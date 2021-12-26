package dougles.project.mockassignment_ii.api

import dougles.project.mockassignment_ii.model.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    suspend fun getSongs(@Query("term") term: String): ResponseDTO
}