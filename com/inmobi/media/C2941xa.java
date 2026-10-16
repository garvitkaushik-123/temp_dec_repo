package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.xa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2941xa implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Object obj;
        Picasso picasso;
        WeakReference a2;
        List list;
        List list2;
        Picasso picasso2;
        Picasso picasso3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        obj = C2960ya.c;
        synchronized (obj) {
            picasso = C2960ya.b;
            if (picasso != null && (a2 = C2960ya.a(C2960ya.f2764a, activity)) != null) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                list = C2960ya.d;
                list.remove(a2);
                list2 = C2960ya.d;
                if (list2.isEmpty()) {
                    Intrinsics.checkNotNullExpressionValue(C2960ya.d(), "access$getTAG$p(...)");
                    picasso2 = C2960ya.b;
                    Objects.toString(picasso2);
                    picasso3 = C2960ya.b;
                    if (picasso3 != null) {
                        picasso3.shutdown();
                    }
                    C2960ya.b = null;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
