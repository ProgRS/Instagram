package co.tiagoaguiar.course.instagram.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.view.CustomDialog
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment  : Fragment( R.layout.fragment_register_photo){

    private var binding: FragmentRegisterPhotoBinding? =null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding =FragmentRegisterPhotoBinding.bind(view)

        val customDialog = CustomDialog(requireContext())

      //  customDialog.addButton({

     //   }, R.string.photo, R.string.gallery, R.string.app_name)

       // customDialog.setTitle(R.string.app_name)
        customDialog.addButton(R.string.photo, R.string.gallery){
            when(it.id){
                R.string.photo -> {
                    //aqui sera possivel abrir a camera
                }

                R.string.gallery -> {
                   //aqui sera possivel abrir a galeria
                }
            }
        }

        customDialog.show();
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}