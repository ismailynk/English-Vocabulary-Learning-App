package com.company.kelimeezberprojesi1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class wordadapter extends RecyclerView.Adapter<wordadapter.wordholder> {
    private List<sqlwords> words= new ArrayList<>();
    @NonNull
    @Override
    public wordholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
        return new wordholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wordholder holder, int position) {
        sqlwords current = words.get(position);
        holder.txttr.setText(current.getTr());
        holder.txting.setText(current.getIng());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWords(List<sqlwords> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    class wordholder extends RecyclerView.ViewHolder{

        private TextView txttr;
        private TextView txting;

        public wordholder(@NonNull View itemView) {
            super(itemView);
            txting = itemView.findViewById(R.id.txting);
            txttr = itemView.findViewById(R.id.txtr);
        }
    }

}
