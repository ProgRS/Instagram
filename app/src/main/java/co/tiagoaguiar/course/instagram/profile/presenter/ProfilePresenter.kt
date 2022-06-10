package co.tiagoaguiar.course.instagram.profile.presenter

import android.util.Patterns
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.data.ProfileRepository
import co.tiagoaguiar.course.instagram.register.RegisterEmail
import co.tiagoaguiar.course.instagram.register.data.RegisterCallback
import co.tiagoaguiar.course.instagram.register.data.RegisterRepository
import java.util.*


class ProfilePresenter(
    private var view: Profile.View?,
    private val repository: ProfileRepository
) : Profile.Presenter{

    override fun clear() {
        repository.clearCache()
    }


    override fun fetchUserProfile(uuid: String?) {
        view?.showProgress(true)
            repository.fetchUserProfile(uuid, object : RequestCallback<UserAuth>{
                override fun onSuccess(data: UserAuth) {

                        view?.displayUserProfile(data)
                }

                override fun onFailure(message: String) {
                    view?.displayRequestFailure(message)
                }

                override fun onComplete() {
                    //não faz nada
                }
            })
    }




    override fun fetchUserPosts(uuid: String?) {
        val userUUID = Database.sessionAuth?.uuid ?: throw RuntimeException("user not found")
            repository.fetchUserPosts(uuid,  object : RequestCallback<List<Post>>{
                override fun onSuccess(data: List<Post>) {
                   if(data.isEmpty()){
                       view?.displayEmptyPosts()
                   }else{
                       view?.displayFullPosts(data)
                   }
                }

                override fun onFailure(message: String) {
                    view?.displayRequestFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
    }




    override fun onDestroy() {
       view = null
    }


}