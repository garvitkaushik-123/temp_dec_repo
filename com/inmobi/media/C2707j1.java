package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.j1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2707j1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final HandlerC2674h1 f2606a;
    public WeakReference b;
    public final /* synthetic */ Context c;

    public C2707j1(Context context) {
        this.c = context;
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
        this.f2606a = new HandlerC2674h1(mainLooper);
    }

    public static final void a(Context context, C2707j1 this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (C2723k1.a(C2723k1.f2618a, context) || this$0.b != null) {
            return;
        }
        this$0.f2606a.sendEmptyMessageDelayed(1001, 3000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference weakReference = this.b;
        if (!Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, activity)) {
            this.b = new WeakReference(activity);
        }
        this.f2606a.removeMessages(1001);
        this.f2606a.sendEmptyMessage(1002);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference weakReference = this.b;
        if (!Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, activity)) {
            this.b = new WeakReference(activity);
        }
        this.f2606a.removeMessages(1001);
        this.f2606a.sendEmptyMessage(1002);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference weakReference = this.b;
        if (Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, activity)) {
            this.f2606a.sendEmptyMessageDelayed(1001, 3000L);
        } else if (this.b == null) {
            final Context context = this.c;
            Uc.a(new Runnable() { // from class: com.inmobi.media.j1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2707j1.a(context, this);
                }
            });
        }
    }
}
