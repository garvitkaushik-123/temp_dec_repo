package com.ironsource;

import android.app.Activity;
import com.ironsource.C3040d4;
import com.ironsource.C3239p0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.i6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3127i6 extends AbstractC3407z implements InterstitialAdListener, RewardedVideoAdListener, AdapterAdRewardListener {
    private WeakReference<InterfaceC3143j6> x;
    private C3126i5 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3127i6(V0 adTools, A instanceData, G adInstancePayload, InterfaceC3143j6 listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.x = new WeakReference<>(listener);
    }

    private final List<String> I() {
        JSONObject optJSONObject = new P6().a(new String[]{N6.u}).optJSONObject(N6.u);
        if (optJSONObject == null) {
            return CollectionsKt.emptyList();
        }
        Object opt = optJSONObject.opt(N6.C);
        List list = opt instanceof List ? (List) opt : null;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        return arrayList;
    }

    private final Map<String, Object> J() {
        Map createMapBuilder = MapsKt.createMapBuilder();
        for (String str : I()) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{C3040d4.i.b}, false, 2, 2, (Object) null);
            if (split$default.size() < 2) {
                IronLog.INTERNAL.warning(a("\"" + str + "\" is not a valid key=value format"));
            } else {
                createMapBuilder.put("custom_" + ((String) split$default.get(0)), (String) split$default.get(1));
            }
        }
        return MapsKt.build(createMapBuilder);
    }

    private final void K() {
        this.y = new C3126i5();
        IronLog.INTERNAL.verbose(AbstractC3407z.a(this, (String) null, 1, (Object) null));
        f().e().a().a(k(), "");
        InterfaceC3143j6 interfaceC3143j6 = this.x.get();
        if (interfaceC3143j6 != null) {
            interfaceC3143j6.b(this);
        }
        c();
    }

    private final void L() {
        IronLog.INTERNAL.verbose(AbstractC3407z.a(this, (String) null, 1, (Object) null));
        f().e().a().d(k());
    }

    private final void M() {
        Map<String, Object> J = J();
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = f().a(currentTimeMillis, p());
        long a3 = C3126i5.a(this.y);
        LevelPlayReward a4 = C3334ub.s.d().B().a(k(), n().i().b().c());
        if (a4 == null) {
            a4 = L4.f2937a.a();
        }
        LevelPlayReward levelPlayReward = a4;
        f().e().a().a(k(), levelPlayReward.getName(), levelPlayReward.getAmount(), currentTimeMillis, a2, a3, J, f().j());
        InterfaceC3143j6 interfaceC3143j6 = this.x.get();
        if (interfaceC3143j6 != null) {
            interfaceC3143j6.a(this, levelPlayReward);
        }
    }

    private final void N() {
        IronLog.INTERNAL.verbose(AbstractC3407z.a(this, (String) null, 1, (Object) null));
        f().e().a().l(k());
        InterfaceC3143j6 interfaceC3143j6 = this.x.get();
        if (interfaceC3143j6 != null) {
            interfaceC3143j6.a(this);
        }
    }

    private final void O() {
        IronLog.INTERNAL.verbose(AbstractC3407z.a(this, (String) null, 1, (Object) null));
        f().e().a().i(k());
    }

    private final void P() {
        IronLog.INTERNAL.verbose(AbstractC3407z.a(this, (String) null, 1, (Object) null));
        f().e().a().k(k());
    }

    private final void b(int i, String str) {
        IronLog.INTERNAL.verbose(a("error = " + i + ", " + str));
        f().e().a().a(k(), i, str, "");
        a(C3239p0.a.FailedToShow);
        IronSourceError ironSourceError = new IronSourceError(i, str);
        InterfaceC3143j6 interfaceC3143j6 = this.x.get();
        if (interfaceC3143j6 != null) {
            interfaceC3143j6.a(this, ironSourceError);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C3127i6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C3127i6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P();
    }

    @Override // com.ironsource.AbstractC3407z
    protected void A() {
        if (!(g() instanceof AdapterAdFullScreenInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
            return;
        }
        Object g = g();
        Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterAdFullScreenInterface) g).loadAd(n().g(), ContextProvider.getInstance().getCurrentActiveActivity(), this);
    }

    @Override // com.ironsource.AbstractC3407z
    public void a(I adInstancePresenter) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.ironsource.AbstractC3407z
    public void c() {
        if (C3334ub.s.d().g().i()) {
            if (!(g() instanceof AdapterAdFullScreenInterface)) {
                IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
                return;
            }
            Object g = g();
            Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<*>");
            ((AdapterAdFullScreenInterface) g).disposeAd(n().g());
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.a(C3127i6.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.b(C3127i6.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.c(C3127i6.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(final int i, final String str) {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.a(C3127i6.this, i, str);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        onAdShowSuccess(new LinkedHashMap());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.d(C3127i6.this);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.e(C3127i6.this);
            }
        });
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + k()));
        try {
            f().e().a().a(activity, k());
            if (!(g() instanceof AdapterAdFullScreenInterface)) {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                f().e().h().g("showAd - adapter not instance of AdapterAdFullScreenInterface");
            } else {
                Object g = g();
                Intrinsics.checkNotNull(g, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
                ((AdapterAdFullScreenInterface) g).showAd(i(), this);
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "showAd - exception = " + th.getMessage();
            IronLog.INTERNAL.error(a(str));
            f().e().h().g(str);
            b(C3408z0.h(n().h()), str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess(final Map<String, Object> extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        a(new Runnable() { // from class: com.ironsource.i6$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3127i6.a(C3127i6.this, extraData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3127i6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3127i6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3127i6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3127i6 this$0, int i, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3127i6 this$0, Map extraData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extraData, "$extraData");
        this$0.l().putAll(extraData);
        this$0.N();
    }
}
