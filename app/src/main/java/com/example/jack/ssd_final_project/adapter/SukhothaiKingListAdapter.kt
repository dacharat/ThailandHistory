package com.example.jack.ssd_final_project.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import com.example.jack.ssd_final_project.R
import com.example.jack.ssd_final_project.models.Kingdom
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL

class SukhothaiKingListAdapter(val context: Context, val kingList: ArrayList<Kingdom>): BaseAdapter(), ListAdapter {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.king_info, null)
        }

        val kingdom: Kingdom = getItem(position) as Kingdom

        val kingImage = view!!.findViewById(R.id.kingImage) as ImageView
        val kingName = view.findViewById(R.id.kingName) as TextView
        val kingReign = view.findViewById(R.id.kingReign) as TextView
        val kingDoing = view.findViewById(R.id.kingDoing) as TextView

        kingName.text = kingdom.name
        kingReign.text = kingdom.reign
        kingDoing.text = kingdom.doing
        var input: InputStream? = null
        try{
            val url = URL(kingdom.image)
            input = BufferedInputStream(url.openStream())
            val bitmap = BitmapFactory.decodeStream(input)
            val resized = Bitmap.createScaledBitmap(bitmap, (bitmap.width*0.39).toInt(), (bitmap.height*0.39).toInt(), true)
            kingImage.setImageBitmap(resized)
        }catch(e : Exception){

        }finally {
            if(input != null) {
                try {
                    input.close()
                } catch (e: IOException) {

                }
            }
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return kingList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return kingList.size
    }

}