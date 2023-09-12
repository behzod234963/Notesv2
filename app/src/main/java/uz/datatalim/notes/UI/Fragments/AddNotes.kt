package uz.datatalim.notes.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.datatalim.notes.DataBase.Remote.ApiClient
import uz.datatalim.notes.Models.Note
import uz.datatalim.notes.R
import uz.datatalim.notes.databinding.FragmentAddNotesBinding

class AddNotes : Fragment() {

    lateinit var binding: FragmentAddNotesBinding
    lateinit var notes:ArrayList<Note>
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAddNotesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        notes=ArrayList()
        val title=binding.etTitleAdd.text
        val text=binding.etText.text
        navController= NavController(requireContext())

        binding.ivSaveAdd.setOnClickListener {

            saveNote(Note(title.toString(),text.toString(),null))
            findNavController().navigate(R.id.action_addNotes_to_homeScreen2)
            navController.popBackStack()

        }

    }

    private fun saveNote(note:Note) {

        ApiClient.api_servis.saveNotes(note).enqueue(object :Callback<Note>{
            override fun onResponse(call: Call<Note>, response: Response<Note>) {

            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


}