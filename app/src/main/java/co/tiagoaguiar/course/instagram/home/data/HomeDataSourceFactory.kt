package co.tiagoaguiar.course.instagram.home.data

import co.tiagoaguiar.course.instagram.commom.base.Cache
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class HomeDataSourceFactory(

    private val feefCache: Cache<List<Post>>,
) {

    fun createLocalDataSource(): HomeDataSource{
            return HomeLocalDataSource(feefCache)
    }

    fun createFromFeed(): HomeDataSource{
        if (feefCache.isCached()){
            return HomeLocalDataSource(feefCache)
        }
        return FireHomeDataSource()
    }
}