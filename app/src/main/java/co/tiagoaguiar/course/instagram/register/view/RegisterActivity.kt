package co.tiagoaguiar.course.instagram.register.view;

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle

import co.tiagoaguiar.course.instagram.R;
import co.tiagoaguiar.course.instagram.databinding.ActivityRegisterBinding

public class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setContentView(R.layout.activity_register)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.register_fragment, fragment)
            commit()
        }
    }


}