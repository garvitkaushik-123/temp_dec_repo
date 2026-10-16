package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbo extends zzhbt {
    zzhbo() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzg = zzg(i);
                if (((zzgyv) ((zzhbp) zzg).zza()).zze()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzgyv) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
