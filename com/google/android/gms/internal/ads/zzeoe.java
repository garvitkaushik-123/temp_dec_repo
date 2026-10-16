package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeoe implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    public zzeoe(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    public static /* synthetic */ zzeof zzc(zzeoe zzeoeVar) {
        int i;
        int i2;
        AudioManager audioManager = (AudioManager) zzeoeVar.zzb.getSystemService("audio");
        float zza = com.google.android.gms.ads.internal.zzv.zzt().zza();
        boolean zze = com.google.android.gms.ads.internal.zzv.zzt().zze();
        if (audioManager == null) {
            return new zzeof(-1, false, false, -1, -1, -1, -1, -1, zza, zze, true);
        }
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlu)).booleanValue()) {
            int zzj = com.google.android.gms.ads.internal.zzv.zzs().zzj(audioManager);
            i2 = audioManager.getStreamMaxVolume(3);
            i = zzj;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzeof(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i, i2, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zza, zze, false);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 13;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeod
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeoe.zzc(zzeoe.this);
            }
        });
    }
}
