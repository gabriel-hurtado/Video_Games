package swag.fr.ogaming_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Hornet on 23/05/2017.
 */
public class Utils {

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean reLoginNow(final Context ct) {

        String password;
        String email;
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ct);
        email = pref.getString("login", "");
        password = pref.getString("password", "");
        if (""!=email)
            return false;
        else return true;



    }



}
