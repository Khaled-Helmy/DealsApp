package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.model.History.Deal;
import com.yalladealz.userapp.repositories.HistoryRepository;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    private HistoryRepository historyRepository;


    public HistoryViewModel() {
        historyRepository = new HistoryRepository();
    }

    public void history(long id, String hash) {
        historyRepository.history(id, hash);
    }

    public LiveData<List<Deal>> getHistory() {
        return historyRepository.getHistory();
    }

    public LiveData<List<Deal>> getAvailable() {
        return historyRepository.getAvailable();
    }


}
