package com.bilingoal.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import com.bilingoal.customdialog.databinding.DialogLayoutBinding;

public class CustomDialog extends DialogFragment {

    private DialogLayoutBinding binding;
    private OnClickListener onClickListener;

    public interface OnClickListener {
        void onClick(String str);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        if(activity != null){
            binding = DataBindingUtil.inflate(activity.getLayoutInflater(),
                    R.layout.dialog_layout, null, false);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(binding.getRoot());
        builder.setPositiveButton("Confirm", (dialog, which) -> {
           onClickListener.onClick(binding.passwordView.getText().toString());
        });
        return builder.create();
    }
}
