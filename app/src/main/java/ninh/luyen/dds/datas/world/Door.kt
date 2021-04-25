package ninh.luyen.dds.datas.world

/**
 * Created by luyen_ninh on 4/25/21.
 */
object Door {

    private external fun openMainDoor(): String
    @JvmStatic
    val keyMainDoor: String
        get() = openMainDoor()

    init {
        System.loadLibrary("native-lib")
    }
}