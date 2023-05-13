package np.edu.kathford.wastemanagementsystem.retrofit.api;

import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("api/user/signup")
    Call<ApiResponse> saveUserSignup(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("address") String address,
            @Field("mobileNo") String mobileNo,
            @Field("type") String type
    );

    @FormUrlEncoded
    @POST("api/user/findall")
    Call getAllUser();

    @FormUrlEncoded
    @POST("api/user/login")
    Call<ApiResponse> checkLogin(
            @Field("username") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("api/user/reset-password")
    Call<ApiResponse> userResetPassword(
            @Field("userId") Long userId,
            @Field("oldPassword") String oldPassword,
            @Field("newPassword") String newPassword,
            @Field("confirmPassword") String confirmPassword);

}

