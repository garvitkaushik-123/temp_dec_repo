package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.d1;
import com.mbridge.msdk.foundation.tools.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImpressionTracker.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f4510a;
    private List<View> b;
    private ViewTreeObserver.OnPreDrawListener c;
    private d d;
    private Handler e;
    private boolean f;
    private int g;

    /* compiled from: ImpressionTracker.java */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.this.b();
            return true;
        }
    }

    /* compiled from: ImpressionTracker.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* compiled from: ImpressionTracker.java */
    /* renamed from: com.mbridge.msdk.mbnative.controller.c$c, reason: collision with other inner class name */
    class RunnableC0356c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4513a;

        RunnableC0356c(View view) {
            this.f4513a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = this.f4513a.getViewTreeObserver();
            if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                c.this.f4510a = new WeakReference(viewTreeObserver);
                if (c.this.c != null) {
                    viewTreeObserver.addOnPreDrawListener(c.this.c);
                }
            }
        }
    }

    /* compiled from: ImpressionTracker.java */
    public interface d {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public c(List<View> list, d dVar, Handler handler, int i) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = null;
        this.d = dVar;
        this.e = handler;
        this.g = i;
        if (list != null) {
            this.b = list;
        } else {
            arrayList.clear();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f = false;
            List<View> list = this.b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i = 0; i < this.b.size(); i++) {
                View view = this.b.get(i);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f) {
            return;
        }
        Handler handler = this.e;
        if (handler != null) {
            if (this.g == 1) {
                d();
            } else {
                handler.postDelayed(new b(), 100L);
            }
        }
        this.f = true;
    }

    private void c() {
        try {
            b();
        } catch (Throwable th) {
            p0.b("ImpressionTracker", th.getMessage(), th);
        }
        try {
            this.c = new a();
        } catch (Throwable th2) {
            p0.b("ImpressionTracker", th2.getMessage(), th2);
        }
    }

    public void a(View view) {
        View view2;
        View view3;
        if (view != null) {
            view2 = f.a(view.getContext(), view);
            this.b.add(view);
        } else {
            List<View> list = this.b;
            view2 = null;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.b.size() && ((view3 = this.b.get(i)) == null || (view2 = f.a(view3.getContext(), view3)) == null); i++) {
                }
            }
        }
        if (view2 == null) {
            return;
        }
        view2.post(new RunnableC0356c(view2));
    }

    private boolean b(View view) {
        return !d1.a(view, this.g);
    }

    public void a() {
        try {
            this.f = false;
            WeakReference<ViewTreeObserver> weakReference = this.f4510a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.f4510a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.f4510a.clear();
            }
            this.d = null;
            this.c = null;
            List<View> list = this.b;
            if (list != null) {
                list.clear();
            }
            this.b = null;
        } catch (Throwable unused) {
        }
    }
}
