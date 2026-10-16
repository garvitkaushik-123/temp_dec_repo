package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzrl extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrm zza;

    zzrl(zzrm zzrmVar) {
        Objects.requireNonNull(zzrmVar);
        this.zza = zzrmVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        AudioTrack audioTrack2;
        zzql zzqlVar;
        boolean z;
        zzql zzqlVar2;
        zzro zzroVar = this.zza.zza;
        audioTrack2 = zzroVar.zzu;
        if (audioTrack.equals(audioTrack2)) {
            zzqlVar = zzroVar.zzq;
            if (zzqlVar != null) {
                z = zzroVar.zzS;
                if (z) {
                    zzqlVar2 = zzroVar.zzq;
                    zzqlVar2.zzb();
                }
            }
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onPresentationEnded(AudioTrack audioTrack) {
        AudioTrack audioTrack2;
        zzro zzroVar = this.zza.zza;
        audioTrack2 = zzroVar.zzu;
        if (audioTrack.equals(audioTrack2)) {
            zzroVar.zzR = true;
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        AudioTrack audioTrack2;
        zzql zzqlVar;
        boolean z;
        zzql zzqlVar2;
        zzro zzroVar = this.zza.zza;
        audioTrack2 = zzroVar.zzu;
        if (audioTrack.equals(audioTrack2)) {
            zzqlVar = zzroVar.zzq;
            if (zzqlVar != null) {
                z = zzroVar.zzS;
                if (z) {
                    zzqlVar2 = zzroVar.zzq;
                    zzqlVar2.zzb();
                }
            }
        }
    }
}
