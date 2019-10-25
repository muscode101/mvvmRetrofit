package plus.look.up.mvvmretrofitbasics.view

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import plus.look.up.mvvmretrofitbasics.R
import plus.look.up.mvvmretrofitbasics.adapter.NewsAdapter
import plus.look.up.mvvmretrofitbasics.model.NewsArticle
import plus.look.up.mvvmretrofitbasics.model.NewsResponse
import java.util.*


class MainActivity : AppCompatActivity() {

    private var articleArrayList = ArrayList<NewsArticle>()
    private var newsAdapter: NewsAdapter? = null
    private lateinit var newsViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initViewModel()
        initNewsListener()

        setupRecyclerView()
        showProgress()

        iv_progress.setOnClickListener {
            iv_progress.animation.cancel()
        }
    }

    private fun initViewModel(){
        newsViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        newsViewModel.init()
    }

    private fun initNewsListener(){
        newsViewModel.getNewsRepository()!!.observe(this, Observer<NewsResponse> {
            it?.let {
                val newsArticles = it.articles
                articleArrayList.addAll(newsArticles!!)
                newsAdapter!!.notifyDataSetChanged()
            }
        })
    }

    private fun showProgress(){
        iv_progress.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.rotate_indefinitely) )
    }

    private fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = NewsAdapter(this@MainActivity, articleArrayList)
            rvNews.layoutManager = LinearLayoutManager(this)
            rvNews.adapter = newsAdapter
            rvNews.itemAnimator = DefaultItemAnimator()
            rvNews.isNestedScrollingEnabled = true
        } else {
            newsAdapter!!.notifyDataSetChanged()
        }
    }
}