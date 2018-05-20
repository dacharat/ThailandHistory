package com.example.jack.ssd_final_project.models

import java.io.Serializable

class ThaiHistory(val mainHistory: String): Serializable {

    override fun toString(): String {
        return mainHistory
    }
}