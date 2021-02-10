package ui.place

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import logic.Repository
import logic.model.Place

class PlaceViewModel:ViewModel() {
    private val searchLiveData = MediatorLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){
        query->Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value=query
    }
}