package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeob implements zzeub {

    @Nullable
    private final Integer zza;

    private zzeob(@Nullable Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzeob zzc(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkx)).booleanValue()) {
            return new zzeob(null);
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        int i = 0;
        try {
            if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkA)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkz)).intValue() && Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        i = SdkExtensions.getExtensionVersion(31);
                    }
                }
            } else {
                i = SdkExtensions.getExtensionVersion(1000000);
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzeob(Integer.valueOf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (num != null) {
            zzcvaVar.zza.putInt("aos", num.intValue());
        }
    }
}
