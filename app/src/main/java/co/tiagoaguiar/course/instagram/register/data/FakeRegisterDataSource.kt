package co.tiagoaguiar.course.instagram.register.data

import android.net.Uri
import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.commom.model.Photo


import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import java.util.*
import co.tiagoaguiar.course.instagram.register.data.RegisterCallback as RegisterEmailCallback

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String , callback: RegisterEmailCallback) {
         Handler(Looper.getMainLooper()).postDelayed({


             //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
      val userAuth =  Database.usersAuth.firstOrNull{ email == it.email }

            if(userAuth == null){
                callback.onSuccess()
            }else{
                callback.onFailure("Usuario já cadastrado")
            }

             callback.onComplete()
           }, 2000)
    }

    override fun create(
        email: String,
        name: String,
        password: String,
        callback: co.tiagoaguiar.course.instagram.register.data.RegisterCallback
    ) {
        Handler(Looper.getMainLooper()).postDelayed({


            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val userAuth =  Database.usersAuth.firstOrNull{ email == it.email }

             if(userAuth != null){
                    callback.onFailure("Usuário ja cadastrado")
             }else{

            val newUser = UserAuth(UUID.randomUUID().toString(), name, email, password)
                 val created = Database.usersAuth.add(newUser)

                 if(created){
                     Database.sessionAuth = newUser
                     callback.onSuccess()
                 }else{
                     callback.onFailure("Erro interno no servidor.")
                 }
             }



            callback.onComplete()
        }, 2000)
    }

    override fun updateUser(
        photoUri: Uri,
        callback: co.tiagoaguiar.course.instagram.register.data.RegisterCallback
    ) {
        Handler(Looper.getMainLooper()).postDelayed({


            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val userAuth =  Database.sessionAuth

            if(userAuth != null){
                callback.onFailure("Usuário não encontrado")
            }else{
                // val newPhoto = Photo(, protoUri)
                val newPhoto = Photo(userAuth?.uuid ?: "", photoUri)
                val created = Database.photos.add(newPhoto)

                if(created){
                    callback.onSuccess()
                }else{
                    callback.onFailure("Erro interno no servidor.")
                }
            }



            callback.onComplete()
        }, 2000)
    }

    /*
    override fun updateUser(
        photoUri: Uri,
        callback: co.tiagoaguiar.course.instagram.register.data.RegisterCallback
    ) {
        Handler(Looper.getMainLooper()).postDelayed({


            //como se fose um SQL: SELECT * FROM USER_AUTH WHERE EMAIL =?  LIMIT 1
            val userAuth =  Database.sessionAuth

            if(userAuth != null){
                callback.onFailure("Usuário não encontrado")
            }else{
                // val newPhoto = Photo(, protoUri)
                val newPhoto = Photo()
                val created = Database.photos.add(newPhoto)

                if(created){
                    callback.onSuccess()
                }else{
                    callback.onFailure("Erro interno no servidor.")
                }
            }



            callback.onComplete()
        }, 2000)
    }

     */

}