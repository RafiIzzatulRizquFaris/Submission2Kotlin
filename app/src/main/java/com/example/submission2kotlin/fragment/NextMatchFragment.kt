package com.example.submission2kotlin.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2kotlin.R
import com.example.submission2kotlin.activity.DetailEventActivity
import com.example.submission2kotlin.adapter.AdapterNextEvent
import com.example.submission2kotlin.contract.NextMatchContract
import com.example.submission2kotlin.gone
import com.example.submission2kotlin.model.Event
import com.example.submission2kotlin.presenter.NextMatchPresenter
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment(), NextMatchContract.View {

    private lateinit var mPresenter: NextMatchPresenter
    private var matchLists: MutableList<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter = NextMatchPresenter(this)
        val strtext = arguments!!.getString("idleagues")
        Log.e("NextMatchFragment", strtext!!)
        rv_next_match.layoutManager = LinearLayoutManager(context)
        rv_next_match.setHasFixedSize(true)
        rv_next_match.adapter = AdapterNextEvent(context!!, matchLists) {
            startActivity<DetailEventActivity>("detail_event" to it)
        }
        mPresenter.getNextMatch(strtext)
    }

    override fun setNextMatch(matchList: List<Event>) {
        if (matchList.isNotEmpty()) {
            matchLists.clear()
            matchLists.addAll(matchList)
            rv_next_match.adapter!!.notifyDataSetChanged()
            pg_next_match.gone()
        } else Toast.makeText(context, "List is Empty", Toast.LENGTH_LONG).show()
    }
}
