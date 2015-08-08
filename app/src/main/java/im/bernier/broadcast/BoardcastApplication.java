package im.bernier.broadcast;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by michaelbernier on 15-08-07.
 */
public class BoardcastApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "WswRJ2mRoUrYdEflyhgutVqsezbXpCdJoamzoYqS", "cRj5ad5uauaZjgy2XbDtvvfg0PP1qE1VXIiLjW8f");
    }
}
