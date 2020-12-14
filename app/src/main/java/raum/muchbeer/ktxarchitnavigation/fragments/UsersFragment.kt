package raum.muchbeer.ktxarchitnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import raum.muchbeer.ktxarchitnavigation.R
import raum.muchbeer.ktxarchitnavigation.adapter.UsersAdapter
import raum.muchbeer.ktxarchitnavigation.model.User


class UsersFragment : Fragment() {

    val userList = listOf(User("muchbeer", 2), User("katoo",5), User("mpabwa", 78),
                                User("mamaG", 34), User("G", 16), User("msabado", 98), User("mtalimbo", 21))

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

       val view : View = inflater.inflate(R.layout.fragment_users, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = UsersAdapter(userList, {selectedItem : User-> listDisplayed(selectedItem)})
        return view
    }

    private fun listDisplayed( user : User) {
        Toast.makeText(activity, "Selected item user has ordered ${user.order}", Toast.LENGTH_LONG).show()

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UsersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsersFragment().apply {
                arguments = Bundle().apply {
                  //  putString(ARG_PARAM1, param1)
                 //   putString(ARG_PARAM2, param2)
                }
            }
    }
}