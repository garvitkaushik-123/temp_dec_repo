package com.bytedance.sdk.component.DbA.eli.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.Dfc;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class wC extends nn {
    public static int eli = -1;
    HttpURLConnection DbA;
    nlS Os;
    int aGH;
    String ui;

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public long DbA() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public long eli() {
        return 0L;
    }

    public wC(HttpURLConnection httpURLConnection, nlS nls) {
        this.aGH = eli;
        this.DbA = httpURLConnection;
        this.Os = nls;
    }

    public wC(int i, String str, nlS nls) {
        this.ui = str;
        this.Os = nls;
        this.aGH = i;
    }

    public nlS FC() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public int Os() {
        try {
            return this.DbA.getResponseCode();
        } catch (Exception unused) {
            return this.aGH;
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public boolean aGH() {
        return Os() >= 200 && Os() < 300;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public String ui() throws IOException {
        if (!TextUtils.isEmpty(this.ui)) {
            return this.ui;
        }
        return this.DbA.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public Dfc MGA() {
        FC fc;
        nlS nls = this.Os;
        if (nls != null && nls.DbA != null) {
            this.Os.DbA.du();
        }
        try {
            try {
                fc = new FC(this.DbA);
            } catch (Throwable th) {
                th.getMessage();
                fc = null;
            }
        } catch (Exception unused) {
            HttpURLConnection httpURLConnection = this.DbA;
            fc = new FC(httpURLConnection, httpURLConnection.getErrorStream());
        }
        nlS nls2 = this.Os;
        if (nls2 != null && nls2.DbA != null) {
            this.Os.DbA.NU();
        }
        return fc;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public com.bytedance.sdk.component.DbA.eli.MGA kb() {
        if (this.DbA == null) {
            return new com.bytedance.sdk.component.DbA.eli.MGA(new String[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.DbA.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || Os() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.DbA.eli.MGA((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            MGA().close();
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.DbA.eli.nn
    public com.bytedance.sdk.component.DbA.eli.aAs wC() {
        if (FC() == null || FC().DbA == null) {
            return null;
        }
        return new com.bytedance.sdk.component.DbA.eli.aAs(FC().DbA);
    }
}
