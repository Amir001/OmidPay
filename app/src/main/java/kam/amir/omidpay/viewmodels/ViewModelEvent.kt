package kam.amir.omidpay.viewmodels

import kam.amir.omidpay.room.product.ProductMerged

sealed interface ViewModelEvent {

    data class clickProduct(val product: ProductMerged) : ViewModelEvent
    data class bookMarkProduct(val product: ProductMerged) : ViewModelEvent
    class backPressed : ViewModelEvent

}