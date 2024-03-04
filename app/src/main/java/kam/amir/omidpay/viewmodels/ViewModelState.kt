package kam.amir.omidpay.viewmodels

import kam.amir.omidpay.composables.test_data.FakeData
import kam.amir.omidpay.room.product.ProductMerged

data class ViewModelState(
    val products: List<ProductMerged> = emptyList(),
    val bookMarkedProducts : List<ProductMerged> = emptyList(),
    val selectedProductId: Int = -1,
    val selectedProduct: ProductMerged = FakeData.productMerged
)