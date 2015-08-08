package im.bernier.broadcast;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private ArrayList<Court> courts;
    private CourtAdapter adapter;
    private Context context = this;

    @Bind(R.id.list)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        getCourts();
    }

    private void updateUI() {
        CourtAdapter adapter = new CourtAdapter(courts, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }

    private void getCourts() {
        RestAdapter builder = new RestAdapter.Builder()
                .setEndpoint("https://api.parse.com/1/classes")
                .build();
        ParseService service = builder.create(ParseService.class);
        service.listCourt(new Callback<ParseResult<ArrayList<Court>>>() {
            @Override
            public void success(ParseResult<ArrayList<Court>> results, Response response) {
                setCourts(results.getResults());
                updateUI();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, error.getMessage());
            }
        });
    }

    public void setCourts(ArrayList<Court> courts) {
        this.courts = courts;
    }
}
