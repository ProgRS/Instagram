package co.tiagoaguiar.course.instagram.profile.data

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class ProfileFakeRemoteDataSource : ProfileDataSource {
    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {

        Handler(Looper.getMainLooper()).postDelayed({


            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val userAuth =  Database.usersAuth.firstOrNull{ userUUID == it.uuid }

            if(userAuth != null){
                callback.onSuccess(userAuth)
            }else{
                callback.onFailure("Usuario não encontrado")
            }

            callback.onComplete()
        }, 2000)
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({


            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val posts =  Database.posts[userUUID]


                callback.onSuccess(posts?.toList() ?: emptyList())


            callback.onComplete()
        }, 2000)
    }


}