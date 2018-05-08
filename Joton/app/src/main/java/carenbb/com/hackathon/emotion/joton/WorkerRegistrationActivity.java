package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WorkerRegistrationActivity extends AppCompatActivity {

    public String Name,Dis,Div,HC;
    public int MobileNo,Pass;
    public List<String> District;
    public List<String> HealthCenter;
    public Spinner spnDis;
    public Spinner spnDiv;
    public Spinner spnHC;
    public EditText etName;
    public EditText etPass;
    public EditText etMobileNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_registration);
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

        spnDiv=(Spinner) findViewById(R.id.spinner61);
        spnDis=(Spinner) findViewById(R.id.spinner62);
        spnHC=(Spinner) findViewById(R.id.spinner63);

        etName =(EditText) findViewById(R.id.editText61);
        etMobileNo =(EditText) findViewById(R.id.editText62);
        etPass =(EditText) findViewById(R.id.editText63);

        etName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
            }
        });

        List<String> Division= new ArrayList<String>(Arrays.asList("Dhaka","Chittagong","Sylhet","Rajshahi","Rangpur","Khulna"));
      //  List<String> District= new ArrayList<String>();
       // List<String> HealthCenter= new ArrayList<String>();

        ArrayAdapter<String> adpDiv = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Division);
        adpDiv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDiv.setAdapter(adpDiv);
        spnDiv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                             @Override
                                             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                 switch (position) {
                                                     case 0:
                                                         Div="Dhaka";
                                                         District = new ArrayList<String>(Arrays.asList("গাজিপুর", "মিরপুর", "Dhaka", "রাজবাড়ি"));
                                                         break;
                                                     case 1:
                                                         Div="Chtta";
                                                         District = new ArrayList<String>(Arrays.asList("haw", "Cow", "Chitta", "fau"));
                                                         break;
                                                     case 4:
                                                         Div="Rangpur";
                                                         District = new ArrayList<String>(Arrays.asList("রংপুর","লালমনিরহাট","পঞ্চগড়","গাইবান্ধা","দিনাজপুর"));
                                                         break;
                                                     default:
                                                         Div="Others";
                                                         District = new ArrayList<String>(Arrays.asList("haw", "Cow", "Others", "fau"));
                                                 }
                                                 setDisSpn();

                                             }

                                             @Override
                                             public void onNothingSelected(AdapterView<?> parent) {

                                             }
                                         }

        );




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
                                                               Name = etName.getText().toString();
                                                               MobileNo = Integer.valueOf(etMobileNo.getText().toString());
                                                               Pass = Integer.valueOf(etPass.getText().toString());

                                                               Log.d("Worker registration: ", "Exec Called with " + " n" + Name + " n" + Div + " n" + Dis + " n" + HC + " n" + String.valueOf(MobileNo) + " n" + String.valueOf(Pass) + " n" + "1" + " yes");
                                                               new doRegisterWorker().execute(Name, Div, Dis, HC, String.valueOf(MobileNo), String.valueOf(Pass), "1", "yes");
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

    public void setDisSpn(){

        spnDis=(Spinner) findViewById(R.id.spinner62);
        ArrayAdapter<String> adpDis = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, District);
        adpDis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDis.setAdapter(adpDis);

        spnDis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Dis = spnDis.getSelectedItem().toString();
               // Toast.makeText(getApplicationContext(), "selected Dis is : " + selectedDis, Toast.LENGTH_LONG).show();
                switch (Dis) {
                    case "রংপুর":
                        HealthCenter = new ArrayList<String>(Arrays.asList("রংপুর স্বাস্থ্য কমপ্লেক্স", "রংপুর সদর স্বাস্থ্যকেন্দ্র", "রাজেন্দ্রপুর স্বাস্থ্য কমপ্লেক্স", "গাইবান্ধা স্বাস্থ্য কমপ্লেক্স", "দিনাজপুর স্বাস্থ্য কমপ্লেক্স"));
                        break;
                    default:
                        HealthCenter = new ArrayList<String>(Arrays.asList("হ্যান স্বাস্থ্য কমপ্লেক্স", "ত্যান সদর স্বাস্থ্যকেন্দ্র"));
                }
                setHCspn();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public boolean ifConnected()
    {
        try{

            ConnectivityManager networkInfo = (ConnectivityManager) getSystemService(WorkerRegistrationActivity.CONNECTIVITY_SERVICE) ;
            networkInfo.getActiveNetworkInfo().isConnectedOrConnecting() ;

            Log.d("1", "Net avail:"
                    + networkInfo.getActiveNetworkInfo().isConnectedOrConnecting());

            ConnectivityManager cm = (ConnectivityManager) getSystemService(WorkerRegistrationActivity.CONNECTIVITY_SERVICE);
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


    public void setHCspn(){

        spnHC =(Spinner) findViewById(R.id.spinner63);
        ArrayAdapter<String> adpHC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HealthCenter);
        adpHC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnHC.setAdapter(adpHC);
        HC = spnHC.getSelectedItem().toString();

    }


    class doRegisterWorker extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/sasthokormi_registration.php";

        private static final String TAG_SUCCESS = "success";
        private static final String TAG_MESSAGE = "message";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(WorkerRegistrationActivity.this);
            pDialog.setMessage("লোডিং...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            try {

                HashMap<String, String> params = new HashMap<>();
                params.put("sas_name", args[0]);
                params.put("sas_division", args[1]);
                params.put("sas_zilla",args[2] );
                params.put("sasthokendro_name",args[3] );
                params.put("sas_phone",args[4] );
                params.put("sas_password",args[5]);
                params.put("system",args[6]);
                params.put("form1",args[7] );

               /* params.put("sas_name", Name);
                params.put("sas_division", Div);
                params.put("sas_zilla",Dis );
                params.put("sasthokendro_name",HC );
                params.put("sas_phone",String.valueOf(MobileNo) );
                params.put("sas_password",String.valueOf(Pass) );
                params.put("system","1");
                params.put("form1","yes" ); args[0] execute(Name, Div,Dis,HC,String.valueOf(MobileNo),String.valueOf(Pass),"1","yes"); */

                Log.d("Worker registration:", "request starting with -");

                JSONObject json = jsonParser.makeHttpRequest(
                        URL, "GET", params);

                if (json != null) {
                    Log.d("JSON result", json.toString());

                    return json;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(JSONObject json) {

            int success = 0;
            String message = "";

            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }

            if (json != null) {

                try {
                    success = json.getInt(TAG_SUCCESS);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            if (success == 1) {
                Log.d("Success!JSON is:",json.toString());

                final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                sharedPreferencesEditor.putString("Account", "worker");
                sharedPreferencesEditor.putString("Name", Name);
                sharedPreferencesEditor.putInt("MobileNo", MobileNo);
                sharedPreferencesEditor.commit();

                Intent i = new Intent(getApplicationContext(), HomeWorkerActivity.class);
                startActivity(i);
                finish();
            }else{

                Toast.makeText(WorkerRegistrationActivity.this,"Something error :(" ,
                        Toast.LENGTH_LONG).show();
                Log.d("Failure.JSON is:",":( ");
            }
        }

    }

    }
