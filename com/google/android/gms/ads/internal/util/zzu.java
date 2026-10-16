package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbde;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public class zzu extends zzt {
    static final boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final boolean zzd(Activity activity, Configuration configuration) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfo)).booleanValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfq)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        int zzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, configuration.screenHeightDp);
        int zzC2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzv.zzr();
        DisplayMetrics zzu = zzs.zzu(windowManager);
        int i = zzu.heightPixels;
        int i2 = zzu.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(activity.getResources().getDisplayMetrics().density + 0.5d)) * ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfm)).intValue();
        return (zze(i, zzC + dimensionPixelSize, round) && zze(i2, zzC2, round)) ? false : true;
    }
}
