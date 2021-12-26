package dougles.project.mockassignment_ii.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class
SongEntity(
    @ColumnInfo(name = "trackName") var trackName: String? = null,
    @ColumnInfo(name = "trackArtist") var trackArtist: String? = null,
    @ColumnInfo(name = "albumArt") var albumArt: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}