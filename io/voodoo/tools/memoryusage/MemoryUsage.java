package io.voodoo.tools.memoryusage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

/* loaded from: classes8.dex */
public class MemoryUsage {
    public static long getSystemMemoryUsage(Context context) {
        try {
            if (((ActivityManager) context.getSystemService("activity")) != null) {
                return r4.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPrivateDirty() * 1024;
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }
}
