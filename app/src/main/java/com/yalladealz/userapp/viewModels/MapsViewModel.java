package com.yalladealz.userapp.viewModels;

import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.BranchDeal;
import com.yalladealz.userapp.model.responses.BranchLocationResponse;
import com.yalladealz.userapp.repositories.MapsRepository;

import java.util.List;

public class MapsViewModel extends ViewModel {

    private MapsRepository mapsRepository;
    private LiveData<List<BranchDeal>> nearByDeals;

    public MapsViewModel() {
        mapsRepository = new MapsRepository();
    }

    //TODO: handle configuration changes
    public LiveData<BranchLocationResponse> getNearByDeals(Location location, int distance) {
        return mapsRepository.getNearByBranches(location, distance);
    }

    public LiveData<List<BranchDeal>> getBranchDeals(String id) {
        return mapsRepository.getBranchDeals(id);
    }
    public LiveData<BranchLocationResponse> getBranches(Location location) {
        return mapsRepository.getBranches(location);
    }
}
