package com.mbridge.msdk.dycreator.viewobserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ReportSubject.java */
/* loaded from: classes6.dex */
public class h extends a {
    public void a(Object obj) {
        g gVar;
        ConcurrentHashMap<Integer, Object> concurrentHashMap = this.b;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<Integer, Object> entry : this.b.entrySet()) {
            if (entry != null) {
                try {
                    if (entry.getValue() != null && (gVar = (g) entry.getValue()) != null) {
                        gVar.a(obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
