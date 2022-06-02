package co.tiagoaguiar.course.instagram.profile.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R



 class  PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_profile_grid, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(R.drawable.ic_insta_add)
    }

    override fun getItemCount(): Int {
        return 30
    }

      class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(image: Int){
            itemView.findViewById<ImageView>(R.id.item_profile_img_grid).setImageResource(image)
        }
    }
}