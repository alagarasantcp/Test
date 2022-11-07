package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.request.ReqLogin;
import com.example.test.viewmodel.ConnexionViewModel;

import dagger.hilt.android.AndroidEntryPoint;

public class Fragment2 extends Fragment {

    public  ConnexionViewModel connexionViewModel;
    EditText etUserName;
    EditText etPassword;
    Button btnSignIn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        connexionViewModel = new ViewModelProvider(requireActivity()).get(ConnexionViewModel.class);
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUserName = getView().findViewById(R.id.etUserName);
        etPassword = getView().findViewById(R.id.etPassword);
        btnSignIn = getView().findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReqLogin.DeviceData deviceData = new ReqLogin.DeviceData("Android",
                        "12121212121212121",
                        "Y");
                connexionViewModel.doLogin(new ReqLogin(etUserName.getText().toString(),
                        deviceData,
                        "0",
                        etPassword.getText().toString(),
                        "0"));
            }
        });
        connexionViewModel.resLoginLiveData.observe(getViewLifecycleOwner(),reLogin -> {
            if(reLogin.loginReturn.customerCount == 1)
            {
                Log.e("Name",reLogin.loginReturn.firstName);
            }
        });
    }
}