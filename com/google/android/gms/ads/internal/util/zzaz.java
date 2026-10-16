package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqz;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbmc;
import com.google.android.gms.internal.ads.zzfqs;
import com.google.android.gms.internal.ads.zzfqt;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzaz extends zzaqs {
    private final Context zzb;

    private zzaz(Context context, zzaqr zzaqrVar) {
        super(zzaqrVar);
        this.zzb = context;
    }

    public static zzaqg zzb(Context context) {
        zzaqg zzaqgVar = new zzaqg(new zzaqz(new File(zzfqt.zza(zzfqs.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzare(null, null)), 4);
        zzaqgVar.zzd();
        return zzaqgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqs, com.google.android.gms.internal.ads.zzapw
    public final zzapz zza(zzaqd zzaqdVar) throws zzaqm {
        if (zzaqdVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeK), zzaqdVar.zzk())) {
                Context context = this.zzb;
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                if (com.google.android.gms.ads.internal.util.client.zzf.zzx(context, 13400000)) {
                    zzapz zza = new zzbmc(context).zza(zzaqdVar);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaqdVar.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaqdVar.zzk())));
                }
            }
        }
        return super.zza(zzaqdVar);
    }
}
