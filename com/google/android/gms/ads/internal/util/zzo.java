package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzhhh;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzo implements zzbee {
    final /* synthetic */ zzbef zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzo(zzs zzsVar, zzbef zzbefVar, Context context, Uri uri) {
        this.zza = zzbefVar;
        this.zzb = context;
        this.zzc = uri;
        Objects.requireNonNull(zzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbee
    public final void zza() {
        zzbef zzbefVar = this.zza;
        CustomTabsIntent build = new CustomTabsIntent.Builder(zzbefVar.zza()).build();
        Intent intent = build.intent;
        Context context = this.zzb;
        intent.setPackage(zzhhh.zza(context));
        build.launchUrl(context, this.zzc);
        zzbefVar.zzf((Activity) context);
    }
}
