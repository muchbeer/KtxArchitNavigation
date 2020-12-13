package raum.muchbeer.ktxarchitnavigation.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import raum.muchbeer.ktxarchitnavigation.R
import raum.muchbeer.ktxarchitnavigation.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.btnDashboard.setOnClickListener {
            if(!TextUtils.isEmpty(binding.editUsername.text.toString())) {
            var bundle : Bundle = bundleOf("user_key" to binding.editUsername.text.toString())
                //kindly note on animation the toLeft : means inaanza Left and outLeft : means inaitwa kwenda Right
            it.findNavController().navigate(R.id.homeToDashboard, bundle)
            } else {
                Toast.makeText(activity, "Please enter the test", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }


}