package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkerSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_selection);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           // View tv =findViewById(R.id.textView20);
            View ivWorker= findViewById(R.id.imageView22);
            View btn2=findViewById(R.id.button21);

            ivWorker.setTransitionName(getString(R.string.worker_pic));
           // tv.setTransitionName(getString(R.string.worker_tit));
            btn2.setTransitionName(getString(R.string.worker_But));
        }
        Button btnReg =(Button)findViewById(R.id.button21);
        Button btnLog =(Button)findViewById(R.id.button20);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WorkerRegistrationActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    View tv =findViewById(R.id.textView20);
                    View btn2=findViewById(R.id.button21);

                    tv.setTransitionName(getString(R.string.worker_tit));
                    btn2.setTransitionName(getString(R.string.worker_But));

                    Pair<View, String> pair2 = Pair.create(tv, tv.getTransitionName());
                    Pair<View, String> pair3 = Pair.create(btn2, btn2.getTransitionName());

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(WorkerSelectionActivity.this, pair2, pair3);
                    startActivity(i, options.toBundle());
                }
                else {
                    startActivity(i);
                }
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WorkerLoginActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    View tv =findViewById(R.id.textView20);
                    View btn2=findViewById(R.id.button21);

                    tv.setTransitionName(getString(R.string.worker_tit));
                    btn2.setTransitionName(getString(R.string.worker_But));

                    Pair<View, String> pair2 = Pair.create(tv, tv.getTransitionName());
                    Pair<View, String> pair3 = Pair.create(btn2, btn2.getTransitionName());

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(WorkerSelectionActivity.this, pair2, pair3);
                    startActivity(i, options.toBundle());
                }
                else {
                    startActivity(i);
                }
            }
        });


    }
}
