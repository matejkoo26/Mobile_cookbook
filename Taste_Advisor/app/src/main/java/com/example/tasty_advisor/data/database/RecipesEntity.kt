package com.example.tasty_advisor.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tasty_advisor.models.FoodRecipe
import com.example.tasty_advisor.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity (
        var foodRecipe : FoodRecipe
        ) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}