package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ironsource.t8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3314t8 implements InterfaceC3195m7 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f3845a = new HashMap();

    /* renamed from: com.ironsource.t8$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3846a;
        String b;
        String c;
        Context d;
        String e;

        a a(String str) {
            this.b = str;
            return this;
        }

        a b(String str) {
            this.c = str;
            return this;
        }

        a c(String str) {
            this.f3846a = str;
            return this;
        }

        a d(String str) {
            this.e = str;
            return this;
        }

        a a(Context context) {
            this.d = context;
            return this;
        }

        public C3314t8 a() {
            return new C3314t8(this);
        }
    }

    private C3314t8(a aVar) {
        a(aVar);
        a(aVar.d);
    }

    private void a(Context context) {
        f3845a.put(D5.e, C2986a4.b(context));
        f3845a.put(D5.f, C2986a4.d(context));
    }

    public static void b(String str) {
        f3845a.put(D5.f, SDKUtils.encodeString(str));
    }

    private void a(a aVar) {
        Context context = aVar.d;
        Z4 b = Z4.b(context);
        f3845a.put(D5.j, SDKUtils.encodeString(b.e()));
        f3845a.put(D5.k, SDKUtils.encodeString(b.f()));
        f3845a.put(D5.l, Integer.valueOf(b.a()));
        f3845a.put(D5.m, SDKUtils.encodeString(b.d()));
        f3845a.put(D5.n, SDKUtils.encodeString(b.c()));
        f3845a.put(D5.d, SDKUtils.encodeString(context.getPackageName()));
        f3845a.put(D5.g, SDKUtils.encodeString(aVar.b));
        f3845a.put("sessionid", SDKUtils.encodeString(aVar.f3846a));
        f3845a.put(D5.b, SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        f3845a.put(D5.o, "prod");
        f3845a.put("origin", D5.q);
        if (TextUtils.isEmpty(aVar.e)) {
            return;
        }
        f3845a.put(D5.i, SDKUtils.encodeString(aVar.e));
    }

    @Override // com.ironsource.InterfaceC3195m7
    public Map<String, Object> a() {
        return f3845a;
    }

    public static void a(String str) {
        f3845a.put(D5.e, SDKUtils.encodeString(str));
    }
}
