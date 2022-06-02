package co.tiagoaguiar.course.instagram.commom.model

import android.net.Uri
import java.sql.Timestamp
import java.util.*

data class Post(
    val uuid: String,
    val uri: Uri,
    val caption: String,
    val timestamp: Long
)
