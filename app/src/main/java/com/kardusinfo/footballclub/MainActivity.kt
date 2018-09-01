package com.kardusinfo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        //kotlin extention
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = Adapter(this, items){
            startActivity(intentFor<InfoActivity>("nama" to "${it.name}","gambar" to it.image,"info" to "${it.infonya}").singleTop())
         }

    }
    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val infonya = resources.getStringArray(R.array.club_info)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),infonya[i]))
        }
        //Recycle the typed array
        image.recycle()
    }
}
