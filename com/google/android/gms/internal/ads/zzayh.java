package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayh extends zzayk {
    private final View zzh;

    public zzayh(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, View view) {
        super(zzawxVar, "h7NW4UTeHoapcAfHjNS1jSIEsdu+S9XbBUhqH3zqKlRoFqG3FEF52d6iyzd+cmzU", "UQVAYGHTy6RzP6i5dxbs04Nz2BVdis2XDzzm3D3JwpQ=", zzastVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzh;
        if (view != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdI);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlt);
            zzaxb zzaxbVar = new zzaxb((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzato zza = zzatp.zza();
            zza.zzb(zzaxbVar.zza.longValue());
            zza.zzd(zzaxbVar.zzb.longValue());
            zza.zze(zzaxbVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzaxbVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzaxbVar.zzd.longValue());
            }
            this.zzd.zzW((zzatp) zza.zzbr());
        }
    }
}
