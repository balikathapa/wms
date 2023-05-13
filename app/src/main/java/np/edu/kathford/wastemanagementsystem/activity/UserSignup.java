package np.edu.kathford.wastemanagementsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import np.edu.kathford.wastemanagementsystem.R;
import np.edu.kathford.wastemanagementsystem.Util.ApiResponse;
import np.edu.kathford.wastemanagementsystem.model.User;
import np.edu.kathford.wastemanagementsystem.retrofit.RetrofitService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.UserService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignup extends AppCompatActivity {

    private EditText full_name;

    private EditText username;
    private EditText email_id;
    private EditText mobile_number;
    private EditText location;
    private EditText password;
    private EditText confirm_password;
    private CheckBox terms_and_conditions;
    private Button signup;
    private TextView login_here, already_user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        full_name = findViewById(R.id.fullName);
        username = findViewById(R.id.usernameId);
        email_id = findViewById(R.id.userEmailId);
        mobile_number = findViewById(R.id.mobileNumber);
        location = findViewById(R.id.location);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirmPassword);
        terms_and_conditions = findViewById(R.id.terms_conditions);
        signup = findViewById(R.id.signUpBtn);
        login_here = findViewById(R.id.already_user);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = full_name.getText().toString();
                String userName = username.getText().toString();
                String email = email_id.getText().toString();
                String number = mobile_number.getText().toString();
                String address = location.getText().toString();
                String pw = password.getText().toString();
                String confirm_pw = confirm_password.getText().toString();

                if (name.isEmpty()) {
                    full_name.setError("Full name is required");
                    full_name.requestFocus();

                }

                if (userName.isEmpty()) {
                    username.setError("User name is required");
                    username.requestFocus();

                }

                if (email.isEmpty()) {
                    email_id.setError("Email is required");
                    email_id.requestFocus();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_id.setError("Please enter a valid email address");
                    email_id.requestFocus();

                }

                if (number.length() != 10) {
                    mobile_number.setError("Mobile number is required or mobile number should have 10 digits");
                    mobile_number.requestFocus();
                }

                if (address.isEmpty()) {
                    location.setError("Address is required");
                    location.requestFocus();
                }

                if (pw.isEmpty()) {
                    password.setError("Password is required");
                    password.requestFocus();
                }

                if (pw.length() <= 8) {
                    password.setError("Password should be at least 8 characters long");
                    password.requestFocus();

                }

                if (confirm_pw.isEmpty()) {
                    confirm_password.setError("Confirm password is required");
                    confirm_password.requestFocus();

                }

                if (!confirm_pw.equals(pw)) {
                    confirm_password.setError("Passwords do not match");
                    confirm_password.requestFocus();
                }

                //call the api using retrofit
                saveSignup(name, userName, pw, email, address, number, "User");


                //passing data to User-login
                /*Intent i= new Intent(UserSignup.this, UserLogin.class);
                i.putExtra("id",001);
                i.putExtra("full_name", name);
                i.putExtra("Email_Id", email);
                i.putExtra("mobile_number", number);
                i.putExtra("location", address);
                i.putExtra("password", pw);
                startActivity(i);*/
            }
        });

        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSignup.this, UserLogin.class);
                startActivity(intent);
            }
        });
    }

    public <T> void saveSignup(String name, String username, String password,
                               String email, String address, String mobileNo, String type) {
        RetrofitService retrofitService = new RetrofitService();
        UserService userSignupService = retrofitService.getRetrofit().create(UserService.class);

        Call<ApiResponse> call = userSignupService.saveUserSignup(
                name, username, password, email, address, mobileNo, type
        );

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.i("Success", new Gson().toJson(response.body()));
                ApiResponse apiResponse = response.body();
                Log.i("Api Response ", new Gson().toJson(apiResponse));
                if (response.isSuccessful()) {
                    Intent i = new Intent(UserSignup.this, UserLogin.class);
                    startActivity(i);
                    Toast.makeText(UserSignup.this, "User saved successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserSignup.this, "Something is not right.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Success", t.getMessage());
                Toast.makeText(UserSignup.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
