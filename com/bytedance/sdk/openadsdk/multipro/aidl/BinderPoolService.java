package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.FC;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.MGA;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.aGH;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.kb;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.ui;

/* loaded from: classes3.dex */
public class BinderPoolService extends Service {
    private static boolean Os;
    public static volatile boolean eli;
    private final Binder DbA = new eli();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        dV.DbA(getApplicationContext());
        eli = true;
        if (!Os) {
            FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService.1
                @Override // java.lang.Runnable
                public void run() {
                    NU.nY().eli(BinderPoolService.this.getApplicationContext());
                }
            });
        }
        Os = true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.DbA;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public static class eli extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            if (i == 0) {
                return kb.eli();
            }
            if (i == 1) {
                return ui.eli();
            }
            if (i == 4) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.eli.Os.eli();
            }
            if (i == 5) {
                return MGA.DbA();
            }
            if (i == 6) {
                return aGH.eli();
            }
            if (i != 7) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.multipro.aidl.eli.DbA.eli();
        }
    }
}
