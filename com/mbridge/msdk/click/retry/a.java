package com.mbridge.msdk.click.retry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RetryReportControl.java */
/* loaded from: classes6.dex */
public class a {
    public static String e = "mtg_retry_report=1";
    public static int f = 10000;
    public static int g = 3;
    public static int h = 50;
    public static int i = 600000;
    private static int j = 0;
    private static int k = 0;
    public static int l = 0;
    public static int m = 1;
    public static int n = 2;
    public static int o = 3;
    public static int p = 4;
    public static int q = 5;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.click.retry.b> f4057a;
    private com.mbridge.msdk.click.retry.c b;
    private BroadcastReceiver c;
    private final Handler d;

    /* compiled from: RetryReportControl.java */
    /* renamed from: com.mbridge.msdk.click.retry.a$a, reason: collision with other inner class name */
    class C0322a extends BroadcastReceiver {
        C0322a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.this.d.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: RetryReportControl.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static a f4059a = new a(null);
    }

    /* compiled from: RetryReportControl.java */
    private static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                a.b().c();
            } else {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.b().a((String) obj, com.mbridge.msdk.click.retry.b.k);
                }
            }
        }
    }

    /* synthetic */ a(C0322a c0322a) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.mbridge.msdk.click.retry.c cVar = this.b;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                a(it.next(), com.mbridge.msdk.click.retry.b.l);
            }
        }
    }

    private a() {
        this.f4057a = new ConcurrentHashMap<>();
        this.b = new com.mbridge.msdk.click.retry.c(h);
        this.d = new c(Looper.getMainLooper());
        g b2 = h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        g = b2.d0();
        f = b2.f0() * 1000;
        i = b2.g0() * 1000;
        j = b2.c0();
        k = b2.e0();
        a();
    }

    public static a b() {
        return b.f4059a;
    }

    private boolean b(int i2) {
        return i2 == m || i2 == n;
    }

    public void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z, boolean z2, int i2) {
        if (!c(i2) || TextUtils.isEmpty(str)) {
            return;
        }
        String replace = str.replace("?" + e, "").replace(C3040d4.i.c + e, "");
        if (this.f4057a == null) {
            this.f4057a = new ConcurrentHashMap<>();
        }
        com.mbridge.msdk.click.retry.b remove = this.f4057a.remove(replace);
        if (remove == null) {
            remove = new com.mbridge.msdk.click.retry.b(str, str2);
            remove.b(i2);
            remove.a(z);
            remove.b(z2);
            remove.a(campaignEx);
            remove.b(str3);
        } else if (remove.d() != com.mbridge.msdk.click.retry.b.l) {
            remove.a(str2);
        }
        if ((!a(i2) || j == 0) && ((!b(i2) || k == 0) && i2 != q)) {
            a(remove);
            return;
        }
        if (System.currentTimeMillis() < remove.c() + i) {
            a(replace, remove);
            if (remove.d() == com.mbridge.msdk.click.retry.b.k) {
                if (remove.e() <= g) {
                    a(replace);
                    return;
                } else {
                    a(remove);
                    return;
                }
            }
            return;
        }
        if (remove.d() == com.mbridge.msdk.click.retry.b.k) {
            a(remove);
        }
    }

    private boolean c(int i2) {
        return a(i2) || b(i2) || i2 == q;
    }

    private void a(com.mbridge.msdk.click.retry.b bVar) {
        String str;
        String str2;
        try {
            CampaignEx a2 = bVar.a();
            if (a2 == null) {
                str = "";
                str2 = str;
            } else {
                String requestId = a2.getRequestId();
                str2 = a2.getRequestIdNotice();
                str = requestId;
            }
            a(com.mbridge.msdk.foundation.controller.c.m().d(), bVar.b().toString(), bVar.g(), str, str2, bVar.h());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i2) {
        f.a().a(context, str, str2, str3, str4, i2);
    }

    private void a(String str, com.mbridge.msdk.click.retry.b bVar) {
        if (this.b == null) {
            this.b = new com.mbridge.msdk.click.retry.c(h);
        }
        this.b.a(str, bVar);
    }

    private void a(String str) {
        Message obtainMessage = this.d.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.d.sendMessageDelayed(obtainMessage, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        String str2;
        com.mbridge.msdk.click.retry.c cVar = this.b;
        if (cVar != null) {
            com.mbridge.msdk.click.retry.b a2 = cVar.a(str);
            this.b.b(str);
            if (a2 == null) {
                com.mbridge.msdk.click.retry.b bVar = this.f4057a.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.c() + i || bVar.e() >= g || i2 == com.mbridge.msdk.click.retry.b.l) {
                    return;
                }
                a(str);
                return;
            }
            if (System.currentTimeMillis() <= a2.c() + i) {
                a2.a(i2);
                this.f4057a.put(str, a2);
                if (b1.c(str) == 0) {
                    str2 = str + "?" + e;
                } else {
                    str2 = str + C3040d4.i.c + e;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), a2.a(), a2.f(), str2, a2.i(), a2.j(), a2.h());
                return;
            }
            if (i2 != com.mbridge.msdk.click.retry.b.l) {
                a(a2);
            }
        }
    }

    private void a() {
        try {
            if (this.c == null) {
                this.c = new C0322a();
                Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                if (d != null) {
                    d.registerReceiver(this.c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(int i2) {
        return i2 == p || i2 == o;
    }
}
