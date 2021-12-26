package dougles.project.mockassignment_ii.ui.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dougles.project.mockassignment_ii.R
import dougles.project.mockassignment_ii.db.entities.SongEntity
import dougles.project.mockassignment_ii.repository.MainRepository
import dougles.project.mockassignment_ii.ui.adapters.SongsAdapter
import dougles.project.mockassignment_ii.ui.viewmodel.MainViewModel
import dougles.project.mockassignment_ii.ui.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var songsAdapter: SongsAdapter
    lateinit var viewModel: MainViewModel
    lateinit var repository: MainRepository
    private var songsList = ArrayList<SongEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = MainRepository(this)


        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        etSearch.addTextChangedListener {

            if (isInternetActive()) {
                viewModel.getDataFromApi(it.toString())
            }

            viewModel.getDataFromDb().observe(this, Observer {
                // Log.d("DataIsComing", it.results.toString())
                //Toast.makeText(this, it.results.toString(), Toast.LENGTH_LONG).show()
                songsList = it as ArrayList<SongEntity>
                setRecyclerView()
            })
            Log.d("Sachin", it.toString())
        }
    }

    private fun isInternetActive(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)?.state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)?.state == NetworkInfo.State.CONNECTED
    }

    private fun setRecyclerView() {
        songsAdapter = SongsAdapter(songsList!!)
        recyclerView.adapter = songsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}