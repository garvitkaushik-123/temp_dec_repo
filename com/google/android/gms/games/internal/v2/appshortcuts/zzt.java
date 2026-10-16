package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.games_v2.zzgz;
import com.google.android.gms.internal.games_v2.zzhd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public final class zzt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzr zza(Context context, Class cls) {
        Bundle bundle;
        Long valueOf;
        ActivityInfo activityInfo;
        Bundle bundle2;
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo != null) {
            bundle = applicationInfo.metaData;
            String str = "";
            if (bundle != null) {
                try {
                    valueOf = Long.valueOf(Long.parseLong(bundle.getString("com.google.android.gms.games.APP_ID", "")));
                } catch (NumberFormatException unused2) {
                }
                if (valueOf == null) {
                    return null;
                }
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(context.getPackageName()), 795136);
                int i = zzhd.zzd;
                zzgz zzgzVar = new zzgz();
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                    if (activityInfo2 != null) {
                        int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(activityInfo2.packageName, activityInfo2.name));
                        if (componentEnabledSetting == 0) {
                            if (activityInfo2.enabled) {
                                if (!resolveInfo.activityInfo.exported) {
                                    zzgzVar.zzd(resolveInfo);
                                }
                            }
                        } else if (componentEnabledSetting == 1) {
                            if (!resolveInfo.activityInfo.exported) {
                            }
                        }
                    }
                }
                zzhd zze = zzgzVar.zze();
                int size = zze.size();
                int i2 = Integer.MAX_VALUE;
                for (int i3 = 0; i3 < size; i3++) {
                    ActivityInfo activityInfo3 = ((ResolveInfo) zze.get(i3)).activityInfo;
                    if (activityInfo3 != null) {
                        try {
                            activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(activityInfo3.packageName, activityInfo3.name), 795264);
                        } catch (PackageManager.NameNotFoundException unused3) {
                            activityInfo = null;
                        }
                        if (activityInfo != null && (bundle2 = activityInfo.metaData) != null) {
                            i2 = Integer.min(i2, bundle2.getInt("com.google.android.gms.games.APP_SHORTCUTS_MAX_NUMBER", Integer.MAX_VALUE));
                            str = bundle2.getString("com.google.android.gms.games.APP_SHORTCUTS_TARGET_ACTIVITY", str);
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(i2), str);
                return new zzr(valueOf.longValue(), context.getPackageName(), ((Integer) pair.first).intValue(), new ComponentName(context, (Class<?>) cls), ((String) pair.second).trim());
            }
            valueOf = null;
            if (valueOf == null) {
            }
        }
        bundle = null;
        String str2 = "";
        if (bundle != null) {
        }
        valueOf = null;
        if (valueOf == null) {
        }
    }
}
