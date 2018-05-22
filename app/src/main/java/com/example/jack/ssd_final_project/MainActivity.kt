package com.example.jack.ssd_final_project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import com.example.jack.ssd_final_project.adapter.KingListAdapter
import com.example.jack.ssd_final_project.models.Kingdom
import com.example.jack.ssd_final_project.models.KingdomRepository
import com.example.jack.ssd_final_project.models.MockKingdomRepository
import com.example.jack.ssd_final_project.presenter.KingPresenter
import com.example.jack.ssd_final_project.presenter.KingView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KingView {

    private lateinit var kingRepo: KingdomRepository
    private lateinit var presenter: KingPresenter
    private lateinit var adapter: KingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        kingRepo = MockKingdomRepository(0)
        presenter = KingPresenter(this, kingRepo)
        presenter.start()
    }

    fun changeToPeriodPage(view: View){
        val intent = Intent(this,PeriodActivity::class.java)
        startActivity(intent)
    }

    override fun setKingList(kings: ArrayList<Kingdom>) {
        adapter = KingListAdapter(this, kings)
        historyList.adapter = adapter
    }
}
