package io.bidmachine.analytics.internal;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: io.bidmachine.analytics.internal.a, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3561a implements InterfaceC3562b {
    public static final C0596a b = new C0596a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f6689a = "AES";

    /* renamed from: io.bidmachine.analytics.internal.a$a, reason: collision with other inner class name */
    public static final class C0596a {
        public /* synthetic */ C0596a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private C0596a() {
        }
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC3562b
    public byte[] a(Key key, byte[] bArr) {
        byte[] a2 = f0.f6697a.a(12);
        byte[] doFinal = a(1, key, a2).doFinal(bArr);
        byte[] bArr2 = new byte[doFinal.length + 12];
        ArraysKt.copyInto(a2, bArr2, 0, 0, 12);
        ArraysKt.copyInto(doFinal, bArr2, 12, 0, doFinal.length);
        return bArr2;
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC3562b
    public String getName() {
        return this.f6689a;
    }

    private final Cipher a(int i, Key key, byte[] bArr) {
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, key, gCMParameterSpec);
        return cipher;
    }
}
