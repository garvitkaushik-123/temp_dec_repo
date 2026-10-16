package com.bykv.vk.openvk.eli.eli.eli.kb;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.ktor.util.date.GMTDateParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class eli {
    public static String eli(File file) {
        return eli(file, null);
    }

    public static String eli(File file, String str) {
        if (!file.isFile()) {
            return "";
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            if (!TextUtils.isEmpty(str)) {
                messageDigest.update(str.getBytes());
            }
            bufferedInputStream.close();
            return eli(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    private static String eli(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i2] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }
}
