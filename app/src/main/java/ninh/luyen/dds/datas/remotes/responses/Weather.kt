package ninh.luyen.dds.datas.remotes.responses

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
):BaseModel()