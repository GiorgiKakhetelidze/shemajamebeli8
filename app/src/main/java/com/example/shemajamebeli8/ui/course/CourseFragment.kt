package com.example.shemajamebeli8.ui.course

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli8.base.BaseFragment
import com.example.shemajamebeli8.databinding.CourseFragmentBinding
import com.example.shemajamebeli8.utils.Resource


class CourseFragment : BaseFragment<CourseFragmentBinding>(CourseFragmentBinding::inflate) {

    private val viewModel by viewModels<CourseViewModel>()
    private val newCourseAdapter = NewCourseAdapter()
    private val activeCourseAdapter = ActiveCourseAdapter()

    override fun init() {
        setObservers()
        setRecycler()
    }

    private fun setObservers() {
        viewModel.data.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    newCourseAdapter.newCourseList = resource.data!!.newCourses
                    activeCourseAdapter.activeCourseList = resource.data.activeCourses
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }
    }

    private fun setRecycler() {
        binding.newCoursesRecyclerView.apply {
            addItemDecoration(ItemDecorator(marginStart = 70, marginTop = 0))
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = newCourseAdapter
        }

        binding.activeCoursesRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = activeCourseAdapter
            addItemDecoration(ItemDecorator(marginTop = 70))
        }
    }

}