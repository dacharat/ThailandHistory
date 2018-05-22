package com.example.jack.ssd_final_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jack.ssd_final_project.adapter.KingListAdapter
import com.example.jack.ssd_final_project.models.Kingdom
import com.example.jack.ssd_final_project.models.KingdomRepository
import com.example.jack.ssd_final_project.models.MockKingdomRepository
import com.example.jack.ssd_final_project.presenter.KingPresenter
import com.example.jack.ssd_final_project.presenter.KingView
import kotlinx.android.synthetic.main.activity_sukhothai_king.*

class AyutthayaKingActivity : AppCompatActivity(), KingView {

    private lateinit var kingRepo: KingdomRepository
    private lateinit var presenter: KingPresenter
    private lateinit var adapter: KingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayutthaya_king)

        kingRepo = MockKingdomRepository(2)
        presenter = KingPresenter(this, kingRepo)
        presenter.start()
    }

    override fun setKingList(kings: ArrayList<Kingdom>) {
        adapter = KingListAdapter(this, kings)
        kingList.adapter = adapter
    }
}

