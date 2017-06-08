package swag.fr.ogaming_app;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.loopj.android.http.*;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Hornet on 23/05/2017.
 */
public class SpashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //handle no internet
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spash_screen);
        getSupportActionBar().hide();

        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }



            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String id = pref.getString("id", "");

            if(!id.equals("")) { // keep loged in user in memory
              Intent i = new Intent(getBaseContext(), TabActivity.class);
              startActivity(i);
            }
            else {
                Intent i = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }

            finish();

        /* no auto login
         Intent i = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(i);
                finish();
         */


    }


    private static final int REQUEST_INTERNET = 2;



    public static void verifyInternetPermissions(Activity activity){
        if (ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.INTERNET},
                    REQUEST_INTERNET);


        }
    }
}
