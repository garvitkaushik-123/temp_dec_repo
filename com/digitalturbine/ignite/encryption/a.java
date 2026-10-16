package com.digitalturbine.ignite.encryption;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes3.dex */
public abstract class a {
    public static Cipher a(int i, byte[] bArr, SecretKey secretKey) {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, secretKey, new GCMParameterSpec(128, bArr));
        return cipher;
    }

    public static String a(Cipher cipher, String str) {
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(Base64.decode(str, 0)), cipher);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read = cipherInputStream.read();
            if (read == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
        }
        byte[] bArr = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return new String(bArr, "UTF-8");
    }
}
