package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.MGA;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.aGH;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.kb;
import com.bytedance.sdk.openadsdk.multipro.aidl.eli.ui;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class eli {
    private static final eli DbA = new eli();
    private DbA Os;
    private IBinderPool eli;
    private long aGH = 0;
    private final ServiceConnection ui = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.eli.2
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            cyF.eli(new wC("onServiceConnected") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.eli.2.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.eli = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        eli.this.eli.asBinder().linkToDeath(eli.this.MGA, 0);
                    } catch (RemoteException e) {
                        Xb.eli("TTAD.BinderPool", "onServiceConnected throws :", e);
                    }
                    System.currentTimeMillis();
                    long unused = eli.this.aGH;
                    if (eli.this.Os != null) {
                        eli.this.Os.onServiceConnected();
                    }
                }
            }, 5);
        }
    };
    private final IBinder.DeathRecipient MGA = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.eli.3
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            cyF.eli(new wC("binderDied") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.eli.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (eli.this.eli.asBinder().isBinderAlive()) {
                            eli.this.eli.asBinder().unlinkToDeath(eli.this.MGA, 0);
                        }
                    } catch (Exception e) {
                        Xb.Os("TTAD.BinderPool", e.getMessage());
                    }
                    eli.this.eli = null;
                    eli.this.aGH();
                }
            }, 5);
        }
    };

    private eli() {
        aGH();
    }

    public static eli eli() {
        return DbA;
    }

    public void DbA() {
        try {
            Context eli = dV.eli();
            eli.startService(new Intent(eli, (Class<?>) BinderPoolService.class));
        } catch (Exception unused) {
        }
    }

    public void Os() {
        try {
            Context eli = dV.eli();
            eli.bindService(new Intent(eli, (Class<?>) BinderPoolService.class), this.ui, 1);
            this.aGH = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }

    public void eli(DbA dbA) {
        this.Os = dbA;
        if (this.eli != null) {
            cyF.eli(new wC("onServiceConnected2") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.Os != null) {
                        eli.this.Os.onServiceConnected();
                    }
                }
            }, 5);
        }
    }

    public IBinder eli(int i) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                try {
                    IBinderPool iBinderPool = this.eli;
                    if (iBinderPool != null) {
                        return iBinderPool.queryBinder(i);
                    }
                    return null;
                } catch (RemoteException e) {
                    Xb.Os("TTAD.BinderPool", e.getMessage());
                    dZ.wC("queryBinder error");
                    return null;
                }
            }
            if (i == 0) {
                return kb.eli();
            }
            if (i == 1) {
                return ui.eli();
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
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            Os();
        }
    }
}
