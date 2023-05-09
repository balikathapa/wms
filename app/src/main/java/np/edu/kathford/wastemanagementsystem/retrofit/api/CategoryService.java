package np.edu.kathford.wastemanagementsystem.retrofit.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CategoryService {

    @FormUrlEncoded
    @POST("api/category/save-update")
    Call saveCategory(
            @Field("name") String name);
}

