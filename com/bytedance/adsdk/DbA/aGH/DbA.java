package com.bytedance.adsdk.DbA.aGH;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public class DbA implements MGA {
    @Override // com.bytedance.adsdk.DbA.aGH.MGA
    public aGH eli(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new eli(httpURLConnection);
    }
}
