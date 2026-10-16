package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzgdj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzar implements zzgdj {
    final /* synthetic */ zzbuf zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzau zzc;

    zzar(zzau zzauVar, zzbuf zzbufVar, boolean z) {
        this.zza = zzbufVar;
        this.zzb = z;
        Objects.requireNonNull(zzauVar);
        this.zzc = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        boolean z;
        String str;
        Uri zzaa;
        zzfjy zzfjyVar;
        zzfjy zzfjyVar2;
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            zzau zzauVar = this.zzc;
            z = zzauVar.zzr;
            if (z || this.zzb) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (zzauVar.zzQ(uri)) {
                        str = zzauVar.zzA;
                        zzaa = zzau.zzaa(uri, str, "1");
                        zzfjyVar = zzauVar.zzq;
                        zzfjyVar.zzd(zzaa.toString(), null, null, null);
                    } else {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhJ)).booleanValue()) {
                            zzfjyVar2 = zzauVar.zzq;
                            zzfjyVar2.zzd(uri.toString(), null, null, null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
