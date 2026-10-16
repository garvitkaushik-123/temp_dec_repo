package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.sb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C2861sb extends FunctionReferenceImpl implements Function1 {
    public C2861sb(C2894ub c2894ub) {
        super(1, c2894ub, C2894ub.class, "instantiateBillingClientV7", "instantiateBillingClientV7(Landroid/content/Context;)Lcom/android/billingclient/api/BillingClient;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context p0 = (Context) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((C2894ub) this.receiver).getClass();
        return C2894ub.b(p0);
    }
}
