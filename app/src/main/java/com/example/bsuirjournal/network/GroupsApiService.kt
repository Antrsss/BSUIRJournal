package com.example.marsphotos.network

import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

    private const val BASE_URL =
        "https://iis.bsuir.by/api/v1/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    interface GroupsApiService {
        @GET("student-groups")
        suspend fun getGroups(): String
    }

    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     */
    object GroupsApi {
        val retrofitService: GroupsApiService by lazy {
            retrofit.create(GroupsApiService::class.java)
        }
}
