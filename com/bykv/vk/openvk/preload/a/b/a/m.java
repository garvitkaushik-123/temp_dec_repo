package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.n;
import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import com.ironsource.C3040d4;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;

/* compiled from: TypeAdapters.java */
/* loaded from: classes3.dex */
public final class m {
    public static final r<com.bykv.vk.openvk.preload.a.i> A;
    public static final s B;
    public static final s C;
    private static r<Class> D;
    private static r<BitSet> E;
    private static r<Boolean> F;
    private static r<Number> G;
    private static r<Number> H;
    private static r<Number> I;
    private static r<AtomicInteger> J;
    private static r<AtomicBoolean> K;
    private static r<AtomicIntegerArray> L;
    private static r<Number> M;
    private static r<Character> N;
    private static r<String> O;
    private static r<StringBuilder> P;
    private static r<StringBuffer> Q;
    private static r<URL> R;
    private static r<URI> S;
    private static r<InetAddress> T;
    private static r<UUID> U;
    private static r<Currency> V;
    private static r<Calendar> W;
    private static r<Locale> X;

    /* renamed from: a, reason: collision with root package name */
    public static final s f876a;
    public static final s b;
    public static final r<Boolean> c;
    public static final s d;
    public static final s e;
    public static final s f;
    public static final s g;
    public static final s h;
    public static final s i;
    public static final s j;
    public static final r<Number> k;
    public static final s l;
    public static final s m;
    public static final r<BigDecimal> n;
    public static final r<BigInteger> o;
    public static final s p;
    public static final s q;
    public static final s r;
    public static final s s;
    public static final s t;
    public static final s u;
    public static final s v;
    public static final s w;
    public static final s x;
    public static final s y;
    public static final s z;

    static {
        r<Class> a2 = new r<Class>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Class a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.a();
        D = a2;
        f876a = a(Class.class, a2);
        r<BitSet> a3 = new r<BitSet>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.12
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ BitSet a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BitSet bitSet) throws IOException {
                BitSet bitSet2 = bitSet;
                cVar.d();
                int length = bitSet2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(bitSet2.get(i2) ? 1L : 0L);
                }
                cVar.e();
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            
                if (java.lang.Integer.parseInt(r1) != 0) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
            
                r5 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
            
                if (r7.m() != 0) goto L23;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private static BitSet b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.a();
                com.bykv.vk.openvk.preload.a.d.b f2 = aVar.f();
                int i2 = 0;
                while (f2 != com.bykv.vk.openvk.preload.a.d.b.END_ARRAY) {
                    int i3 = AnonymousClass30.f884a[f2.ordinal()];
                    boolean z2 = true;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z2 = aVar.i();
                        } else if (i3 == 3) {
                            String h2 = aVar.h();
                            try {
                            } catch (NumberFormatException unused) {
                                throw new p("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(h2)));
                            }
                        } else {
                            throw new p("Invalid bitset value type: ".concat(String.valueOf(f2)));
                        }
                        if (z2) {
                            bitSet.set(i2);
                        }
                        i2++;
                        f2 = aVar.f();
                    }
                }
                aVar.b();
                return bitSet;
            }
        }.a();
        E = a3;
        b = a(BitSet.class, a3);
        F = new r<Boolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.23
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Boolean bool) throws IOException {
                cVar.a(bool);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b f2 = aVar.f();
                if (f2 == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                if (f2 == com.bykv.vk.openvk.preload.a.d.b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
                }
                return Boolean.valueOf(aVar.i());
            }
        };
        c = new r<Boolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.31
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Boolean bool) throws IOException {
                Boolean bool2 = bool;
                cVar.b(bool2 == null ? "null" : bool2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Boolean.valueOf(aVar.h());
            }
        };
        d = a(Boolean.TYPE, Boolean.class, F);
        G = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.32
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        e = a(Byte.TYPE, Byte.class, G);
        H = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.33
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        f = a(Short.TYPE, Short.class, H);
        I = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.34
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        g = a(Integer.TYPE, Integer.class, I);
        r<AtomicInteger> a4 = new r<AtomicInteger>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.35
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicInteger a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.a(atomicInteger.get());
            }

            private static AtomicInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        }.a();
        J = a4;
        h = a(AtomicInteger.class, a4);
        r<AtomicBoolean> a5 = new r<AtomicBoolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.36
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.d(atomicBoolean.get());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicBoolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.i());
            }
        }.a();
        K = a5;
        i = a(AtomicBoolean.class, a5);
        r<AtomicIntegerArray> a6 = new r<AtomicIntegerArray>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.2
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicIntegerArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.d();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(r6.get(i2));
                }
                cVar.e();
            }

            private static AtomicIntegerArray b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.m()));
                    } catch (NumberFormatException e2) {
                        throw new p(e2);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }
        }.a();
        L = a6;
        j = a(AtomicIntegerArray.class, a6);
        k = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.3
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.l());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.4
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        };
        new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.5
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        };
        r<Number> rVar = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.6
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b f2 = aVar.f();
                int i2 = AnonymousClass30.f884a[f2.ordinal()];
                if (i2 == 1 || i2 == 3) {
                    return new com.bykv.vk.openvk.preload.a.b.f(aVar.h());
                }
                if (i2 == 4) {
                    aVar.j();
                    return null;
                }
                throw new p("Expecting number, got: ".concat(String.valueOf(f2)));
            }
        };
        M = rVar;
        l = a(Number.class, rVar);
        N = new r<Character>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.7
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Character ch) throws IOException {
                Character ch2 = ch;
                cVar.b(ch2 == null ? null : String.valueOf(ch2));
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Character a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if (h2.length() != 1) {
                    throw new p("Expecting character, got: ".concat(String.valueOf(h2)));
                }
                return Character.valueOf(h2.charAt(0));
            }
        };
        m = a(Character.TYPE, Character.class, N);
        O = new r<String>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.8
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, String str) throws IOException {
                cVar.b(str);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ String a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b f2 = aVar.f();
                if (f2 == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                if (f2 == com.bykv.vk.openvk.preload.a.d.b.BOOLEAN) {
                    return Boolean.toString(aVar.i());
                }
                return aVar.h();
            }
        };
        n = new r<BigDecimal>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.9
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ BigDecimal a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.a(bigDecimal);
            }

            private static BigDecimal b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigDecimal(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        o = new r<BigInteger>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.10
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ BigInteger a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BigInteger bigInteger) throws IOException {
                cVar.a(bigInteger);
            }

            private static BigInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigInteger(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new p(e2);
                }
            }
        };
        p = a(String.class, O);
        r<StringBuilder> rVar2 = new r<StringBuilder>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.11
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, StringBuilder sb) throws IOException {
                StringBuilder sb2 = sb;
                cVar.b(sb2 == null ? null : sb2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ StringBuilder a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuilder(aVar.h());
            }
        };
        P = rVar2;
        q = a(StringBuilder.class, rVar2);
        r<StringBuffer> rVar3 = new r<StringBuffer>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.13
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, StringBuffer stringBuffer) throws IOException {
                StringBuffer stringBuffer2 = stringBuffer;
                cVar.b(stringBuffer2 == null ? null : stringBuffer2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ StringBuffer a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuffer(aVar.h());
            }
        };
        Q = rVar3;
        r = a(StringBuffer.class, rVar3);
        r<URL> rVar4 = new r<URL>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.14
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, URL url) throws IOException {
                URL url2 = url;
                cVar.b(url2 == null ? null : url2.toExternalForm());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ URL a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if ("null".equals(h2)) {
                    return null;
                }
                return new URL(h2);
            }
        };
        R = rVar4;
        s = a(URL.class, rVar4);
        r<URI> rVar5 = new r<URI>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.15
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ URI a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, URI uri) throws IOException {
                URI uri2 = uri;
                cVar.b(uri2 == null ? null : uri2.toASCIIString());
            }

            private static URI b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    String h2 = aVar.h();
                    if ("null".equals(h2)) {
                        return null;
                    }
                    return new URI(h2);
                } catch (URISyntaxException e2) {
                    throw new com.bykv.vk.openvk.preload.a.j(e2);
                }
            }
        };
        S = rVar5;
        t = a(URI.class, rVar5);
        r<InetAddress> rVar6 = new r<InetAddress>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.16
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, InetAddress inetAddress) throws IOException {
                InetAddress inetAddress2 = inetAddress;
                cVar.b(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ InetAddress a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return InetAddress.getByName(aVar.h());
            }
        };
        T = rVar6;
        u = b(InetAddress.class, rVar6);
        r<UUID> rVar7 = new r<UUID>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.17
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, UUID uuid) throws IOException {
                UUID uuid2 = uuid;
                cVar.b(uuid2 == null ? null : uuid2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ UUID a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return UUID.fromString(aVar.h());
            }
        };
        U = rVar7;
        v = a(UUID.class, rVar7);
        r<Currency> a7 = new r<Currency>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.18
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Currency currency) throws IOException {
                cVar.b(currency.getCurrencyCode());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Currency a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.h());
            }
        }.a();
        V = a7;
        w = a(Currency.class, a7);
        x = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.19
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.a() != Timestamp.class) {
                    return null;
                }
                final r<T> a8 = dVar.a((Class) Date.class);
                return (r<T>) new r<Timestamp>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.19.1
                    @Override // com.bykv.vk.openvk.preload.a.r
                    public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Timestamp timestamp) throws IOException {
                        r.this.a(cVar, timestamp);
                    }

                    @Override // com.bykv.vk.openvk.preload.a.r
                    public final /* synthetic */ Timestamp a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                        Date date = (Date) r.this.a(aVar2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }
                };
            }
        };
        final r<Calendar> rVar8 = new r<Calendar>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.20
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.h();
                    return;
                }
                cVar.f();
                cVar.a("year");
                cVar.a(r4.get(1));
                cVar.a("month");
                cVar.a(r4.get(2));
                cVar.a("dayOfMonth");
                cVar.a(r4.get(5));
                cVar.a("hourOfDay");
                cVar.a(r4.get(11));
                cVar.a("minute");
                cVar.a(r4.get(12));
                cVar.a("second");
                cVar.a(r4.get(13));
                cVar.g();
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Calendar a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                aVar.c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_OBJECT) {
                    String g2 = aVar.g();
                    int m2 = aVar.m();
                    if ("year".equals(g2)) {
                        i2 = m2;
                    } else if ("month".equals(g2)) {
                        i3 = m2;
                    } else if ("dayOfMonth".equals(g2)) {
                        i4 = m2;
                    } else if ("hourOfDay".equals(g2)) {
                        i5 = m2;
                    } else if ("minute".equals(g2)) {
                        i6 = m2;
                    } else if ("second".equals(g2)) {
                        i7 = m2;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }
        };
        W = rVar8;
        final Class<Calendar> cls = Calendar.class;
        final Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        y = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.28
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> a8 = aVar.a();
                if (a8 == cls || a8 == cls2) {
                    return rVar8;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + rVar8 + C3040d4.i.e;
            }
        };
        r<Locale> rVar9 = new r<Locale>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.21
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Locale locale) throws IOException {
                Locale locale2 = locale;
                cVar.b(locale2 == null ? null : locale2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Locale a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (nextToken2 == null && nextToken3 == null) {
                    return new Locale(nextToken);
                }
                if (nextToken3 == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, nextToken3);
            }
        };
        X = rVar9;
        z = a(Locale.class, rVar9);
        r<com.bykv.vk.openvk.preload.a.i> rVar10 = new r<com.bykv.vk.openvk.preload.a.i>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.22
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.bykv.vk.openvk.preload.a.r
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.bykv.vk.openvk.preload.a.i a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                switch (AnonymousClass30.f884a[aVar.f().ordinal()]) {
                    case 1:
                        return new n(new com.bykv.vk.openvk.preload.a.b.f(aVar.h()));
                    case 2:
                        return new n(Boolean.valueOf(aVar.i()));
                    case 3:
                        return new n(aVar.h());
                    case 4:
                        aVar.j();
                        return com.bykv.vk.openvk.preload.a.k.f917a;
                    case 5:
                        com.bykv.vk.openvk.preload.a.g gVar = new com.bykv.vk.openvk.preload.a.g();
                        aVar.a();
                        while (aVar.e()) {
                            gVar.a(a(aVar));
                        }
                        aVar.b();
                        return gVar;
                    case 6:
                        com.bykv.vk.openvk.preload.a.l lVar = new com.bykv.vk.openvk.preload.a.l();
                        aVar.c();
                        while (aVar.e()) {
                            lVar.a(aVar.g(), a(aVar));
                        }
                        aVar.d();
                        return lVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.bykv.vk.openvk.preload.a.r
            public void a(com.bykv.vk.openvk.preload.a.d.c cVar, com.bykv.vk.openvk.preload.a.i iVar) throws IOException {
                if (iVar == null || (iVar instanceof com.bykv.vk.openvk.preload.a.k)) {
                    cVar.h();
                    return;
                }
                boolean z2 = iVar instanceof n;
                if (z2) {
                    if (z2) {
                        n nVar = (n) iVar;
                        if (nVar.e()) {
                            cVar.a(nVar.a());
                            return;
                        } else if (nVar.d()) {
                            cVar.d(nVar.c());
                            return;
                        } else {
                            cVar.b(nVar.b());
                            return;
                        }
                    }
                    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(iVar)));
                }
                boolean z3 = iVar instanceof com.bykv.vk.openvk.preload.a.g;
                if (z3) {
                    cVar.d();
                    if (z3) {
                        Iterator<com.bykv.vk.openvk.preload.a.i> it = ((com.bykv.vk.openvk.preload.a.g) iVar).iterator();
                        while (it.hasNext()) {
                            a(cVar, it.next());
                        }
                        cVar.e();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(iVar)));
                }
                boolean z4 = iVar instanceof com.bykv.vk.openvk.preload.a.l;
                if (z4) {
                    cVar.f();
                    if (z4) {
                        for (Map.Entry<String, com.bykv.vk.openvk.preload.a.i> entry : ((com.bykv.vk.openvk.preload.a.l) iVar).d()) {
                            cVar.a(entry.getKey());
                            a(cVar, entry.getValue());
                        }
                        cVar.g();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(iVar)));
                }
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
        };
        A = rVar10;
        B = b(com.bykv.vk.openvk.preload.a.i.class, rVar10);
        C = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.24
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> a8 = aVar.a();
                if (!Enum.class.isAssignableFrom(a8) || a8 == Enum.class) {
                    return null;
                }
                if (!a8.isEnum()) {
                    a8 = a8.getSuperclass();
                }
                return new a(a8);
            }
        };
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.bykv.vk.openvk.preload.a.b.a.m$30, reason: invalid class name */
    static /* synthetic */ class AnonymousClass30 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f884a;

        static {
            int[] iArr = new int[com.bykv.vk.openvk.preload.a.d.b.values().length];
            f884a = iArr;
            try {
                iArr[com.bykv.vk.openvk.preload.a.d.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f884a[com.bykv.vk.openvk.preload.a.d.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    static final class a<T extends Enum<T>> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f885a = new HashMap();
        private final Map<T, String> b = new HashMap();

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            cVar.b(r3 == null ? null : this.b.get(r3));
        }

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) cls.getField(name).getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
                    if (bVar != null) {
                        name = bVar.a();
                        for (String str : bVar.b()) {
                            this.f885a.put(str, t);
                        }
                    }
                    this.f885a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            return this.f885a.get(aVar.h());
        }
    }

    public static <TT> s a(final com.bykv.vk.openvk.preload.a.c.a<TT> aVar, final r<TT> rVar) {
        return new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.25
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar2) {
                if (aVar2.equals(com.bykv.vk.openvk.preload.a.c.a.this)) {
                    return rVar;
                }
                return null;
            }
        };
    }

    public static <TT> s a(final Class<TT> cls, final r<TT> rVar) {
        return new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.26
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return rVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + rVar + C3040d4.i.e;
            }
        };
    }

    public static <TT> s a(final Class<TT> cls, final Class<TT> cls2, final r<? super TT> rVar) {
        return new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.27
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return rVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + rVar + C3040d4.i.e;
            }
        };
    }

    private static <T1> s b(final Class<T1> cls, final r<T1> rVar) {
        return new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.29
            @Override // com.bykv.vk.openvk.preload.a.s
            public final <T2> r<T2> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T2> aVar) {
                final Class<? super T2> a2 = aVar.a();
                if (cls.isAssignableFrom(a2)) {
                    return (r<T2>) new r<T1>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.29.1
                        @Override // com.bykv.vk.openvk.preload.a.r
                        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T1 t1) throws IOException {
                            rVar.a(cVar, t1);
                        }

                        @Override // com.bykv.vk.openvk.preload.a.r
                        public final T1 a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                            T1 t1 = (T1) rVar.a(aVar2);
                            if (t1 == null || a2.isInstance(t1)) {
                                return t1;
                            }
                            throw new p("Expected a " + a2.getName() + " but was " + t1.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + rVar + C3040d4.i.e;
            }
        };
    }
}
