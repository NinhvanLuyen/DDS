package ninh.luyen.dds.datas.remotes.responses

/**
 * Created by luyen_ninh on 4/23/21.
 */
data class SearchCacheModel(
    val query: String,
    val searchResponseModel: SearchResponseModel
):BaseModel()