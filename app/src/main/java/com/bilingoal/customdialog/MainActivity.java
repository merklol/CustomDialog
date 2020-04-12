package com.bilingoal.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.bilingoal.customdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        dialog = new CustomDialog();

        dialog.setOnClickListener(password -> {
            binding.textView.setText(password);
        });

        binding.btn.setOnClickListener(v -> {
            dialog.show(getSupportFragmentManager(), "custom_dialog");
        });
    }
}
