package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzgy extends zzhd {
    zzgy() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhd
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzg = zzg(i);
                if (((zzey) ((zzgz) zzg).zza()).zze()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzey) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
