package co.tiagoaguiar.course.instagram.search.data

import co.tiagoaguiar.course.instagram.commom.base.RequestCallback
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import co.tiagoaguiar.course.instagram.search.Search
import java.util.*

class SearchRepository(private val dataSource: SearchDataSource) {

    fun fetchUsers( name: String, callback: RequestCallback<List<UserAuth>>){
        dataSource.fetchUsers(name, object :RequestCallback<List<UserAuth>>{
            override fun onSuccess(data: List<UserAuth>) {
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
}