package com.example.submission2kotlin.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.example.submission2kotlin.R
import com.example.submission2kotlin.adapter.TabFragmentAdapter
import com.example.submission2kotlin.contract.DetailLeagueContract
import com.example.submission2kotlin.gone
import com.example.submission2kotlin.model.Item
import com.example.submission2kotlin.model.League
import com.example.submission2kotlin.presenter.DetailLeaguePresenter
import kotlinx.android.synthetic.main.activity_detail_league.*


class DetailLeagueActivity : AppCompatActivity(), DetailLeagueContract.View {

    private lateinit var mPresenter: DetailLeaguePresenter
    private var myIdLeague: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        mPresenter = DetailLeaguePresenter(this)
        val intentLeague: Item? = intent.getParcelableExtra("detail")
        myIdLeague = intentLeague!!.id!!.toString()
        Glide.with(this).load(intentLeague.image).into(posterLeague)
        mPresenter.getDetailLeague(myIdLeague!!)
        setSliderFragment()
    }

    override fun setDetailLeague(listLeague: List<League>) {
        supportActionBar!!.title = listLeague[0].strLeague
        txtLeagueName.text = listLeague[0].strLeague
        txtLeagueDescriptionEN.text = listLeague[0].strDescriptionEN
        ftvFacebook.setOnClickListener { openInBrowser(listLeague[0].strFacebook) }
        ftvTwitter.setOnClickListener { openInBrowser(listLeague[0].strTwitter) }
        ftvWebsite.setOnClickListener { openInBrowser(listLeague[0].strWebsite) }
        ftvYoutube.setOnClickListener { openInBrowser(listLeague[0].strYoutube) }
        progressBar.gone()
    }


    private fun setSliderFragment() {
        val sectionsPagerAdapter: FragmentPagerAdapter =
            TabFragmentAdapter(this, supportFragmentManager, myIdLeague.toString())
        view_pager.adapter = sectionsPagerAdapter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) tab_layout.setTabTextColors(
            R.color.colorPrimaryDark, getColor(
                R.color.colorWhite
            )
        )
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun openInBrowser(myURL: String?) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://$myURL")))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu!!.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.query_hint)
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(this@DetailLeagueActivity, SearchEventActivity::class.java)
                intent.putExtra("query_event", query)
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean = false
        })
        return true
    }
}


//    private fun getDetailLeague(id: Int) {
//        val call: Call<ResponseBody?>? = userService.responseDetailLeague(id)
//        call!!.enqueue(object : Callback<ResponseBody?> {
//            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
//                try {
//                    if (response.isSuccessful) {
//                        if (response.body() != null) {
//                            val jsonObject = JSONObject(response.body()!!.string())
//                            val status = jsonObject.toString()
//                            try {
//                                val statusObject = JSONObject(status)
//                                val data = statusObject.getJSONArray("leagues")
//                                for (i in 0 until data.length()) {
//                                    val dataObject = data.getJSONObject(i)
//                                    idLeague = dataObject.getString("idLeague")
//                                    strLeague = dataObject.getString("strLeague")
//                                    strCountry = dataObject.getString("strCountry")
//                                    strWebsite = dataObject.getString("strWebsite")
//                                    strFacebook = dataObject.getString("strFacebook")
//                                    strTwitter = dataObject.getString("strTwitter")
//                                    strYoutube = dataObject.getString("strYoutube")
//                                    strDescriptionEN = dataObject.getString("strDescriptionEN")
//                                }
//                                supportActionBar!!.title = strLeague
//                                txtLeagueName.text = strLeague
//                                txtLeagueDescriptionEN.text = strDescriptionEN
//                                ftvFacebook.setOnClickListener { openInBrowser(strFacebook) }
//                                ftvTwitter.setOnClickListener { openInBrowser(strTwitter) }
//                                ftvWebsite.setOnClickListener { openInBrowser(strWebsite) }
//                                ftvYoutube.setOnClickListener { openInBrowser(strYoutube) }
//                                progressBar.gone()
//                            } catch (e: JSONException) {
//                                e.printStackTrace()
//                                Log.e("JSONEX 2", e.toString())
//                            }
//                        }
//                    }
//                } catch (Ne: JSONException) {
//                    Ne.printStackTrace()
//                    Log.e("JSONEX", Ne.toString())
//                } catch (Oe: IOException) {
//                    Oe.printStackTrace()
//                    Log.e("IONEX", Oe.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
//                Log.e("onFailure", t.toString())
//            }
//        })
//    }