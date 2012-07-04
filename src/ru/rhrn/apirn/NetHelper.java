package ru.rhrn.apirn;

import ru.rhrn.apirn.URLHelper;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetHelper {

    private static final String BASE_API_URL = "http://apirn.com/";

    private static final String BASE_API_VERSION = "v1/";

    private String baseApiURL = BASE_API_URL + BASE_API_VERSION;
    
    private URLHelper url = new URLHelper();

    private Context context;

    public NetHelper(Context context) {
        this.context = context;
    }

    public String join(String email, String password) {

        String joinURL = baseApiURL + "join/";

        url.url(joinURL);

        String text = "";

        try {
          text = url.get();
        } catch(Exception e) {

        }

        return text;
    }

    public boolean isOnline() {

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }


}
