package com.utad.myappud2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class News(
    val title: String,
    val image: String,
    val description: String,
    val author: String
) : Parcelable
