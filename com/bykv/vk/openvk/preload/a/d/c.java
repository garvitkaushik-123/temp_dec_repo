package com.bykv.vk.openvk.preload.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: JsonWriter.java */
/* loaded from: classes3.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f914a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            f914a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f914a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final boolean a() {
        return this.h;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final boolean b() {
        return this.i;
    }

    public final void c(boolean z) {
        this.k = z;
    }

    public final boolean c() {
        return this.k;
    }

    public final c d() throws IOException {
        j();
        return a(1, AbstractJsonLexerKt.BEGIN_LIST);
    }

    public final c e() throws IOException {
        return a(1, 2, AbstractJsonLexerKt.END_LIST);
    }

    public final c f() throws IOException {
        j();
        return a(3, AbstractJsonLexerKt.BEGIN_OBJ);
    }

    public final c g() throws IOException {
        return a(3, 5, AbstractJsonLexerKt.END_OBJ);
    }

    private c a(int i, char c) throws IOException {
        m();
        a(i);
        this.c.write(c);
        return this;
    }

    private c a(int i, int i2, char c) throws IOException {
        int i3 = i();
        if (i3 != i2 && i3 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.e--;
        if (i3 == i2) {
            k();
        }
        this.c.write(c);
        return this;
    }

    private void a(int i) {
        int i2 = this.e;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            this.d = Arrays.copyOf(iArr, i2 << 1);
        }
        int[] iArr2 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr2[i3] = i;
    }

    private int i() {
        int i = this.e;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.d[i - 1];
    }

    private void b(int i) {
        this.d[this.e - 1] = i;
    }

    public final c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.j != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j = str;
        return this;
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            c(this.j);
            this.j = null;
        }
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return h();
        }
        j();
        m();
        c(str);
        return this;
    }

    public final c h() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        m();
        this.c.write("null");
        return this;
    }

    public final c d(boolean z) throws IOException {
        j();
        m();
        this.c.write(z ? "true" : "false");
        return this;
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return h();
        }
        j();
        m();
        this.c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public final c a(long j) throws IOException {
        j();
        m();
        this.c.write(Long.toString(j));
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return h();
        }
        j();
        String obj = number.toString();
        if (!this.h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
        }
        m();
        this.c.append((CharSequence) obj);
        return this;
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.i ? b : f914a;
        this.c.write(34);
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.c.write(str, i2, i - i2);
                }
                this.c.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.c.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.c.write(str, i2, length - i2);
        }
        this.c.write(34);
    }

    private void k() throws IOException {
        if (this.f == null) {
            return;
        }
        this.c.write(10);
        int i = this.e;
        for (int i2 = 1; i2 < i; i2++) {
            this.c.write(this.f);
        }
    }

    private void l() throws IOException {
        int i = i();
        if (i == 5) {
            this.c.write(44);
        } else if (i != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int i = i();
        if (i == 1) {
            b(2);
            k();
            return;
        }
        if (i == 2) {
            this.c.append(AbstractJsonLexerKt.COMMA);
            k();
        } else {
            if (i != 4) {
                if (i != 6) {
                    if (i == 7) {
                        if (!this.h) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                b(7);
                return;
            }
            this.c.append((CharSequence) this.g);
            b(5);
        }
    }
}
