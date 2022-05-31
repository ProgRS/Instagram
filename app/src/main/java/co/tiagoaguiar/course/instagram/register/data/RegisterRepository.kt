package co.tiagoaguiar.course.instagram.register.data

class RegisterRepository(private val dataSource: RegisterDataSource) {

    fun create(email: String,  callback: RegisterCallback){
        // vai ser responsavel sobre o que fzer com estes dados
        // servidor ou banco de dados local
        //pode salvar localmente algum dado
        //pode só chamar um servidor
        //pode só chamar um banco local

        dataSource.create(email, callback)


    }

    fun create(email: String, name:String, password: String , callback: RegisterCallback){

        dataSource.create(email,name, password,  callback)


    }


}