package com.inmobi.media;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.ironsource.C3251pc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.ub, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2894ub {

    /* renamed from: a, reason: collision with root package name */
    public C2582bb f2722a;
    public BillingClient b;
    public final AtomicInteger c = new AtomicInteger(0);
    public final C2633eb d = new C2633eb();
    public final int e = 2;

    public static final void a(BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
    }

    public static final void b(BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
    }

    public static BillingClient b(Context context) {
        try {
            return BillingClient.newBuilder(context).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).setListener(new PurchasesUpdatedListener() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda2
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    C2894ub.b(billingResult, list);
                }
            }).build();
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        } catch (NoClassDefFoundError e2) {
            S5 s52 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return null;
        }
    }

    public final void a(Context context, C2582bb onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        try {
            this.f2722a = onComplete;
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            String string = bundle != null ? bundle.getString("com.google.android.play.billingclient.version") : null;
            if (string == null) {
                a(new C2668gb((short) 2236), (C2633eb) null);
                return;
            }
            BillingClient billingClient = (BillingClient) (StringsKt.startsWith$default(string, "6", false, 2, (Object) null) ? new C2845rb(this) : StringsKt.startsWith$default(string, C3251pc.e, false, 2, (Object) null) ? new C2861sb(this) : new C2878tb(this)).invoke(context);
            if (billingClient == null) {
                a(new C2668gb((short) 2233), (C2633eb) null);
                return;
            }
            this.b = billingClient;
            C2830qb onComplete2 = new C2830qb(this);
            Intrinsics.checkNotNullParameter(onComplete2, "onComplete");
            BillingClient billingClient2 = this.b;
            if (billingClient2 != null) {
                billingClient2.startConnection(new C2797ob(this, onComplete2));
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            a(new C2668gb((short) 2237), (C2633eb) null);
        }
    }

    public static final void b(final C2894ub this$0, final Function1 onComplete, BillingResult billingResult, List purchasesResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(purchasesResult, "purchasesResult");
        C2633eb c2633eb = this$0.d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : purchasesResult) {
            Purchase purchase = (Purchase) obj;
            if (purchase.getPurchaseState() == 1 && purchase.isAcknowledged()) {
                arrayList.add(obj);
            }
        }
        c2633eb.b = arrayList.size();
        Uc.a(new Runnable() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C2894ub.b(Function1.this, this$0);
            }
        });
    }

    public static final void b(Function1 onComplete, C2894ub this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onComplete.invoke(this$0.d);
    }

    public final void a(AbstractC2717jb abstractC2717jb, C2633eb c2633eb) {
        AbstractC2733kb.a(abstractC2717jb);
        C2582bb c2582bb = this.f2722a;
        if (c2582bb != null) {
            c2582bb.invoke(c2633eb);
        }
    }

    public static BillingClient a(Context context) {
        try {
            return BillingClient.newBuilder(context).enablePendingPurchases().setListener(new PurchasesUpdatedListener() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda5
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    C2894ub.a(billingResult, list);
                }
            }).build();
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        } catch (NoClassDefFoundError e2) {
            S5 s52 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return null;
        }
    }

    public final void a(final C2814pb onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        QueryPurchasesParams.Builder newBuilder = QueryPurchasesParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        newBuilder.setProductType("inapp");
        QueryPurchasesParams.Builder newBuilder2 = QueryPurchasesParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder(...)");
        newBuilder2.setProductType("subs");
        BillingClient billingClient = this.b;
        if (billingClient != null) {
            billingClient.queryPurchasesAsync(newBuilder.build(), new PurchasesResponseListener() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    C2894ub.a(C2894ub.this, onComplete, billingResult, list);
                }
            });
        }
        BillingClient billingClient2 = this.b;
        if (billingClient2 != null) {
            billingClient2.queryPurchasesAsync(newBuilder2.build(), new PurchasesResponseListener() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda1
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    C2894ub.b(C2894ub.this, onComplete, billingResult, list);
                }
            });
        }
    }

    public static final void a(final C2894ub this$0, final Function1 onComplete, BillingResult billingResult, List purchasesResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(purchasesResult, "purchasesResult");
        C2633eb c2633eb = this$0.d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : purchasesResult) {
            Purchase purchase = (Purchase) obj;
            if (purchase.getPurchaseState() == 1 && purchase.isAcknowledged()) {
                arrayList.add(obj);
            }
        }
        c2633eb.f2563a = arrayList.size();
        Uc.a(new Runnable() { // from class: com.inmobi.media.ub$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C2894ub.a(Function1.this, this$0);
            }
        });
    }

    public static final void a(Function1 onComplete, C2894ub this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onComplete.invoke(this$0.d);
    }
}
