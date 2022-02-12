package com.application.tastyapp.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.tastyapp.R
import com.application.tastyapp.response.model.frontScreen.InstructionX
import kotlinx.android.synthetic.main.instruction_item_view.view.*

class InstructionAdapter(val prepList:ArrayList<InstructionX>): RecyclerView.Adapter<InstructionAdapter.PreparationHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreparationHolder {
        return PreparationHolder(LayoutInflater.from(parent.context).inflate(R.layout.instruction_item_view,parent,false))

    }

    override fun onBindViewHolder(holder: PreparationHolder, position: Int) {
        holder.setData(prepList[position])
    }


    override fun getItemCount(): Int {
        return prepList.size
    }

    class PreparationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(instruction: InstructionX) {
            itemView.apply {
                tv_stepNo.text = instruction.position.toString()
                tv_StepDetial.text = instruction.displayText
            }
        }
    }
}