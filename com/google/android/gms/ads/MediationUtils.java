package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbde;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> list) {
        AdSize adSize2 = null;
        if (list != null && adSize != null) {
            if (!adSize.zzh() && !adSize.zzi()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(adSize.getWidthInPixels(context) / f), Math.round(adSize.getHeightInPixels(context) / f));
            }
            for (AdSize adSize3 : list) {
                if (adSize3 != null) {
                    int width = adSize.getWidth();
                    int width2 = adSize3.getWidth();
                    int height = adSize.getHeight();
                    double d = width * 0.5d;
                    double d2 = width2;
                    int height2 = adSize3.getHeight();
                    if (d <= d2 && width >= width2) {
                        if (adSize.zzi()) {
                            int zza = adSize.zza();
                            if (((Integer) zzbd.zzc().zzb(zzbde.zzil)).intValue() <= width2) {
                                if (((Integer) zzbd.zzc().zzb(zzbde.zzim)).intValue() <= height2 && zza >= height2) {
                                    if (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= adSize3.getWidth() * adSize3.getHeight()) {
                                        adSize2 = adSize3;
                                    }
                                }
                            }
                        } else if (adSize.zzh()) {
                            if (adSize.zzb() >= height2) {
                                if (adSize2 == null) {
                                }
                                adSize2 = adSize3;
                            }
                        } else if (height * MIN_HEIGHT_RATIO <= height2 && height >= height2) {
                            if (adSize2 == null) {
                            }
                            adSize2 = adSize3;
                        }
                    }
                }
            }
        }
        return adSize2;
    }
}
