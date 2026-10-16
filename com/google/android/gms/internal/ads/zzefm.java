package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzefm implements zzdgn {
    private final zzfca zza;
    private final zzbrp zzb;
    private final AdFormat zzc;
    private zzcwq zzd = null;

    zzefm(zzfca zzfcaVar, zzbrp zzbrpVar, AdFormat adFormat) {
        this.zza = zzfcaVar;
        this.zzb = zzbrpVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) throws zzdgm {
        boolean zzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                zzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (ordinal != 2) {
                    if (ordinal == 5) {
                        zzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdgm("Adapter failed to show.");
                }
                zzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zzs) {
                zzcwq zzcwqVar = this.zzd;
                if (zzcwqVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbI)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzcwqVar.zza();
                return;
            }
            throw new zzdgm("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgm(th);
        }
    }

    public final void zzc(zzcwq zzcwqVar) {
        this.zzd = zzcwqVar;
    }
}
