package plus.look.up.mvvmretrofitbasics.wrapper

import androidx.lifecycle.MutableLiveData
import plus.look.up.mvvmretrofitbasics.model.NewsApi
import plus.look.up.mvvmretrofitbasics.model.NewsResponse
import plus.look.up.mvvmretrofitbasics.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HttpClientWrapper {

    private val dataApi: NewsApi = RetrofitService.createService(NewsApi::class.java)

    fun fetchData(source: String, key: String): MutableLiveData<NewsResponse> {
        val responseData = MutableLiveData<NewsResponse>()
        dataApi.getNewsList(source, key).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                if (response.isSuccessful) {
                    responseData.value = response.body()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                responseData.value = null
            }
        })
        return responseData
    }

    companion object {

        private var httpClientWrapper: HttpClientWrapper? = null

        val instance: HttpClientWrapper
            get() {
                if (httpClientWrapper == null) {
                    httpClientWrapper = HttpClientWrapper()
                }
                return httpClientWrapper as HttpClientWrapper
            }
    }
}