package np.edu.kathford.wastemanagementsystem.retrofit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

//    OkHttpClient client = new OkHttpClient.Builder().build();

    public void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.68:8080/wms/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
