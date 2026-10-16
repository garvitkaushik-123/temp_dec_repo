package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.e0;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class d0 extends c0 {
    private final String f;
    private final com.applovin.impl.sdk.ad.b g;
    private final List h;
    private final c i;
    private StringBuffer j;
    private final Object k;
    private final ExecutorService l;
    private final String m;
    private List n;
    private List o;

    class a implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f427a;

        a(String str) {
            this.f427a = str;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                if (((Boolean) d0.this.f412a.a(v4.T0)).booleanValue()) {
                    synchronized (d0.this.k) {
                        StringUtils.replaceAll(d0.this.j, this.f427a, uri.toString());
                    }
                } else {
                    StringUtils.replaceAll(d0.this.j, this.f427a, uri.toString());
                }
                d0.this.g.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar = d0.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                d0 d0Var = d0.this;
                d0Var.c.a(d0Var.b, "Failed to cache JavaScript resource " + this.f427a);
            }
            if (d0.this.i != null) {
                d0.this.i.a(d0.this.f, true);
            }
        }
    }

    class b implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f428a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        b(String str, String str2, String str3) {
            this.f428a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri == null) {
                if (!d0.this.g.a0().contains(this.b + this.c) || d0.this.i == null) {
                    return;
                }
                d0.this.i.a(d0.this.f, true);
                return;
            }
            if (((Boolean) d0.this.f412a.a(v4.T0)).booleanValue()) {
                synchronized (d0.this.k) {
                    StringUtils.replaceAll(d0.this.j, this.f428a, uri.toString());
                }
            } else {
                StringUtils.replaceAll(d0.this.j, this.f428a, uri.toString());
            }
            d0.this.g.a(uri);
        }
    }

    public interface c {
        void a(String str, boolean z);
    }

    public d0(String str, com.applovin.impl.sdk.ad.b bVar, List list, ExecutorService executorService, String str2, com.applovin.impl.sdk.k kVar, c cVar) {
        super("AsyncTaskCacheHTMLResources", kVar);
        this.f = str;
        this.g = bVar;
        this.h = list;
        this.l = executorService;
        this.m = str2;
        this.i = cVar;
        this.j = new StringBuffer(str);
        this.k = new Object();
    }

    private Collection f() {
        HashSet hashSet = new HashSet();
        for (char c2 : ((String) this.f412a.a(v4.D0)).toCharArray()) {
            hashSet.add(Character.valueOf(c2));
        }
        hashSet.add('\"');
        return hashSet;
    }

    private void a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.l.submit((e0) it.next()));
        }
        this.o = arrayList;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                ((Future) it2.next()).get();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0017, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HashSet d() {
        HashSet hashSet = new HashSet();
        List R = this.g.R();
        Collection f = f();
        for (String str : this.h) {
            char c2 = 0;
            int i = 0;
            int i2 = 0;
            while (i < this.f.length()) {
                if (this.e.get()) {
                    return null;
                }
                i = this.f.indexOf(str, i2);
                if (i == -1) {
                    break;
                }
                int length = this.f.length();
                int i3 = i;
                while (!f.contains(Character.valueOf(this.f.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return null;
                }
                String substring = this.f.substring(str.length() + i, i3);
                String str2 = str + substring;
                if (StringUtils.isValidString(substring) && !R.contains(str2)) {
                    com.applovin.impl.sdk.ad.b bVar = this.g;
                    String[] strArr = new String[1];
                    strArr[c2] = str;
                    hashSet.add(new e0(str2, bVar, Arrays.asList(strArr), true, this.m, this.f412a, new b(str2, str, substring)));
                } else if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Skip caching of optional or non-resource " + substring);
                }
                i2 = i3;
                c2 = 0;
            }
        }
        return hashSet;
    }

    private HashSet e() {
        HashSet hashSet = new HashSet();
        for (String str : StringUtils.getRegexMatches(StringUtils.match(this.f, (String) this.f412a.a(v4.X4)), 1)) {
            if (this.e.get()) {
                return null;
            }
            if (StringUtils.isValidString(str)) {
                hashSet.add(new e0(str, this.g, Collections.emptyList(), false, this.m, this.f412a, new a(str)));
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of non-resource " + str);
            }
        }
        return hashSet;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        HashSet e;
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        if (TextUtils.isEmpty(this.f)) {
            a(this.f);
            return Boolean.FALSE;
        }
        if (!((Boolean) this.f412a.a(v4.E0)).booleanValue()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Resource caching is disabled, skipping cache...");
            }
            a(this.f);
            return Boolean.FALSE;
        }
        HashSet hashSet = new HashSet();
        HashSet d = d();
        if (d != null) {
            hashSet.addAll(d);
        }
        if (((Boolean) this.f412a.a(v4.W4)).booleanValue() && (e = e()) != null) {
            hashSet.addAll(e);
        }
        this.n = new ArrayList(hashSet);
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        List list = this.n;
        if (list == null || list.isEmpty()) {
            a(this.f);
            return Boolean.FALSE;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Executing " + this.n.size() + " caching operations...");
        }
        if (this.f412a.r0().f()) {
            a(this.n);
        } else {
            this.l.invokeAll(this.n);
        }
        if (((Boolean) this.f412a.a(v4.T0)).booleanValue()) {
            synchronized (this.k) {
                a(this.j.toString());
            }
        } else {
            a(this.j.toString());
        }
        return Boolean.TRUE;
    }

    public void c() {
        List list = this.n;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((e0) it.next()).a(true);
            }
        }
        List<Future> list2 = this.o;
        if (list2 != null) {
            for (Future future : list2) {
                if (!future.isDone()) {
                    future.cancel(true);
                }
            }
        }
    }

    private void a(String str) {
        c cVar;
        if (this.e.get() || (cVar = this.i) == null) {
            return;
        }
        cVar.a(str, false);
    }
}
