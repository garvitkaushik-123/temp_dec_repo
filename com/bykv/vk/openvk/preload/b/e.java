package com.bykv.vk.openvk.preload.b;

/* compiled from: InterceptorFactory.java */
/* loaded from: classes3.dex */
public interface e {
    <T> T a(Class<T> cls);

    /* compiled from: InterceptorFactory.java */
    public static class a implements e {
        @Override // com.bykv.vk.openvk.preload.b.e
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
