package com.bytedance.sdk.openadsdk.multipro.aidl.DbA;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.Os.aAs;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class DbA extends IDislikeClosedListener.Stub {
    private final String DbA;
    private final kb.eli eli;

    public DbA(String str, kb.eli eliVar) {
        this.DbA = str;
        this.eli = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.DbA.DbA.1
            @Override // java.lang.Runnable
            public void run() {
                if (DbA.this.eli != null) {
                    DbA.this.eli.eli();
                    aAs.eli(6, DbA.this.DbA);
                }
            }
        });
    }
}
