package ninh.luyen.dds.commons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.utils.replaceFragment

abstract class BaseFragment : Fragment() {
    private lateinit var activity: BaseActivity

    private lateinit var baseViewModel: BaseViewModel

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.activity = context as BaseActivity
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::baseViewModel.isInitialized)
            baseViewModel.onDestroy()
    }

    internal fun navigateToFragment(fragDes: BaseFragment, tag: String) {
        replaceFragment(
            R.id.container,
            fragDes,
            true,
            tag
        )
    }

    internal fun init(viewModel: BaseViewModel) {
        baseViewModel = ViewModelProvider(this).get(viewModel::class.java)
        baseViewModel.init()
    }

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

}