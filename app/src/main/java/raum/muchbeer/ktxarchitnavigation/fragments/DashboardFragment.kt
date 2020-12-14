package raum.muchbeer.ktxarchitnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import raum.muchbeer.ktxarchitnavigation.R
import raum.muchbeer.ktxarchitnavigation.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

private lateinit var binding : FragmentDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)

      // var receiveInput =  arguments!!.getString("user_key")
        val receiveInput : String? = requireArguments()!!.getString("user_key")
        binding.txtDisplay.text = receiveInput.toString()

        binding.btnUsers.setOnClickListener {
            it.findNavController().navigate(R.id.dashboardToUsers)
        }
        return binding.root
    }

}