package io.bidmachine.analytics.internal;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f6653a;
    private final String b;
    private final byte[] c;
    private final boolean d;
    private final byte[] e;
    private final Key f;
    private final B g;

    public C(byte[] bArr, String str, byte[] bArr2, boolean z) {
        this.f6653a = bArr;
        this.b = str;
        this.c = bArr2;
        this.d = z;
        KeyPair a2 = new r().a();
        this.e = a2.getPublic().getEncoded();
        this.f = a2.getPrivate();
        this.g = new C3582w();
    }

    public final Key a() {
        return a(this.f, this.e, this.f6653a);
    }

    public final byte[] b() {
        return this.e;
    }

    public final Key a(Key key, byte[] bArr, byte[] bArr2) {
        return new SecretKeySpec(this.g.a(a(key, bArr2), this.d ? a(bArr, bArr2) : null, this.c), this.b);
    }

    private final byte[] a(Key key, byte[] bArr) {
        PublicKey generatePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
        keyAgreement.init(key);
        keyAgreement.doPhase(generatePublic, true);
        return keyAgreement.generateSecret();
    }

    public /* synthetic */ C(byte[] bArr, String str, byte[] bArr2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, str, (i & 4) != 0 ? null : bArr2, (i & 8) != 0 ? false : z);
    }

    private final byte[] a(byte[] bArr, byte[] bArr2) {
        List mutableListOf = CollectionsKt.mutableListOf(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
        CollectionsKt.sort(mutableListOf);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(((ByteBuffer) mutableListOf.get(0)).array());
        byteArrayOutputStream.write(((ByteBuffer) mutableListOf.get(1)).array());
        return byteArrayOutputStream.toByteArray();
    }
}
