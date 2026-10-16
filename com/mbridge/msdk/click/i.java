package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: JavaHttpSpider.java */
/* loaded from: classes6.dex */
public class i {
    private static final String f = "i";

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f4043a;
    private String b;
    private boolean c = true;
    private final int d = 3145728;
    private com.mbridge.msdk.click.entity.a e;

    public i() {
        com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        this.f4043a = d;
        if (d == null) {
            this.f4043a = com.mbridge.msdk.setting.h.b().a();
        }
    }

    public com.mbridge.msdk.click.entity.a a(String str, boolean z, boolean z2, CampaignEx campaignEx) {
        int i;
        HttpsURLConnection httpsURLConnection = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String replace = str.replace(" ", "%20");
        this.e = new com.mbridge.msdk.click.entity.a();
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(replace).openConnection();
            try {
                httpsURLConnection2.setHostnameVerifier(new MBridgeHostnameVerifier(replace));
                httpsURLConnection2.setRequestMethod("GET");
                if ((!z && !z2) || campaignEx == null) {
                    httpsURLConnection2.setRequestProperty("User-Agent", l0.i());
                }
                if (z && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpsURLConnection2.setRequestProperty("User-Agent", l0.i());
                }
                if (z2 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpsURLConnection2.setRequestProperty("User-Agent", l0.i());
                }
                httpsURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                if (this.f4043a.I0() && !TextUtils.isEmpty(this.b)) {
                    httpsURLConnection2.setRequestProperty("referer", this.b);
                }
                httpsURLConnection2.setConnectTimeout(60000);
                httpsURLConnection2.setReadTimeout(60000);
                httpsURLConnection2.setInstanceFollowRedirects(false);
                httpsURLConnection2.connect();
                this.e.f4039a = httpsURLConnection2.getHeaderField("Location");
                this.e.d = httpsURLConnection2.getHeaderField(HttpHeaders.REFERER);
                this.e.f = httpsURLConnection2.getResponseCode();
                this.e.b = httpsURLConnection2.getContentType();
                this.e.e = httpsURLConnection2.getContentLength();
                this.e.c = httpsURLConnection2.getContentEncoding();
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.e.c);
                com.mbridge.msdk.click.entity.a aVar = this.e;
                if (aVar.f == 200 && this.c && (i = aVar.e) > 0 && i < 3145728 && !TextUtils.isEmpty(replace)) {
                    try {
                        String a2 = a(httpsURLConnection2.getInputStream(), equalsIgnoreCase);
                        if (!TextUtils.isEmpty(a2)) {
                            byte[] bytes = a2.getBytes();
                            if (bytes.length > 0 && bytes.length < 3145728) {
                                this.e.g = a2.trim();
                            }
                        }
                    } catch (Throwable th) {
                        p0.b(f, th.getMessage());
                    }
                }
                this.b = replace;
                httpsURLConnection2.disconnect();
                return this.e;
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = httpsURLConnection2;
                try {
                    this.e.h = th.getMessage();
                    return this.e;
                } finally {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: Exception -> 0x0026, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0026, blocks: (B:33:0x0022, B:12:0x004c), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[Catch: all -> 0x002d, TryCatch #5 {all -> 0x002d, blocks: (B:39:0x0008, B:4:0x000e, B:7:0x0030, B:9:0x0034, B:10:0x0041), top: B:38:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(InputStream inputStream, boolean z) {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            if (z) {
                try {
                    try {
                        inputStream = new GZIPInputStream(inputStream);
                    } catch (Exception e2) {
                        e = e2;
                        if (this.e == null) {
                            com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
                            this.e = aVar;
                            aVar.h = e.getMessage();
                        }
                        p0.b(f, e.getMessage());
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return sb.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            p0.b(f, e3.getMessage());
                        }
                    }
                    throw th;
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader2 = bufferedReader;
                    if (this.e == null) {
                    }
                    p0.b(f, e.getMessage());
                    if (bufferedReader2 != null) {
                    }
                    return sb.toString();
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            p0.b(f, e5.getMessage());
        }
        return sb.toString();
    }
}
