package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdun {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdpz zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsu zzl;
    private final VersionInfoParcel zzm;
    private final zzddc zzo;
    private final zzfhx zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzcak zze = new zzcak();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();

    public zzdun(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdpz zzdpzVar, ScheduledExecutorService scheduledExecutorService, zzdsu zzdsuVar, VersionInfoParcel versionInfoParcel, zzddc zzddcVar, zzfhx zzfhxVar) {
        this.zzh = zzdpzVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsuVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzddcVar;
        this.zzp = zzfhxVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* synthetic */ Object zzf(zzdun zzdunVar, zzfhj zzfhjVar) {
        zzdunVar.zze.zzc(true);
        zzfhjVar.zzg(true);
        zzdunVar.zzp.zzc(zzfhjVar.zzm());
        return null;
    }

    public static /* synthetic */ void zzi(zzdun zzdunVar, Object obj, zzcak zzcakVar, String str, long j, zzfhj zzfhjVar) {
        synchronized (obj) {
            if (!zzcakVar.isDone()) {
                zzdunVar.zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - j));
                zzdunVar.zzl.zzb(str, "timeout");
                zzdunVar.zzo.zzb(str, "timeout");
                zzfhx zzfhxVar = zzdunVar.zzp;
                zzfhjVar.zzc(AndroidInitializeBoldSDK.MSG_TIMEOUT);
                zzfhjVar.zzg(false);
                zzfhxVar.zzc(zzfhjVar.zzm());
                zzcakVar.zzc(false);
            }
        }
    }

    public static /* synthetic */ void zzj(zzdun zzdunVar) {
        zzdunVar.zzl.zze();
        zzdunVar.zzo.zze();
        zzdunVar.zzb = true;
    }

    public static /* synthetic */ void zzl(zzdun zzdunVar) {
        synchronized (zzdunVar) {
            if (zzdunVar.zzc) {
                return;
            }
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - zzdunVar.zzd));
            zzdunVar.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            zzdunVar.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            zzdunVar.zze.zzd(new Exception());
        }
    }

    public static /* synthetic */ void zzm(zzdun zzdunVar, String str, zzbmh zzbmhVar, zzfdu zzfduVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbmhVar.zzf();
                    return;
                }
                Context context = (Context) zzdunVar.zzg.get();
                if (context == null) {
                    context = zzdunVar.zzf;
                }
                zzfduVar.zzi(context, zzbmhVar, list);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            }
        } catch (RemoteException e2) {
            throw new zzfwn(e2);
        } catch (zzfdd unused) {
            zzbmhVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzdun zzdunVar, String str) {
        final zzdun zzdunVar2 = zzdunVar;
        Context context = zzdunVar2.zzf;
        int i = 5;
        final zzfhj zza = zzfhi.zza(context, 5);
        zza.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final zzfhj zza2 = zzfhi.zza(context, i);
                zza2.zzi();
                zza2.zzd(next);
                final Object obj = new Object();
                final zzcak zzcakVar = new zzcak();
                ListenableFuture zzo = zzgdn.zzo(zzcakVar, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzca)).longValue(), TimeUnit.SECONDS, zzdunVar2.zzk);
                zzdunVar2.zzl.zzc(next);
                zzdunVar2.zzo.zzc(next);
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
                zzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdud
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdun.zzi(zzdun.this, obj, zzcakVar, next, elapsedRealtime, zza2);
                    }
                }, zzdunVar2.zzi);
                arrayList.add(zzo);
                try {
                    try {
                        final zzdum zzdumVar = new zzdum(zzdunVar, obj, next, elapsedRealtime, zza2, zzcakVar);
                        zzdunVar2 = zzdunVar;
                        JSONObject optJSONObject = jSONObject.optJSONObject(next);
                        final ArrayList arrayList2 = new ArrayList();
                        if (optJSONObject != null) {
                            try {
                                JSONArray jSONArray = optJSONObject.getJSONArray("data");
                                int i2 = 0;
                                while (i2 < jSONArray.length()) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                    String optString = jSONObject2.optString("format", "");
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys2 = optJSONObject2.keys();
                                        while (keys2.hasNext()) {
                                            String next2 = keys2.next();
                                            bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                            jSONArray = jSONArray;
                                        }
                                    }
                                    JSONArray jSONArray2 = jSONArray;
                                    arrayList2.add(new zzbmn(optString, bundle));
                                    i2++;
                                    jSONArray = jSONArray2;
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        zzdunVar2.zzv(next, false, "", 0);
                        try {
                            final zzfdu zzc = zzdunVar2.zzh.zzc(next, new JSONObject());
                            zzdunVar2.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdui
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdun.zzm(zzdun.this, next, zzdumVar, zzc, arrayList2);
                                }
                            });
                        } catch (zzfdd e) {
                            try {
                                String str2 = "Failed to create Adapter.";
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzns)).booleanValue()) {
                                    str2 = "Failed to create Adapter. " + e.getMessage();
                                }
                                zzdumVar.zze(str2);
                            } catch (RemoteException e2) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
                            }
                        }
                        i = 5;
                    } catch (JSONException e3) {
                        e = e3;
                        zzdunVar2 = zzdunVar;
                        com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e);
                        zzdunVar2.zzo.zza("MalformedJson");
                        zzdunVar2.zzl.zza("MalformedJson");
                        zzdunVar2.zze.zzd(e);
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdapterInitializer.updateAdapterStatus");
                        zzfhx zzfhxVar = zzdunVar2.zzp;
                        zza.zzh(e);
                        zza.zzg(false);
                        zzfhxVar.zzc(zza.zzm());
                        return;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    zzdunVar2 = zzdunVar;
                }
            }
            zzgdn.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdue
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdun.zzf(zzdun.this, zza);
                    return null;
                }
            }, zzdunVar2.zzi);
        } catch (JSONException e5) {
            e = e5;
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            return zzgdn.zzh(zzc);
        }
        final zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduf
            @Override // java.lang.Runnable
            public final void run() {
                r0.zzi.execute(new Runnable(zzdun.this, zzcakVar) { // from class: com.google.android.gms.internal.ads.zzduh
                    public final /* synthetic */ zzcak zza;

                    {
                        this.zza = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        String zzc2 = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc();
                        boolean isEmpty = TextUtils.isEmpty(zzc2);
                        zzcak zzcakVar2 = this.zza;
                        if (isEmpty) {
                            zzcakVar2.zzd(new Exception());
                        } else {
                            zzcakVar2.zzc(zzc2);
                        }
                    }
                });
            }
        });
        return zzcakVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbmd(str, z, i, str2));
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        Map map = this.zzn;
        for (String str : map.keySet()) {
            zzbmd zzbmdVar = (zzbmd) map.get(str);
            arrayList.add(new zzbmd(str, zzbmdVar.zzb, zzbmdVar.zzc, zzbmdVar.zzd));
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzq = false;
    }

    public final void zzr() {
        if (!((Boolean) zzbfk.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbZ)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    zzcak zzcakVar = this.zze;
                    Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzduj
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdun.zzj(zzdun.this);
                        }
                    };
                    Executor executor = this.zzi;
                    zzcakVar.addListener(runnable, executor);
                    this.zza = true;
                    ListenableFuture zzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduc
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdun.zzl(zzdun.this);
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcb)).longValue(), TimeUnit.SECONDS);
                    zzgdn.zzr(zzu, new zzdul(this), executor);
                    return;
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(false);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzbmk zzbmkVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdug
            @Override // java.lang.Runnable
            public final void run() {
                zzdun zzdunVar = zzdun.this;
                try {
                    zzbmkVar.zzb(zzdunVar.zzg());
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
