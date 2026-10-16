package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: LocalDNSManager.java */
/* loaded from: classes6.dex */
public class i {
    private static final String f = "i";
    private static volatile i g;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, InetAddress> f4955a = new ConcurrentHashMap<>();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private String d = "";
    private String e = "";
    private final com.mbridge.msdk.foundation.buffer.sharedperference.a c = com.mbridge.msdk.foundation.buffer.sharedperference.a.b();

    /* compiled from: LocalDNSManager.java */
    private static class a implements OnDownloadStateListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final String f4956a;
        private final String b;
        private final String c;

        public a(String str, String str2, String str3) {
            this.f4956a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage<Object> downloadMessage) {
            i.b().c();
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            i.b().b(this.f4956a, this.b, this.c);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            i.b().c();
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }
    }

    private i() {
    }

    public static i b() {
        if (g == null) {
            synchronized (i.class) {
                if (g == null) {
                    g = new i();
                }
            }
        }
        return g;
    }

    private void d(String str) {
        try {
            this.e = e(com.mbridge.msdk.foundation.same.net.utils.d.h().y);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(j0.a(str));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && next.contains(this.e)) {
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            this.f4955a.put(next, InetAddress.getByAddress(next, com.mbridge.msdk.foundation.same.c.b(string)));
                        } catch (UnknownHostException e) {
                            this.d = String.format("create InetAddress failed for %s with ip %s", next, string);
                            p0.b(f, "init: local dns cache error", e);
                        }
                    }
                }
            }
            this.b.set(true);
        } catch (Exception e2) {
            p0.b(f, "init: local dns cache json parse error", e2);
            this.d = "parse local dns config error";
            this.f4955a.clear();
            this.b.set(false);
        }
    }

    private static String e(String str) {
        return str.replace("https://{}", "").replace("http://{}", "");
    }

    public boolean c(String str) {
        return TextUtils.equals(str, com.mbridge.msdk.foundation.same.net.utils.d.h().e.replace("https://", ""));
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str) || !e()) {
            return;
        }
        this.b.set(false);
        this.f4955a.clear();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.b.set(false);
        this.d = "download local dns config error";
    }

    public boolean e() {
        return r0.a().b("local_dns", false, false);
    }

    private void a() {
        String a2 = this.c.a("cache");
        String a3 = this.c.a("url");
        String b = r0.a().b("local_dns_config_url", "", false);
        if (TextUtils.isEmpty(b)) {
            this.c.a("cache", "");
        } else if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3) && TextUtils.equals(b, a3)) {
            d(a2);
        } else {
            a(b);
        }
    }

    public boolean c(String str, String str2, String str3) {
        if (e() && d() && TextUtils.equals(str, "campaign") && !c(str3)) {
            return TextUtils.equals(str2, String.valueOf(94)) || TextUtils.equals(str2, String.valueOf(MBSupportMuteAdType.INTERSTITIAL_VIDEO));
        }
        return false;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        try {
            String a2 = com.mbridge.msdk.foundation.same.c.a(new FileInputStream(new File(str2, str3)));
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.c.a("cache", a2);
            this.c.a("url", str);
            d(a2);
        } catch (Exception e) {
            p0.b(f, "downloadLocalDNSConfig: onDownloadComplete: file not found", e);
            this.d = "find local dns config file error";
        }
    }

    private void a(String str) {
        a(str, com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_OTHER) + File.separator, b(str));
    }

    private void a(String str, String str2, String str3) {
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, str3, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withConnectTimeout(30000L).withReadTimeout(30000L).withWriteTimeout(30000L).withTimeout(30000L).withHttpRetryCounter(5).withDirectoryPathInternal(str2).withDownloadPriority(DownloadPriority.HIGH).withDownloadStateListener(new a(str, str2, str3)).build().start();
    }

    public boolean d() {
        return this.b.get() && !this.f4955a.isEmpty();
    }

    public List<InetAddress> a(String str, UnknownHostException unknownHostException) throws UnknownHostException {
        InetAddress inetAddress;
        try {
            inetAddress = this.f4955a.get(str);
        } catch (Exception e) {
            p0.b(f, "lookup: local dns cache error", e);
            inetAddress = null;
        }
        if (inetAddress != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(inetAddress);
            return arrayList;
        }
        throw unknownHostException;
    }
}
