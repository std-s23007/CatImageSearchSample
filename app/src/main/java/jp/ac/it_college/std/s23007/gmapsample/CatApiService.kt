package jp.ac.it_college.std.s23007.gmapsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApiService {
    @Headers("x-api-key: live_8AO5oPbgUjQqdw8zWMHl6cNQJ1oNJICGqm8g3vV6PiyO19vhvEDVEuQlvjcZCf5G")
    @GET("v1/images/search")
    fun getRandomCatImage(): Call<List<CatImage>>
}

data class CatImage(val url: String)
