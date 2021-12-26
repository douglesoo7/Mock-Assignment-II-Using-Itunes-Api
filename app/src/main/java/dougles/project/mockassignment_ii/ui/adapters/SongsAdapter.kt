package dougles.project.mockassignment_ii.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dougles.project.mockassignment_ii.R
import dougles.project.mockassignment_ii.db.entities.SongEntity
import kotlinx.android.synthetic.main.item_layout.view.*

class SongsAdapter(private val responseDTOList: ArrayList<SongEntity>) :
    RecyclerView.Adapter<SongsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val song = responseDTOList[position]
        holder.setData(song)
    }

    override fun getItemCount(): Int {
        return responseDTOList.size
    }
}

class SongsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(song: SongEntity) {
        view.apply {
            Glide.with(ivAlbumArt)
                .load(song.albumArt)
                .into(ivAlbumArt)

            tvTrackName.text = song.trackName
            tvTrackAlbum.text = "Dummy Album"
            tvTrackArtist.text = song.trackArtist
        }
    }
}
