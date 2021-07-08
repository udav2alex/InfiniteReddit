package ru.gressor.infinitereddit.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.gressor.infinitereddit.api.ApiService
import ru.gressor.infinitereddit.entities.RedditRecord
import ru.gressor.infinitereddit.mappings.toRedditRecord

class RecordPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, RedditRecord>() {
    // nextKey "after" for page
    private val keysCache = mutableListOf<String>()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RedditRecord> =
        try {
            val currentPageNumber = params.key ?: 0

            val response = if (currentPageNumber == 0) {
                apiService.getResponse()
            } else {
                apiService.getPagedResponse(keysCache[currentPageNumber - 1])
            }

            if (currentPageNumber > keysCache.size - 1) {
                keysCache.add(response.data.after)
            }

            LoadResult.Page(
                data = response.data.children.map { it.toRedditRecord() },
                prevKey = if (currentPageNumber == 0) { null } else { currentPageNumber - 1 },
                nextKey = currentPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, RedditRecord>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage: LoadResult.Page<Int, RedditRecord>? =
                state.closestPageToPosition(anchorPosition)

            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}