package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MotherSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_selection);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View tv =findViewById(R.id.textView20);
            View ivMother= findViewById(R.id.imageView22);
            View btn1=findViewById(R.id.button20);
            View btn2=findViewById(R.id.button21);

            ivMother.setTransitionName(getString(R.string.mother_trans_pic));
            //tv.setTransitionName(getString(R.string.worker_tit));
            btn1.setTransitionName(getString(R.string.mother_trans_button));
            btn2.setTransitionName(getString(R.string.mother_trans_title));
        }

        Button btnCancle=(Button) findViewById(R.id.button23);
        Button btnRegister=(Button) findViewById(R.id.button21);
        Button btnlogin=(Button) findViewById(R.id.button20);

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                sharedPreferencesEditor.putString("Account", "ma");
                sharedPreferencesEditor.putString("Name", "Anon");
                sharedPreferencesEditor.commit();
                Intent i = new Intent(getApplicationContext(), HomeInfoActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MotherRegistrationActivity.class);
                startActivity(i);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MotherLoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
