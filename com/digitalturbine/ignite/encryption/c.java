package com.digitalturbine.ignite.encryption;

import android.util.Pair;
import java.security.Key;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public final class c {
    public d b;
    public b c;

    /* renamed from: a, reason: collision with root package name */
    public SecretKey f1002a = null;
    public final AlgorithmParameterSpec d = new com.digitalturbine.ignite.encryption.generator.a().a();

    public final void a() {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : init", "EncryptionManager");
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias("dtx_ignite_service_storage")) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(this.d);
            keyGenerator.generateKey();
        }
        Key key = keyStore.getKey("dtx_ignite_service_storage", null);
        if (key instanceof SecretKey) {
            this.f1002a = (SecretKey) key;
            this.b = new d();
            this.c = new b();
        }
    }

    public final Pair a(String str) {
        if (this.b != null) {
            return d.a(this.f1002a, str);
        }
        return null;
    }

    public final String a(String str, byte[] bArr) {
        b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        SecretKey secretKey = this.f1002a;
        bVar.getClass();
        return a.a(a.a(2, bArr, secretKey), str);
    }
}
