package ninh.luyen.dds.datas.cache.models

import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel

/**
 * Created by luyen_ninh on 4/25/21.
 */
data class SearchCache(
    val query: String,
    val searchResponseModel: SearchResponseModel
)