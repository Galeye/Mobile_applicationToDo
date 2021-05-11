package edu.gcit.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class wordListAdapter extends RecyclerView.Adapter<wordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;

    private LayoutInflater mInflater;

    public wordListAdapter (Context context, LinkedList<String> mWordList){
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    public wordListAdapter(LinkedList<String> mWordList) {
        this.mWordList = mWordList;
    }

    //calling the viewHolder that has been created
    @NonNull
    @Override
    public wordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_list_item, parent, false);
        return  new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull wordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    //to get the size of the linkedlist
    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView wordItemView;
        final wordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, wordListAdapter mAdapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int mPos = getLayoutPosition();
            String element = mWordList.get(mPos);
            mWordList.set(mPos, "Clicked" + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
