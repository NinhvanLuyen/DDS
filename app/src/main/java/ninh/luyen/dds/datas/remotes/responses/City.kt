package ninh.luyen.dds.datas.remotes.responses

data class City(
    val coord: Coordinator,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
):BaseModel()