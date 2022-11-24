package edu.mirea.alexbulan.countpressing.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import edu.mirea.alexbulan.countpressing.databinding.ActivityMainBinding;
import edu.mirea.alexbulan.countpressing.ui.viewModule.CountViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private CountViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mViewModel = new ViewModelProvider(this).get(CountViewModel.class);

        mBinding.presssCountBtn.setOnClickListener(view -> {
            mViewModel.increasePressCount();
        });
        mBinding.pressCountText.setText(String.valueOf(mViewModel.getPressCountValue()));
        mViewModel.getPressCountContainer().observe(this, pressCountValue -> {
            mBinding.pressCountText.setText(pressCountValue.toString());
        });
        setContentView(mBinding.getRoot());
    }
}