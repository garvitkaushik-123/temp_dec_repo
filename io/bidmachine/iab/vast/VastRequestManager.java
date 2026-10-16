package io.bidmachine.iab.vast;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes7.dex */
public class VastRequestManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<VastRequest, Boolean> f6881a = new WeakHashMap();

    static synchronized void a(VastRequest vastRequest) {
        synchronized (VastRequestManager.class) {
            if (vastRequest == null) {
                return;
            }
            f6881a.remove(vastRequest);
        }
    }

    public static synchronized VastRequest get(String vastRequestId) {
        synchronized (VastRequestManager.class) {
            if (TextUtils.isEmpty(vastRequestId)) {
                return null;
            }
            Iterator<Map.Entry<VastRequest, Boolean>> it = f6881a.entrySet().iterator();
            while (it.hasNext()) {
                VastRequest key = it.next().getKey();
                if (key.getId().equals(vastRequestId)) {
                    return key;
                }
            }
            return null;
        }
    }

    public static synchronized void store(VastRequest vastRequest) {
        synchronized (VastRequestManager.class) {
            if (vastRequest == null) {
                return;
            }
            f6881a.put(vastRequest, Boolean.TRUE);
        }
    }
}
