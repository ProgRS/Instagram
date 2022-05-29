package co.tiagoaguiar.course.instagram.login.data

import co.tiagoaguiar.course.instagram.login.Login
import javax.security.auth.callback.Callback

interface LoginDataSource {

    fun login(email:String, password: String, callback: LoginCallback)
}