package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdnv implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final Context zzb;
    private final zzdsj zzc;
    private final zzeca zzd;
    private final Executor zze;
    private final zzavu zzf;
    private final VersionInfoParcel zzg;
    private final zzfjy zzh;
    private final zzecl zzi;
    private final zzfda zzj;

    public zzdnv(Context context, Executor executor, zzavu zzavuVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzcft zzcftVar, zzeca zzecaVar, zzfjy zzfjyVar, zzdsj zzdsjVar, zzecl zzeclVar, zzfda zzfdaVar) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzavuVar;
        this.zzg = versionInfoParcel;
        this.zza = zzaVar;
        this.zzd = zzecaVar;
        this.zzh = zzfjyVar;
        this.zzc = zzdsjVar;
        this.zzi = zzeclVar;
        this.zzj = zzfdaVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdny zzdnyVar = new zzdny(this);
        zzdnyVar.zzk();
        return zzdnyVar;
    }
}
