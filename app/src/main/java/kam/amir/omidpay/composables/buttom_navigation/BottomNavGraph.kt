package kam.amir.todo.composables.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kam.amir.omidpay.composables.pages.FavoriteListPage
import kam.amir.omidpay.composables.pages.ProductListPage
import kam.amir.omidpay.room.product.ProductMerged


@Composable
fun BottomNavGraph(
    navControl: NavHostController,
    modifier: Modifier = Modifier,
    products: List<ProductMerged>,
    bookmarkedProducts : List<ProductMerged>,
    onProductClicked: (product: ProductMerged) -> Unit,
    onBookMarkClicked: (product: ProductMerged) -> Unit,
) {
    NavHost(
        navController = navControl,
        startDestination = BottomNavItems.Products.route
    ) {
        composable(BottomNavItems.Products.route) {
            ProductListPage(
                modifier = modifier,
                products = products,
                onProductClicked = onProductClicked,
                onBookMarkClicked = onBookMarkClicked,
            )
        }
        composable(BottomNavItems.Bookmarks.route) {
            FavoriteListPage(
                modifier = modifier,
                onBookMarkClicked = onBookMarkClicked,
                onProductClicked = onProductClicked,
                products = bookmarkedProducts
            )
        }
    }
}