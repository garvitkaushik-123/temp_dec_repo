package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.C3193m5;
import com.ironsource.C3207n2;
import com.ironsource.C3241p2;
import com.ironsource.C3260q4;
import com.ironsource.C3337ue;
import com.ironsource.S1;
import com.ironsource.Y1;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f3530a = "1";
    private final String b = "102";
    private final String c = "102";
    private final String d = "GenericNotifications";
    private f e;
    private IronSource.AD_UNIT f;
    private C3241p2 g;
    private S1 h;
    private ISBannerSize i;

    public e(f fVar) {
        this.e = fVar;
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i, IronSourceSegment ironSourceSegment, ISBannerSize iSBannerSize) {
        this.i = iSBannerSize;
        a(context, map, list, hVar, i, ironSourceSegment);
    }

    public void a(Context context, i iVar, S1 s1) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.e.a(context, iVar, s1));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("execute auction exception " + e.getMessage());
            if (s1 != null) {
                s1.a(1000, e.getMessage(), 0, Y1.f3135a.a(this.e.a(), 1000), 0L);
            }
        }
    }

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        protected S1 f3531a;
        protected d.a b;
        protected int c;
        protected String d;
        protected long e;
        protected int f;
        private int h;
        private final URL k;
        private final JSONObject l;
        private final boolean m;
        private final int n;
        private final long o;
        private final boolean p;
        private final boolean q;
        private final boolean r;
        protected String i = "";
        protected int j = 0;
        protected String g = a((Integer) null);

        public a(S1 s1, URL url, JSONObject jSONObject, boolean z, C3241p2 c3241p2) {
            this.f3531a = s1;
            this.k = url;
            this.l = jSONObject;
            this.m = z;
            this.n = c3241p2.g();
            this.o = c3241p2.m();
            this.p = c3241p2.o();
            this.q = c3241p2.p();
            this.h = c3241p2.d();
            this.r = c3241p2.n();
        }

        private void a(long j, long j2) {
            long time = j - (new Date().getTime() - j2);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        protected boolean b() {
            long time;
            int responseCode;
            this.e = new Date().getTime();
            try {
                this.h = this.j == 1015 ? 1 : this.h;
                this.f = 0;
                HttpURLConnection httpURLConnection = null;
                while (true) {
                    int i = this.f;
                    int i2 = this.n;
                    if (i >= i2) {
                        this.f = i2 - 1;
                        this.g = a(Integer.valueOf(this.c));
                        return false;
                    }
                    try {
                        time = new Date().getTime();
                        String str = "Auction Handler: auction trial " + (this.f + 1) + " out of " + this.n + " max trials";
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                        IronSourceUtils.sendAutomationLog(str);
                        httpURLConnection = a(this.k, this.o);
                        a(httpURLConnection, this.l, this.p);
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (SocketTimeoutException e) {
                        C3260q4.d().a(e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.c = 1006;
                        this.d = "Connection timed out";
                        IronLog.INTERNAL.error("Auction socket timeout exception " + e.getMessage());
                    } catch (Throwable th) {
                        C3260q4.d().a(th);
                        IronLog.INTERNAL.error("getting exception " + th);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.c = 1000;
                        this.d = th.getMessage();
                        this.g = a(Integer.valueOf(this.c));
                        return false;
                    }
                    if (responseCode == 200 || responseCode == 204) {
                        break;
                    }
                    this.c = 1001;
                    String str2 = "Auction response code not valid, error code response from server - " + responseCode;
                    this.d = str2;
                    IronLog.INTERNAL.error(str2);
                    httpURLConnection.disconnect();
                    if (this.f < this.n - 1) {
                        a(this.o, time);
                    }
                    this.f++;
                }
                try {
                    a(a(httpURLConnection), this.m, this.q);
                    httpURLConnection.disconnect();
                    return true;
                } catch (JSONException e2) {
                    C3260q4.d().a(e2);
                    if (e2.getMessage() != null && e2.getMessage().equalsIgnoreCase("decryption error")) {
                        this.c = 1003;
                        this.d = "Auction decryption error";
                    } else if (e2.getMessage() == null || !e2.getMessage().equalsIgnoreCase("decompression error")) {
                        this.c = 1002;
                        this.d = "Auction parsing error";
                    } else {
                        this.c = 1008;
                        this.d = "Auction decompression error";
                    }
                    this.g = a(Integer.valueOf(this.c));
                    IronLog.INTERNAL.error("Auction handle response exception " + e2.getMessage());
                    httpURLConnection.disconnect();
                    return false;
                }
            } catch (Exception e3) {
                C3260q4.d().a(e3);
                this.c = 1007;
                this.d = e3.getMessage();
                this.f = 0;
                this.g = a(Integer.valueOf(this.c));
                IronLog.INTERNAL.error("Auction request exception " + e3.getMessage());
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b = b();
            S1 s1 = this.f3531a;
            if (s1 == null) {
                return;
            }
            a(b, s1, new Date().getTime() - this.e);
        }

        private String a() {
            if (this.h == 2) {
                return C3193m5.b().d();
            }
            return C3193m5.b().c();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z) throws Exception {
            String a2;
            String encode;
            String format;
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (this.h == 2) {
                try {
                    a2 = C3193m5.b().a();
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    this.i = e.getLocalizedMessage();
                    this.j = 1015;
                    this.h = 1;
                    IronLog.INTERNAL.error("get encrypted session key exception " + e.getMessage());
                }
                String jSONObject2 = jSONObject.toString();
                String a3 = a();
                if (!z) {
                    IronLog.INTERNAL.verbose("compressing and encrypting auction request");
                    encode = IronSourceAES.compressAndEncrypt(a3, jSONObject2);
                } else {
                    encode = IronSourceAES.encode(a3, jSONObject2);
                }
                if (this.h != 2) {
                    format = String.format("{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}", a2, encode);
                } else {
                    format = String.format("{\"request\" : \"%1$s\"}", encode);
                }
                bufferedWriter.write(format);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();
            }
            a2 = "";
            String jSONObject22 = jSONObject.toString();
            String a32 = a();
            if (!z) {
            }
            if (this.h != 2) {
            }
            bufferedWriter.write(format);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        private HttpURLConnection a(URL url, long j) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        protected JSONObject a(JSONObject jSONObject, boolean z) throws JSONException {
            String str;
            String a2 = a();
            if (this.h == 2) {
                str = "ct";
            } else {
                str = C3337ue.n;
            }
            String string = jSONObject.getString(str);
            if (z) {
                return b(a2, string);
            }
            return a(a2, string);
        }

        protected void a(String str, boolean z, boolean z2) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    jSONObject = a(jSONObject, z2);
                }
                d.a a2 = d.b().a(jSONObject);
                this.b = a2;
                this.c = a2.c();
                this.d = this.b.d();
                return;
            }
            throw new JSONException("empty response");
        }

        private JSONObject a(String str, String str2) throws JSONException {
            String decode = IronSourceAES.decode(str, str2);
            if (!TextUtils.isEmpty(decode)) {
                return new JSONObject(decode);
            }
            throw new JSONException("decryption error");
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        protected void a(boolean z, S1 s1, long j) {
            if (z) {
                s1.a(this.b.h(), this.b.a(), this.b.e(), this.b.f(), this.b.b(), this.f + 1, j, this.j, this.i);
            } else {
                s1.a(this.c, this.d, this.f + 1, this.g, j);
            }
        }

        private String a(Integer num) {
            return Y1.f3135a.a(this.r, num);
        }

        private JSONObject b(String str, String str2) throws JSONException {
            IronLog.INTERNAL.verbose("decrypting and decompressing auction response");
            String decryptAndDecompress = IronSourceAES.decryptAndDecompress(str, str2);
            if (decryptAndDecompress != null) {
                return new JSONObject(decryptAndDecompress);
            }
            throw new JSONException("decompression error");
        }
    }

    @Deprecated
    public e(IronSource.AD_UNIT ad_unit, C3241p2 c3241p2, S1 s1) {
        this.f = ad_unit;
        this.g = c3241p2;
        this.h = s1;
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i, IronSourceSegment ironSourceSegment) {
        e eVar;
        boolean isEncryptedResponse;
        try {
            isEncryptedResponse = IronSourceUtils.isEncryptedResponse();
            eVar = this;
        } catch (Exception e) {
            e = e;
            eVar = this;
        }
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(eVar.h, new URL(eVar.g.a(false)), eVar.a(map, list, hVar, i, isEncryptedResponse, ironSourceSegment), isEncryptedResponse, eVar.g));
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.INTERNAL.error("execute auction exception " + exc.getMessage());
            eVar.h.a(1000, exc.getMessage(), 0, Y1.f3135a.a(eVar.g.n(), 1000), 0L);
        }
    }

    public void a(C3207n2 c3207n2, int i, C3207n2 c3207n22, String str) {
        Iterator<String> it = c3207n2.b().iterator();
        while (it.hasNext()) {
            C3207n2 c3207n23 = c3207n2;
            int i2 = i;
            String str2 = str;
            d.b().a("reportImpression", c3207n23.c(), d.b().a(it.next(), i2, c3207n23, "", "", str2));
            i = i2;
            c3207n2 = c3207n23;
            str = str2;
        }
        C3207n2 c3207n24 = c3207n2;
        int i3 = i;
        String str3 = str;
        if (c3207n22 != null) {
            Iterator<String> it2 = c3207n22.b().iterator();
            while (it2.hasNext()) {
                d.b().a("reportImpression", "GenericNotifications", d.b().a(it2.next(), i3, c3207n24, "", "102", str3));
            }
        }
    }

    public void a(C3207n2 c3207n2, int i, C3207n2 c3207n22) {
        Iterator<String> it = c3207n2.h().iterator();
        while (it.hasNext()) {
            C3207n2 c3207n23 = c3207n2;
            int i2 = i;
            d.b().a("reportLoadSuccess", c3207n23.c(), d.b().a(it.next(), i2, c3207n23, "", "", ""));
            i = i2;
            c3207n2 = c3207n23;
        }
        C3207n2 c3207n24 = c3207n2;
        int i3 = i;
        if (c3207n22 != null) {
            Iterator<String> it2 = c3207n22.h().iterator();
            while (it2.hasNext()) {
                d.b().a("reportLoadSuccess", "GenericNotifications", d.b().a(it2.next(), i3, c3207n24, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<y> copyOnWriteArrayList, ConcurrentHashMap<String, C3207n2> concurrentHashMap, int i, C3207n2 c3207n2, C3207n2 c3207n22) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<y> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        a(arrayList, concurrentHashMap, i, c3207n2, c3207n22);
    }

    public void a(ArrayList<String> arrayList, ConcurrentHashMap<String, C3207n2> concurrentHashMap, int i, C3207n2 c3207n2, C3207n2 c3207n22) {
        int j = c3207n22.j();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals(c3207n22.c())) {
                C3207n2 c3207n23 = concurrentHashMap.get(next);
                int j2 = c3207n23.j();
                String i2 = c3207n23.i();
                String str = j2 < j ? "1" : "102";
                IronLog.INTERNAL.verbose("instance=" + c3207n23.c() + ", instancePriceOrder= " + j2 + ", loseReasonCode=" + str + ", winnerInstance=" + c3207n22.c() + ", winnerInstancePriceOrder=" + j);
                Iterator<String> it2 = c3207n23.g().iterator();
                while (it2.hasNext()) {
                    d.b().a("reportAuctionLose", c3207n23.c(), d.b().a(it2.next(), i, c3207n22, i2, str, ""));
                }
            }
        }
        if (c3207n2 != null) {
            Iterator<String> it3 = c3207n2.g().iterator();
            while (it3.hasNext()) {
                d.b().a("reportAuctionLose", "GenericNotifications", d.b().a(it3.next(), i, c3207n22, "", "102", ""));
            }
        }
    }

    private JSONObject a(Map<String, Object> map, List<String> list, h hVar, int i, boolean z, IronSourceSegment ironSourceSegment) throws JSONException {
        i iVar = new i(this.f);
        iVar.a(map);
        iVar.a(list);
        iVar.a(hVar);
        iVar.a(i);
        iVar.a(this.i);
        iVar.a(ironSourceSegment);
        iVar.b(z);
        return d.b().a(iVar);
    }

    public boolean a() {
        return this.e.b();
    }
}
