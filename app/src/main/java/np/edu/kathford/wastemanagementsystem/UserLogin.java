package np.edu.kathford.wastemanagementsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserLogin extends AppCompatActivity {

    private EditText login_emailId, login_password;
    private CheckBox showPassword;
    private Button login_btn;
    private TextView create_account;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login_emailId= findViewById(R.id.userEmailId);
        login_password=findViewById(R.id.password);
        login_btn=findViewById(R.id.loginBtn);
        showPassword=findViewById(R.id.show_hide_password);
        create_account=findViewById(R.id.createAccount);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_emailId.getText().toString().trim();
                String password = login_password.getText().toString().trim();
                String submit_button = login_btn.getText().toString().trim();

                System.out.println("EMail is : "+email);
                System.out.println("Password is : "+password);
//                System.out.println("");


            }
        });
    }
}
