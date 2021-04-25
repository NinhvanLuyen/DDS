package ninh.luyen.dds.ui.homes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.BaseFragment
import ninh.luyen.dds.commons.utils.onClick
import ninh.luyen.dds.ui.homes.adapters.ErrorAdapter
import ninh.luyen.dds.ui.homes.adapters.LoadingAdapter
import ninh.luyen.dds.ui.homes.adapters.TempAdapter
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
        edtSearch.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    if (edtSearch.text.trim().length >= 3)
                        viewModel.search(edtSearch.text.toString())
                    else
                        edtSearch.error = getString(R.string.too_short)
                    true
                }
                else -> {
                    false

                }

            }
        }

        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnSearch.isEnabled = edtSearch.text.trim().length >= 3
            }

        })
        btnSearch.isEnabled = edtSearch.text.trim().length >= 3
        btnSearch.onClick {
            viewModel.search(edtSearch.text.toString())
        }
        viewModel.news.observe(viewLifecycleOwner) {
            val weatherAdapter =
                TempAdapter(it.list)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =
                ConcatAdapter(weatherAdapter, weatherAdapter, weatherAdapter, weatherAdapter)

        }
        viewModel.error.observe(viewLifecycleOwner) {
            val errorAdapter =
                ErrorAdapter(getString(it))
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = errorAdapter

        }
        viewModel.loading.observe(viewLifecycleOwner) {
            val loadingAdapter = LoadingAdapter()
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = loadingAdapter

        }
        viewModel.query.observe(viewLifecycleOwner) {
            edtSearch.setText(it)

        }
    }
}