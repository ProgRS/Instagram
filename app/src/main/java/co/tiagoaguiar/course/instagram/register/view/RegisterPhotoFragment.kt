package co.tiagoaguiar.course.instagram.register.view

import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.DependencyInjector
import co.tiagoaguiar.course.instagram.commom.view.CropperImageFragment
import co.tiagoaguiar.course.instagram.commom.view.CustomDialog
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterPhotoBinding
import co.tiagoaguiar.course.instagram.register.RegisterPhoto
import co.tiagoaguiar.course.instagram.register.presentation.RegisterPhotoPresenter

class RegisterPhotoFragment  : Fragment( R.layout.fragment_register_photo), RegisterPhoto.View{

    private var binding: FragmentRegisterPhotoBinding? =null
    private var fragmentAttachListener: FragmentAttachListener? = null
    override lateinit var presenter: RegisterPhoto.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cropKey"){ requestKey, bundle ->
            val uri = bundle.getParcelable<Uri>(CropperImageFragment.KEY_URI)
            onCropImageResult(uri)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding =FragmentRegisterPhotoBinding.bind(view)

        val repository = DependencyInjector.registerEmailReposotory()

        presenter = RegisterPhotoPresenter(this, repository)

        binding?.let {
            with(it){
                registerBtnJump.setOnClickListener{
                    fragmentAttachListener?.goToMainScreen()
                }
                registerBtnNext.isEnabled =true
                registerBtnNext.setOnClickListener{
                    openDialog()


                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListener){
            fragmentAttachListener = context
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerBtnNext?.showProgress(enabled)
    }

    override fun onUpdateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onUpdateSuccess() {
        fragmentAttachListener?.goToMainScreen()
    }



    private fun openDialog(){

        val customDialog = CustomDialog(requireContext())


        customDialog.addButton(R.string.photo, R.string.gallery){
            when(it.id){
                R.string.photo -> {
                   fragmentAttachListener?.goToCameraScreen()
                }

                R.string.gallery -> {
                    fragmentAttachListener?.goToGalleryScreen()
                }
            }
        }

        customDialog.show();

    }

    private fun onCropImageResult(uri: Uri?){
        if(uri != null){
          val bitmap =  if(Build.VERSION.SDK_INT >= 28) {
                val source = ImageDecoder.createSource(requireContext().contentResolver, uri)
                 ImageDecoder.decodeBitmap(source)

            }else{
                MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)

            }
            binding?.registerImgProfile?.setImageBitmap(bitmap)

            presenter.updateUser(uri)
        }
    }

    override fun onDestroy() {

        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }



}