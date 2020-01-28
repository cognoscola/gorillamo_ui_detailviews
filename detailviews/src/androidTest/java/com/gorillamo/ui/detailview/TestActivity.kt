package com.gorillamo.ui.detailview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)


        supportFragmentManager.beginTransaction()
            .add(R.id.detail_list,DetailListViewFragment())
            .commit()
    }



    companion object{

        var layout = 0

    }

}