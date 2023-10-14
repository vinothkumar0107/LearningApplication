package com.example.audio.mvvm_api_call

import com.google.gson.annotations.SerializedName

data class ResponseModelClass(

	@field:SerializedName("test_deatils")
	val testDeatils: List<TestDeatilsItem?>? = null,

	@field:SerializedName("contact_details")
	val contactDetails: ContactDetails? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class ContactDetails(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("contact_no")
	val contactNo: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("designation")
	val designation: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)

data class TestDeatilsItem(

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: Int? = null
)
