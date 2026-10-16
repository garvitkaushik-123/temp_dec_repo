package com.google.android.gms.internal.ads;

import android.app.LocaleManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeun implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    zzeun(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:4|2)|5|6|(3:72|73|(5:75|9|10|11|(18:13|14|15|(2:17|(2:19|(1:21))(1:22))|23|(2:55|(3:58|(3:61|(2:64|65)(1:63)|59)|66))|25|26|(2:28|(9:30|31|(9:45|46|(1:50)|52|35|(1:37)(1:44)|(1:39)(1:43)|40|41)(1:33)|34|35|(0)(0)|(0)(0)|40|41))|54|31|(0)(0)|34|35|(0)(0)|(0)(0)|40|41)(17:68|15|(0)|23|(0)|25|26|(0)|54|31|(0)(0)|34|35|(0)(0)|(0)(0)|40|41)))|8|9|10|11|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0096 A[Catch: Exception -> 0x00b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b0, blocks: (B:11:0x008a, B:13:0x0096), top: B:10:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ zzeul zzc(zzeun zzeunVar) {
        ActivityInfo activityInfo;
        PackageInfo packageInfo;
        String str;
        String str2;
        Context context;
        boolean equals;
        boolean z;
        String str3;
        String string;
        PackageInfo packageInfo2;
        Context context2 = zzeunVar.zzb;
        PackageManager packageManager = context2.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo zzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo zzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.zzv.zzr();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        boolean zzw = com.google.android.gms.ads.internal.util.client.zzf.zzw();
        boolean isLatchsky = DeviceProperties.isLatchsky(context2);
        boolean isSidewinder = DeviceProperties.isSidewinder(context2);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        LocaleList localeList = LocaleList.getDefault();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(localeList.get(i).getLanguage());
        }
        ResolveInfo zzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zzd3 != null && (activityInfo = zzd3.activityInfo) != null) {
            try {
                packageInfo = Wrappers.packageManager(context2).getPackageInfo(activityInfo.packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo != null) {
                str = packageInfo.versionCode + "." + activityInfo.packageName;
                packageInfo2 = Wrappers.packageManager(zzeunVar.zzb).getPackageInfo("com.android.vending", 128);
                if (packageInfo2 != null) {
                    str2 = null;
                    String str4 = Build.FINGERPRINT;
                    String language2 = Locale.getDefault().getLanguage();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznI)).booleanValue()) {
                    }
                    String str5 = language2;
                    Context context3 = zzeunVar.zzb;
                    if (packageManager != null) {
                    }
                    context = context3;
                    equals = false;
                    com.google.android.gms.ads.internal.zzv.zzr();
                    long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlN)).booleanValue()) {
                    }
                    z = false;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlR)).booleanValue()) {
                    }
                    str3 = string;
                    if (zzd2 == null) {
                    }
                    return new zzeul(zzd == null, zzd2 == null, country, zzw, isLatchsky, isSidewinder, language, arrayList, str, str2, str4, equals, Build.MODEL, availableBytes, z, str3, Build.VERSION.SDK_INT, str5);
                }
                str2 = packageInfo2.versionCode + "." + packageInfo2.packageName;
                String str42 = Build.FINGERPRINT;
                String language22 = Locale.getDefault().getLanguage();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznI)).booleanValue()) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        LocaleManager localeManager = (LocaleManager) zzeunVar.zzb.getSystemService(LocaleManager.class);
                        if (localeManager != null) {
                            language22 = localeManager.getSystemLocales().get(0).getLanguage();
                        }
                    } else {
                        language22 = zzeunVar.zzb.getResources().getConfiguration().getLocales().get(0).getLanguage();
                    }
                }
                String str52 = language22;
                Context context32 = zzeunVar.zzb;
                if (packageManager != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
                    ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null && resolveActivity != null) {
                        int i2 = 0;
                        while (i2 < queryIntentActivities.size()) {
                            context = context32;
                            if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                                equals = resolveActivity.activityInfo.packageName.equals(zzhhh.zza(context));
                                break;
                            }
                            i2++;
                            context32 = context;
                        }
                    }
                }
                context = context32;
                equals = false;
                com.google.android.gms.ads.internal.zzv.zzr();
                long availableBytes2 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlN)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzr();
                    if (com.google.android.gms.ads.internal.util.zzs.zzC(context)) {
                        z = true;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlR)).booleanValue()) {
                            try {
                                Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                                string = (bundle != null && bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) ? bundle.getString("com.google.unity.ads.UNITY_VERSION") : "";
                            } catch (PackageManager.NameNotFoundException unused2) {
                            }
                            str3 = null;
                            return new zzeul(zzd == null, zzd2 == null, country, zzw, isLatchsky, isSidewinder, language, arrayList, str, str2, str42, equals, Build.MODEL, availableBytes2, z, str3, Build.VERSION.SDK_INT, str52);
                        }
                        str3 = string;
                        if (zzd2 == null) {
                        }
                        return new zzeul(zzd == null, zzd2 == null, country, zzw, isLatchsky, isSidewinder, language, arrayList, str, str2, str42, equals, Build.MODEL, availableBytes2, z, str3, Build.VERSION.SDK_INT, str52);
                    }
                }
                z = false;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlR)).booleanValue()) {
                }
                str3 = string;
                if (zzd2 == null) {
                }
                return new zzeul(zzd == null, zzd2 == null, country, zzw, isLatchsky, isSidewinder, language, arrayList, str, str2, str42, equals, Build.MODEL, availableBytes2, z, str3, Build.VERSION.SDK_INT, str52);
            }
        }
        str = null;
        packageInfo2 = Wrappers.packageManager(zzeunVar.zzb).getPackageInfo("com.android.vending", 128);
        if (packageInfo2 != null) {
        }
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeum
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeun.zzc(zzeun.this);
            }
        });
    }
}
