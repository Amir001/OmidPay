package kam.amir.omidpay.room.bookmark

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmark")
    fun getBookmarks():Flow<List<Bookmark>>

    @Insert
    suspend fun addBookmark(bookmark: Bookmark)

    @Query("DELETE FROM Bookmark WHERE productId = :productId")
    suspend fun deleteBookmark(productId: Int)

}