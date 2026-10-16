package com.mbridge.msdk.thrid.okhttp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Headers.java */
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f4882a;

    p(a aVar) {
        List<String> list = aVar.f4883a;
        this.f4882a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(int i) {
        return this.f4882a[i * 2];
    }

    @Nullable
    public String b(String str) {
        return a(this.f4882a, str);
    }

    public List<String> c(String str) {
        int b = b();
        ArrayList arrayList = null;
        for (int i = 0; i < b; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof p) && Arrays.equals(((p) obj).f4882a, this.f4882a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4882a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b = b();
        for (int i = 0; i < b; i++) {
            sb.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f4883a = new ArrayList(20);

        a a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? b(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? b("", str.substring(1)) : b("", str);
        }

        a b(String str, String str2) {
            this.f4883a.add(str);
            this.f4883a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            p.a(str);
            p.a(str2, str);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f4883a.size()) {
                if (str.equalsIgnoreCase(this.f4883a.get(i))) {
                    this.f4883a.remove(i);
                    this.f4883a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            p.a(str);
            p.a(str2, str);
            return b(str, str2);
        }

        public p a() {
            return new p(this);
        }
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f4883a, this.f4882a);
        return aVar;
    }

    public int b() {
        return this.f4882a.length / 2;
    }

    public String b(int i) {
        return this.f4882a[(i * 2) + 1];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    static void a(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(com.mbridge.msdk.thrid.okhttp.internal.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(com.mbridge.msdk.thrid.okhttp.internal.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}
