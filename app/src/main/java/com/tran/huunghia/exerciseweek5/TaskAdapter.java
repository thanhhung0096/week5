package com.tran.huunghia.exerciseweek5;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by user on 06/04/2018.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{
    // Store a member variable for the tasks
    private List<Task> mtasks;
    // Store the context for easy access
    private Context mContext;
    Dialog dialog;
    String nameOfTask = "";
    String priorityOfTask = "";
    // Pass in the task array into the constructor
    public TaskAdapter(Context context, List<Task> tasks) {
        mtasks = tasks;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View taskView = inflater.inflate(R.layout.item_task, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final TaskAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Task task = mtasks.get(position);
        // Set item views based on your views and data model
        viewHolder.tvName.setText(task.getName());
        viewHolder.btnPriority.setText(task.getPriority());
        viewHolder.tvDate.setText(task.getDate());
        viewHolder.rvLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.fragment_task);
                dialog.show();
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mtasks.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvName;
        public TextView tvDate;
        public Button btnPriority;
        RelativeLayout rvLayout;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnLongClickListener(this);
            tvName = (TextView) itemView.findViewById(R.id.tvNameTask);
            tvDate = (TextView) itemView.findViewById(R.id.tvDateTask);
            //imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            btnPriority = (Button) itemView.findViewById(R.id.btnPriorityTask);
            rvLayout = (RelativeLayout)itemView.findViewById(R.id.id_tem_task);
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getLayoutPosition();
            mtasks.remove(position);
            notifyItemRemoved(position);
            return false;
        }
        /*@Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Task task = mtasks.get(position);

            //openDetailActivity(task.getTitle(),task.getPoster_path(),task.getOverview(),task.getRelease_date(),task.getVote_average());

        }*/
    }

    private void openDetailActivity(String title, String path_poster, String overview, String releaseDate, String vote_average)
    {
        /*Intent i=new Intent(mContext, taskDetailActivity.class);

        //PACK DATA TO SEND
        i.putExtra("title",title);
        i.putExtra("path_poster",path_poster);
        i.putExtra("overview",overview);
        i.putExtra("vote_average",vote_average);
        i.putExtra("releaseDate","Release Date: " + releaseDate);
        //open activity
        mContext.startActivity(i);*/

    }
}
/*public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{
    // Store a member variable for the tasks
    private List<Task> mtasks;
    // Store the context for easy access
    private Context mContext;
    Dialog dialog;
    // Pass in the task array into the constructor
    public TaskAdapter(Context context, List<Task> tasks) {
        mtasks = tasks;
        mContext = context;
    }
    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View taskView = inflater.inflate(R.layout.item_task, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final TaskAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Task task = mtasks.get(position);
        // Set item views based on my views and data model

        viewHolder.tvName.setText(task.getName());
        viewHolder.tvDate.setText("");
        viewHolder.btnPriority.setText(task.getPriority());
        viewHolder.rvLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.fragment_task);
                Toast.makeText(mContext, "as" , Toast.LENGTH_SHORT).show();
                dialog.show();
            }
        });
       }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mtasks.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvName;
        public TextView tvDate;
        public Button btnPriority;
        public RelativeLayout rvLayout;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnLongClickListener(this);
            tvName = (TextView) itemView.findViewById(R.id.tvNameTask);
            tvDate = (TextView) itemView.findViewById(R.id.tvDateTask);
            btnPriority = (Button) itemView.findViewById(R.id.btnPriorityTask);
            rvLayout = (RelativeLayout) itemView.findViewById(R.id.id_tem_task);
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getLayoutPosition();
            mtasks.remove(position);
            notifyItemRemoved(position);
            return false;
        }
    }
    public  void openFragment(){

    }
}*/
