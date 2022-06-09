package co.tiagoaguiar.course.instagram.post.presenter

import android.net.Uri
import android.util.Patterns
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Database

import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import co.tiagoaguiar.course.instagram.post.Post
import co.tiagoaguiar.course.instagram.post.data.PostRepository
import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.data.ProfileRepository
import co.tiagoaguiar.course.instagram.register.RegisterEmail
import co.tiagoaguiar.course.instagram.register.data.RegisterCallback
import co.tiagoaguiar.course.instagram.register.data.RegisterRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class PostPresenter(
    private var view: Post.View?,
    private val repository: PostRepository
) : Post.Presenter, CoroutineScope{

    private var uri: Uri? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO


    override fun fetchPictures() {

        view?.showProgress(true)
        launch{
         val pictures = repository.fetchPictures()
            withContext(Dispatchers.Main){
                if(pictures.isEmpty()){
                    view?.displayEmptyPictures()
                }else{
                    view?.displayFullPictures(pictures)
                }
                view?.showProgress(false)
            }
        }
    }


    override fun onDestroy() {
        job.cancel()
       view = null
    }

    override fun selectUri(uri: Uri) {
        this.uri = uri
    }

    override fun getSelectedUri(): Uri? {
        return uri
    }

}