package com.gorillamo.ui.detailview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)


        supportFragmentManager.beginTransaction()
            .add(containerId,DetailListViewFragment.Instance(testInput!!))
            .commit()
    }



    companion object{

        var testInput:Array<String>? = null
        var containerId = 0
        var layout = 0

    }

}