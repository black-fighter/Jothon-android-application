package carenbb.com.hackathon.emotion.joton;

import android.app.ProgressDialog;
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
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllWorkerListActivity extends AppCompatActivity {


    private static final String TAG = "Worker List Activity";
    private List<MotherItem> mothersList;
    private RecyclerView recyclerView;
    private MyRecyclerAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_mother_list);
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
                Snackbar.make(view, "Refreshing worker list...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new getWorkerList().execute();

    }

    class getWorkerList extends AsyncTask<String, String, JSONObject> {

        JSONParser jsonParser = new JSONParser();

        private ProgressDialog pDialog;

        private static final String URL = "http://kibibytes.org/api/joton/view_sasthokormi.php";

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(AllWorkerListActivity.this);
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

                    JSONArray mothers = json.optJSONArray("Workers");
                    mothersList = new ArrayList<>();

                    for (int i = 0; i < mothers.length(); i++) {
                        JSONObject mother = mothers.optJSONObject(i);
                        MotherItem item = new MotherItem();
                        item.setMotherName(mother.optString("Name"));
                        item.setMobileNo(mother.optString("Mobile"));
                        mothersList.add(item);
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

                adapter = new MyRecyclerAdapter3(AllWorkerListActivity.this, mothersList);
                recyclerView.setAdapter(adapter);
                Log.d(TAG,"Recycler view added");

            }
            else {
                Toast.makeText(getApplicationContext(), "Failed to load help", Toast.LENGTH_LONG);
            }

        }

    }


}
