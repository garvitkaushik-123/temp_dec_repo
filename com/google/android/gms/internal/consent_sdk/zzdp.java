package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public final class zzdp implements zzdo {
    private final Object zza;

    private zzdp(Object obj) {
        this.zza = obj;
    }

    public static zzdo zzb(Object obj) {
        if (obj != null) {
            return new zzdp(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdt, com.google.android.gms.internal.consent_sdk.zzds
    public final Object zza() {
        return this.zza;
    }
}
