package co.tiagoaguiar.course.instagram.register.data

import co.tiagoaguiar.course.instagram.commom.model.UserAuth

interface RegisterCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()

}