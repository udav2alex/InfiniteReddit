package ru.gressor.infinitereddit.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.gressor.infinitereddit.api.ApiService
import ru.gressor.infinitereddit.entities.RedditRecord
import ru.gressor.infinitereddit.mappings.toRedditRecord

class RecordPagingSource(
    private val apiService: ApiService
) : PagingSource<String, RedditRecord>() {
    private val keysCache = mutableListOf<String>()
    private val currentPageNumber = 0

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditRecord> =
        try {
            val currentPageId = params.key ?: ""

            val response = if (currentPageId == "") {
                apiService.getResponse()
            } else {
                apiService.getPagedResponse(currentPageId)
            }

            LoadResult.Page(
                data = response.data.children
                    .map { it.toRedditRecord() },
                prevKey = null,
                nextKey = response.data.after
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<String, RedditRecord>): String? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.

        state.anchorPosition?.let { anchorPosition ->
            val anchorPage: LoadResult.Page<String, RedditRecord>? =
                state.closestPageToPosition(anchorPosition)
        } ?: ""

        return ""

//            .anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }
}
}