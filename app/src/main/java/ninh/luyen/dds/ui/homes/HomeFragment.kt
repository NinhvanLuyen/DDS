package ninh.luyen.dds.ui.homes

import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import ninh.luyen.dds.commons.utils.onClick
import kotlinx.android.synthetic.main.home_fragment.*
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.BaseFragment
import ninh.luyen.dds.ui.homes.adapters.DetailsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by luyen_ninh on 3/21/21.
 */
class HomeFragment : BaseFragment() {
    private val viewModel: HomeViewModel by viewModel()

    override fun layoutId(): Int {
        return R.layout.home_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init(viewModel)
        viewModel.getCache()

        btnSearch.onClick {
            viewModel.search(edtSearch.text.toString())
        }
        viewModel.news.observe(viewLifecycleOwner) {
            val weatherAdapter =
                DetailsAdapter(it.list)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =
                ConcatAdapter(weatherAdapter, weatherAdapter, weatherAdapter, weatherAdapter)

        }
        viewModel.error.observe(viewLifecycleOwner) {
            val errorAdapter = ErrorAdapter(getString(it))
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = errorAdapter

        }
        viewModel.query.observe(viewLifecycleOwner) {
            edtSearch.setText(it)

        }
    }
}