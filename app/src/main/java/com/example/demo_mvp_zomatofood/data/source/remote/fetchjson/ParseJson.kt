package com.example.demo_mvp_zomatofood.data.source.remote.fetchjson

import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.model.FoodEntry
import org.json.JSONObject

class ParseJson {

    fun foodParseJson(jsonObject: JSONObject): Food {
        return Food(
            title = jsonObject.getString(FoodEntry.TITLE),
            description = jsonObject.getString(FoodEntry.DESCRIPTION),
            imageUrl = jsonObject.getString(FoodEntry.IMAGE_URL)
        )
    }
}
