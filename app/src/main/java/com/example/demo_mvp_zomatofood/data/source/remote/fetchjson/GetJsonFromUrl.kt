@file:Suppress("DEPRECATION")

package com.example.demo_mvp_zomatofood.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.demo_mvp_zomatofood.data.source.remote.OnFetchDataListener
import org.json.JSONObject

@Suppress("DEPRECATION")
class GetJsonFromUrl<T>(
    private val listener: OnFetchDataListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJonFromUrl(params[0])
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null && data.isNotBlank()) {
            val jsonObject = JSONObject(data)
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T)
        } else listener.onError(exception)
    }
}
