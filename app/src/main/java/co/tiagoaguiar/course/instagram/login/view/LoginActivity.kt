package co.tiagoaguiar.course.instagram.login.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.util.TxtWatcher
import co.tiagoaguiar.course.instagram.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding =  ActivityLoginBinding.inflate(layoutInflater)

    setContentView(binding.root)

    with(binding) {
         loginEditEmail.addTextChangedListener(watcher)
         loginEditPassword.addTextChangedListener(watcher)

         loginBtnEnter.setOnClickListener {
         loginBtnEnter.showProgress(true)

         loginEditEmailInput.error = "Esse e-mail é invalido"

         loginEditPasswordInput.error = "Senha Incorreta"

        Handler(Looper.getMainLooper()).postDelayed({
           loginBtnEnter.showProgress(false)
         }, 2000)
        }
      }
    }



  private val watcher = TxtWatcher{

      binding.loginBtnEnter.isEnabled = it.isNotEmpty()

  }
}