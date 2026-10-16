package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzcak;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbm extends zzaqd {
    private final zzcak zza;
    private final com.google.android.gms.ads.internal.util.client.zzl zzb;

    public zzbm(String str, Map map, zzcak zzcakVar) {
        super(0, str, new zzbl(zzcakVar));
        this.zza = zzcakVar;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        this.zzb = zzlVar;
        zzlVar.zzd(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    protected final zzaqj zzh(zzapz zzapzVar) {
        return zzaqj.zzb(zzapzVar, zzara.zzb(zzapzVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    protected final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapz zzapzVar = (zzapz) obj;
        Map map = zzapzVar.zzc;
        int i = zzapzVar.zza;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = this.zzb;
        zzlVar.zzf(map, i);
        byte[] bArr = zzapzVar.zzb;
        if (com.google.android.gms.ads.internal.util.client.zzl.zzk() && bArr != null) {
            zzlVar.zzh(bArr);
        }
        this.zza.zzc(zzapzVar);
    }
}
