package plus.look.up.mvvmretrofitbasics.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import plus.look.up.mvvmretrofitbasics.model.NewsResponse
import plus.look.up.mvvmretrofitbasics.network.NewsRepository


class ViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<NewsResponse>? = null
    private var newsRepository: NewsRepository? = null

    fun init() {
        if (mutableLiveData == null) {
            newsRepository = NewsRepository.instance
            mutableLiveData = newsRepository!!.getNews("google-news", "0618ac8b029244489d819b14c2ebea14")
        }
    }

    fun getNewsRepository(): LiveData<NewsResponse>? {
        return mutableLiveData
    }

}