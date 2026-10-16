package com.bykv.vk.openvk.preload.geckox.a.a;

/* compiled from: CacheConfig.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final int f937a;
    final c b;
    private final b c;

    /* synthetic */ a(C0113a c0113a, byte b) {
        this(c0113a);
    }

    private a(C0113a c0113a) {
        this.f937a = c0113a.f938a;
        this.c = c0113a.b;
        this.b = c0113a.c;
    }

    public final b a() {
        return this.c;
    }

    /* compiled from: CacheConfig.java */
    /* renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    public static final class C0113a {

        /* renamed from: a, reason: collision with root package name */
        private int f938a;
        private b b = b.f939a;
        private c c;

        public final C0113a a() {
            this.f938a = 20;
            return this;
        }

        public final C0113a a(b bVar) {
            if (bVar == null) {
                bVar = b.f939a;
            }
            this.b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }
}
