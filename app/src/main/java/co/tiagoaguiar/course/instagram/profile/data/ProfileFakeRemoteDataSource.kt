package co.tiagoaguiar.course.instagram.profile.data

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.User
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class ProfileFakeRemoteDataSource : ProfileDataSource {
    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<Pair<User, Boolean?>>)  {

        Handler(Looper.getMainLooper()).postDelayed({




            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val userAuth =  Database.usersAuth.firstOrNull{ userUUID == it.uuid }

            if(userAuth != null){
                if(userAuth == Database.sessionAuth){
                   // TODO PARA REMOVER ESTA CLASSE callback.onSuccess(Pair(userAuth, null))
                }else{
                    val followings = Database.followers[Database.sessionAuth!!.uuid]

                    val destUser = followings?.firstOrNull{it == userUUID}


                   // TODO PARA REMOVER ESTA CLASSE callback.onSuccess(Pair(userAuth, destUser != null ))
                }

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


    override fun followUser(
        userUUID: String,
        isFollow: Boolean,
        callback: RequestCallback<Boolean>
    ) {
        Handler(Looper.getMainLooper()).postDelayed({
        var followers = Database.followers[Database.sessionAuth!!.uuid]
            if(followers == null){
                followers = mutableSetOf()
                Database.followers[Database.sessionAuth!!.uuid] = followers
            }

            if(isFollow){
                Database.followers[Database.sessionAuth!!.uuid]!!.add(userUUID)
            }else{
                Database.followers[Database.sessionAuth!!.uuid]!!.remove(userUUID)
            }

            callback.onSuccess(true)
            callback.onComplete()

        }, 500)
    }

}