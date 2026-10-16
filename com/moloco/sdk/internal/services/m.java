package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m {
    public static final PackageInfo a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            Intrinsics.checkNotNull(packageInfo);
            return packageInfo;
        }
        PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        Intrinsics.checkNotNull(packageInfo2);
        return packageInfo2;
    }
}
