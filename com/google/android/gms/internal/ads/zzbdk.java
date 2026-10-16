package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes5.dex */
public final class zzbdk {
    public static final void zza(zzbdj zzbdjVar, zzbdh zzbdhVar) {
        if (zzbdhVar.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbdhVar.zzb())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzbdjVar.zzd(zzbdhVar.zza(), zzbdhVar.zzb(), zzbdhVar.zzc(), zzbdhVar.zzd());
    }
}
