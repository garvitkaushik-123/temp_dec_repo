package com.voodoo.sauce.core.keychain;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes7.dex */
public final class KeychainPlugin {
    private static final int AES_KEY_SIZE_BITS = 256;
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final int IV_SIZE_BYTES = 12;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String KEY_ALIAS_PREFIX = "unity_keystore_";
    private static final String PREFS_NAME = "secure_kv_store";
    private static final String TAG = "AndroidKeychainService";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private final SharedPreferences prefs;
    private final boolean supported;

    public KeychainPlugin(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.prefs = applicationContext != null ? applicationContext.getSharedPreferences(PREFS_NAME, 0) : null;
        boolean resolveSupported = resolveSupported();
        this.supported = resolveSupported;
        if (resolveSupported) {
            return;
        }
        Log.w(TAG, "AndroidKeyStore not available; keychain operations will be no-ops.");
    }

    public boolean isReady() {
        return this.supported && this.prefs != null;
    }

    public synchronized boolean setString(String str, String str2) {
        if (!isReady() || isEmpty(str)) {
            return false;
        }
        try {
            SecretKey ensureKey = ensureKey(KEY_ALIAS_PREFIX + str);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, ensureKey);
            byte[] iv = cipher.getIV();
            if (str2 == null) {
                str2 = "";
            }
            byte[] doFinal = cipher.doFinal(str2.getBytes(StandardCharsets.UTF_8));
            byte[] bArr = new byte[iv.length + doFinal.length];
            System.arraycopy(iv, 0, bArr, 0, iv.length);
            System.arraycopy(doFinal, 0, bArr, iv.length, doFinal.length);
            boolean commit = this.prefs.edit().putString(str, Base64.encodeToString(bArr, 2)).commit();
            if (!commit) {
                Log.e(TAG, "setString('" + str + "') failed: SharedPreferences.commit() returned false.");
            }
            return commit;
        } catch (Exception e) {
            Log.e(TAG, "setString('" + str + "') threw.", e);
            return false;
        }
    }

    public synchronized boolean hasKey(String str) {
        if (!isReady() || isEmpty(str)) {
            return false;
        }
        try {
            return this.prefs.contains(str);
        } catch (Exception e) {
            Log.e(TAG, "hasKey('" + str + "') threw.", e);
            return false;
        }
    }

    public synchronized String getString(String str, String str2) {
        if (!isReady() || isEmpty(str) || !this.prefs.contains(str)) {
            return str2;
        }
        try {
            String string = this.prefs.getString(str, null);
            if (isEmpty(string)) {
                Log.e(TAG, "getString('" + str + "') failed: stored value missing/empty despite key present.");
                return str2;
            }
            byte[] decode = Base64.decode(string, 2);
            if (decode != null && decode.length > 12) {
                byte[] bArr = new byte[12];
                int length = decode.length - 12;
                byte[] bArr2 = new byte[length];
                System.arraycopy(decode, 0, bArr, 0, 12);
                System.arraycopy(decode, 12, bArr2, 0, length);
                SecretKey key = getKey(KEY_ALIAS_PREFIX + str);
                if (key == null) {
                    Log.e(TAG, "getString('" + str + "') failed: secret key missing for alias.");
                    return str2;
                }
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(2, key, new GCMParameterSpec(128, bArr));
                return new String(cipher.doFinal(bArr2), StandardCharsets.UTF_8);
            }
            Log.e(TAG, "getString('" + str + "') failed: decoded payload null or too short.");
            return str2;
        } catch (Exception e) {
            Log.e(TAG, "getString('" + str + "') threw.", e);
            return str2;
        }
    }

    public synchronized boolean deleteKey(String str) {
        if (!isReady() || isEmpty(str)) {
            return false;
        }
        try {
            boolean commit = this.prefs.edit().remove(str).commit();
            if (!commit) {
                Log.e(TAG, "deleteKey('" + str + "') failed: SharedPreferences.commit() returned false.");
            }
            deleteKeystoreEntry(KEY_ALIAS_PREFIX + str);
            return commit;
        } catch (Exception e) {
            Log.e(TAG, "deleteKey('" + str + "') threw.", e);
            return false;
        }
    }

    private static SecretKey ensureKey(String str) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
        if (!keyStore.containsAlias(str)) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", KEYSTORE_PROVIDER);
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).build());
            return keyGenerator.generateKey();
        }
        return (SecretKey) keyStore.getKey(str, null);
    }

    private static SecretKey getKey(String str) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
        return (SecretKey) keyStore.getKey(str, null);
    }

    private static void deleteKeystoreEntry(String str) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
        if (keyStore.containsAlias(str)) {
            keyStore.deleteEntry(str);
        }
    }

    private static boolean resolveSupported() {
        try {
            KeyStore.getInstance(KEYSTORE_PROVIDER).load(null);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "KeyStore support probe failed; treating as unsupported.", e);
            return false;
        }
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
