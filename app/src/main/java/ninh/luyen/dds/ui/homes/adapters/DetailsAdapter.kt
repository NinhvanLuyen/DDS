package ninh.luyen.dds.ui.homes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_day_detail.view.*
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.utils.toTimeFromSeconds
import ninh.luyen.dds.datas.remotes.responses.Detail


/**
 * Created by luyen_ninh on 4/20/21.
 */

class DetailsAdapter(private val mData: List<Detail>) :
    RecyclerView.Adapter<DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_day_detail,
                    null
                )
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
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

class DetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDate: TextView = view.tvDate
    val tvAvgTemp: TextView = view.tvAvgTemp
    val tvPressure: TextView = view.tvPressure
    val tvHumidity: TextView = view.tvHumidity
    val tvDescription: TextView = view.tvDescription

}