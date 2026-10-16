package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Random;
import org.json.JSONException;

/* renamed from: com.ironsource.m5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3193m5 {
    public static final int d = 1;
    public static final int e = 2;
    public static final String f = "C38FB23A402222A0C17D34A92F971D1F";
    public static final String g = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaUZaiASqhU4+s3JiQaIzVYtC+rZiPX2K+ZRg4C21kBZDNQM5+SEkp5GT5a9W/IR2oz6Q/ucifXcc7QEo5Xl5GX1BAhFI+8KaxPmn5Km5zFdH0aCvrrpDYQpH239Q+2uuUC79G5MpfSIw0zixU4VkF0WbVdHDpgQDds39cPl6cTwIDAQAB";
    public static final String h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static final int i = 32;
    private static final C3193m5 j = new C3193m5();

    /* renamed from: a, reason: collision with root package name */
    private String f3477a = "";
    private String b = "";
    private String c = "";

    private String a(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static C3193m5 b() {
        return j;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f3477a)) {
            this.f3477a = f;
        }
        return this.f3477a;
    }

    public synchronized String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = a(h, 32);
        }
        return this.b;
    }

    public String a() throws JSONException {
        if (TextUtils.isEmpty(this.c)) {
            try {
                this.c = P9.a(d(), g);
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                String str = "Session key encryption exception: " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(str);
                throw new JSONException(str);
            }
        }
        return this.c;
    }
}
