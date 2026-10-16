package com.moloco.sdk.internal.services.encryption;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0456a f5674a = C0456a.f5675a;

    /* renamed from: com.moloco.sdk.internal.services.encryption.a$a, reason: collision with other inner class name */
    public static final class C0456a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0456a f5675a = new C0456a();

        public final a a() {
            return new com.moloco.sdk.internal.services.encryption.b();
        }
    }

    public static final class b {
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ void b() {
        }
    }

    String a(byte[] bArr, byte[] bArr2);

    IvParameterSpec a();

    byte[] a(String str);

    byte[] a(byte[] bArr);

    byte[] a(byte[] bArr, String str);

    String b(byte[] bArr);

    SecretKeySpec b();

    byte[] b(byte[] bArr, String str);
}
