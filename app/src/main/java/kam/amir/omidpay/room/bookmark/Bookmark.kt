package kam.amir.omidpay.room.bookmark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val productId: Int
)