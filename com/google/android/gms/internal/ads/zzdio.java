package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdio extends zzcra {
    public static final zzfyq zzc = zzfyq.zzs("3010", "3008", "1005", "1009", "2011", "2007");
    private final List zzA;
    private final Executor zzd;
    private final zzdit zze;
    private final zzdjb zzf;
    private final zzdjt zzg;
    private final zzdiy zzh;
    private final zzdje zzi;
    private final zzhgl zzj;
    private final zzhgl zzk;
    private final zzhgl zzl;
    private final zzhgl zzm;
    private final zzhgl zzn;
    private zzdkr zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private final zzbyk zzt;
    private final zzavu zzu;
    private final VersionInfoParcel zzv;
    private final Context zzw;
    private final zzdiq zzx;
    private final zzelb zzy;
    private final Map zzz;

    public zzdio(zzcqz zzcqzVar, Executor executor, zzdit zzditVar, zzdjb zzdjbVar, zzdjt zzdjtVar, zzdiy zzdiyVar, zzdje zzdjeVar, zzhgl zzhglVar, zzhgl zzhglVar2, zzhgl zzhglVar3, zzhgl zzhglVar4, zzhgl zzhglVar5, zzbyk zzbykVar, zzavu zzavuVar, VersionInfoParcel versionInfoParcel, Context context, zzdiq zzdiqVar, zzelb zzelbVar, zzazf zzazfVar) {
        super(zzcqzVar);
        this.zzd = executor;
        this.zze = zzditVar;
        this.zzf = zzdjbVar;
        this.zzg = zzdjtVar;
        this.zzh = zzdiyVar;
        this.zzi = zzdjeVar;
        this.zzj = zzhglVar;
        this.zzk = zzhglVar2;
        this.zzl = zzhglVar3;
        this.zzm = zzhglVar4;
        this.zzn = zzhglVar5;
        this.zzt = zzbykVar;
        this.zzu = zzavuVar;
        this.zzv = versionInfoParcel;
        this.zzw = context;
        this.zzx = zzdiqVar;
        this.zzy = zzelbVar;
        this.zzz = new HashMap();
        this.zzA = new ArrayList();
    }

    public static boolean zzZ(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzla)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        long zzx = com.google.android.gms.ads.internal.util.zzs.zzx(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (zzx >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlb)).intValue()) {
                return true;
            }
        }
        return false;
    }

    private final synchronized View zzab(Map map) {
        if (map != null) {
            zzfyq zzfyqVar = zzc;
            int size = zzfyqVar.size();
            int i = 0;
            while (i < size) {
                WeakReference weakReference = (WeakReference) map.get((String) zzfyqVar.get(i));
                i++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    private final synchronized ImageView.ScaleType zzac() {
        zzdkr zzdkrVar = this.zzo;
        if (zzdkrVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj = zzdkrVar.zzj();
        if (zzj != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj);
        }
        return zzdjt.zza;
    }

    private final void zzad(String str, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfG)).booleanValue()) {
            zzf("Google", true);
            return;
        }
        ListenableFuture zzw = this.zze.zzw();
        if (zzw == null) {
            return;
        }
        zzgdn.zzr(zzw, new zzdim(this, "Google", true), this.zzd);
    }

    private final synchronized void zzae(View view, Map map, Map map2) {
        View zzab;
        if (!this.zzr && (zzab = zzab(map)) != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznM)).booleanValue()) {
                Rect rect = new Rect();
                if (zzab.getGlobalVisibleRect(rect, new Point()) && zzab.getHeight() == rect.height() && zzab.getWidth() == rect.width()) {
                    this.zzf.zzr(view, map, map2, zzac());
                    this.zzr = true;
                }
            } else if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznN)).booleanValue()) {
                zzbcv zzbcvVar = zzbde.zznO;
                if (((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).floatValue() > 0.0d) {
                    double floatValue = ((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).floatValue();
                    if (zzab.getGlobalVisibleRect(new Rect(), new Point())) {
                        if (r1.height() * r1.width() >= zzab.getHeight() * zzab.getWidth() * (floatValue / 100.0d)) {
                            this.zzf.zzr(view, map, map2, zzac());
                            this.zzr = true;
                        }
                    }
                }
            } else if (zzZ(zzab)) {
                this.zzf.zzr(view, map, map2, zzac());
                this.zzr = true;
            }
        }
    }

    private final synchronized void zzaf(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzt(view, map, map2, zzac());
        this.zzq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag(View view, zzedh zzedhVar) {
        zzcfg zzr = this.zze.zzr();
        if (!this.zzh.zzd() || zzedhVar == null || zzr == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzC().zzj(zzedhVar.zza(), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzah(zzdkr zzdkrVar) {
        Iterator<String> keys;
        View view;
        zzavp zzc2;
        if (!this.zzp) {
            this.zzo = zzdkrVar;
            this.zzg.zze(zzdkrVar);
            this.zzf.zzB(zzdkrVar.zzf(), zzdkrVar.zzm(), zzdkrVar.zzn(), zzdkrVar, zzdkrVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcT)).booleanValue() && (zzc2 = this.zzu.zzc()) != null) {
                zzc2.zzo(zzdkrVar.zzf());
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbW)).booleanValue()) {
                zzfca zzfcaVar = this.zzb;
                if (zzfcaVar.zzak && (keys = zzfcaVar.zzaj.keys()) != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        zzdkr zzdkrVar2 = this.zzo;
                        WeakReference weakReference = zzdkrVar2 == null ? null : (WeakReference) zzdkrVar2.zzl().get(next);
                        this.zzz.put(next, false);
                        if (weakReference != null && (view = (View) weakReference.get()) != null) {
                            zzaze zzazeVar = new zzaze(this.zzw, view);
                            this.zzA.add(zzazeVar);
                            zzazeVar.zzd(new zzdil(this, next));
                        }
                    }
                }
            }
            if (zzdkrVar.zzi() != null) {
                zzdkrVar.zzi().zzd(this.zzt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai(zzdkr zzdkrVar) {
        this.zzf.zzC(zzdkrVar.zzf(), zzdkrVar.zzl());
        if (zzdkrVar.zzh() != null) {
            zzdkrVar.zzh().setClickable(false);
            zzdkrVar.zzh().removeAllViews();
        }
        if (zzdkrVar.zzi() != null) {
            zzdkrVar.zzi().zze(this.zzt);
        }
        this.zzo = null;
    }

    public static /* synthetic */ void zzt(zzdio zzdioVar, boolean z) {
        zzdkr zzdkrVar = zzdioVar.zzo;
        if (zzdkrVar != null) {
            zzdioVar.zzf.zzq(null, zzdkrVar.zzf(), zzdioVar.zzo.zzl(), zzdioVar.zzo.zzm(), z, zzdioVar.zzac(), 0);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        }
    }

    public static /* synthetic */ void zzv(zzdio zzdioVar, View view, boolean z, int i) {
        zzdkr zzdkrVar = zzdioVar.zzo;
        if (zzdkrVar != null) {
            zzdioVar.zzf.zzq(view, zzdkrVar.zzf(), zzdioVar.zzo.zzl(), zzdioVar.zzo.zzm(), z, zzdioVar.zzac(), i);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
        }
    }

    public static /* synthetic */ void zzw(zzdio zzdioVar) {
        zzdioVar.zzf.zzk();
        zzdioVar.zze.zzI();
    }

    public final void zzA(View view) {
        zzedh zzu = this.zze.zzu();
        if (!this.zzh.zzd() || zzu == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzC().zzg(zzu.zza(), view);
    }

    public final synchronized void zzB() {
        this.zzf.zzj();
    }

    public final synchronized void zzC(View view, Map map, Map map2, boolean z) {
        if (this.zzq) {
            zzae(view, map, map2);
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbW)).booleanValue() && this.zzb.zzak) {
            Map map3 = this.zzz;
            Iterator it = map3.keySet().iterator();
            while (it.hasNext()) {
                if (!((Boolean) map3.get((String) it.next())).booleanValue()) {
                    break;
                }
            }
        }
        if (z) {
            zzaf(view, map, map2);
            zzae(view, map, map2);
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeh)).booleanValue() && map != null) {
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                View view2 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (view2 != null && zzZ(view2)) {
                    zzaf(view, map, map2);
                    return;
                }
            }
        }
    }

    public final synchronized void zzD(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        this.zzf.zzl(zzdjVar);
    }

    public final synchronized void zzE(View view, View view2, Map map, Map map2, boolean z) {
        zzcfg zzs;
        this.zzg.zzc(this.zzo);
        this.zzf.zzm(view, view2, map, map2, z, zzac());
        if (this.zzs) {
            zzdit zzditVar = this.zze;
            if (zzditVar.zzs() != null && (zzs = zzditVar.zzs()) != null) {
                zzs.zzd("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzF(final View view, final int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlW)).booleanValue()) {
            zzdkr zzdkrVar = this.zzo;
            if (zzdkrVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdkrVar instanceof zzdjn;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdii
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdio.zzv(zzdio.this, view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized void zzG(String str) {
        this.zzf.zzn(str);
    }

    public final synchronized void zzH(Bundle bundle) {
        this.zzf.zzo(bundle);
    }

    public final synchronized void zzI() {
        zzdkr zzdkrVar = this.zzo;
        if (zzdkrVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdkrVar instanceof zzdjn;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdik
                @Override // java.lang.Runnable
                public final void run() {
                    zzdio.zzt(zzdio.this, z);
                }
            });
        }
    }

    public final void zzJ(Bundle bundle) {
        final zzcfg zzs = this.zze.zzs();
        if (zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Video webview is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdih
                @Override // java.lang.Runnable
                public final void run() {
                    zzfyq zzfyqVar = zzdio.zzc;
                    zzcfg.this.zze("onVideoEvent", jSONObject);
                }
            });
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error reading event signals", e);
        }
    }

    public final synchronized void zzK() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzu();
    }

    public final void zzL(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfG)).booleanValue()) {
            zzdit zzditVar = this.zze;
            if (zzditVar.zzc() != 3) {
                zzcak zzp = zzditVar.zzp();
                if (zzp == null) {
                    return;
                }
                zzgdn.zzr(zzp, new zzdin(this, view), this.zzd);
                return;
            }
        }
        zzag(view, this.zze.zzu());
    }

    public final synchronized void zzM(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzv(view, motionEvent, view2);
    }

    public final synchronized void zzN(Bundle bundle) {
        this.zzf.zzw(bundle);
    }

    public final synchronized void zzO(View view) {
        this.zzf.zzx(view);
    }

    public final synchronized void zzP() {
        this.zzf.zzy();
    }

    public final synchronized void zzQ(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.zzf.zzz(zzdfVar);
    }

    public final synchronized void zzR(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zzy.zza(zzdtVar);
    }

    public final synchronized void zzS(zzbig zzbigVar) {
        this.zzf.zzA(zzbigVar);
    }

    public final synchronized void zzT(final zzdkr zzdkrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdid
                @Override // java.lang.Runnable
                public final void run() {
                    zzdio.this.zzah(zzdkrVar);
                }
            });
        } else {
            zzah(zzdkrVar);
        }
    }

    public final synchronized void zzU(final zzdkr zzdkrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdie
                @Override // java.lang.Runnable
                public final void run() {
                    zzdio.this.zzai(zzdkrVar);
                }
            });
        } else {
            zzai(zzdkrVar);
        }
    }

    public final boolean zzV() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzW() {
        return this.zzf.zzD();
    }

    public final synchronized boolean zzX() {
        return this.zzf.zzE();
    }

    public final boolean zzY() {
        return this.zzh.zzd();
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized boolean zzaa(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzF = this.zzf.zzF(bundle);
        this.zzq = zzF;
        return zzF;
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdij
            @Override // java.lang.Runnable
            public final void run() {
                zzdio.zzw(zzdio.this);
            }
        });
        super.zzb();
    }

    public final zzdiq zzc() {
        return this.zzx;
    }

    public final zzedh zzf(String str, boolean z) {
        boolean z2;
        String str2;
        zzedd zzeddVar;
        zzede zzedeVar;
        zzdiy zzdiyVar = this.zzh;
        if (zzdiyVar.zzd() && !TextUtils.isEmpty(str)) {
            zzdit zzditVar = this.zze;
            zzcfg zzr = zzditVar.zzr();
            zzcfg zzs = zzditVar.zzs();
            if (zzr == null && zzs == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdiyVar.zza();
            int zzc2 = zzdiyVar.zza().zzc();
            int i2 = zzc2 - 1;
            boolean z3 = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    String str3 = "Unknown omid media type: " + (zzc2 != 1 ? zzc2 != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO") + ". Not initializing Omid.";
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj(str3);
                    return null;
                }
                if (zzr == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            } else if (zzs != null) {
                z2 = true;
            } else {
                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was video but there was no video webview.");
            }
            if (z3) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzr = zzs;
            }
            if (zzr == null) {
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Webview is null in InternalNativeAd");
                return null;
            }
            if (!com.google.android.gms.ads.internal.zzv.zzC().zzl(this.zzw)) {
                int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.zzv;
            String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            if (z2) {
                zzeddVar = zzedd.VIDEO;
                zzedeVar = zzede.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeddVar = zzedd.NATIVE_DISPLAY;
                zzedeVar = zzditVar.zzc() == 3 ? zzede.UNSPECIFIED : zzede.ONE_PIXEL;
            }
            zzedh zzb = com.google.android.gms.ads.internal.zzv.zzC().zzb(str4, zzr.zzG(), "", "javascript", str2, str, zzedeVar, zzeddVar, this.zzb.zzal);
            if (zzb == null) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to create omid session in InternalNativeAd");
                return null;
            }
            zzditVar.zzW(zzb);
            zzr.zzat(zzb);
            if (z2) {
                zzfll zza = zzb.zza();
                if (zzs != null) {
                    com.google.android.gms.ads.internal.zzv.zzC().zzj(zza, zzs.zzF());
                }
                this.zzs = true;
            }
            if (z) {
                com.google.android.gms.ads.internal.zzv.zzC().zzk(zzb.zza());
                zzr.zzd("onSdkLoaded", new ArrayMap());
            }
            return zzb;
        }
        return null;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzac());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zzf.zzg(view, map, map2, zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final void zzk() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdif
            @Override // java.lang.Runnable
            public final void run() {
                zzdio.zzu(zzdio.this);
            }
        };
        Executor executor = this.zzd;
        executor.execute(runnable);
        if (this.zze.zzc() != 7) {
            final zzdjb zzdjbVar = this.zzf;
            Objects.requireNonNull(zzdjbVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdig
                @Override // java.lang.Runnable
                public final void run() {
                    zzdjb.this.zzs();
                }
            });
        }
        super.zzk();
    }

    public static /* synthetic */ void zzu(zzdio zzdioVar) {
        try {
            zzdit zzditVar = zzdioVar.zze;
            int zzc2 = zzditVar.zzc();
            if (zzc2 == 1) {
                zzbhq zzb = zzdioVar.zzi.zzb();
                if (zzb != null) {
                    zzdioVar.zzad("Google", true);
                    zzb.zze((zzbhg) zzdioVar.zzj.zzb());
                    return;
                }
                return;
            }
            if (zzc2 == 2) {
                zzbhn zza = zzdioVar.zzi.zza();
                if (zza != null) {
                    zzdioVar.zzad("Google", true);
                    zza.zze((zzbhe) zzdioVar.zzk.zzb());
                    return;
                }
                return;
            }
            if (zzc2 == 3) {
                zzbhw zzd = zzdioVar.zzi.zzd(zzditVar.zzA());
                if (zzd != null) {
                    if (zzditVar.zzs() != null) {
                        zzdioVar.zzf("Google", true);
                    }
                    zzd.zze((zzbhj) zzdioVar.zzn.zzb());
                    return;
                }
                return;
            }
            if (zzc2 == 6) {
                zzbid zzf = zzdioVar.zzi.zzf();
                if (zzf != null) {
                    zzdioVar.zzad("Google", true);
                    zzf.zze((zzbij) zzdioVar.zzl.zzb());
                    return;
                }
                return;
            }
            if (zzc2 != 7) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrong native template id!");
            } else {
                zzbmy zzg = zzdioVar.zzi.zzg();
                if (zzg != null) {
                    zzg.zzg((zzbms) zzdioVar.zzm.zzb());
                }
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
