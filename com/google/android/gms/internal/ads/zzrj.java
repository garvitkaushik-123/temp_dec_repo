package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzrj implements zzqr {
    final /* synthetic */ zzro zza;

    /* synthetic */ zzrj(zzro zzroVar, zzrn zzrnVar) {
        Objects.requireNonNull(zzroVar);
        this.zza = zzroVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zza(long j) {
        zzea.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzb(long j) {
        zzql zzqlVar;
        zzql zzqlVar2;
        zzqg zzqgVar;
        zzro zzroVar = this.zza;
        zzqlVar = zzroVar.zzq;
        if (zzqlVar != null) {
            zzqlVar2 = zzroVar.zzq;
            zzqgVar = ((zzrs) zzqlVar2).zza.zzc;
            zzqgVar.zzx(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzc(long j, long j2, long j3, long j4) {
        long zzN;
        long zzO;
        zzro zzroVar = this.zza;
        zzN = zzroVar.zzN();
        zzO = zzroVar.zzO();
        zzea.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzN + ", " + zzO);
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzd(long j, long j2, long j3, long j4) {
        long zzN;
        long zzO;
        zzro zzroVar = this.zza;
        zzN = zzroVar.zzN();
        zzO = zzroVar.zzO();
        zzea.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzN + ", " + zzO);
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zze(int i, long j) {
        zzql zzqlVar;
        long j2;
        zzql zzqlVar2;
        zzqg zzqgVar;
        zzro zzroVar = this.zza;
        zzqlVar = zzroVar.zzq;
        if (zzqlVar != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j2 = zzroVar.zzW;
            zzqlVar2 = zzroVar.zzq;
            zzqgVar = ((zzrs) zzqlVar2).zza.zzc;
            zzqgVar.zzz(i, j, elapsedRealtime - j2);
        }
    }
}
