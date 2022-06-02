package co.tiagoaguiar.course.instagram.splash.data

import co.tiagoaguiar.course.instagram.register.data.RegisterCallback

interface SplashDataSource {

    fun session(callback: SplashCallback){

    }
}