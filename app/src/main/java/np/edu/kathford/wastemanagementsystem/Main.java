package np.edu.kathford.wastemanagementsystem;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentCategory fragmentCategory= new FragmentCategory();
        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
//        transaction.add(R.id.linearLayoutContainer,fragmentCategory);
        transaction.commit();
        Log.d("MainActivity","onCreate()");
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
