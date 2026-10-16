package com.vungle.ads.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityManager.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0003()*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J.\u0010\"\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "foregroundActivityCount", "", "isAppInForeground", "", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "targetActivityInfo", "Lcom/vungle/ads/internal/util/ActivityManager$TargetActivityInfo;", "addListener", "", "callback", "deInit", "context", "Landroid/content/Context;", C3040d4.a.f, "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "removeListener", "startActivitySafely", "deepLinkOverrideIntent", "Landroid/content/Intent;", "defaultIntent", "adOpenCallback", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "Companion", "LifeCycleCallback", "TargetActivityInfo", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ActivityManager implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityManager";
    private volatile int foregroundActivityCount;
    private volatile boolean isAppInForeground;
    private volatile TargetActivityInfo targetActivityInfo;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ActivityManager instance = new ActivityManager();
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final CopyOnWriteArraySet<LifeCycleCallback> callbacks = new CopyOnWriteArraySet<>();

    /* compiled from: ActivityManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "", "()V", "onBackground", "", "onForeground", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class LifeCycleCallback {
        public void onBackground() {
        }

        public void onForeground() {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    private ActivityManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(Context context) {
        Object m10241constructorimpl;
        if (this.isInitialized.getAndSet(true)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ActivityManager activityManager = this;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Logger.INSTANCE.e(TAG, "Error initializing ActivityManager", m10244exceptionOrNullimpl);
            this.isInitialized.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deInit(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
        this.isInitialized.set(false);
        this.targetActivityInfo = null;
        this.foregroundActivityCount = 0;
        this.isAppInForeground = false;
        this.callbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAppInForeground() {
        return !this.isInitialized.get() || this.isAppInForeground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addListener(LifeCycleCallback callback) {
        this.callbacks.add(callback);
    }

    public final void removeListener(LifeCycleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.foregroundActivityCount++;
        if (this.isAppInForeground || this.foregroundActivityCount != 1) {
            return;
        }
        this.isAppInForeground = true;
        TargetActivityInfo targetActivityInfo = this.targetActivityInfo;
        if (targetActivityInfo != null) {
            Context it = targetActivityInfo.getContext().get();
            if (it != null) {
                Companion companion = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                companion.startWhenForeground(it, targetActivityInfo.getDeepLinkOverrideIntent(), targetActivityInfo.getDefaultIntent(), targetActivityInfo.getAdOpenCallback());
            }
            this.targetActivityInfo = null;
        }
        Iterator<T> it2 = this.callbacks.iterator();
        while (it2.hasNext()) {
            ((LifeCycleCallback) it2.next()).onForeground();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.foregroundActivityCount--;
        if (this.isAppInForeground && this.foregroundActivityCount == 0) {
            this.isAppInForeground = false;
            Iterator<T> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ((LifeCycleCallback) it.next()).onBackground();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean startActivitySafely(Context context, Intent deepLinkOverrideIntent, Intent defaultIntent, PresenterAdOpenCallback adOpenCallback) {
        try {
        } catch (Exception e) {
            Logger.INSTANCE.e(TAG, "Failed to start activity: " + e);
            if (deepLinkOverrideIntent != null && adOpenCallback != null) {
                try {
                    adOpenCallback.onDeeplinkClick(false);
                } catch (Exception unused) {
                }
            }
            if (deepLinkOverrideIntent != null && defaultIntent != null) {
                context.startActivity(defaultIntent);
                return true;
            }
        }
        if (deepLinkOverrideIntent == null) {
            if (defaultIntent != null) {
                context.startActivity(defaultIntent);
            }
            return false;
        }
        context.startActivity(deepLinkOverrideIntent);
        if (adOpenCallback != null) {
            adOpenCallback.onDeeplinkClick(true);
        }
        return true;
    }

    /* compiled from: ActivityManager.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$TargetActivityInfo;", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "deepLinkOverrideIntent", "Landroid/content/Intent;", "defaultIntent", "adOpenCallback", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "(Ljava/lang/ref/WeakReference;Landroid/content/Intent;Landroid/content/Intent;Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;)V", "getAdOpenCallback", "()Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "getContext", "()Ljava/lang/ref/WeakReference;", "getDeepLinkOverrideIntent", "()Landroid/content/Intent;", "getDefaultIntent", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final /* data */ class TargetActivityInfo {
        private final PresenterAdOpenCallback adOpenCallback;
        private final WeakReference<Context> context;
        private final Intent deepLinkOverrideIntent;
        private final Intent defaultIntent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TargetActivityInfo copy$default(TargetActivityInfo targetActivityInfo, WeakReference weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback, int i, Object obj) {
            if ((i & 1) != 0) {
                weakReference = targetActivityInfo.context;
            }
            if ((i & 2) != 0) {
                intent = targetActivityInfo.deepLinkOverrideIntent;
            }
            if ((i & 4) != 0) {
                intent2 = targetActivityInfo.defaultIntent;
            }
            if ((i & 8) != 0) {
                presenterAdOpenCallback = targetActivityInfo.adOpenCallback;
            }
            return targetActivityInfo.copy(weakReference, intent, intent2, presenterAdOpenCallback);
        }

        public final WeakReference<Context> component1() {
            return this.context;
        }

        /* renamed from: component2, reason: from getter */
        public final Intent getDeepLinkOverrideIntent() {
            return this.deepLinkOverrideIntent;
        }

        /* renamed from: component3, reason: from getter */
        public final Intent getDefaultIntent() {
            return this.defaultIntent;
        }

        /* renamed from: component4, reason: from getter */
        public final PresenterAdOpenCallback getAdOpenCallback() {
            return this.adOpenCallback;
        }

        public final TargetActivityInfo copy(WeakReference<Context> context, Intent deepLinkOverrideIntent, Intent defaultIntent, PresenterAdOpenCallback adOpenCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new TargetActivityInfo(context, deepLinkOverrideIntent, defaultIntent, adOpenCallback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetActivityInfo)) {
                return false;
            }
            TargetActivityInfo targetActivityInfo = (TargetActivityInfo) other;
            return Intrinsics.areEqual(this.context, targetActivityInfo.context) && Intrinsics.areEqual(this.deepLinkOverrideIntent, targetActivityInfo.deepLinkOverrideIntent) && Intrinsics.areEqual(this.defaultIntent, targetActivityInfo.defaultIntent) && Intrinsics.areEqual(this.adOpenCallback, targetActivityInfo.adOpenCallback);
        }

        public int hashCode() {
            int hashCode = this.context.hashCode() * 31;
            Intent intent = this.deepLinkOverrideIntent;
            int hashCode2 = (hashCode + (intent == null ? 0 : intent.hashCode())) * 31;
            Intent intent2 = this.defaultIntent;
            int hashCode3 = (hashCode2 + (intent2 == null ? 0 : intent2.hashCode())) * 31;
            PresenterAdOpenCallback presenterAdOpenCallback = this.adOpenCallback;
            return hashCode3 + (presenterAdOpenCallback != null ? presenterAdOpenCallback.hashCode() : 0);
        }

        public String toString() {
            return "TargetActivityInfo(context=" + this.context + ", deepLinkOverrideIntent=" + this.deepLinkOverrideIntent + ", defaultIntent=" + this.defaultIntent + ", adOpenCallback=" + this.adOpenCallback + ')';
        }

        public TargetActivityInfo(WeakReference<Context> context, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.deepLinkOverrideIntent = intent;
            this.defaultIntent = intent2;
            this.adOpenCallback = presenterAdOpenCallback;
        }

        public final WeakReference<Context> getContext() {
            return this.context;
        }

        public final Intent getDeepLinkOverrideIntent() {
            return this.deepLinkOverrideIntent;
        }

        public final Intent getDefaultIntent() {
            return this.defaultIntent;
        }

        public final PresenterAdOpenCallback getAdOpenCallback() {
            return this.adOpenCallback;
        }
    }

    /* compiled from: ActivityManager.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ,\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$Companion;", "", "()V", "TAG", "", C3207n2.p, "Lcom/vungle/ads/internal/util/ActivityManager;", "getInstance$vungle_ads_release$annotations", "getInstance$vungle_ads_release", "()Lcom/vungle/ads/internal/util/ActivityManager;", "addLifecycleListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "deInit", "context", "Landroid/content/Context;", "deInit$vungle_ads_release", C3040d4.a.f, "isForeground", "", "removeLifecycleListener", "startWhenForeground", "deepLinkOverrideIntent", "Landroid/content/Intent;", "defaultIntent", "adOpenCallback", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getInstance$vungle_ads_release$annotations() {
        }

        private Companion() {
        }

        public final ActivityManager getInstance$vungle_ads_release() {
            return ActivityManager.instance;
        }

        public final boolean startWhenForeground(Context context, Intent deepLinkOverrideIntent, Intent defaultIntent, PresenterAdOpenCallback adOpenCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (isForeground()) {
                return getInstance$vungle_ads_release().startActivitySafely(context, deepLinkOverrideIntent, defaultIntent, adOpenCallback);
            }
            getInstance$vungle_ads_release().targetActivityInfo = new TargetActivityInfo(new WeakReference(context), deepLinkOverrideIntent, defaultIntent, adOpenCallback);
            return false;
        }

        public final void init(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            getInstance$vungle_ads_release().init(context);
        }

        public final boolean isForeground() {
            return getInstance$vungle_ads_release().isAppInForeground();
        }

        public final void addLifecycleListener(LifeCycleCallback listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getInstance$vungle_ads_release().addListener(listener);
        }

        public final void removeLifecycleListener(LifeCycleCallback listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getInstance$vungle_ads_release().removeListener(listener);
        }

        public final void deInit$vungle_ads_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            getInstance$vungle_ads_release().deInit(context);
        }
    }
}
