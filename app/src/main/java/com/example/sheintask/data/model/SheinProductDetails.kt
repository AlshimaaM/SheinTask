package com.example.sheintask.data

import com.google.gson.annotations.SerializedName

data class SheinProductDetails(

	@SerializedName("data")
	val data: DataProduct,

	@SerializedName("success")
	val success: Boolean? ,

	@SerializedName("message")
	val message: String?
)

data class Products(

	@SerializedName("image")
	val image: String?,

	@SerializedName("ProductUserNumber")
	val productUserNumber: Int? ,

	@SerializedName("address")
	val address: String? ,

	@SerializedName("lng")
	val lng: String? ,

	@SerializedName("old_price")
	val oldPrice: Int? ,

	@SerializedName("mobile")
	val mobile: String?,

	@SerializedName("description")
	val description: String? ,

	@SerializedName("new_price")
	val newPrice: Int? ,

	@SerializedName("Gallary")
	val gallary: List<GallaryItem?> ,

	@SerializedName("rate")
	val rate: Int?,

	@SerializedName("vendor")
	val vendor: String? ,

	@SerializedName("review")
	val review: List<ReviewItem?> ,

	@SerializedName("name")
	val name: String? ,

	@SerializedName("exp_date")
	val expDate: String?,

	@SerializedName("id")
	val id: Int ,

	@SerializedName("lat")
	val lat: String? ,

	@SerializedName("email")
	val email: String?
)

data class DataProduct(

	@SerializedName("Products")
	val products: Products
)

data class GallaryItem(

	@SerializedName("images")
	val images: String?,

	@SerializedName("id")
	val id: Int?
)

data class ReviewItem(

	@SerializedName("rate")
	val rate: String? ,

	@SerializedName("comment")
	val comment: String
)
