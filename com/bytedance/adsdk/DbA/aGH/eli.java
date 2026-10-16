package com.bytedance.adsdk.DbA.aGH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes3.dex */
public class eli implements aGH {
    private final HttpURLConnection eli;

    public eli(HttpURLConnection httpURLConnection) {
        this.eli = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.DbA.aGH.aGH
    public boolean eli() {
        try {
            return this.eli.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.DbA.aGH.aGH
    public InputStream DbA() throws IOException {
        return this.eli.getInputStream();
    }

    @Override // com.bytedance.adsdk.DbA.aGH.aGH
    public String Os() {
        return this.eli.getContentType();
    }

    @Override // com.bytedance.adsdk.DbA.aGH.aGH
    public String aGH() {
        try {
            if (eli()) {
                return null;
            }
            return "Unable to fetch " + this.eli.getURL() + ". Failed with " + this.eli.getResponseCode() + "\n" + eli(this.eli);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eli.disconnect();
    }

    private String eli(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
