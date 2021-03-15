package edu.fordham.times_table;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{
    //list of data
    List<String> data;

    MyAdapter(List<String> l){
        data = l;
    }

    //view holder is a container that contains views wrapper class
    static class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView){
            super(itemView);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Instantiates a layout XML file into its corresponding View objects
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //goes to ViewHolder then the corresponding itemView then from that itemView gets the itemText
        // sets the text to the position the list is in
         TextView tv = holder.itemView.findViewById(R.id.itemView);
         tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
