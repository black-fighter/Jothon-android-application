package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MotherRegistrationActivity extends AppCompatActivity {

    public Spinner spnLayout,spnDis,spnUpo,spnDiv,spnAge,spnDays,spnWeight,spnBabyNo,spnBabyAge,spnBabyWeight,spnBlood,spnChildBlood;
    public RelativeLayout childRl, motherRl;
    public String Name,Dis,Div,Upo,BG,ChildBG,MomAge,ChildAge,ChildNo,MomWeight,ChildWeight,GorvoDays;
    public int MobileNo;
    public List<String> District,Upozila;
    public EditText etName,etMobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_registration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

        spnAge = (Spinner) findViewById(R.id.spinner44);
        spnDays = (Spinner) findViewById(R.id.spinner411);
        spnWeight = (Spinner) findViewById(R.id.spinner43);
        spnBabyNo = (Spinner) findViewById(R.id.spinner419);
        spnDiv=(Spinner) findViewById(R.id.spinner421);
        spnDis=(Spinner) findViewById(R.id.spinner431);
        spnUpo=(Spinner) findViewById(R.id.spinner441);
        spnBabyAge=(Spinner) findViewById(R.id.spinner49);
        spnBabyWeight=(Spinner) findViewById(R.id.spinner46);
        spnBlood=(Spinner) findViewById(R.id.spinner4111);
        spnChildBlood=(Spinner) findViewById(R.id.spinner47);

        etName =(EditText) findViewById(R.id.editText41);
        etMobileNo =(EditText) findViewById(R.id.editText42);

        List<String> lsAge = new ArrayList<String>();
        for(int i=17;i<46;i++)
            lsAge.add(String.valueOf(i)+" বছর  ");
        ArrayAdapter<String> adpAge = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsAge);
        adpAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAge.setAdapter(adpAge);

        List<String> lsCAge = new ArrayList<String>();
        for(int i=0;i<24;i++)
            lsCAge.add(String.valueOf(i)+" সপ্তাহ  ");
        for(int i=6;i<13;i++)
            lsCAge.add(String.valueOf(i)+" মাস  ");
        for(int i=2;i<6;i++)
            lsCAge.add(String.valueOf(i)+" বছর  ");
        ArrayAdapter<String> adpCAge = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsCAge);
        adpCAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBabyAge.setAdapter(adpCAge);

        List<String> lsDays = new ArrayList<String>();
        for(int i=0;i<151;i++)
            lsDays.add(String.valueOf(i)+" দিন  ");
        ArrayAdapter<String> adpDays = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsDays);
        adpDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDays.setAdapter(adpDays);

               List<String> lsWeight = new ArrayList<String>();
        for(int i=30;i<101;i=i+5)
            lsWeight.add(String.valueOf(i)+"~"+String.valueOf(i+5)+" কেজি ");
        ArrayAdapter<String> adpWeight = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsWeight);
        adpWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnWeight.setAdapter(adpWeight);

        List<String> lsChildWeight = new ArrayList<String>();
        for(int i=0;i<30;i=i+2)
            lsChildWeight.add(String.valueOf(i)+"~"+String.valueOf(i+2)+" কেজি ");
        ArrayAdapter<String> adpCWeight = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsChildWeight);
        adpCWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBabyWeight.setAdapter(adpCWeight);

        List<String> lsSerial = new ArrayList<String>();
        for(int i=1;i<10;i++)
            lsSerial.add(String.valueOf(i)+" নাম্বার");
        ArrayAdapter<String> adpSerial = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsSerial);
        adpSerial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBabyNo.setAdapter(adpSerial);

        List<String> lsBloodGroup = new ArrayList<String>(Arrays.asList("A (+)ve","A (-)ve","B (+)ve","B (-)ve","AB","O"));
        ArrayAdapter<String> adplsBloodGroup = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsBloodGroup);
        adplsBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBlood.setAdapter(adplsBloodGroup);

        List<String> lsChildBloodGroup = new ArrayList<String>(Arrays.asList("A (+)ve","A (-)ve","B (+)ve","B (-)ve","AB","O"));
        ArrayAdapter<String> adplsChildBloodGroup = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lsChildBloodGroup);
        adplsChildBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnChildBlood.setAdapter(adplsChildBloodGroup);

        childRl=(RelativeLayout)this.findViewById(R.id.childLayout);
        motherRl=(RelativeLayout)this.findViewById(R.id.motherLayout);
        spnLayout=(Spinner)findViewById(R.id.dropDown);
        List<String> layoutList = new ArrayList<String>(Arrays.asList("কেবল গর্ভবতী", "বাচ্চা হয়ে গেছে"));
        ArrayAdapter<String> adpLl = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,layoutList);
        adpLl.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLayout.setAdapter(adpLl);

        spnLayout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        motherRl.setVisibility(View.VISIBLE);
                        childRl.setVisibility(View.GONE);
                        break;
                    case 1:
                        motherRl.setVisibility(View.GONE);
                        childRl.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> Division= new ArrayList<String>(Arrays.asList("Dhaka","Chittagong","Sylhet","Rajshahi","Rangpur","Khulna"));
        ArrayAdapter<String> adpDiv = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Division);
        adpDiv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDiv.setAdapter(adpDiv);
        spnDiv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Div = "Dhaka";
                        District = new ArrayList<String>(Arrays.asList("গাজিপুর", "মিরপুর", "Dhaka", "রাজবাড়ি"));
                        break;
                    case 1:
                        Div = "Chtta";
                        District = new ArrayList<String>(Arrays.asList("haw", "Cow", "Chitta", "fau"));
                        break;
                    case 4:
                        Div = "Rangpur";
                        District = new ArrayList<String>(Arrays.asList("রংপুর", "লালমনিরহাট", "পঞ্চগড়", "গাইবান্ধা", "দিনাজপুর"));
                        break;
                    default:
                        Div = "Others";
                        District = new ArrayList<String>(Arrays.asList("haw", "Cow", "Others", "fau"));
                }
                setDisSpn();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

                               {
                                   @Override
                                   public void onClick(View view) {
                                       if (ifConnected()) {
                                           Snackbar snackbar = Snackbar
                                                   .make(view, "দয়া করে আরেকবার তথ্যগুলো যাচাই করুন", Snackbar.LENGTH_LONG)
                                                   .setAction("ঠিক আছে", new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           Name = etName.getText().toString();
                                                           MobileNo = Integer.valueOf(etMobileNo.getText().toString());
                                                           MomWeight = spnWeight.getSelectedItem().toString();
                                                           MomAge = spnAge.getSelectedItem().toString();
                                                           BG = spnBlood.getSelectedItem().toString();
                                                           ChildNo = spnBabyNo.getSelectedItem().toString();
                                                           GorvoDays = spnDays.getSelectedItem().toString();
                                                           ChildAge = spnBabyAge.getSelectedItem().toString();
                                                           ChildWeight = spnBabyWeight.getSelectedItem().toString();
                                                           ChildBG = spnChildBlood.getSelectedItem().toString();

                                                           if (Integer.toString(MobileNo).length() == 11) {

                                                               Log.d("Worker registration: ", "Exec Called with " + " n" + Name + " n" + Div + " n" + Dis + " n" + " n" + String.valueOf(MobileNo) + " n" + " n" + "1" + " yes");
                                                               new doRegisterMother().execute(Name, String.valueOf(MobileNo), MomAge, ChildNo, MomWeight, GorvoDays, ChildAge, ChildWeight, ChildBG, Div, Dis, Upo, "1", "yse", BG);


                                                           } else
                                                               Toast.makeText(getApplicationContext(),"মোবাইল নাম্বার ভ্যালিড নয়।আবার চেষ্টা করুন",Toast.LENGTH_LONG).show();

                                                       }
                                                   }).setActionTextColor(Color.GREEN);

                                           snackbar.show();
                                       } else
                                           Snackbar.make(view, "ইন্টারনেট সংযোগ পাওয়া যাচ্ছে না,পুনরায় চেষ্টা করুন", Snackbar.LENGTH_LONG)
                                                   .show();


                                   }
                               }

        );
    }


    public void setDisSpn(){

        spnDis=(Spinner) findViewById(R.id.spinner431);
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
                        Upozila = new ArrayList<String>(Arrays.asList("রংপুর ", "বদরগঞ্জ", "হারাগাছ", "গাইবান্ধা ", "উলিপুর"));
                        break;
                    default:
                        Upozila = new ArrayList<String>(Arrays.asList("হ্যান উপজেলা","ত্যান উপজেলা"));
                }
                setUpospn();
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


    public void setUpospn(){

        spnUpo =(Spinner) findViewById(R.id.spinner441);
        ArrayAdapter<String> adpHC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Upozila);
        adpHC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnUpo.setAdapter(adpHC);
        Upo = spnUpo.getSelectedItem().toString();

    }


    class doRegisterMother extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/ma_registration.php";

        private static final String TAG_SUCCESS = "success";
        private static final String TAG_MESSAGE = "message";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MotherRegistrationActivity.this);
            pDialog.setMessage("লোডিং...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {



            try {

                HashMap<String, String> params = new HashMap<>();
                params.put("ma_name", args[0]);
                params.put("ma_mob_no",args[1]);
                params.put("ma_boyos",args[2]);
                params.put("ma_ba_no",args[3]);
                params.put("ma_wei",args[4]);
                params.put("ma_gorvabosthar_kotodin",args[5]);
                params.put("ma_s_boyos",args[6]);
                params.put("ma_s_wei",args[7]);
                params.put("ma_s_bl_gr",args[8]);
                params.put("ma_division",args[9]);
                params.put("ma_zilla",args[10]);
                params.put("ma_upozilla",args[11]);
                params.put("system",args[12]);
                params.put("form1",args[13]);
                params.put("ma_bl_gr",args[14]);

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
                sharedPreferencesEditor.putString("Account", "ma");
                sharedPreferencesEditor.putString("Name", Name);
                sharedPreferencesEditor.putInt("MobileNo", MobileNo);
                sharedPreferencesEditor.commit();

                Intent i = new Intent(getApplicationContext(), HomeInfoActivity.class);
                startActivity(i);
                finish();
            }else{

                Toast.makeText(MotherRegistrationActivity.this, "Something error ! Registration failed:(",
                        Toast.LENGTH_LONG).show();
                Log.d("Failure.JSON is:",":( ");
            }
        }

    }
}

