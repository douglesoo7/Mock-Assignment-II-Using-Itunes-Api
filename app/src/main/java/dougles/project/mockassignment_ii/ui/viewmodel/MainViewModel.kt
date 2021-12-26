package dougles.project.mockassignment_ii.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dougles.project.mockassignment_ii.db.entities.SongEntity
import dougles.project.mockassignment_ii.model.ResponseDTO
import dougles.project.mockassignment_ii.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getDataFromApi(searchTerm: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getDataFromApi(searchTerm)
        }
    }

    fun getDataFromDb() = mainRepository.getDataFromDb()



}