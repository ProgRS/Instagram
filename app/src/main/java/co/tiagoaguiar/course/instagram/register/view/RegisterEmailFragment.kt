package co.tiagoaguiar.course.instagram.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.DependencyInjector
import co.tiagoaguiar.course.instagram.commom.util.TxtWatcher
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterEmailBinding
import co.tiagoaguiar.course.instagram.register.RegisterEmail
import co.tiagoaguiar.course.instagram.register.presentation.RegisterEmailPresenter

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View{

    private var binding: FragmentRegisterEmailBinding? = null
    private var fragmentAttachListener : FragmentAttachListener?= null

    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)

        val repository = DependencyInjector.registerEmailReposotory()
        presenter = RegisterEmailPresenter(this, repository)

        binding?.let {
            with(it){
                registerTxtLogin.setOnClickListener(){
                    activity?.finish()
                }

                registerBtnNext.setOnClickListener(){
                    presenter.create(
                        registerEditEmail.text.toString()
                    )
                }

                registerEditEmail.addTextChangedListener(watcher)
                registerEditEmail.addTextChangedListener(TxtWatcher{
                        displayEmailFailure(null)
                })

            }
        }

        // buscar referencias

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListener){
                fragmentAttachListener = context
        }
    }



    override fun onDestroy() {
        binding = null
        fragmentAttachListener = null
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher{

        binding?.registerBtnNext?.isEnabled = binding?.registerEditEmail?.text.toString().isNotEmpty()


    }

    override fun showProgress(enabled: Boolean) {
       binding?.registerBtnNext?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
            binding?.registerEditEmailInput?.error = emailError?.let{ getString(it)}

    }

    override fun onEmailFailure(message: String) {
        binding?.registerEditEmailInput?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {
        // depois mandar pra proximo fragment
        fragmentAttachListener?.gotoNameAndPasswordScreen(email)
    }


}