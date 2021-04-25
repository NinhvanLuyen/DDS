package ninh.luyen.dds.ui.homes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ninh.luyen.dds.R

/**
 * Created by luyen_ninh on 4/25/21.
 */
class LoadingAdapter : RecyclerView.Adapter<LoadingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadingViewHolder {
        return LoadingViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_loading,
                    parent
                    ,false
                )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: LoadingViewHolder, position: Int) {
    }
}

class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view)
