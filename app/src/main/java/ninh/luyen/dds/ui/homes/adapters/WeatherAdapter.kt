package ninh.luyen.dds.ui.homes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ninh.luyen.dds.R
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel

/**
 * Created by luyen_ninh on 4/20/21.
 */
class WeatherAdapter(private val mData: List<SearchResponseModel>) :
    RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_weather,
                    null
                )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.apply {
            tvCityName.text = mData[position].city.name
        }
    }

}

class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvCityName: TextView = view.findViewById(R.id.tvCityName)
}