package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbcj;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzebi implements zzfhb {
    private final zzeaw zza;
    private final zzeba zzb;

    zzebi(zzeaw zzeawVar, zzeba zzebaVar) {
        this.zza = zzeawVar;
        this.zzb = zzebaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzd(zzfgu zzfguVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue() && zzfgu.RENDERER == zzfguVar) {
            zzeaw zzeawVar = this.zza;
            if (zzeawVar.zzc() != 0) {
                zzeawVar.zzf(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - zzeawVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdE(zzfgu zzfguVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdF(zzfgu zzfguVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue() && zzfgu.RENDERER == zzfguVar) {
            zzeaw zzeawVar = this.zza;
            if (zzeawVar.zzc() != 0) {
                zzeawVar.zzf(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - zzeawVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdG(zzfgu zzfguVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue()) {
            if (zzfgu.RENDERER == zzfguVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime());
                return;
            }
            if (zzfgu.PRELOADED_LOADER == zzfguVar || zzfgu.SERVER_TRANSACTION == zzfguVar) {
                zzeaw zzeawVar = this.zza;
                zzeawVar.zzh(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime());
                final zzeba zzebaVar = this.zzb;
                final long zzd = zzeawVar.zzd();
                zzebaVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzeaz
                    @Override // com.google.android.gms.internal.ads.zzfge
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzeba.this.zzf()) {
                            return null;
                        }
                        long j = zzd;
                        zzbcj.zzaf.zza.C0217zza zzn = zzbcj.zzaf.zza.zzn();
                        zzn.zzP(j);
                        byte[] zzaV = zzn.zzbr().zzaV();
                        zzebh.zzf(sQLiteDatabase, false, false);
                        zzebh.zzc(sQLiteDatabase, j, zzaV);
                        return null;
                    }
                });
            }
        }
    }
}
