package kam.amir.omidpay.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kam.amir.omidpay.room.bookmark.Bookmark
import kam.amir.omidpay.room.bookmark.BookmarkDao
import kam.amir.omidpay.room.product.Product
import kam.amir.omidpay.room.product.ProductDao


@Database(
    entities = [Bookmark::class, Product::class],
    version = 3,
    exportSchema = false
)

abstract class Database : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao
    abstract fun ProductDao(): ProductDao
}