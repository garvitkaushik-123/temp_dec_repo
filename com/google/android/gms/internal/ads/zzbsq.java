package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbsq implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsr zza;

    zzbsq(zzbsr zzbsrVar) {
        Objects.requireNonNull(zzbsrVar);
        this.zza = zzbsrVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
