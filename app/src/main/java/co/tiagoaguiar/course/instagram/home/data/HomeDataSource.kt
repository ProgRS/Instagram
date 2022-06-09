package co.tiagoaguiar.course.instagram.home.data

import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*

interface HomeDataSource {



    fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession(): UserAuth{ throw UnsupportedOperationException()}

    fun putFeed(response: List<Post>?){ throw UnsupportedOperationException() }
}