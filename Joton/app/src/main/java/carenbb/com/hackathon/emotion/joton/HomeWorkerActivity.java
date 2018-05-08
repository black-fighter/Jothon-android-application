package carenbb.com.hackathon.emotion.joton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HomeWorkerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

   // private CoordinatorLayout coordinatorLayout;
    private TextView tvUserName,tvUserInfo;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_worker);

        Log.d("HomeWorkerActivity :", "Home worker alived");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
        final String userName = sharedPreferences.getString("Name", "Anon");
        final int userMobileNo = sharedPreferences.getInt("MobileNo", 01);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
        navigationView=(NavigationView) findViewById(R.id.nav_view7);
        View header = navigationView.getHeaderView(0);
        tvUserInfo=(TextView) header.findViewById(R.id.textViewUserInfo);
        tvUserName=(TextView) header.findViewById(R.id.textViewUserName);
        View parent =findViewById(R.id.main_content);
        Button help = (Button) findViewById(R.id.button32);
        Button mom = (Button) findViewById(R.id.button31);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(), HelpListActivity.class);
                startActivity(i2);
            }
        });
        mom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(), AllMotherListActivity.class);
                startActivity(i2);
            }
        });
        if (userName=="Anon")
        {
            Toast.makeText(getApplicationContext(),"পূর্ব্বর্তী সেসন পাওয়া যাচ্ছে না।দয়া করে পুনরায় লগইন করুন",Toast.LENGTH_LONG).show();
            Intent i=new Intent(getApplicationContext(),WorkerRegistrationActivity.class);
            startActivity(i);
            finish();
           /* Snackbar snackbar = Snackbar.make(n,"পূর্ব্বর্তী সেসন পাওয়া যাচ্ছে না।দয়া করে পুনরায় লগইন করুন",Snackbar.LENGTH_LONG)
                    .setAction("ঠিক আছে", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getApplicationContext(),WorkerRegistrationActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }).setActionTextColor(Color.GREEN).show();*/
        }
        else {
            tvUserName.setText(userName);
            tvUserInfo.setText("মোবাইল: 0"+String.valueOf(userMobileNo));
        }

        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view7);
        if(navigationView != null)
        {
            setupDrawerContent(navigationView);
        }

        /*ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);*/


        /*fab.setOnClickListener(new View.OnClickListener()

                               {
                                   @Override
                                   public void onClick(View view) {
                                           Snackbar snackbar = Snackbar
                                                   .make(view, "দয়া করে আরেকবার তথ্যগুলো যাচাই করুন", Snackbar.LENGTH_LONG)
                                                   .setAction("ঠিক আছে", new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {

                                                       }
                                                   }).setActionTextColor(Color.GREEN);

                                           snackbar.show();
                                       }
                               }

        );*/
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
        adapter.addFragment(new InfoChildListFragment(), "জরুরী সাহায্য");
        adapter.addFragment(new InfoChildListFragment(), "সব মায়ের বার্তাবলী");
        adapter.addFragment(new InfoListFragment(), "সকল মায়ের তথ্যাবলী");
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
                            case R.id.nav_logout:

                                final SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                                sharedPreferencesEditor.putString("Account", "non");
                                sharedPreferencesEditor.putString("Name", "Anon");
                                sharedPreferencesEditor.putInt("MobileNo", 01);
                                sharedPreferencesEditor.commit();
                                Toast.makeText(getApplicationContext(), "লগ আউট সল", Toast.LENGTH_LONG);
                                finish();
                                break;
                            case R.id.nav_help_view:
                                Intent i2 = new Intent(getApplicationContext(), HelpListActivity.class);
                                startActivity(i2);
                                break;
                            case R.id.nav_ma_view:
                                Intent i3=new Intent(getApplicationContext(),AllMotherListActivity.class);
                                startActivity(i3);
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

}
