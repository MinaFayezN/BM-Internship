package dev.mina.internship

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ContactsAPI {

    @GET("36ccb13f-1f33-4d62-b79d-b8493344c450")
    suspend fun getContacts(): Contacts

    @GET("36ccb13f-1f33-4d62-b79d-b8493344c450")
    suspend fun getConversionForList(@Query("base") base:String,@Query("list")list:String,): Contacts

    /*https://mocki.io/v1/9a54a7b3-497b-41f3-b13f-23964afd4bd6?userId={id}&age={age}*/
    @GET("9a54a7b3-497b-41f3-b13f-23964afd4bd6")
    suspend fun getContact(
        @Query("userID") id: Int,
        @Query("age") age: Int,
        @QueryMap map: Map<String, String>,
    ): Contacts

    /*https://mocki.io/v1/9a54a7b3-497b-41f3-b13f-23964afd4bd6/{username} -> https://mocki.io/v1/9a54a7b3-497b-41f3-b13f-23964afd4bd6/5 */
    @GET("9a54a7b3-497b-41f3-b13f-23964afd4bd6/{id}")
    suspend fun getContactDetails(
        @Path("id") id:Int,
    ): Contact
}