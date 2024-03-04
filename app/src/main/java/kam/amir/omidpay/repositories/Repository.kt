package kam.amir.omidpay.repositories

import kam.amir.omidpay.repositories.results.ResultProduct
import kam.amir.omidpay.room.product.Product
import kam.amir.omidpay.room.product.ProductMerged
import kotlinx.coroutines.flow.Flow

abstract class Repository {

    abstract suspend fun getProducts(): ResultProduct

    abstract suspend fun getProductById(product: Product): Flow<Product>

    abstract suspend fun bookMarkProduct(product: Product)

    abstract suspend fun deleteBookmark(product: Product)

    abstract suspend fun getBookmarkedProducts(): Flow<List<ProductMerged>>

}