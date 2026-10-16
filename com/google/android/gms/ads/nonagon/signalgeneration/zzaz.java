package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzbze;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzaz {
    private final String zza;
    private final String zzb;
    private final zzbze zzc;

    /* synthetic */ zzaz(zzax zzaxVar, zzay zzayVar) {
        String str;
        String str2;
        zzbze zzbzeVar;
        str = zzaxVar.zza;
        this.zza = str;
        str2 = zzaxVar.zzb;
        this.zzb = str2;
        zzbzeVar = zzaxVar.zzc;
        this.zzc = zzbzeVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final zzbcj.zza.EnumC0215zza zza() {
        char c;
        String str = this.zza;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? zzbcj.zza.EnumC0215zza.AD_INITIATER_UNSPECIFIED : zzbcj.zza.EnumC0215zza.REWARD_BASED_VIDEO_AD : zzbcj.zza.EnumC0215zza.AD_LOADER : zzbcj.zza.EnumC0215zza.INTERSTITIAL : zzbcj.zza.EnumC0215zza.BANNER;
    }

    final zzbze zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    final String zzd() {
        return this.zzb;
    }

    public final Set zze() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
