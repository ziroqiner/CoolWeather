package logic

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import logic.model.Place
import logic.network.CoolWeatherNetWork
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = CoolWeatherNetWork.searchPlaces(query)
            if(placeResponse.status=="ok"){
                val places = placeResponse.places
                Result.success(places)
                }else{
                    Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}