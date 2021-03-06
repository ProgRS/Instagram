package co.tiagoaguiar.course.instagram.commom.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class User(
    val uuid: String? = null,
    val name: String? = null,
    val email: String? = null,
    val photoUrl: String? = null,
    val postCount: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,

    )
