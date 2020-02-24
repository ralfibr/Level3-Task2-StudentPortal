package com.example.studentportal

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_portal.view.*

/**
 * Portal Adapter
 */

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
// Handle the navigate to web browser
        fun bind(portal: Portal) {
            itemView.tvTitle.text = portal.title
            itemView.tvUrl.text = portal.url
            itemView.setOnClickListener {
                val uris = Uri.parse(portal.url)
                val intents = Intent(Intent.ACTION_VIEW, uris)
                val b = Bundle()
                b.putBoolean("new_window", true)
                intents.putExtras(b)
                 var context: Context = itemView.context
                context.startActivity(intents)

            }
        }
    }
// onCreateViewHolder: Called when RecyclerView needs a new RecyclerView.ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    // get array size
    override fun getItemCount(): Int {
        return portals.size
    }
    //  Called by RecyclerView to bind the data with the specified position.
    //  The bind method made in the previous step is used.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }


}



