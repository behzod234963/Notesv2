package uz.datatalim.notes.DataBase.Remote
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import uz.datatalim.notes.Models.Note

interface ApiServis {

    @GET("notes")
    fun getAllNotes():Call<ArrayList<Note>>

    @GET("notes/{id}")
    fun getNoteById(@Path("id")id:Int):Call<ArrayList<Note>>

    @POST("notes")
    fun saveNotes(@Body note:Note):Call<Note>

    @PUT("notes/{id}")
    fun editNote(@Path("id")id: Int,@Body note:Note):Call<Note>

    @DELETE("notes/{id}")
    fun deleteNote(@Path("id")id: Int):Call<Note>

}