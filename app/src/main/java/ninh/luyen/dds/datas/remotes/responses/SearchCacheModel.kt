package ninh.luyen.dds.datas.remotes.responses

import ninh.luyen.dds.commons.utils.inTime

/**
 * Created by luyen_ninh on 4/23/21.
 */
data class SearchCacheModel(
    val query: String,
    val timeRequest: Long = 0,
    val searchResponseModel: SearchResponseModel?
) : BaseModel() {

    /**
     * @param currentQuery meaning query is searching
     * @param debounceTime Unit is TimeUnit.SECOND
     * meaning in this time you don't need search more if it same query
     */
    fun isSameQuery(currentQuery: String, debounceTime:Long): Boolean {
        if (this.query != currentQuery)
            return false
        if (this.timeRequest.inTime(debounceTime))
            return true
        return false


    }
}