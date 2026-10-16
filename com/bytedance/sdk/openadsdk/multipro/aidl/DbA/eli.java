package com.bytedance.sdk.openadsdk.multipro.aidl.DbA;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class eli extends IAppOpenAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.eli.aGH.DbA eli;

    public eli(com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA) {
        this.eli = dbA;
    }

    private void eli() {
        this.eli = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onDestroy() throws RemoteException {
        eli();
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.eli.1
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.eli();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdClicked() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.eli.2
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdSkip() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.eli.3
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.DbA();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdTimeOver() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.eli.4
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.Os();
                }
            }
        });
    }
}
