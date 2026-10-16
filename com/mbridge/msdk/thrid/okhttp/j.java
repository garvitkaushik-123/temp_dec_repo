package com.mbridge.msdk.thrid.okhttp;

import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import io.ktor.client.utils.CacheControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: Cookie.java */
/* loaded from: classes6.dex */
public final class j {
    private static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f4876a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    private j(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4876a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    public String a() {
        return this.f4876a;
    }

    public String b() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f4876a.equals(this.f4876a) && jVar.b.equals(this.b) && jVar.d.equals(this.d) && jVar.e.equals(this.e) && jVar.c == this.c && jVar.f == this.f && jVar.g == this.g && jVar.h == this.h && jVar.i == this.i;
    }

    public int hashCode() {
        int hashCode = (((((((this.f4876a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long j2 = this.c;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.mbridge.msdk.thrid.okhttp.internal.c.d(str);
    }

    private static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    @Nullable
    public static j a(q qVar, String str) {
        return a(System.currentTimeMillis(), qVar, str);
    }

    @Nullable
    static j a(long j2, q qVar, String str) {
        long j3;
        String str2;
        String str3;
        int length = str.length();
        char c = ';';
        int a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, length, ';');
        int a3 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, a2, D5.T);
        String str4 = null;
        if (a3 == a2) {
            return null;
        }
        String d = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, 0, a3);
        if (d.isEmpty() || com.mbridge.msdk.thrid.okhttp.internal.c.c(d) != -1) {
            return null;
        }
        String d2 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a3 + 1, a2);
        if (com.mbridge.msdk.thrid.okhttp.internal.c.c(d2) != -1) {
            return null;
        }
        int i = a2 + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = true;
        long j4 = 253402300799999L;
        long j5 = -1;
        String str5 = null;
        while (i < length) {
            int a4 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i, length, c);
            int a5 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i, a4, D5.T);
            String d3 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, i, a5);
            String d4 = a5 < a4 ? com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a5 + 1, a4) : "";
            if (d3.equalsIgnoreCase("expires")) {
                try {
                    j4 = a(d4, 0, d4.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (d3.equalsIgnoreCase(CacheControl.MAX_AGE)) {
                j5 = b(d4);
            } else {
                if (d3.equalsIgnoreCase(C3040d4.i.D)) {
                    str4 = a(d4);
                    z4 = false;
                } else if (d3.equalsIgnoreCase("path")) {
                    str5 = d4;
                } else if (d3.equalsIgnoreCase("secure")) {
                    z2 = true;
                } else if (d3.equalsIgnoreCase("httponly")) {
                    z3 = true;
                }
                i = a4 + 1;
                c = ';';
            }
            z = true;
            i = a4 + 1;
            c = ';';
        }
        if (j5 == Long.MIN_VALUE) {
            j3 = Long.MIN_VALUE;
        } else if (j5 != -1) {
            long j6 = j2 + (j5 <= 9223372036854775L ? j5 * 1000 : Long.MAX_VALUE);
            j3 = (j6 < j2 || j6 > 253402300799999L) ? 253402300799999L : j6;
        } else {
            j3 = j4;
        }
        String g = qVar.g();
        if (str4 == null) {
            str2 = g;
        } else {
            if (!a(g, str4)) {
                return null;
            }
            str2 = str4;
        }
        if (g.length() != str2.length() && PublicSuffixDatabase.a().a(str2) == null) {
            return null;
        }
        if (str5 == null || !str5.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            String c2 = qVar.c();
            int lastIndexOf = c2.lastIndexOf(47);
            if (lastIndexOf != 0) {
                str5 = c2.substring(0, lastIndexOf);
            } else {
                str3 = RemoteSettings.FORWARD_SLASH_STRING;
                return new j(d, d2, j3, str2, str3, z2, z3, z4, z);
            }
        }
        str3 = str5;
        return new j(d, d2, j3, str2, str3, z2, z3, z4, z);
    }

    private static long a(String str, int i, int i2) {
        int a2 = a(str, i, i2, false);
        Matcher matcher = m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i4 == -1 && matcher.usePattern(m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            a2 = a(str, a3 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        if (i8 >= 0 && i8 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.mbridge.msdk.thrid.okhttp.internal.c.p);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static String a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<j> a(q qVar, p pVar) {
        List<String> c = pVar.c(HttpHeaders.SET_COOKIE);
        int size = c.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            j a2 = a(qVar, c.get(i));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4876a);
        sb.append(D5.T);
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.mbridge.msdk.thrid.okhttp.internal.http.d.a(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.d);
        }
        sb.append("; path=").append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
