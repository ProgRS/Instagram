package co.tiagoaguiar.course.instagram.profile.view

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.BaseFragment
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import co.tiagoaguiar.course.instagram.databinding.FragmentProfileBinding

class ProfileFragment
    : BaseFragment<FragmentProfileBinding ,Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
    ), Profile.View{
    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if(enabled) View.VISIBLE else View.GONE
    }

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtPostsCount?.text = userAuth.postCount.toString()
        binding?.profileTxtFollowingCount?.text = userAuth.followingCount.toString()
        binding?.profileTxtFollowersCount?.text = userAuth.followersCount.toString()
        binding?.profileTxtUsername?.text = userAuth.name
        binding?.profileTxtBio?.text = "TODO"
    }

    override fun displayRequestFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun displayEmptyPosts() {
        TODO("Not yet implemented")
    }

    override fun displayFullPosts(posts: List<Post>) {
        TODO("Not yet implemented")
    }

    override  lateinit var presenter: Profile.Presenter

    //override lateinit var  presenter: Profile.Presenter

    override fun setupPresenter() {
        // TODO:  presenter= ProfilePresenter(this, repository)
    }

    override fun setupViews() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(),3)
        binding?.profileRv?.adapter = PostAdapter()

        presenter.fetchUserProfile()
        presenter.fetchUserPosts()
    }

    override fun getMenu(): Int {
        return R.menu.menu_profile
    }

}