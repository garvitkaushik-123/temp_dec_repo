package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: GeckoConfig.java */
/* loaded from: classes3.dex */
public class b {
    private static IThreadPoolCallback r;
    private static ThreadPoolExecutor s;

    /* renamed from: a, reason: collision with root package name */
    private final Context f943a;
    private final com.bykv.vk.openvk.preload.geckox.a.a.c b;
    private final IStatisticMonitor c;
    private final INetWork d;
    private final List<String> e;
    private final List<String> f;
    private final com.bykv.vk.openvk.preload.geckox.a.a.a g;
    private final Long h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final File n;
    private final boolean o;
    private final long p;
    private JSONObject q;

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        Context context = aVar.d;
        this.f943a = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        List<String> list = aVar.b;
        this.e = list;
        this.f = aVar.c;
        this.b = aVar.e;
        this.g = aVar.h;
        Long l = aVar.i;
        this.h = l;
        if (TextUtils.isEmpty(aVar.j)) {
            this.i = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
        } else {
            this.i = aVar.j;
        }
        String str = aVar.k;
        this.j = str;
        this.l = aVar.n;
        this.m = aVar.o;
        this.p = aVar.p;
        if (aVar.m == null) {
            this.n = new File(context.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.n = aVar.m;
        }
        String str2 = aVar.l;
        this.k = str2;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("host == null");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (l == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        this.d = aVar.f944a;
        this.c = aVar.f;
        this.o = aVar.g;
    }

    public final Context a() {
        return this.f943a;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.a b() {
        return this.g;
    }

    public final boolean c() {
        return this.o;
    }

    public final List<String> d() {
        return this.f;
    }

    public final List<String> e() {
        return this.e;
    }

    public final JSONObject f() {
        return this.q;
    }

    public final void a(JSONObject jSONObject) {
        this.q = jSONObject;
    }

    public static Executor g() {
        return t();
    }

    public static Executor h() {
        return t();
    }

    public final INetWork i() {
        return this.d;
    }

    public final String j() {
        return this.k;
    }

    public final long k() {
        return this.h.longValue();
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.l;
    }

    public final File n() {
        return this.n;
    }

    public final String o() {
        return this.i;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.c p() {
        return this.b;
    }

    public final IStatisticMonitor q() {
        return this.c;
    }

    public final String r() {
        return this.j;
    }

    public final long s() {
        return this.p;
    }

    public static ExecutorService t() {
        IThreadPoolCallback iThreadPoolCallback = r;
        ExecutorService threadPool = iThreadPoolCallback != null ? iThreadPoolCallback.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (s == null) {
            synchronized (b.class) {
                if (s == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    s = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return s;
    }

    public static void a(IThreadPoolCallback iThreadPoolCallback) {
        r = iThreadPoolCallback;
    }

    /* compiled from: GeckoConfig.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private INetWork f944a;
        private List<String> b;
        private List<String> c;
        private Context d;
        private com.bykv.vk.openvk.preload.geckox.a.a.c e;
        private IStatisticMonitor f;
        private boolean g = true;
        private com.bykv.vk.openvk.preload.geckox.a.a.a h;
        private Long i;
        private String j;
        private String k;
        private String l;
        private File m;
        private String n;
        private String o;
        private long p;

        public a(Context context) {
            this.d = context.getApplicationContext();
        }

        public final a a(String... strArr) {
            this.c = Arrays.asList(strArr);
            return this;
        }

        public final a b(String... strArr) {
            this.b = Arrays.asList(strArr);
            return this;
        }

        public final a a(INetWork iNetWork) {
            this.f944a = iNetWork;
            return this;
        }

        public final a a(long j) {
            this.p = j;
            return this;
        }

        public final a a(IStatisticMonitor iStatisticMonitor) {
            this.f = iStatisticMonitor;
            return this;
        }

        public final a a() {
            this.g = false;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.geckox.a.a.a aVar) {
            this.h = aVar;
            return this;
        }

        public final a b() {
            this.i = 38L;
            return this;
        }

        public final a a(String str) {
            this.j = str;
            return this;
        }

        public final a b(String str) {
            this.k = str;
            return this;
        }

        public final a c(String str) {
            this.l = str;
            return this;
        }

        public final a a(File file) {
            this.m = file;
            return this;
        }
    }
}
