package uz.datatalim.notes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.notes.Models.HomeModel
import uz.datatalim.notes.R

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var onClick:((Int)->Unit)?=null
    val notes:ArrayList<HomeModel> = ArrayList()

    fun submitList(list:ArrayList<HomeModel>){

        this.notes.clear()
        this.notes.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false))

    }

    override fun getItemCount(): Int =notes.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val notes=notes[position]

        holder.apply {

            tvText.text=notes.text
            llItemHome.setBackgroundResource(notes.color)

        }

    }

    class HomeViewHolder(view: View):RecyclerView.ViewHolder(view){

        val tvText:TextView=view.findViewById(R.id.tvText_item_home)
        val llItemHome:LinearLayout=view.findViewById(R.id.llItemHome)

    }

}