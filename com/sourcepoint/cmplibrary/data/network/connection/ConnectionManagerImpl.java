package com.sourcepoint.cmplibrary.data.network.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionManagerImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManagerImpl;", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "isConnected", "", "()Z", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ConnectionManagerImpl implements ConnectionManager {

    /* renamed from: connectivityManager$delegate, reason: from kotlin metadata */
    private final Lazy connectivityManager;
    private final Context context;

    public ConnectionManagerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.connectivityManager = LazyKt.lazy(new Function0<ConnectivityManager>() { // from class: com.sourcepoint.cmplibrary.data.network.connection.ConnectionManagerImpl$connectivityManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConnectivityManager invoke() {
                Context context2;
                context2 = ConnectionManagerImpl.this.context;
                Object systemService = context2.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                return (ConnectivityManager) systemService;
            }
        });
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager.getValue();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager
    public boolean isConnected() {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = getConnectivityManager().getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = getConnectivityManager().getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }
}
