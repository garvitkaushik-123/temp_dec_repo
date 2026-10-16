package com.fyber.inneractive.sdk.config.cellular;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k;
import com.fyber.inneractive.sdk.util.x0;

/* loaded from: classes4.dex */
public final class f extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public h f1077a;
    public final ConnectivityManager b;

    public f(ConnectivityManager connectivityManager, h hVar) {
        this.f1077a = hVar;
        this.b = connectivityManager;
    }

    public final void a() {
        this.f1077a = null;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to unregister network callback", th, new Object[0]);
            }
        }
    }

    public final void b() {
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to register network callback", th, new Object[0]);
            }
        }
    }

    public final void c() {
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to unregister network callback", th, new Object[0]);
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        x0 x0Var = x0.UNKNOWN;
        if (networkCapabilities.hasTransport(3)) {
            x0Var = x0.ETHERNET;
        } else if (networkCapabilities.hasTransport(0)) {
            int k = k.k();
            if (k != 0) {
                if (k != 3) {
                    if (k == 18) {
                        x0Var = x0.WIFI;
                    } else if (k == 20) {
                        x0Var = x0.MOBILE_5G;
                    } else if (k != 5 && k != 6) {
                        switch (k) {
                            default:
                                switch (k) {
                                    case 12:
                                    case 14:
                                    case 15:
                                        break;
                                    case 13:
                                        x0Var = x0.MOBILE_4G;
                                        break;
                                    default:
                                        x0Var = x0.CELLULAR;
                                        break;
                                }
                            case 8:
                            case 9:
                            case 10:
                                x0Var = x0.MOBILE_3G;
                                break;
                        }
                    }
                }
                x0Var = x0.MOBILE_3G;
            }
        } else if (networkCapabilities.hasTransport(1)) {
            x0Var = x0.WIFI;
        }
        h hVar = this.f1077a;
        if (hVar != null) {
            hVar.a(x0Var);
        }
    }
}
