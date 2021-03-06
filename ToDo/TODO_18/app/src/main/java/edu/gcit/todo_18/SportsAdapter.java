package edu.gcit.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSportData;
    private Context mContext;

    SportsAdapter(Context context, ArrayList<Sport> SportData){
        this.mSportData = SportData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sport currentSport = mSportData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mInfo;
        private ImageView mSportsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView)itemView.findViewById(R.id.title);
            mInfo = (TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);
        }

        void bindTo(Sport currentSport){
           mTitle.setText(currentSport.getTitle());
           mInfo.setText(currentSport.getInfo());
           //to load the images
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
        }
    }

}
