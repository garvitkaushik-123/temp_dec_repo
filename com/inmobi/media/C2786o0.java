package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.o0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2786o0 {

    /* renamed from: a, reason: collision with root package name */
    public final AdConfig.AdQualityConfig f2655a;
    public final InterfaceC2971z5 b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final CopyOnWriteArrayList f;
    public AdQualityControl g;
    public EnumC2620df h;
    public AdQualityResult i;
    public String j;
    public JSONObject k;
    public final AtomicBoolean l;

    public C2786o0(AdConfig.AdQualityConfig adQualityConfig, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(adQualityConfig, "adQualityConfig");
        this.f2655a = adQualityConfig;
        this.b = interfaceC2971z5;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new CopyOnWriteArrayList();
        this.h = EnumC2620df.f2552a;
        this.j = "";
        this.k = new JSONObject();
        this.l = new AtomicBoolean(false);
    }

    public final boolean a() {
        if (this.c.get()) {
            a("ad quality session is already in progress. skipping...");
            return false;
        }
        if (!this.f2655a.getEnabled()) {
            a("config kill switch - false. ad quality will skip");
            return false;
        }
        if (this.g == null) {
            a("setup not done. skipping");
            return false;
        }
        EnumC2620df enumC2620df = this.h;
        if (enumC2620df != EnumC2620df.f2552a && enumC2620df != EnumC2620df.b) {
            return true;
        }
        a("ad view is not visible. skipping");
        return false;
    }

    public final void a(AdQualityResult adQualityResult, boolean z) {
        if (adQualityResult.getBeaconUrl().length() == 0) {
            a("beacon is empty");
            return;
        }
        C2910vb process = new C2910vb(adQualityResult);
        C2689i0 c2689i0 = new C2689i0(this, z);
        C2706j0 shouldProcess = C2706j0.f2605a;
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        C2638f0.a(0L, new C2604d(shouldProcess, process, c2689i0));
    }

    public final void a(final GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, final long j, final boolean z, final Jb jb) {
        a("isCapture started - " + this.l.get() + ", isReporting - " + z);
        if (this.l.get() && !z) {
            a((Exception) null, "Screenshot process already in progress... skipping...");
        } else {
            gestureDetectorOnGestureListenerC2634ec.post(new Runnable() { // from class: com.inmobi.media.o0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2786o0.a(C2786o0.this, gestureDetectorOnGestureListenerC2634ec, j, z, jb);
                }
            });
        }
    }

    public static final void a(C2786o0 this$0, View adView, long j, boolean z, Jb jb) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adView, "$adView");
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter("starting capture - draw", PglCryptUtils.KEY_MESSAGE);
        Log.i("AdQualityManager", "starting capture - draw");
        this$0.getClass();
        Intrinsics.checkNotNullParameter(adView, "adView");
        Qc process = new Qc(adView, this$0.f2655a);
        if (!z) {
            this$0.f.add(process);
        }
        C2754m0 c2754m0 = new C2754m0(this$0, process, z, jb);
        C2770n0 shouldProcess = new C2770n0(this$0);
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        C2638f0.a(j, new C2604d(shouldProcess, process, c2754m0));
        this$0.l.set(!z);
    }

    public final void a(final Activity activity, final long j, final boolean z, final Jb jb) {
        a("isCapture started - " + this.l.get() + ", isReporting - " + z);
        if (this.l.get() && !z) {
            a((Exception) null, "Screenshot process already in progress... skipping...");
        } else {
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.inmobi.media.o0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C2786o0.a(C2786o0.this, activity, j, z, jb);
                }
            });
        }
    }

    public static final void a(C2786o0 this$0, Activity activity, long j, boolean z, Jb jb) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.a("activity is visible");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        Intrinsics.checkNotNullParameter(window, "window");
        Qa process = new Qa(window, this$0.f2655a);
        if (!z) {
            this$0.f.add(process);
        }
        C2754m0 c2754m0 = new C2754m0(this$0, process, z, jb);
        C2770n0 shouldProcess = new C2770n0(this$0);
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        C2638f0.a(j, new C2604d(shouldProcess, process, c2754m0));
        this$0.l.set(!z);
    }

    public final void a(String str, byte[] bArr, boolean z) {
        Context d = Uc.d();
        if (d != null) {
            Dd process = new Dd(d.getFilesDir().getAbsolutePath() + "/adQuality/screenshots", bArr);
            if (!z) {
                this.f.add(process);
            }
            C2722k0 c2722k0 = new C2722k0(this, z, process, str);
            C2738l0 shouldProcess = C2738l0.f2627a;
            Intrinsics.checkNotNullParameter(process, "process");
            Intrinsics.checkNotNullParameter(shouldProcess, "shouldProcess");
            ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
            C2638f0.a(0L, new C2604d(shouldProcess, process, c2722k0));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean z) {
        String beacon;
        AdQualityResult adQualityResult;
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter("checking for trigger", PglCryptUtils.KEY_MESSAGE);
        Log.i("AdQualityManager", "checking for trigger");
        AdQualityControl adQualityControl = this.g;
        if (adQualityControl == null || (beacon = adQualityControl.getBeacon()) == null) {
            return;
        }
        if (this.f.isEmpty() && this.d.get() && !this.e.get()) {
            this.e.set(true);
            a("session end - queuing result");
            AdQualityResult adQualityResult2 = this.i;
            if (adQualityResult2 == null) {
                adQualityResult2 = new AdQualityResult("null", null, beacon, null, 8, null);
            }
            a(adQualityResult2, true);
            return;
        }
        if (this.d.get() && !z && !this.e.get()) {
            this.e.set(true);
            a("session stop - queuing result");
            ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
                try {
                    try {
                        scheduledExecutorService.shutdownNow();
                    } catch (Exception e) {
                        Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                        Intrinsics.checkNotNullParameter("shutdown fail", PglCryptUtils.KEY_MESSAGE);
                        Log.e("AdQualityComponent", "shutdown fail", e);
                        Thread.currentThread().interrupt();
                        adQualityResult = this.i;
                        if (adQualityResult == null) {
                        }
                        a(adQualityResult, true);
                        return;
                    }
                } catch (InterruptedException unused) {
                    scheduledExecutorService.shutdownNow();
                    Thread.currentThread().interrupt();
                    adQualityResult = this.i;
                    if (adQualityResult == null) {
                    }
                    a(adQualityResult, true);
                    return;
                }
            }
            adQualityResult = this.i;
            if (adQualityResult == null) {
                adQualityResult = new AdQualityResult("null", null, beacon, null, 8, null);
            }
            a(adQualityResult, true);
            return;
        }
        String message = "list size - " + this.f.size() + " session end triggered - " + this.d.get() + " queue triggered - " + this.e + " waiting";
        Intrinsics.checkNotNullParameter("AdQualityManager", "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("AdQualityManager", message);
    }

    public final void a(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("AdQualityManager", str);
        }
    }

    public final void a(Exception exc, String str) {
        Unit unit;
        if (exc != null) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("AdQualityManager", str, exc);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.b;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).b("AdQualityManager", AbstractC2673h0.a("Error with null exception : ", str));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
