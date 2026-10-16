package com.google.android.gms.internal.ads;

import android.content.Context;
import com.ironsource.C3040d4;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbkl implements zzbkf {
    private final Context zza;
    private final Map zzb;

    public zzbkl(Context context, Map map) {
        this.zza = context;
        this.zzb = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        char c;
        zzbyo zzo = com.google.android.gms.ads.internal.zzv.zzo();
        Context context = this.zza;
        if (zzo.zzp(context)) {
            String str = (String) map.get(C3040d4.h.j0);
            String str2 = (String) map.get("eventId");
            int hashCode = str.hashCode();
            if (hashCode == 94399) {
                if (str.equals("_aa")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode != 94401) {
                if (hashCode == 94407 && str.equals("_ai")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("_ac")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                com.google.android.gms.ads.internal.zzv.zzo().zzj(context, str2, (Map) this.zzb.get("_ac"));
            } else if (c == 1) {
                com.google.android.gms.ads.internal.zzv.zzo().zzk(context, str2, (Map) this.zzb.get("_ai"));
            } else if (c == 2) {
                com.google.android.gms.ads.internal.zzv.zzo().zzh(context, str2);
            } else {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("logScionEvent gmsg contained unsupported eventName");
            }
        }
    }
}
