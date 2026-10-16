package com.bykv.vk.openvk.preload.geckox.a.a;

import java.io.File;
import java.util.List;

/* compiled from: CachePolicy.java */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f939a = new d();
    public static final b b;
    protected a c;
    protected File d;
    protected List<String> e;

    public abstract void a();

    static {
        new f();
        b = new e();
    }

    public void a(a aVar, File file, List<String> list) {
        this.c = aVar;
        this.d = file;
        this.e = list;
    }
}
