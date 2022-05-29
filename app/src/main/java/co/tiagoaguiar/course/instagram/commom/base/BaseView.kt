package co.tiagoaguiar.course.instagram.commom.base

import co.tiagoaguiar.course.instagram.login.Login

interface BaseView<T> {
    var presenter: T
}