package kam.amir.omidpay.repositories

import kam.amir.omidpay.repositories.results.ResultProduct
import kam.amir.omidpay.retrofit.ApiServiceProduct
import kam.amir.omidpay.room.Database
import kam.amir.omidpay.room.bookmark.Bookmark
import kam.amir.omidpay.room.product.Product
import kam.amir.omidpay.room.product.ProductMerged
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val database: Database,
    private val apiServiceProduct: ApiServiceProduct,
) : Repository() {


    override suspend fun getProducts(): ResultProduct {


        val result = apiServiceProduct.getAllProducts()

        if (result.isSuccessful) {
            result.body()?.let { list ->
                database.ProductDao().insertProducts(list)

                val mergedProducts = database.ProductDao().getAllProductsMerged()

                val sortedList = mergedProducts.map { list ->
                    list.sortedBy { it.product.price }
                }

                return ResultProduct.OnSuccess(sortedList)
            }
        } else
            return ResultProduct.OnFail("network Error !")

        return ResultProduct.OnFail("unknown Error !")
    }



    override suspend fun getProductById(product: Product): Flow<Product> {
        return database.ProductDao().getProductById(product.id)
    }

    override suspend fun bookMarkProduct(product: Product) {
        database.bookmarkDao().addBookmark(Bookmark(productId = product.id))
    }

    override suspend fun deleteBookmark(product: Product) {
        database.bookmarkDao().deleteBookmark(productId = product.id)
    }

    override suspend fun getBookmarkedProducts(): Flow<List<ProductMerged>> {
        return database.ProductDao().getBookmarkedProducts()

    }


}