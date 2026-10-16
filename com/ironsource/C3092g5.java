package com.ironsource;

import android.os.Handler;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.ironsource.g5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3092g5 implements InterfaceC3398y7 {
    private static final int e = 5;
    private static C3092g5 f;

    /* renamed from: a, reason: collision with root package name */
    private HandlerC3075f5 f3313a;
    private final JSONObject b;
    private Thread c;
    private final String d;

    private C3092g5(String str, R7 r7, JSONObject jSONObject) {
        this.d = str;
        this.f3313a = new HandlerC3075f5(r7.a());
        this.b = jSONObject;
        IronSourceStorageUtils.deleteFolder(b());
        IronSourceStorageUtils.makeDir(b());
    }

    public static synchronized C3092g5 a(String str, R7 r7, JSONObject jSONObject) {
        C3092g5 c3092g5;
        synchronized (C3092g5.class) {
            if (f == null) {
                f = new C3092g5(str, r7, jSONObject);
            }
            c3092g5 = f;
        }
        return c3092g5;
    }

    private Thread b(C3382x8 c3382x8, String str, int i, int i2, Handler handler) {
        if (i <= 0) {
            i = this.b.optInt("connectionTimeout", 5);
        }
        if (i2 <= 0) {
            i2 = this.b.optInt("readTimeout", 5);
        }
        boolean optBoolean = this.b.optBoolean(C3074f4.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a(new C3041d5(c3382x8, str, (int) timeUnit.toMillis(i), (int) timeUnit.toMillis(i2), optBoolean, b()), handler);
    }

    public boolean c() {
        Thread thread = this.c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f = null;
        HandlerC3075f5 handlerC3075f5 = this.f3313a;
        if (handlerC3075f5 != null) {
            handlerC3075f5.a();
            this.f3313a = null;
        }
    }

    @Override // com.ironsource.InterfaceC3398y7
    public void a(InterfaceC3386xc interfaceC3386xc) {
        this.f3313a.a(interfaceC3386xc);
    }

    private Thread a(C3041d5 c3041d5, Handler handler) {
        return new Thread(new Xe(c3041d5, handler));
    }

    @Override // com.ironsource.InterfaceC3398y7
    public void a(C3382x8 c3382x8, String str, int i, int i2, Handler handler) {
        b(c3382x8, str, i, i2, handler).start();
    }

    @Override // com.ironsource.InterfaceC3398y7
    public void a(C3382x8 c3382x8, String str, int i, int i2) {
        b(c3382x8, str, i, i2, this.f3313a).start();
    }

    @Override // com.ironsource.InterfaceC3398y7
    public void a(C3382x8 c3382x8, String str) {
        int optInt = this.b.optInt("connectionTimeout", 5);
        int optInt2 = this.b.optInt("readTimeout", 5);
        boolean optBoolean = this.b.optBoolean(C3074f4.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Thread a2 = a(new C3041d5(c3382x8, str, (int) timeUnit.toMillis(optInt), (int) timeUnit.toMillis(optInt2), optBoolean, b()), this.f3313a);
        this.c = a2;
        a2.start();
    }

    private String b() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.d, "temp");
    }

    public String a() {
        return this.d;
    }
}
