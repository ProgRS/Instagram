package co.tiagoaguiar.course.instagram.profile.data

import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.User
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*

class ProfileRepository(private val dataSourceFactory: ProfileDataSourceFactory) {

    fun clearCache(){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        localDataSource.putPosts(null)
        localDataSource.putUser(null)
    }

    fun fetchUserProfile(uuid: String?, callback: RequestCallback<Pair<User, Boolean?>>){
           val localDataSource = dataSourceFactory.createLocalDataSource()
           val userId = uuid ?: localDataSource.fetchSession()
            //val dataSource = dataSourceFactory.createFromPosts()
             val dataSource = dataSourceFactory.createFromUser(uuid)

            dataSource.fetchUserProfile(userId , object : RequestCallback<Pair<User, Boolean?>>{
                override fun onSuccess(data: Pair<User, Boolean?>) {
                    if(uuid == null) {
                        localDataSource.putUser(data)
                    }
                    callback.onSuccess(data)
                }

                override fun onFailure(message: String) {
                    callback.onFailure(message)
                }

                override fun onComplete() {
                     callback.onComplete()
                }

            })


    }
    fun fetchUserPosts(uuid: String?, callback: RequestCallback<List<Post>>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userId = uuid ?: localDataSource.fetchSession()
        val dataSource = dataSourceFactory.createFromUser(uuid)

        dataSource.fetchUserPosts(userId, object :RequestCallback<List<Post>>{
            override fun onSuccess(data: List<Post>) {
                if(uuid == null) {
                    localDataSource.putPosts(data)
                }
                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }

            override fun onComplete() {
                callback.onComplete()
            }

        })
    }

    fun followUser(uuid: String?, follow: Boolean, calback:RequestCallback<Boolean>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userId = uuid ?: localDataSource.fetchSession()
        val dataSource = dataSourceFactory.createRemoteDataSource()

        dataSource.followUser(userId, follow, object : RequestCallback<Boolean> {
            override fun onSuccess(data: Boolean) {
                    calback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                calback.onFailure(message)
            }

            override fun onComplete() {
                calback.onComplete()
            }

        })
    }

}