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
