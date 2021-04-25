package ninh.luyen.dds.datas.remotes.responses

data class FeelLike(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
):BaseModel()