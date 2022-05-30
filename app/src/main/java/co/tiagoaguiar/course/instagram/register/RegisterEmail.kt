package co.tiagoaguiar.course.instagram.register

import androidx.annotation.StringRes
import co.tiagoaguiar.course.instagram.commom.base.BasePresenter
import co.tiagoaguiar.course.instagram.commom.base.BaseView
import java.lang.Error

interface RegisterEmail {

    interface Presenter : BasePresenter{
            fun create(email: String)
    }

    interface View: BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int? )


    fun onEmailFailure(message: String)

    fun goToNameAndPasswordScreen(email: String)
    }

}
