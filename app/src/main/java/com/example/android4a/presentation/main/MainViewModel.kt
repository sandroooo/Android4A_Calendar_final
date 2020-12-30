package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.*


class MainViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
): ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser : String ){
        //createUserUseCase.invoke(User("test"))
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test@gmail.com"))
           val user = getUserUseCase.invoke(emailUser)
           //val user2 = getUserUseCase.invoke("test@gmail.com ","azerty")
           val loginStatus =  if(user !=null){
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }


        }
    }

    fun onCreate(emailUser : String ){

        viewModelScope.launch(Dispatchers.IO) {


            val user = createUserUseCase.invoke(User(emailUser))


        }
    }

}