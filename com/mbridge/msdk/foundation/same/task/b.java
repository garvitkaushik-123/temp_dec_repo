package com.mbridge.msdk.foundation.same.task;

import android.content.Context;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.r0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoader.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    ThreadPoolExecutor f4334a;
    HashMap<Long, com.mbridge.msdk.foundation.same.task.a> b;
    WeakReference<Context> c;

    /* compiled from: CommonTaskLoader.java */
    class a implements a.InterfaceC0340a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.same.task.a f4335a;
        final /* synthetic */ a.InterfaceC0340a b;

        a(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0340a interfaceC0340a) {
            this.f4335a = aVar;
            this.b = interfaceC0340a;
        }

        @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0340a
        public void a(a.b bVar) {
            if (bVar == a.b.CANCEL) {
                b.this.b.remove(Long.valueOf(this.f4335a.getId()));
            } else if (bVar == a.b.FINISH) {
                b.this.b.remove(Long.valueOf(this.f4335a.getId()));
            } else if (bVar == a.b.RUNNING && b.this.c.get() == null) {
                b.this.a();
            }
            a.InterfaceC0340a interfaceC0340a = this.b;
            if (interfaceC0340a != null) {
                interfaceC0340a.a(bVar);
            }
        }
    }

    public b(Context context, int i) {
        if (r0.a().a("c_t_l_t_p", true)) {
            this.f4334a = c.b();
        } else {
            if (i == 0) {
                this.f4334a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f4334a = new ThreadPoolExecutor(i, (i * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f4334a.allowCoreThreadTimeOut(true);
        }
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    public void a(com.mbridge.msdk.foundation.same.task.a aVar) {
        a(aVar, null);
        this.f4334a.execute(aVar);
    }

    public void b(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0340a interfaceC0340a) {
        a(aVar, interfaceC0340a);
        this.f4334a.execute(aVar);
    }

    private synchronized void a(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0340a interfaceC0340a) {
        this.b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setOnStateChangeListener(new a(aVar, interfaceC0340a));
    }

    public b(Context context) {
        if (r0.a().a("c_t_l_t_p", true)) {
            this.f4334a = c.b();
        } else {
            if (r0.a().a("c_t_p_t_l", true)) {
                int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.f4334a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f4334a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f4334a.allowCoreThreadTimeOut(true);
        }
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    public synchronized void a() {
        try {
            Iterator<Map.Entry<Long, com.mbridge.msdk.foundation.same.task.a>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel();
            }
            this.b.clear();
        } catch (Exception unused) {
        }
    }
}
