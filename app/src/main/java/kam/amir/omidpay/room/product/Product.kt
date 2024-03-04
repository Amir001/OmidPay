package kam.amir.omidpay.room.product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val title : String,
    val price : Double,
    val description : String,
    val category : String,
    val image : String
)
