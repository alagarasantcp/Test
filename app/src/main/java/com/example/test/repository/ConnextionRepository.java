package com.example.test.repository;

import com.example.test.api.ApiService;
import com.example.test.api.RetrofitClient;
import com.example.test.request.ReqLogin;
import com.example.test.responsse.ResLoginReturn;
import com.example.test.responsse.ServerMsg;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ConnextionRepository {

    private ApiService connexionApi;

    public ConnextionRepository(ApiService connexionApi) {
        this.connexionApi = connexionApi;
    }

    public Observable<ResLoginReturn> doLogin(ReqLogin reqLogin) {
        Retrofit retrofit = RetrofitClient.getInstance();
        connexionApi = retrofit.create(ApiService.class);
        return Observable.create(emitter -> connexionApi.doLogin(reqLogin).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cardsResponse -> {
                    if (cardsResponse != null) {
                        emitter.onNext(cardsResponse);
                    }
                }, throwable -> {
                    emitter.onNext(new ResLoginReturn(new ServerMsg(throwable.getMessage(), "Failed")));
                }));
    }
}
