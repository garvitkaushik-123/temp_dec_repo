package io.adn.unityplugin.internal;

import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: UnityPluginManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
/* synthetic */ class UnityPluginManager$loadInterstitial$1 extends FunctionReferenceImpl implements Function0<Unit> {
    UnityPluginManager$loadInterstitial$1(Object obj) {
        super(0, obj, UnityPluginManager.class, C3040d4.g.T, "destroyInterstitial()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((UnityPluginManager) this.receiver).destroyInterstitial();
    }
}
