package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzavk implements zzfqb {
    final /* synthetic */ zzfod zza;

    zzavk(zzavm zzavmVar, zzfod zzfodVar) {
        this.zza = zzfodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqb
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
