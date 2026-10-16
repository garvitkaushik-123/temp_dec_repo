package com.ironsource;

import android.content.Context;
import com.ironsource.Ad;
import com.ironsource.C3027cb;
import com.ironsource.C3332u9;
import com.ironsource.C3334ub;
import com.ironsource.D0;
import com.ironsource.G8;
import com.ironsource.J7;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import com.unity3d.mediation.segment.LevelPlaySegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.cb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3027cb {

    /* renamed from: a, reason: collision with root package name */
    public static final C3027cb f3228a = new C3027cb();
    private static final C3047db b = new C3047db();

    /* renamed from: com.ironsource.cb$a */
    public static final class a implements Yd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f3229a;
        final /* synthetic */ Context b;
        final /* synthetic */ C3126i5 c;
        final /* synthetic */ LevelPlayInitListener d;

        a(LevelPlayInitRequest levelPlayInitRequest, Context context, C3126i5 c3126i5, LevelPlayInitListener levelPlayInitListener) {
            this.f3229a = levelPlayInitRequest;
            this.b = context;
            this.c = c3126i5;
            this.d = levelPlayInitListener;
        }

        @Override // com.ironsource.Yd
        public void a(final Sd sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            C3047db c3047db = C3027cb.b;
            final LevelPlayInitRequest levelPlayInitRequest = this.f3229a;
            final Context context = this.b;
            final C3126i5 c3126i5 = this.c;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            c3047db.a(new Runnable() { // from class: com.ironsource.cb$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3027cb.a.a(LevelPlayInitRequest.this, sdkConfig, context, c3126i5, levelPlayInitListener);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, Sd sdkConfig, Context context, C3126i5 initDuration, LevelPlayInitListener levelPlayInitListener) {
            Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            C3027cb.f3228a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }

        @Override // com.ironsource.Yd
        public void a(final Ud error) {
            Intrinsics.checkNotNullParameter(error, "error");
            C3047db c3047db = C3027cb.b;
            final LevelPlayInitListener levelPlayInitListener = this.d;
            final C3126i5 c3126i5 = this.c;
            c3047db.a(new Runnable() { // from class: com.ironsource.cb$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3027cb.a.a(LevelPlayInitListener.this, c3126i5, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, C3126i5 initDuration, Ud error) {
            Intrinsics.checkNotNullParameter(initDuration, "$initDuration");
            Intrinsics.checkNotNullParameter(error, "$error");
            C3027cb.f3228a.a(levelPlayInitListener, initDuration, error);
        }
    }

    /* renamed from: com.ironsource.cb$b */
    static final class b extends Lambda implements Function0<Unit> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ La f3230a;
        final /* synthetic */ C3126i5 b;
        final /* synthetic */ long c;
        final /* synthetic */ LevelPlayInitListener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(La la, C3126i5 c3126i5, long j, LevelPlayInitListener levelPlayInitListener) {
            super(0);
            this.f3230a = la;
            this.b = c3126i5;
            this.c = j;
            this.d = levelPlayInitListener;
        }

        public final void a() {
            C3027cb.f3228a.a(this.f3230a, this.b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    private C3027cb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener levelPlayInitListener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        f3228a.c(context, initRequest, levelPlayInitListener);
    }

    private final void c(Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener) {
        IronLog.API.info("LevelPlay.init() appkey: " + levelPlayInitRequest.getAppKey() + ", userId: " + levelPlayInitRequest.getUserId() + ", legacyAdFormats: " + levelPlayInitRequest.getLegacyAdFormats() + ", context: " + context.getClass().getSimpleName());
        C3126i5 c3126i5 = new C3126i5();
        C3047db c3047db = b;
        LevelPlay.AdFormat[] adFormatArr = (LevelPlay.AdFormat[]) levelPlayInitRequest.getLegacyAdFormats().toArray(new LevelPlay.AdFormat[0]);
        C3118he.f3342a.a(context, new C2996ae(levelPlayInitRequest.getAppKey(), levelPlayInitRequest.getUserId(), ArraysKt.toMutableList(c3047db.a((LevelPlay.AdFormat[]) Arrays.copyOf(adFormatArr, adFormatArr.length)))), new a(levelPlayInitRequest, context, c3126i5, levelPlayInitListener));
    }

    public final void b(LevelPlaySegment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        com.ironsource.mediationsdk.p.j().a(a(segment));
    }

    public final void b(LevelPlayImpressionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.ironsource.mediationsdk.p.j().a(new Pa(listener));
    }

    public static /* synthetic */ void a(C3027cb c3027cb, Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener, int i, Object obj) {
        if ((i & 4) != 0) {
            levelPlayInitListener = null;
        }
        c3027cb.a(context, levelPlayInitRequest, levelPlayInitListener);
    }

    public final void a(final Context context, final LevelPlayInitRequest initRequest, final LevelPlayInitListener levelPlayInitListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        b.d(new Runnable() { // from class: com.ironsource.cb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3027cb.b(context, initRequest, levelPlayInitListener);
            }
        });
    }

    public final void a(LevelPlayImpressionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.ironsource.mediationsdk.p.j().b(new Pa(listener));
    }

    private final IronSourceSegment a(LevelPlaySegment levelPlaySegment) {
        IronSourceSegment ironSourceSegment = new IronSourceSegment();
        ironSourceSegment.setLevel(levelPlaySegment.getLevel());
        ironSourceSegment.setIAPTotal(levelPlaySegment.getIapTotal());
        ironSourceSegment.setIsPaying(levelPlaySegment.isPaying());
        ironSourceSegment.setUserCreationDate(levelPlaySegment.getUserCreationDate());
        ironSourceSegment.setSegmentName(levelPlaySegment.getSegmentName());
        Iterator<T> it = levelPlaySegment.getCustoms$mediationsdk_release().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ironSourceSegment.setCustom((String) pair.getFirst(), (String) pair.getSecond());
        }
        return ironSourceSegment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LevelPlayInitRequest levelPlayInitRequest, Sd sd, Context context, C3126i5 c3126i5, LevelPlayInitListener levelPlayInitListener) {
        C3334ub.b bVar = C3334ub.s;
        G8.a D = bVar.a().D();
        La la = new La(sd);
        if (la.k()) {
            b.a(context);
        }
        J7.a a2 = bVar.a().a();
        C3047db c3047db = b;
        la.b(c3047db).a(a2);
        la.a(c3047db).a(bVar.a().l());
        la.c(c3047db).a(bVar.a().v());
        C3027cb c3027cb = f3228a;
        c3027cb.a(levelPlayInitRequest, la);
        long e = bVar.d().g().e();
        c3027cb.a(e, new b(la, c3126i5, e, levelPlayInitListener));
        D.a(la);
        if (sd.a().e()) {
            new C3201md(null, null, null, IronSourceThreadManager.INSTANCE.getThreadPoolExecutor(), 7, null).c(context);
        }
    }

    private final void a(long j, Function0<Unit> function0) {
        if (!C3334ub.s.d().e().c() && j > 0) {
            b.a(function0, j);
        } else {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final La la, C3126i5 c3126i5, long j, final LevelPlayInitListener levelPlayInitListener) {
        C3334ub.s.a().D().d();
        long a2 = C3126i5.a(c3126i5);
        C3047db c3047db = b;
        c3047db.a(a2, la.f(), j);
        c3047db.e(new Runnable() { // from class: com.ironsource.cb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3027cb.a(LevelPlayInitListener.this, la);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, La levelPlayConfig) {
        Intrinsics.checkNotNullParameter(levelPlayConfig, "$levelPlayConfig");
        IronLog.CALLBACK.info("LevelPlayInitListener.onInitSuccess()");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitSuccess(new LevelPlayConfiguration(levelPlayConfig.j()));
        }
    }

    private final void a(LevelPlayInitRequest levelPlayInitRequest, La la) {
        LevelPlay.AdFormat adFormat = LevelPlay.AdFormat.REWARDED;
        if (a(levelPlayInitRequest, adFormat) && la.d().c().f() != null) {
            Ad.a aVar = Ad.z;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            Ad a2 = aVar.a(new C3070f0(ad_unit, C3347v7.f3910a.a(), "", null, null, null, 56, null), la, true);
            List<C3116hc> c = la.c(adFormat);
            D0.b bVar = D0.b.MEDIATION;
            new C3083fd(new V0(new C3205n0(ad_unit, bVar), a2, bVar), adFormat, c, a2).a();
        }
        LevelPlay.AdFormat adFormat2 = LevelPlay.AdFormat.INTERSTITIAL;
        if (a(levelPlayInitRequest, adFormat2) && la.d().c().d() != null) {
            C3332u9.a aVar2 = C3332u9.z;
            IronSource.AD_UNIT ad_unit2 = IronSource.AD_UNIT.INTERSTITIAL;
            C3332u9 a3 = aVar2.a(new C3070f0(ad_unit2, C3347v7.f3910a.a(), "", null, null, null, 56, null), la, true);
            List<C3116hc> c2 = la.c(adFormat2);
            D0.b bVar2 = D0.b.MEDIATION;
            new C3083fd(new V0(new C3205n0(ad_unit2, bVar2), a3, bVar2), adFormat2, c2, a3).a();
        }
        LevelPlay.AdFormat adFormat3 = LevelPlay.AdFormat.BANNER;
        if (!a(levelPlayInitRequest, adFormat3) || la.d().c().c() == null) {
            return;
        }
        N2 a4 = N2.z.a(new K2(), la, true);
        List<C3116hc> c3 = la.c(adFormat3);
        IronSource.AD_UNIT ad_unit3 = IronSource.AD_UNIT.BANNER;
        D0.b bVar3 = D0.b.MEDIATION;
        new C3083fd(new V0(new C3205n0(ad_unit3, bVar3), a4, bVar3), adFormat3, c3, a4).a();
    }

    private final boolean a(LevelPlayInitRequest levelPlayInitRequest, LevelPlay.AdFormat adFormat) {
        return !levelPlayInitRequest.getLegacyAdFormats().contains(adFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final LevelPlayInitListener levelPlayInitListener, C3126i5 c3126i5, final Ud ud) {
        long a2 = C3126i5.a(c3126i5);
        C3047db c3047db = b;
        c3047db.a(ud, a2);
        c3047db.e(new Runnable() { // from class: com.ironsource.cb$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3027cb.a(Ud.this, levelPlayInitListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ud error, LevelPlayInitListener levelPlayInitListener) {
        Intrinsics.checkNotNullParameter(error, "$error");
        IronLog.CALLBACK.info("LevelPlayInitListener.LevelPlayInitError() error: " + error);
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitFailed(new LevelPlayInitError(error));
        }
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add(value);
        com.ironsource.mediationsdk.p.j().a(key, arrayList);
    }
}
