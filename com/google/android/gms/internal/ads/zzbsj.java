package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbsj implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsl zza;

    zzbsj(zzbsl zzbslVar) {
        Objects.requireNonNull(zzbslVar);
        this.zza = zzbslVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        zzbsl zzbslVar = this.zza;
        Intent zzb = zzbslVar.zzb();
        com.google.android.gms.ads.internal.zzv.zzr();
        context = zzbslVar.zzb;
        com.google.android.gms.ads.internal.util.zzs.zzU(context, zzb);
    }
}
