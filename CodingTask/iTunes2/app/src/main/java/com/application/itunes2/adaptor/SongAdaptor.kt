package com.application.itunessong.adaptor

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.itunes2.R
import com.application.itunes2.databinding.ItemLayoutBinding
import com.application.itunes2.onCLick
import com.application.itunessong.responsemodel.Result
import com.bumptech.glide.Glide

class SongAdaptor(
    val list: List<Result>,
//    var listener : onCLick
) : RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return SongViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val songlist = list[position]
        holder.setData(songlist)
//        val mediaPlayer: MediaPlayer =
//            MediaPlayer.create(holder.itemLayoutBinding.TvSongName.context,
//                Uri.parse(holder.itemLayoutBinding.songname!!.previewUrl))
//
//
//        holder.itemLayoutBinding.ButtonPlay.setOnClickListener {
//            mediaPlayer.start()
//        }
//        holder.itemLayoutBinding.ButtonPause.setOnClickListener {
//            mediaPlayer.pause() }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class SongViewHolder(
    val itemLayoutBinding: ItemLayoutBinding,
//    var listener : onCLick
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(resultModel: Result) {
        itemLayoutBinding.songname = resultModel
//        itemLayoutBinding.saveclicklistener = listener
        Glide.with(itemLayoutBinding.IvImageOfSong).load(resultModel.artworkUrl100)
            .into(itemLayoutBinding.IvImageOfSong)
    }

}
