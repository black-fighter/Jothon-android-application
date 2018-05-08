package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MotherLoginActivity extends AppCompatActivity {

    public String Name;
    public int MobileNo;
    public EditText etMobileNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View tv =findViewById(R.id.textView60);
            //View ivWorker= findViewById(R.id.imageView22);
            View btn2=findViewById(R.id.fab);
;
            tv.setTransitionName(getString(R.string.worker_tit));
            btn2.setTransitionName(getString(R.string.worker_But));
        }

        etMobileNo =(EditText) findViewById(R.id.editText61);


            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick(View view) {
                                           if (ifConnected())
                                           {
                                               Snackbar snackbar = Snackbar
                                                       .make(view, "দয়া করে আরেকবার তথ্যগুলো যাচাই করুন", Snackbar.LENGTH_LONG)
                                                       .setAction("ঠিক আছে", new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               MobileNo = Integer.valueOf(etMobileNo.getText().toString());

                                                               Log.d("Mother Login : ", "Exec Called with " + "n" + String.valueOf(MobileNo) + " n"  + " n" + "1" + " yes");
                                                               new doLoginMother().execute(String.valueOf(MobileNo), "1", "yes");
                                                           }
                                                       }).setActionTextColor(Color.GREEN);

                                               snackbar.show();
                                           }
                                           else Snackbar.make(view, "ইন্টারনেট সংযোগ পাওয়া যাচ্ছে না,পুনরায় চেষ্টা করুন", Snackbar.LENGTH_LONG)
                                                   .show();


                                       }
                                   }

            );


        }


    public boolean ifConnected()
    {
        try{

            ConnectivityManager networkInfo = (ConnectivityManager) getSystemService(MotherLoginActivity.CONNECTIVITY_SERVICE) ;
            networkInfo.getActiveNetworkInfo().isConnectedOrConnecting() ;

            Log.d("1", "Net avail:"
                    + networkInfo.getActiveNetworkInfo().isConnectedOrConnecting());

            ConnectivityManager cm = (ConnectivityManager) getSystemService(MotherLoginActivity.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                Log.d("2", "Network available:true");
                return true;

            } else {
                Log.d("3", "Network available:false");
                return false;
            }

        }catch(Exception e){
            return false ;
        }
       /* ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();*/
    }


    class doLoginMother extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/ma_login.php";

        private static final String TAG_SUCCESS = "success";
        private static final String TAG_NAME = "name";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MotherLoginActivity.this);
            pDialog.setMessage("লোডিং...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            try {

                HashMap<String, String> params = new HashMap<>();
                params.put("mob_no", args[0]);
                params.put("system",args[1] );
                params.put("form_login",args[2] );

               /* params.put("sas_name", Name);
                params.put("sas_division", Div);
                params.put("sas_zilla",Dis );
                params.put("sasthokendro_name",HC );
                params.put("sas_phone",String.valueOf(MobileNo) );
                params.put("sas_password",String.valueOf(Pass) );
                params.put("system","1");
                params.put("form1","yes" ); args[0] execute(Name, Div,Dis,HC,String.valueOf(MobileNo),String.valueOf(Pass),"1","yes"); */

                Log.d("Mother Login:", "request starting ");

                JSONObject json = jsonParser.makeHttpRequest(
                        URL, "GET", params);

                if (json != null) {
                    Log.d("Mother Login:", "JSON result - "+json.toString());

                    return json;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(JSONObject json) {

            int success = 0;
            String Name = "";

            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }

            if (json != null) {

                try {
                    success = json.getInt(TAG_SUCCESS);
                    Name = json.getString(TAG_NAME);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            if (success == 1) {
                Log.d("Success!JSON is:",json.toString());

                final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                sharedPreferencesEditor.putString("Account", "ma");
                sharedPreferencesEditor.putString("Name", Name);
                sharedPreferencesEditor.putInt("MobileNo", MobileNo);
                sharedPreferencesEditor.commit();

                Intent i = new Intent(getApplicationContext(), HomeInfoActivity.class);
                startActivity(i);
                finish();
            }else{

                Toast.makeText(MotherLoginActivity.this,"Something error!Login failed :(" ,
                        Toast.LENGTH_LONG).show();
                Log.d("Failure.JSON is:",":( ");
            }
        }

    }

    }
