package com.mbridge.msdk.dycreator.viewobserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ConcreteSubject.java */
/* loaded from: classes6.dex */
public class d extends a {
    public void a(Object obj) {
        i iVar;
        try {
            synchronized (this) {
                ConcurrentHashMap<Integer, Object> concurrentHashMap = this.b;
                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                    for (Map.Entry<Integer, Object> entry : this.b.entrySet()) {
                        if (entry != null && (entry.getValue() instanceof i) && (iVar = (i) entry.getValue()) != null) {
                            iVar.a(obj);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
