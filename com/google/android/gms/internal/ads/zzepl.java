package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzepl implements zzhgr {
    public static zzepl zza() {
        return zzepk.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        List arrayList = new ArrayList();
        zzbcv zzbcvVar = zzbde.zzmh;
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).split(","));
        }
        zzhgz.zzb(arrayList);
        return arrayList;
    }
}
