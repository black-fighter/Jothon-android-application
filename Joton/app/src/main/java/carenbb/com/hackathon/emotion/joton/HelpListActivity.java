package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelpListActivity extends AppCompatActivity {


    private static final String TAG = "Help List Activity";
    private List<HelpItem> helpsList;
    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView =(RecyclerView)findViewById(R.id.recyclerview8);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refreshing help list...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new getHelpList().execute();
    }


    class getHelpList extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/help_view.php";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(HelpListActivity.this);
            pDialog.setMessage("লোডিং...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            try {

                HashMap<String, String> params = new HashMap<>();

                Log.d(TAG, "request starting ");

                JSONObject json = jsonParser.makeHttpRequest(
                        URL, "GET", params);

                if (json != null) {
                    Log.d(TAG, "JSON result - " + json.toString());

                        JSONArray helps = json.optJSONArray("Help");
                        helpsList = new ArrayList<>();

                        for (int i = 0; i < helps.length(); i++) {
                            JSONObject help = helps.optJSONObject(i);
                            HelpItem item = new HelpItem();
                            item.setMotherName(help.optString("Name"));
                            item.setMsg(help.optString("Msg"));
                            item.setDateTime(help.optString("Time"));
                            helpsList.add(item);
                        }

                    return json;
                }

            } catch (Exception e) {
                Log.d(TAG,e.getLocalizedMessage());
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(JSONObject json) {


            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }

            if (json != null) {
                adapter = new MyRecyclerAdapter(HelpListActivity.this, helpsList);
                recyclerView.setAdapter(adapter);
                Log.d(TAG,"Recycler view added");

            }
            else {
                Toast.makeText(getApplicationContext(),"Failed to load help",Toast.LENGTH_LONG);
            }

        }

    }

}
