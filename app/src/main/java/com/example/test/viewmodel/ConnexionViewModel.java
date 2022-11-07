package com.example.test.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.test.repository.ConnextionRepository;
import com.example.test.request.ReqLogin;
import com.example.test.responsse.ResLoginReturn;

public class ConnexionViewModel extends ViewModel {
    private final ConnextionRepository connexionRepository;
    private MutableLiveData<ResLoginReturn> _resLoginLiveData = new MutableLiveData<>();
    public LiveData<ResLoginReturn> resLoginLiveData = _resLoginLiveData;
    public ConnexionViewModel(ConnextionRepository connexionRepository) {
        this.connexionRepository = connexionRepository;
    }

    public void doLogin(ReqLogin reqLogin) {
        connexionRepository.doLogin(reqLogin).subscribe(resLoginReturn -> _resLoginLiveData.postValue(resLoginReturn));
    }

}
