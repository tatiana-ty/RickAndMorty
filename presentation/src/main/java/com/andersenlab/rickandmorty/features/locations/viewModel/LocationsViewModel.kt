package com.andersenlab.rickandmorty.features.locations.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andersenlab.domain.entities.Location
import com.andersenlab.domain.entities.LocationsFilter
import com.andersenlab.domain.interactors.ILocationInteractor
import com.andersenlab.rickandmorty.features.base.BaseViewModel
import com.andersenlab.rickandmorty.features.locations.ui.LocationsFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(
    private val locationInteractor: ILocationInteractor
) : BaseViewModel() {

    private val locationsMutableLiveData: MutableLiveData<List<Location>> =
        MutableLiveData()
    val locationsLiveData: LiveData<List<Location>>
        get() = locationsMutableLiveData

    private val isErrorMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val isErrorLiveData: LiveData<Boolean>
        get() = isErrorMutableLiveData

    private val isLoadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val isLoadingLiveData: LiveData<Boolean>
        get() = isLoadingMutableLiveData

    fun loadLocations(page: Int, filter: LocationsFilter) {
        isLoadingLiveData(true)
        viewModelScope.launch {
            val locationsEntityResult = locationInteractor.getAllLocations(page, filter)
            LocationsFragment.pages = locationsEntityResult.info.pages
            updateAppropriateLiveData(locationsEntityResult.results, 0)
        }
    }

    fun reloadLocations(filter: LocationsFilter) {
        isLoadingLiveData(true)
        viewModelScope.launch {
            val locationsEntityResult = locationInteractor.getAllLocations(1, filter)
            LocationsFragment.pages = locationsEntityResult.info.pages
            updateAppropriateLiveData(locationsEntityResult.results, 1)
        }
    }

    private fun updateAppropriateLiveData(locations: List<Location>, flag: Int) {
        if (!locations.isNullOrEmpty()) {
            onResultSuccess(locations, flag)
        } else {
            onResultError()
        }
    }

    private fun onResultSuccess(locations: List<Location>, flag: Int) {
        when (flag) {
            0 ->
                if (!locationsMutableLiveData.value.isNullOrEmpty()) {
                    locationsMutableLiveData.value = locationsMutableLiveData.value?.plus(locations)
                } else {
                    locationsMutableLiveData.value = locations
                }
            1 -> locationsMutableLiveData.value = locations
        }
        isLoadingLiveData(false)
    }

    private fun onResultError() {
        viewModelScope.launch {
            delay(300)
            isLoadingLiveData(false)
        }.invokeOnCompletion {
            isErrorMutableLiveData.value = true
        }
    }

    private fun isLoadingLiveData(isLoading: Boolean) {
        this.isLoadingMutableLiveData.value = isLoading
    }
}
