package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzax implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    zzax(zzay zzayVar, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        Objects.requireNonNull(zzayVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = this.zza;
        AlertDialog.Builder zzL = zzs.zzL(context);
        zzL.setMessage(this.zzb);
        if (this.zzc) {
            zzL.setTitle("Error");
        } else {
            zzL.setTitle("Info");
        }
        if (this.zzd) {
            zzL.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            zzL.setPositiveButton("Learn More", new zzaw(this, context));
            zzL.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        zzL.create().show();
    }
}
