package com.bykv.vk.openvk.preload.b;

/* compiled from: UnProceedChain.java */
/* loaded from: classes3.dex */
final class m<IN> implements b<IN> {

    /* renamed from: a, reason: collision with root package name */
    private b<IN> f930a;

    public m(b<IN> bVar) {
        this.f930a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f930a.a((Class) cls);
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f930a.b(cls);
    }
}
