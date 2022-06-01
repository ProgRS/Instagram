package co.tiagoaguiar.course.instagram.commom.extension
import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import co.tiagoaguiar.course.instagram.register.RegisterNameAndPassword

fun Activity.hideKeyboard(){
            val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view: View? =currentFocus

            if(view == null){
                view = View(this)
            }

            imm.hideSoftInputFromWindow(view.windowToken, 0 )
}
