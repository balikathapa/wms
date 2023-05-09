package np.edu.kathford.wastemanagementsystem.retrofit.api;

import java.util.Date;

import np.edu.kathford.wastemanagementsystem.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("api/user")
    Call saveUserSignup(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("type") String type
    );
}

