package uz.datatalim.notes.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.datatalim.notes.Adapters.HomeAdapter
import uz.datatalim.notes.DataBase.Remote.ApiClient
import uz.datatalim.notes.Models.Note
import uz.datatalim.notes.R
import uz.datatalim.notes.databinding.FragmentHomeScreenBinding

class HomeScreen : Fragment() {

    lateinit var binding: FragmentHomeScreenBinding
    lateinit var homeAdapter:HomeAdapter
    lateinit var notes:ArrayList<Note>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        loadNotes()
        homeAdapter= HomeAdapter()
        notes=ArrayList()
        binding.rvHome.adapter=HomeAdapter()
        binding.rvHome.layoutManager=LinearLayoutManager(requireContext())
        homeAdapter.submitList(notes)

        binding.btnAddHome.setOnClickListener {

            findNavController().navigate(R.id.action_homeScreen2_to_addNotes)

        }

    }

    private fun loadNotes() {

        ApiClient.api_servis.getAllNotes().enqueue(object :Callback<ArrayList<Note>>{
            override fun onResponse(
                call: Call<ArrayList<Note>>,
                response: Response<ArrayList<Note>>
            ) {

                if (response.isSuccessful){

                    notes.clear()
                    notes.addAll(response.body()!!)
                    homeAdapter.submitList(notes)

                }

            }

            override fun onFailure(call: Call<ArrayList<Note>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}