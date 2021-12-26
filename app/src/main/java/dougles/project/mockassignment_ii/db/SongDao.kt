package dougles.project.mockassignment_ii.db

import androidx.lifecycle.LiveData
import androidx.room.*
import dougles.project.mockassignment_ii.db.entities.SongEntity

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(song: SongEntity)

    @Query("SELECT * FROM song")
    fun getAllSongs(): LiveData<List<SongEntity>>

    @Query("SELECT * FROM song WHERE trackArtist =:trackArtistName")
    fun getSongs(trackArtistName: String): LiveData<List<SongEntity>>

    @Insert
    fun insertAll(songs: ArrayList<SongEntity>)

    @Query("DELETE FROM song")
    fun deleteAllDataFromDb()
}