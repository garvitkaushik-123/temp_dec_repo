package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesx implements zzeub {
    private zzfsa zza;
    private zzfsa zzb;
    private boolean zzc;
    private boolean zzd;
    private final boolean zze = false;
    private final boolean zzf;

    public zzesx(zzfsa zzfsaVar, zzfsa zzfsaVar2, boolean z, boolean z2, boolean z3) {
        this.zza = zzfsaVar;
        this.zzb = zzfsaVar2;
        this.zzc = z;
        this.zzd = z2;
        this.zzf = z3;
    }

    public zzesx(boolean z) {
        this.zzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdp)).booleanValue() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
    
        if (r6.zzb.zzc() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        r1.putString("paidv2_id_android", r6.zzb.zzb());
        r1.putLong("paidv2_creation_time_android", r6.zzb.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009e, code lost:
    
        r1.putBoolean("paidv2_pub_option_android", r6.zzc);
        r1.putBoolean("paidv2_user_option_android", r6.zzd);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdr)).booleanValue() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0038, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdq)).booleanValue() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzdo)).booleanValue() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6.zza.zzc() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r1.putString("paidv1_id_android", r6.zza.zzb());
        r1.putLong("paidv1_creation_time_android", r6.zza.zza());
     */
    @Override // com.google.android.gms.internal.ads.zzeub
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        if (this.zze) {
            return;
        }
        Bundle zza = zzfdk.zza(bundle, "pii");
        boolean z = this.zzf;
        if (!z) {
        }
        if (z) {
        }
        if (!z) {
        }
        if (z) {
        }
        if (zza.isEmpty()) {
            return;
        }
        bundle.putBundle("pii", zza);
    }
}
