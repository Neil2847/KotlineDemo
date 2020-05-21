package tw.com.mook.hsinchutravel.ui.others

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_others.*

import tw.com.mook.hsinchutravel.databinding.FragmentOthersBinding

class OthersFragment : Fragment() {

    private lateinit var viewModel: OthersViewModel
    private lateinit var binding: FragmentOthersBinding

    // ------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(OthersViewModel::class.java)
        binding = FragmentOthersBinding.inflate(inflater,container,false)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textOthers.text = it
        })
        return binding.root
    }

    // ------------------------------------------
}
