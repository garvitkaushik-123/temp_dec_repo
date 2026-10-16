package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfjp {
    private final com.google.android.gms.ads.internal.util.client.zzx zza;
    private final com.google.android.gms.ads.internal.util.client.zzu zzb;
    private final zzgdz zzc;
    private final zzfjq zzd;

    public zzfjp(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzgdz zzgdzVar, zzfjq zzfjqVar) {
        this.zza = zzxVar;
        this.zzb = zzuVar;
        this.zzc = zzgdzVar;
        this.zzd = zzfjqVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzfjp zzfjpVar, int i, long j, String str, com.google.android.gms.ads.internal.util.client.zzt zztVar) {
        if (zztVar != com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE) {
            return zzgdn.zzh(zztVar);
        }
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = zzfjpVar.zza;
        long zzb = zzxVar.zzb();
        if (i != 1) {
            zzb = (long) (zzxVar.zza() * j);
        }
        return zzfjpVar.zze(str, zzb, i + 1);
    }

    public final ListenableFuture zzd(String str) {
        try {
            return zze(str, 0L, 1);
        } catch (NullPointerException | RejectedExecutionException unused) {
            return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
        }
    }

    private final ListenableFuture zze(final String str, final long j, final int i) {
        final String str2;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        if (i > zzxVar.zzc()) {
            zzfjq zzfjqVar = this.zzd;
            if (zzfjqVar == null || !zzxVar.zzd()) {
                return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE);
            }
            zzfjqVar.zza(str, "", 2);
            return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.BUFFERED);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziW)).booleanValue()) {
            Uri parse = Uri.parse(str);
            String encodedQuery = parse.getEncodedQuery();
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            clearQuery.appendQueryParameter("pa", Integer.toString(i));
            str2 = String.valueOf(clearQuery.build()) + C3040d4.i.c + encodedQuery;
        } else {
            str2 = str;
        }
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzfjo
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzfjp.zzc(zzfjp.this, i, j, str, (com.google.android.gms.ads.internal.util.client.zzt) obj);
            }
        };
        if (j == 0) {
            zzgdz zzgdzVar = this.zzc;
            return zzgdn.zzn(zzgdzVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    com.google.android.gms.ads.internal.util.client.zzt zza;
                    zza = zzfjp.this.zzb.zza(str2);
                    return zza;
                }
            }), zzgcuVar, zzgdzVar);
        }
        zzgdz zzgdzVar2 = this.zzc;
        return zzgdn.zzn(zzgdzVar2.schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                com.google.android.gms.ads.internal.util.client.zzt zza;
                zza = zzfjp.this.zzb.zza(str2);
                return zza;
            }
        }, j, TimeUnit.MILLISECONDS), zzgcuVar, zzgdzVar2);
    }
}
