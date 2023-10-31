package com.example.tasty_advisor.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tasty_advisor.models.Result
import com.example.tasty_advisor.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var result: Result
) {
}