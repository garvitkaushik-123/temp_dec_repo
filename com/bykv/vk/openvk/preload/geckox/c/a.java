package com.bykv.vk.openvk.preload.geckox.c;

import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;

/* compiled from: BooleanTypeAdapter.java */
/* loaded from: classes3.dex */
public final class a extends r<Boolean> {
    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ void a(c cVar, Boolean bool) throws IOException {
        Boolean bool2 = bool;
        if (bool2 == null) {
            cVar.h();
        } else {
            cVar.a(bool2);
        }
    }

    /* compiled from: BooleanTypeAdapter.java */
    /* renamed from: com.bykv.vk.openvk.preload.geckox.c.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f951a;

        static {
            int[] iArr = new int[com.bykv.vk.openvk.preload.a.d.b.values().length];
            f951a = iArr;
            try {
                iArr[com.bykv.vk.openvk.preload.a.d.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f951a[com.bykv.vk.openvk.preload.a.d.b.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f951a[com.bykv.vk.openvk.preload.a.d.b.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        com.bykv.vk.openvk.preload.a.d.b f = aVar.f();
        int i = AnonymousClass1.f951a[f.ordinal()];
        if (i == 1) {
            return Boolean.valueOf(aVar.i());
        }
        if (i == 2) {
            aVar.j();
            return null;
        }
        if (i == 3) {
            return Boolean.valueOf(aVar.m() != 0);
        }
        throw new m("Expected BOOLEAN or NUMBER but was ".concat(String.valueOf(f)));
    }
}
