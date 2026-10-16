package io.adn.unityplugin.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: UnityPluginManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
/* synthetic */ class UnityPluginManager$loadRewardedAd$1 extends FunctionReferenceImpl implements Function0<Unit> {
    UnityPluginManager$loadRewardedAd$1(Object obj) {
        super(0, obj, UnityPluginManager.class, "destroyRewardedAd", "destroyRewardedAd()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((UnityPluginManager) this.receiver).destroyRewardedAd();
    }
}
