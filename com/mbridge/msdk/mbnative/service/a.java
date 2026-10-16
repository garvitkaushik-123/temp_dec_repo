package com.mbridge.msdk.mbnative.service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.d;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.Map;

/* compiled from: NativeProvider.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private NativeController f4523a;
    private Handler b = new Handler(Looper.getMainLooper());
    private com.mbridge.msdk.mbnative.listener.a c;
    private NativeListener.NativeTrackingListener d;

    /* compiled from: NativeProvider.java */
    /* renamed from: com.mbridge.msdk.mbnative.service.a$a, reason: collision with other inner class name */
    class RunnableC0359a implements Runnable {
        RunnableC0359a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    public a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.onAdLoadError("current request is loading");
        this.c.b();
    }

    public static void preload(Map<String, Object> map, int i) {
        p0.c("NativeProvider", "native provider preload");
        new d().a(map, i);
    }

    public void b(View view, Campaign campaign) {
        p0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f4523a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view);
    }

    public String c() {
        NativeController nativeController = this.f4523a;
        return nativeController != null ? nativeController.g() : "";
    }

    public void d() {
        a(0, "");
    }

    public void e() {
        a(1, "");
    }

    public void g() {
        try {
            this.f4523a.i();
        } catch (Exception unused) {
            p0.b("NativeProvider", "release failed");
        }
    }

    public void a(com.mbridge.msdk.mbnative.listener.a aVar) {
        this.c = aVar;
    }

    public a(com.mbridge.msdk.mbnative.listener.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.c = aVar;
        this.d = nativeTrackingListener;
    }

    public void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.d = nativeTrackingListener;
    }

    public void a(Context context, Resources resources, Map<String, Object> map) {
        this.f4523a = new NativeController(this.c, this.d, map, context);
    }

    public void a(String str) {
        a(0, str);
    }

    public void a() {
        try {
            this.f4523a.d();
        } catch (Exception unused) {
            p0.b("NativeProvider", "clear cache failed");
        }
    }

    public void b(View view, List<View> list, Campaign campaign) {
        p0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f4523a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view, list);
    }

    public void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.f4523a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view, list);
    }

    public String b() {
        NativeController nativeController = this.f4523a;
        if (nativeController != null) {
            return nativeController.e();
        }
        return "";
    }

    public void a(View view, Campaign campaign) {
        p0.c("NativeProvider", "native provider registerView");
        NativeController nativeController = this.f4523a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view);
    }

    private void a(int i, String str) {
        if (this.f4523a != null) {
            com.mbridge.msdk.mbnative.listener.a aVar = this.c;
            if (aVar != null && aVar.a()) {
                if (u0.h()) {
                    f();
                    return;
                } else {
                    this.b.post(new RunnableC0359a());
                    return;
                }
            }
            com.mbridge.msdk.mbnative.listener.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.f4523a.a(i, str);
        }
    }
}
