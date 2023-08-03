package com.zrq.webvideo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zrq.webvideo.databinding.ItemHomeVideoBinding
import com.zrq.webvideo.entity.VideoItem
import xyz.doikki.videocontroller.StandardVideoController

class HomeVideoAdapter(
    private val context: Context,
    private val list: MutableList<VideoItem>,
    private val onItemClick: (ItemHomeVideoBinding, Int) -> Unit,
    private val onItemLongClick: (Int) -> Unit,
) : RecyclerView.Adapter<VH<ItemHomeVideoBinding>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemHomeVideoBinding> {
        val inflate = ItemHomeVideoBinding.inflate(LayoutInflater.from(context), parent, false)
        return VH(inflate)
    }

    override fun onBindViewHolder(holder: VH<ItemHomeVideoBinding>, position: Int) {
        val item = list[position]
        holder.binding.apply {
            tvTitle.text = item.title
            tvUpName.text = item.up
            tvDuration.text = item.duration
            Glide.with(context)
                .load(item.cover)
                .into(ivCover)

            if (item.isPlayer) {
                videoView.visibility = View.VISIBLE
                rlCover.visibility = View.GONE
                videoView.release()
                videoView.setUrl(item.preview)
                videoView.setLooping(true)
                videoView.start()
            } else {
                videoView.visibility = View.GONE
                rlCover.visibility = View.VISIBLE
                videoView.release()
            }

            root.setOnClickListener {
                onItemClick(this ,position)
            }
            root.setOnLongClickListener {
                onItemLongClick(position)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}