package com.example.submission2kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.submission2kotlin.R
import com.example.submission2kotlin.contract.DetailSearchContract
import com.example.submission2kotlin.model.Event
import com.example.submission2kotlin.model.SearchEvent
import com.example.submission2kotlin.model.Team
import com.example.submission2kotlin.presenter.DetailSearchPresenter
import kotlinx.android.synthetic.main.activity_detail_event.*

class DetailSearchActivity : AppCompatActivity(), DetailSearchContract.View {

    private lateinit var mPresenter: DetailSearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search)
        mPresenter = DetailSearchPresenter(this)
        val event: SearchEvent? = intent.getParcelableExtra("detail_search")
        mPresenter.getDetailSearch(event!!.idEvent!!)
        mPresenter.getDetailTeamHome(event.idHomeTeam!!)
        mPresenter.getDetailTeamAway(event.idAwayTeam!!)
    }

    override fun setDetailSearch(listEvent: List<Event>) {
        supportActionBar?.title = listEvent[0].strEvent
        dateScheduleTv.text = listEvent[0].dateEvent
        awayNameTv.text = listEvent[0].strAwayTeam
        homeNameTv.text = listEvent[0].strHomeTeam
        homeScoreTv.text = listEvent[0].intHomeScore
        awayScoreTv.text = listEvent[0].intAwayScore
        homeScorerTv.text = listEvent[0].strHomeGoalDetails
        awayScorerTv.text = listEvent[0].strAwayGoalDetails
        gkHomeTv.text = listEvent[0].strHomeLineupGoalkeeper
        gkAwayTv.text = listEvent[0].strAwayLineupGoalkeeper
        defHomeTv.text = listEvent[0].strHomeLineupDefense
        defAwayTv.text = listEvent[0].strAwayLineupDefense
        midHomeTv.text = listEvent[0].strHomeLineupMidfield
        midAwayTv.text = listEvent[0].strAwayLineupMidfield
        forHomeTv.text = listEvent[0].strHomeLineupForward
        forAwayTv.text = listEvent[0].strAwayLineupForward
        subHomeTv.text = listEvent[0].strHomeLineupSubstitutes
        subAwayTv.text = listEvent[0].strAwayLineupSubstitutes
    }

    override fun setDetailTeamHome(listTeam: List<Team>) {
        Glide.with(this).load(listTeam[0].strTeamBadge).into(homeImg)
    }

    override fun setDetailTeamAway(listTeam: List<Team>) {
        Glide.with(this).load(listTeam[0].strTeamBadge).into(awayImg)
    }
}
