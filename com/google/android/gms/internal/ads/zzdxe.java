package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdxe implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdxe(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdxe zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdxe(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        zzfha zzfhaVar = (zzfha) this.zza.zzb();
        final CookieManager zza = com.google.android.gms.ads.internal.zzv.zzs().zza((Context) this.zzb.zzb());
        zzfgu zzfguVar = zzfgu.WEBVIEW_COOKIE;
        Objects.requireNonNull(zzfhaVar);
        zzfgq zzi = zzfgk.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = zza;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbc));
            }
        }, zzfguVar, zzfhaVar).zzi(1L, TimeUnit.SECONDS);
        final zzfge zzfgeVar = new zzfge() { // from class: com.google.android.gms.internal.ads.zzdwz
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                return "";
            }
        };
        return zzi.zzc(Exception.class, new zzgcu(zzfgeVar) { // from class: com.google.android.gms.internal.ads.zzfgl
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh("");
            }
        }).zza();
    }
}
