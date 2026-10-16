package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzik implements zzfl {
    static final zzfl zza = new zzik();

    private zzik() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfl
    public final boolean zza(int i) {
        return (i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : zzil.ALTERNATIVE_BILLING_ACTION : zzil.LOCAL_PURCHASES_UPDATED_ACTION : zzil.PURCHASES_UPDATED_ACTION : zzil.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
