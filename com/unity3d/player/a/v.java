package com.unity3d.player.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes7.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f6537a;
    public int b;
    public final u c;

    public v(Context context) {
        NetworkCapabilities networkCapabilities;
        int i = 0;
        this.b = 0;
        u uVar = new u(this);
        this.c = uVar;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f6537a = connectivityManager;
        if (connectivityManager == null) {
            t.Log(6, "NetworkConnectivity: ConnectivityManager not found");
            return;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
            i = networkCapabilities.hasTransport(0) ? 1 : 2;
        }
        this.b = i;
        connectivityManager.registerDefaultNetworkCallback(uVar);
    }

    public final void a() {
        ConnectivityManager connectivityManager = this.f6537a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.c);
    }
}
