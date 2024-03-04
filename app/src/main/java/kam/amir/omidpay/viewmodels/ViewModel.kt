package kam.amir.omidpay.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kam.amir.omidpay.repositories.Repository
import kam.amir.omidpay.repositories.results.ResultProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {


    private var _state = MutableStateFlow(ViewModelState())

    val state: StateFlow<ViewModelState> get() = _state


    init {

        viewModelScope.launch {
            retrieveProducts()
        }

        viewModelScope.launch {
            retrieveBookmarkedProducts()
        }
    }

    fun onEvent(event: ViewModelEvent) {
        when (event) {
            is ViewModelEvent.bookMarkProduct -> {
                viewModelScope.launch {
                    if (event.product.isBookmarked)
                        repository.deleteBookmark(event.product.product)
                    else
                        repository.bookMarkProduct(event.product.product)
                }
            }

            is ViewModelEvent.clickProduct -> {

                _state.update {
                    it.copy(
                        selectedProductId = event.product.product.id,
                        selectedProduct = event.product
                    )
                }
            }

            is ViewModelEvent.backPressed -> {
                _state.update {
                    it.copy(
                        selectedProductId = -1
                    )
                }
            }
        }
    }

    private suspend fun retrieveProducts(){
        val productsResult = repository.getProducts()

        when (productsResult) {
            is ResultProduct.OnFail -> Log.e("tessst", productsResult.message)
            is ResultProduct.OnSuccess -> {
                productsResult.products.collect { list ->
                    _state.update {
                        it.copy(
                            products = list
                        )
                    }
                }
            }
        }
    }

    private suspend fun retrieveBookmarkedProducts(){
        val productsResult = repository.getBookmarkedProducts()
        productsResult.collect{list->
            _state.update {
                it.copy(
                    bookMarkedProducts = list
                )
            }
        }
    }
}