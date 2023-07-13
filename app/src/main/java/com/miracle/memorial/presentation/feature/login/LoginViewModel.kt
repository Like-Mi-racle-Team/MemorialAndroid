package com.miracle.memorial.presentation.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miracle.memorial.domain.model.Login
import com.miracle.memorial.domain.model.LoginDto
import com.miracle.memorial.domain.repository.LoginRepository
import com.miracle.memorial.presentation.utils.MutableEventFlow
import com.miracle.memorial.presentation.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _eventFLow = MutableEventFlow<Event>()
    val eventFlow = _eventFLow.asEventFlow()

    fun login(loginDto: LoginDto) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            loginRepository.login(loginDto)
        }.onSuccess {
            event(Event.SuccessLogin(it))
            Log.d("success", "$it")
        }.onFailure {
            event(Event.UnkownException)
            Log.d("error1", "${it.message}")
        }
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFLow.emit(event)
        }
    }

    sealed class Event {
        data class SuccessLogin(val code: Login): Event()
        object SuccessToken: Event()
        object UnkownException: Event()
    }

}