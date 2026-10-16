package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdpw {
    private final Map zza = new HashMap();

    zzdpw() {
    }

    @Nullable
    public final synchronized zzdpv zza(String str) {
        return (zzdpv) this.zza.get(str);
    }

    public final String zzb(String str) {
        zzbse zzbseVar;
        zzdpv zza = zza(str);
        return (zza == null || (zzbseVar = zza.zzb) == null) ? "" : zzbseVar.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0019 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final synchronized void zzc(String str, @Nullable zzfdu zzfduVar) {
        zzbse zze;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbse zzbseVar = null;
        if (zzfduVar != null) {
            try {
                zze = zzfduVar.zze();
            } catch (zzfdd unused) {
            }
            if (zzfduVar != null) {
                try {
                    zzbseVar = zzfduVar.zzf();
                } catch (zzfdd unused2) {
                }
            }
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjM)).booleanValue()) {
                if (zzfduVar != null) {
                    try {
                        zzfduVar.zzC();
                    } catch (zzfdd unused3) {
                    }
                }
                z = false;
            }
            this.zza.put(str, new zzdpv(str, zze, zzbseVar, z));
        }
        zze = null;
        if (zzfduVar != null) {
        }
        boolean z2 = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjM)).booleanValue()) {
        }
        this.zza.put(str, new zzdpv(str, zze, zzbseVar, z2));
    }

    final synchronized void zzd(String str, zzbrp zzbrpVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdpv(str, zzbrpVar.zzf(), zzbrpVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
