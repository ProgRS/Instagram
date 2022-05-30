package co.tiagoaguiar.course.instagram.register.data

import co.tiagoaguiar.course.instagram.login.Login
import co.tiagoaguiar.course.instagram.login.data.LoginCallback
import co.tiagoaguiar.course.instagram.register.RegisterEmail
import javax.security.auth.callback.Callback

interface RegisterEmailDataSource {

    fun create(email:String, callback: RegisterEmailCallback)
}