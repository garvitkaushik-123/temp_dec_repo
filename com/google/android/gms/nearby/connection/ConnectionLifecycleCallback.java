package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class ConnectionLifecycleCallback {
    public void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
    }

    public abstract void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(String str, ConnectionResolution connectionResolution);

    public abstract void onDisconnected(String str);
}
