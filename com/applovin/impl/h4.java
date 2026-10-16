package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class h4 {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference f477a = new AtomicReference();

    public static String a() {
        return "iabtechlab-Applovin";
    }

    public static URL b() {
        try {
            return new URL("https://compliance.iabtechnologylab.com/compliance-js/omid-validation-verification-script-v1-APPLOVIN-01102024.js");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        return "iabtechlab.com-omid";
    }

    public static String a(com.applovin.impl.sdk.k kVar, Map map) {
        String str = (String) f477a.get();
        if (StringUtils.isValidString(str)) {
            return str;
        }
        URL b = b();
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStream a2 = kVar.H().a(b.toString(), (List) null, false, map);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a2));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append("\n");
                    } finally {
                    }
                }
                bufferedReader.close();
                if (a2 != null) {
                    a2.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            kVar.O().a("OpenMeasurementTestParameters", th);
            kVar.E().a("OpenMeasurementTestParameters", "getTestValidationJavaScriptContent", th);
        }
        String sb2 = sb.toString();
        f477a.set(sb2);
        return sb2;
    }
}
