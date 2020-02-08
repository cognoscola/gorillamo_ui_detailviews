package com.gorillamo.ui.detailview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_detail.*


class DetailListDialog :DialogFragment(){

    private lateinit var callback:(String)->Any

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_detail,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addButton.setOnClickListener {

            val inText = input.text.toString()
            if(inText.isNotBlank().or(inText.isNotEmpty()))
                callback(inText)
            dismiss()
        }
    }

    companion object{

        fun instance(callback:(String)->Any) = DetailListDialog().apply {
            this.callback = callback
        }
    }

}