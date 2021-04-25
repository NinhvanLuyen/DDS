package ninh.luyen.dds

import ninh.luyen.dds.commons.BaseActivity
import ninh.luyen.dds.ui.homes.HomeFragment

/**
 * Created by luyen_ninh on 4/19/21.
 */
class HomeActivity:BaseActivity(){
    override fun layoutId(): Int {
        return R.layout.home_activity
    }

    override fun fragment() = HomeFragment()

}