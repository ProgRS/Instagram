package co.tiagoaguiar.course.instagram.register.data

import co.tiagoaguiar.course.instagram.login.data.LoginCallback
import javax.sql.CommonDataSource

class RegisterEmailRepository(private val dataSource: RegisterEmailDataSource) {

    fun create(email: String,  callback: RegisterEmailCallback){
        // vai ser responsavel sobre o que fzer com estes dados
        // servidor ou banco de dados local
        //pode salvar localmente algum dado
        //pode só chamar um servidor
        //pode só chamar um banco local

        dataSource.create(email, callback)


    }

}