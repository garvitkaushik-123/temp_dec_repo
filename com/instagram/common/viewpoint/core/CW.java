package com.instagram.common.viewpoint.core;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;

/* loaded from: assets/audience_network/classes2.dex */
public final class CW extends ConnectivityManager.NetworkCallback {
    public boolean A00;
    public boolean A01;
    public final /* synthetic */ CX A02;

    public CW(CX cx) {
        this.A02 = cx;
    }

    private void A00() {
        Handler handler;
        handler = this.A02.A04;
        handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.CU
            @Override // java.lang.Runnable
            public final void run() {
                CW.this.A02();
            }
        });
    }

    private void A01() {
        Handler handler;
        handler = this.A02.A04;
        handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.CV
            @Override // java.lang.Runnable
            public final void run() {
                CW.this.A03();
            }
        });
    }

    public final /* synthetic */ void A02() {
        CW cw;
        cw = this.A02.A02;
        if (cw == null) {
            return;
        }
        this.A02.A03();
    }

    public final /* synthetic */ void A03() {
        CW cw;
        cw = this.A02.A02;
        if (cw == null) {
            return;
        }
        this.A02.A04();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        A00();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onBlockedStatusChanged(Network network, boolean z) {
        if (!z) {
            A01();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        boolean hasCapability = networkCapabilities.hasCapability(16);
        boolean networkValidated = this.A01;
        if (networkValidated) {
            boolean networkValidated2 = this.A00;
            if (networkValidated2 == hasCapability) {
                if (!hasCapability) {
                    return;
                }
                A01();
                return;
            }
        }
        this.A01 = true;
        this.A00 = hasCapability;
        A00();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        A00();
    }
}
