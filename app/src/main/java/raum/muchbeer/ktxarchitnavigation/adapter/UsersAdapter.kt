package raum.muchbeer.ktxarchitnavigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import raum.muchbeer.ktxarchitnavigation.R
import raum.muchbeer.ktxarchitnavigation.model.User

class UsersAdapter (private val userList:List<User>, private val selectedItem:(User)->Unit) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context)
        val viewList  :View= view.inflate(R.layout.users_list_item, parent,false)
       return UsersViewHolder(viewList)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val listUser = userList.get(position)

       holder.bind(listUser, selectedItem)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    class UsersViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView){
        val usersData = itemView.findViewById<TextView>(R.id.txtUsers)
        val userNumber = itemView.findViewById<TextView>(R.id.txtNumber)

        fun bind( user : User, selectedItem: (User) -> Unit) {
            usersData.text = user.userName
            userNumber.text = user.order.toString()

            itemView.setOnClickListener {
                selectedItem(user)
            }
        }
    }


}