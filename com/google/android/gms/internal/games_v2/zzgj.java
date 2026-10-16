package com.google.android.gms.internal.games_v2;

import java.util.Objects;
import java.util.function.Function;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final /* synthetic */ class zzgj implements Function {
    static final /* synthetic */ zzgj zza = new zzgj();

    private /* synthetic */ zzgj() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzhk zzk;
        zzhj zzhjVar = (zzhj) obj;
        int i = zzhjVar.zzb;
        if (i == 0) {
            return zzif.zza;
        }
        if (i == 1) {
            return new zzii(Objects.requireNonNull(zzhjVar.zza[0]));
        }
        zzk = zzhk.zzk(i, zzhjVar.zza);
        zzhjVar.zzb = zzk.size();
        zzhjVar.zzc = true;
        return zzk;
    }
}
