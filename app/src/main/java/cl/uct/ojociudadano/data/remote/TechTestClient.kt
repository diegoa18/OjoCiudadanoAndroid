package cl.uct.ojociudadano.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TechTestClient {
    // 10.0.2.2 apunta al localhost del computador desde el emulador Android.
    private const val BASE_URL = "http://192.168.1.9:3000/"


    val api: TechTestApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TechTestApi::class.java)
    }
}
