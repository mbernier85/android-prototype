package im.bernier.broadcast;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by michaelbernier on 15-08-07.
 */
public interface ParseService {

    @Headers({"X-Parse-Application-Id: WswRJ2mRoUrYdEflyhgutVqsezbXpCdJoamzoYqS", "X-Parse-REST-API-Key: ldD1HWTmViS2U5AA1oDAeVwYUuS0SeqepJ8IcQlX"})
    @GET("/courts")
    void listCourt(retrofit.Callback<ParseResult<ArrayList<Court>>> callback);

}
