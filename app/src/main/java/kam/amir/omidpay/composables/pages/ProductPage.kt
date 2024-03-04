package kam.amir.omidpay.composables.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kam.amir.omidpay.R
import kam.amir.omidpay.composables.basic_composables.ActionBar
import kam.amir.omidpay.composables.test_data.FakeData
import kam.amir.omidpay.room.product.ProductMerged
import kam.amir.omidpay.ui.theme.PriceColor

@Composable
fun ProductPage(
    modifier: Modifier = Modifier,
    product: ProductMerged,
    onBackClicked: () -> Unit,
) {

    ActionBar(
        modifier = modifier,
        title = "Product Page",
        onIconClicked = { onBackClicked() }
    ) {

        Box {
            Column(
                Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                AsyncImage(
                    model = product.product.image,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    contentDescription = "product pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(300.dp)
                )

                Text(
                    text = product.product.title,
                    maxLines = 1,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Text(
                    text = "in ${product.product.category}",
                    modifier = Modifier.padding(bottom = 32.dp)
                )


                Text(text = product.product.description)


                Spacer(modifier = Modifier.height(100.dp))

            }


            Column {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${product.product.price} $",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(PriceColor)
                        .padding(8.dp),
                    textAlign = TextAlign.Center

                )
            }
        }
    }

}

@Preview
@Composable
fun ProductPagePreview() {
    ProductPage(onBackClicked = {}, product = FakeData.productMerged)
}