package co.tiagoaguiar.course.instagram.profile.data

import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String , callback: RequestCallback<UserAuth>)

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession(): UserAuth{ throw UnsupportedOperationException()}

    fun putUser(response: UserAuth){ throw UnsupportedOperationException() }

    fun putPosts(response: List<Post>?){ throw UnsupportedOperationException() }
}