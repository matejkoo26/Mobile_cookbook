package com.example.tasty_advisor.util

class Constants {
    companion object {
        const val BASE_URL = "https://api.spoonacular.com"
        const val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"
        const val API_KEY = "d350f9e0731c4cba94069cb50271766c"

        const val RECIPE_RESULT_KEY = "recipeBundle"
        // API Query Keys
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        //ROOM Database
        const val FAVORITE_RECIPES_TABLE = "favorite_recipes_table"
        const val DATABASE_NAME = "recipes_database"
        const val RECIPES_TABLE = "recipes_table"

        //Bottom Sheet and Preferences
        const val DEFAULT_RECIPES_NUMBER = "30"
        const val DEFAULT_MEAL_TYPE = "main course"

        const val PREFERENCES_NAME = "tasty_advisor_preferences"
        const val PREFERENCES_MEAL_TYPE = "mealType"
        const val PREFERENCES_MEAL_TYPE_ID ="mealTypeId"


    }
}