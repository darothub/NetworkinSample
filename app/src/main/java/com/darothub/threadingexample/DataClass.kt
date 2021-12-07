package com.darothub.threadingexample

import com.google.gson.annotations.SerializedName

data class DataClass(
    var page: Int,
    @SerializedName("per_page")
    var perPage: Int,
    var total: Int,
    @SerializedName("total_pages")
    var totalPages: Int,
    var data: List<DataObject>,
    //
///
///
///
///
///
//
)

data class DataObject(
    var id: Int,
    var name: String,
    var year: Int,
    var color: String,
    @SerializedName("pantone_value")
    var pantoneValue: String
)

