package kam.amir.omidpay.repositories.results

import kam.amir.omidpay.room.product.ProductMerged
import kotlinx.coroutines.flow.Flow

sealed class ResultProduct {

    data class OnSuccess(val products: Flow<List<ProductMerged>>) : ResultProduct()
    data class OnFail(val message: String) : ResultProduct()

}