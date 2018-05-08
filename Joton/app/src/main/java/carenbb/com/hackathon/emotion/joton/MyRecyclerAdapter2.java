package carenbb.com.hackathon.emotion.joton;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 03-Apr-16........
 */
public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.MotherListRowHolder> {

    private List<MotherItem> motherItemList;
    private String Details;
    private Context mContext;


    public MyRecyclerAdapter2(Context context, List<MotherItem> motherItemList) {
        this.motherItemList = motherItemList;
        this.mContext = context;
    }


    public static class MotherListRowHolder extends RecyclerView.ViewHolder {
      protected TextView tvName,tvDt,tvMsg;

        public MotherListRowHolder(View view) {
            super(view);
            this.tvName = (TextView) view.findViewById(R.id.textViewName);
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
        Details ="মোবাইল নং : "+motherItem.getMobileNo()+"\nওজন:"+motherItem.getWeight()+"\nসন্তান নং : "+motherItem.getBaby()+"\nগর্ভাবস্থা :"+motherItem.getDays()+" দিন";
        motherListRowHolder.tvName.setText(motherItem.getMotherName());
        motherListRowHolder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext,MotherDetailActivity.class);
                i.putExtra("DETAILS",Details);
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
