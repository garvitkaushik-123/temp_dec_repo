package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbya;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbya zzc;
    private final zzbuy zzd = new zzbuy(false, Collections.emptyList());

    public zzb(Context context, zzbya zzbyaVar, zzbuy zzbuyVar) {
        this.zza = context;
        this.zzc = zzbyaVar;
    }

    private final boolean zzd() {
        zzbya zzbyaVar = this.zzc;
        return (zzbyaVar != null && zzbyaVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbya zzbyaVar = this.zzc;
            if (zzbyaVar != null) {
                zzbyaVar.zze(str, null, 3);
                return;
            }
            zzbuy zzbuyVar = this.zzd;
            if (!zzbuyVar.zza || (list = zzbuyVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzv.zzr();
                    com.google.android.gms.ads.internal.util.zzs.zzM(context, "", replace);
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
