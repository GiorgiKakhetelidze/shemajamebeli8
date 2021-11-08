package com.example.shemajamebeli8.ui.course

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli8.databinding.ActiveCourseItemBinding
import com.example.shemajamebeli8.model.ActiveCourse
import okhttp3.internal.toHexString

class ActiveCourseAdapter : RecyclerView.Adapter<ActiveCourseAdapter.ActiveCourseItem>() {

    var activeCourseList: List<ActiveCourse> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActiveCourseItem(
        ActiveCourseItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: ActiveCourseItem, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return activeCourseList.size
    }

    inner class ActiveCourseItem(private val binding: ActiveCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var curItem: ActiveCourse

        fun bind() {
            curItem = activeCourseList[adapterPosition]
            Glide.with(itemView.context).load(curItem.image).into(binding.ImgView)
            binding.titleTxtView.text = curItem.title
            binding.bookingTimeTxtView.text = curItem.bookingTime
            binding.playBtn.progress = curItem.progress?.toInt()!!
            val backgroundOpacity = curItem.backgroundColorPresent?.toInt()?.let { setOpacity(it) } ?: "80"
            val playButtonOpacity = curItem.playButtonColorPresent?.toInt()?.let { setOpacity(it) } ?: "80"
            binding.activeCourseLayout.setBackgroundColor(Color.parseColor("#" + backgroundOpacity + curItem.mainColor))
            binding.titleTxtView.setTextColor(Color.parseColor("#" + curItem.mainColor))
            binding.bookingTimeTxtView.setTextColor(Color.parseColor("#" + playButtonOpacity + curItem.mainColor))
        }

        private fun setOpacity(percent: Int): String {
            val opacity = (100 - percent) / 100 * 255
            return opacity.toHexString()
        }
    }

}