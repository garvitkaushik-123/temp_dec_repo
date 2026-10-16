package com.inmobi.media;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.URLUtil;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.squareup.picasso.Callback;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.t1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2868t1 implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2868t1 f2707a;
    public static final Object b;
    public static AdConfig.AssetCacheConfig c;
    public static AdConfig.VastVideoConfig d;
    public static final ExecutorService e;
    public static final ThreadPoolExecutor f;
    public static HandlerC2804p1 g;
    public static HandlerThread h;
    public static final AtomicBoolean i;
    public static final AtomicBoolean j;
    public static final ConcurrentHashMap k;
    public static final ArrayList l;
    public static final AtomicBoolean m;
    public static final C2835r1 n;
    public static final C2851s1 o;

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!(config instanceof AdConfig)) {
            c = null;
            d = null;
        } else {
            AdConfig adConfig = (AdConfig) config;
            c = adConfig.getAssetCache();
            d = adConfig.getVastVideo();
        }
    }

    public final void b(C2705j c2705j) {
        String locationOnDisk = c2705j.c;
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        if (locationOnDisk == null || locationOnDisk.length() == 0 || assetCacheConfig == null) {
            return;
        }
        File file = new File(locationOnDisk);
        long min = Math.min((c2705j.g - c2705j.e) + System.currentTimeMillis(), (assetCacheConfig.getTimeToLive() * 1000) + System.currentTimeMillis());
        int nextInt = new Random().nextInt() & Integer.MAX_VALUE;
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        String url = c2705j.b;
        int maxRetries = assetCacheConfig.getMaxRetries();
        long j2 = c2705j.h;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        if (url == null) {
            url = "";
        }
        C2705j c2705j2 = new C2705j(nextInt, url, locationOnDisk, maxRetries, currentTimeMillis, currentTimeMillis2, min, j2);
        c2705j2.e = System.currentTimeMillis();
        Nc.a().a(c2705j2);
        long j3 = c2705j.e;
        c2705j2.j = AbstractC2737l.a(c2705j, file, j3, j3);
        c2705j2.i = true;
        a(c2705j2, (byte) -1);
    }

    public final synchronized void c(String str) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2721k c2721k = (C2721k) l.get(i2);
            Iterator it = c2721k.h.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(((C2942xb) it.next()).b, str)) {
                        c2721k.b++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public final synchronized void d(String str) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2721k c2721k = (C2721k) l.get(i2);
            Set set = c2721k.h;
            HashSet hashSet = c2721k.e;
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(((C2942xb) it.next()).b, str)) {
                    if (!hashSet.contains(str)) {
                        c2721k.e.add(str);
                        c2721k.f2616a++;
                    }
                }
            }
        }
    }

    public final synchronized void e() {
        ArrayList arrayList = new ArrayList();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2721k c2721k = (C2721k) l.get(i2);
            if (c2721k.f2616a == c2721k.h.size()) {
                try {
                    InterfaceC2884u1 interfaceC2884u1 = (InterfaceC2884u1) c2721k.d.get();
                    if (interfaceC2884u1 != null) {
                        interfaceC2884u1.a(c2721k);
                    }
                    arrayList.add(c2721k);
                } catch (Exception e2) {
                    Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e2, "event"));
                }
            }
        }
        b(arrayList);
    }

    static {
        C2868t1 c2868t1 = new C2868t1();
        f2707a = c2868t1;
        b = new Object();
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        l = new ArrayList();
        m = new AtomicBoolean(true);
        n = C2835r1.f2689a;
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), c2868t1);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        AdConfig adConfig = (AdConfig) a2;
        c = adConfig.getAssetCache();
        d = adConfig.getVastVideo();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new K5("t1".concat("-AP")));
        Intrinsics.checkNotNullExpressionValue(newCachedThreadPool, "newCachedThreadPool(...)");
        e = newCachedThreadPool;
        int i2 = AbstractC2970z4.f2771a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new K5("t1".concat("-AD")));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f = threadPoolExecutor;
        HandlerThread handlerThread = new HandlerThread("assetFetcher");
        h = handlerThread;
        D4.a(handlerThread, "assetFetcher");
        HandlerThread handlerThread2 = h;
        Intrinsics.checkNotNull(handlerThread2);
        Looper looper = handlerThread2.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        g = new HandlerC2804p1(looper, c2868t1);
        k = new ConcurrentHashMap(2, 0.9f, 2);
        o = new C2851s1();
    }

    public final synchronized void a(C2705j c2705j) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2721k c2721k = (C2721k) l.get(i2);
            Iterator it = c2721k.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((C2942xb) it.next()).b, c2705j.b)) {
                    if (!c2721k.g.contains(c2705j)) {
                        c2721k.g.add(c2705j);
                    }
                }
            }
        }
    }

    public final void c() {
        if (m.get()) {
            j.set(false);
            boolean z = T9.f2439a;
            if (T9.a(false) != null) {
                H7 f2 = Uc.f();
                C2835r1 c2835r1 = n;
                f2.a(c2835r1);
                Uc.f().a(new int[]{10, 2, 1}, c2835r1);
                return;
            }
            synchronized (b) {
                if (i.compareAndSet(false, true)) {
                    if (h == null) {
                        HandlerThread handlerThread = new HandlerThread("assetFetcher");
                        h = handlerThread;
                        D4.a(handlerThread, "assetFetcher");
                    }
                    if (g == null) {
                        HandlerThread handlerThread2 = h;
                        Intrinsics.checkNotNull(handlerThread2);
                        Looper looper = handlerThread2.getLooper();
                        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
                        g = new HandlerC2804p1(looper, this);
                    }
                    if (Nc.a().b().isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                        d();
                    } else {
                        Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                        H7 f3 = Uc.f();
                        C2835r1 c2835r12 = n;
                        f3.a(c2835r12);
                        Uc.f().a(new int[]{10, 2, 1}, c2835r12);
                        HandlerC2804p1 handlerC2804p1 = g;
                        Intrinsics.checkNotNull(handlerC2804p1);
                        handlerC2804p1.sendEmptyMessage(1);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void d() {
        if (m.get()) {
            synchronized (b) {
                i.set(false);
                k.clear();
                HandlerThread handlerThread = h;
                if (handlerThread != null) {
                    handlerThread.getLooper().quit();
                    handlerThread.interrupt();
                    h = null;
                    g = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0128, code lost:
    
        r20.l = 4;
        r20.d = 0;
        com.inmobi.media.C2753m.a(r1, r14, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0132, code lost:
    
        r19.f2636a.a(r20);
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0148, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018c, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0145, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018a, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0142, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0188, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x014b, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018e, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x013f, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0186, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013c, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0184, code lost:
    
        r2 = r12;
        r10 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(C2705j asset, InterfaceC2771n1 interfaceC2771n1) {
        BufferedOutputStream bufferedOutputStream;
        Object obj;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? r10;
        InputStream inputStream2;
        long elapsedRealtime;
        HttpURLConnection httpURLConnection;
        long j2;
        File a2;
        C2705j c2705j = (C2705j) k.putIfAbsent(asset.b, asset);
        AdConfig.VastVideoConfig vastVideoConfig = d;
        if (c2705j != null || vastVideoConfig == null) {
            return false;
        }
        C2753m c2753m = new C2753m(interfaceC2771n1);
        long vastMaxAssetSize = vastVideoConfig.getVastMaxAssetSize();
        List<String> allowedContentType = vastVideoConfig.getAllowedContentType();
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(allowedContentType, "allowedContentType");
        Intrinsics.checkNotNullExpressionValue("m", "TAG");
        ?? r102 = 5;
        if (T9.a(false) != null) {
            asset.l = (byte) 5;
            interfaceC2771n1.a(asset);
        } else {
            if (!Intrinsics.areEqual(asset.b, "") && URLUtil.isValidUrl(asset.b)) {
                String[] strArr = (String[]) allowedContentType.toArray(new String[0]);
                BufferedOutputStream bufferedOutputStream3 = null;
                try {
                    try {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        URLConnection openConnection = new URL(asset.b).openConnection();
                        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(60000);
                        httpURLConnection.setReadTimeout(60000);
                        int responseCode = httpURLConnection.getResponseCode();
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        if (responseCode < 400) {
                            String contentType = httpURLConnection.getContentType();
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str = strArr[i2];
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                if (contentType != null && StringsKt.equals(str, contentType, true)) {
                                    booleanRef.element = true;
                                    break;
                                }
                                i2++;
                            }
                            if (!booleanRef.element) {
                                asset.l = (byte) 3;
                                asset.d = 0;
                                c2753m.f2636a.a(asset);
                                boolean z = T9.f2439a;
                            }
                        }
                        long contentLength = httpURLConnection.getContentLength();
                        j2 = 0;
                        if (contentLength >= 0) {
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                            if (contentLength > vastMaxAssetSize) {
                                asset.l = (byte) 4;
                                asset.d = 0;
                                c2753m.f2636a.a(asset);
                                boolean z2 = T9.f2439a;
                            }
                        }
                        httpURLConnection.connect();
                        a2 = Uc.f2453a.a(asset.b);
                        if (a2.exists() && a2.delete()) {
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        }
                        inputStream = httpURLConnection.getInputStream();
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream3;
                        obj = r102;
                    }
                    try {
                        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(a2));
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                Ref.IntRef intRef = new Ref.IntRef();
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    intRef.element = read;
                                    if (read <= 0) {
                                        bufferedOutputStream2.flush();
                                        httpURLConnection.disconnect();
                                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                        P9 p9 = new P9();
                                        p9.f = httpURLConnection.getHeaderFields();
                                        asset.j = AbstractC2737l.a(asset, a2, elapsedRealtime, elapsedRealtime2);
                                        asset.k = elapsedRealtime2 - elapsedRealtime;
                                        InterfaceC2771n1 interfaceC2771n12 = c2753m.f2636a;
                                        String absolutePath = a2.getAbsolutePath();
                                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                        interfaceC2771n12.a(p9, absolutePath, asset);
                                        inputStream2 = inputStream;
                                        break;
                                    }
                                    C2753m c2753m2 = c2753m;
                                    j2 += read;
                                    if (j2 > vastMaxAssetSize) {
                                        break;
                                    }
                                    c2753m = c2753m2;
                                    bufferedOutputStream2.write(bArr, 0, read);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                r10 = inputStream;
                                T9.a((Closeable) r10);
                                T9.a(bufferedOutputStream2);
                                throw th;
                            }
                        } catch (FileNotFoundException unused) {
                        } catch (MalformedURLException unused2) {
                        } catch (ProtocolException unused3) {
                        } catch (SocketTimeoutException unused4) {
                        } catch (IOException unused5) {
                        } catch (Exception unused6) {
                        }
                    } catch (FileNotFoundException unused7) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream3 = inputStream;
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        asset.a((byte) 2);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream3;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (MalformedURLException unused8) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream4 = inputStream;
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        asset.a((byte) 1);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream4;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (ProtocolException unused9) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream5 = inputStream;
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        asset.a((byte) 5);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream5;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (SocketTimeoutException unused10) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream6 = inputStream;
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        asset.a((byte) 2);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream6;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (IOException unused11) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream7 = inputStream;
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        asset.a((byte) 5);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream7;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (Exception unused12) {
                        bufferedOutputStream3 = null;
                        InputStream inputStream8 = inputStream;
                        asset.a((byte) 0);
                        c2753m.f2636a.a(asset);
                        r102 = inputStream8;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        inputStream2 = r102;
                        T9.a((Closeable) inputStream2);
                        T9.a(bufferedOutputStream2);
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        obj = inputStream;
                        bufferedOutputStream = null;
                        bufferedOutputStream2 = bufferedOutputStream;
                        r10 = obj;
                        T9.a((Closeable) r10);
                        T9.a(bufferedOutputStream2);
                        throw th;
                    }
                } catch (FileNotFoundException unused13) {
                    inputStream = null;
                } catch (MalformedURLException unused14) {
                    inputStream = null;
                } catch (ProtocolException unused15) {
                    inputStream = null;
                } catch (SocketTimeoutException unused16) {
                    inputStream = null;
                } catch (IOException unused17) {
                    inputStream = null;
                } catch (Exception unused18) {
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = null;
                    obj = null;
                }
                T9.a((Closeable) inputStream2);
                T9.a(bufferedOutputStream2);
                return true;
            }
            asset.a((byte) 1);
            interfaceC2771n1.a(asset);
            return true;
        }
        return true;
    }

    public final synchronized void b(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            l.remove(arrayList.get(i2));
        }
    }

    public static void b() {
        ArrayList a2 = Nc.a().a();
        long j2 = 0;
        if (!a2.isEmpty()) {
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                String str = ((C2705j) it.next()).c;
                if (str != null) {
                    j2 += new File(str).length();
                }
            }
        }
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        Unit unit = null;
        if (assetCacheConfig != null) {
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            assetCacheConfig.getMaxCacheSize();
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            if (j2 > assetCacheConfig.getMaxCacheSize()) {
                C2755m1 a3 = Nc.a();
                a3.getClass();
                ArrayList a4 = T1.a(a3, null, null, null, null, "ts ASC ", 1, 15);
                C2705j asset = a4.isEmpty() ? null : (C2705j) a4.get(0);
                if (asset != null) {
                    if (m.get()) {
                        C2755m1 a5 = Nc.a();
                        a5.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        a5.a("id = ?", new String[]{String.valueOf(asset.f2604a)});
                        String str2 = asset.c;
                        if (str2 != null) {
                            File file = new File(str2);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    b();
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
        }
    }

    public static final void b(C2721k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "$assetBatch");
        synchronized (f2707a) {
            ArrayList arrayList = l;
            if (!arrayList.contains(assetBatch)) {
                arrayList.add(assetBatch);
            }
        }
        Intrinsics.checkNotNullExpressionValue("t1", "TAG");
        assetBatch.h.size();
        Iterator it = assetBatch.h.iterator();
        while (it.hasNext()) {
            String str = ((C2942xb) it.next()).b;
            C2868t1 c2868t1 = f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            C2705j a2 = Nc.a().a(str);
            if (a2 != null && a2.a()) {
                Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                c2868t1.b(a2);
            } else {
                a(str);
            }
        }
    }

    public static final void b(C2721k assetBatch, String adType) {
        String str;
        long elapsedRealtime;
        Context d2;
        Intrinsics.checkNotNullParameter(assetBatch, "$assetBatch");
        Intrinsics.checkNotNullParameter(adType, "$adType");
        synchronized (f2707a) {
            ArrayList arrayList = l;
            if (!arrayList.contains(assetBatch)) {
                arrayList.add(assetBatch);
            }
        }
        Intrinsics.checkNotNullExpressionValue("t1", "TAG");
        assetBatch.h.size();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (C2942xb c2942xb : assetBatch.h) {
            String str2 = c2942xb.b;
            int length = str2.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            if (str2.subSequence(i2, length + 1).toString().length() > 0 && c2942xb.f2753a == 2) {
                arrayList2.add(c2942xb.b);
            } else {
                arrayList3.add(c2942xb.b);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList2.size());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            try {
                Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                elapsedRealtime = SystemClock.elapsedRealtime();
                d2 = Uc.d();
            } catch (Exception unused) {
                str = adType;
            }
            if (d2 != null) {
                C2960ya c2960ya = C2960ya.f2764a;
                RequestCreator load = c2960ya.a(d2).load(str3);
                str = adType;
                try {
                    Object a2 = c2960ya.a(new C2820q1(countDownLatch, str3, elapsedRealtime, str));
                    load.fetch(a2 instanceof Callback ? (Callback) a2 : null);
                } catch (Exception unused2) {
                    countDownLatch.countDown();
                    adType = str;
                }
                adType = str;
            }
        }
        try {
            countDownLatch.await();
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
        } catch (InterruptedException unused3) {
        }
        C2868t1 c2868t1 = f2707a;
        c2868t1.e();
        c2868t1.a((byte) 0);
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            String str4 = (String) it2.next();
            C2868t1 c2868t12 = f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            C2705j a3 = Nc.a().a(str4);
            if (a3 != null && a3.a()) {
                Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                c2868t12.b(a3);
            } else {
                a(str4);
            }
        }
    }

    public final synchronized void a(C2705j c2705j, byte b2) {
        a(c2705j);
        k.remove(c2705j.b);
        if (b2 == -1) {
            d(c2705j.b);
            e();
        } else {
            c(c2705j.b);
            a(b2);
        }
    }

    public final synchronized void a(byte b2) {
        ArrayList arrayList = new ArrayList();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2721k c2721k = (C2721k) l.get(i2);
            if (c2721k.b > 0) {
                try {
                    InterfaceC2884u1 interfaceC2884u1 = (InterfaceC2884u1) c2721k.d.get();
                    if (interfaceC2884u1 != null) {
                        interfaceC2884u1.a(c2721k, b2);
                    }
                    arrayList.add(c2721k);
                } catch (Exception e2) {
                    Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e2, "event"));
                }
            }
        }
        b(arrayList);
    }

    public static void a() {
        if (m.get()) {
            synchronized (b) {
                ArrayList a2 = Nc.a().a();
                if (a2.isEmpty()) {
                    return;
                }
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    C2705j asset = (C2705j) it.next();
                    asset.getClass();
                    if (System.currentTimeMillis() > asset.g && m.get()) {
                        C2755m1 a3 = Nc.a();
                        a3.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        a3.a("id = ?", new String[]{String.valueOf(asset.f2604a)});
                        String str = asset.c;
                        if (str != null) {
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                }
                b();
                a(a2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void a(ArrayList arrayList) {
        File[] listFiles;
        File b2 = Uc.f2453a.b(Uc.d());
        if (!b2.exists() || (listFiles = b2.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(file.getAbsolutePath(), ((C2705j) it.next()).c)) {
                        break;
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue("t1", "TAG");
                    file.getAbsolutePath();
                    file.delete();
                    break;
                }
            }
        }
    }

    public static final void b(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "$remoteUrl");
        C2705j a2 = Nc.a().a(remoteUrl);
        if (a2 != null) {
            if (a2.a()) {
                f2707a.b(a2);
            } else if (a(a2, o)) {
                Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            } else {
                Intrinsics.checkNotNullExpressionValue("t1", "TAG");
            }
        }
    }

    public static void a(final C2721k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (m.get()) {
            e.execute(new Runnable() { // from class: com.inmobi.media.t1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C2868t1.b(C2721k.this);
                }
            });
        }
    }

    public static void a(final C2721k assetBatch, final String adType) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (m.get()) {
            e.execute(new Runnable() { // from class: com.inmobi.media.t1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C2868t1.b(C2721k.this, adType);
                }
            });
        }
    }

    public static void a(final String url) {
        C2705j asset;
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        if (assetCacheConfig != null) {
            int nextInt = new Random().nextInt() & Integer.MAX_VALUE;
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            int maxRetries = assetCacheConfig.getMaxRetries();
            long timeToLive = assetCacheConfig.getTimeToLive();
            Intrinsics.checkNotNullParameter(url, "url");
            asset = new C2705j(nextInt, url == null ? "" : url, null, maxRetries, currentTimeMillis, currentTimeMillis2, System.currentTimeMillis() + timeToLive, 0L);
        } else {
            asset = null;
        }
        if (Nc.a().a(url) == null && asset != null) {
            C2755m1 a2 = Nc.a();
            synchronized (a2) {
                Intrinsics.checkNotNullParameter(asset, "asset");
                a2.a(asset, "url = ?", new String[]{asset.b});
            }
        }
        f.execute(new Runnable() { // from class: com.inmobi.media.t1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2868t1.b(url);
            }
        });
    }
}
