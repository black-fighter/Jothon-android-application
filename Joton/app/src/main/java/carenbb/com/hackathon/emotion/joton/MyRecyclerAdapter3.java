package carenbb.com.hackathon.emotion.joton;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 03-Apr-16........
 */
public class MyRecyclerAdapter3 extends RecyclerView.Adapter<MyRecyclerAdapter3.MotherListRowHolder> {

    private List<MotherItem> motherItemList;
    private String Details;
    private Context mContext;


    public MyRecyclerAdapter3(Context context, List<MotherItem> motherItemList) {
        this.motherItemList = motherItemList;
        this.mContext = context;
    }


    public static class MotherListRowHolder extends RecyclerView.ViewHolder {
      protected TextView tvName,tvMobile;
              protected ImageView iv;

        public MotherListRowHolder(View view) {
            super(view);
            this.tvName = (TextView) view.findViewById(R.id.textViewName);
            this.tvMobile =(TextView) view.findViewById(R.id.textViewMsg);
            this.iv=(ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public MotherListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mother_row, null);
        MotherListRowHolder mh = new MotherListRowHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(MotherListRowHolder motherListRowHolder, int i) {
        final MotherItem motherItem = motherItemList.get(i);
        motherListRowHolder.iv.setImageResource(R.drawable.worker_user3);
        motherListRowHolder.tvMobile.setText(motherItem.getMobileNo());
        motherListRowHolder.tvName.setText(motherItem.getMotherName());
        motherListRowHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext,MotherDetailActivity.class);
                //i.putExtra("DETAILS",Details);
                i.putExtra("NAME",motherItem.getMotherName());
                mContext.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != motherItemList ? motherItemList.size() : 0);
    }
}
