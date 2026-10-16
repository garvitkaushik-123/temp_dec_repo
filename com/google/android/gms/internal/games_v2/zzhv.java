package com.google.android.gms.internal.games_v2;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzhv extends zzht implements Serializable {
    static final zzht zza = new zzhv();

    private zzhv() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzhw zzhwVar = (zzhw) obj;
        zzhw zzhwVar2 = (zzhw) obj2;
        return zzgq.zzc().zza(zzhwVar.zza, zzhwVar2.zza).zza(zzhwVar.zzb, zzhwVar2.zzb).zzb();
    }
}
