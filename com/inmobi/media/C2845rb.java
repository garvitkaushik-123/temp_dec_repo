package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.rb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C2845rb extends FunctionReferenceImpl implements Function1 {
    public C2845rb(C2894ub c2894ub) {
        super(1, c2894ub, C2894ub.class, "instantiateBillingClientV6", "instantiateBillingClientV6(Landroid/content/Context;)Lcom/android/billingclient/api/BillingClient;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context p0 = (Context) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((C2894ub) this.receiver).getClass();
        return C2894ub.a(p0);
    }
}
