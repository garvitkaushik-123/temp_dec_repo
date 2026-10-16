package com.pgl.ssdk;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes6.dex */
public class p0 extends m0 {
    private Context n;
    private final int o;

    public p0(Context context, int i) {
        super(context);
        this.n = context;
        this.o = i;
    }

    @Override // com.pgl.ssdk.m0
    public String a() {
        int i = this.o;
        if (i == 222) {
            return "/ssdk/v2/r?os=0&ver=7.5.0.0.overseas-rc.1&mode=1&app_ver=" + b0.h(this.n) + "&region=" + d0.a() + "&did=" + com.pgl.ssdk.ces.b.d() + "&aid=" + com.pgl.ssdk.ces.b.c();
        }
        if (i == 301) {
            return "/ssdk/sd/token?os=android&app_id=" + com.pgl.ssdk.ces.b.c() + "&did=" + com.pgl.ssdk.ces.b.d() + "&app_ver=" + b0.h(this.n) + "&platform=android&ver=7.5.0.0.overseas-rc.1&mode=1";
        }
        return null;
    }

    @Override // com.pgl.ssdk.m0
    public void a(int i, byte[] bArr) {
        try {
            if (i == 200) {
                int i2 = this.o;
                if (i2 == 222) {
                    ((Integer) com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, null, bArr)).intValue();
                    return;
                }
                if (i2 == 301) {
                    Object a2 = f1.a(bArr);
                    u0.b("write token result = ".concat(String.valueOf(a2)));
                    if ((a2 instanceof Integer) && ((Integer) a2).intValue() == 0) {
                        u0.b("write token succ");
                        f1.f6394a = 200;
                        return;
                    } else {
                        if (a2 instanceof String) {
                            f1.c = (String) a2;
                            f1.f6394a = 200;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            n0.b(this.n);
        } catch (Throwable unused) {
        }
    }
}
