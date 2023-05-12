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
    private  CardView D1, D2, D3, D4, D5, D6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        D1=(CardView) findViewById(R.id.d1);
        D2=(CardView) findViewById(R.id.d2);
        D3=(CardView) findViewById(R.id.d3);
        D4=(CardView) findViewById(R.id.d4);
        D5=(CardView) findViewById(R.id.d5);
        D6=(CardView) findViewById(R.id.d6);


        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, AdminCategory.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy()");
    }

}
