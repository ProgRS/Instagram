package co.tiagoaguiar.course.instagram.profile.data

import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class FireProfileDataSource : ProfileDataSource {
    override fun fetchUserProfile(
        userUUID: String,
        callback: RequestCallback<Pair<UserAuth, Boolean?>>
    ) {
        TODO("Not yet implemented")
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        TODO("Not yet implemented")
    }

    
}