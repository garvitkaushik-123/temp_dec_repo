package com.ironsource.sdk.controller;

import com.ironsource.C3040d4;
import com.ironsource.C3092g5;
import com.ironsource.C3260q4;
import com.ironsource.C3264q8;
import com.ironsource.C3348v8;
import com.ironsource.C3382x8;
import com.ironsource.D5;
import com.ironsource.Md;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class d {
    static final String h = "controllerSourceData";
    private static final String i = "next_";
    private static final String j = "fallback_";
    private static final String k = "controllerSourceCode";

    /* renamed from: a, reason: collision with root package name */
    private long f3713a;
    private int b;
    private c c;
    private EnumC0299d d = EnumC0299d.NONE;
    private String e;
    private String f;
    private C3092g5 g;

    class a extends JSONObject {
        a() throws JSONException {
            putOpt(C3040d4.a.j, Integer.valueOf(d.this.b));
            putOpt(d.k, Integer.valueOf(d.this.d.b()));
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3715a;

        static {
            int[] iArr = new int[c.values().length];
            f3715a = iArr;
            try {
                iArr[c.FETCH_FROM_SERVER_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3715a[c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3715a[c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum c {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* renamed from: com.ironsource.sdk.controller.d$d, reason: collision with other inner class name */
    public enum EnumC0299d {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);


        /* renamed from: a, reason: collision with root package name */
        private int f3717a;

        EnumC0299d(int i) {
            this.f3717a = i;
        }

        public int b() {
            return this.f3717a;
        }
    }

    d(JSONObject jSONObject, String str, String str2, C3092g5 c3092g5) {
        int optInt = jSONObject.optInt(C3040d4.a.j, -1);
        this.b = optInt;
        this.c = a(optInt);
        this.e = str;
        this.f = str2;
        this.g = c3092g5;
    }

    private c a(int i2) {
        return i2 != 1 ? i2 != 2 ? c.FETCH_FROM_SERVER_NO_FALLBACK : c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL : c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private boolean b() throws Exception {
        return IronSourceStorageUtils.renameFile(i().getPath(), g().getPath());
    }

    private void c() {
        try {
            C3382x8 g = g();
            if (g.exists()) {
                C3382x8 h2 = h();
                if (h2.exists()) {
                    h2.delete();
                }
                IronSourceStorageUtils.renameFile(g.getPath(), h2.getPath());
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }

    private void d() {
        IronSourceStorageUtils.deleteFile(h());
    }

    private void e() {
        IronSourceStorageUtils.deleteFile(g());
    }

    private C3382x8 h() {
        return new C3382x8(this.e, "fallback_mobileController.html");
    }

    private C3382x8 i() {
        return new C3382x8(this.e, "next_mobileController.html");
    }

    private boolean j() {
        return h().exists();
    }

    private void l() {
        C3264q8 a2 = new C3264q8().a(D5.y, Integer.valueOf(this.b));
        if (this.f3713a > 0) {
            a2.a(D5.B, Long.valueOf(System.currentTimeMillis() - this.f3713a));
        }
        C3348v8.a(Md.x, a2.a());
    }

    JSONObject f() throws JSONException {
        return new a();
    }

    C3382x8 g() {
        return new C3382x8(this.e, C3040d4.f);
    }

    boolean k() {
        int i2 = b.f3715a[this.c.ordinal()];
        if (i2 == 1) {
            e();
            a(new C3382x8(this.e, SDKUtils.getFileName(this.f)));
            return false;
        }
        if (i2 == 2) {
            c();
            a(new C3382x8(this.e, SDKUtils.getFileName(this.f)));
            return false;
        }
        if (i2 == 3) {
            try {
                C3382x8 g = g();
                C3382x8 i3 = i();
                if (!i3.exists() && !g.exists()) {
                    a(new C3382x8(this.e, SDKUtils.getFileName(this.f)));
                    return false;
                }
                if (!i3.exists() && g.exists()) {
                    EnumC0299d enumC0299d = EnumC0299d.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                    this.d = enumC0299d;
                    a(enumC0299d);
                    a(new C3382x8(this.e, i3.getName()));
                    return true;
                }
                c();
                if (b()) {
                    EnumC0299d enumC0299d2 = EnumC0299d.PREPARED_CONTROLLER_LOADED;
                    this.d = enumC0299d2;
                    a(enumC0299d2);
                    d();
                    a(new C3382x8(this.e, i3.getName()));
                    return true;
                }
                if (!a()) {
                    a(new C3382x8(this.e, SDKUtils.getFileName(this.f)));
                    return false;
                }
                EnumC0299d enumC0299d3 = EnumC0299d.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                this.d = enumC0299d3;
                a(enumC0299d3);
                a(new C3382x8(this.e, i3.getName()));
                return true;
            } catch (Exception e) {
                C3260q4.d().a(e);
            }
        }
        return false;
    }

    boolean m() {
        return this.d != EnumC0299d.NONE;
    }

    void a(Runnable runnable) {
        if (m()) {
            return;
        }
        if (this.c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
            d();
        }
        EnumC0299d enumC0299d = EnumC0299d.CONTROLLER_FROM_SERVER;
        this.d = enumC0299d;
        a(enumC0299d);
        runnable.run();
    }

    void a(Runnable runnable, Runnable runnable2) {
        if (m()) {
            return;
        }
        if (this.c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK && a()) {
            EnumC0299d enumC0299d = EnumC0299d.FALLBACK_CONTROLLER_RECOVERY;
            this.d = enumC0299d;
            a(enumC0299d);
            runnable.run();
            return;
        }
        l();
        runnable2.run();
    }

    private void a(C3382x8 c3382x8) {
        if (this.g.c()) {
            return;
        }
        this.g.a(c3382x8, this.f);
    }

    void a(C3264q8 c3264q8) {
        c3264q8.a(D5.y, Integer.valueOf(this.b));
        C3348v8.a(Md.v, c3264q8.a());
        this.f3713a = System.currentTimeMillis();
    }

    private void a(EnumC0299d enumC0299d) {
        C3264q8 a2 = new C3264q8().a(D5.y, Integer.valueOf(this.b)).a(D5.z, Integer.valueOf(enumC0299d.b()));
        if (this.f3713a > 0) {
            a2.a(D5.B, Long.valueOf(System.currentTimeMillis() - this.f3713a));
        }
        C3348v8.a(Md.w, a2.a());
    }

    private boolean a() {
        try {
            if (j()) {
                return IronSourceStorageUtils.renameFile(h().getPath(), g().getPath());
            }
            return false;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return false;
        }
    }
}
