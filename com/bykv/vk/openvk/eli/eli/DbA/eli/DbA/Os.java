package com.bykv.vk.openvk.eli.eli.DbA.eli.DbA;

import android.content.Context;
import com.bykv.vk.openvk.eli.eli.eli.ui.eli;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class Os {
    public static final ConcurrentHashMap<String, DbA> eli = new ConcurrentHashMap<>();

    public static synchronized void eli(Context context, com.bykv.vk.openvk.eli.eli.eli.Os.Os os, eli.InterfaceC0111eli interfaceC0111eli) {
        synchronized (Os.class) {
            if (os == null) {
                return;
            }
            ConcurrentHashMap<String, DbA> concurrentHashMap = eli;
            DbA dbA = concurrentHashMap.get(os.dV());
            if (dbA == null) {
                dbA = new DbA(context, os);
                concurrentHashMap.put(os.dV(), dbA);
                new Object[]{"preloadVideo:  cache size = ", Integer.valueOf(os.MGA()), os.dV()};
            }
            dbA.eli(interfaceC0111eli);
            new Object[]{"preloadVideo:  cache size = ", Integer.valueOf(os.MGA()), os.dV()};
        }
    }

    public static synchronized void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        synchronized (Os.class) {
            DbA remove = eli.remove(os.dV());
            if (remove != null) {
                remove.eli(true);
            }
            new Object[]{"removePreload:  cache size = ", Integer.valueOf(os.MGA()), os.dV()};
        }
    }
}
