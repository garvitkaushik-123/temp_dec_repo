package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzak {
    public final Uri zza;
    public final String zzb;
    public final zzah zzc;
    public final zzac zzd;
    public final List zze;
    public final String zzf;
    public final zzfyq zzg;
    public final Object zzh;
    public final long zzi;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    /* synthetic */ zzak(Uri uri, String str, zzah zzahVar, zzac zzacVar, List list, String str2, zzfyq zzfyqVar, Object obj, long j, zzao zzaoVar) {
        this.zza = uri;
        int i = zzay.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfyqVar;
        int i2 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        if (zzfyqVar.size() > 0) {
            throw null;
        }
        zzfynVar.zzi();
        this.zzh = null;
        this.zzi = -9223372036854775807L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        if (this.zza.equals(zzakVar.zza)) {
            String str = zzakVar.zzb;
            if (Objects.equals(null, null)) {
                zzah zzahVar = zzakVar.zzc;
                if (Objects.equals(null, null)) {
                    zzac zzacVar = zzakVar.zzd;
                    if (Objects.equals(null, null) && this.zze.equals(zzakVar.zze)) {
                        String str2 = zzakVar.zzf;
                        if (Objects.equals(null, null) && this.zzg.equals(zzakVar.zzg)) {
                            Object obj2 = zzakVar.zzh;
                            if (Objects.equals(null, null)) {
                                long j = zzakVar.zzi;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) (((((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31) * 31) - Long.MAX_VALUE);
    }
}
