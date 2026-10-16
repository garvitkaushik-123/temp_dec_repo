package io.bidmachine;

import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.utils.BMError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
class NetworkRequestManager {
    private static volatile NetworkRequestManager instance;
    private final Object lock = new Object();
    final Map<String, NetworkRequest<?, Response, BMError>> networkRequestMap = new HashMap();

    NetworkRequestManager() {
    }

    public static NetworkRequestManager get() {
        NetworkRequestManager networkRequestManager;
        NetworkRequestManager networkRequestManager2 = instance;
        if (networkRequestManager2 != null) {
            return networkRequestManager2;
        }
        synchronized (NetworkRequestManager.class) {
            networkRequestManager = instance;
            if (networkRequestManager == null) {
                networkRequestManager = new NetworkRequestManager();
                instance = networkRequestManager;
            }
        }
        return networkRequestManager;
    }

    public boolean contains(String id) {
        boolean containsKey;
        synchronized (this.lock) {
            containsKey = this.networkRequestMap.containsKey(id);
        }
        return containsKey;
    }

    public void add(String id, NetworkRequest<?, Response, BMError> networkRequest) {
        synchronized (this.lock) {
            this.networkRequestMap.put(id, networkRequest);
        }
    }

    public NetworkRequest<?, Response, BMError> remove(String id) {
        NetworkRequest<?, Response, BMError> remove;
        synchronized (this.lock) {
            remove = this.networkRequestMap.remove(id);
        }
        return remove;
    }
}
