package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzclw implements zzclg {
    private final Context zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb = com.google.android.gms.ads.internal.zzv.zzp().zzi();

    public zzclw(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
        boolean parseBoolean = Boolean.parseBoolean(str);
        zzgVar.zzD(parseBoolean);
        if (parseBoolean) {
            com.google.android.gms.ads.internal.util.zzad.zzc(this.zza);
        }
    }
}
