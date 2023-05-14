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
import np.edu.kathford.wastemanagementsystem.retrofit.RetrofitService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.AdminService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.UserService;
import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminSignup extends AppCompatActivity {

    private EditText fullNameEditText;

    private EditText usernameEditText;
    private EditText emailIdEditText;
    private EditText phoneNumberEditText;
    private EditText mobileNumberEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private CheckBox terms_and_conditions;
    private Button signup;
    private TextView login_here;
    private TextView already_user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);

        fullNameEditText = findViewById(R.id.fullName);
        usernameEditText = findViewById(R.id.usernameId);
        emailIdEditText = findViewById(R.id.userEmailId);
        mobileNumberEditText = findViewById(R.id.mobileNumber);
        phoneNumberEditText = findViewById(R.id.phoneNumberId);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        signup = findViewById(R.id.signUpBtn);
        login_here = findViewById(R.id.already_user);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fullNameEditText.getText().toString();
                String userName = usernameEditText.getText().toString();
                String email = emailIdEditText.getText().toString();
                String mobileNo = mobileNumberEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String pw = passwordEditText.getText().toString();
                String confirm_pw = confirmPasswordEditText.getText().toString();

                if (name.isEmpty()) {
                    fullNameEditText.setError("Full name is required");
                    fullNameEditText.requestFocus();
                }

                if (userName.isEmpty()) {
                    usernameEditText.setError("User name is required");
                    usernameEditText.requestFocus();
                }

                if (email.isEmpty()) {
                    emailIdEditText.setError("Email is required");
                    emailIdEditText.requestFocus();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailIdEditText.setError("Please enter a valid email address");
                    emailIdEditText.requestFocus();

                }

                if (mobileNo.length() != 10) {
                    mobileNumberEditText.setError("Mobile number is required or mobile number should have 10 digits");
                    mobileNumberEditText.requestFocus();
                }

                if (pw.isEmpty()) {
                    passwordEditText.setError("Password is required");
                    passwordEditText.requestFocus();
                }

                if (pw.length() <= 8) {
                    passwordEditText.setError("Password should be at least 8 characters long");
                    passwordEditText.requestFocus();

                }

                if (confirm_pw.isEmpty()) {
                    confirmPasswordEditText.setError("Confirm password is required");
                    confirmPasswordEditText.requestFocus();
                }

                if (!confirm_pw.equals(pw)) {
                    confirmPasswordEditText.setError("Passwords do not match");
                    confirmPasswordEditText.requestFocus();
                }

                //call the api using retrofit
                saveSignup(name, userName, pw, email, mobileNo, phoneNumber);

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
                Intent intent = new Intent(AdminSignup.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }

    public <T> void saveSignup(String name, String username, String password,
                               String email, String mobileNo, String phoneNo) {
        RetrofitService retrofitService = new RetrofitService();
        AdminService adminService = retrofitService.getRetrofit().create(AdminService.class);

        Call<ApiResponse> call = adminService.saveAdminSignup(
                name, username, password, email, mobileNo, phoneNo
        );

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.i("Success", new Gson().toJson(response.body()));
                ApiResponse apiResponse = response.body();
                Log.i("Api Response ", new Gson().toJson(apiResponse));
                if (response.isSuccessful()) {
                    Intent i = new Intent(AdminSignup.this, AdminLogin.class);
                    startActivity(i);
                    Toast.makeText(AdminSignup.this, "Admin saved successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AdminSignup.this, "Something is not right.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Success", t.getMessage());
                Toast.makeText(AdminSignup.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
