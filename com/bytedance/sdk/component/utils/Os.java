package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Os {
    private static HashMap<String, ArrayList<String>> eli = new HashMap<>();

    public static ArrayList<String> eli(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (eli.get(str) != null) {
                return eli.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : DbA(context, packageName)) {
                    String str2 = "error!";
                    if (SameMD5.TAG.equals(str)) {
                        str2 = eli(signature, SameMD5.TAG);
                    } else if ("SHA1".equals(str)) {
                        str2 = eli(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = eli(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception unused) {
            }
            eli.put(str, arrayList);
        }
        return arrayList;
    }

    public static String eli(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> eli2 = eli(context, "SHA1");
        if (eli2 != null && eli2.size() != 0) {
            for (int i = 0; i < eli2.size(); i++) {
                sb.append(eli2.get(i));
                if (i < eli2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] DbA(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String eli(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception unused) {
            return "error!";
        }
    }
}
