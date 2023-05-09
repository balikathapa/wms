package np.edu.kathford.wastemanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminCategory extends AppCompatActivity {

    EditText category_name, description, price;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        category_name = findViewById(R.id.category_name);
        description = findViewById(R.id.category_description);
        price = findViewById(R.id.category_price);
        submit = findViewById(R.id.category_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = category_name.getText().toString();
                String des = description.getText().toString();
                String price1 = price.getText().toString();


                //validation for category
                if (name.isEmpty()) {
                    category_name.setError("Full name is required");
                    category_name.requestFocus();
                }

                if (des.isEmpty()) {
                    description.setError("Full name is required");
                    description.requestFocus();
                }

                if (price1.isEmpty()) {
                    price.setError("Full name is required");
                    price.requestFocus();
                }

                //call the api
//                System.out.println(" I am Inside Api to integrate ");
//
//                CategoryService api = new RetrofitService().initialize().create(CategoryService.class);
//
//                CategoryRequest categoryRequest = new CategoryRequest();
//                categoryRequest.setName("John");
//                categoryRequest.setDescription("Test");
//                categoryRequest.setPrice(800.00);
//                retrofit2.Call call = api.saveCategory(
//                        categoryRequest
//                );


                           /*  call.enqueue(new Callback<Category>
                                @Override
                                public void onResponse(Call<Category> call, Response<Category> response) {
                                    // Handle successful response
                                }

                                @Override
                                public void onFailure(Call<Category> call, Throwable t) {
                                    // Handle failure
                                }
                            });*/



            }
        });

    }
}