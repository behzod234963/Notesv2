package uz.datatalim.notes.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.datatalim.notes.Adapters.HomeAdapter
import uz.datatalim.notes.Models.HomeModel
import uz.datatalim.notes.R
import uz.datatalim.notes.databinding.FragmentHomeScreenBinding

class HomeScreen : Fragment() {

    lateinit var binding: FragmentHomeScreenBinding
    lateinit var homeAdapter:HomeAdapter
    lateinit var notes:ArrayList<HomeModel>

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
        binding.rvHome.adapter=HomeAdapter()
        binding.rvHome.layoutManager=LinearLayoutManager(requireContext())

        binding.btnAddHome.setOnClickListener {

            findNavController().navigate(R.id.action_homeScreen2_to_addNotes)

        }

    }

    private fun loadNotes() {

        notes=ArrayList()

    }
}