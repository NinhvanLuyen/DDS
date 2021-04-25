package ninh.luyen.dds.commons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.utils.TAG
import ninh.luyen.dds.commons.utils.addFragment

abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract fun fragment(): BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        getData()

        //add main frag
        addFragmentDefault(savedInstanceState)
    }

    private fun addFragmentDefault(savedInstanceState: Bundle?) {
        savedInstanceState ?: addFragment(R.id.container, fragment(), fragment().TAG())
    }

    open fun getData(){

    }
}