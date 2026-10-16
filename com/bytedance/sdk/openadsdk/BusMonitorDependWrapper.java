package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.dV.DbA;
import com.bytedance.sdk.openadsdk.dV.DbA.eli;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes3.dex */
public class BusMonitorDependWrapper implements DbA {
    private Handler DbA;
    private DbA eli;

    public BusMonitorDependWrapper(DbA dbA) {
        this.eli = dbA;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public Context getContext() {
        DbA dbA = this.eli;
        if (dbA != null && dbA.getContext() != null) {
            return this.eli.getContext();
        }
        return getReflectContext();
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public Handler getHandler() {
        DbA dbA = this.eli;
        if (dbA != null && dbA.getHandler() != null) {
            return this.eli.getHandler();
        }
        if (this.DbA == null) {
            this.DbA = new Handler(getSafeHandlerThread("pag_monitor", 0).getLooper());
        }
        return this.DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public int getUploadIntervalTime() {
        int uploadIntervalTime;
        DbA dbA = this.eli;
        return (dbA == null || (uploadIntervalTime = dbA.getUploadIntervalTime()) < 1800000) ? Constants.THIRTY_MINUTES : uploadIntervalTime;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public boolean isMonitorOpen() {
        DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.isMonitorOpen();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public void onMonitorUpload(List<eli> list) {
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.onMonitorUpload(list);
        }
    }

    public static Context getReflectContext() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            return (Application) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public int getOnceLogCount() {
        DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.getOnceLogCount();
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public int getOnceLogInterval() {
        DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.getOnceLogInterval();
        }
        return 1000;
    }

    @Override // com.bytedance.sdk.openadsdk.dV.DbA
    public HandlerThread getSafeHandlerThread(String str, int i) {
        HandlerThread safeHandlerThread;
        DbA dbA = this.eli;
        if (dbA != null && (safeHandlerThread = dbA.getSafeHandlerThread(str, i)) != null) {
            return safeHandlerThread;
        }
        HandlerThread handlerThread = new HandlerThread("pag_monitor");
        handlerThread.start();
        return handlerThread;
    }
}
