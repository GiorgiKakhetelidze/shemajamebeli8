package com.example.shemajamebeli8.ui.course

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli8.model.Courses
import com.example.shemajamebeli8.network.NetworkClient
import com.example.shemajamebeli8.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CourseViewModel : ViewModel() {

    private val _data = MutableLiveData<Resource<Courses>>()
    val data: MutableLiveData<Resource<Courses>> get() = _data

    init {
        getData()
    }

    private fun getData() {
        try {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    _data.postValue(Resource.Loading(load = true))
                    val response = NetworkClient.courseService.getCourses()
                    val result = response.body()
                    if (response.isSuccessful && result != null)
                        _data.postValue(Resource.Success(data = result))
                    else
                        _data.postValue(Resource.Error(message = response.message()))
                }
            }
        } catch (e: Exception) {
            _data.postValue(Resource.Error(message = e.message.toString()))
        } finally {
            _data.postValue(Resource.Loading(load = false))
        }
    }


}