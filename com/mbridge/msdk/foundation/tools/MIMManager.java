package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class MIMManager {
    private static volatile String i;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f4341a;
    private int b;
    private CopyOnWriteArrayList<CampaignEx> c;
    private Context d;
    private volatile Boolean e;
    private CampaignEx f;
    private volatile g g;
    private volatile MiOverseaMiniCardBroadcasterReceiver h;

    public static class MiOverseaMiniCardBroadcasterReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN=").equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME);
                int intExtra = intent.getIntExtra(IronSourceConstants.EVENTS_ERROR_CODE, 0);
                int intExtra2 = intExtra < 0 ? intent.getIntExtra("reason", 0) : -1;
                p0.b("MIMManager", stringExtra + " " + intExtra + " " + intExtra2);
                if (intExtra == 1 || intExtra == 2 || intExtra == 3 || intExtra == 4 || intExtra == 7) {
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar.a(C3040d4.h.W, URLEncoder.encode("m_mini_card", D5.N));
                        CampaignEx a2 = MIMManager.b().a(stringExtra);
                        if (a2 != null) {
                            eVar.a("rid", a2.getRequestId());
                            eVar.a("rid_n", a2.getRequestIdNotice());
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, a2.getCampaignUnitId());
                            eVar.a("u_stid", com.mbridge.msdk.foundation.controller.a.r.get(a2.getCampaignUnitId()));
                            cVar.a(a2);
                        }
                        eVar.a("event", String.valueOf(intExtra));
                        eVar.a("pkg_name", stringExtra);
                        if (intExtra2 != -1) {
                            eVar.a("reasonCode", String.valueOf(intExtra2));
                        }
                        cVar.a("m_mini_card", eVar);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mini_card", cVar);
                    } catch (Exception e) {
                        p0.b("MIMManager", e.getMessage());
                    }
                }
            }
        }
    }

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4342a;

        a(Context context) {
            this.f4342a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MIMManager.this.f4341a.compareAndSet(false, true)) {
                try {
                    MIMManager mIMManager = MIMManager.this;
                    mIMManager.e = mIMManager.a();
                } catch (Exception e) {
                    p0.a("MIMManager", e.getMessage());
                }
                if (MIMManager.this.e == null || !MIMManager.this.e.booleanValue() || this.f4342a == null) {
                    return;
                }
                try {
                    MIMManager.this.g = new g(null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                    intentFilter.addAction(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                    intentFilter.addAction(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                    this.f4342a.registerReceiver(MIMManager.this.g, intentFilter);
                } catch (Exception e2) {
                    p0.a("MIMManager", e2.getMessage());
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4343a;
        final /* synthetic */ CampaignEx b;

        b(Context context, CampaignEx campaignEx) {
            this.f4343a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MIMManager.this.e(this.f4343a, this.b);
            } catch (Exception e) {
                p0.b("MIMManager", e.getMessage());
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4344a;
        final /* synthetic */ CampaignEx b;

        c(Context context, CampaignEx campaignEx) {
            this.f4344a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MIMManager.this.d(this.f4344a, this.b);
            } catch (Exception e) {
                p0.b("MIMManager", e.getMessage());
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4345a;
        final /* synthetic */ CampaignEx b;

        d(Context context, CampaignEx campaignEx) {
            this.f4345a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    MIMManager.this.f(this.f4345a, this.b);
                    if (MIMManager.this.c == null || !MIMManager.this.c.contains(this.b)) {
                        return;
                    }
                } catch (Exception e) {
                    p0.b("MIMManager", e.getMessage());
                    if (MIMManager.this.c == null || !MIMManager.this.c.contains(this.b)) {
                        return;
                    }
                }
                MIMManager.this.c.remove(this.b);
            } catch (Throwable th) {
                if (MIMManager.this.c != null && MIMManager.this.c.contains(this.b)) {
                    MIMManager.this.c.remove(this.b);
                }
                throw th;
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4346a;
        final /* synthetic */ String b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ int d;

        e(Context context, String str, CampaignEx campaignEx, int i) {
            this.f4346a = context;
            this.b = str;
            this.c = campaignEx;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f4346a == null || TextUtils.isEmpty(this.b) || this.c == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3040d4.h.W, "2000100");
                jSONObject.put("network_type", l0.s(this.f4346a));
                jSONObject.put("rid", this.c.getRequestId());
                jSONObject.put("rid_n", this.c.getRequestIdNotice());
                if (!TextUtils.isEmpty(this.c.getCampaignUnitId())) {
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.c.getCampaignUnitId());
                    String str = com.mbridge.msdk.foundation.controller.a.r.get(this.c.getCampaignUnitId());
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("u_stid", str);
                }
                jSONObject.put("cid", this.c.getId());
                jSONObject.put("status", this.b);
                jSONObject.put("code", this.d);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
            } catch (Throwable th) {
                p0.b("MIMManager", th.getMessage());
            }
        }
    }

    private static final class f {

        /* renamed from: a, reason: collision with root package name */
        private static final MIMManager f4347a = new MIMManager(null);
    }

    private static class g extends BroadcastReceiver {
        private g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CampaignEx a2;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN=")) || action.equals(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN=")) || !action.equals(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"))) {
                return;
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                int i = extras.getInt("statusCode", -1);
                String string = extras.getString(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME, "");
                if (i != -1 && !TextUtils.isEmpty(string) && (a2 = MIMManager.b().a(string)) != null) {
                    MIMManager.b().a(context, a2, i);
                    MIMManager.b().a(context, "dm_page_status", i, MIMManager.b().c());
                }
            } catch (Exception e) {
                p0.b("MIMManager", e.getMessage());
            }
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* synthetic */ MIMManager(a aVar) {
        this();
    }

    public void f() {
        this.b++;
    }

    public void g() {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 <= 0) {
            a(this.d);
        }
    }

    public void h() {
        try {
            if (this.h == null) {
                this.h = new MiOverseaMiniCardBroadcasterReceiver();
            }
            IntentFilter intentFilter = new IntentFilter(j0.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN="));
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d2 != null) {
                d2.registerReceiver(this.h, intentFilter);
            }
        } catch (Exception e2) {
            p0.a("MIMManager", e2.getMessage());
        }
    }

    public void i() {
        try {
            if (this.h != null) {
                Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                if (d2 != null) {
                    d2.unregisterReceiver(this.h);
                }
                this.f = null;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                }
                this.c = null;
                this.h = null;
            }
        } catch (Exception e2) {
            p0.a("MIMManager", e2.getMessage());
        }
    }

    private MIMManager() {
        this.b = 0;
        this.c = new CopyOnWriteArrayList<>();
        this.f4341a = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, CampaignEx campaignEx) {
        String[] w;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (w = nativeVideoTracking.w()) == null) {
                    return;
                }
                int length = w.length;
                int i2 = 0;
                while (i2 < length) {
                    Context context2 = context;
                    CampaignEx campaignEx2 = campaignEx;
                    com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), w[i2], false, false);
                    i2++;
                    context = context2;
                    campaignEx = campaignEx2;
                }
            } catch (Exception e2) {
                p0.b("MIMManager", e2.getMessage());
            }
        }
    }

    public String d() {
        try {
            return i == null ? "" : String.format("[%s]", i);
        } catch (Exception unused) {
            return "";
        }
    }

    public Boolean e() {
        return this.e;
    }

    public static MIMManager b() {
        return f.f4347a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, CampaignEx campaignEx) {
        String[] v;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (v = nativeVideoTracking.v()) == null) {
                    return;
                }
                int length = v.length;
                int i2 = 0;
                while (i2 < length) {
                    Context context2 = context;
                    CampaignEx campaignEx2 = campaignEx;
                    com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), v[i2], false, false);
                    i2++;
                    context = context2;
                    campaignEx = campaignEx2;
                }
            } catch (Exception e2) {
                p0.b("MIMManager", e2.getMessage());
            }
        }
    }

    CampaignEx c() {
        return this.f;
    }

    private Runnable c(Context context, CampaignEx campaignEx) {
        return new d(context, campaignEx);
    }

    public void b(Context context) {
        this.d = context;
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, CampaignEx campaignEx) {
        String[] u;
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                if (nativeVideoTracking == null || (u = nativeVideoTracking.u()) == null) {
                    return;
                }
                int length = u.length;
                int i2 = 0;
                while (i2 < length) {
                    Context context2 = context;
                    CampaignEx campaignEx2 = campaignEx;
                    com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), u[i2], false, false);
                    i2++;
                    context = context2;
                    campaignEx = campaignEx2;
                }
            } catch (Exception e2) {
                p0.b("MIMManager", e2.getMessage());
            }
        }
    }

    public void a(CampaignEx campaignEx) {
        try {
            if (this.e != null && campaignEx != null && this.e.booleanValue()) {
                this.f = campaignEx;
                this.c.add(campaignEx);
            }
            if (com.mbridge.msdk.util.b.b() && campaignEx != null && campaignEx.getDeepLinkURL().startsWith("mimarket")) {
                if (this.h == null) {
                    h();
                }
                this.f = campaignEx;
                this.c.add(campaignEx);
            }
        } catch (Exception e2) {
            p0.b("MIMManager", e2.getMessage());
        }
    }

    public void b(CampaignEx campaignEx) {
        try {
            if (this.e == null || campaignEx == null || !this.e.booleanValue()) {
                return;
            }
            this.f = null;
            try {
                this.c.remove(campaignEx);
            } catch (Exception e2) {
                p0.a("MIMManager", e2.getMessage());
            }
        } catch (Exception e3) {
            p0.b("MIMManager", e3.getMessage());
        }
    }

    private Runnable b(Context context, CampaignEx campaignEx) {
        return new b(context, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.c;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.c.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            p0.b("MIMManager", e2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean a() {
        Cursor cursor;
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        Boolean bool = null;
        if (d2 != null) {
            try {
                if (d2.getContentResolver() != null) {
                    try {
                        cursor = d2.getContentResolver().query(Uri.parse(j0.a("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                                    bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e2) {
                                p0.a("MIMManager", e2.getMessage());
                            }
                            try {
                                i = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e3) {
                                p0.a("MIMManager", e3.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            p0.a("MIMManager", e4.getMessage());
                        }
                    }
                }
            } catch (Exception e5) {
                p0.b("MIMManager", e5.getMessage());
            }
        }
        return bool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r4 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        r3.c = null;
        r3.g = null;
        r3.d = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        r4.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r4 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (context != null) {
            try {
                try {
                    if (this.g != null) {
                        context.unregisterReceiver(this.g);
                    }
                    if (this.h != null) {
                        context.unregisterReceiver(this.h);
                    }
                    this.f = null;
                    copyOnWriteArrayList = this.c;
                } catch (Exception e2) {
                    p0.a("MIMManager", e2.getMessage());
                    this.f = null;
                    copyOnWriteArrayList = this.c;
                }
            } catch (Throwable th) {
                this.f = null;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.c;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                this.c = null;
                this.g = null;
                this.d = null;
                throw th;
            }
        }
        try {
            i();
        } catch (Throwable th2) {
            p0.b("MIMManager", th2.getMessage());
        }
    }

    void a(Context context, CampaignEx campaignEx, int i2) {
        Runnable b2;
        if (i2 == 3001) {
            b2 = b(context, campaignEx);
        } else if (i2 != 3002) {
            b2 = i2 != 3008 ? null : c(context, campaignEx);
        } else {
            b2 = a(context, campaignEx);
        }
        if (b2 != null) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(b2);
        }
    }

    private Runnable a(Context context, CampaignEx campaignEx) {
        return new c(context, campaignEx);
    }

    void a(Context context, String str, int i2, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(context, str, campaignEx, i2));
    }
}
