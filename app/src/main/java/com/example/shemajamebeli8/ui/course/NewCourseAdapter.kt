package com.example.shemajamebeli8.ui.course

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli8.R
import com.example.shemajamebeli8.databinding.NewCourseItemBinding
import com.example.shemajamebeli8.model.NewCourse

class NewCourseAdapter : RecyclerView.Adapter<NewCourseAdapter.NewCourseItem>() {

    var newCourseList: List<NewCourse> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewCourseItem(
        NewCourseItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: NewCourseItem, position: Int) {
        holder.bind()
    }

    override fun getItemCount() : Int {
        return newCourseList.size
    }

    inner class NewCourseItem(private val binding: NewCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var curItem: NewCourse

        fun bind() {
            curItem = newCourseList[adapterPosition]
            setIcon(curItem.iconType)
            binding.durationTxtView.text = curItem.duration
            binding.titleTxtView.text = curItem.title
            binding.questeionTxtView.text = curItem.question
            binding.newCourseLayout.setBackgroundColor(Color.parseColor("#" + curItem.mainColor))
                .toString()
        }

        private fun setIcon(iconName: String?) {
            if (iconName == "card")
                binding.iconImgView.setImageDrawable(
                    getDrawable(
                        itemView.context,
                        R.drawable.ic_baseline_credit_card_24
                    )
                )
            else
                binding.iconImgView.setImageDrawable(
                    getDrawable(
                        itemView.context,
                        R.drawable.ic_baseline_settings_24
                    )
                )
        }

    }

}