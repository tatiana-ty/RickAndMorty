package com.andersenlab.rickandmorty.features.episodes.ui

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.andersenlab.domain.entities.Episode
import com.andersenlab.rickandmorty.R

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder>() {

    private lateinit var episodes: List<Episode>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.episode_item, parent, false)
                    as View
        )
    }

    var onClick: (Episode) -> Unit = { _ -> }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(viewHolder: EpisodesViewHolder, position: Int) {
        viewHolder.bind(episodes[position])
        avoidMultipleClicks(viewHolder.itemView)
        viewHolder.itemView.setOnClickListener {
            onClick(episodes[position])
        }
    }

    private fun avoidMultipleClicks(view: View) {
        view.isClickable = false
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            view.isClickable = true
        }, 1000)
    }

    fun updateAdapter(updatedList: List<Episode>) {
        val result = DiffUtil.calculateDiff(EpisodesDiffCallback(episodes, updatedList))
        this.episodes = updatedList.toMutableList()
        result.dispatchUpdatesTo(this)
    }

    fun setData(episodes: List<Episode>) {
        this.episodes = episodes
    }

    inner class EpisodesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.episode)
        val date: TextView = itemView.findViewById(R.id.airDate)

        fun bind(episode: Episode) {
            name.text = "${episode.episode}: ${episode.name}"
            date.text = episode.date
        }
    }
}