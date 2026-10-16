package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC3183lc;
import com.ironsource.environment.thread.IronSourceThreadManager;

/* loaded from: classes6.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private ConnectivityManager f3280a;
    private InterfaceC3183lc b;
    private boolean c = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkStateReceiver networkStateReceiver = NetworkStateReceiver.this;
            InterfaceC3183lc interfaceC3183lc = networkStateReceiver.b;
            if (interfaceC3183lc != null) {
                interfaceC3183lc.a(networkStateReceiver.c);
            }
        }
    }

    public NetworkStateReceiver(Context context, InterfaceC3183lc interfaceC3183lc) {
        this.b = interfaceC3183lc;
        if (context != null) {
            this.f3280a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        a();
    }

    private boolean a() {
        boolean z = this.c;
        ConnectivityManager connectivityManager = this.f3280a;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                this.c = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            } catch (Exception e) {
                C3260q4.d().a(e);
                this.c = false;
            }
        } else {
            this.c = false;
        }
        return z != this.c;
    }

    private void b() {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null || !a()) {
            return;
        }
        b();
    }
}
