package com.bytedance.sdk.openadsdk.core.act;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

/* loaded from: classes3.dex */
public class ActServiceConnection extends CustomTabsServiceConnection {
    private DbA mConnectionCallback;

    public ActServiceConnection(DbA dbA) {
        this.mConnectionCallback = dbA;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        DbA dbA = this.mConnectionCallback;
        if (dbA != null) {
            dbA.eli(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        DbA dbA = this.mConnectionCallback;
        if (dbA != null) {
            dbA.eli();
        }
    }
}
