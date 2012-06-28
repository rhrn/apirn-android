package ru.rhrn.apirn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Net {

    private static final String BASE_API_URL = "http://apirn.com/";

    private static final String BASE_API_VERSION = "v1/";

    private String baseApiURL = BASE_API_URL + BASE_API_VERSION;

    private Context context;

    public Net(Context context) {
        this.context = context;
    }

    public String join(String email, String password) {

        String joinURL = baseApiURL + "join/";

        return joinURL;
    }

    public boolean isOnline() {

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }


}
