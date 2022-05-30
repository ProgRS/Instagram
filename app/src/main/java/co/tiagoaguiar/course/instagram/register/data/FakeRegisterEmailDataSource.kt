package co.tiagoaguiar.course.instagram.register.data

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.commom.model.Database
import co.tiagoaguiar.course.instagram.register.data.RegisterEmailCallback as RegisterEmailCallback

class FakeRegisterEmailDataSource : RegisterEmailDataSource {
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


}