package com.bykv.vk.openvk.preload.a.d;

import com.bykv.vk.openvk.preload.a.b.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: JsonReader.java */
/* loaded from: classes3.dex */
public class a implements Closeable {
    private final Reader b;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private String[] n;
    private int[] o;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;

    /* renamed from: a, reason: collision with root package name */
    int f912a = 0;
    private int m = 1;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.b = reader;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean p() {
        return this.c;
    }

    public void a() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.f912a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + r());
    }

    public void b() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 4) {
            int i2 = this.m;
            this.m = i2 - 1;
            int[] iArr = this.o;
            int i3 = i2 - 2;
            iArr[i3] = iArr[i3] + 1;
            this.f912a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + r());
    }

    public void c() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 1) {
            a(3);
            this.f912a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + r());
    }

    public void d() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 2) {
            int i2 = this.m;
            int i3 = i2 - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i2 - 2;
            iArr[i4] = iArr[i4] + 1;
            this.f912a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + r());
    }

    public boolean e() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public b f() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        switch (i) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    final int q() throws IOException {
        int b;
        int[] iArr = this.l;
        int i = this.m;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int b2 = b(true);
            if (b2 != 44) {
                if (b2 != 59) {
                    if (b2 == 93) {
                        this.f912a = 4;
                        return 4;
                    }
                    throw b("Unterminated array");
                }
                v();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5 && (b = b(true)) != 44) {
                    if (b != 59) {
                        if (b == 125) {
                            this.f912a = 2;
                            return 2;
                        }
                        throw b("Unterminated object");
                    }
                    v();
                }
                int b3 = b(true);
                if (b3 == 34) {
                    this.f912a = 13;
                    return 13;
                }
                if (b3 == 39) {
                    v();
                    this.f912a = 12;
                    return 12;
                }
                if (b3 == 125) {
                    if (i2 != 5) {
                        this.f912a = 2;
                        return 2;
                    }
                    throw b("Expected name");
                }
                v();
                this.e--;
                if (a((char) b3)) {
                    this.f912a = 14;
                    return 14;
                }
                throw b("Expected name");
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int b4 = b(true);
                if (b4 != 58) {
                    if (b4 == 61) {
                        v();
                        if (this.e < this.f || b(1)) {
                            char[] cArr = this.d;
                            int i3 = this.e;
                            if (cArr[i3] == '>') {
                                this.e = i3 + 1;
                            }
                        }
                    } else {
                        throw b("Expected ':'");
                    }
                }
            } else if (i2 == 6) {
                if (this.c) {
                    y();
                }
                this.l[this.m - 1] = 7;
            } else if (i2 == 7) {
                if (b(false) == -1) {
                    this.f912a = 17;
                    return 17;
                }
                v();
                this.e--;
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int b5 = b(true);
        if (b5 == 34) {
            this.f912a = 9;
            return 9;
        }
        if (b5 == 39) {
            v();
            this.f912a = 8;
            return 8;
        }
        if (b5 != 44 && b5 != 59) {
            if (b5 == 91) {
                this.f912a = 3;
                return 3;
            }
            if (b5 != 93) {
                if (b5 == 123) {
                    this.f912a = 1;
                    return 1;
                }
                this.e--;
                int s = s();
                if (s != 0) {
                    return s;
                }
                int t = t();
                if (t != 0) {
                    return t;
                }
                if (!a(this.d[this.e])) {
                    throw b("Expected value");
                }
                v();
                this.f912a = 10;
                return 10;
            }
            if (i2 == 1) {
                this.f912a = 4;
                return 4;
            }
        }
        if (i2 == 1 || i2 == 2) {
            v();
            this.e--;
            this.f912a = 7;
            return 7;
        }
        throw b("Unexpected value");
    }

    private int s() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.d[this.e];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.e + i2 >= this.f && !b(i2 + 1)) {
                return 0;
            }
            char c2 = this.d[this.e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.f912a = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r9 != 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0097, code lost:
    
        if (r10 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009f, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
    
        if (r11 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a5, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a7, code lost:
    
        if (r13 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
    
        r19.i = r11;
        r19.e += r8;
        r19.f912a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b7, code lost:
    
        if (r9 == 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
    
        if (r9 == 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bd, code lost:
    
        if (r9 != 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
    
        r19.j = r8;
        r19.f912a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0092, code lost:
    
        if (a(r14) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0094, code lost:
    
        return r18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t() throws IOException {
        int i;
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = 0;
        int i5 = 0;
        char c = 0;
        boolean z = false;
        int i6 = 1;
        long j = 0;
        while (true) {
            char c2 = 2;
            if (i2 + i5 == i3) {
                if (i5 != cArr.length) {
                    if (!b(i5 + 1)) {
                        i = i4;
                        break;
                    }
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    return i4;
                }
            }
            char c3 = cArr[i2 + i5];
            i = i4;
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    if (c != 2 && c != 4) {
                        return i;
                    }
                    c = 5;
                } else if (c3 == '-') {
                    c2 = 6;
                    if (c == 0) {
                        c = 1;
                        z = true;
                    } else if (c != 5) {
                        return i;
                    }
                } else if (c3 != '.') {
                    if (c3 < '0' || c3 > '9') {
                        break;
                    }
                    if (c == 1 || c == 0) {
                        j = -(c3 - '0');
                    } else if (c == 2) {
                        if (j == 0) {
                            return i;
                        }
                        long j2 = (10 * j) - (c3 - '0');
                        i6 &= (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : i;
                        j = j2;
                    } else if (c == 3) {
                        c = 4;
                    } else if (c == 5 || c == 6) {
                        c = 7;
                    }
                } else {
                    if (c != 2) {
                        return i;
                    }
                    c = 3;
                }
                i5++;
                i4 = i;
            } else {
                c2 = 6;
                if (c != 5) {
                    return i;
                }
            }
            c = c2;
            i5++;
            i4 = i;
        }
    }

    private boolean a(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        v();
        return false;
    }

    public String g() throws IOException {
        String b;
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 14) {
            b = u();
        } else if (i == 12) {
            b = b('\'');
        } else if (i == 13) {
            b = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + r());
        }
        this.f912a = 0;
        this.n[this.m - 1] = b;
        return b;
    }

    public String h() throws IOException {
        String str;
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 10) {
            str = u();
        } else if (i == 8) {
            str = b('\'');
        } else if (i == 9) {
            str = b('\"');
        } else if (i == 11) {
            str = this.k;
            this.k = null;
        } else if (i == 15) {
            str = Long.toString(this.i);
        } else if (i == 16) {
            str = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + r());
        }
        this.f912a = 0;
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 5) {
            this.f912a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.f912a = 0;
            int[] iArr2 = this.o;
            int i3 = this.m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + f() + r());
    }

    public void j() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 7) {
            this.f912a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + r());
    }

    public double k() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 15) {
            this.f912a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9) {
            this.k = b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.k = u();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + r());
        }
        this.f912a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + r());
        }
        this.k = null;
        this.f912a = 0;
        int[] iArr2 = this.o;
        int i3 = this.m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public long l() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 15) {
            this.f912a = 0;
            int[] iArr = this.o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.i;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f912a = 0;
                int[] iArr2 = this.o;
                int i3 = this.m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + r());
        }
        this.f912a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.k + r());
        }
        this.k = null;
        this.f912a = 0;
        int[] iArr3 = this.o;
        int i4 = this.m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    private String b(char c) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = null;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            int i3 = i;
            while (true) {
                if (i3 < i2) {
                    int i4 = i3 + 1;
                    char c2 = cArr[i3];
                    if (c2 == c) {
                        this.e = i4;
                        int i5 = (i4 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i5);
                        }
                        sb.append(cArr, i, i5);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        this.e = i4;
                        int i6 = i4 - i;
                        int i7 = i6 - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i6 << 1, 16));
                        }
                        sb.append(cArr, i, i7);
                        sb.append(x());
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i4;
                        }
                        i3 = i4;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i3 - i) << 1, 16));
                    }
                    sb.append(cArr, i, i3 - i);
                    this.e = i3;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        v();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String u() throws IOException {
        StringBuilder sb = null;
        int i = 0;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.e;
                if (i3 + i2 < this.f) {
                    char c = this.d[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 < this.d.length) {
                    if (b(i2 + 1)) {
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.d, this.e, i2);
                    this.e += i2;
                }
            }
            i = i2;
            String str = sb != null ? new String(this.d, this.e, i) : sb.append(this.d, this.e, i).toString();
            this.e += i;
            return str;
        } while (b(1));
        if (sb != null) {
        }
        this.e += i;
        return str;
    }

    private void c(char c) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        return;
                    }
                    if (c2 == '\\') {
                        this.e = i3;
                        x();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.e = i;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    public int m() throws IOException {
        int i = this.f912a;
        if (i == 0) {
            i = q();
        }
        if (i == 15) {
            long j = this.i;
            int i2 = (int) j;
            if (j != i2) {
                throw new NumberFormatException("Expected an int but was " + this.i + r());
            }
            this.f912a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.k = u();
            } else {
                this.k = b(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f912a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + r());
        }
        this.f912a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.k + r());
        }
        this.k = null;
        this.f912a = 0;
        int[] iArr3 = this.o;
        int i6 = this.m - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f912a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x009d. Please report as an issue. */
    public void n() throws IOException {
        int i = 0;
        do {
            int i2 = this.f912a;
            if (i2 == 0) {
                i2 = q();
            }
            if (i2 == 3) {
                a(1);
            } else if (i2 == 1) {
                a(3);
            } else {
                if (i2 == 4) {
                    this.m--;
                } else if (i2 == 2) {
                    this.m--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        do {
                            int i3 = 0;
                            while (true) {
                                int i4 = this.e;
                                if (i4 + i3 < this.f) {
                                    char c = this.d[i4 + i3];
                                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                        if (c != '#') {
                                            if (c != ',') {
                                                if (c != '/' && c != '=') {
                                                    if (c != '{' && c != '}' && c != ':') {
                                                        if (c != ';') {
                                                            switch (c) {
                                                                case '[':
                                                                case ']':
                                                                    break;
                                                                case '\\':
                                                                    break;
                                                                default:
                                                                    i3++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.e = i4 + i3;
                                }
                            }
                            v();
                            this.e += i3;
                        } while (b(1));
                    } else if (i2 == 8 || i2 == 12) {
                        c('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        c('\"');
                    } else if (i2 == 16) {
                        this.e += this.j;
                    }
                    this.f912a = 0;
                }
                i--;
                this.f912a = 0;
            }
            i++;
            this.f912a = 0;
        } while (i != 0);
        int[] iArr = this.o;
        int i5 = this.m;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.n[i5 - 1] = "null";
    }

    private void a(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 << 1;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean b(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.d;
        int i4 = this.h;
        int i5 = this.e;
        this.h = i4 - i5;
        int i6 = this.f;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.b;
            int i8 = this.f;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.f + read;
            this.f = i2;
            if (this.g == 0 && (i3 = this.h) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private int b(boolean z) throws IOException {
        char c;
        char[] cArr = this.d;
        int i = this.e;
        int i2 = this.f;
        while (true) {
            if (i == i2) {
                this.e = i;
                if (!b(1)) {
                    if (z) {
                        throw new EOFException("End of input" + r());
                    }
                    return -1;
                }
                i = this.e;
                i2 = this.f;
            }
            int i3 = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.e = i3;
                    if (i3 == i2) {
                        this.e = i;
                        boolean b = b(2);
                        this.e++;
                        if (!b) {
                            break;
                        }
                    }
                    v();
                    int i4 = this.e;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.e = i4 + 1;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i = this.e + 2;
                        i2 = this.f;
                    } else {
                        if (c2 != '/') {
                            break;
                        }
                        this.e = i4 + 1;
                        w();
                        i = this.e;
                        i2 = this.f;
                    }
                } else if (c == '#') {
                    this.e = i3;
                    v();
                    w();
                    i = this.e;
                    i2 = this.f;
                } else {
                    this.e = i3;
                    return c;
                }
            }
            i = i3;
        }
        return c;
    }

    private void v() throws IOException {
        if (!this.c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() throws IOException {
        char c;
        do {
            if (this.e >= this.f && !b(1)) {
                return;
            }
            char[] cArr = this.d;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = i2;
                return;
            }
        } while (c != '\r');
    }

    private boolean a(String str) throws IOException {
        int i;
        int length = str.length();
        while (true) {
            if (this.e + length > this.f && !b(length)) {
                return false;
            }
            char[] cArr = this.d;
            int i2 = this.e;
            if (cArr[i2] != '\n') {
                while (i < length) {
                    i = this.d[this.e + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.g++;
            this.h = i2 + 1;
            this.e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + r();
    }

    final String r() {
        return " at line " + (this.g + 1) + " column " + ((this.e - this.h) + 1) + " path " + o();
    }

    public String o() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.m;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.l[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(this.o[i2]).append(AbstractJsonLexerKt.END_LIST);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.n[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    private char x() throws IOException {
        int i;
        if (this.e == this.f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.g++;
            this.h = i3;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c == 'u') {
            if (i2 + 5 > this.f && !b(4)) {
                throw b("Unterminated escape sequence");
            }
            int i4 = this.e;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char c3 = this.d[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u".concat(new String(this.d, this.e, 4)));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.e += 4;
            return c2;
        }
        throw b("Invalid escape sequence");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + r());
    }

    private void y() throws IOException {
        b(true);
        int i = this.e;
        int i2 = i - 1;
        this.e = i2;
        if (i + 4 <= this.f || b(5)) {
            char[] cArr = this.d;
            if (cArr[i2] == ')' && cArr[i] == ']' && cArr[i + 1] == '}' && cArr[i + 2] == '\'' && cArr[i + 3] == '\n') {
                this.e += 5;
            }
        }
    }

    static {
        e.f897a = new e() { // from class: com.bykv.vk.openvk.preload.a.d.a.1
            @Override // com.bykv.vk.openvk.preload.a.b.e
            public final void a(a aVar) throws IOException {
                if (aVar instanceof com.bykv.vk.openvk.preload.a.b.a.e) {
                    throw null;
                }
                int i = aVar.f912a;
                if (i == 0) {
                    i = aVar.q();
                }
                if (i == 13) {
                    aVar.f912a = 9;
                } else if (i == 12) {
                    aVar.f912a = 8;
                } else {
                    if (i == 14) {
                        aVar.f912a = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.r());
                }
            }
        };
    }
}
