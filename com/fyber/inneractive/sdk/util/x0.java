package com.fyber.inneractive.sdk.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.ironsource.Z3;

/* loaded from: classes4.dex */
public enum x0 {
    UNKNOWN(""),
    ETHERNET(Z3.f3155a),
    WIFI(Z3.b),
    MOBILE_3G(Z3.f3155a),
    MOBILE_4G("4g"),
    MOBILE_5G("5g"),
    CELLULAR("Cellular");

    final String key;

    x0(String str) {
        this.key = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static x0 a() {
        int i;
        x0 x0Var;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) o.f1770a.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (o.a("android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            i = activeNetworkInfo.getType();
            if (i != 9) {
                return ETHERNET;
            }
            if (i != 0) {
                if (i == 1) {
                    return WIFI;
                }
                if (i != 2 && i != 3 && i != 4 && i != 5) {
                    return UNKNOWN;
                }
            }
            com.fyber.inneractive.sdk.config.cellular.a aVar = IAConfigManager.O.N;
            if (aVar == null || aVar.f1074a == null) {
                int k = k.k();
                if (k != 0) {
                    if (k != 3) {
                        if (k == 18) {
                            x0Var = WIFI;
                        } else if (k == 20) {
                            x0Var = MOBILE_5G;
                        } else if (k != 5 && k != 6) {
                            switch (k) {
                                default:
                                    switch (k) {
                                        case 12:
                                        case 14:
                                        case 15:
                                            break;
                                        case 13:
                                            x0Var = MOBILE_4G;
                                            break;
                                        default:
                                            x0Var = CELLULAR;
                                            break;
                                    }
                                case 8:
                                case 9:
                                case 10:
                                    x0Var = MOBILE_3G;
                                    break;
                            }
                        }
                    }
                    x0Var = MOBILE_3G;
                } else {
                    x0Var = UNKNOWN;
                }
            } else {
                x0Var = aVar.b;
            }
            return x0Var == UNKNOWN ? k.k() == 13 ? MOBILE_4G : MOBILE_3G : x0Var;
        }
        i = 8;
        if (i != 9) {
        }
    }

    public final String b() {
        return this.key;
    }
}
