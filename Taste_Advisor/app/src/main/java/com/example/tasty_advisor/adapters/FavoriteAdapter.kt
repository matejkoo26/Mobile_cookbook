package com.example.tasty_advisor.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tasty_advisor.data.database.FavoritesEntity
import com.example.tasty_advisor.databinding.FavoriteRecipesLayoutBinding
import com.example.tasty_advisor.ui.fragments.favorite.FavoriteFragmentDirections
import com.example.tasty_advisor.util.RecipesDiffUtil
import kotlinx.android.synthetic.main.favorite_recipes_layout.view.*

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

   private var favoriteRecipe = emptyList<FavoritesEntity>()

    class MyViewHolder(private val binding: FavoriteRecipesLayoutBinding):
            RecyclerView.ViewHolder(binding.root) {

                fun  bind(favoritesEntity: FavoritesEntity) {
                    binding.favoriteEntity = favoritesEntity
                    binding.executePendingBindings()
                }
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavoriteRecipesLayoutBinding.inflate(layoutInflater, parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedRecipe = favoriteRecipe[position]
        holder.bind(selectedRecipe)

        holder.itemView.favoriteRecipesLayout.setOnClickListener {
            val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailsActivity(selectedRecipe.result)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return favoriteRecipe.size
    }

    fun setData(newFavoriteRecipes: List<FavoritesEntity> ) {
        val favoriteRecipesDiffUtil = RecipesDiffUtil(favoriteRecipe, newFavoriteRecipes)
        val diffUtilResult = DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoriteRecipe = newFavoriteRecipes
        diffUtilResult.dispatchUpdatesTo(this)
    }
}