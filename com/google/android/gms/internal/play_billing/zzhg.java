package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public final class zzhg extends RuntimeException {
    public zzhg(zzgl zzglVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzfq zza() {
        return new zzfq(getMessage());
    }
}
