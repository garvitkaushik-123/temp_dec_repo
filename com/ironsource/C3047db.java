package com.ironsource;

import android.content.Context;
import android.os.Handler;
import android.view.Choreographer;
import com.ironsource.C3337ue;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.db, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3047db {

    /* renamed from: a, reason: collision with root package name */
    private final C3113h9 f3255a = new C3113h9(null, 1, null);

    /* renamed from: com.ironsource.db$a */
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

    /* renamed from: com.ironsource.db$b */
    public static final class b extends Pd {
        final /* synthetic */ Function0<Unit> b;

        b(Function0<Unit> function0) {
            this.b = function0;
        }

        @Override // com.ironsource.Pd
        public void a() {
            this.b.invoke();
        }
    }

    public final void a(Pd safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final void b(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.db$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3047db.a(C3047db.this, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void c(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.db$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3047db.b(C3047db.this, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void d(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f3255a.b(runnable);
    }

    public final void e(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3047db this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        this$0.f3255a.b(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final C3047db this$0, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.ironsource.db$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                C3047db.a(C3047db.this, runnable, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3047db this$0, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        this$0.b(runnable);
    }

    public final void b(Pd safeRunnable) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.f3255a.a(safeRunnable);
    }

    public static /* synthetic */ void a(C3047db c3047db, Runnable runnable, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOnUIThread");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        c3047db.a(runnable, j);
    }

    public final void b(String adUnitId, int i, String str) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
        jSONObject.putOpt("reason", str);
        jSONObject.put("mediationAdUnitId", adUnitId);
        jSONObject.put("isMultipleAdUnits", 1);
        C3051df.a(A5.TROUBLESHOOTING_AD_UNIT_REWARD_PARSE_ERROR, jSONObject);
    }

    public final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(runnable), j);
    }

    public final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f3255a.a(callback);
    }

    public final void a(Pd safeRunnable, long j) {
        Intrinsics.checkNotNullParameter(safeRunnable, "safeRunnable");
        this.f3255a.a(safeRunnable, j);
    }

    public static /* synthetic */ void a(C3047db c3047db, Pd pd, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        c3047db.a(pd, j);
    }

    public static /* synthetic */ void a(C3047db c3047db, Function0 function0, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        c3047db.a((Function0<Unit>) function0, j);
    }

    public final void a(Function0<Unit> action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        a((Pd) new b(action), j);
    }

    public final Handler a() {
        return this.f3255a.a();
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IntegrationHelper.validateIntegration(context.getApplicationContext());
    }

    public final IronSource.AD_UNIT[] a(LevelPlay.AdFormat... adFormats) {
        Intrinsics.checkNotNullParameter(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        for (LevelPlay.AdFormat adFormat : adFormats) {
            arrayList.add(a(adFormat));
        }
        return (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[0]);
    }

    public final IronSource.AD_UNIT a(LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        return com.unity3d.mediation.a.a(adFormat);
    }

    public final boolean a(AdapterBaseInterface networkAdapter, IronSource.AD_UNIT adFormat, String providerName) {
        Intrinsics.checkNotNullParameter(networkAdapter, "networkAdapter");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return C3051df.a(networkAdapter, adFormat, providerName);
    }

    public final void a(long j, C3337ue.a responseOrigin, long j2) {
        Intrinsics.checkNotNullParameter(responseOrigin, "responseOrigin");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j);
        String b2 = responseOrigin.b();
        Intrinsics.checkNotNullExpressionValue(b2, "responseOrigin.value");
        jSONObject.put(IronSourceConstants.EVENTS_EXT1, a(b2, j2));
        C3051df.a(A5.SDK_INIT_SUCCESS, jSONObject);
    }

    private final String a(String str, long j) {
        return "responseOrigin=" + str + ";delayTimeAfterInitProcess=" + j;
    }

    public final void a(Ud error, long j) {
        Intrinsics.checkNotNullParameter(error, "error");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
        jSONObject.put("reason", error.d());
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j);
        C3051df.a(A5.SDK_INIT_FAILED, jSONObject);
    }

    public final void a(String placementName, LevelPlay.AdFormat adFormat, int i, String str) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
        jSONObject.putOpt("reason", str);
        jSONObject.put("placement", placementName);
        jSONObject.put(Ma.f, adFormat.getValue());
        jSONObject.put("adf", C3051df.b(com.unity3d.mediation.a.a(adFormat)));
        jSONObject.put("isMultipleAdUnits", 1);
        C3051df.a(A5.TROUBLESHOOTING_PLACEMENT_CAPPING_PARSE_ERROR, jSONObject);
    }

    public final void a(String adUnitId, int i, String str) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
        jSONObject.putOpt("reason", str);
        jSONObject.put("mediationAdUnitId", adUnitId);
        jSONObject.put("isMultipleAdUnits", 1);
        C3051df.a(A5.TROUBLESHOOTING_AD_UNIT_CAPPING_PARSE_ERROR, jSONObject);
    }
}
