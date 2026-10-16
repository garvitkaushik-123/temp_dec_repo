package com.google.android.gms.internal.ads;

import com.unity3d.services.core.di.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzij implements zzkx {
    private final zzzm zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final HashMap zzg;
    private long zzh;

    public zzij() {
        zzzm zzzmVar = new zzzm(true, 65536);
        zzl(1000, 0, "bufferForPlaybackMs", "0");
        zzl(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzl(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        zzl(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzl(50000, 50000, "maxBufferMs", "minBufferMs");
        zzl(0, 0, "backBufferDurationMs", "0");
        this.zza = zzzmVar;
        this.zzb = zzex.zzs(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzc = zzex.zzs(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzd = zzex.zzs(1000L);
        this.zze = zzex.zzs(2000L);
        this.zzf = zzex.zzs(0L);
        this.zzg = new HashMap();
        this.zzh = -1L;
    }

    private static void zzl(int i, int i2, String str, String str2) {
        zzdd.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzm(zzph zzphVar) {
        if (this.zzg.remove(zzphVar) != null) {
            zzn();
        }
    }

    private final void zzn() {
        if (this.zzg.isEmpty()) {
            this.zza.zze();
        } else {
            this.zza.zzf(zza());
        }
    }

    final int zza() {
        Iterator it = this.zzg.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((zzih) it.next()).zzb;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final long zzb(zzph zzphVar) {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzc(zzph zzphVar) {
        long id = Thread.currentThread().getId();
        long j = this.zzh;
        boolean z = true;
        if (j != -1 && j != id) {
            z = false;
        }
        zzdd.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzh = id;
        HashMap hashMap = this.zzg;
        if (!hashMap.containsKey(zzphVar)) {
            hashMap.put(zzphVar, new zzih(null));
        }
        zzih zzihVar = (zzih) hashMap.get(zzphVar);
        zzihVar.getClass();
        zzihVar.zzb = 13107200;
        zzihVar.zza = false;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzd(zzph zzphVar) {
        zzm(zzphVar);
        if (this.zzg.isEmpty()) {
            this.zzh = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zze(zzph zzphVar) {
        zzm(zzphVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzf(zzkw zzkwVar, zzxk zzxkVar, zzyw[] zzywVarArr) {
        zzih zzihVar = (zzih) this.zzg.get(zzkwVar.zza);
        zzihVar.getClass();
        int length = zzywVarArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 13107200;
            if (i >= length) {
                zzihVar.zzb = Math.max(13107200, i2);
                zzn();
                return;
            }
            zzyw zzywVar = zzywVarArr[i];
            if (zzywVar != null) {
                switch (zzywVar.zzc().zzc) {
                    case -1:
                    case 1:
                        break;
                    case 0:
                        i3 = 144310272;
                        break;
                    case 2:
                        i3 = 131072000;
                        break;
                    case 3:
                    case 5:
                    default:
                        i3 = 131072;
                        break;
                    case 4:
                        i3 = 26214400;
                        break;
                }
                i2 += i3;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzg(zzph zzphVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzh(zzkw zzkwVar) {
        zzih zzihVar = (zzih) this.zzg.get(zzkwVar.zza);
        zzihVar.getClass();
        int zza = this.zza.zza();
        int zza2 = zza();
        long j = this.zzb;
        float f = zzkwVar.zzc;
        if (f > 1.0f) {
            j = Math.min(zzex.zzq(j, f), this.zzc);
        }
        long j2 = zzkwVar.zzb;
        if (j2 < Math.max(j, 500000L)) {
            boolean z = zza < zza2;
            zzihVar.zza = z;
            if (!z && j2 < 500000) {
                zzea.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzc || zza >= zza2) {
            zzihVar.zza = false;
        }
        return zzihVar.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzi(zzbl zzblVar, zzvh zzvhVar, long j) {
        Iterator it = this.zzg.values().iterator();
        while (it.hasNext()) {
            if (((zzih) it.next()).zza) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzj(zzkw zzkwVar) {
        boolean z = zzkwVar.zzd;
        long zzr = zzex.zzr(zzkwVar.zzb, zzkwVar.zzc);
        long j = z ? this.zze : this.zzd;
        long j2 = zzkwVar.zze;
        if (j2 != -9223372036854775807L) {
            j = Math.min(j2 / 2, j);
        }
        return j <= 0 || zzr >= j || this.zza.zza() >= zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final zzzm zzk() {
        return this.zza;
    }
}
