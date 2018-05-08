package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        TextView tv =(TextView) findViewById(R.id.textView10);
        Typeface tf1=Typeface.createFromAsset(getAssets(), "font/Amar_Bangla.ttf");
        tv.setTypeface(tf1);

         SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
        account = sharedPreferences.getString("Account","non");

        //String curName = sharedPreferences.getString( "name","anonymus");


        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    if (account.equals("worker")){
                        Log.d("MainActivity :","Going to worker page");
                        Intent i = new Intent(getApplicationContext(), HomeWorkerActivity.class);
                        startActivity(i);
                    }
                    else if (account.equals("ma")){
                        Log.d("MainActivity :","Going to mother page");
                        Intent i = new Intent(getApplicationContext(), HomeInfoActivity.class);
                        startActivity(i);
                    }
                    else {
                        Log.d("MainActivity :","Going to selector page");
                        Intent i = new Intent(getApplicationContext(), UserSelectActivity.class);
                        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            View tv =findViewById(R.id.textView10);
                            tv.setTransitionName(getString(R.string.worker_tit));;
                            Pair<View, String> pair1 = Pair.create(tv, tv.getTransitionName());

                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(MainActivity.this, pair1);
                            startActivity(i, options.toBundle());
                        }*/

                         startActivity(i);
                    }

                    supportFinishAfterTransition();
                }
            }
        };
        splashThread.start();
    }


    @Override
    public void onBackPressed() {

        return;
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
    
}
