package np.edu.kathford.wastemanagementsystem.retrofit;

import np.edu.kathford.wastemanagementsystem.model.CategoryRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CategoryService {

    @FormUrlEncoded
    @POST("api/category/save-update")
    Call saveCategory(
            @Field("name") String name);
}

