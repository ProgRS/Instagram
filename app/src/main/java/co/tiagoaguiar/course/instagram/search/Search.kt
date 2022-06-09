package co.tiagoaguiar.course.instagram.search

import co.tiagoaguiar.course.instagram.commom.base.BasePresenter
import co.tiagoaguiar.course.instagram.commom.base.BaseView

interface Search {
    interface Presenter: BasePresenter { }
     interface View : BaseView<Presenter>{}
}