package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.f0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class InneractiveAdSpotManager {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1156a = new ConcurrentHashMap();

    public static void destroy() {
        ConcurrentHashMap concurrentHashMap = get().f1156a;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) concurrentHashMap.get((String) it.next());
            if (inneractiveAdSpot != null) {
                inneractiveAdSpot.destroy();
            }
        }
        concurrentHashMap.clear();
    }

    public static InneractiveAdSpotManager get() {
        return e.f1166a;
    }

    public void bindSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.f1156a.put(inneractiveAdSpot.getLocalUniqueId(), inneractiveAdSpot);
    }

    public InneractiveAdSpot createSpot() {
        f0 f0Var = new f0();
        this.f1156a.put(f0Var.f1202a, f0Var);
        return f0Var;
    }

    public InneractiveAdSpot getSpot(String str) {
        return (InneractiveAdSpot) this.f1156a.get(str);
    }

    public void removeSpot(InneractiveAdSpot inneractiveAdSpot) {
        ConcurrentHashMap concurrentHashMap = this.f1156a;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(inneractiveAdSpot.getLocalUniqueId());
        }
    }
}
