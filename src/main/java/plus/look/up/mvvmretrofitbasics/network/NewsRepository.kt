package plus.look.up.mvvmretrofitbasics.network


import androidx.lifecycle.MutableLiveData
import plus.look.up.mvvmretrofitbasics.model.NewsResponse
import plus.look.up.mvvmretrofitbasics.wrapper.HttpClientWrapper

class NewsRepository {

    fun getNews(source: String, key: String): MutableLiveData<NewsResponse> =
        HttpClientWrapper.instance.fetchData(source, key)

    companion object {
        private var newsRepository: NewsRepository? = null
        val instance: NewsRepository
            get() {
                if (newsRepository == null) {
                    newsRepository = NewsRepository()
                }
                return newsRepository as NewsRepository
            }
    }
}