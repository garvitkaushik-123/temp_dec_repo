package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzemy implements zzeuc {
    private final zzgdy zza;
    private final zzdpz zzb;
    private final zzdun zzc;
    private final zzena zzd;

    public zzemy(zzgdy zzgdyVar, zzdpz zzdpzVar, zzdun zzdunVar, zzena zzenaVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdpzVar;
        this.zzc = zzdunVar;
        this.zzd = zzenaVar;
    }

    public static /* synthetic */ zzemz zzc(zzemy zzemyVar) {
        List<String> asList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbD)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzfdu zzc = zzemyVar.zzb.zzc(str, new JSONObject());
                zzc.zzC();
                boolean zzt = zzemyVar.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmb)).booleanValue() || zzt) {
                    try {
                        zzbse zzf = zzc.zzf();
                        if (zzf != null) {
                            bundle2.putString(BidTokenRepositoryKt.SDK_VERSION, zzf.toString());
                        }
                    } catch (zzfdd unused) {
                    }
                }
                try {
                    zzbse zze = zzc.zze();
                    if (zze != null) {
                        bundle2.putString("adapter_version", zze.toString());
                    }
                } catch (zzfdd unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfdd unused3) {
            }
        }
        zzemz zzemzVar = new zzemz(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmb)).booleanValue()) {
            zzemyVar.zzd.zzb(zzemzVar);
        }
        return zzemzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbcv zzbcvVar = zzbde.zzmb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzena zzenaVar = this.zzd;
            if (zzenaVar.zza() != null) {
                zzemz zza = zzenaVar.zza();
                zza.getClass();
                return zzgdn.zzh(zza);
            }
        }
        if (zzfwg.zzd((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbD)) || (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && (this.zzd.zzd() || !this.zzc.zzt()))) {
            return zzgdn.zzh(new zzemz(new Bundle()));
        }
        this.zzd.zzc(true);
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemy.zzc(zzemy.this);
            }
        });
    }
}
