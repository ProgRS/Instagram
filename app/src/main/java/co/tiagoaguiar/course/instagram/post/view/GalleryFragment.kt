package co.tiagoaguiar.course.instagram.post.view

import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.BaseFragment
import co.tiagoaguiar.course.instagram.commom.base.DependencyInjector
import co.tiagoaguiar.course.instagram.databinding.FragmentGalleryBinding
import co.tiagoaguiar.course.instagram.post.Post
import co.tiagoaguiar.course.instagram.post.presenter.PostPresenter

class GalleryFragment : BaseFragment<FragmentGalleryBinding, Post.Presenter>(
    R.layout.fragment_gallery,
    FragmentGalleryBinding::bind
), Post.View{

    override lateinit var presenter: Post.Presenter

    private val adapter = PictureAdapter(){ uri ->

        binding?.galleryImgSelected?.setImageURI(uri)
        binding?.galleryNested?.smoothScrollTo(0,0)
    }

    override fun setupPresenter() {
        presenter = PostPresenter(this, DependencyInjector.postRepository(requireContext()))

    }

    override fun setupViews() {
        binding?.galleryRv?.layoutManager = GridLayoutManager(requireContext(),3)
        binding?.galleryRv?.adapter = adapter

        presenter.fetchPictures()
        // presenter.fetchUserPosts()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.galleryProgress?.visibility = if(enabled) View.VISIBLE else View.GONE
    }

    override fun displayFullPictures(posts: List<Uri>) {
        binding?.galleryTxtEmpty?.visibility = View.GONE
        binding?.galleryRv?.visibility = View.VISIBLE
        adapter.items =posts
        adapter.notifyDataSetChanged()
        binding?.galleryImgSelected?.setImageURI(posts.first())
        binding?.galleryNested?.smoothScrollTo(0,0)

    }

    override fun displayEmptyPictures() {
        binding?.galleryTxtEmpty?.visibility = View.VISIBLE
        binding?.galleryRv?.visibility = View.GONE
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


}