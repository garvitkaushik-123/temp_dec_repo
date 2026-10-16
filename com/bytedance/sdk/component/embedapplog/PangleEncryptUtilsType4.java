package com.bytedance.sdk.component.embedapplog;

import android.util.Log;
import android.util.Pair;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class PangleEncryptUtilsType4 {
    private static int getCryptFailedReason(int i) {
        switch (i) {
            case 501:
                return 6;
            case 502:
                return 4;
            case 503:
                return 1;
            case 504:
                return 3;
            case 505:
            case 506:
                return 2;
            default:
                return 0;
        }
    }

    PangleEncryptUtilsType4() {
    }

    static JSONObject encrypt(JSONObject jSONObject, IDefaultEncrypt iDefaultEncrypt) {
        Pair<Integer, JSONObject> pair;
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(jSONObject);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            pair = null;
        }
        if (pair != null && ((Integer) pair.first).intValue() == 0 && pair.second != null) {
            return (JSONObject) pair.second;
        }
        if (iDefaultEncrypt == null) {
            return null;
        }
        try {
            return iDefaultEncrypt.encrypt(jSONObject, pair == null ? 0 : getCryptFailedReason(((Integer) pair.first).intValue()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static JSONObject encryptType4WithNoWrapBase64(JSONObject jSONObject, IDefaultEncrypt iDefaultEncrypt) {
        Pair<Integer, String> cypher4EncryptWithNoWrapBase64;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        if (jSONObject != null) {
            try {
                cypher4EncryptWithNoWrapBase64 = PglCryptUtils.getInstance().cypher4EncryptWithNoWrapBase64(jSONObject.toString());
            } catch (Throwable th) {
                Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            }
            if (cypher4EncryptWithNoWrapBase64 != null || ((Integer) cypher4EncryptWithNoWrapBase64.first).intValue() != 0 || cypher4EncryptWithNoWrapBase64.second == null) {
                if (iDefaultEncrypt != null) {
                    return null;
                }
                try {
                    return iDefaultEncrypt.encrypt(jSONObject, cypher4EncryptWithNoWrapBase64 == null ? 0 : getCryptFailedReason(((Integer) cypher4EncryptWithNoWrapBase64.first).intValue()));
                } catch (Exception unused) {
                    return null;
                }
            }
            try {
                jSONObject2 = new JSONObject();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, cypher4EncryptWithNoWrapBase64.second);
                jSONObject2.put("cypher", 4);
                return jSONObject2;
            } catch (Throwable th3) {
                th = th3;
                jSONObject3 = jSONObject2;
                Log.e("pangle-encrypt", "encrypt json exception " + th.getMessage());
                return jSONObject3;
            }
        }
        cypher4EncryptWithNoWrapBase64 = null;
        if (cypher4EncryptWithNoWrapBase64 != null) {
        }
        if (iDefaultEncrypt != null) {
        }
    }

    static Pair<Integer, byte[]> encryptWithoutBase64(byte[] bArr) {
        Pair<Integer, byte[]> pair;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(bArr);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            pair = null;
        }
        int i = 0;
        if (pair != null && ((Integer) pair.first).intValue() == 0 && pair.second != null && ((byte[]) pair.second).length > 0) {
            bArr2 = (byte[]) pair.second;
        } else if (pair != null) {
            i = getCryptFailedReason(((Integer) pair.first).intValue());
        }
        return new Pair<>(Integer.valueOf(i), bArr2);
    }

    static Pair<Integer, String> decrypt(String str) {
        try {
            Pair<Integer, String> cypher4Decrypt = PglCryptUtils.getInstance().cypher4Decrypt(str);
            return new Pair<>(Integer.valueOf(getCryptFailedReason(((Integer) cypher4Decrypt.first).intValue())), cypher4Decrypt.second);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "decrypt exception " + th.getMessage());
            return new Pair<>(2, null);
        }
    }
}
