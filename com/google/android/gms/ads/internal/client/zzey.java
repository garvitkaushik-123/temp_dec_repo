package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzfwg;
import com.ironsource.mediationsdk.metadata.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzey {
    public static final Set zza = new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    private static zzey zzb;
    private zzep zzc;
    private zzfc zzd;
    private zzeo zze;
    private zzdb zzl;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private boolean zzi = false;
    private boolean zzj = false;
    private final Object zzk = new Object();
    private OnAdInspectorClosedListener zzm = null;
    private RequestConfiguration zzn = new RequestConfiguration.Builder().build();
    private final ArrayList zzh = new ArrayList();

    private zzey() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzA(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbmd zzbmdVar = (zzbmd) it.next();
            hashMap.put(zzbmdVar.zza, new zzbml(zzbmdVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbmdVar.zzd, zzbmdVar.zzc));
        }
        return new zzbmm(hashMap);
    }

    private final void zzB(String str) {
        try {
            this.zzl.zzk();
            this.zzl.zzl(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    private final void zzC(Context context) {
        if (this.zzl == null) {
            this.zzl = (zzdb) new zzau(zzbb.zza(), context).zzd(context, false);
        }
    }

    private final void zzD(RequestConfiguration requestConfiguration) {
        try {
            this.zzl.zzu(new zzfx(requestConfiguration));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to set request configuration parcel.", e);
        }
    }

    public static zzey zzf() {
        zzey zzeyVar;
        synchronized (zzey.class) {
            if (zzb == null) {
                zzb = new zzey();
            }
            zzeyVar = zzb;
        }
        return zzeyVar;
    }

    public static /* synthetic */ void zzl(zzey zzeyVar, String str) {
        synchronized (zzeyVar.zzk) {
            zzeyVar.zzB(null);
        }
    }

    public static /* synthetic */ void zzm(zzey zzeyVar, String str) {
        synchronized (zzeyVar.zzk) {
            zzeyVar.zzB(null);
        }
    }

    public final RequestConfiguration zzc() {
        return this.zzn;
    }

    public final InitializationStatus zze() {
        InitializationStatus zzA;
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                zzA = zzA(this.zzl.zzg());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final Map getAdapterStatusMap() {
                        HashMap hashMap = new HashMap();
                        hashMap.put("com.google.android.gms.ads.MobileAds", new zzeu(zzey.this));
                        return hashMap;
                    }
                };
            }
        }
        return zzA;
    }

    public final com.google.android.gms.ads.preload.zzb zzg(AdFormat adFormat) {
        AdFormat adFormat2 = AdFormat.BANNER;
        int ordinal = adFormat.ordinal();
        if (ordinal == 1) {
            return this.zzc;
        }
        if (ordinal == 2) {
            return this.zzd;
        }
        if (ordinal != 5) {
            return null;
        }
        return this.zze;
    }

    public final Status zzh(Context context, List list, PreloadCallback preloadCallback) {
        boolean z;
        Status status;
        zzbde.zza(context);
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PreloadConfiguration preloadConfiguration = (PreloadConfiguration) it.next();
            String str = String.valueOf(preloadConfiguration.getAdFormat()) + "#" + preloadConfiguration.getAdUnitId();
            hashMap.put(str, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzi(hashMap, str, 0)).intValue() + 1));
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if (((Integer) ((Map.Entry) it2.next()).getValue()).intValue() > 1) {
                hashSet.add("Preload configurations include duplicated ad unit IDs and ad format combinations");
                z = true;
                break;
            }
        }
        HashMap hashMap2 = new HashMap();
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            PreloadConfiguration preloadConfiguration2 = (PreloadConfiguration) it3.next();
            AdFormat adFormat = preloadConfiguration2.getAdFormat();
            if (zza.contains(preloadConfiguration2.getAdFormat())) {
                hashMap2.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzi(hashMap2, adFormat, 0)).intValue() + 1));
                if (preloadConfiguration2.getBufferSize() > 15) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size exceeds the maximum limit %d for %s", 15, adFormat.name()));
                } else if (preloadConfiguration2.getBufferSize() < 0) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size less than 0 for %s", adFormat.name()));
                }
            } else {
                hashSet.add("PreloadConfiguration ad format is not supported:".concat(String.valueOf(String.valueOf(preloadConfiguration2.getAdFormat()))));
            }
            z = true;
        }
        EnumMap enumMap = new EnumMap(AdFormat.class);
        enumMap.put((EnumMap) AdFormat.APP_OPEN_AD, (AdFormat) zzbd.zzc().zzb(zzbde.zzeO));
        enumMap.put((EnumMap) AdFormat.INTERSTITIAL, (AdFormat) zzbd.zzc().zzb(zzbde.zzeM));
        enumMap.put((EnumMap) AdFormat.REWARDED, (AdFormat) zzbd.zzc().zzb(zzbde.zzeN));
        for (Map.Entry entry : hashMap2.entrySet()) {
            AdFormat adFormat2 = (AdFormat) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            int intValue2 = ((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzi(enumMap, adFormat2, 0)).intValue();
            if (intValue > intValue2) {
                hashSet.add(String.format(Locale.US, "Preload configurations' size exceeds the maximum limit %d for %s", Integer.valueOf(intValue2), adFormat2.name()));
                z = true;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                sb.append((String) it4.next());
                if (it4.hasNext()) {
                    sb.append(", ");
                }
            }
            String sb2 = sb.toString();
            com.google.android.gms.ads.internal.util.client.zzo.zzg(sb2);
            status = new Status(13, sb2);
        } else {
            status = Status.RESULT_SUCCESS;
        }
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        Preconditions.checkArgument(status.isSuccess(), statusMessage);
        synchronized (this.zzg) {
            ArrayList arrayList = new ArrayList();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(com.google.android.gms.ads.internal.util.client.zzf.zze(context, (PreloadConfiguration) it5.next(), 1));
            }
            try {
                com.google.android.gms.ads.zzb.zza(context).zzp(arrayList, new zzet(this, preloadCallback));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to start preload.", e);
                return Status.RESULT_INTERNAL_ERROR;
            }
        }
        return Status.RESULT_SUCCESS;
    }

    public final String zzj() {
        String zzc;
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc = zzfwg.zzc(this.zzl.zzf());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to get internal version.", e);
                return "";
            }
        }
        return zzc;
    }

    public final void zzp(Context context) {
        synchronized (this.zzk) {
            zzC(context);
            try {
                this.zzl.zzi();
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzf) {
            if (this.zzi) {
                if (onInitializationCompleteListener != null) {
                    this.zzh.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.zzj) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(zze());
                }
                return;
            }
            this.zzi = true;
            if (onInitializationCompleteListener != null) {
                this.zzh.add(onInitializationCompleteListener);
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            synchronized (this.zzk) {
                zzex zzexVar = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                try {
                    zzC(context);
                    this.zzl.zzs(new zzew(this, zzexVar));
                    this.zzl.zzo(new zzbpm());
                    if (this.zzn.getTagForChildDirectedTreatment() != -1 || this.zzn.getTagForUnderAgeOfConsent() != -1) {
                        zzD(this.zzn);
                    }
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("MobileAdsSettingManager initialization failed", e);
                }
                zzbde.zza(context);
                if (((Boolean) zzbfc.zza.zze()).booleanValue()) {
                    if (((Boolean) zzbd.zzc().zzb(zzbde.zzlD)).booleanValue()) {
                        com.google.android.gms.ads.internal.util.client.zzo.zze("Initializing on bg thread");
                        ThreadPoolExecutor threadPoolExecutor = com.google.android.gms.ads.internal.util.client.zzb.zza;
                        final Object[] objArr3 = objArr2 == true ? 1 : 0;
                        threadPoolExecutor.execute(new Runnable(objArr3) { // from class: com.google.android.gms.ads.internal.client.zzer
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzey.zzm(zzey.this, null);
                            }
                        });
                        this.zzc = new zzep(context);
                        this.zzd = new zzfc(context);
                        this.zze = new zzeo(context);
                    }
                }
                if (((Boolean) zzbfc.zzb.zze()).booleanValue()) {
                    if (((Boolean) zzbd.zzc().zzb(zzbde.zzlD)).booleanValue()) {
                        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
                        final Object[] objArr4 = objArr == true ? 1 : 0;
                        executorService.execute(new Runnable(objArr4) { // from class: com.google.android.gms.ads.internal.client.zzes
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzey.zzl(zzey.this, null);
                            }
                        });
                        this.zzc = new zzep(context);
                        this.zzd = new zzfc(context);
                        this.zze = new zzeo(context);
                    }
                }
                com.google.android.gms.ads.internal.util.client.zzo.zze("Initializing on calling thread");
                zzB(null);
                this.zzc = new zzep(context);
                this.zzd = new zzfc(context);
                this.zze = new zzeo(context);
            }
        }
    }

    public final void zzr(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzk) {
            zzC(context);
            this.zzm = onAdInspectorClosedListener;
            try {
                this.zzl.zzm(new zzev(null));
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzs(Context context, String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzl.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzt(Class cls) {
        synchronized (this.zzk) {
            try {
                this.zzl.zzh(cls.getCanonicalName());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void zzu(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzl.zzp(z);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzv(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzk) {
            if (this.zzl == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzl.zzq(f);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to set app volume.", e);
            }
        }
    }

    public final void zzw(String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzl.zzt(str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to set plugin.", e);
            }
        }
    }

    public final void zzx(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.zzk) {
            RequestConfiguration requestConfiguration2 = this.zzn;
            this.zzn = requestConfiguration;
            if (this.zzl == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zzD(requestConfiguration);
            }
        }
    }

    public final boolean zzz(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            try {
                this.zzl.zzj(z);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to " + (z ? a.j : "disable") + " the publisher first-party ID.", e);
                return false;
            }
        }
        return true;
    }

    public final float zza() {
        synchronized (this.zzk) {
            zzdb zzdbVar = this.zzl;
            float f = 1.0f;
            if (zzdbVar == null) {
                return 1.0f;
            }
            try {
                f = zzdbVar.zze();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to get app volume.", e);
            }
            return f;
        }
    }

    public final boolean zzy() {
        synchronized (this.zzk) {
            zzdb zzdbVar = this.zzl;
            boolean z = false;
            if (zzdbVar == null) {
                return false;
            }
            try {
                z = zzdbVar.zzv();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to get app mute state.", e);
            }
            return z;
        }
    }
}
