package co.tiagoaguiar.course.instagram.add.data

import android.net.Uri
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*

interface AddDataSource {

    fun createPost(userUUID: String, uri: Uri, caption: String, callback: RequestCallback<Boolean>) { throw UnsupportedOperationException()}

    fun fetchSession(): String { throw UnsupportedOperationException()}
}