package com.yalladealz.userapp.viewModels;

import androidx.lifecycle.ViewModel;

import com.yalladealz.userapp.repositories.PhotoUpdateRepository;

import okhttp3.MultipartBody;

public class PhotoUpdateViewModel extends ViewModel {

    private PhotoUpdateRepository photoUpdateRepository ;

    public PhotoUpdateViewModel() {
        photoUpdateRepository = new PhotoUpdateRepository();
    }

    public void updatrPhoto(MultipartBody.Part body){
        photoUpdateRepository.updatePhoto(body);
    }


}
