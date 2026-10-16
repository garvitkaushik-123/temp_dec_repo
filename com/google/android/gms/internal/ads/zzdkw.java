package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzdkw implements zzdjb, zzdax {
    private final zzbqf zza;
    private final zzcwq zzb;
    private final zzcym zzc;
    private final zzcvw zzd;
    private final zzdeb zze;
    private final Context zzf;
    private final zzfca zzg;
    private final VersionInfoParcel zzh;
    private final zzfcw zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = true;
    private final zzbqb zzm;
    private final zzbqc zzn;

    public zzdkw(zzbqb zzbqbVar, zzbqc zzbqcVar, zzbqf zzbqfVar, zzcwq zzcwqVar, zzcym zzcymVar, zzcvw zzcvwVar, zzdeb zzdebVar, Context context, zzfca zzfcaVar, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar) {
        this.zzm = zzbqbVar;
        this.zzn = zzbqcVar;
        this.zza = zzbqfVar;
        this.zzb = zzcwqVar;
        this.zzc = zzcymVar;
        this.zzd = zzcvwVar;
        this.zze = zzdebVar;
        this.zzf = context;
        this.zzg = zzfcaVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzfcwVar;
    }

    private final void zzc(View view) {
        try {
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar != null && !zzbqfVar.zzA()) {
                zzbqfVar.zzw(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzli)).booleanValue()) {
                    this.zze.zzdf();
                    return;
                }
                return;
            }
            zzbqb zzbqbVar = this.zzm;
            if (zzbqbVar != null && !zzbqbVar.zzx()) {
                zzbqbVar.zzs(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzli)).booleanValue()) {
                    this.zze.zzdf();
                    return;
                }
                return;
            }
            zzbqc zzbqcVar = this.zzn;
            if (zzbqcVar == null || zzbqcVar.zzv()) {
                return;
            }
            zzbqcVar.zzq(ObjectWrapper.wrap(view));
            this.zzd.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzli)).booleanValue()) {
                this.zze.zzdf();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzd(Map map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzA(zzbig zzbigVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzB(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        IObjectWrapper zzn;
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzg.zzaj;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbJ)).booleanValue() && jSONObject.length() != 0) {
                Map hashMap = map == null ? new HashMap() : map;
                Map hashMap2 = map2 == null ? new HashMap() : map2;
                HashMap hashMap3 = new HashMap();
                hashMap3.putAll(hashMap);
                hashMap3.putAll(hashMap2);
                Iterator<String> keys = jSONObject.keys();
                loop0: while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    if (optJSONArray != null) {
                        WeakReference weakReference = (WeakReference) hashMap3.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbK)).booleanValue() && next.equals("3010")) {
                                zzbqf zzbqfVar = this.zza;
                                Object obj2 = null;
                                if (zzbqfVar != null) {
                                    try {
                                        zzn = zzbqfVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbqb zzbqbVar = this.zzm;
                                    if (zzbqbVar != null) {
                                        zzn = zzbqbVar.zzk();
                                    } else {
                                        zzbqc zzbqcVar = this.zzn;
                                        zzn = zzbqcVar != null ? zzbqcVar.zzj() : null;
                                    }
                                }
                                if (zzn != null) {
                                    obj2 = ObjectWrapper.unwrap(zzn);
                                }
                                if (obj2 != null) {
                                    cls = obj2.getClass();
                                }
                            }
                            try {
                                ArrayList arrayList = new ArrayList();
                                com.google.android.gms.ads.internal.util.zzbs.zzc(optJSONArray, arrayList);
                                com.google.android.gms.ads.internal.zzv.zzr();
                                ClassLoader classLoader = this.zzf.getClassLoader();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                        break;
                                    }
                                }
                            } catch (JSONException unused2) {
                                continue;
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzl = z;
            HashMap zzd = zzd(map);
            HashMap zzd2 = zzd(map2);
            zzbqf zzbqfVar2 = this.zza;
            if (zzbqfVar2 != null) {
                zzbqfVar2.zzy(wrap, ObjectWrapper.wrap(zzd), ObjectWrapper.wrap(zzd2));
                return;
            }
            zzbqb zzbqbVar2 = this.zzm;
            if (zzbqbVar2 != null) {
                zzbqbVar2.zzv(wrap, ObjectWrapper.wrap(zzd), ObjectWrapper.wrap(zzd2));
                zzbqbVar2.zzu(wrap);
                return;
            }
            zzbqc zzbqcVar2 = this.zzn;
            if (zzbqcVar2 != null) {
                zzbqcVar2.zzt(wrap, ObjectWrapper.wrap(zzd), ObjectWrapper.wrap(zzd2));
                zzbqcVar2.zzs(wrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzC(View view, Map map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar != null) {
                zzbqfVar.zzz(wrap);
                return;
            }
            zzbqb zzbqbVar = this.zzm;
            if (zzbqbVar != null) {
                zzbqbVar.zzw(wrap);
                return;
            }
            zzbqc zzbqcVar = this.zzn;
            if (zzbqcVar != null) {
                zzbqcVar.zzu(wrap);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzD() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzE() {
        return this.zzg.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzF(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdq() {
        try {
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar == null || !zzbqfVar.zzB()) {
                return;
            }
            zzfca zzfcaVar = this.zzg;
            if (zzfcaVar.zze == 4 || zzfcaVar.zzaC) {
                zzbqfVar.zzx();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to report impression from an adapter", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzg(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzi() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzl(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzm(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzk && this.zzg.zzL) {
            return;
        }
        zzc(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzo(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzq(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzk) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzg.zzL) {
            zzc(view2);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzr(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzt(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzj) {
                this.zzj = com.google.android.gms.ads.internal.zzv.zzu().zzn(this.zzf, this.zzh.afmaVersion, this.zzg.zzC.toString(), this.zzi.zzf);
            }
            if (this.zzl) {
                zzbqf zzbqfVar = this.zza;
                if (zzbqfVar == null) {
                    zzbqb zzbqbVar = this.zzm;
                    if (zzbqbVar != null && !zzbqbVar.zzy()) {
                        zzbqbVar.zzt();
                        this.zzb.zza();
                        return;
                    }
                    zzbqc zzbqcVar = this.zzn;
                    if (zzbqcVar == null || zzbqcVar.zzw()) {
                        return;
                    }
                    zzbqcVar.zzr();
                    this.zzb.zza();
                    return;
                }
                zzfca zzfcaVar = this.zzg;
                if (zzfcaVar.zzaC) {
                    if (zzbqfVar.zzB()) {
                        return;
                    }
                    zzbqfVar.zzx();
                    this.zzb.zza();
                    return;
                }
                if (zzbqfVar.zzB() && zzfcaVar.zze == 4) {
                    this.zzc.zza();
                } else {
                    zzbqfVar.zzx();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzv(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzw(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzx(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzy() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzz(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }
}
