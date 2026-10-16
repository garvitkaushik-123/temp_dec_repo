package com.ironsource;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.utils.IronSourceStorageUtils;

/* loaded from: classes6.dex */
class Xe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3134a;
    private final C3041d5 b;

    Xe(C3041d5 c3041d5, Handler handler) {
        this.b = c3041d5;
        this.f3134a = handler;
    }

    Z5 a(C3041d5 c3041d5, String str, long j) {
        return new Z5(c3041d5, str, j);
    }

    @Override // java.lang.Runnable
    public void run() {
        C3382x8 c3382x8 = new C3382x8(this.b.b().getParent(), this.b.b().getName());
        Message a2 = a();
        a2.obj = c3382x8;
        String a3 = a(c3382x8.getParent());
        if (a3 == null) {
            a2.what = 1020;
            this.f3134a.sendMessage(a2);
        } else {
            C3058e5 call = a(new C3041d5(c3382x8, this.b.e(), this.b.a(), this.b.c(), this.b.f(), this.b.d()), a3, 3L).call();
            a2.what = call.b() == 200 ? 1016 : call.b();
            this.f3134a.sendMessage(a2);
        }
    }

    Message a() {
        return new Message();
    }

    String a(String str) {
        return IronSourceStorageUtils.makeDir(str);
    }
}
