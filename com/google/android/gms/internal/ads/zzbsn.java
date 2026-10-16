package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbsn implements View.OnClickListener {
    final /* synthetic */ zzbso zza;

    zzbsn(zzbso zzbsoVar) {
        Objects.requireNonNull(zzbsoVar);
        this.zza = zzbsoVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
