package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeInfoActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView tvUserName,tvUserInfo;
    private NavigationView navigationView;
    public String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_info);

        Log.d("HomeInfoActivity :", "Home info alived");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
        userName = sharedPreferences.getString("Name", "Anon");
        final int userMobileNo = sharedPreferences.getInt("MobileNo", 01);

        navigationView=(NavigationView) findViewById(R.id.nav_view5);
        View header = navigationView.getHeaderView(0);
        tvUserInfo=(TextView) header.findViewById(R.id.textViewUserInfo);
        tvUserName=(TextView) header.findViewById(R.id.textViewUserName);
        View parent =findViewById(R.id.main_content);

        if (userName=="Anon")
        {
            tvUserName.setText("অনিবন্ধিত মা");
            tvUserInfo.setText("");
            RelativeLayout relativeLayout1 =(RelativeLayout)findViewById(R.id.topLayout1);
            relativeLayout1.setVisibility(View.VISIBLE);
            navigationView.getMenu().findItem(R.id.nav_help).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_message).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_nearHC).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_nearWorker).setVisible(false);
        }
        else {
            tvUserName.setText(userName);
            tvUserInfo.setText("মোবাইল: 0"+String.valueOf(userMobileNo));
            RelativeLayout relativeLayout2 =(RelativeLayout)findViewById(R.id.topLayout2);
            relativeLayout2.setVisibility(View.VISIBLE);

            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_register).setVisible(false);

        }

        Button btnReg =(Button) findViewById(R.id.button51);
        Button btnLog =(Button) findViewById(R.id.button52);
        Button btnHelp =(Button) findViewById(R.id.button53);
        Button btnMsg =(Button) findViewById(R.id.button54);
        Button btnViewWorker =(Button) findViewById(R.id.button56);

        btnViewWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AllWorkerListActivity.class);
                startActivity(i);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AllWorkerListActivity.class);
                startActivity(i);
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent i=new Intent(getApplicationContext(),MotherRegistrationActivity.class);
                startActivity(i);
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i=new Intent(getApplicationContext(),MotherLoginActivity.class);
                startActivity(i);
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                showHelpMsgDialog();
            }
        });

        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view5);
        if(navigationView != null)
        {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new InfoListFragment(), "মায়ের যত্ন");
        adapter.addFragment(new InfoChildListFragment(), "শিশুর যত্ন"); //Todo: all change goes to here
        adapter.addFragment(new InfoListFragment(), "রোগবালাই");
        adapter.addFragment(new InfoListFragment(), "অন্যান");
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                      //  menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch(id)
                        {
                            case R.id.nav_register:

                                Intent i = new Intent(getApplicationContext(), MotherRegistrationActivity.class);
                                startActivity(i);
                                break;
                            case R.id.nav_login:

                                Intent i2=new Intent(getApplicationContext(),MotherLoginActivity.class);
                                startActivity(i2);
                                break;
                            case R.id.nav_logout:
                                final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                                sharedPreferencesEditor.putString("Account", "non");
                                sharedPreferencesEditor.putString("Name", "Anon");
                                sharedPreferencesEditor.putInt("MobileNo", 01);
                                sharedPreferencesEditor.commit();
                                finish();
                                break;
                            case R.id.nav_help:
                                showHelpMsgDialog();
                                break;
                        }
                        return true;
                    }
                });
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    public void showHelpMsgDialog()
    {
        final AlertDialog.Builder builder=new AlertDialog.Builder(HomeInfoActivity.this);
        builder.setTitle("জরুরী সাহায্য");
        builder.setMessage("সত্যি জরুরী সাহায্য দরকার?");
        builder.setPositiveButton("হ্যা,জরুরী :( ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("Help Sending with: ", userName);
                new SendHelpRequest().execute(userName, "Urgent Help Plz", "1", "yes");
                //dialog.dismiss();
            }
        });
        builder.setNegativeButton("দুঃখিত,লাগবে না ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    class SendHelpRequest extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/help_insert.php";

        private static final String TAG_SUCCESS = "success";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(HomeInfoActivity.this);
            pDialog.setMessage("পাঠানো হচ্ছে......");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {



            try {

                HashMap<String, String> params = new HashMap<>();
                params.put("ma_name", args[0]);
                params.put("msg",args[1]);
                params.put("system",args[2]);
                params.put("form_help",args[3]);

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
                Log.d("Success!JSON is:", json.toString());

                Toast.makeText(getApplicationContext(),"সাহায্যের অনুরোধটি নিকটস্থ স্বাস্থ্যকর্মীদের কাছে পাঠানো হয়েছে।তারা আপনাকে সাহায্যের জন্য প্রস্তুত থাকবে।",Toast.LENGTH_LONG).show();


                /*AlertDialog.Builder builder2=new AlertDialog.Builder(getApplicationContext());
                builder2.setMessage("সাহায্যের অনুরোধটি নিকটস্থ স্বাস্থ্যকর্মীদের কাছে পাঠানো হয়েছে।তারা আপনাকে সাহায্যের জন্য প্রস্তুত থাকবে।");
                builder2.setPositiveButton("ঠিক আছে", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder2.setCancelable(true);
                builder2.create();
                builder2.show();*/

                Toast.makeText(getApplicationContext(),"পাঠানো হয়েছে",Toast.LENGTH_LONG);
            }else{

                Toast.makeText(getApplicationContext(), "Something error !",
                        Toast.LENGTH_LONG).show();
                Log.d("Failure.JSON is:", ":( ");
            }
        }

    }

}
