package co.tiagoaguiar.course.instagram.add.data

import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.UserAuth

class AddLocalDataSource : AddDataSource{
    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw  RuntimeException("Usuario não logado!!")
    }
}