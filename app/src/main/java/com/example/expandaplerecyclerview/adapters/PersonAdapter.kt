package com.example.expandaplerecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expandaplerecyclerview.data.model.Person
import com.example.expandaplerecyclerview.databinding.PersonCartViewBinding

class PersonAdapter(val personlist:ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val binding: PersonCartViewBinding) :RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int =personlist.size
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonAdapter.PersonViewHolder {
        val binding = PersonCartViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.PersonViewHolder, position: Int) {
        val person = personlist[position]
        holder.binding.name.text = person.name
        holder.binding.info.text = person.info

        val isExpanded : Boolean = person.isExpanded
        holder.binding.expendingCard.visibility = if (isExpanded) ViewGroup.VISIBLE else ViewGroup.GONE

       /* holder.binding.open.setOnClickListener {
            person.isExpanded = !person.isExpanded
            notifyItemChanged(position)

        }*/

        holder.binding.open.setOnClickListener {
         val acıkOlanıKapat =acıkOlanıKapat()
            if (position == acıkOlanıKapat ){
                person.isExpanded = false
            }else{
                person.isExpanded = true
                notifyItemChanged(position)
            }
        }

    }
    private fun acıkOlanıKapat():Int {
        val durum = personlist.indexOfFirst {it.isExpanded}
        if (durum != -1){
            personlist[durum].isExpanded = false
            notifyItemChanged(durum)
        }
        return durum
    }


}