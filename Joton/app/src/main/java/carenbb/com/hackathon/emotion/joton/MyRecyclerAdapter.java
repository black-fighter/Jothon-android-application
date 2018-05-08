package carenbb.com.hackathon.emotion.joton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by HP on 03-Apr-16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.HelpListRowHolder> {

    private static final String TAG = "Help List Activity";

    private List<HelpItem> helpItemList;

    private Context mContext;


    public MyRecyclerAdapter(Context context, List<HelpItem> helpItemList) {
        this.helpItemList = helpItemList;
        this.mContext = context;
    }


    public static class HelpListRowHolder extends RecyclerView.ViewHolder {
      protected TextView tvName,tvDt,tvMsg;

        public HelpListRowHolder(View view) {
            super(view);
            this.tvName = (TextView) view.findViewById(R.id.textViewName);
            this.tvMsg = (TextView) view.findViewById(R.id.textViewMsg);
            this.tvDt = (TextView) view.findViewById(R.id.textViewDT);
        }


    }



    @Override
    public HelpListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.help_row, null);
        HelpListRowHolder mh = new HelpListRowHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(HelpListRowHolder helpListRowHolder, final int i) {
        HelpItem helpItem = helpItemList.get(i);
        helpListRowHolder.tvName.setText(helpItem.getMotherName());
        helpListRowHolder.tvMsg.setText(helpItem.getMsg());
        helpListRowHolder.tvDt.setText(helpItem.getDateTime());
        //helpListRowHolder.bind(helpItemList.get(i), listener);
        /*helpListRowHolder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Recycle Click" + i, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

   /* public void bind (final HelpItem item, final AdapterView.OnItemClickListener listener) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });*/


    @Override
    public int getItemCount() {
        return (null != helpItemList ? helpItemList.size() : 0);
    }
}
