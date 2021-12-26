package dougles.project.mockassignment_ii.model

import com.google.gson.annotations.SerializedName

data class ResponseDTO(

    @field:SerializedName("resultCount")
    val resultCount: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultsDTO?>? = null
)