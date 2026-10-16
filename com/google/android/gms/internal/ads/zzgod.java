package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgod {
    private final zzgxe zza;
    private final Class zzb;

    /* synthetic */ zzgod(zzgxe zzgxeVar, Class cls, zzgoc zzgocVar) {
        this.zza = zzgxeVar;
        this.zzb = cls;
    }

    public static zzgod zzb(zzgob zzgobVar, zzgxe zzgxeVar, Class cls) {
        return new zzgoa(zzgxeVar, cls, zzgobVar);
    }

    public abstract zzgfm zza(zzgpb zzgpbVar) throws GeneralSecurityException;

    public final zzgxe zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
