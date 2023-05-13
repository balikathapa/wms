package np.edu.kathford.wastemanagementsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.math.BigDecimal;

import lombok.experimental.Helper;
import np.edu.kathford.wastemanagementsystem.R;
import np.edu.kathford.wastemanagementsystem.retrofit.RetrofitService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.CategoryService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.UserService;
import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminCategory extends AppCompatActivity {

    EditText categoryNameEditText;
    //    EditText description;
    EditText priceEditText;
    Button submitBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        categoryNameEditText = findViewById(R.id.category_name);
//        description = findViewById(R.id.category_description);
        priceEditText = findViewById(R.id.category_price);
        submitBtn = findViewById(R.id.category_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = categoryNameEditText.getText().toString();
//                String des = description.getText().toString();
                String price1 = priceEditText.getText().toString();


                //validation for category
                if (name.isEmpty()) {
                    categoryNameEditText.setError("Catgory name is required");
                    categoryNameEditText.requestFocus();
                }

                /*if (price1.isEmpty()) {
                    price.setError("Price is required");
                    price.requestFocus();
                }*/

                //calling api should be here
                saveCategory(name, !price1.isEmpty() ? BigDecimal.valueOf(Long.parseLong(price1)) : BigDecimal.ZERO);
            }
        });

    }

    public void saveCategory(String name, BigDecimal price) {
        RetrofitService retrofitService = new RetrofitService();

        CategoryService categoryService = retrofitService.getRetrofit().create(CategoryService.class);
        Call<ApiResponse> call = categoryService.saveOrUpdateCategory(name, "", price);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.i("Success", new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    Intent i = new Intent(AdminCategory.this, AdminDashboard.class);
                    startActivity(i);
                    Toast.makeText(AdminCategory.this, "Category saved successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AdminCategory.this, "Something is not right.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Success", t.getMessage());
                Toast.makeText(AdminCategory.this, "Failed to login data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}