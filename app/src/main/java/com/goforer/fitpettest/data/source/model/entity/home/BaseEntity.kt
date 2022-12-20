package com.goforer.fitpettest.data.source.model.entity.home

import com.google.gson.Gson
import com.google.gson.GsonBuilder

open class BaseEntity {
    companion object {
        private fun gsonBuilder(): GsonBuilder {
            val builder = GsonBuilder()
            builder.serializeNulls()

            return builder
        }

        fun gson(): Gson {
            val builder = gsonBuilder()

            return builder.create()
        }

        fun <Type> deepCopy(`object`: Type, type: Class<Type>): Type? {
            return try {
                gson().fromJson(gson().toJson(`object`, type), type)
            } catch (e: Exception) {
                e.printStackTrace()

                null
            }
        }
    }
}