package ninh.luyen.dds.ui.homes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_error.view.*
import ninh.luyen.dds.R

/**
 * Created by luyen_ninh on 4/20/21.
 */
class ErrorAdapter(private val errorMessage: String)
    : RecyclerView.Adapter<ErrorViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ErrorViewHolder {
        return ErrorViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_error,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ErrorViewHolder, position: Int) {
        holder.apply {
            tvErrorMessage.text = errorMessage
        }
    }

}

class ErrorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvErrorMessage: TextView = view.tvErrorMessage
}