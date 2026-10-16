package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfff {
    private final zzfej zza;
    private final zzffd zzb;
    private final zzfef zzc;
    private zzffl zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfff(zzfej zzfejVar, zzfef zzfefVar, zzffd zzffdVar) {
        this.zza = zzfejVar;
        this.zzc = zzfefVar;
        this.zzb = zzffdVar;
        zzfefVar.zzb(new zzffa(this));
    }

    public static /* synthetic */ void zzc(zzfff zzfffVar) {
        synchronized (zzfffVar) {
            zzfffVar.zzf = 1;
            zzfffVar.zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        r3 = new com.google.android.gms.internal.ads.zzffl(r4.zza, r4.zzb, r0);
        r4.zze = r3;
        r3.zzd(new com.google.android.gms.internal.ads.zzffb(r4, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgy)).booleanValue() && !com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzh()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (arrayDeque.isEmpty()) {
                    break;
                }
                zzffe zzffeVar = (zzffe) arrayDeque.pollFirst();
                if (zzffeVar == null || (zzffeVar.zza() != null && this.zza.zze(zzffeVar.zza()))) {
                    break;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized ListenableFuture zza(zzffe zzffeVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzc(zzffeVar);
    }

    public final synchronized void zzf(zzffe zzffeVar) {
        this.zzd.add(zzffeVar);
    }
}
