package ninh.luyen.dds.ui.homes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_temp_detail.view.*
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.utils.toTimeFromSeconds
import ninh.luyen.dds.datas.remotes.responses.Detail


/**
 * Created by luyen_ninh on 4/20/21.
 */

class TempAdapter(private val mData: List<Detail>) :
    RecyclerView.Adapter<TempViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempViewHolder {
        return TempViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_temp_detail,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: TempViewHolder, position: Int) {
        holder.apply {
            tvDate.text =
                itemView.context.getString(R.string.date, mData[position].dt.toTimeFromSeconds())
            tvAvgTemp.text =
                itemView.context.getString(R.string.avg_temp, mData[position].temp.getAvg())
            tvPressure.text =
                itemView.context.getString(R.string.pressure, mData[position].pressure)
            tvHumidity.text =
                itemView.context.getString(R.string.humidity, mData[position].humidity)
            tvDescription.text = itemView.context.getString(
                R.string.description,
                mData[position].weather.first().description
            )
        }
    }

}

class TempViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDate: TextView = view.tvDate
    val tvAvgTemp: TextView = view.tvAvgTemp
    val tvPressure: TextView = view.tvPressure
    val tvHumidity: TextView = view.tvHumidity
    val tvDescription: TextView = view.tvDescription

}