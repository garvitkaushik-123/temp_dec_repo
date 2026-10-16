package com.fyber.inneractive.sdk.model.vast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes4.dex */
public final class b implements com.fyber.inneractive.sdk.response.i {

    /* renamed from: a, reason: collision with root package name */
    public String f1281a;
    public String b;
    public final PriorityQueue d;
    public o f;
    public final PriorityQueue g;
    public final Comparator h;
    public com.fyber.inneractive.sdk.flow.endcard.k o;
    public v p;
    public final ArrayList e = new ArrayList();
    public int i = 0;
    public int j = 0;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();
    public final ArrayList m = new ArrayList();
    public String n = "";
    public final HashMap c = new HashMap();

    public b(com.fyber.inneractive.sdk.flow.vast.g gVar, com.fyber.inneractive.sdk.flow.vast.d dVar) {
        this.d = new PriorityQueue(1, gVar);
        this.h = dVar;
        this.g = new PriorityQueue(1, dVar);
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(x xVar) {
        HashMap hashMap;
        if (xVar == null || (hashMap = this.c) == null) {
            return null;
        }
        return (List) hashMap.get(xVar);
    }

    public final void a(x xVar, String str) {
        List list = (List) this.c.get(xVar);
        if (list == null) {
            list = new ArrayList();
            this.c.put(xVar, list);
        }
        list.add(str);
    }
}
