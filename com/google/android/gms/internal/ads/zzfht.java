package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfht {
    public static void zza(ListenableFuture listenableFuture, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        zzg(listenableFuture, zzfhuVar, zzfhjVar, false);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        zzg(listenableFuture, zzfhuVar, zzfhjVar, true);
    }

    public static void zzc(ListenableFuture listenableFuture, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzgdn.zzr(zzgde.zzw(listenableFuture), new zzfhs(zzfhuVar, zzfhjVar), zzcaf.zzg);
        }
    }

    public static void zzd(ListenableFuture listenableFuture, zzfhj zzfhjVar) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzgdn.zzr(zzgde.zzw(listenableFuture), new zzfhq(zzfhjVar), zzcaf.zzg);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzji), str);
    }

    public static int zzf(zzfcw zzfcwVar) {
        int zzg = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzg(zzfcwVar) - 1;
        return (zzg == 0 || zzg == 1) ? 7 : 23;
    }

    private static void zzg(ListenableFuture listenableFuture, zzfhu zzfhuVar, zzfhj zzfhjVar, boolean z) {
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzgdn.zzr(zzgde.zzw(listenableFuture), new zzfhr(zzfhuVar, zzfhjVar, z), zzcaf.zzg);
        }
    }
}
