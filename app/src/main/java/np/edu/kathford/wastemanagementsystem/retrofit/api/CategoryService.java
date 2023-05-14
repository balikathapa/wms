package np.edu.kathford.wastemanagementsystem.retrofit.api;


import java.math.BigDecimal;

import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CategoryService {

    @FormUrlEncoded
    @POST("api/category/save-update")
    Call<ApiResponse> saveOrUpdateCategory(
            @Field("name") String name,
            @Field("icon") String icon,
            @Field("price") BigDecimal price);

}
