package io.bidmachine.analytics.internal;

import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;

/* loaded from: classes7.dex */
public final class r implements D {

    /* renamed from: a, reason: collision with root package name */
    private final KeyPairGenerator f6784a;

    public r() {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
        this.f6784a = keyPairGenerator;
    }

    @Override // io.bidmachine.analytics.internal.D
    public KeyPairGenerator b() {
        return this.f6784a;
    }
}
