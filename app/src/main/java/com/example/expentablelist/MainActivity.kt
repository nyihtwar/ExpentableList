package com.example.expentablelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val data: HashMap<String,List<String>> get(){

        val carList= ArrayList<String>()
        carList.add("Swift")
        carList.add("Honda")
        carList.add("BMW")
        carList.add("Suzuki")

        val drinkList=ArrayList<String>()
        drinkList.add("Asia")
        drinkList.add("Bear")
        drinkList.add("Wine")
        drinkList.add("CocaCola")

        val studentList=ArrayList<String>()
        studentList.add("Mg Mg")
        studentList.add("Kyaw Win Paing")
        studentList.add("Htet Akar")
        studentList.add("Pyae Sone Phyo")
        studentList.add("Way Yan Tun")

        val subjectList=ArrayList<String>()
        subjectList.add("Java")
        subjectList.add("PHP")
        subjectList.add("Kotlin")
        subjectList.add("Python")

        val dataList=HashMap<String,List<String>>()
        dataList["cars"]=carList
        dataList["drinks"]=drinkList
        dataList["students"]=studentList
        dataList["subjects"]=subjectList

        return dataList
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataList=data
        val titles=ArrayList(dataList.keys)
        val adapter=CustomAdapter(this,titles,dataList)

        myExList.setAdapter(adapter)
    }
}
