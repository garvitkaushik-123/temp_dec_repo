package com.ironsource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Rb implements InterfaceC3279r7 {

    /* renamed from: a, reason: collision with root package name */
    private String f3030a = "Rb";
    private int b = 23;
    private final InterfaceC3296s7 c;
    private ConnectivityManager.NetworkCallback d;

    class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3031a;

        a(Context context) {
            this.f3031a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network != null) {
                Rb.this.c.a(C2986a4.a(network, this.f3031a), C2986a4.a(this.f3031a, network));
                return;
            }
            InterfaceC3296s7 interfaceC3296s7 = Rb.this.c;
            String b = C2986a4.b(this.f3031a);
            Context context = this.f3031a;
            interfaceC3296s7.a(b, C2986a4.a(context, C2986a4.a(context)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                Rb.this.c.b(C2986a4.a(network, this.f3031a), C2986a4.a(this.f3031a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                Rb.this.c.b(C2986a4.a(network, this.f3031a), C2986a4.a(this.f3031a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (C2986a4.b(this.f3031a).equals("none")) {
                Rb.this.c.a();
            }
        }
    }

    public Rb(InterfaceC3296s7 interfaceC3296s7) {
        this.c = interfaceC3296s7;
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void a(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.b || this.d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.d);
        } catch (Exception e) {
            C3260q4.d().a(e);
            Log.e(this.f3030a, "NetworkCallback for was not registered or already unregistered");
        }
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.b) {
            a(context);
            if (C2986a4.b(context).equals("none")) {
                this.c.a();
            }
            if (this.d == null) {
                this.d = new a(context);
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, this.d);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                Log.e(this.f3030a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.ironsource.InterfaceC3279r7
    public JSONObject c(Context context) {
        return C2986a4.a(context, C2986a4.a(context));
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void a() {
        this.d = null;
    }
}
