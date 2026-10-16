package io.bidmachine.analytics.internal;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/* loaded from: classes7.dex */
public interface D {
    default KeyPair a() {
        return b().generateKeyPair();
    }

    KeyPairGenerator b();
}
