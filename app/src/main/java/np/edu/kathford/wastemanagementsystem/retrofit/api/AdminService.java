package np.edu.kathford.wastemanagementsystem.retrofit.api;

import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AdminService {

    @FormUrlEncoded
    @POST("api/admin/signup/save")
    Call<ApiResponse> saveAdminSignup(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("mobileNo") String mobileNo,
            @Field("phoneNo") String phoneNo
    );

    @FormUrlEncoded
    @POST("api/admin/findall")
    Call getAllUser();

    @FormUrlEncoded
    @POST("api/admin/login")
    Call<ApiResponse> checkLogin(
            @Field("username") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("api/admin/reset-password")
    Call<ApiResponse> adminResetPassword(
            @Field("userId") Long adminId,
            @Field("oldPassword") String oldPassword,
            @Field("newPassword") String newPassword,
            @Field("confirmPassword") String confirmPassword);
}


