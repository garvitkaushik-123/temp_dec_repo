package com.inmobi.media;

import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ob, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2797ob implements BillingClientStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2894ub f2662a;
    public final /* synthetic */ C2830qb b;

    public C2797ob(C2894ub c2894ub, C2830qb c2830qb) {
        this.f2662a = c2894ub;
        this.b = c2830qb;
    }

    public static final void a(Function1 onComplete, AbstractC2781nb result) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(result, "$result");
        onComplete.invoke(result);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        this.f2662a.getClass();
        final C2830qb c2830qb = this.b;
        final C2894ub c2894ub = this.f2662a;
        Uc.a(new Runnable() { // from class: com.inmobi.media.ob$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2797ob.a(Function1.this, c2894ub);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        final AbstractC2781nb c2749lb;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.f2662a.getClass();
        Objects.toString(billingResult);
        if (billingResult.getResponseCode() == 0) {
            c2749lb = C2765mb.f2641a;
        } else {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "getDebugMessage(...)");
            c2749lb = new C2749lb(debugMessage, responseCode);
        }
        final C2830qb c2830qb = this.b;
        Uc.a(new Runnable() { // from class: com.inmobi.media.ob$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2797ob.a(Function1.this, c2749lb);
            }
        });
    }

    public static final void a(Function1 onComplete, C2894ub this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        onComplete.invoke(new C2749lb("Billing Service Disconnected", -1));
    }
}
