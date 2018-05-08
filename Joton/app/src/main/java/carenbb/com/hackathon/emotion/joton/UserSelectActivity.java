package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

       /* if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View tv =findViewById(R.id.textView20);
            tv.setTransitionName(getString(R.string.worker_tit));
        }*/

         TextView tv =(TextView) findViewById(R.id.textView20);
        TextView tv2 =(TextView) findViewById(R.id.textView21);
         Button btn1=(Button) findViewById(R.id.button20);
         Button btn2=(Button) findViewById(R.id.button21);
         ImageView ivWorker=(ImageView) findViewById(R.id.imageView22);

        Typeface tf1=Typeface.createFromAsset(getAssets(),"font/Amar_Bangla.ttf");
        tv.setTypeface(tf1);
        tv2.setTypeface(tf1);
        btn1.setTypeface(tf1);
        btn2.setTypeface(tf1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MotherSelectionActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    View tv = findViewById(R.id.textView20);
                    View tv2 = findViewById(R.id.textView21);
                    View btn1 = findViewById(R.id.button20);
                    View btn2 = findViewById(R.id.button21);
                    View ivMother = findViewById(R.id.imageView21);


                    ivMother.setTransitionName(getString(R.string.mother_trans_pic));
                    btn1.setTransitionName(getString(R.string.mother_trans_button));
                    btn2.setTransitionName(getString(R.string.mother_trans_title));

                    Pair<View, String> pair1 = Pair.create(ivMother, ivMother.getTransitionName());
                    Pair<View, String> pair2 = Pair.create(btn1, btn1.getTransitionName());
                    Pair<View, String> pair3 = Pair.create(btn2, btn2.getTransitionName());

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(UserSelectActivity.this, pair1, pair2, pair3);
                    startActivity(i, options.toBundle());
                } else {
                    startActivity(i);
                }
               // finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), WorkerSelectionActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    View tv =findViewById(R.id.textView20);
                    View tv2 = findViewById(R.id.textView21);
                    View btn1=findViewById(R.id.button20);
                    View btn2=findViewById(R.id.button21);
                    View ivWorker= findViewById(R.id.imageView22);

                    tv.setTransitionName(getString(R.string.worker_tit));
                    btn2.setTransitionName(getString(R.string.worker_But));
                    ivWorker.setTransitionName(getString(R.string.worker_pic));

                    Pair<View, String> pair1 = Pair.create(ivWorker, ivWorker.getTransitionName());
                    //Pair<View, String> pair2 = Pair.create(tv, tv.getTransitionName());
                    Pair<View, String> pair3 = Pair.create(btn2, btn2.getTransitionName());

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(UserSelectActivity.this, pair1, pair3);
                    startActivity(i, options.toBundle());
                }
                else {
                    startActivity(i);
                }
            }
        });
    }

}
