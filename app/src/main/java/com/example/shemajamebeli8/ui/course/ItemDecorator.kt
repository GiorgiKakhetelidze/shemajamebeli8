package com.example.shemajamebeli8.ui.course

import android.graphics.Rect
import android.view.View
import androidx.annotation.Dimension
import androidx.recyclerview.widget.RecyclerView

class ItemDecorator(@Dimension private val marginStart: Int = 0 , @Dimension private val marginTop: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        outRect.set(
            marginStart,
             marginTop,
             outRect.right,
              outRect.bottom
        )
    }
}