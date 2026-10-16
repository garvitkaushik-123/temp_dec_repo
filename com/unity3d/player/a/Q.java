package com.unity3d.player.a;

import android.app.Activity;
import android.os.Build;
import com.unity3d.player.UnityPlayer;
import java.lang.Thread;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class Q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public volatile Thread.UncaughtExceptionHandler f6523a;
    public String b;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        String str;
        try {
            StringBuilder append = new StringBuilder().append("FATAL EXCEPTION [" + thread.getName() + "]\n").append("Unity version     : 6000.3.12f1\n").append("Device model      : " + Build.MANUFACTURER + " " + Build.MODEL + "\n");
            String str2 = Build.FINGERPRINT;
            StringBuilder sb = new StringBuilder("Device fingerprint: ");
            sb.append(str2);
            sb.append("\n");
            StringBuilder append2 = append.append(sb.toString()).append("CPU supported ABI : " + Arrays.toString(Build.SUPPORTED_ABIS) + "\n").append("Build Type        : Release\nScripting Backend : IL2CPP\n").append("Libs loaded from  : " + this.b + "\n");
            try {
                Activity activity = UnityPlayer.currentActivity;
                str = String.valueOf(activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData.getBoolean("unity.strip-engine-code"));
            } catch (Exception unused) {
                str = "Undefined";
            }
            Error error = new Error(append2.append("Strip Engine Code : " + str + "\n").toString());
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f6523a.uncaughtException(thread, error);
        } catch (Throwable unused2) {
            this.f6523a.uncaughtException(thread, th);
        }
    }
}
