package com.applovin.impl;

import android.os.Process;
import android.os.SystemClock;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.y3;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class y3 {

    /* renamed from: a, reason: collision with root package name */
    private final PriorityBlockingQueue f798a = new PriorityBlockingQueue();
    private final com.applovin.impl.sdk.k b;

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private final BlockingQueue f799a;
        private final com.applovin.impl.sdk.k b;

        private void a() {
            b((c) this.f799a.take());
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x00cc A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #7 {all -> 0x014b, blocks: (B:55:0x00b4, B:57:0x00cc, B:79:0x00f7, B:61:0x00d9, B:65:0x00e5, B:76:0x00f5, B:75:0x00f2), top: B:54:0x00b4, inners: #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void b(final c cVar) {
            int i;
            HttpURLConnection httpURLConnection;
            byte[] bArr;
            Throwable th;
            byte[] bArr2;
            HttpURLConnection httpURLConnection2;
            long j;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = 0;
            byte[] bArr3 = null;
            try {
                httpURLConnection2 = a(cVar);
                try {
                    if (cVar.d != null && cVar.d.length > 0) {
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setFixedLengthStreamingMode(cVar.d.length);
                        try {
                            OutputStream outputStream = httpURLConnection2.getOutputStream();
                            try {
                                outputStream.write(cVar.d);
                                outputStream.close();
                            } finally {
                            }
                        } catch (Throwable th2) {
                            HashMap hashMap = new HashMap();
                            CollectionUtils.putStringIfValid("details", "outputStream", hashMap);
                            this.b.E().a("NetworkCommunicationThread", "processRequest", th2, hashMap);
                            throw th2;
                        }
                    }
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    i2 = httpURLConnection2.getResponseCode();
                    j = SystemClock.elapsedRealtime();
                } catch (Throwable th3) {
                    th = th3;
                    bArr = null;
                    httpURLConnection = httpURLConnection2;
                    i = i2;
                    long j2 = elapsedRealtime;
                    Throwable th4 = th;
                    try {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.b.O().a("NetworkCommunicationThread", th4);
                        this.b.O();
                        if (com.applovin.impl.sdk.o.a()) {
                        }
                        if (httpURLConnection != null) {
                        }
                        th = th4;
                        elapsedRealtime = j2;
                        bArr2 = bArr3;
                        i2 = i;
                        httpURLConnection2 = httpURLConnection;
                        j = elapsedRealtime2;
                        bArr3 = bArr;
                        k7.a(httpURLConnection2, this.b);
                        final d a2 = d.a().a(i2).a(bArr3).b(bArr2).a(j - elapsedRealtime).a(th).a();
                        cVar.g.execute(new Runnable() { // from class: com.applovin.impl.y3$b$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                y3.b.a(y3.c.this, a2);
                            }
                        });
                    } catch (Throwable th5) {
                        k7.a(httpURLConnection, this.b);
                        throw th5;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                i = 0;
                httpURLConnection = null;
                bArr = null;
            }
            if (i2 <= 0) {
                bArr2 = null;
                th = null;
                k7.a(httpURLConnection2, this.b);
                final d a22 = d.a().a(i2).a(bArr3).b(bArr2).a(j - elapsedRealtime).a(th).a();
                cVar.g.execute(new Runnable() { // from class: com.applovin.impl.y3$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        y3.b.a(y3.c.this, a22);
                    }
                });
            }
            try {
                InputStream inputStream = httpURLConnection2.getInputStream();
                try {
                    bArr = r0.a(inputStream, this.b);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th = th7;
                            try {
                                HashMap hashMap2 = new HashMap();
                                CollectionUtils.putStringIfValid("details", "responseDataInputStream", hashMap2);
                                this.b.E().a("NetworkCommunicationThread", "processRequest", th, hashMap2);
                                throw th;
                            } catch (Throwable th8) {
                                th = th8;
                                httpURLConnection = httpURLConnection2;
                                i = i2;
                                long j22 = elapsedRealtime;
                                Throwable th42 = th;
                                long elapsedRealtime22 = SystemClock.elapsedRealtime();
                                this.b.O().a("NetworkCommunicationThread", th42);
                                this.b.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.b.O().d("NetworkCommunicationThread", "Failed to make HTTP request", th42);
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        InputStream errorStream = httpURLConnection.getErrorStream();
                                        try {
                                            bArr3 = r0.a(errorStream, this.b);
                                            if (errorStream != null) {
                                                errorStream.close();
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th9) {
                                        this.b.O().a("NetworkCommunicationThread", th42);
                                        HashMap hashMap3 = new HashMap();
                                        CollectionUtils.putStringIfValid("details", "responseErrorDataInputStream", hashMap3);
                                        this.b.E().a("NetworkCommunicationThread", "processRequest", th9, hashMap3);
                                    }
                                }
                                th = th42;
                                elapsedRealtime = j22;
                                bArr2 = bArr3;
                                i2 = i;
                                httpURLConnection2 = httpURLConnection;
                                j = elapsedRealtime22;
                                bArr3 = bArr;
                                k7.a(httpURLConnection2, this.b);
                                final d a222 = d.a().a(i2).a(bArr3).b(bArr2).a(j - elapsedRealtime).a(th).a();
                                cVar.g.execute(new Runnable() { // from class: com.applovin.impl.y3$b$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        y3.b.a(y3.c.this, a222);
                                    }
                                });
                            }
                        }
                    }
                    bArr2 = null;
                    th = null;
                    bArr3 = bArr;
                    k7.a(httpURLConnection2, this.b);
                    final d a2222 = d.a().a(i2).a(bArr3).b(bArr2).a(j - elapsedRealtime).a(th).a();
                    cVar.g.execute(new Runnable() { // from class: com.applovin.impl.y3$b$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            y3.b.a(y3.c.this, a2222);
                        }
                    });
                } catch (Throwable th10) {
                    if (inputStream == null) {
                        throw th10;
                    }
                    try {
                        inputStream.close();
                        throw th10;
                    } catch (Throwable th11) {
                        th10.addSuppressed(th11);
                        throw th10;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                bArr = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private b(BlockingQueue blockingQueue, int i, com.applovin.impl.sdk.k kVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            }
            if (kVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f799a = blockingQueue;
            this.b = kVar;
            setPriority(((Integer) kVar.a(v4.Q)).intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(c cVar, d dVar) {
            cVar.f.accept(dVar);
        }

        private HttpURLConnection a(c cVar) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.f800a).openConnection();
            httpURLConnection.setRequestMethod(cVar.b);
            httpURLConnection.setConnectTimeout(cVar.e);
            httpURLConnection.setReadTimeout(cVar.e);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!cVar.c.isEmpty()) {
                for (Map.Entry entry : cVar.c.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }
    }

    public static class c implements Comparable {
        private static final AtomicInteger i = new AtomicInteger();

        /* renamed from: a, reason: collision with root package name */
        private final String f800a;
        private final String b;
        private final Map c;
        private final byte[] d;
        private final int e;
        private final Consumer f;
        private final Executor g;
        private final int h;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f801a;
            private String b;
            private Map c = new HashMap();
            private byte[] d;
            private int e;
            private Consumer f;
            private Executor g;

            public a a(String str) {
                this.f801a = str;
                return this;
            }

            public a b(String str) {
                this.b = str;
                return this;
            }

            public a a(Map map) {
                if (map == null) {
                    map = new HashMap();
                }
                this.c = map;
                return this;
            }

            public a a(String str, String str2) {
                this.c.put(str, str2);
                return this;
            }

            public a a(byte[] bArr) {
                this.d = bArr;
                return this;
            }

            public a a(int i) {
                this.e = i;
                return this;
            }

            public a a(Consumer consumer) {
                this.f = consumer;
                return this;
            }

            public a a(Executor executor) {
                this.g = executor;
                return this;
            }

            public c a() {
                return new c(this);
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.h - cVar.h;
        }

        private c(a aVar) {
            this.f800a = aVar.f801a;
            this.b = aVar.b;
            this.c = aVar.c != null ? aVar.c : Collections.emptyMap();
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = i.incrementAndGet();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f802a;
        private final byte[] b;
        private final byte[] c;
        private final long d;
        private final Throwable e;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f803a;
            private byte[] b;
            private byte[] c;
            private long d;
            private Throwable e;

            public a a(int i) {
                this.f803a = i;
                return this;
            }

            public a b(byte[] bArr) {
                this.c = bArr;
                return this;
            }

            public a a(byte[] bArr) {
                this.b = bArr;
                return this;
            }

            public a a(Throwable th) {
                this.e = th;
                return this;
            }

            public a a(long j) {
                this.d = j;
                return this;
            }

            public d a() {
                return new d(this);
            }
        }

        public static a a() {
            return new a();
        }

        public int b() {
            return this.f802a;
        }

        public int c() {
            Throwable th = this.e;
            if (th == null) {
                return this.f802a;
            }
            throw th;
        }

        public byte[] d() {
            Throwable th = this.e;
            if (th == null) {
                return this.b;
            }
            throw th;
        }

        public long e() {
            return this.d;
        }

        public byte[] f() {
            return this.c;
        }

        private d(a aVar) {
            this.f802a = aVar.f803a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }
    }

    public y3(com.applovin.impl.sdk.k kVar) {
        this.b = kVar;
    }

    public void a() {
        for (int i = 0; i < ((Integer) this.b.a(v4.P)).intValue(); i++) {
            new b(this.f798a, i, this.b).start();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.f798a.add(cVar);
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }
}
