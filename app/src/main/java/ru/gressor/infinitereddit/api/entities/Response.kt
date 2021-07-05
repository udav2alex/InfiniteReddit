package ru.gressor.infinitereddit.api.entities

import com.google.gson.annotations.SerializedName

data class Response(
	@field:SerializedName("data")
	val data: ResponseContent
)

data class ResponseContent(
	@field:SerializedName("children")
	val children: List<Child>
)

data class Child(
	@field:SerializedName("data")
	val data: Data
)

data class Data(
	@field:SerializedName("total_awards_received")
	val totalAwardsReceived: Int? = null,

	@field:SerializedName("num_comments")
	val numComments: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)