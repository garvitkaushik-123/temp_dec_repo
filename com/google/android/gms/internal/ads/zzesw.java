package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesw implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;
    private final zzfcw zzc;
    private final VersionInfoParcel zzd;

    zzesw(Context context, zzgdy zzgdyVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgdyVar;
        this.zzc = zzfcwVar;
        this.zzd = versionInfoParcel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdo)).booleanValue() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0055, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzfse.zzj(r0).zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdz)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ba, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdp)).booleanValue() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzfsf.zzi(r0);
        r0 = com.google.android.gms.internal.ads.zzfsb.zza(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ec, code lost:
    
        if (r9.zzd.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdv)).intValue()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ee, code lost:
    
        r2 = r4.zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdA)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
        r3 = r0.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0112, code lost:
    
        r6 = r0.zze();
        r4 = r2;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdr)).booleanValue() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdq)).booleanValue() != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ zzesx zzc(zzesw zzeswVar) {
        try {
            Context context = zzeswVar.zza;
            boolean zza = zzeswVar.zzc.zza();
            zzfsa zzfsaVar = new zzfsa();
            zzfsa zzfsaVar2 = new zzfsa();
            boolean z = true;
            if (zza) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzds)).booleanValue()) {
                    return new zzesx(true);
                }
            }
            if (!zza) {
            }
            if (zza) {
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdw)).booleanValue()) {
                if (zzeswVar.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdv)).intValue()) {
                    zzfsf.zzi(context).zzj();
                }
            }
            if (!zza) {
            }
            if (zza) {
            }
            zzfsa zzfsaVar3 = zzfsaVar2;
            boolean z2 = true;
            boolean z3 = true;
            return new zzesx(zzfsaVar, zzfsaVar3, z2, z3, zza);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "PerAppIdSignal");
            return new zzesx(zzeswVar.zzc.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesw.zzc(zzesw.this);
            }
        });
    }
}
