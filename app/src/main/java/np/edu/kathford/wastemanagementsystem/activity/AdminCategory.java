package np.edu.kathford.wastemanagementsystem.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.wastemanagementsystem.R;

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
//                String des = description.getText().toString();
                String price1 = price.getText().toString();


                //validation for category
                if (name.isEmpty()) {
                    category_name.setError("Full name is required");
                    category_name.requestFocus();
                }

                /*if (price1.isEmpty()) {
                    price.setError("Price is required");
                    price.requestFocus();
                }*/

                //calling api should be here
            }
        });

    }
}