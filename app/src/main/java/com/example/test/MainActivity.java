package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private NavHostFragment navHostFragment;
    private boolean canExit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        navController = navHostFragment.getNavController();

    }

    @Override
    public void onBackPressed() {
        if (navController.getCurrentDestination() != null && navController.getCurrentDestination().getId() != 0) {
            int aId = navController.getCurrentDestination().getId();
            if (aId == R.id.fragment1) {
                finish();
            } else if (aId == R.id.fragment2) {
                if (canExit) {
                    finish();
                } else {
                    Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
                    canExit = true;
                    new Handler().postDelayed(() -> canExit = false, 2000);
                }
            } else navController.navigateUp();
        } else
            super.onBackPressed();
    }
}