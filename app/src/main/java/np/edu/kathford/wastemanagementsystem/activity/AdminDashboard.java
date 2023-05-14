package np.edu.kathford.wastemanagementsystem.activity;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.wastemanagementsystem.R;


public class AdminDashboard extends AppCompatActivity {

    private ImageButton login_button;
    private CardView profileCardView;
    private CardView categoryCardView;
    private CardView manageUserCardView;
    private CardView signupCardView;
    private CardView paymentCardView;
    private CardView logoutCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        profileCardView = (CardView) findViewById(R.id.profileId);
        categoryCardView = (CardView) findViewById(R.id.categoryId);
        manageUserCardView = (CardView) findViewById(R.id.manageUserId);
        signupCardView = (CardView) findViewById(R.id.signupAdminId);
        paymentCardView = (CardView) findViewById(R.id.viewPaymentId);
        logoutCardView = (CardView) findViewById(R.id.logoutId);

        categoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, AdminCategory.class);
                startActivity(intent);

            }
        });

        signupCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, AdminSignup.class);
                startActivity(intent);

            }
        });
        logoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, AdminLogin.class);
                startActivity(intent);

            }
        });

        /*resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, ResetPassword.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");
    }

}
