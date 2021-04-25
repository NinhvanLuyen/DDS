package ninh.luyen.dds.datas.remotes.responses

data class Detail(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val feelLike: FeelLike,
    val weather: List<Weather>,
    val pressure: Int,
    val humidity: Int
) : BaseModel()
