package com.example.jack.ssd_final_project.models

import android.os.AsyncTask
import org.json.JSONObject
import java.net.URL

class MockKingdomRepository: KingdomRepository() {

    private var kingList = ArrayList<Kingdom>()

    override fun getKingList(): ArrayList<Kingdom> {
        return kingList
    }

    override fun loadAllKing() {
        kingList.clear()
        SukhothaiKingLoaderTask().execute()
    }

    private inner class SukhothaiKingLoaderTask : AsyncTask<String, Unit, String>() {
        override fun doInBackground(vararg params: String?): String {
            return URL("https://raw.githubusercontent.com/dacharat/ThailandHistory/master/assets/SukhothaiKingdom.json").readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            if(result != null) {
                val obj = JSONObject(result)

                for(key in obj.keys()) {
                    val expair = obj.getJSONObject(key)
                    kingList.add(Kingdom(expair.getString("image"),expair.getString("name"), expair.getString("reign"), expair.getString("doing")))
                }
            }
            setChanged()
            notifyObservers()
        }

    }
}