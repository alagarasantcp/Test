package com.example.test.api;

import com.example.test.request.ReqLogin;
import com.example.test.responsse.ResLoginReturn;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiService {

    @POST(LOGIN_API)
    Observable<ResLoginReturn> doLogin(@Body ReqLogin reqLogin);
    String LOGIN_API = "Registration/NewLoginValidation";
}
