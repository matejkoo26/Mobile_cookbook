package com.example.tasty_advisor.viewmodels

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasty_advisor.data.DataStoreRepository
import com.example.tasty_advisor.util.Constants.Companion.API_KEY
import com.example.tasty_advisor.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.tasty_advisor.util.Constants.Companion.DEFAULT_RECIPES_NUMBER
import com.example.tasty_advisor.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.example.tasty_advisor.util.Constants.Companion.QUERY_API_KEY
import com.example.tasty_advisor.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import com.example.tasty_advisor.util.Constants.Companion.QUERY_NUMBER
import com.example.tasty_advisor.util.Constants.Companion.QUERY_TYPE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipesViewModel @ViewModelInject constructor(
    application :Application,
    private val dataStoreRepository: DataStoreRepository
    ) : AndroidViewModel(application) {

    private var mealType = DEFAULT_MEAL_TYPE

    val readMealType = dataStoreRepository.readMealType

    fun saveMealType(mealType: String, mealTypeId: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveMealType(mealType, mealTypeId)
        }
    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        viewModelScope.launch {
            readMealType.collect { value ->
                mealType = value.selectedMealType
            }
        }
        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = mealType
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }
}