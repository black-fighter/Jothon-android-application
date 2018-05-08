package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn1= (Button) findViewById(R.id.button31);
        Typeface tf1=Typeface.createFromAsset(getAssets(),"font/Amar_Bangla.ttf");

        btn1.setTypeface(tf1);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                Intent i= new Intent(getApplicationContext(),MotherRegistrationActivity.class);
                startActivity(i);
            }
        });

    }

}
