package dougles.project.mockassignment_ii.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dougles.project.mockassignment_ii.db.entities.SongEntity

@Database(
    entities = [SongEntity::class],
    version = 1
)
abstract class SongDatabase : RoomDatabase() {

    abstract fun getDao(): SongDao

    companion object {
        private var instance: SongDatabase? = null

        fun getSongsDatabase(context: Context): SongDatabase {
            if (instance != null) {

                return instance!!

            } else {

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    SongDatabase::class.java,
                    "songs_db"
                ).fallbackToDestructiveMigration()
                instance = builder.build()
                return instance!!


            }
        }
    }
}