package co.tiagoaguiar.course.instagram.profile

import co.tiagoaguiar.course.instagram.commom.base.BasePresenter
import co.tiagoaguiar.course.instagram.commom.base.BaseView
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.User
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*

interface Profile {

    interface Presenter: BasePresenter{
        fun fetchUserProfile(uuid: String?)
        fun fetchUserPosts(uuid: String?)
        fun followUser(uuid: String?, follow: Boolean)
        fun clear()

    }

    interface View: BaseView<Presenter>{
            fun showProgress(enabled: Boolean)
            fun displayUserProfile(user: Pair<User, Boolean?>)
            fun displayRequestFailure(message: String)
            fun displayEmptyPosts()
            fun displayFullPosts(posts: List<Post>)
    }
}