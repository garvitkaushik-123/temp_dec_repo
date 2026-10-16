package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public interface PurchasesResponseListener {
    void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list);
}
