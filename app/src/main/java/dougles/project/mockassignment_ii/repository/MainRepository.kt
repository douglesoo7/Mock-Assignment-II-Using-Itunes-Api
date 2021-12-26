package dougles.project.mockassignment_ii.repository

import android.content.Context
import androidx.lifecycle.LiveData
import dougles.project.mockassignment_ii.api.RetrofitBuilder
import dougles.project.mockassignment_ii.db.SongDao
import dougles.project.mockassignment_ii.db.SongDatabase
import dougles.project.mockassignment_ii.db.entities.SongEntity
import dougles.project.mockassignment_ii.model.ResultsDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository(context: Context) {
    val dao = SongDatabase.getSongsDatabase(context).getDao()
    val api = RetrofitBuilder.getApiService()

    suspend fun getDataFromApi(searchTerm: String) {

        val response = api.getSongs(searchTerm)

        storeDataInDatabase(response.results)
    }

    fun storeDataInDatabase(result: List<ResultsDTO?>?) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllDataFromDb()
            val listOfSongs = ArrayList<SongEntity>()
            for (i in result!!) {
                val songEntity = SongEntity(i?.trackName, i?.artistName, i?.artworkUrl100)
                listOfSongs.add(songEntity)
            }

            dao.insertAll(listOfSongs)
        }
    }

    fun getDataFromDb() = dao.getAllSongs()



}

