package plus.look.up.mvvmretrofitbasics.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import plus.look.up.mvvmretrofitbasics.R
import plus.look.up.mvvmretrofitbasics.model.NewsArticle
import java.util.*

class NewsAdapter(private var context: Context, private var articles: ArrayList<NewsArticle>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.tvName.text = articles[position].title.toString()
        holder.tvDescription.text = articles[position].toString()
        Picasso.get().load(articles[position].urlToImage).into(holder.ivNews)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDesCription)
        var ivNews: ImageView = itemView.findViewById(R.id.ivNews)
    }
}
