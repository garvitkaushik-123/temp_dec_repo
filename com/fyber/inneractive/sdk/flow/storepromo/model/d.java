package com.fyber.inneractive.sdk.flow.storepromo.model;

import com.fyber.inneractive.sdk.util.h;
import java.text.DecimalFormat;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1234a;
    public final String b;
    public final String c;

    public d(String str, String str2, String str3) {
        String str4;
        this.c = "";
        this.f1234a = str;
        this.b = str2;
        h hVar = new h(str3);
        if (hVar.f1759a == null) {
            str4 = "N/A";
        } else {
            double longValue = r11.longValue() / 1024.0d;
            double d = longValue / 1024.0d;
            double d2 = d / 1024.0d;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String str5 = decimalFormat.format(hVar.f1759a) + " bytes";
            if (d > 850.0d) {
                str4 = decimalFormat.format(d2) + " GB";
            } else if (longValue > 850.0d) {
                str4 = decimalFormat.format(d) + " MB";
            } else if (hVar.f1759a.longValue() > 850) {
                str4 = decimalFormat.format(longValue) + " kB";
            } else {
                str4 = str5;
            }
        }
        this.c = str4;
    }
}
