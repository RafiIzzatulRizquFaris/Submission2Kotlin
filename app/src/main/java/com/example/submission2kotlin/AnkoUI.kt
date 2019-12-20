package com.example.submission2kotlin

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2kotlin.activity.LeagueActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class LeagueActivityUI : AnkoComponent<LeagueActivity> {
    var recyclerView: RecyclerView? = null

    override fun createView(ui: AnkoContext<LeagueActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            recyclerView = recyclerView {
                lparams(width = matchParent, height = matchParent)
            }
        }
    }
}

class ListUI : AnkoComponent<Context> {
    lateinit var image: ImageView
    lateinit var name: TextView
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        cardView {
            cardElevation = dip(2).toFloat()
            preventCornerOverlap = false
            elevation = dip(4).toFloat()
            radius = dip(15).toFloat()

            lparams {
                margin = dip(8)
                width = matchParent
                height = wrapContent
            }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                image = imageView {
                    id = Ids.image
                }.lparams(width = dip(72), height = dip(72)) {
                    margin = dip(16)
                }

                name = textView {
                    id = Ids.name
                    textSize = sp(8).toFloat()
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(30)
                }
            }.lparams {
                margin = dip(8)
            }

        }
    }

    companion object Ids {
        const val image = 1
        const val name = 2
    }
}
