package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcak;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbo {
    private static zzaqg zza;
    private static final Object zzb = new Object();

    public zzbo(Context context) {
        zzaqg zza2;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            if (zza == null) {
                zzbde.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeJ)).booleanValue()) {
                        zza2 = zzaz.zzb(context);
                        zza = zza2;
                    }
                }
                zza2 = zzark.zza(context, null);
                zza = zza2;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzcak zzcakVar = new zzcak();
        zza.zza(new zzbm(str, null, zzcakVar));
        return zzcakVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbk zzbkVar = new zzbk(null);
        zzbi zzbiVar = new zzbi(this, str, zzbkVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbj zzbjVar = new zzbj(this, i, str, zzbkVar, zzbiVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
            try {
                zzlVar.zzd(str, "GET", zzbjVar.zzl(), zzbjVar.zzx());
            } catch (zzapl e) {
                String message = e.getMessage();
                int i2 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            }
        }
        zza.zza(zzbjVar);
        return zzbkVar;
    }
}
