package np.edu.kathford.wastemanagementsystem.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http:/localhost:8080/wms/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit initialize() {
        return retrofit;
    }

}
