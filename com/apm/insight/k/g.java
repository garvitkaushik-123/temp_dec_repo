package com.apm.insight.k;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.apm.insight.Npth;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

/* compiled from: EventUploadQueue.java */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> f280a = new ConcurrentHashMap<>();
    private static final HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> b = new HashMap<>();
    private static volatile g c;
    private volatile boolean e = false;
    private Runnable f = new Runnable() { // from class: com.apm.insight.k.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (Npth.isStopUpload()) {
                return;
            }
            if (!g.b.isEmpty() && l.e()) {
                g.f();
            }
            g.this.c();
            g.this.d.a(g.this.f, 30000L);
        }
    };
    private final p d = m.a();

    private g() {
    }

    public static g a() {
        if (c == null) {
            synchronized (g.class) {
                if (c == null) {
                    c = new g();
                }
            }
        }
        return c;
    }

    public static void a(com.apm.insight.entity.c cVar) {
        a(com.apm.insight.d.a(), cVar);
    }

    public static void a(final Object obj, final com.apm.insight.entity.c cVar) {
        String str;
        Handler a2 = m.a().a();
        if (a2 == null || a2.getLooper() != Looper.myLooper()) {
            m.a().a(new Runnable() { // from class: com.apm.insight.k.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    g.a(obj, cVar);
                }
            });
            return;
        }
        if (obj == null) {
            obj = com.apm.insight.d.a();
        }
        if (!l.e()) {
            com.apm.insight.a.a("EventUploadQueue", "enqueue before init.");
            c(obj, cVar);
            return;
        }
        if (!com.apm.insight.runtime.a.a(obj)) {
            a.b();
        }
        f();
        try {
            str = cVar.c().getString("log_type");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        if (!TextUtils.isEmpty(str) && com.apm.insight.runtime.a.b(obj)) {
            com.apm.insight.a.a("EventUploadQueue", "logType " + str + " enqueued");
            b(obj, cVar);
        } else {
            com.apm.insight.a.a("EventUploadQueue", "logType " + str + " not sampled");
        }
    }

    private static void b(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> concurrentHashMap;
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        synchronized (obj) {
            concurrentHashMap = f280a;
            concurrentLinkedQueue = concurrentHashMap.get(obj);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                concurrentHashMap.put(obj, concurrentLinkedQueue);
            }
        }
        concurrentLinkedQueue.add(cVar);
        int size = concurrentHashMap.size();
        boolean z = size >= 30;
        com.apm.insight.a.b((Object) "[enqueue] size=".concat(String.valueOf(size)));
        if (z) {
            g();
        }
    }

    private static void c(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        try {
            String string = cVar.c().getString("log_type");
            HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> hashMap = b;
            synchronized (hashMap) {
                HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>> hashMap2 = hashMap.get(string);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(obj, hashMap2);
                }
                concurrentLinkedQueue = hashMap2.get(string);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    hashMap2.put(string, concurrentLinkedQueue);
                }
            }
            concurrentLinkedQueue.add(cVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        HashMap hashMap;
        HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> hashMap2 = b;
        synchronized (hashMap2) {
            hashMap = new HashMap(hashMap2);
            hashMap2.clear();
        }
        if (!com.apm.insight.runtime.a.a()) {
            com.apm.insight.a.a("EventUploadQueue", "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (com.apm.insight.runtime.a.a() && !com.apm.insight.runtime.a.b(entry.getKey()))) {
                    com.apm.insight.a.a("EventUploadQueue", "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            com.apm.insight.entity.c cVar = (com.apm.insight.entity.c) concurrentLinkedQueue.poll();
                            if (cVar != null) {
                                b(entry.getKey(), cVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private static void g() {
        if (!l.e() || Npth.isStopUpload()) {
            return;
        }
        try {
            m.a().a(new Runnable() { // from class: com.apm.insight.k.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    g.a().c();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        if (f280a.isEmpty()) {
            this.d.a(this.f, 30000L);
        } else {
            this.d.a(this.f);
        }
    }

    public final void c() {
        synchronized (this.d) {
            if (this.e) {
                return;
            }
            this.e = true;
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> entry : f280a.entrySet()) {
                ConcurrentLinkedQueue<com.apm.insight.entity.c> value = entry.getValue();
                Object key = entry.getKey();
                while (!value.isEmpty()) {
                    for (int i = 0; i < 30; i++) {
                        try {
                            if (value.isEmpty()) {
                                break;
                            }
                            linkedList.add(value.poll());
                        } catch (Throwable th) {
                            com.apm.insight.a.b(th);
                        }
                    }
                    if (linkedList.isEmpty()) {
                        break;
                    }
                    com.apm.insight.entity.a a2 = com.apm.insight.runtime.a.f.a().a(linkedList, com.apm.insight.entity.b.a(key));
                    if (a2 != null) {
                        com.apm.insight.a.a((Object) "upload events");
                        d.a().b(a2.c());
                    }
                    linkedList.clear();
                }
            }
            this.e = false;
        }
    }
}
