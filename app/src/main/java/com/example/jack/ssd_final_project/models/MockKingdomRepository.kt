package com.example.jack.ssd_final_project.models

import android.os.AsyncTask
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import org.json.JSONObject
import java.io.StringReader
import java.net.URL

class MockKingdomRepository(val kingdomPeriod:Int): KingdomRepository() {

    private val thJson: String = "https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/ThaiHistory.json"
    private val sktJson: String = "https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/SukhothaiKingdom.json"
    private val aydJSON: String = "https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/AyutthayaKingdom.json"
    private val tbrJson: String = "https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/ThonburiKingdom.json"
    private val rtsJson: String = "https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/RattanakosinKingdom.json"

    private var kingList = ArrayList<Kingdom>()
    lateinit var jsonUrl: String

    init {
        when(kingdomPeriod) {
            0-> jsonUrl = thJson
            1-> jsonUrl = sktJson
            2-> jsonUrl = aydJSON
            3-> jsonUrl = tbrJson
            4-> jsonUrl = rtsJson
            else -> {
//                jsonUrl = ""
            }
        }
    }

    override fun getKingList(): ArrayList<Kingdom> {
        return kingList
    }

    override fun loadAllKing() {
        kingList.clear()
        SukhothaiKingLoaderTask().execute()
    }

    private inner class SukhothaiKingLoaderTask : AsyncTask<String, Unit, String>() {
        override fun doInBackground(vararg params: String?): String {
            return URL(jsonUrl).readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            if(result != null) {

                val klaxon = Klaxon()

                JsonReader(StringReader(result)).use { reader ->
                    reader.beginArray {
                        while (reader.hasNext()) {
                            klaxon.parse<Kingdom>(reader)?.let {
                                kingList.add(it)

                            }
                        }
                    }
                }
            }
            setChanged()
            notifyObservers()
        }

    }
}