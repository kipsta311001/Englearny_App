package bayon.fabien.englearny_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.ViewHolder> {


    List<Tests> listOfTest;
    OnTestListClickListener listener;


    public TestListAdapter(List<Tests> listOfTest, OnTestListClickListener listener) {
        this.listOfTest = listOfTest;
        this.listener = listener;

    }

    @NonNull
    @Override
    public TestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_list_cell, parent, false);
        TestListAdapter.ViewHolder viewHolder = new TestListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestListAdapter.ViewHolder holder, final int position) {
        holder.nameTest.setText(listOfTest.get(position).getTestName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.OnTestListClickListener(listOfTest.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listOfTest.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTest;

        public ViewHolder(@NonNull View listOfTest) {
            super(listOfTest);
            nameTest = listOfTest.findViewById(R.id.testName);

        }
    }
}

