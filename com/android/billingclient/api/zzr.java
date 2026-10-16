package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzr extends BroadcastReceiver {
    final /* synthetic */ zzs zza;
    private boolean zzb;
    private final boolean zzc;

    zzr(zzs zzsVar, boolean z) {
        Objects.requireNonNull(zzsVar);
        this.zza = zzsVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i, zzil zzilVar, long j, boolean z) {
        zzch zzchVar;
        zzch zzchVar2;
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                zzchVar2 = this.zza.zze;
                zzchVar2.zzd(zzhx.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzeu.zza()), j, z);
            } else {
                zzchVar = this.zza.zze;
                zzchVar.zzd(zzcg.zzb(zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, billingResult, null, zzilVar), j, z);
            }
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        BillingResult zzh;
        PurchasesUpdatedListener purchasesUpdatedListener;
        zzch zzchVar;
        zzb zzbVar;
        zzch zzchVar2;
        PurchasesUpdatedListener purchasesUpdatedListener2;
        UserChoiceBillingListener userChoiceBillingListener;
        zzb zzbVar2;
        zzch zzchVar3;
        UserChoiceBillingListener userChoiceBillingListener2;
        zzch zzchVar4;
        PurchasesUpdatedListener purchasesUpdatedListener3;
        UserChoiceBillingListener userChoiceBillingListener3;
        zzch zzchVar5;
        PurchasesUpdatedListener purchasesUpdatedListener4;
        PurchasesUpdatedListener purchasesUpdatedListener5;
        int intValue;
        zzch zzchVar6;
        PurchasesUpdatedListener purchasesUpdatedListener6;
        PurchasesUpdatedListener purchasesUpdatedListener7;
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -1484087650) {
            if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -337612916) {
            if (hashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                c = 1;
            }
            c = 65535;
        }
        zzil zzilVar = c != 0 ? c != 1 ? c != 2 ? zzil.BROADCAST_ACTION_UNSPECIFIED : zzil.ALTERNATIVE_BILLING_ACTION : zzil.LOCAL_PURCHASES_UPDATED_ACTION : zzil.PURCHASES_UPDATED_ACTION;
        zzil zzilVar2 = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        int i = (zzilVar.equals(zzilVar2) || zzilVar.equals(zzil.ALTERNATIVE_BILLING_ACTION)) ? 2 : zzilVar.equals(zzil.PURCHASES_UPDATED_ACTION) ? 32 : 1;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            zzs zzsVar = this.zza;
            zzchVar6 = zzsVar.zze;
            zzie zzieVar = zzie.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            BillingResult billingResult = zzcj.zzh;
            zzchVar6.zza(zzcg.zzb(zzieVar, i, billingResult, null, zzilVar));
            purchasesUpdatedListener6 = zzsVar.zzb;
            if (purchasesUpdatedListener6 != null) {
                purchasesUpdatedListener7 = zzsVar.zzb;
                purchasesUpdatedListener7.onPurchasesUpdated(billingResult, null);
            }
        } else {
            if (i == 2) {
                int i2 = com.google.android.gms.internal.play_billing.zzc.zza;
                if (intent == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingHelper", "Got null intent!");
                    BillingResult.Builder newBuilder = BillingResult.newBuilder();
                    newBuilder.setResponseCode(6);
                    newBuilder.setOnPurchasesUpdatedSubResponseCode(0);
                    newBuilder.setDebugMessage("An internal error occurred.");
                    zzh = newBuilder.build();
                } else {
                    BillingResult.Builder newBuilder2 = BillingResult.newBuilder();
                    newBuilder2.setResponseCode(com.google.android.gms.internal.play_billing.zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
                    Bundle extras2 = intent.getExtras();
                    if (extras2 == null) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
                    } else {
                        Object obj = extras2.get("SUB_RESPONSE_CODE");
                        if (obj == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingBroadcastManager", "getLaunchBillingFlowSubResponseCodeFromBundle() got null response code, assuming OK");
                        } else if (obj instanceof Integer) {
                            intValue = ((Integer) obj).intValue();
                            newBuilder2.setOnPurchasesUpdatedSubResponseCode(intValue);
                            newBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                            zzh = newBuilder2.build();
                        } else {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(String.valueOf(obj.getClass().getName())));
                        }
                    }
                    intValue = 0;
                    newBuilder2.setOnPurchasesUpdatedSubResponseCode(intValue);
                    newBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                    zzh = newBuilder2.build();
                }
            } else {
                zzh = com.google.android.gms.internal.play_billing.zzc.zzh(intent, "BillingBroadcastManager");
            }
            BillingResult billingResult2 = zzh;
            long j = extras.getLong("billingClientTransactionId", 0L);
            boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
            if (zzilVar.equals(zzil.PURCHASES_UPDATED_ACTION) || zzilVar.equals(zzilVar2)) {
                List<Purchase> zzl = com.google.android.gms.internal.play_billing.zzc.zzl(extras);
                if (billingResult2.getResponseCode() == 0) {
                    zzchVar = this.zza.zze;
                    zzchVar.zzh(zzcg.zzc(i, zzilVar), j, z);
                } else {
                    zzd(extras, billingResult2, i, zzilVar, j, z);
                }
                purchasesUpdatedListener = this.zza.zzb;
                purchasesUpdatedListener.onPurchasesUpdated(billingResult2, zzl);
                return;
            }
            if (zzilVar.equals(zzil.ALTERNATIVE_BILLING_ACTION)) {
                if (billingResult2.getResponseCode() != 0) {
                    zzd(extras, billingResult2, i, zzilVar, j, z);
                    purchasesUpdatedListener5 = this.zza.zzb;
                    purchasesUpdatedListener5.onPurchasesUpdated(billingResult2, com.google.android.gms.internal.play_billing.zzbt.zzk());
                    return;
                }
                zzs zzsVar2 = this.zza;
                zzbVar = zzsVar2.zzc;
                if (zzbVar == null) {
                    userChoiceBillingListener3 = zzsVar2.zzd;
                    if (userChoiceBillingListener3 == null) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                        zzs zzsVar3 = this.zza;
                        zzchVar5 = zzsVar3.zze;
                        zzie zzieVar2 = zzie.MISSING_USER_CHOICE_BILLING_LISTENER;
                        BillingResult billingResult3 = zzcj.zzh;
                        zzchVar5.zzd(zzcg.zzb(zzieVar2, i, billingResult3, null, zzilVar), j, z);
                        purchasesUpdatedListener4 = zzsVar3.zzb;
                        purchasesUpdatedListener4.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzbt.zzk());
                        return;
                    }
                }
                String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    zzchVar4 = zzsVar2.zze;
                    zzie zzieVar3 = zzie.MISSING_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult4 = zzcj.zzh;
                    zzchVar4.zzd(zzcg.zzb(zzieVar3, i, billingResult4, null, zzilVar), j, z);
                    purchasesUpdatedListener3 = zzsVar2.zzb;
                    purchasesUpdatedListener3.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzbt.zzk());
                    return;
                }
                try {
                    userChoiceBillingListener = zzsVar2.zzd;
                    if (userChoiceBillingListener != null) {
                        UserChoiceDetails userChoiceDetails = new UserChoiceDetails(string);
                        userChoiceBillingListener2 = zzsVar2.zzd;
                        userChoiceBillingListener2.userSelectedAlternativeBilling(userChoiceDetails);
                    } else {
                        JSONArray optJSONArray = new JSONObject(string).optJSONArray("products");
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                                if (optJSONObject != null) {
                                    arrayList.add(new zzc(optJSONObject, null));
                                }
                            }
                        }
                        zzbVar2 = zzsVar2.zzc;
                        zzbVar2.zza();
                    }
                    zzchVar3 = this.zza.zze;
                    zzchVar3.zzh(zzcg.zzc(i, zzilVar), j, z);
                } catch (JSONException unused) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                    zzs zzsVar4 = this.zza;
                    zzchVar2 = zzsVar4.zze;
                    zzie zzieVar4 = zzie.INVALID_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult5 = zzcj.zzh;
                    zzchVar2.zzd(zzcg.zzb(zzieVar4, i, billingResult5, null, zzilVar), j, z);
                    purchasesUpdatedListener2 = zzsVar4.zzb;
                    purchasesUpdatedListener2.onPurchasesUpdated(billingResult5, com.google.android.gms.internal.play_billing.zzbt.zzk());
                }
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzr zzrVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzrVar = this;
                    context.registerReceiver(zzrVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzrVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzrVar.zzb = true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
