package com.iab.omid.library.bytedance2.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.bytedance2.processor.a;
import com.iab.omid.library.bytedance2.utils.f;
import com.iab.omid.library.bytedance2.utils.h;
import com.iab.omid.library.bytedance2.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0248a {
    private static TreeWalker i = new TreeWalker();
    private static Handler j = new Handler(Looper.getMainLooper());
    private static Handler k = null;
    private static final Runnable l = new b();
    private static final Runnable m = new c();
    private int b;
    private long h;

    /* renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f1946a = new ArrayList();
    private boolean c = false;
    private final List<com.iab.omid.library.bytedance2.weakreference.a> d = new ArrayList();
    private com.iab.omid.library.bytedance2.walking.a f = new com.iab.omid.library.bytedance2.walking.a();
    private com.iab.omid.library.bytedance2.processor.b e = new com.iab.omid.library.bytedance2.processor.b();
    private com.iab.omid.library.bytedance2.walking.b g = new com.iab.omid.library.bytedance2.walking.b(new com.iab.omid.library.bytedance2.walking.async.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.g.b();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.k != null) {
                TreeWalker.k.post(TreeWalker.l);
                TreeWalker.k.postDelayed(TreeWalker.m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void a(long j2) {
        if (this.f1946a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f1946a) {
                treeWalkerTimeLogger.onTreeProcessed(this.b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.b, j2);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.bytedance2.walking.c cVar, boolean z) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.bytedance2.processor.a b2 = this.e.b();
        String b3 = this.f.b(str);
        if (b3 != null) {
            JSONObject a2 = b2.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(a2, str);
            com.iab.omid.library.bytedance2.utils.c.b(a2, b3);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, a2);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0250a c2 = this.f.c(view);
        if (c2 == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, c2);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String d = this.f.d(view);
        if (d == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, d);
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, Boolean.valueOf(this.f.f(view)));
        this.f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.h);
    }

    private void e() {
        this.b = 0;
        this.d.clear();
        this.c = false;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.c = true;
                break;
            }
        }
        this.h = f.b();
    }

    public static TreeWalker getInstance() {
        return i;
    }

    private void i() {
        if (k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            k = handler;
            handler.post(l);
            k.postDelayed(m, 200L);
        }
    }

    private void k() {
        Handler handler = k;
        if (handler != null) {
            handler.removeCallbacks(m);
            k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    @Override // com.iab.omid.library.bytedance2.processor.a.InterfaceC0248a
    public void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, boolean z) {
        com.iab.omid.library.bytedance2.walking.c e;
        TreeWalker treeWalker;
        if (h.d(view) && (e = this.f.e(view)) != com.iab.omid.library.bytedance2.walking.c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, a2);
            if (b(view, a2)) {
                treeWalker = this;
            } else {
                boolean z2 = z || a(view, a2);
                if (this.c && e == com.iab.omid.library.bytedance2.walking.c.OBSTRUCTION_VIEW && !z2) {
                    this.d.add(new com.iab.omid.library.bytedance2.weakreference.a(view));
                }
                treeWalker = this;
                treeWalker.a(view, aVar, a2, e, z2);
            }
            treeWalker.b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f1946a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f1946a.add(treeWalkerTimeLogger);
    }

    void f() {
        TreeWalker treeWalker;
        this.f.e();
        long b2 = f.b();
        com.iab.omid.library.bytedance2.processor.a a2 = this.e.a();
        if (this.f.b().size() > 0) {
            Iterator<String> it = this.f.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.a(null);
                a(next, this.f.a(next), a3);
                com.iab.omid.library.bytedance2.utils.c.b(a3);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.g.a(a3, hashSet, b2);
            }
        }
        if (this.f.c().size() > 0) {
            JSONObject a4 = a2.a(null);
            treeWalker = this;
            treeWalker.a(null, a2, a4, com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.bytedance2.utils.c.b(a4);
            treeWalker.g.b(a4, treeWalker.f.c(), b2);
            if (treeWalker.c) {
                Iterator<com.iab.omid.library.bytedance2.adsession.a> it2 = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
                while (it2.hasNext()) {
                    it2.next().a(treeWalker.d);
                }
            }
        } else {
            treeWalker = this;
            treeWalker.g.b();
        }
        treeWalker.f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f1946a.clear();
        j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f1946a.contains(treeWalkerTimeLogger)) {
            this.f1946a.remove(treeWalkerTimeLogger);
        }
    }
}
