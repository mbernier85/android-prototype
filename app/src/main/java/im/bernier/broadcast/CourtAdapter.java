package im.bernier.broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by michaelbernier on 15-08-07.
 */
public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.CourtViewHolder> {

    private String TAG = getClass().getSimpleName();

    private ArrayList<Court> courts;
    private Context context;

    public CourtAdapter(ArrayList<Court> courts, Context context) {
        this.courts = courts;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(CourtAdapter.CourtViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public CourtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.court_item_layout, parent, false);
        CourtViewHolder vh = new CourtViewHolder(view);
        return vh;
    }

    @Override
    public int getItemCount() {
        return courts.size();
    }

    public class CourtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.name)
        protected TextView name;

        private Court court;

        public CourtViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        public void bind(int position) {
            court = courts.get(position);
            name.setText(court.getName());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, CourtDetailActivity.class);
            intent.putExtra("court", court);
            context.startActivity(intent);
        }
    }
}
