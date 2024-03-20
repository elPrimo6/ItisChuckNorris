package ru.epetrashko.itischucknorris.response

import com.google.gson.annotations.SerializedName

/**
 * @author e.petrashko
 */
data class JokeResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("created_at")
    val createdTime: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("value")
    val value: String
)
