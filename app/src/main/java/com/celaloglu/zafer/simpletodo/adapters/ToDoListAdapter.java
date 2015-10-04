package com.celaloglu.zafer.simpletodo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.celaloglu.zafer.simpletodo.R;
import com.celaloglu.zafer.simpletodo.models.ToDoTitle;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder>{

    private List<ToDoTitle> titles;
    public ToDoListAdapter(List<ToDoTitle> titles){
        this.titles = titles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(titles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        View parent;

        public ViewHolder(View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            parent.setOnClickListener(this);
            textView = (TextView)itemView.findViewById(R.id.text);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),textView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
