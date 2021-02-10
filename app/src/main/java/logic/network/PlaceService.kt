package logic.network

import com.coolweather.Android.CoolWeatherApplication
import logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${CoolWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query")query:String): Call<PlaceResponse>
}