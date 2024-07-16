package ru.alexsergeev.testwb.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.java.KoinJavaComponent.inject
import ru.alexsergeev.testwb.dto.EventModel
import ru.alexsergeev.testwb.dto.PersonModel
import ru.alexsergeev.testwb.repository.BaseRepository

class BaseViewModel(val repository: BaseRepository): ViewModel() {

    private var _personData by mutableStateOf(PersonModel("","", ""))
    val personData: PersonModel
        get() = _personData

    private fun getPersonData() {
        _personData = repository.getPersonData()
    }

    fun setPersonData(name: String, phone: String, avatar: String) {
        _personData.name = name
        _personData.phone = phone
        _personData.avatar = avatar
    }

    fun getEventsList() = repository.getEventsList()

    fun getGroups() = repository.getGroups()
}

//@Composable
//fun ViewModelInject(userName : String, viewModel: BaseViewModel = koinViewModel()){
//    Text(text = viewModel.sayHello(userName), modifier = Modifier.padding(8.dp))
//}
//
//class UserStateHolder(private val repository: BaseRepository) {
//
//    fun sayHello(name : String) : String{
//        val foundUser = repository.findUser(name)
//        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
//    }
//}
//
//@Composable
//fun FactoryInject(userName : String, presenter: UserStateHolder = get()){
//    Text(text = presenter.sayHello(userName), modifier = Modifier.padding(8.dp))
//}