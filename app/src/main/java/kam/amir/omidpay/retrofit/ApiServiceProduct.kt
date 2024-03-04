package kam.amir.omidpay.retrofit

import kam.amir.omidpay.room.product.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServiceProduct {

    @GET("/products")
    suspend fun getAllProducts(): Response<List<Product>>

    @GET("/products/category/{id}")
    suspend fun getProductById(
        @Path("id") productId: Int
    ): Response<Product>
}