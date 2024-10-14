package com.example.fixup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.fixup.apicalls.ApiService;
import com.example.fixup.apicalls.RetroFitClient;
import com.example.fixup.models.ProfileModel;
import com.example.fixup.utils.AndroidUtil;
import com.example.fixup.utils.SessionManagerUtil;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends AppCompatActivity {
    private SessionManagerUtil sessionManagerUtil;
    private EditText nameText, contactNoText, stateText, cityText;
    private Button cancelButton, updateButton;
    private ProgressBar progressBar;
    private String orgName, orgContactNo, orgState, orgCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameText = findViewById(R.id.profile_user_name);
        contactNoText = findViewById(R.id.profile_user_contact_no);
        stateText = findViewById(R.id.profile_user_state);
        cityText = findViewById(R.id.profile_user_city);
        cancelButton = findViewById(R.id.profile_update_cancel);
        updateButton = findViewById(R.id.profile_update_button);
        progressBar = findViewById(R.id.profile_progress_bar);
        sessionManagerUtil = new SessionManagerUtil(this);
        fetchUserDetails(sessionManagerUtil.getEmail());
        cancelButton.setOnClickListener(v -> {
            setTextUnChanged();
            finish();
        });
        updateButton.setOnClickListener(v -> {

        });
    }

    private void fetchUserDetails(String email) {
        Retrofit retrofit = RetroFitClient.getClient(this.getString(R.string.base_url) + "/");
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> map  = new HashMap<>();
        map.put("email", email);
        Call<ProfileModel> call = apiService.fetchUserDetailsForProfile(map);
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                if(response.isSuccessful() && response.code() == 201 && response.body() != null) {
                    AndroidUtil.showToast(
                            getApplicationContext(),
                            "User Details Fetched"
                    );
                    orgName = response.body().getName();
                    orgContactNo = response.body().getContactNo();
                    orgState = response.body().getState();
                    orgCity = response.body().getCity();
                    nameText.setText(orgName);
                    contactNoText.setText(orgContactNo);
                    stateText.setText(orgState);
                    cityText.setText(orgCity);
                } else {
                    AndroidUtil.showToast(
                            getApplicationContext(),
                            response.message()
                    );
                }
            }
            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                AndroidUtil.showToast(
                        getApplicationContext(),
                        "Request Failed"
                );
            }
        });
    }
    private void setTextUnChanged() {
        nameText.setText(orgName);
        contactNoText.setText(orgContactNo);
        stateText.setText(orgState);
        cityText.setText(orgCity);
    }
}