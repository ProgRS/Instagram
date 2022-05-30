package co.tiagoaguiar.course.instagram.commom.base

import co.tiagoaguiar.course.instagram.login.data.FakeDataSource
import co.tiagoaguiar.course.instagram.login.data.LoginRepository
import co.tiagoaguiar.course.instagram.register.RegisterEmail
import co.tiagoaguiar.course.instagram.register.data.FakeRegisterEmailDataSource
import co.tiagoaguiar.course.instagram.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailReposotory() : RegisterEmailRepository{
            return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }
}