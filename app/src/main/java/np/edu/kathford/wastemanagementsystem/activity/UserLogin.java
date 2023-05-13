package np.edu.kathford.wastemanagementsystem.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import np.edu.kathford.wastemanagementsystem.R;
import np.edu.kathford.wastemanagementsystem.util.ApiResponse;
import np.edu.kathford.wastemanagementsystem.retrofit.RetrofitService;
import np.edu.kathford.wastemanagementsystem.retrofit.api.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLogin extends AppCompatActivity {

    private EditText login_emailId;
    private EditText login_password;
    private CheckBox showPassword;
    private Button login_btn;
    //    private TextView create_account;
    private TextView signupHereTextView;

//    private TextView resetPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //receiving data from signup
        Intent i = getIntent();
//        int id=i.getIntExtra("id",001);
//        String name1=i.getStringExtra("full_name");
//        String address1=i.getStringExtra("location");
//        String email1=i.getStringExtra("Email_Id");
//        String password1=i.getStringExtra("password");
//        String number1=i.getStringExtra("mobile_number");

        login_emailId = findViewById(R.id.loginUserId);
        login_password = findViewById(R.id.login_password);
        login_btn = findViewById(R.id.loginBtn);
//        showPassword=findViewById(R.id.show_hide_password);
//        create_account = findViewById(R.id.createAccount);
        signupHereTextView = findViewById(R.id.createAccount);
//        resetPassword = findViewById(R.id.forgot_password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = login_emailId.getText().toString().trim();
                String password = login_password.getText().toString().trim();
//                String submit_button = login_btn.getText().toString().trim();

                checkUserLogin(username, password);

               /* if(email1==email){
                    if(password1==password){
                        Toast.makeText(UserLogin.this, "Successful login", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(UserLogin.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(UserLogin.this, "Email Incorrect", Toast.LENGTH_LONG).show();
                }*/


                //passing data to ResetPassword
                /*Intent in= new Intent(UserLogin.this,ResetPassword.class);
                in.putExtra("id", 002);
                in.putExtra("email" ,email);*/
            }
        });

        signupHereTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLogin.this, UserSignup.class);
                startActivity(intent);
            }
        });

        /*resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLogin.this, ResetPassword.class);
                startActivity(intent);
            }
        });*/
    }

    public void checkUserLogin(String username, String password) {
        RetrofitService retrofitService = new RetrofitService();

        UserService userSignupService = retrofitService.getRetrofit().create(UserService.class);
        Call<ApiResponse> call = userSignupService.checkLogin(username, password);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.i("Success test ", new Gson().toJson(response.body()));
                Gson gson = new Gson();
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    String apiResponse = response.body().toString();
                    try {
                        JSONObject j = new JSONObject(apiResponse);
                        boolean success = j.getBoolean("success");
                        String message = j.getString("message");
                        System.out.println("Message : "+message);
                        System.out.println(success + " Success ");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
//                Log.i("Api Response ", new Gson().toJson(apiResponse));
                    Intent i = new Intent(UserLogin.this, UserDashboard.class);
                    startActivity(i);
                    Toast.makeText(UserLogin.this, "Login successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserLogin.this, "Something is not right.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Success", t.getMessage());
                Toast.makeText(UserLogin.this, "Failed to login data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
