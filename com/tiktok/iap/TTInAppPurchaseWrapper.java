package com.tiktok.iap;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.appevents.TTAppEventLogger;
import com.tiktok.appevents.TTPurchaseInfo;
import com.tiktok.appevents.contents.TTContentsEventConstants;
import com.tiktok.util.TTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTInAppPurchaseWrapper {
    static final String TAG = "com.tiktok.iap.TTInAppPurchaseWrapper";
    private static BillingClient mBillingClient;
    private static Context mContext;
    private static final TTLogger ttLogger = new TTLogger(TTInAppPurchaseWrapper.class.getName(), TikTokBusinessSdk.getLogLevel());

    public static void registerIapTrack() {
        try {
            if (TikTokBusinessSdk.getApplicationContext() == null) {
                return;
            }
            mContext = TikTokBusinessSdk.getApplicationContext();
            mBillingClient = BillingClient.newBuilder(mContext).setListener(new PurchasesUpdatedListener() { // from class: com.tiktok.iap.TTInAppPurchaseWrapper$$ExternalSyntheticLambda1
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    TTInAppPurchaseWrapper.lambda$registerIapTrack$0(billingResult, list);
                }
            }).enablePendingPurchases().build();
            startBillingClient();
        } catch (Throwable th) {
            ttLogger.error(th, "register Iap track error", new Object[0]);
        }
    }

    static /* synthetic */ void lambda$registerIapTrack$0(BillingResult billingResult, List purchases) {
        ArrayList<String> skus;
        if (TTAppEventLogger.autoTrackPaymentEnable && billingResult != null && billingResult.getResponseCode() == 0 && purchases != null) {
            Iterator it = purchases.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                if (purchase != null && (skus = purchase.getSkus()) != null && skus.size() != 0) {
                    querySkuAndTrack(skus, purchase, true);
                }
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            ttLogger.info("user canceled", new Object[0]);
        } else {
            ttLogger.info("otherErr : %s", billingResult.getDebugMessage());
        }
    }

    public static void startBillingClient() {
        try {
            BillingClient billingClient = mBillingClient;
            if (billingClient != null && !billingClient.isReady()) {
                mBillingClient.startConnection(new BillingClientStateListener() { // from class: com.tiktok.iap.TTInAppPurchaseWrapper.1
                    @Override // com.android.billingclient.api.BillingClientStateListener
                    public void onBillingSetupFinished(BillingResult billingResult) {
                        if (billingResult.getResponseCode() == 0) {
                            TTInAppPurchaseWrapper.ttLogger.info("billing setup finished", new Object[0]);
                        } else {
                            TTInAppPurchaseWrapper.ttLogger.info("billing setup error %s", billingResult.getDebugMessage());
                        }
                    }

                    @Override // com.android.billingclient.api.BillingClientStateListener
                    public void onBillingServiceDisconnected() {
                        TTInAppPurchaseWrapper.ttLogger.info("billing service disconnected", new Object[0]);
                    }
                });
            }
        } catch (Throwable th) {
            ttLogger.error(th, "start billing client connection error", new Object[0]);
        }
    }

    private static void querySkuAndTrack(final List<String> skus, final Purchase purchase, final boolean isInAppPurchase) {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : skus) {
                if (str != null && !str.isEmpty()) {
                    arrayList.add(str);
                }
            }
            SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
            if (isInAppPurchase) {
                newBuilder.setSkusList(arrayList).setType("inapp");
            } else {
                newBuilder.setSkusList(arrayList).setType("subs");
            }
            mBillingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() { // from class: com.tiktok.iap.TTInAppPurchaseWrapper$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.SkuDetailsResponseListener
                public final void onSkuDetailsResponse(BillingResult billingResult, List list) {
                    TTInAppPurchaseWrapper.lambda$querySkuAndTrack$1(Purchase.this, isInAppPurchase, skus, billingResult, list);
                }
            });
        } catch (Throwable th) {
            ttLogger.error(th, "query Sku And Track error", new Object[0]);
        }
    }

    static /* synthetic */ void lambda$querySkuAndTrack$1(final Purchase purchase, final boolean isInAppPurchase, final List skus, BillingResult billingResult, List skuDetailsList) {
        if (billingResult != null && billingResult.getResponseCode() == 0 && skuDetailsList != null) {
            if (skuDetailsList.size() <= 0) {
                if (isInAppPurchase) {
                    querySkuAndTrack(skus, purchase, false);
                    return;
                } else {
                    sendNoSkuIapTrack(skus, purchase);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = skuDetailsList.iterator();
                while (it.hasNext()) {
                    TTPurchaseInfo tTPurchaseInfo = new TTPurchaseInfo(new JSONObject(purchase.getOriginalJson()), new JSONObject(((SkuDetails) it.next()).getOriginalJson()));
                    tTPurchaseInfo.setAutoTrack(true);
                    arrayList.add(tTPurchaseInfo);
                }
                TikTokBusinessSdk.trackGooglePlayPurchase(arrayList);
                return;
            } catch (Throwable th) {
                ttLogger.error(th, "query Sku And Track google play purchase error", new Object[0]);
                return;
            }
        }
        sendNoSkuIapTrack(skus, purchase);
    }

    private static void sendNoSkuIapTrack(List<String> skus, Purchase purchase) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : skus) {
                if (str != null && !str.isEmpty()) {
                    jSONArray.put(new JSONObject().put(FirebaseAnalytics.Param.QUANTITY, purchase.getQuantity()).put("content_id", str));
                }
            }
            TikTokBusinessSdk.trackEvent(TTContentsEventConstants.ContentsEventName.EVENT_NAME_PURCHASE, new JSONObject().put(TTContentsEventConstants.Params.EVENT_PROPERTY_CONTENTS, jSONArray));
        } catch (Throwable th) {
            ttLogger.error(th, "Track Purchase error", new Object[0]);
        }
    }
}
