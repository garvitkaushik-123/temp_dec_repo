package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.internal.play_billing.zzdj;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private PendingPurchasesParams zzD;
    private boolean zzE;
    private boolean zzF;
    private volatile BillingClientStateListener zzG;
    private ExecutorService zzH;
    private final Long zzI;
    private com.google.android.gms.internal.play_billing.zzbl zzJ;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzs zzf;
    private Context zzg;
    private zzch zzh;
    private volatile com.google.android.gms.internal.play_billing.zzam zzi;
    private volatile zzbf zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str, BillingClient.Builder builder) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbq(), str, null, null, null, null, builder);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzc.zzt(str2);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(this.zzI.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, zzbVar, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = zzbVar != null;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        startConnection(new zzbq(j));
    }

    public static /* synthetic */ Void zzA(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        billingClientImpl.zzaA(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void zzB(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzaC(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzC(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) {
        billingClientImpl.zzay(externalOfferReportingDetailsListener, null);
        return null;
    }

    public static /* synthetic */ Void zzD(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        billingClientImpl.zzax(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzE(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        billingClientImpl.zzaz(alternativeBillingOnlyAvailabilityListener);
        return null;
    }

    static Future zzG(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future submit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaj
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzH(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzI(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbt.zzk());
    }

    public static /* synthetic */ void zzJ(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzL(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzN(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
    }

    public static /* synthetic */ void zzP(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zzd() != null) {
            billingClientImpl.zzf.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            zzs zzsVar = billingClientImpl.zzf;
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    private final /* synthetic */ Void zzaA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzB) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzq(24, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbm(externalOfferAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support launching external offer flow.");
                zzaJ(externalOfferAvailabilityListener, zzcj.zzA, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzh, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzm(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbi(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzh, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzo(22, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbk(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzh, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    private final void zzaD(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Consuming purchase with token: " + purchaseToken);
            try {
                synchronized (this.zza) {
                    try {
                        zzamVar = this.zzi;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                if (zzamVar == null) {
                    try {
                        zzaG(consumeResponseListener, purchaseToken, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                        return;
                    } catch (DeadObjectException e) {
                        e = e;
                        zzaG(consumeResponseListener, purchaseToken, zzcj.zzj, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    } catch (Exception e2) {
                        e = e2;
                        zzaG(consumeResponseListener, purchaseToken, zzcj.zzh, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    }
                }
                if (this.zzp) {
                    String packageName = this.zzg.getPackageName();
                    boolean z = this.zzp;
                    String str2 = this.zzc;
                    String str3 = this.zzd;
                    long longValue = this.zzI.longValue();
                    Bundle bundle = new Bundle();
                    if (z) {
                        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str2, str3, longValue);
                    }
                    Bundle zze = zzamVar.zze(9, packageName, purchaseToken, bundle);
                    zza = zze.getInt("RESPONSE_CODE");
                    str = com.google.android.gms.internal.play_billing.zzc.zzj(zze, "BillingClient");
                } else {
                    zza = zzamVar.zza(3, this.zzg.getPackageName(), purchaseToken);
                    str = "";
                }
                BillingResult zza2 = zzcj.zza(zza, str);
                if (zza == 0) {
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Successfully consumed purchase.");
                    consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
                } else {
                    zzaG(consumeResponseListener, purchaseToken, zza2, zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "Error consuming purchase with token. Response code: " + zza, null);
                }
            } catch (DeadObjectException e3) {
                e = e3;
                zzaG(consumeResponseListener, purchaseToken, zzcj.zzj, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
            } catch (Exception e4) {
                e = e4;
                zzaG(consumeResponseListener, purchaseToken, zzcj.zzh, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
            }
        } catch (DeadObjectException e5) {
            e = e5;
        } catch (Exception e6) {
            e = e6;
        }
    }

    private final void zzaE(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(zzieVar, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    private final void zzaG(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzie zzieVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str2, exc);
        zzbf(zzieVar, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaH(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaI(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaK(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzaL(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        zzbf(zzieVar, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaM(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzaN(int i, zzie zzieVar, Exception exc) {
        zzhx zzhxVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        zzch zzchVar = this.zzh;
        String zza = zzcg.zza(exc);
        try {
            zzic zzc = zzig.zzc();
            zzc.zzo(i);
            if (zzieVar != null) {
                zzc.zzn(zzieVar);
            }
            if (zza != null) {
                zzc.zza(zza);
            }
            zzhv zzc2 = zzhx.zzc();
            zzc2.zzl(zzc);
            zzc2.zzp(30);
            zzhxVar = (zzhx) zzc2.zze();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzhxVar = null;
        }
        zzchVar.zza(zzhxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaO(zzhx zzhxVar) {
        try {
            this.zzh.zzb(zzhxVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaP(zzhx zzhxVar, long j, boolean z) {
        try {
            this.zzh.zze(zzhxVar, this.zzm, j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaQ(zzib zzibVar) {
        try {
            this.zzh.zzg(zzibVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaR(zzie zzieVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzcg.zza;
            zzhv zzhvVar = (zzhv) zzcg.zzb(zzieVar, 6, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzm();
            zzjt zzc = zzjv.zzc();
            zzc.zza(i > 0);
            zzc.zzl(i);
            zzhvVar.zzo(zzc);
            zzaO((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaS(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Setting clientState from " + zzaZ(this.zzb) + " to " + zzaZ(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzaT() {
        ExecutorService executorService = this.zzH;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzH = null;
        }
    }

    private final void zzaU(BillingClientStateListener billingClientStateListener, int i) {
        zzie zzieVar;
        BillingResult billingResult;
        BillingResult billingResult2;
        synchronized (this.zza) {
            if (zzaY()) {
                billingResult = zzap(i);
            } else {
                if (this.zzb == 1) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                    zzie zzieVar2 = zzie.BILLING_CLIENT_CONNECTING;
                    billingResult2 = zzcj.zzd;
                    zzaR(zzieVar2, billingResult2, i);
                } else if (this.zzb == 3) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    zzie zzieVar3 = zzie.BILLING_CLIENT_CLOSED;
                    billingResult2 = zzcj.zzj;
                    zzaR(zzieVar3, billingResult2, i);
                } else {
                    zzaS(1);
                    if (i == 0) {
                        this.zzG = billingClientStateListener;
                        i = 0;
                    }
                    zzaV();
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbf(this, billingClientStateListener, i, null);
                    this.zzj.zzc();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> queryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
                    } else {
                        ResolveInfo resolveInfo = queryIntentServices.get(0);
                        if (resolveInfo.serviceInfo != null) {
                            String str = resolveInfo.serviceInfo.packageName;
                            String str2 = resolveInfo.serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    if (this.zzb == 2) {
                                        billingResult = zzap(i);
                                    } else if (this.zzb != 1) {
                                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                        zzie zzieVar4 = zzie.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                        billingResult2 = zzcj.zzj;
                                        zzaR(zzieVar4, billingResult2, i);
                                    } else {
                                        zzbf zzbfVar = this.zzj;
                                        if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.zzg.bindService(intent2, zzbfVar, 1) : this.zzg.bindService(intent2, 1, zzF(), zzbfVar)) {
                                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service was bonded successfully.");
                                            billingResult = null;
                                        } else {
                                            zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                        }
                                    }
                                }
                            }
                        } else {
                            zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzaS(0);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service unavailable on device.");
                    BillingResult billingResult3 = zzcj.zzb;
                    zzaR(zzieVar, billingResult3, i);
                    billingResult = billingResult3;
                }
                billingResult = billingResult2;
            }
        }
        if (billingResult != null) {
            billingClientStateListener.onBillingSetupFinished(billingResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzaV() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                try {
                    this.zzg.unbindService(this.zzj);
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzi = null;
                        this.zzj = null;
                    } finally {
                        this.zzi = null;
                        this.zzj = null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzaW(long j) {
        try {
            BillingResult billingResult = (BillingResult) zzar(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzaY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzaX(long j) {
        long max;
        com.google.android.gms.internal.play_billing.zzbi zzb = com.google.android.gms.internal.play_billing.zzbi.zzb(this.zzJ);
        long j2 = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                max = Math.max(0L, j2);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
            }
            if (max <= 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                return zzaY();
            }
            BillingResult billingResult = (BillingResult) zzar(i).get(max, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                return zzaY();
            }
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            j2 = 30000 - zzb.zza(TimeUnit.MILLISECONDS);
            long pow = ((long) Math.pow(2.0d, i - 1)) * 1000;
            if (j2 < pow) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                return zzaY();
            }
            if (i < 3 && pow > 0) {
                try {
                    Thread.sleep(pow);
                    j2 = 30000 - zzb.zza(TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e2);
                }
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Max retries reached.");
        return zzaY();
    }

    private final boolean zzaY() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                z = true;
            }
        }
        return z;
    }

    private static final String zzaZ(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    static /* bridge */ /* synthetic */ void zzac(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    static /* bridge */ /* synthetic */ void zzae(BillingClientImpl billingClientImpl, int i) {
        if (i != 0) {
            billingClientImpl.zzaS(0);
            return;
        }
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzaS(2);
            zzs zzsVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
            if (zzsVar != null) {
                zzsVar.zzg(billingClientImpl.zzy);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzai(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzal(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            return zzamVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzam(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            return zzamVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzan() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzbo zzao(BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        zzbf(zzieVar, 7, billingResult, zzcg.zza(exc));
        return new zzbo(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzap(int i) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzc = zzib.zzc();
        zzc.zzo(6);
        zzjt zzc2 = zzjv.zzc();
        zzc2.zzn(true);
        zzc2.zza(i > 0);
        zzc2.zzl(i);
        zzc.zzn(zzc2);
        zzaQ((zzib) zzc.zze());
        return zzcj.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaq() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzj;
                }
            }
            return zzcj.zzh;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzcz zzar(final int i) {
        if (this.zzE && !zzaY()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzu
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return BillingClientImpl.zzq(BillingClientImpl.this, i, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzcu.zza(zzcj.zzi);
    }

    private final /* synthetic */ Object zzas(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzie zzieVar2 = zzie.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzcj.zzg;
                zzbd(zzieVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar != null) {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, longValue);
                    Bundle zzd = zzamVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zzc.zzb(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzj(zzd, "BillingClient")));
                    return null;
                }
                zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzie zzieVar3 = zzie.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzcj.zza;
                zzbd(zzieVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzh, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzat(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaL(billingConfigResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, longValue);
                    zzamVar.zzn(18, packageName, bundle, new zzbj(billingConfigResponseListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                zzie zzieVar2 = zzie.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzcj.zzy;
                zzbd(zzieVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzaL(billingConfigResponseListener, zzcj.zzj, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaL(billingConfigResponseListener, zzcj.zzh, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzau(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaN(-1, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzr(12, this.zzg.getPackageName(), bundle, new zzbn(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaN(-1, zzie.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaN(6, zzie.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzav(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaw() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final /* synthetic */ Void zzax(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzk(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbg(alternativeBillingOnlyReportingDetailsListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzh, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzay(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzz) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    long j = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime;
                    String str2 = this.zzc;
                    String str3 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str2, str3, longValue);
                    bundle.putLong("appInstallTimeMillis", j);
                    zzamVar.zzl(22, packageName, bundle, new zzbh(externalOfferReportingDetailsListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzaI(externalOfferReportingDetailsListener, zzcj.zzt, zzie.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzh, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzp(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbl(alternativeBillingOnlyAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzh, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final zzcw zzba(int i, BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        zzbf(zzieVar, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        return new zzcw(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzcw zzbb(String str, boolean z, int i) {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        int i2;
        int i3;
        Bundle zzi;
        BillingResult build;
        zzie zzieVar;
        BillingClientImpl billingClientImpl = this;
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z2 = billingClientImpl.zzp;
        boolean z3 = billingClientImpl.zzw;
        boolean isEnabledForOneTimeProducts = billingClientImpl.zzD.isEnabledForOneTimeProducts();
        boolean isEnabledForPrepaidPlans = billingClientImpl.zzD.isEnabledForPrepaidPlans();
        long longValue = billingClientImpl.zzI.longValue();
        Bundle bundle = new Bundle();
        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, longValue);
        if (z2 && isEnabledForOneTimeProducts) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z3 && isEnabledForPrepaidPlans) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        String str2 = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzamVar = billingClientImpl.zzi;
                }
                if (zzamVar == null) {
                    return billingClientImpl.zzba(9, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (billingClientImpl.zzp) {
                    if (billingClientImpl.zzC) {
                        i3 = 26;
                    } else if (billingClientImpl.zzB) {
                        i3 = 24;
                    } else if (billingClientImpl.zzw) {
                        i3 = 19;
                    } else {
                        i2 = 9;
                        zzi = zzamVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, str2, bundle);
                    }
                    i2 = i3;
                    zzi = zzamVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, str2, bundle);
                } else {
                    zzi = zzamVar.zzh(3, billingClientImpl.zzg.getPackageName(), str, str2);
                }
                BillingResult billingResult = zzcj.zzh;
                if (zzi == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s got null owned items list", "getPurchase()"));
                    zzieVar = zzie.NULL_OWNED_ITEMS_LIST;
                } else {
                    int zzb = com.google.android.gms.internal.play_billing.zzc.zzb(zzi, "BillingClient");
                    String zzj = com.google.android.gms.internal.play_billing.zzc.zzj(zzi, "BillingClient");
                    BillingResult.Builder newBuilder = BillingResult.newBuilder();
                    newBuilder.setResponseCode(zzb);
                    newBuilder.setDebugMessage(zzj);
                    build = newBuilder.build();
                    if (zzb != 0) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(zzb)));
                        zzieVar = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (zzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && zzi.containsKey("INAPP_PURCHASE_DATA_LIST") && zzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                            zzieVar = zzie.NULL_SKUS_LIST;
                        } else if (stringArrayList2 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            zzieVar = zzie.NULL_PURCHASES_LIST;
                        } else if (stringArrayList3 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            zzieVar = zzie.NULL_SIGNATURES_LIST;
                        } else {
                            build = zzcj.zzi;
                            zzieVar = zzie.REASON_UNSPECIFIED;
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                        zzieVar = zzie.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (build == zzcj.zzi) {
                        return billingClientImpl.zzba(9, build, zzieVar, "Purchase bundle invalid", null);
                    }
                    ArrayList<String> stringArrayList4 = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList5 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList6 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    boolean z4 = false;
                    for (int i4 = 0; i4 < stringArrayList5.size(); i4++) {
                        String str3 = stringArrayList5.get(i4);
                        String str4 = stringArrayList6.get(i4);
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList4.get(i4))));
                        try {
                            Purchase purchase = new Purchase(str3, str4);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "BUG: empty/null token!");
                                z4 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return zzba(9, zzcj.zzh, zzie.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    billingClientImpl = this;
                    if (z4) {
                        billingClientImpl.zzbd(zzie.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                    }
                    str2 = zzi.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                }
                build = billingResult;
                if (build == zzcj.zzi) {
                }
            } catch (DeadObjectException e2) {
                return zzba(9, zzcj.zzj, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return billingClientImpl.zzba(9, zzcj.zzh, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(str2));
        return new zzcw(zzcj.zzi, arrayList);
    }

    private final void zzbc(BillingResult billingResult, zzie zzieVar, int i) {
        zzib zzibVar = null;
        zzhx zzhxVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i2 = zzcg.zza;
            try {
                zzhz zzc = zzib.zzc();
                zzc.zzo(5);
                zziw zzc2 = zziz.zzc();
                zzc2.zza(i);
                zzc.zzl((zziz) zzc2.zze());
                zzibVar = (zzib) zzc.zze();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            }
            zzaQ(zzibVar);
            return;
        }
        int i3 = zzcg.zza;
        try {
            zzhv zzc3 = zzhx.zzc();
            zzic zzc4 = zzig.zzc();
            zzc4.zzo(billingResult.getResponseCode());
            zzc4.zzl(billingResult.getDebugMessage());
            zzc4.zzn(zzieVar);
            zzc3.zzl(zzc4);
            zzc3.zzp(5);
            zziw zzc5 = zziz.zzc();
            zzc5.zza(i);
            zzc3.zzm((zziz) zzc5.zze());
            zzhxVar = (zzhx) zzc3.zze();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e2);
        }
        zzaO(zzhxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbd(zzie zzieVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbe(zzie zzieVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcg.zza;
            try {
                this.zzh.zzc(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    private final void zzbf(zzie zzieVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbg(zzie zzieVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbh(zzie zzieVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbi(int i) {
        try {
            int i2 = zzcg.zza;
            zzaQ(zzcg.zzc(i, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    static /* bridge */ /* synthetic */ BillingResult zzl(Exception exc) {
        return exc instanceof DeadObjectException ? zzcj.zzj : zzcj.zzh;
    }

    public static /* synthetic */ Object zzq(BillingClientImpl billingClientImpl, int i, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.zzaU(new zzbc(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzr(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        if (billingClientImpl.zzaX(30000L)) {
            billingClientImpl.zzaD(consumeParams, consumeResponseListener);
            return null;
        }
        zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzcj.zzj;
        billingClientImpl.zzbd(zzieVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        return null;
    }

    public static /* synthetic */ Object zzs(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) {
        if (!billingClientImpl.zzaX(30000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(zzieVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
            return null;
        }
        if (billingClientImpl.zzu) {
            zzbo zzg = billingClientImpl.zzg(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzg.zza(), zzg.zzb()), new QueryProductDetailsResult(zzg.zzc(), zzg.zzd()));
            return null;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Querying product details is not supported.");
        zzie zzieVar2 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzcj.zzr;
        billingClientImpl.zzbd(zzieVar2, 7, billingResult2);
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
        return null;
    }

    public static /* synthetic */ Object zzt(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        billingClientImpl.zzas(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzau(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        billingClientImpl.zzat(billingConfigResponseListener);
        return null;
    }

    public static /* synthetic */ Void zzz(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzaB(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzt(BillingClientImpl.this, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzL(BillingClientImpl.this, acknowledgePurchaseResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, zzaq);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaq);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzak
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzr(BillingClientImpl.this, consumeResponseListener, consumeParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzH(BillingClientImpl.this, consumeResponseListener, consumeParams);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, zzaq);
            consumeResponseListener.onConsumeResponse(zzaq, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzD(BillingClientImpl.this, alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzag
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        final String str = null;
        if (zzG(new Callable(externalOfferReportingDetailsListener, str) { // from class: com.android.billingclient.api.zzaq
            public final /* synthetic */ ExternalOfferReportingDetailsListener zzb;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzC(BillingClientImpl.this, this.zzb, null);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaI(externalOfferReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaI(externalOfferReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbi(12);
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    this.zzf.zzf();
                }
            } finally {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                zzaV();
                zzaT();
                zzaS(3);
                this.zzG = null;
            }
            try {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                zzaV();
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
            }
            try {
                zzaT();
                zzaS(3);
            } catch (Throwable th2) {
                try {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th2);
                    zzaS(3);
                } catch (Throwable th3) {
                    zzaS(3);
                    this.zzG = null;
                    throw th3;
                }
            }
            this.zzG = null;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzv(BillingClientImpl.this, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzJ(BillingClientImpl.this, billingConfigResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, zzaq);
            billingConfigResponseListener.onBillingConfigResponse(zzaq, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzE(BillingClientImpl.this, alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzau
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzA(BillingClientImpl.this, externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaJ(externalOfferAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaJ(externalOfferAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c;
        BillingResult billingResult;
        if (!zzaW(3000L)) {
            billingResult = zzcj.zzj;
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbd(zzieVar, 5, billingResult);
                return billingResult;
            }
            zzbi(5);
            return billingResult;
        }
        int i = zzcj.zzG;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 107244:
                if (str.equals("lll")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 108237:
                if (str.equals("mmm")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 109230:
                if (str.equals("nnn")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BillingResult billingResult2 = this.zzk ? zzcj.zzi : zzcj.zzl;
                zzbc(billingResult2, zzie.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                break;
            case 1:
                BillingResult billingResult3 = this.zzl ? zzcj.zzi : zzcj.zzm;
                zzbc(billingResult3, zzie.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                break;
            case 2:
                BillingResult billingResult4 = this.zzo ? zzcj.zzi : zzcj.zzn;
                zzbc(billingResult4, zzie.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                break;
            case 3:
                BillingResult billingResult5 = this.zzq ? zzcj.zzi : zzcj.zzs;
                zzbc(billingResult5, zzie.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                break;
            case 4:
                BillingResult billingResult6 = this.zzs ? zzcj.zzi : zzcj.zzo;
                zzbc(billingResult6, zzie.CROSS_APP_NOT_SUPPORTED, 6);
                break;
            case 5:
                BillingResult billingResult7 = this.zzr ? zzcj.zzi : zzcj.zzq;
                zzbc(billingResult7, zzie.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                break;
            case 6:
                BillingResult billingResult8 = this.zzt ? zzcj.zzi : zzcj.zzp;
                zzbc(billingResult8, zzie.MULTI_ITEM_NOT_SUPPORTED, 8);
                break;
            case 7:
                BillingResult billingResult9 = this.zzt ? zzcj.zzi : zzcj.zzp;
                zzbc(billingResult9, zzie.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                break;
            case '\b':
                BillingResult billingResult10 = this.zzu ? zzcj.zzi : zzcj.zzr;
                zzbc(billingResult10, zzie.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                break;
            case '\t':
                BillingResult billingResult11 = this.zzv ? zzcj.zzi : zzcj.zzy;
                zzbc(billingResult11, zzie.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                break;
            case '\n':
                BillingResult billingResult12 = this.zzv ? zzcj.zzi : zzcj.zzz;
                zzbc(billingResult12, zzie.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                break;
            case 11:
                BillingResult billingResult13 = this.zzx ? zzcj.zzi : zzcj.zzC;
                zzbc(billingResult13, zzie.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                break;
            case '\f':
                BillingResult billingResult14 = this.zzy ? zzcj.zzi : zzcj.zzD;
                zzbc(billingResult14, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                break;
            case '\r':
                BillingResult billingResult15 = this.zzB ? zzcj.zzi : zzcj.zzA;
                zzbc(billingResult15, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, 18);
                break;
            case 14:
                BillingResult billingResult16 = this.zzA ? zzcj.zzi : zzcj.zzu;
                zzbc(billingResult16, zzie.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                break;
            case 15:
                BillingResult billingResult17 = this.zzB ? zzcj.zzi : zzcj.zzv;
                zzbc(billingResult17, zzie.AUTO_PAY_NOT_SUPPORTED, 20);
                break;
            case 16:
                BillingResult billingResult18 = this.zzC ? zzcj.zzi : zzcj.zzw;
                zzbc(billingResult18, zzie.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                break;
            default:
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                BillingResult billingResult19 = zzcj.zzx;
                zzbc(billingResult19, zzie.UNKNOWN_FEATURE, 1);
                break;
        }
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzE) {
            return true;
        }
        return zzaY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04b4  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean zzd;
        String productId;
        String productType;
        long j;
        Future zzG;
        long j2;
        zzie zzieVar;
        BillingResult billingResult;
        boolean z;
        zzie zzieVar2;
        int i;
        String str;
        boolean z2;
        String str2;
        boolean z3;
        Intent intent;
        long j3;
        long nextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zzd() == null) {
            zzie zzieVar3 = zzie.MISSING_LISTENER;
            BillingResult billingResult2 = zzcj.zzE;
            zzbe(zzieVar3, 2, billingResult2, nextLong);
            return billingResult2;
        }
        if (!zzaW(3000L)) {
            zzie zzieVar4 = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult3 = zzcj.zzj;
            zzbe(zzieVar4, 2, billingResult3, nextLong);
            zzm(billingResult3);
            return billingResult3;
        }
        synchronized (this.zza) {
            zzd = this.zzj != null ? this.zzj.zzd() : false;
        }
        ArrayList<SkuDetails> zzj = billingFlowParams.zzj();
        List zzk = billingFlowParams.zzk();
        String str3 = null;
        SkuDetails skuDetails = (SkuDetails) com.google.android.gms.internal.play_billing.zzby.zza(zzj, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzby.zza(zzk, null);
        if (skuDetails != null) {
            productId = skuDetails.getSku();
            productType = skuDetails.getType();
        } else {
            productId = productDetailsParams.zza().getProductId();
            productType = productDetailsParams.zza().getProductType();
        }
        if (productType.equals("subs") && !this.zzk) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzie zzieVar5 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
            BillingResult billingResult4 = zzcj.zzl;
            zzbg(zzieVar5, 2, billingResult4, nextLong, zzd);
            zzm(billingResult4);
            return billingResult4;
        }
        if (billingFlowParams.zzt() && !this.zzn) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzie zzieVar6 = zzie.EXTRA_PARAMS_NOT_SUPPORTED;
            BillingResult billingResult5 = zzcj.zzf;
            zzbg(zzieVar6, 2, billingResult5, nextLong, zzd);
            zzm(billingResult5);
            return billingResult5;
        }
        if (zzj.size() > 1 && !this.zzt) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzie zzieVar7 = zzie.MULTI_ITEM_NOT_SUPPORTED;
            BillingResult billingResult6 = zzcj.zzp;
            zzbg(zzieVar7, 2, billingResult6, nextLong, zzd);
            zzm(billingResult6);
            return billingResult6;
        }
        if (!zzk.isEmpty() && !this.zzu) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzie zzieVar8 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult7 = zzcj.zzr;
            zzbg(zzieVar8, 2, billingResult7, nextLong, zzd);
            zzm(billingResult7);
            return billingResult7;
        }
        BillingResult zzd2 = billingFlowParams.zzd();
        if (zzd2 != zzcj.zzi) {
            zzbg(zzie.INVALID_BILLING_FLOW_PARAMS, 2, zzd2, nextLong, zzd);
            zzm(zzd2);
            return zzd2;
        }
        if (this.zzn) {
            boolean z4 = this.zzp;
            boolean z5 = this.zzw;
            boolean isEnabledForOneTimeProducts = this.zzD.isEnabledForOneTimeProducts();
            boolean isEnabledForPrepaidPlans = this.zzD.isEnabledForPrepaidPlans();
            boolean z6 = this.zzF;
            String str4 = this.zzc;
            String str5 = this.zzd;
            boolean z7 = zzd;
            long longValue = this.zzI.longValue();
            this.zzg.getPackageName();
            int i2 = com.google.android.gms.internal.play_billing.zzc.zza;
            final Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str4, str5, longValue);
            bundle.putLong("billingClientTransactionId", nextLong);
            if (billingFlowParams.zzb() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zzb());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zze())) {
                bundle.putString(InMobiAdapter.ACCOUNT_ID, billingFlowParams.zze());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.zzf());
            }
            if (billingFlowParams.zzs()) {
                i = 1;
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            } else {
                i = 1;
            }
            if (!TextUtils.isEmpty(null)) {
                String[] strArr = new String[i];
                strArr[0] = null;
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(strArr)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzh())) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.zzh());
            }
            billingFlowParams.zzg();
            if (TextUtils.isEmpty(null)) {
                str = null;
            } else {
                billingFlowParams.zzg();
                str = null;
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzi())) {
                bundle.putString("originalExternalTransactionId", billingFlowParams.zzi());
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("paymentsPurchaseParams", str);
            }
            if (z4 && isEnabledForOneTimeProducts) {
                z2 = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z2 = true;
            }
            if (z5 && isEnabledForPrepaidPlans) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z2);
            }
            if (z6) {
                bundle.putBoolean("enableAlternativeBilling", z2);
            }
            billingFlowParams.zzc();
            billingFlowParams.zza();
            ArrayList arrayList = new ArrayList();
            for (BillingFlowParams.ProductDetailsParams productDetailsParams2 : billingFlowParams.zzk()) {
            }
            if (!arrayList.isEmpty()) {
                zzdj zza = zzdk.zza();
                zza.zza(arrayList);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdk) zza.zze()).zzM());
            }
            if (zzj.isEmpty()) {
                j = nextLong;
                str2 = productId;
                ArrayList<String> arrayList2 = new ArrayList<>(zzk.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(zzk.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                for (int i3 = 0; i3 < zzk.size(); i3++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) zzk.get(i3);
                    ProductDetails zza2 = productDetailsParams3.zza();
                    if (!zza2.zzb().isEmpty()) {
                        arrayList4.add(zza2.zzb());
                    }
                    arrayList5.add(productDetailsParams3.zzb());
                    String zzc = zza2.zzc();
                    if (zza2.zzd() != null && !zza2.zzd().isEmpty()) {
                        Iterator it = zza2.zzd().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = (ProductDetails.OneTimePurchaseOfferDetails) it.next();
                            if (!TextUtils.isEmpty(oneTimePurchaseOfferDetails.zzb())) {
                                zzc = oneTimePurchaseOfferDetails.zzb();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(zzc)) {
                        arrayList6.add(zzc);
                    }
                    if (i3 > 0) {
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) zzk.get(i3)).zza().getProductId());
                        arrayList3.add(((BillingFlowParams.ProductDetailsParams) zzk.get(i3)).zza().getProductType());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                if (!arrayList7.isEmpty()) {
                    bundle.putIntegerArrayList("autoPayBalanceThresholdList", arrayList7);
                }
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                }
            } else {
                ArrayList<String> arrayList8 = new ArrayList<>();
                ArrayList<String> arrayList9 = new ArrayList<>();
                ArrayList<String> arrayList10 = new ArrayList<>();
                ArrayList<Integer> arrayList11 = new ArrayList<>();
                ArrayList<String> arrayList12 = new ArrayList<>();
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                long j4 = nextLong;
                for (SkuDetails skuDetails2 : zzj) {
                    if (skuDetails2.zzf().isEmpty()) {
                        j3 = j4;
                    } else {
                        j3 = j4;
                        arrayList8.add(skuDetails2.zzf());
                    }
                    String zzc2 = skuDetails2.zzc();
                    String zzb = skuDetails2.zzb();
                    int zza3 = skuDetails2.zza();
                    String str6 = productId;
                    String zze = skuDetails2.zze();
                    arrayList9.add(zzc2);
                    z8 |= !TextUtils.isEmpty(zzc2);
                    arrayList10.add(zzb);
                    z9 |= !TextUtils.isEmpty(zzb);
                    arrayList11.add(Integer.valueOf(zza3));
                    z10 |= zza3 != 0;
                    z11 |= !TextUtils.isEmpty(zze);
                    arrayList12.add(zze);
                    j4 = j3;
                    productId = str6;
                }
                j = j4;
                str2 = productId;
                if (!arrayList8.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList8);
                }
                if (z8) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList9);
                }
                if (z9) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList10);
                }
                if (z10) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList11);
                }
                if (z11) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList12);
                }
                if (zzj.size() > 1) {
                    ArrayList<String> arrayList13 = new ArrayList<>(zzj.size() - 1);
                    ArrayList<String> arrayList14 = new ArrayList<>(zzj.size() - 1);
                    for (int i4 = 1; i4 < zzj.size(); i4++) {
                        arrayList13.add(((SkuDetails) zzj.get(i4)).getSku());
                        arrayList14.add(((SkuDetails) zzj.get(i4)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList13);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList14);
                }
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                zzie zzieVar9 = zzie.OFFER_ID_TOKEN_NOT_SUPPORTED;
                BillingResult billingResult8 = zzcj.zzq;
                zzbg(zzieVar9, 2, billingResult8, j, z7);
                zzm(billingResult8);
                return billingResult8;
            }
            zzd = z7;
            if (skuDetails != null && !TextUtils.isEmpty(skuDetails.zzd())) {
                bundle.putString("skuPackageName", skuDetails.zzd());
            } else if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                z3 = false;
                str3 = null;
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("accountName", str3);
                }
                intent = activity.getIntent();
                if (intent != null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Activity's intent is null.");
                } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        bundle.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused) {
                        bundle.putString("proxyPackageVersion", "package not found");
                    }
                }
                final int i5 = (this.zzu || zzk.isEmpty()) ? (this.zzs || !z3) ? !this.zzp ? 9 : 6 : 15 : 17;
                final BillingFlowParams billingFlowParams2 = billingFlowParams;
                final String str7 = productType;
                final String str8 = str2;
                zzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzw
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Bundle zzal;
                        zzal = BillingClientImpl.this.zzal(i5, str8, str7, billingFlowParams2, bundle);
                        return zzal;
                    }
                }, 5000L, null, this.zze, zzF());
                j2 = billingFlowParams2;
            } else {
                bundle.putString("skuPackageName", productDetailsParams.zza().zza());
            }
            str3 = null;
            z3 = true;
            if (!TextUtils.isEmpty(str3)) {
            }
            intent = activity.getIntent();
            if (intent != null) {
            }
            final int i52 = (this.zzu || zzk.isEmpty()) ? (this.zzs || !z3) ? !this.zzp ? 9 : 6 : 15 : 17;
            final BillingFlowParams billingFlowParams22 = billingFlowParams;
            final String str72 = productType;
            final String str82 = str2;
            zzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle zzal;
                    zzal = BillingClientImpl.this.zzal(i52, str82, str72, billingFlowParams22, bundle);
                    return zzal;
                }
            }, 5000L, null, this.zze, zzF());
            j2 = billingFlowParams22;
        } else {
            j = nextLong;
            final String str9 = productId;
            final String str10 = productType;
            zzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzx
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle zzam;
                    zzam = BillingClientImpl.this.zzam(str9, str10);
                    return zzam;
                }
            }, 5000L, null, this.zze, zzF());
            j2 = nextLong;
        }
        try {
            if (zzG == null) {
                try {
                    zzieVar = zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                    billingResult = zzcj.zzc;
                    z = zzd;
                    j2 = j;
                } catch (CancellationException e) {
                    e = e;
                    j2 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar10 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult9 = zzcj.zzk;
                    zzbh(zzieVar10, 2, billingResult9, zzcg.zza(e), j2, zzd);
                    zzm(billingResult9);
                    return billingResult9;
                } catch (TimeoutException e2) {
                    e = e2;
                    j2 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar102 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult92 = zzcj.zzk;
                    zzbh(zzieVar102, 2, billingResult92, zzcg.zza(e), j2, zzd);
                    zzm(billingResult92);
                    return billingResult92;
                } catch (Exception e3) {
                    e = e3;
                    j2 = j;
                }
                try {
                    zzbg(zzieVar, 2, billingResult, j2, z);
                    zzm(billingResult);
                    return billingResult;
                } catch (CancellationException e4) {
                    e = e4;
                    zzd = z;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar1022 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult922 = zzcj.zzk;
                    zzbh(zzieVar1022, 2, billingResult922, zzcg.zza(e), j2, zzd);
                    zzm(billingResult922);
                    return billingResult922;
                } catch (TimeoutException e5) {
                    e = e5;
                    zzd = z;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar10222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult9222 = zzcj.zzk;
                    zzbh(zzieVar10222, 2, billingResult9222, zzcg.zza(e), j2, zzd);
                    zzm(billingResult9222);
                    return billingResult9222;
                } catch (Exception e6) {
                    e = e6;
                    zzd = z;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzie zzieVar11 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult10 = zzcj.zzj;
                    zzbh(zzieVar11, 2, billingResult10, zzcg.zza(e), j2, zzd);
                    zzm(billingResult10);
                    return billingResult10;
                }
            }
            j2 = j;
            Bundle bundle2 = (Bundle) zzG.get(5000L, TimeUnit.MILLISECONDS);
            int zzb2 = com.google.android.gms.internal.play_billing.zzc.zzb(bundle2, "BillingClient");
            String zzj2 = com.google.android.gms.internal.play_billing.zzc.zzj(bundle2, "BillingClient");
            if (zzb2 == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                intent2.putExtra("billingClientTransactionId", j2);
                intent2.putExtra("wasServiceAutoReconnected", zzd);
                activity.startActivity(intent2);
                return zzcj.zzi;
            }
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unable to buy item, Error response code: " + zzb2);
            BillingResult zza4 = zzcj.zza(zzb2, zzj2);
            try {
                if (bundle2 == null) {
                    zzieVar2 = zzie.REASON_UNSPECIFIED;
                } else {
                    Object obj = bundle2.get("LOG_REASON");
                    if (obj == null) {
                        zzieVar2 = zzie.REASON_UNSPECIFIED;
                    } else if (obj instanceof Integer) {
                        zzieVar2 = zzie.zzb(((Integer) obj).intValue());
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        zzieVar2 = zzie.REASON_UNSPECIFIED;
                    }
                }
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                zzieVar2 = zzie.REASON_UNSPECIFIED;
            }
            if (zzieVar2 == zzie.REASON_UNSPECIFIED) {
                zzieVar2 = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            }
            zzie zzieVar12 = zzieVar2;
            if (bundle2 != null) {
                try {
                    str3 = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                }
            }
            try {
                zzbh(zzieVar12, 2, zza4, str3, j2, zzd);
                zzm(zza4);
                return zza4;
            } catch (CancellationException e7) {
                e = e7;
                j2 = j2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar102222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult92222 = zzcj.zzk;
                zzbh(zzieVar102222, 2, billingResult92222, zzcg.zza(e), j2, zzd);
                zzm(billingResult92222);
                return billingResult92222;
            } catch (TimeoutException e8) {
                e = e8;
                j2 = j2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar1022222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult922222 = zzcj.zzk;
                zzbh(zzieVar1022222, 2, billingResult922222, zzcg.zza(e), j2, zzd);
                zzm(billingResult922222);
                return billingResult922222;
            } catch (Exception e9) {
                e = e9;
                j2 = j2;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                zzie zzieVar112 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                BillingResult billingResult102 = zzcj.zzj;
                zzbh(zzieVar112, 2, billingResult102, zzcg.zza(e), j2, zzd);
                zzm(billingResult102);
                return billingResult102;
            }
        } catch (CancellationException e10) {
            e = e10;
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            zzie zzieVar10222222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
            BillingResult billingResult9222222 = zzcj.zzk;
            zzbh(zzieVar10222222, 2, billingResult9222222, zzcg.zza(e), j2, zzd);
            zzm(billingResult9222222);
            return billingResult9222222;
        } catch (TimeoutException e11) {
            e = e11;
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            zzie zzieVar102222222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
            BillingResult billingResult92222222 = zzcj.zzk;
            zzbh(zzieVar102222222, 2, billingResult92222222, zzcg.zza(e), j2, zzd);
            zzm(billingResult92222222);
            return billingResult92222222;
        } catch (Exception e12) {
            e = e12;
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
            zzie zzieVar1122 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
            BillingResult billingResult1022 = zzcj.zzj;
            zzbh(zzieVar1122, 2, billingResult1022, zzcg.zza(e), j2, zzd);
            zzm(billingResult1022);
            return billingResult1022;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzal
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzs(BillingClientImpl.this, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzap
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzN(BillingClientImpl.this, productDetailsResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, zzaq);
            productDetailsResponseListener.onProductDetailsResponse(zzaq, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzG(new zzaw(this, purchasesResponseListener, queryPurchasesParams.zza(), false), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzat
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzI(BillingClientImpl.this, purchasesResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, zzaq);
            purchasesResponseListener.onQueryPurchasesResponse(zzaq, com.google.android.gms.internal.play_billing.zzbt.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzaW(3000L)) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
            return zzcj.zzj;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzcj.zzs;
        }
        View findViewById = activity.findViewById(R.id.content);
        IBinder windowToken = findViewById.getWindowToken();
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        Handler handler = this.zze;
        final zzax zzaxVar = new zzax(this, handler, inAppMessageResponseListener);
        zzG(new Callable() { // from class: com.android.billingclient.api.zzas
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzu(BillingClientImpl.this, bundle, activity, zzaxVar);
                return null;
            }
        }, 5000L, null, handler, zzF());
        return zzcj.zzi;
    }

    final synchronized ExecutorService zzF() {
        if (this.zzH == null) {
            this.zzH = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzav(this));
        }
        return this.zzH;
    }

    public final void zzag(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzbo zzg(QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String zzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbt zza = queryProductDetailsParams.zza();
        int size = zza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    return zzao(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.zzw && this.zzD.isEnabledForPrepaidPlans();
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                Bundle zzj = zzamVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), zzb, bundle, com.google.android.gms.internal.play_billing.zzc.zzf(str, this.zzd, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z, true, false, true, false, true), this.zzI.longValue()));
                if (zzj == null) {
                    return zzao(zzcj.zzB, zzie.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!zzj.containsKey("DETAILS_LIST")) {
                    int zzb2 = com.google.android.gms.internal.play_billing.zzc.zzb(zzj, "BillingClient");
                    String zzj2 = com.google.android.gms.internal.play_billing.zzc.zzj(zzj, "BillingClient");
                    if (zzb2 == 0) {
                        return zzao(zzcj.zza(6, zzj2), zzie.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzao(zzcj.zza(zzb2, zzj2), zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + zzb2, null);
                }
                ArrayList<String> stringArrayList = zzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzao(zzcj.zzB, zzie.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e) {
                        return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = zzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (QueryProductDetailsParams.Product product : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put(InAppPurchaseMetaData.KEY_PRODUCT_ID, product.zza()).put("type", product.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                ProductDetails productDetails2 = (ProductDetails) it.next();
                                if (!product.zza().equals(productDetails2.getProductId()) || !product.zzb().equals(productDetails2.getProductType())) {
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(it2.next());
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return zzao(zzcj.zzj, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzao(zzcj.zzh, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzbo(0, "", arrayList, arrayList2);
    }

    final zzch zzj() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzP(BillingClientImpl.this, billingResult);
            }
        });
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(3000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 16, billingResult);
            return billingResult;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzie zzieVar2 = zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzD;
            zzbd(zzieVar2, 16, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzay zzayVar = new zzay(this, handler, alternativeBillingOnlyInformationDialogListener);
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzz(BillingClientImpl.this, alternativeBillingOnlyInformationDialogListener, activity, zzayVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzF()) != null) {
            return zzcj.zzi;
        }
        BillingResult zzaq = zzaq();
        zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 16, zzaq);
        return zzaq;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(3000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 25, billingResult);
            return billingResult;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support external offer.");
            zzie zzieVar2 = zzie.EXTERNAL_OFFER_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzt;
            zzbd(zzieVar2, 25, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzaz zzazVar = new zzaz(this, handler, externalOfferInformationDialogListener);
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzan
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzB(BillingClientImpl.this, externalOfferInformationDialogListener, activity, zzazVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzao
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaK(externalOfferInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzF()) != null) {
            return zzcj.zzi;
        }
        BillingResult zzaq = zzaq();
        zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 25, zzaq);
        return zzaq;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzaU(billingClientStateListener, 0);
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null, builder);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
    }

    BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzI = valueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(BuildConfig.VERSION_NAME);
        if (zzaw != null) {
            zzc.zzt(zzaw);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(valueOf.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzc.zzt(str2);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(this.zzI.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = userChoiceBillingListener != null;
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzI = valueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(BuildConfig.VERSION_NAME);
        if (zzaw != null) {
            zzc.zzt(zzaw);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(valueOf.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzs(this.zzg, null, null, null, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, BuildConfig.VERSION_NAME, (zzch) null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, BuildConfig.VERSION_NAME, null, userChoiceBillingListener, null, null, builder);
    }
}
