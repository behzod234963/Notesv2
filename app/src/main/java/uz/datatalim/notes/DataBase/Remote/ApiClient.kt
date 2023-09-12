package uz.datatalim.notes.DataBase.Remote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiClient {

    val retrofit=Retrofit.Builder().baseUrl("https://650060dc18c34dee0cd4d10e.mockapi.io/").addConverterFactory(GsonConverterFactory.create()).build()

    val api_servis= retrofit.create(ApiServis::class.java)

}