package tw.com.mook.hsinchutravel.ui.nearby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tw.com.mook.hsinchutravel.R
import tw.com.mook.hsinchutravel.databinding.FragmentNearbyBinding

class NearbyFragment : Fragment() {

    private lateinit var viewModel: NearbyViewModel
    private lateinit var binding: FragmentNearbyBinding

    // ------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(NearbyViewModel::class.java)
        binding = FragmentNearbyBinding.inflate(inflater,container,false)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNearby.text = it
        })

        return binding.root
    }

    // ------------------------------------------
}
