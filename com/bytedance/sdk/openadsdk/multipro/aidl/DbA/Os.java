package com.bytedance.sdk.openadsdk.multipro.aidl.DbA;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class Os extends IFullScreenVideoAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.eli.Os.DbA eli;

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    public Os(com.bytedance.sdk.openadsdk.eli.Os.DbA dbA) {
        this.eli = dbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        this.eli = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.Os.1
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.eli != null) {
                    Os.this.eli.eli();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.Os.2
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.eli != null) {
                    Os.this.eli.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.Os.3
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.eli != null) {
                    Os.this.eli.DbA();
                }
                Os.this.eli();
            }
        });
    }
}
