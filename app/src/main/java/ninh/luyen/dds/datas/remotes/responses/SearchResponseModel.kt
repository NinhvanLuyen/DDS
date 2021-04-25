package ninh.luyen.dds.datas.remotes.responses

data class SearchResponseModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val message: Double,
    val list: List<Detail>
) : BaseModel()