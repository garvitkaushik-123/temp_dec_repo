package com.fyber.inneractive.sdk.config.cellular;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.fyber.inneractive.sdk.util.x0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public final class b extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f1075a = Executors.newSingleThreadExecutor();
    public h b;
    public final TelephonyManager c;

    public b(TelephonyManager telephonyManager, h hVar) {
        this.c = telephonyManager;
        this.b = hVar;
    }

    public final void a() {
        this.b = null;
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.unregisterTelephonyCallback(this);
        }
        this.f1075a.shutdownNow();
    }

    public final void b() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.registerTelephonyCallback(this.f1075a, this);
        }
    }

    public final void c() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.unregisterTelephonyCallback(this);
        }
    }

    @Override // android.telephony.TelephonyCallback.DisplayInfoListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        x0 x0Var;
        int networkType = telephonyDisplayInfo.getNetworkType();
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        if (overrideNetworkType == 2 || overrideNetworkType == 3 || overrideNetworkType == 5) {
            x0Var = x0.MOBILE_5G;
        } else if (networkType != 0) {
            if (networkType != 3) {
                if (networkType == 18) {
                    x0Var = x0.WIFI;
                } else if (networkType == 20) {
                    x0Var = x0.MOBILE_5G;
                } else if (networkType != 5 && networkType != 6) {
                    switch (networkType) {
                        default:
                            switch (networkType) {
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
        } else {
            x0Var = x0.UNKNOWN;
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(x0Var);
        }
    }
}
