package co.tiagoaguiar.course.instagram.profile.view

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.commom.base.BaseFragment
import co.tiagoaguiar.course.instagram.commom.base.DependencyInjector
import co.tiagoaguiar.course.instagram.commom.model.Post
import co.tiagoaguiar.course.instagram.commom.model.UserAuth
import co.tiagoaguiar.course.instagram.databinding.FragmentProfileBinding
import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.presenter.ProfilePresenter

class ProfileFragment
    : BaseFragment<FragmentProfileBinding ,Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
    ), Profile.View{


    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if(enabled) View.VISIBLE else View.GONE
    }

    private val adapter =PostAdapter()

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtPostsCount?.text = userAuth.postCount.toString()
        binding?.profileTxtFollowingCount?.text = userAuth.followingCount.toString()
        binding?.profileTxtFollowersCount?.text = userAuth.followersCount.toString()
        binding?.profileTxtUsername?.text = userAuth.name
        binding?.profileTxtBio?.text = "TODO"
        presenter.fetchUserPosts()

    }

    override fun displayRequestFailure(message: String) {
       Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun displayEmptyPosts() {
       binding?.profileTxtEmpty?.visibility = View.VISIBLE
        binding?.profileRv?.visibility = View.GONE
    }

    override fun displayFullPosts(posts: List<Post>) {
        binding?.profileTxtEmpty?.visibility = View.GONE
        binding?.profileRv?.visibility = View.VISIBLE
        adapter.items =posts
        adapter.notifyDataSetChanged()
    }

    override  lateinit var presenter: Profile.Presenter

    //override lateinit var  presenter: Profile.Presenter

    override fun setupPresenter() {
        val repository = DependencyInjector.profileRepository()
        presenter = ProfilePresenter(this, repository)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if(savedInstanceState != null){
          val state = savedInstanceState.getParcelable<UserAuth>("myState")
            state?.let{
                displayUserProfile(it)
            }
        }

        super.onViewStateRestored(savedInstanceState)
    }

    override fun setupViews() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(),3)
        binding?.profileRv?.adapter = adapter

        presenter.fetchUserProfile()
        presenter.fetchUserPosts()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable("myState", presenter.state)
        super.onSaveInstanceState(outState)

    }

    override fun getMenu(): Int {
        return R.menu.menu_profile
    }

}