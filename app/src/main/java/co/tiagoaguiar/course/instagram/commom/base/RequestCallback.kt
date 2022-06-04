package co.tiagoaguiar.course.instagram.commom.base

interface RequestCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(message: String)
    fun onComplete()

}