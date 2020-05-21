package tw.com.mook.hsinchutravel.ui.travel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tw.com.mook.hsinchutravel.R
import tw.com.mook.hsinchutravel.databinding.FragmentTravelBinding

class TravelFragment : Fragment() {

    private lateinit var viewModel: TravelViewModel
    private lateinit var binding: FragmentTravelBinding

    // ------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(TravelViewModel::class.java)
        binding = FragmentTravelBinding.inflate(inflater,container,false)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textTravel.text = it
        })
        return binding.root
    }

    // ------------------------------------------
}
