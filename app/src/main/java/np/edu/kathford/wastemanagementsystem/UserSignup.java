package np.edu.kathford.wastemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSignup extends AppCompatActivity {

    private EditText full_name, email_id, mobile_number, location, password, confirm_password;
    private CheckBox terms_and_conditions;
    private Button signup;
    private TextView login_here;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        full_name=findViewById(R.id.fullName);
        email_id=findViewById(R.id.userEmailId);
        mobile_number=findViewById(R.id.mobileNumber);
        location=findViewById(R.id.location);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirmPassword);
        terms_and_conditions=findViewById(R.id.terms_conditions);
        signup=findViewById(R.id.signUpBtn);
        login_here=findViewById(R.id.already_user);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, number, address, pw, confirm_pw;
                name = full_name.getText().toString();
                email = email_id.getText().toString();
                number = mobile_number.getText().toString();
                address = location.getText().toString();
                pw = password.getText().toString();
                confirm_pw = confirm_password.getText().toString();

                if (name != null && !name.isEmpty()) {
                    Toast.makeText(UserSignup.this, "Full name valid", Toast.LENGTH_LONG).show();
                    if (email != null && !email.isEmpty()) {
                        Toast.makeText(UserSignup.this, "email is valid", Toast.LENGTH_LONG).show();
                        if (pw != null && !pw.isEmpty()) {
//                            public boolean isValidPassword(String pass_w){
//                                String pattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
//                                // At least 8 characters, at least one letter, at least one number, and at least one special character
//                                Pattern p = Pattern.compile(pattern);
//                                Matcher m = p.matcher(pw);
//                                return m.matches();
                            if (number != null && !number.isEmpty()) {
                                if (number.length() == 10) {
                                    Toast.makeText(UserSignup.this, "Number is valid", Toast.LENGTH_LONG).show();
                                    if (address != null && !address.isEmpty()) {
                                        Toast.makeText(UserSignup.this, "Address is valid", Toast.LENGTH_LONG).show();
                                        if (confirm_pw != null && !confirm_pw.isEmpty()) {
                                            if (confirm_pw == pw) {
                                                Toast.makeText(UserSignup.this, "Confirm password valid", Toast.LENGTH_LONG).show();
                                            } else {
                                                confirm_password.setError("Input the correct password");
                                            }
                                        } else {
                                            password.setError("Enter the password in correct format");
                                        }
                                    } else {
                                        location.setError("Enter the address");
                                    }
                                } else {
                                    mobile_number.setError("Mobile number should have at least ten digits");
                                }
                            } else {
                                mobile_number.setError("Input mobile number");
                            }
                        } else {
                            password.setError("Password must not be empty");
                        }

                    }
                    else{
                        email_id.setError("Email must not be empty");
                    }
                }
                else {
                    full_name.setError("Name field must not be empty");
                }

                //passing data to User-login
                Intent i= new Intent(UserSignup.this, UserLogin.class);
                i.putExtra("id",001);
                i.putExtra("full_name", name);
                i.putExtra("Email_Id", email);
                i.putExtra("mobile_number", number);
                i.putExtra("location", address);
                i.putExtra("password", pw);
                startActivity(i);

            }


        });
    }
}
