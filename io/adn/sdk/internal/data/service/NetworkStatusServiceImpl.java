package io.adn.sdk.internal.data.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat;
import io.adn.sdk.internal.domain.model.metrics.ConnectionInfo;
import io.adn.sdk.internal.domain.model.metrics.ConnectionType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: NetworkStatusService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/data/service/NetworkStatusServiceImpl;", "Lio/adn/sdk/internal/data/service/NetworkStatusService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "connectionInfoFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/domain/model/metrics/ConnectionInfo;", "networkCallback", "Lio/adn/sdk/internal/data/service/NetworkStatusServiceImpl$NetworkStateCallback;", "registerNetworkCallback", "", "currentConnectionInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitConnection", "currentConnectionType", "", "isNetworkAvailable", "", "refreshConnectionInfo", "determineConnectionInfo", "legacyConnectionInfo", "mapMobileConnectionType", "Lio/adn/sdk/internal/domain/model/metrics/ConnectionType;", "type", "", "NetworkStateCallback", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NetworkStatusServiceImpl implements NetworkStatusService {
    public static final int $stable = 8;
    private final MutableStateFlow<ConnectionInfo> connectionInfoFlow;
    private final ConnectivityManager connectivityManager;
    private final NetworkStateCallback networkCallback;

    public NetworkStatusServiceImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this.connectionInfoFlow = StateFlowKt.MutableStateFlow(null);
        this.networkCallback = new NetworkStateCallback();
        registerNetworkCallback();
        refreshConnectionInfo();
    }

    private final void registerNetworkCallback() {
        try {
            Result.Companion companion = Result.INSTANCE;
            NetworkStatusServiceImpl networkStatusServiceImpl = this;
            this.connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.data.service.NetworkStatusService
    public Object currentConnectionInfo(Continuation<? super ConnectionInfo> continuation) {
        return this.connectionInfoFlow.getValue();
    }

    @Override // io.adn.sdk.internal.data.service.NetworkStatusService
    public Object awaitConnection(Continuation<? super ConnectionInfo> continuation) {
        refreshConnectionInfo();
        return FlowKt.first(FlowKt.filterNotNull(this.connectionInfoFlow), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.data.service.NetworkStatusService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object currentConnectionType(Continuation<? super String> continuation) {
        NetworkStatusServiceImpl$currentConnectionType$1 networkStatusServiceImpl$currentConnectionType$1;
        int i;
        if (continuation instanceof NetworkStatusServiceImpl$currentConnectionType$1) {
            networkStatusServiceImpl$currentConnectionType$1 = (NetworkStatusServiceImpl$currentConnectionType$1) continuation;
            if ((networkStatusServiceImpl$currentConnectionType$1.label & Integer.MIN_VALUE) != 0) {
                networkStatusServiceImpl$currentConnectionType$1.label -= Integer.MIN_VALUE;
                Object obj = networkStatusServiceImpl$currentConnectionType$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkStatusServiceImpl$currentConnectionType$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    networkStatusServiceImpl$currentConnectionType$1.label = 1;
                    obj = currentConnectionInfo(networkStatusServiceImpl$currentConnectionType$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ConnectionInfo connectionInfo = (ConnectionInfo) obj;
                return connectionInfo != null ? "offline" : "offline";
            }
        }
        networkStatusServiceImpl$currentConnectionType$1 = new NetworkStatusServiceImpl$currentConnectionType$1(this, continuation);
        Object obj2 = networkStatusServiceImpl$currentConnectionType$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkStatusServiceImpl$currentConnectionType$1.label;
        if (i != 0) {
        }
        ConnectionInfo connectionInfo2 = (ConnectionInfo) obj2;
        return connectionInfo2 != null ? "offline" : "offline";
    }

    @Override // io.adn.sdk.internal.data.service.NetworkStatusService
    public boolean isNetworkAvailable() {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = this.connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshConnectionInfo() {
        this.connectionInfoFlow.setValue(determineConnectionInfo());
    }

    private final ConnectionInfo determineConnectionInfo() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            NetworkStatusServiceImpl networkStatusServiceImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(legacyConnectionInfo());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        ConnectionInfo connectionInfo = new ConnectionInfo(false, ConnectionType.Unknown);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = connectionInfo;
        }
        return (ConnectionInfo) m10241constructorimpl;
    }

    private final ConnectionInfo legacyConnectionInfo() {
        ConnectionType mapMobileConnectionType;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            mapMobileConnectionType = mapMobileConnectionType(activeNetworkInfo.getSubtype());
        } else if (type == 1) {
            mapMobileConnectionType = ConnectionType.WIFI;
        } else if (type == 9) {
            mapMobileConnectionType = ConnectionType.Ethernet;
        } else {
            mapMobileConnectionType = ConnectionType.Unknown;
        }
        return new ConnectionInfo(ConnectivityManagerCompat.isActiveNetworkMetered(this.connectivityManager), mapMobileConnectionType);
    }

    private final ConnectionType mapMobileConnectionType(int type) {
        if (type != 20) {
            switch (type) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return ConnectionType.Mobile2g;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return ConnectionType.Mobile3g;
                case 13:
                    return ConnectionType.Mobile4g;
                default:
                    return ConnectionType.MobileUnknown;
            }
        }
        return ConnectionType.Mobile5g;
    }

    /* compiled from: NetworkStatusService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/data/service/NetworkStatusServiceImpl$NetworkStateCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "<init>", "(Lio/adn/sdk/internal/data/service/NetworkStatusServiceImpl;)V", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        public NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            NetworkStatusServiceImpl.this.refreshConnectionInfo();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            NetworkStatusServiceImpl.this.connectionInfoFlow.setValue(null);
        }
    }
}
