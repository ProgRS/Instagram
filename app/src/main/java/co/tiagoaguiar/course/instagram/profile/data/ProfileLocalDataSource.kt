package co.tiagoaguiar.course.instagram.profile.data

import co.tiagoaguiar.course.instagram.commom.base.Cache
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class ProfileLocalDataSource(
    private val profileCache: Cache<UserAuth>,
    private val postsCache: Cache<List<Post>>,
) : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        val userAuth = profileCache.get(userUUID)
        if (userAuth != null) {
            callback.onSuccess(userAuth)
        } else {
            callback.onFailure("Usuário não encontrado")
        }
        callback.onComplete()
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = postsCache.get(userUUID)
        if (posts != null) {
            callback.onSuccess(posts)
        } else {
            callback.onFailure("posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("usuário não logado!!!")
    }

    override fun putUser(response: UserAuth) {
        profileCache.put(response)
    }

    override fun putPosts(response: List<Post>?) {
        postsCache.put(response)
    }

}