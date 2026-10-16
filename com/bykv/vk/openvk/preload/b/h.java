package com.bykv.vk.openvk.preload.b;

/* compiled from: Pipe.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    Class<? extends d> f925a;
    private com.bykv.vk.openvk.preload.b.b.a b;
    private Object[] c;

    /* synthetic */ h(a aVar, byte b) {
        this(aVar);
    }

    private h(a aVar) {
        this.f925a = aVar.f926a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.f925a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    final com.bykv.vk.openvk.preload.b.b.a a() {
        return this.b;
    }

    final Object[] b() {
        return this.c;
    }

    /* compiled from: Pipe.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Class<? extends d> f926a;
        private com.bykv.vk.openvk.preload.b.b.a b;
        private Object[] c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f926a = cls;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.b.b.a aVar) {
            this.b = aVar;
            return this;
        }

        public final a a(Object... objArr) {
            this.c = objArr;
            return this;
        }

        public final h b() {
            return new h(this, (byte) 0);
        }
    }
}
