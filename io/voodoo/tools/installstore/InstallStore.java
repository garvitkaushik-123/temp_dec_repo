package io.voodoo.tools.installstore;

import android.app.Activity;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes8.dex */
public class InstallStore {
    public static String get(String str, String str2) {
        String installerPackageName;
        try {
            Activity activity = UnityPlayer.currentActivity;
            PackageManager packageManager = activity.getPackageManager();
            String packageName = activity.getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                InstallSourceInfo installSourceInfo = packageManager.getInstallSourceInfo(packageName);
                installerPackageName = installSourceInfo != null ? installSourceInfo.getInstallingPackageName() : null;
            } else {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            }
            if (installerPackageName != null) {
                if (!installerPackageName.isEmpty()) {
                    return installerPackageName;
                }
            }
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }
}
