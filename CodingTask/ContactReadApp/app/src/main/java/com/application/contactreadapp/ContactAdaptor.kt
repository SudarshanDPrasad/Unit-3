//package com.application.contactreadapp
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.item_layout.view.*
//
//class ContactAdaptor(
//    val list : List<ContactDto>
//): RecyclerView.Adapter<ContactHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
//        return ContactHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
//        val listofContacts = list[position]
//        holder.setData(listofContacts)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}
//
//class ContactHolder(
//    val itemview: View,
//) : RecyclerView.ViewHolder(itemview) {
//
//    fun setData(contactDto: ContactDto){
//        itemview.Tv_Name.setText(contactDto.name)
//        itemview.Tv_Number.setText(contactDto.number)
//    }
//
//}
