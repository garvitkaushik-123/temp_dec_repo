package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import org.json.JSONObject;

/* compiled from: NetAddressManager.java */
/* loaded from: classes6.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f4364a;
    private com.mbridge.msdk.setting.j b;
    private long c;
    private final BroadcastReceiver d;
    IntentFilter e;

    /* compiled from: NetAddressManager.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final f0 f4365a = new f0();
    }

    public static f0 a() {
        return b.f4365a;
    }

    public String b() {
        try {
            if (this.f4364a == null) {
                this.f4364a = new JSONObject();
            }
            if (this.f4364a.length() < 2) {
                try {
                    this.f4364a.put("KEY_INFO", (String) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", ""));
                } catch (Exception e) {
                    p0.b("NetAddressManager", e.getMessage());
                }
                try {
                    this.f4364a.put("KEY_TIME", ((Long) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e2) {
                    p0.b("NetAddressManager", e2.getMessage());
                }
            }
            String optString = this.f4364a.optString("KEY_INFO");
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            com.mbridge.msdk.setting.g b2 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            return System.currentTimeMillis() - this.f4364a.optLong("KEY_TIME") > (b2 != null ? b2.R() : 3600L) * 1000 ? "" : optString;
        } catch (Exception e3) {
            p0.b("NetAddressManager", e3.getMessage());
            return "";
        }
    }

    public void c() {
        Context d;
        try {
            if (com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b()).S() != 1 || (d = com.mbridge.msdk.foundation.controller.c.m().d()) == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            this.e = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.registerReceiver(this.d, this.e);
        } catch (Exception e) {
            p0.b("NetAddressManager", e.getMessage());
        }
    }

    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c > 3000) {
            if (this.b == null) {
                this.b = new com.mbridge.msdk.setting.j();
            }
            this.b.c(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
            this.c = currentTimeMillis;
        }
    }

    public void e() {
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d != null) {
            try {
                d.unregisterReceiver(this.d);
            } catch (Exception e) {
                p0.b("NetAddressManager", e.getMessage());
            }
        }
    }

    private f0() {
        this.f4364a = new JSONObject();
        this.d = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.e = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public void a(String str) {
        if (this.f4364a == null) {
            this.f4364a = new JSONObject();
        }
        try {
            if (!this.f4364a.optString("KEY_INFO", "").equals(str)) {
                this.f4364a.put("KEY_INFO", str);
                c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", str);
            }
        } catch (Exception e) {
            p0.b("NetAddressManager", e.getMessage());
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f4364a.put("KEY_TIME", currentTimeMillis);
            c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", Long.valueOf(currentTimeMillis));
        } catch (Exception e2) {
            p0.b("NetAddressManager", e2.getMessage());
        }
    }
}
