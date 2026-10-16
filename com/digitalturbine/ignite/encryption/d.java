package com.digitalturbine.ignite.encryption;

import android.util.Base64;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public final class d {
    public static Pair a(SecretKey secretKey, String str) {
        byte[] generateSeed = new SecureRandom().generateSeed(12);
        Cipher a2 = a.a(1, generateSeed, secretKey);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, a2);
        cipherOutputStream.write(str.getBytes("UTF-8"));
        cipherOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new Pair(Base64.encodeToString(generateSeed, 0), Base64.encodeToString(byteArray, 0));
    }
}
