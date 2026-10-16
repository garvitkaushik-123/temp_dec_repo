package com.mbridge.msdk.thrid.okhttp;

import com.google.common.base.Ascii;
import com.ironsource.D5;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* compiled from: HttpUrl.java */
/* loaded from: classes6.dex */
public final class q {
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f4884a;
    private final String b;
    private final String c;
    final String d;
    final int e;
    private final List<String> f;

    @Nullable
    private final List<String> g;

    @Nullable
    private final String h;
    private final String i;

    /* compiled from: HttpUrl.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        String f4885a;

        @Nullable
        String d;
        final List<String> f;

        @Nullable
        List<String> g;

        @Nullable
        String h;
        String b = "";
        String c = "";
        int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private boolean c(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static int f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String a2 = a(str, 0, str.length());
            if (a2 == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = a2;
            return this;
        }

        a d() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, q.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, q.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = q.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f4885a = "http";
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            this.f4885a = "https";
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f4885a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(this.d);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.f4885a != null) {
                int b = b();
                String str3 = this.f4885a;
                if (str3 == null || b != q.a(str3)) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(b);
                }
            }
            q.b(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                q.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        private void c() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        public a a(@Nullable String str) {
            this.g = str != null ? q.d(q.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public q a() {
            if (this.f4885a != null) {
                if (this.d != null) {
                    return new q(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        int b() {
            int i = this.e;
            return i != -1 ? i : q.a(this.f4885a);
        }

        private static int b(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(q.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static int e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        a a(@Nullable q qVar, String str) {
            int a2;
            String str2;
            int i;
            String str3;
            String str4 = str;
            int b = com.mbridge.msdk.thrid.okhttp.internal.c.b(str4, 0, str4.length());
            int c = com.mbridge.msdk.thrid.okhttp.internal.c.c(str4, b, str4.length());
            int e = e(str4, b, c);
            if (e != -1) {
                if (str4.regionMatches(true, b, "https:", 0, 6)) {
                    this.f4885a = "https";
                    b += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, b, "http:", 0, 5)) {
                        this.f4885a = "http";
                        b += 5;
                    } else {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, e) + "'");
                    }
                }
            } else if (qVar != null) {
                this.f4885a = qVar.f4884a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f = f(str4, b, c);
            char c2 = '#';
            if (f < 2 && qVar != null && qVar.f4884a.equals(this.f4885a)) {
                this.b = qVar.f();
                this.c = qVar.b();
                this.d = qVar.d;
                this.e = qVar.e;
                this.f.clear();
                this.f.addAll(qVar.d());
                if (b == c || str4.charAt(b) == '#') {
                    a(qVar.e());
                }
                str2 = str4;
            } else {
                int i2 = b + f;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str4, i2, c, "@/\\?#");
                    char charAt = a2 != c ? str4.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a3 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str4, i2, a2, AbstractJsonLexerKt.COLON);
                            String a4 = q.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.b + "%40" + a4;
                            }
                            this.b = a4;
                            if (a3 != a2) {
                                i = a2;
                                this.c = q.a(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            } else {
                                i = a2;
                            }
                            str3 = str;
                            z2 = true;
                        } else {
                            i = a2;
                            str3 = str;
                            this.c += "%40" + q.a(str3, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        str4 = str3;
                        c2 = '#';
                    }
                }
                str2 = str4;
                int i3 = i2;
                int c3 = c(str2, i3, a2);
                int i4 = c3 + 1;
                if (i4 < a2) {
                    this.d = a(str2, i3, c3);
                    int b2 = b(str2, i4, a2);
                    this.e = b2;
                    if (b2 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i4, a2) + '\"');
                    }
                } else {
                    this.d = a(str2, i3, c3);
                    this.e = q.a(this.f4885a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, c3) + '\"');
                }
                b = a2;
            }
            int a5 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str2, b, c, "?#");
            d(str2, b, a5);
            if (a5 < c && str2.charAt(a5) == '?') {
                int a6 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str2, a5, c, '#');
                this.g = q.d(q.a(str2, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < c && str2.charAt(a5) == '#') {
                this.h = q.a(str2, a5 + 1, c, "", true, false, false, false, null);
            }
            return this;
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            } else {
                this.f.clear();
                this.f.add("");
                i++;
            }
            int i3 = i;
            while (i3 < i2) {
                int a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i3, i2, "/\\");
                boolean z = a2 < i2;
                String str2 = str;
                a(str2, i3, a2, z, true);
                if (z) {
                    i3 = a2 + 1;
                    str = str2;
                } else {
                    str = str2;
                    i3 = a2;
                }
            }
        }

        private boolean d(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = q.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (c(a2)) {
                return;
            }
            if (d(a2)) {
                c();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, a2);
            } else {
                this.f.add(a2);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            return com.mbridge.msdk.thrid.okhttp.internal.c.a(q.a(str, i, i2, false));
        }
    }

    q(a aVar) {
        this.f4884a = aVar.f4885a;
        this.b = a(aVar.b, false);
        this.c = a(aVar.c, false);
        this.d = aVar.d;
        this.e = aVar.b();
        this.f = a(aVar.f, false);
        List<String> list = aVar.g;
        this.g = list != null ? a(list, true) : null;
        String str = aVar.h;
        this.h = str != null ? a(str, false) : null;
        this.i = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.i.substring(this.i.indexOf(58, this.f4884a.length() + 3) + 1, this.i.indexOf(64));
    }

    public String c() {
        int indexOf = this.i.indexOf(47, this.f4884a.length() + 3);
        String str = this.i;
        return this.i.substring(indexOf, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.i.indexOf(47, this.f4884a.length() + 3);
        String str = this.i;
        int a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = com.mbridge.msdk.thrid.okhttp.internal.c.a(this.i, i, a2, '/');
            arrayList.add(this.i.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public String e() {
        if (this.g == null) {
            return null;
        }
        int indexOf = this.i.indexOf(63) + 1;
        String str = this.i;
        return this.i.substring(indexOf, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q) && ((q) obj).i.equals(this.i);
    }

    public String f() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.f4884a.length() + 3;
        String str = this.i;
        return this.i.substring(length, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.d;
    }

    public boolean h() {
        return this.f4884a.equals("https");
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f4885a = this.f4884a;
        aVar.b = f();
        aVar.c = b();
        aVar.d = this.d;
        aVar.e = this.e != a(this.f4884a) ? this.e : -1;
        aVar.f.clear();
        aVar.f.addAll(d());
        aVar.a(e());
        aVar.h = a();
        return aVar;
    }

    public int j() {
        return this.e;
    }

    @Nullable
    public String k() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.g);
        return sb.toString();
    }

    public String l() {
        return this.f4884a;
    }

    public URI m() {
        String aVar = i().d().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.i;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(D5.T);
                sb.append(str2);
            }
        }
    }

    @Nullable
    public a c(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    @Nullable
    public q e(String str) {
        a c = c(str);
        if (c != null) {
            return c.a();
        }
        return null;
    }

    public static q b(String str) {
        return new a().a(null, str).a();
    }

    static List<String> d(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String a() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.p();
            }
        }
        return str.substring(i, i2);
    }

    static void a(com.mbridge.msdk.thrid.okio.c cVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i + 1));
                int a3 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i3));
                if (a2 != -1 && a3 != -1) {
                    cVar.writeByte((a2 << 4) + a3);
                    i = i3;
                }
                cVar.f(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                }
                cVar.f(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i + 1)) != -1 && com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, str2, z, z2, z3, z4, charset);
                return cVar.p();
            }
        }
        return str.substring(i, i2);
    }

    static void a(com.mbridge.msdk.thrid.okio.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.mbridge.msdk.thrid.okio.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    cVar.f(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new com.mbridge.msdk.thrid.okio.c();
                    }
                    if (charset != null && !charset.equals(com.mbridge.msdk.thrid.okhttp.internal.c.j)) {
                        cVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        cVar2.f(codePointAt);
                    }
                    while (!cVar2.f()) {
                        byte readByte = cVar2.readByte();
                        cVar.writeByte(37);
                        char[] cArr = j;
                        cVar.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        cVar.writeByte((int) cArr[readByte & Ascii.SI]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
