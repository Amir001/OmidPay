package kam.amir.omidpay.room.product

import androidx.room.Embedded
import kam.amir.omidpay.room.bookmark.Bookmark

data class ProductMerged(
    @Embedded
    val product: Product,

    val isBookmarked: Boolean = false,
)
