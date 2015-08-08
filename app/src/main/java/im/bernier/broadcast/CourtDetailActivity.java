package im.bernier.broadcast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.kickflip.sdk.Kickflip;
import io.kickflip.sdk.api.json.Stream;
import io.kickflip.sdk.av.BroadcastListener;
import io.kickflip.sdk.exception.KickflipException;

/**
 * Created by michaelbernier on 15-08-07.
 */
public class CourtDetailActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    private Court court;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.court_detail_layout);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            court = getIntent().getParcelableExtra("court");
        } else {
            court = savedInstanceState.getParcelable("court");
        }
        toolbar.setTitle(court.getName());
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("court", court);
    }

    @OnClick(R.id.broadcast_button)
    protected void broadcastClick() {
        startBroadcast();
    }

    private void startBroadcast() {
        final String CLIENT_ID = "-oWHH9pN=4gZXjQ7NsQei8.@Lzwra?Gt!CAVOwQ-";
        final String CLIENT_SECRET = "_Xmy?lc5tKT00COH6wH:ebX1MpVij@PakUXG1xZpDZEtv7Qxuu=FkA3=DCownFA-BDee1qBHjSDWfLC.:zHVONPq!sWTft;maijNyF95C=2!mX4JQEQkdv16Ht.oK!8b";

        Kickflip.setup(this, CLIENT_ID, CLIENT_SECRET);
        Kickflip.startBroadcastActivity(this, new BroadcastListener() {
            @Override
            public void onBroadcastStart() {

            }

            @Override
            public void onBroadcastLive(Stream stream) {
                Log.i(TAG, "BroadcastLive @ " + stream.getKickflipUrl());
            }

            @Override
            public void onBroadcastStop() {

            }

            @Override
            public void onBroadcastError(KickflipException e) {
                Log.d(TAG, e.getMessage());
            }
        });
    }
}
