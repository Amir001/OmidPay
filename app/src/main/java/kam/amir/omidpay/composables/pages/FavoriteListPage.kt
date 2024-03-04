package kam.amir.omidpay.composables.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kam.amir.omidpay.composables.basic_composables.ActionBar
import kam.amir.omidpay.composables.basic_composables.ProductList
import kam.amir.omidpay.composables.test_data.FakeData
import kam.amir.omidpay.room.product.ProductMerged

@Composable
fun FavoriteListPage(
    modifier: Modifier = Modifier,
    products: List<ProductMerged>,
    onProductClicked: (product: ProductMerged) -> Unit,
    onBookMarkClicked: (product: ProductMerged) -> Unit
) {

    ActionBar(
        modifier = modifier,
        title = "Bookmarked Items",
        noIcon = true,
        onIconClicked = {}) {
        ProductList(
            products = products,
            onProductClicked = onProductClicked,
            onBookMarkClicked = onBookMarkClicked
        )

    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun FavoriteListPagePreview() {
    FavoriteListPage(
        products = FakeData.productMergeds,
        onProductClicked = {},
        onBookMarkClicked = {}
    )
}