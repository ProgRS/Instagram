package co.tiagoaguiar.course.instagram.register.view

interface FragmentAttachListener {

   fun gotoNameAndPasswordScreen(email: String)
   fun goToWelcomeScreen(name: String)
   fun goToPhotoScreen()
   fun goToMainScreen()
}