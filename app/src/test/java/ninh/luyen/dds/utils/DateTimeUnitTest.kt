package ninh.luyen.dds.utils

import ninh.luyen.dds.commons.utils.isInTime
import ninh.luyen.dds.commons.utils.toTimeFromSeconds
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateTimeUnitTest {

    @Test
    fun `convert seconds to date time`() {
        val input = 1619236800
        val expect = "Sat, 24 Apr 2021"
        assertEquals(expect, input.toTimeFromSeconds())
    }

    @Test
    fun `check is current in time`(){
        //10s before
        val lastTime = System.currentTimeMillis() - (10 * 1000)
        assertEquals(lastTime.isInTime(11),true)
    }
}