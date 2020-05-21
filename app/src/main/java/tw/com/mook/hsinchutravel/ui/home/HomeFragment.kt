package tw.com.mook.hsinchutravel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_home.*
import tw.com.mook.hsinchutravel.databinding.FragmentHomeBinding
import tw.com.mook.hsinchutravel.other.ViewModelProviderFactory
import tw.com.mook.hsinchutravel.other.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    // ------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
        viewModel.setNavigator(this)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        viewModel.connectIndex()
    }

    // ------------------------------------------
    private fun initView() {
        viewModel.getTitle().observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
    }

    // ------------------------------------------
}
