package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzetq implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    zzetq(zzgdy zzgdyVar, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzgdyVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    public static /* synthetic */ zzetr zzc(zzetq zzetqVar) {
        Context context = zzetqVar.zzb;
        boolean isCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzv.zzr();
        boolean zzF = com.google.android.gms.ads.internal.util.zzs.zzF(context);
        String str = zzetqVar.zzc.afmaVersion;
        com.google.android.gms.ads.internal.zzv.zzr();
        boolean zzG = com.google.android.gms.ads.internal.util.zzs.zzG();
        com.google.android.gms.ads.internal.zzv.zzr();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new zzetr(isCallerInstantApp, zzF, str, zzG, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), zzetqVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 35;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetq.zzc(zzetq.this);
            }
        });
    }
}
