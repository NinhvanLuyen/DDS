package ninh.luyen.dds.datas.remotes.responses

data class Temp(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
) : BaseModel() {
    fun getAvg() =
        String.format("%.0f", (day + night + eve + morn) / 4)
}