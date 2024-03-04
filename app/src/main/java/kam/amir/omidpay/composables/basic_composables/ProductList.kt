package kam.amir.omidpay.composables.basic_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kam.amir.omidpay.composables.test_data.FakeData
import kam.amir.omidpay.room.product.Product
import kam.amir.omidpay.room.product.ProductMerged

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    products: List<ProductMerged>,
    onProductClicked: (product: ProductMerged) -> Unit,
    onBookMarkClicked: (product: ProductMerged) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(products) {
            ProductC(
                product = it,
                onProductClicked = onProductClicked,
                onBookMarkClicked = onBookMarkClicked
            )
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ProductListPreview() {
    MaterialTheme {
        ProductList(onProductClicked = {}, onBookMarkClicked = {}, products = FakeData.productMergeds)
    }
}