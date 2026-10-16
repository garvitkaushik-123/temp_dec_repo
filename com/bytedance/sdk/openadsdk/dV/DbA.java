package com.bytedance.sdk.openadsdk.dV;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.List;

/* loaded from: classes3.dex */
public interface DbA {
    Context getContext();

    Handler getHandler();

    int getOnceLogCount();

    int getOnceLogInterval();

    HandlerThread getSafeHandlerThread(String str, int i);

    int getUploadIntervalTime();

    boolean isMonitorOpen();

    void onMonitorUpload(List<com.bytedance.sdk.openadsdk.dV.DbA.eli> list);
}
