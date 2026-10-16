package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzuj implements zzwa {
    private final zzaea zza;
    private zzadv zzb;
    private zzadw zzc;

    public zzuj(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final int zza(zzaer zzaerVar) throws IOException {
        zzadv zzadvVar = this.zzb;
        zzadvVar.getClass();
        zzadw zzadwVar = this.zzc;
        zzadwVar.getClass();
        return zzadvVar.zzb(zzadwVar, zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final long zzb() {
        zzadw zzadwVar = this.zzc;
        if (zzadwVar != null) {
            return zzadwVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zzc() {
        zzadv zzadvVar = this.zzb;
        if (zzadvVar != null && (zzadvVar instanceof zzaie)) {
            ((zzaie) zzadvVar).zza();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r1.zzf() != r11) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        if (r1.zzf() != r11) goto L38;
     */
    @Override // com.google.android.gms.internal.ads.zzwa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzl zzlVar, Uri uri, Map map, long j, long j2, zzady zzadyVar) throws IOException {
        zzadl zzadlVar = new zzadl(zzlVar, j, j2);
        this.zzc = zzadlVar;
        if (this.zzb != null) {
            return;
        }
        zzadv[] zza = this.zza.zza(uri, map);
        int length = zza.length;
        zzfyn zzi = zzfyq.zzi(length);
        if (length == 1) {
            this.zzb = zza[0];
        } else {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zzadv zzadvVar = zza[i];
                try {
                } catch (EOFException unused) {
                    if (this.zzb == null) {
                    }
                } catch (Throwable th) {
                    zzdd.zzf(this.zzb != null || zzadlVar.zzf() == j);
                    zzadlVar.zzj();
                    throw th;
                }
                if (zzadvVar.zzi(zzadlVar)) {
                    this.zzb = zzadvVar;
                    zzdd.zzf(zzadvVar != null || zzadlVar.zzf() == j);
                    zzadlVar.zzj();
                } else {
                    zzi.zzh(zzadvVar.zzd());
                    if (this.zzb == null) {
                    }
                    boolean z = true;
                    zzdd.zzf(z);
                    zzadlVar.zzj();
                    i++;
                }
            }
            if (this.zzb == null) {
                Iterator it = zzfzg.zzc(zzfyq.zzm(zza), new zzfve() { // from class: com.google.android.gms.internal.ads.zzui
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        zzadv zzadvVar2 = (zzadv) obj;
                        zzadvVar2.zzc();
                        return zzadvVar2.getClass().getSimpleName();
                    }
                }).iterator();
                StringBuilder sb = new StringBuilder();
                zzfvh.zzc(sb, it, ", ");
                throw new zzxl("None of the available extractors (" + sb.toString() + ") could read the stream.", uri, zzi.zzi());
            }
        }
        this.zzb.zze(zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zzf(long j, long j2) {
        zzadv zzadvVar = this.zzb;
        zzadvVar.getClass();
        zzadvVar.zzf(j, j2);
    }
}
