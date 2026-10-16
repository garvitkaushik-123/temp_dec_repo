package com.google.android.gms.internal.ads;

import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdsu {
    private final String zze;
    private final zzdso zzf;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final com.google.android.gms.ads.internal.util.zzg zza = com.google.android.gms.ads.internal.zzv.zzp().zzi();

    public zzdsu(String str, zzdso zzdsoVar) {
        this.zze = str;
        this.zzf = zzdsoVar;
    }

    private final Map zzg() {
        Map zza = this.zzf.zza();
        zza.put("tms", Long.toString(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime(), 10));
        zza.put(ScarConstants.TOKEN_ID_KEY, this.zza.zzN() ? "" : this.zze);
        return zza;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "aaia");
            zzg.put("aair", "MalformedJson");
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_finished");
            zzg.put("ancn", str);
            zzg.put("rqe", str2);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_started");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_finished");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue() && !this.zzd) {
            Map zzg = zzg();
            zzg.put("action", "init_finished");
            List list = this.zzb;
            list.add(zzg);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzf.zzg((Map) it.next());
            }
            this.zzd = true;
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcl)).booleanValue() && !this.zzc) {
            Map zzg = zzg();
            zzg.put("action", "init_started");
            this.zzb.add(zzg);
            this.zzc = true;
        }
    }
}
