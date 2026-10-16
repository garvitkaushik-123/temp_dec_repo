package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzfhi {
    public static zzfhj zza(Context context, int i) {
        boolean booleanValue;
        if (zzfhx.zza()) {
            int i2 = i - 2;
            if (i2 == 20 || i2 == 21) {
                booleanValue = ((Boolean) zzbex.zze.zze()).booleanValue();
            } else if (i2 != 110) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        booleanValue = ((Boolean) zzbex.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        booleanValue = ((Boolean) zzbex.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        booleanValue = ((Boolean) zzbex.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                booleanValue = ((Boolean) zzbex.zzf.zze()).booleanValue();
            }
            if (booleanValue) {
                return new zzfhl(context, i);
            }
        }
        return new zzfiq();
    }

    public static zzfhj zzb(Context context, int i, int i2, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        zzfhj zza = zza(context, i);
        if (zza instanceof zzfhl) {
            zza.zzi();
            zza.zzn(i2);
            zza.zzf(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zza(zzmVar.zzm));
            String str = zzmVar.zzp;
            if (zzfht.zze(str)) {
                zza.zze(str);
            }
        }
        return zza;
    }
}
