package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbao implements Comparator {
    public zzbao(zzbap zzbapVar) {
        Objects.requireNonNull(zzbapVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbad zzbadVar = (zzbad) obj;
        zzbad zzbadVar2 = (zzbad) obj2;
        if (zzbadVar.zzd() < zzbadVar2.zzd()) {
            return -1;
        }
        if (zzbadVar.zzd() > zzbadVar2.zzd()) {
            return 1;
        }
        if (zzbadVar.zzb() < zzbadVar2.zzb()) {
            return -1;
        }
        if (zzbadVar.zzb() > zzbadVar2.zzb()) {
            return 1;
        }
        float zza = (zzbadVar.zza() - zzbadVar.zzd()) * (zzbadVar.zzc() - zzbadVar.zzb());
        float zza2 = (zzbadVar2.zza() - zzbadVar2.zzd()) * (zzbadVar2.zzc() - zzbadVar2.zzb());
        if (zza > zza2) {
            return -1;
        }
        return zza < zza2 ? 1 : 0;
    }
}
