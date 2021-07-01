package com.example.sheintask.data

import com.google.gson.annotations.SerializedName

data class SheinHome(

	@SerializedName("data")
	val data: Data,

	@SerializedName("success")
	val success: Boolean?,

	@SerializedName("message")
	val message: String?
)

data class Data(

	@SerializedName("Sponsors")
	val sponsors: List<SponsorsItem?>?,

	@SerializedName("hot_product_paid_status")
	val hotProductPaidStatus: List<HotProductPaidStatusItem?> ,

	@SerializedName("hot_saller_paid_status")
	val hotSallerPaidStatus: List<HotSallerPaidStatusItem?>?,

	@SerializedName("Sliders")
	val sliders: List<SlidersItem?> ,

	@SerializedName("vendor")
	val vendor: List<VendorItem?>?,

	@SerializedName("recommend_paid_status")
	val recommendPaidStatus: List<RecommendPaidStatusItem?>?
)

data class SponsorsItem(

	@SerializedName("image")
	val image: String?
)

data class RecommendPaidStatusItem(

	@SerializedName("image")
	val image: String? ,

	@SerializedName("ProductUserNumber")
	val productUserNumber: Int? ,

	@SerializedName("rate")
	val rate: Int? ,

	@SerializedName("old_price")
	val oldPrice: Int?,

	@SerializedName("name")
	val name: String?,

	@SerializedName("new_price")
	val newPrice: Int? ,

	@SerializedName("exp_date")
	val expDate: String? ,

	@SerializedName("id")
	val id: Int?
)

data class SlidersItem(

	@SerializedName("image")
	val image: String? ,

	@SerializedName("product")
	val product: Int? ,

	@SerializedName("name")
	val name: String?,

	@SerializedName("id")
	val id: Int?,

	@SerializedName("title")
	val title: String?
)

data class HotSallerPaidStatusItem(

	@SerializedName("image")
	val image: String?,

	@SerializedName("ProductUserNumber")
	val productUserNumber: Int? ,

	@SerializedName("rate")
	val rate: Int?,

	@SerializedName("old_price")
	val oldPrice: Int? ,

	@SerializedName("name")
	val name: String? ,

	@SerializedName("new_price")
	val newPrice: Int? ,

	@SerializedName("exp_date")
	val expDate: String?,

	@SerializedName("id")
	val id: Int?
)

data class VendorItem(

	@SerializedName("image")
	val image: String?,

	@SerializedName("sub_id")
	val subId: String?,

	@SerializedName("name")
	val name: String?,

	@SerializedName("id")
	val id: Int?
)

data class HotProductPaidStatusItem(

	@SerializedName("image")
	val image: String? ,

	@SerializedName("ProductUserNumber")
	val productUserNumber: Int?,

	@SerializedName("rate")
	val rate: Int? ,

	@SerializedName("old_price")
	val oldPrice: Int? ,

	@SerializedName("name")
	val name: String? ,

	@SerializedName("new_price")
	val newPrice: Int? ,

	@SerializedName("exp_date")
	val expDate: String? ,

	@SerializedName("id")
	val id: Int?
)
