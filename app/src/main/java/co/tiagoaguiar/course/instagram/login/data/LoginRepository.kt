package co.tiagoaguiar.course.instagram.login.data

import javax.sql.CommonDataSource

class LoginRepository(private val dataSource: LoginDataSource) {

    fun login(email: String, password: String, callback: LoginCallback){
        // vai ser responsavel sobre o que fzer com estes dados
        // servidor ou banco de dados local
        //pode salvar localmente algum dado
        //pode só chamar um servidor
        //pode só chamar um banco local

        dataSource.login(email, password, callback)


    }

}