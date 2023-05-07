package np.edu.kathford.wastemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ResetPassword extends AppCompatActivity {
    private EditText emailResetPw, passwordResetPw, newPassword, confirmNewPassword;
    private TextView submitResetPw, backResetPw;

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
                    return;
                }

                if (newPw.isEmpty()) {
                    newPassword.setError("Confirm password is required");
                    newPassword.requestFocus();
                    return;
                }

                if (!confirmNewPw.equals(newPw)) {
                    confirmNewPassword.setError("Passwords do not match");
                    confirmNewPassword.requestFocus();
                    return;
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
