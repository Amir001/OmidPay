package kam.amir.omidpay.room.product

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Upsert
    suspend fun insertProducts(products : List<Product>)

    @Query("SELECT * FROM Product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE id = :id")
    fun getProductById(id: Int): Flow<Product>

    @Query("SELECT Product.id, title, price, description, category, image, Bookmark.id IS NOT NULL AS isBookmarked FROM Product LEFT JOIN Bookmark ON Product.id = Bookmark.productId")
    fun getAllProductsMerged(): Flow<List<ProductMerged>>

    @Query("SELECT Product.id, title, price, description, category, image, Bookmark.id IS NOT NULL AS isBookmarked FROM Product LEFT JOIN Bookmark ON Product.id = Bookmark.productId WHERE Bookmark.id IS NOT NULL")
    fun getBookmarkedProducts(): Flow<List<ProductMerged>>

}