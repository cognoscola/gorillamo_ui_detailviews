package com.gorillamo.ui.detailview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_detail.*

class DetailListViewFragment private constructor():Fragment(){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.detail_list).apply {
            adapter = DetailListAdapter(arguments?.getStringArray(VALUE_KEY)?: emptyArray())
            val layoutMgr = LinearLayoutManager(context)
            layoutMgr.orientation = LinearLayoutManager.VERTICAL
            layoutManager = LinearLayoutManager(context)
        }

        view.findViewById<Button>(R.id.addButton).setOnClickListener {

            DetailListDialog.instance {



            }.show(childFragmentManager,"TAG")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_detail,container,false)
    }


    companion object{

        private const val VALUE_KEY = "KEY"

        fun Instance(values:Array<String>):DetailListViewFragment =
             DetailListViewFragment().apply {
                 val bundle = Bundle()
                 bundle.putStringArray(VALUE_KEY,values)
                 arguments = bundle
             }
    }
}