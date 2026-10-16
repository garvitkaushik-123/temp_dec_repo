package com.ironsource;

import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.r4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class RunnableC3276r4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3669a;

    public RunnableC3276r4(JSONObject stringToSend) {
        Intrinsics.checkNotNullParameter(stringToSend, "stringToSend");
        this.f3669a = stringToSend;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("preparing to send crashes report");
            URLConnection openConnection = new URL(C3260q4.d().h).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, D5.L);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(this.f3669a.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
            Log.i("MSG", httpURLConnection.getResponseMessage());
            httpURLConnection.disconnect();
            ironLog.verbose("sent crash report for type " + this.f3669a.get("crashType") + " and date " + this.f3669a.get("crashDate"));
        } catch (Exception e) {
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
