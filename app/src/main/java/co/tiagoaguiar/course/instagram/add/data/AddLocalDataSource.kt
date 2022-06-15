package co.tiagoaguiar.course.instagram.add.data

import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import com.google.firebase.auth.FirebaseAuth

class AddLocalDataSource : AddDataSource{
    override fun fetchSession(): String {
        return  FirebaseAuth.getInstance().uid ?: throw  RuntimeException("Usuario não logado!!")
    }
}