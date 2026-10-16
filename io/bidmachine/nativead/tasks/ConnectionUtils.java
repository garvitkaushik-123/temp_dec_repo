package io.bidmachine.nativead.tasks;

import android.net.Uri;
import io.bidmachine.core.Logger;
import io.bidmachine.nativead.utils.NoSSLv3SocketFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes6.dex */
class ConnectionUtils {
    ConnectionUtils() {
    }

    static InputStream getInputStream(String remoteUrl, int timeout) throws Exception {
        try {
            URLConnection openConnection = new URL(remoteUrl).openConnection();
            openConnection.setConnectTimeout(timeout);
            openConnection.setReadTimeout(timeout);
            setupNoSSLv3(openConnection);
            openConnection.connect();
            return openConnection.getInputStream();
        } catch (Exception unused) {
            Uri.Builder buildUpon = Uri.parse(remoteUrl).buildUpon();
            buildUpon.scheme("http");
            URLConnection openConnection2 = new URL(buildUpon.build().toString()).openConnection();
            openConnection2.setConnectTimeout(timeout);
            openConnection2.setReadTimeout(timeout);
            openConnection2.connect();
            return openConnection2.getInputStream();
        }
    }

    private static void setupNoSSLv3(URLConnection connection) {
        try {
            if (connection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
                httpsURLConnection.setSSLSocketFactory(new NoSSLv3SocketFactory(httpsURLConnection.getSSLSocketFactory()));
            }
        } catch (Exception e) {
            Logger.w(e);
        }
    }
}
