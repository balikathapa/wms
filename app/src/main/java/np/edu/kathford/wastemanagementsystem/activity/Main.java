package np.edu.kathford.wastemanagementsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.wastemanagementsystem.R;

public class Main extends AppCompatActivity {

    private ImageButton main_signup_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_signup_btn= findViewById(R.id.signup_main_btn);

        main_signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, UserLogin.class);
                startActivity(intent);
            }
        });
    }



}

