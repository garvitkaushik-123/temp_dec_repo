package com.bytedance.sdk.openadsdk.multipro.aidl.DbA;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class aGH extends IRewardAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.eli.ui.eli eli;

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    public aGH(com.bytedance.sdk.openadsdk.eli.ui.eli eliVar) {
        this.eli = eliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        this.eli = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.eli != null) {
                    aGH.this.eli.eli();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH.2
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.eli != null) {
                    aGH.this.eli.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH.3
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.eli != null) {
                    aGH.this.eli.DbA();
                }
                aGH.this.eli();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.aGH.4
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.eli != null) {
                    aGH.this.eli.eli(z, i, str, i2, str2);
                }
            }
        });
    }
}
