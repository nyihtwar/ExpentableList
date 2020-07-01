package com.example.expentablelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import kotlinx.android.synthetic.main.list_group.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class CustomAdapter(val context: Context,
                    val titles :List<String>,
                    val dataList:HashMap<String,List<String>>
):BaseExpandableListAdapter() {
    override fun getGroup(p0: Int): Any {
        return titles[p0]
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true

    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {

        val cv=LayoutInflater.from(context).inflate(R.layout.list_group,p3,false)
        cv.listTitle.text=titles[p0]
        return cv
    }

    override fun getChildrenCount(p0: Int): Int {
        return dataList[titles[p0]]!!.size
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return dataList[titles[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {

        val cv=LayoutInflater.from(context).inflate(R.layout.list_item,p4,false)
        cv.exListItem.text=dataList[titles[p0]]!![p1]
        return cv
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun getGroupCount(): Int {
        return titles.size
    }
}