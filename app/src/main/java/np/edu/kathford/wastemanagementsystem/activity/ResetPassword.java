package np.edu.kathford.wastemanagementsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.wastemanagementsystem.R;


public class ResetPassword extends AppCompatActivity {
    private EditText emailResetPw;
    private EditText passwordResetPw;
    private EditText newPassword;
    private EditText confirmNewPassword;
    private TextView submitResetPw;
    private TextView backResetPw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        //receiving data from UserLogin
        Intent in = getIntent();
        int id=in.getIntExtra("id",002);
        String receivedEmail=in.getStringExtra("email");
        String receivedPassword=in.getStringExtra("password");

        emailResetPw = findViewById(R.id.registered_emailid);
        newPassword=findViewById(R.id.new_password);
        confirmNewPassword=findViewById(R.id.confirm_new_password);
        submitResetPw=findViewById(R.id.forgot_button);
        backResetPw=findViewById(R.id.backToLoginBtn);

        submitResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting data
                String emailResetPassword=emailResetPw.getText().toString().trim();
                String newPw= newPassword.getText().toString().trim();
                String confirmNewPw=confirmNewPassword.getText().toString().trim();


                //data validation
                if(receivedEmail!=emailResetPassword){
                    emailResetPw.setError("Please enter your registered email");
                    emailResetPw.requestFocus();
                }
                if (newPw.length() <=8) {
                    newPassword.setError("Password should be at least 8 characters long");
                    newPassword.requestFocus();

                }

                if (newPw.isEmpty()) {
                    newPassword.setError("Confirm password is required");
                    newPassword.requestFocus();

                }

                if (!confirmNewPw.equals(newPw)) {
                    confirmNewPassword.setError("Passwords do not match");
                    confirmNewPassword.requestFocus();

                }

            }
        });

        backResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPassword.this, UserLogin.class);
                startActivity(intent);

            }
        });

    }
}
