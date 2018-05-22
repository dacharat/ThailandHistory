package com.example.jack.ssd_final_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jack.ssd_final_project.adapter.SukhothaiKingListAdapter
import com.example.jack.ssd_final_project.models.Kingdom
import com.example.jack.ssd_final_project.models.KingdomRepository
import com.example.jack.ssd_final_project.models.MockKingdomRepository
import com.example.jack.ssd_final_project.presenter.KingPresenter
import com.example.jack.ssd_final_project.presenter.KingView
import kotlinx.android.synthetic.main.activity_sukhothai_king.*

class SukhothaiKingActivity : AppCompatActivity(), KingView {

    private lateinit var kingRepo: KingdomRepository
    private lateinit var presenter: KingPresenter
    private lateinit var adapter: SukhothaiKingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sukhothai_king)

        kingRepo = MockKingdomRepository()
        presenter = KingPresenter(this, kingRepo)
        System.out.print("I am starting")
        presenter.start()
    }

    override fun setKingList(kings: ArrayList<Kingdom>) {
        adapter = SukhothaiKingListAdapter(this, kings)
        kingList.adapter = adapter
    }

}
