package plus.look.up.mvvmretrofitbasics.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsArticle {

    @SerializedName("source")
    @Expose
    var source: NewsSource? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = null
    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null
    @SerializedName("content")
    @Expose
    var content: String? = null
}
