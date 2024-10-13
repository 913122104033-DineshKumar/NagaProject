package com.example.fixup.apicalls;

import com.example.fixup.OtpVerificationActivity;
import com.example.fixup.apicalls.models.LoginRequestModel;
import com.example.fixup.apicalls.models.OTPRequestModel;
import com.example.fixup.models.IssueDetailModel;
import com.example.fixup.models.UserDetailsModel;

import java.util.HashMap;

import retrofit2.Call;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/register")
    Call<Void> register(@Body HashMap<String, String> map);
    @POST("auth/sendOTP")
    Call<OTPRequestModel> sendOTP(@Body HashMap<String, String> map);
    @POST("issue/addPost")
    Call<Void> addPost(@Body HashMap<String, String> map);
    @POST("auth/loginUser")
    Call<LoginRequestModel> loginUser(@Body HashMap<String, String> map);
    @POST("issue/fetchPostByUserCity")
    Call<IssueDetailModel> fetchPostByUserCity(@Body HashMap<String, String> map);
}