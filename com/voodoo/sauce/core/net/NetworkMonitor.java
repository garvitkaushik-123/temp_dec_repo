package com.voodoo.sauce.core.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes7.dex */
public class NetworkMonitor {
    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback networkCallback;

    public interface NetworkListener {
        void onNetworkChange(boolean z);
    }

    public void start(Context context, final NetworkListener networkListener) {
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.voodoo.sauce.core.net.NetworkMonitor.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                networkListener.onNetworkChange(false);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                networkListener.onNetworkChange(NetworkMonitor.hasValidatedInternet(networkCapabilities));
            }
        };
        if (this.connectivityManager != null) {
            this.connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
            Network activeNetwork = this.connectivityManager.getActiveNetwork();
            boolean z = false;
            if (activeNetwork != null) {
                NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null && hasValidatedInternet(networkCapabilities)) {
                    z = true;
                }
                networkListener.onNetworkChange(z);
                return;
            }
            networkListener.onNetworkChange(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasValidatedInternet(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.hasCapability(16) && networkCapabilities.hasCapability(12);
    }

    public void stop() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.connectivityManager;
        if (connectivityManager != null && (networkCallback = this.networkCallback) != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
            this.networkCallback = null;
        }
        this.connectivityManager = null;
    }
}
