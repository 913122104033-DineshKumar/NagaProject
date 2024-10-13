package com.example.fixup.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class AndroidUtil {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static void switchActivity(Context from, Class<?> to){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(from, to);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                from.startActivity(intent);
            }
        }, 1000);
    }
    public static void switchActivityWithExtras(Context from, Class<?> to, Map<String, String> map) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(from, to);
                for(Map.Entry<String, String> entry: map.entrySet()) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                from.startActivity(intent);
            }
        }, 1000);
    }
    public static void setProgressBarVisible(ProgressBar progressBar, boolean setVisible) {
        if(setVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
    public static void setButtonEnabled(Button button, boolean setEnabled) {
        if(setEnabled) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
    }
}
