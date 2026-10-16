package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhx implements zzhgr {
    private final zzhha zza;

    private zzdhx(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdhx zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdhx(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        VersionInfoParcel zza = ((zzchz) this.zza).zza();
        com.google.android.gms.ads.internal.zzv.zzr();
        return new zzayz(UUID.randomUUID().toString(), zza, "native", new JSONObject(), false, true);
    }
}
