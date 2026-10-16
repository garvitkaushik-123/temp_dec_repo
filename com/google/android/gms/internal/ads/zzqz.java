package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzqz {
    public static void zza(AudioTrack audioTrack, zzpp zzppVar) {
        audioTrack.setPreferredDevice(zzppVar == null ? null : zzppVar.zza);
    }
}
