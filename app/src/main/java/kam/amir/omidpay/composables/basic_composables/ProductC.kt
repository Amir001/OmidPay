package kam.amir.omidpay.composables.basic_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kam.amir.omidpay.R
import kam.amir.omidpay.composables.test_data.FakeData
import kam.amir.omidpay.room.product.ProductMerged
import kam.amir.omidpay.ui.theme.PriceColor
import kam.amir.omidpay.ui.theme.TransparentWhite

@Composable
fun ProductC(
    modifier: Modifier = Modifier,
    product: ProductMerged,
    onProductClicked: (product: ProductMerged) -> Unit,
    onBookMarkClicked: (product: ProductMerged) -> Unit

) {

    Card(
        modifier = modifier
            .wrapContentSize()
            .clickable { onProductClicked(product) }
    ) {

        Box {

            Column {

                AsyncImage(
                    model = product.product.image,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    contentDescription = "product pic",
                    modifier = Modifier.size(180.dp),
                    contentScale = ContentScale.Crop
                )

                Column(Modifier.padding(16.dp)) {
                    //todo create a text composable to make it go ...
                    Text(
                        text = product.product.title,
                        maxLines = 1,
                        fontSize = 24.sp,
                        modifier = Modifier.width(118.dp)
                    )
                    Text(
                        text = "in ${product.product.category}",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(text = "${product.product.price} $", color = PriceColor)
                }


            }

            Box(
                Modifier
                    .background(color = TransparentWhite)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = if (product.isBookmarked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    Modifier.clickable { onBookMarkClicked(product) }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ProductPreview() {
    MaterialTheme {
        ProductC(product = FakeData.productMerged, onProductClicked = {}, onBookMarkClicked = {})
    }
}