package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Objects;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgwz extends ThreadLocal {
    final /* synthetic */ zzgxa zza;

    zzgwz(zzgxa zzgxaVar) {
        Objects.requireNonNull(zzgxaVar);
        this.zza = zzgxaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzgwm zzgwmVar = zzgwm.zzb;
            zzgxa zzgxaVar = this.zza;
            str = zzgxaVar.zzb;
            Mac mac = (Mac) zzgwmVar.zza(str);
            key = zzgxaVar.zzc;
            mac.init(key);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
