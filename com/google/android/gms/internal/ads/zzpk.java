package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzpk extends AudioDeviceCallback {
    final /* synthetic */ zzpo zza;

    /* synthetic */ zzpk(zzpo zzpoVar, zzpn zzpnVar) {
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        Context context;
        zze zzeVar;
        zzpp zzppVar;
        zzpo zzpoVar = this.zza;
        context = zzpoVar.zza;
        zzeVar = zzpoVar.zzh;
        zzppVar = zzpoVar.zzg;
        zzpoVar.zzk(zzpj.zzc(context, zzeVar, zzppVar));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpp zzppVar;
        Context context;
        zze zzeVar;
        zzpp zzppVar2;
        zzpo zzpoVar = this.zza;
        zzppVar = zzpoVar.zzg;
        String str = zzex.zza;
        int length = audioDeviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (Objects.equals(audioDeviceInfoArr[i], zzppVar)) {
                zzpoVar.zzg = null;
                break;
            }
            i++;
        }
        context = zzpoVar.zza;
        zzeVar = zzpoVar.zzh;
        zzppVar2 = zzpoVar.zzg;
        zzpoVar.zzk(zzpj.zzc(context, zzeVar, zzppVar2));
    }
}
