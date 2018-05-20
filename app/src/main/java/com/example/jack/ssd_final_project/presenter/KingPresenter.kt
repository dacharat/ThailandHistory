package com.example.jack.ssd_final_project.presenter

import com.example.jack.ssd_final_project.models.KingdomRepository
import java.util.*

class KingPresenter(val view: KingView, val kingRepo : KingdomRepository): Observer {

    fun start() {
        kingRepo.addObserver(this)
        kingRepo.loadAllKing()
    }

    override fun update(o: Observable?, arg: Any?) {
        if(o == kingRepo) {
            view.setKingList(kingRepo.getKingList())
        }
    }

}