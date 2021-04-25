package ninh.luyen.dds.datas.cache

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ninh.luyen.dds.BuildConfig
import ninh.luyen.dds.commons.utils.TAG
import ninh.luyen.dds.datas.remotes.responses.SearchCacheModel
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import java.lang.Exception
import java.text.ParseException

/**
 * Created by luyen_ninh on 4/23/21.
 */
class CacheSharedPreferences(
    private val context: Context,
    private val gson: Gson
) {

    companion object {
        private const val CACHE_SEARCH_RESULT = "CACHE_SEARCH_RESULT"
    }

    private val sp by lazy {
        context.getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            Context.MODE_PRIVATE
        )
    }

    suspend fun saveSearchResult(result: SearchCacheModel) {
        withContext(Dispatchers.IO)
        {

            val data = gson.toJson(result)
            sp.edit {
                putString(CACHE_SEARCH_RESULT, data)
                apply()
            }
        }
    }

    suspend fun getCacheSearchResult(): SearchCacheModel? {
        return withContext(Dispatchers.IO) {
            val localResult = sp.getString(CACHE_SEARCH_RESULT, "")
            try {
                gson.fromJson<SearchCacheModel>(localResult, SearchCacheModel::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    }

}