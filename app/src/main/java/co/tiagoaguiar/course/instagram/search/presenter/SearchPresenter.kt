package co.tiagoaguiar.course.instagram.search.presenter

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
import co.tiagoaguiar.course.instagram.search.Search
import co.tiagoaguiar.course.instagram.search.data.SearchRepository


class SearchPresenter(
    private var view: Search.View?,
    private val repository: SearchRepository
) : Search.Presenter{

    override fun fetchUsers(name: String) {
        view?.showProgress(true)
        repository.fetchUsers(name, object : RequestCallback<List<UserAuth>>{
                override fun onSuccess(data: List<UserAuth>) {
                   if(data.isEmpty()){
                       view?.displayEmptyUsers()
                   }else{
                       view?.displayFullUsers(data)
                   }
                }

                override fun onFailure(message: String) {
                    view?.displayEmptyUsers()
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