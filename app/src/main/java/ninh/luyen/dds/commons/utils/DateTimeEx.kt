package ninh.luyen.dds.commons.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by luyen_ninh on 4/21/21.
 */
fun Int.toTimeFromSeconds(): String {
    val dateTime = Date(this * 1000L)
    return SimpleDateFormat("EEE, dd MMM yyyy", Locale.US).format(dateTime)
}

fun Long.isInTime(debounce: Long): Boolean {
    if (this + (debounce * 1000) <= System.currentTimeMillis())
        return false
    return true


}
