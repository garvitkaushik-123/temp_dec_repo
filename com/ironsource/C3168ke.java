package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3337ue;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ke, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3168ke {

    /* renamed from: a, reason: collision with root package name */
    private final J9 f3410a = new J9();
    private final C3113h9 b = new C3113h9(IronSourceThreadManager.INSTANCE.getInitHandler());
    private final InterfaceC3381x7 c = C3334ub.s.d().i();

    /* renamed from: com.ironsource.ke$a */
    public static final class a extends Pd {
        final /* synthetic */ Runnable b;

        a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.ironsource.Pd
        public void a() {
            this.b.run();
        }
    }

    public final void a(Pd safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final InterfaceC3381x7 b() {
        return this.c;
    }

    public final J9 c() {
        return this.f3410a;
    }

    public final void d(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    public final void e(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new a(callback), 0L, 2, null);
    }

    public final void f() {
        com.ironsource.mediationsdk.p.j().S();
    }

    public final void g() {
        C3334ub.s.d().q().a(new C3413z5(A5.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
    }

    public static /* synthetic */ void a(C3168ke c3168ke, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c3168ke.a(runnable, j);
    }

    public final void b(Pd safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.b.a(safeRunnable);
    }

    public final void c(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.b.b(runnable);
    }

    public final IronSourceSegment d() {
        return com.ironsource.mediationsdk.p.j().q();
    }

    public final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable, j);
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, runnable, 0L, 2, null);
    }

    public final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return IronSourceUtils.isNetworkConnected(context);
    }

    public final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.b.a(callback);
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String M = this.c.M(context);
        Intrinsics.checkNotNullExpressionValue(M, "deviceInfoService.getOrG…UniqueIdentifier(context)");
        return M;
    }

    public final boolean e() {
        return IronSourceUtils.isEncryptedResponse();
    }

    public final void a(Pd safeRunnable, long j) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.b.a(safeRunnable, j);
    }

    public static /* synthetic */ void a(C3168ke c3168ke, Pd pd, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c3168ke.a(pd, j);
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        K6.a().a(key, value);
    }

    public final void a(long j, C3337ue.a responseOrigin) {
        Intrinsics.checkNotNullParameter(responseOrigin, "responseOrigin");
        com.ironsource.mediationsdk.p.j().a(j, responseOrigin);
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String advertiserId = com.ironsource.mediationsdk.p.j().getAdvertiserId(context);
        Intrinsics.checkNotNullExpressionValue(advertiserId, "getInstance().getAdvertiserId(context)");
        return advertiserId;
    }

    public final C3337ue a(Context context, String appKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        return com.ironsource.mediationsdk.p.j().a(context, appKey);
    }

    public final void a(D1 reporterSettings) {
        Intrinsics.checkNotNullParameter(reporterSettings, "reporterSettings");
        C3260q4.d().a(reporterSettings.b(), reporterSettings.d(), reporterSettings.c(), reporterSettings.e(), IronSourceUtils.getSessionId(), reporterSettings.a(), reporterSettings.g());
    }

    public final void a(EnumC3135ie initStatus) {
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        C3151je.f3381a.a(initStatus);
    }

    public final void a() {
        C3167kd.c().a();
    }
}
