package kam.amir.omidpay.composables

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kam.amir.omidpay.composables.pages.ProductPage
import kam.amir.omidpay.viewmodels.ViewModelEvent
import kam.amir.omidpay.viewmodels.ViewModelState
import kam.amir.todo.composables.bottomNavigation.BottomNav
import kam.amir.todo.composables.bottomNavigation.BottomNavGraph

@Composable
fun ControllerScreen(
    state: ViewModelState,
    onEvent: (ViewModelEvent) -> Unit
) {

    val navController = rememberNavController()

    if (state.selectedProductId == -1)

        Scaffold(
            bottomBar = {
                BottomNav(navController = navController)
            }
        ) { padding ->
            BottomNavGraph(
                navControl = navController,
                modifier = Modifier.padding(padding),
                products = state.products,
                bookmarkedProducts = state.bookMarkedProducts,
                onProductClicked = {
                    onEvent(ViewModelEvent.clickProduct(it))
                },
                onBookMarkClicked = {
                    onEvent(ViewModelEvent.bookMarkProduct(it))
                }
            )
        }
    else {
        BackHandler { onEvent(ViewModelEvent.backPressed()) }
        ProductPage(
            product = state.selectedProduct,
            onBackClicked = { onEvent(ViewModelEvent.backPressed()) }
        )
    }
}

