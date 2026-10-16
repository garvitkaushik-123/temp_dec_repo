package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import java.util.List;

/* loaded from: classes4.dex */
public final class j1 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final i1 f1763a;
    public final Uri b;
    public final List c;

    public j1(i1 i1Var, Uri uri, List list) {
        this.f1763a = i1Var;
        this.b = uri;
        this.c = list;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1763a.mPriority.compareTo(((j1) obj).f1763a.mPriority);
    }
}
