package com.example.jack.ssd_final_project.models

import java.util.*
import kotlin.collections.ArrayList

abstract class KingdomRepository: Observable() {

    abstract fun loadAllKing()

    abstract fun getKingList(): ArrayList<Kingdom>
}