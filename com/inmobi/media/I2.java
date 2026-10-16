package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import com.ironsource.C3040d4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class I2 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2311a;
    public final LinkedHashMap b;
    public Map c;
    public ThreadPoolExecutor d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I2(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f2311a = new ArrayList();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0323 A[Catch: OutOfMemoryError -> 0x0327, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x0327, blocks: (B:93:0x0312, B:95:0x0316, B:97:0x031c, B:99:0x0323, B:103:0x031f), top: B:92:0x0312 }] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleMessage(Message message) {
        Lazy lazy;
        Lazy lazy2;
        Map map;
        Map map2;
        boolean z;
        boolean a2;
        boolean z2;
        Map map3;
        U2 u2;
        ThreadPoolExecutor threadPoolExecutor;
        boolean booleanValue;
        ThreadPoolExecutor threadPoolExecutor2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(message, "message");
        if (O2.d.get()) {
            Unit unit = null;
            ThreadPoolExecutor threadPoolExecutor3 = null;
            ThreadPoolExecutor threadPoolExecutor4 = null;
            Unit unit2 = null;
            switch (message.what) {
                case 0:
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    Object obj = message.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigFetchInputs");
                    S2 s2 = (S2) obj;
                    Config config = s2.f2422a;
                    LinkedHashMap linkedHashMap = O2.f2380a;
                    N2 n2 = s2.b;
                    if (n2 != null) {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        n2.toString();
                        map = O2.f2380a;
                        ArrayList arrayList = (ArrayList) map.get(config);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(new WeakReference(n2));
                        map2 = O2.f2380a;
                        map2.put(config, arrayList);
                    }
                    if (!O2.c.get()) {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        config.getType();
                        break;
                    } else {
                        String accountId$media_release = config.getAccountId$media_release();
                        if (accountId$media_release != null) {
                            String type = config.getType();
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            Config a3 = D3.a(accountId$media_release, type);
                            lazy = O2.f;
                            if (((Q2) lazy.getValue()).b("root", accountId$media_release)) {
                                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                M2.a(D3.a(accountId$media_release, "root"));
                            } else {
                                Config a4 = M2.a(accountId$media_release);
                                Intrinsics.checkNotNull(a4, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                                RootConfig rootConfig = (RootConfig) a4;
                                long lastUpdateTimeStamp = rootConfig.getLastUpdateTimeStamp();
                                long expiryForType = rootConfig.getExpiryForType(rootConfig.getType());
                                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                long j = 1000;
                                Object[] objArr = System.currentTimeMillis() - lastUpdateTimeStamp > expiryForType * j;
                                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                if (objArr != false) {
                                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                    M2.a(D3.a(accountId$media_release, "root"));
                                }
                                if (!Intrinsics.areEqual("root", type)) {
                                    lazy2 = O2.f;
                                    if (((Q2) lazy2.getValue()).b(type, accountId$media_release)) {
                                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                        M2.a(a3);
                                    } else {
                                        Config a5 = M2.a(accountId$media_release, type);
                                        long lastUpdateTimeStamp2 = a5 != null ? a5.getLastUpdateTimeStamp() : 0L;
                                        long expiryForType2 = rootConfig.getExpiryForType(type);
                                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                        r12 = System.currentTimeMillis() - lastUpdateTimeStamp2 > expiryForType2 * j;
                                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                        if (r12) {
                                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                            M2.a(a3);
                                        }
                                    }
                                }
                            }
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            config.getType();
                            break;
                        }
                    }
                    break;
                case 1:
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    Object obj2 = message.obj;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.Config");
                    Config config2 = (Config) obj2;
                    String accountId$media_release2 = config2.getAccountId$media_release();
                    if (accountId$media_release2 != null) {
                        String type2 = config2.getType();
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        LinkedHashMap linkedHashMap2 = O2.f2380a;
                        Config a6 = M2.a(accountId$media_release2);
                        Intrinsics.checkNotNull(a6, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                        Map map4 = (Map) this.b.get(new J2(((RootConfig) a6).getUrlForType(type2), accountId$media_release2));
                        if (map4 != null && map4.containsKey(type2)) {
                            r12 = true;
                        }
                        Map map5 = this.c;
                        boolean z3 = (map5 == null || !map5.containsKey(type2)) ? r12 : true;
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        config2.getType();
                        if (z3) {
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            config2.getType();
                        } else {
                            this.f2311a.add(config2);
                            if (!hasMessages(2)) {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                obtain.obj = accountId$media_release2;
                                sendMessage(obtain);
                            }
                        }
                        unit2 = Unit.INSTANCE;
                    }
                    if (unit2 == null) {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        config2.getType();
                        break;
                    }
                    break;
                case 2:
                    LinkedHashMap linkedHashMap3 = O2.f2380a;
                    Object obj3 = message.obj;
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    Intrinsics.checkNotNull(M2.a((String) obj3), "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    sendEmptyMessageDelayed(3, ((RootConfig) r1).getWaitTime() * 1000);
                    break;
                case 3:
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    Iterator it = this.f2311a.iterator();
                    while (it.hasNext()) {
                        Config config3 = (Config) it.next();
                        String accountId$media_release3 = config3.getAccountId$media_release();
                        if (accountId$media_release3 != null) {
                            LinkedHashMap linkedHashMap4 = O2.f2380a;
                            Config a7 = M2.a(accountId$media_release3);
                            Intrinsics.checkNotNull(a7, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                            J2 j2 = new J2(((RootConfig) a7).getUrlForType(config3.getType()), accountId$media_release3);
                            Map map6 = (Map) this.b.get(j2);
                            if (map6 == null) {
                                map6 = new HashMap();
                                this.b.put(j2, map6);
                            }
                            map6.put(config3.getType(), config3);
                        }
                    }
                    this.f2311a.clear();
                    ThreadPoolExecutor threadPoolExecutor5 = this.d;
                    if (threadPoolExecutor5 == null || !threadPoolExecutor5.isShutdown()) {
                        threadPoolExecutor4 = this.d;
                    } else {
                        this.d = null;
                    }
                    if (threadPoolExecutor4 == null) {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        int i = AbstractC2970z4.f2771a;
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
                        String f = O2.f();
                        Intrinsics.checkNotNullExpressionValue(f, "access$getTAG$cp(...)");
                        ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(1, 1, 5L, timeUnit, linkedBlockingDeque, new K5(f));
                        threadPoolExecutor6.allowCoreThreadTimeOut(true);
                        this.d = threadPoolExecutor6;
                        sendEmptyMessage(4);
                        break;
                    }
                    break;
                case 4:
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    if (this.b.isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        sendEmptyMessage(5);
                        break;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        Map.Entry entry = (Map.Entry) this.b.entrySet().iterator().next();
                        this.c = (Map) entry.getValue();
                        this.b.remove(entry.getKey());
                        J2 j22 = (J2) entry.getKey();
                        Map map7 = this.c;
                        Intrinsics.checkNotNull(map7);
                        String str = ((J2) entry.getKey()).b;
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        Objects.toString(j22);
                        LinkedHashMap linkedHashMap5 = O2.f2380a;
                        Config a8 = M2.a(str);
                        Intrinsics.checkNotNull(a8, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                        RootConfig rootConfig2 = (RootConfig) a8;
                        int retryInterval = rootConfig2.getRetryInterval();
                        int maxRetries = rootConfig2.getMaxRetries();
                        C2897ue c2897ue = new C2897ue(rootConfig2.getIncludeIds());
                        try {
                            if (!rootConfig2.getIpAddrTPSupport().isEmpty()) {
                                Boolean bool = AbstractC2564ab.b;
                                if (bool != null) {
                                    booleanValue = bool.booleanValue();
                                } else {
                                    Context d = Uc.d();
                                    if (d != null) {
                                        ConcurrentHashMap concurrentHashMap = C6.b;
                                        C6 a9 = B6.a(d, "user_info_store");
                                        Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                                        AbstractC2564ab.b = Boolean.valueOf(a9.f2249a.getBoolean("user_age_restricted", false));
                                    }
                                    Boolean bool2 = AbstractC2564ab.b;
                                    booleanValue = bool2 != null ? bool2.booleanValue() : false;
                                }
                                if (!booleanValue) {
                                    z = true;
                                    a2 = G4.a(G4.f2291a, false, 1, null);
                                    if (a2 && map7.containsKey("root")) {
                                        HashMap hashMap = new HashMap(1);
                                        Object obj4 = map7.get("root");
                                        Intrinsics.checkNotNull(obj4);
                                        hashMap.put("root", obj4);
                                        map3 = hashMap;
                                        z2 = true;
                                    } else {
                                        z2 = a2;
                                        map3 = map7;
                                    }
                                    U2 u22 = new U2(map3, c2897ue, j22.f2321a, maxRetries, retryInterval, z2, str, z);
                                    if (map7.containsKey("root")) {
                                        u2 = null;
                                    } else {
                                        String fallbackUrlForRootType = rootConfig2.getFallbackUrlForRootType();
                                        HashMap hashMap2 = new HashMap(1);
                                        Object obj5 = map7.get("root");
                                        Intrinsics.checkNotNull(obj5);
                                        hashMap2.put("root", obj5);
                                        u2 = new U2(hashMap2, c2897ue, fallbackUrlForRootType, maxRetries, retryInterval, z2, str, z);
                                    }
                                    T2 t2 = new T2(this, u22, u2);
                                    threadPoolExecutor = this.d;
                                    if (threadPoolExecutor == null && threadPoolExecutor.isShutdown()) {
                                        this.d = null;
                                    } else {
                                        threadPoolExecutor3 = this.d;
                                    }
                                    if (threadPoolExecutor3 == null) {
                                        threadPoolExecutor3.execute(t2);
                                        break;
                                    }
                                }
                            }
                            threadPoolExecutor = this.d;
                            if (threadPoolExecutor == null) {
                            }
                            threadPoolExecutor3 = this.d;
                            if (threadPoolExecutor3 == null) {
                            }
                        } catch (OutOfMemoryError unused) {
                            O2.f();
                            if (this.b.isEmpty()) {
                                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                                sendEmptyMessage(5);
                                return;
                            }
                            return;
                        }
                        z = false;
                        a2 = G4.a(G4.f2291a, false, 1, null);
                        if (a2) {
                        }
                        z2 = a2;
                        map3 = map7;
                        U2 u222 = new U2(map3, c2897ue, j22.f2321a, maxRetries, retryInterval, z2, str, z);
                        if (map7.containsKey("root")) {
                        }
                        T2 t22 = new T2(this, u222, u2);
                    }
                    break;
                case 5:
                    ThreadPoolExecutor threadPoolExecutor7 = this.d;
                    if (threadPoolExecutor7 == null || !threadPoolExecutor7.isShutdown()) {
                        threadPoolExecutor2 = this.d;
                    } else {
                        this.d = null;
                        threadPoolExecutor2 = null;
                    }
                    if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                        this.c = null;
                        this.b.clear();
                        removeMessages(3);
                        threadPoolExecutor2.shutdownNow();
                        break;
                    }
                    break;
                case 6:
                    Object obj6 = message.obj;
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse");
                    W2 w2 = (W2) obj6;
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    if (w2.c == null) {
                        if (w2.b != 304) {
                            if (Intrinsics.areEqual(w2.f2468a.getType(), "root")) {
                                Config config4 = w2.f2468a;
                                Intrinsics.checkNotNull(config4, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
                                if (((RootConfig) config4).getIpAddrTPSupport().isEmpty()) {
                                    I5.a();
                                }
                            }
                            lazy3 = O2.f;
                            Q2 q2 = (Q2) lazy3.getValue();
                            Config config5 = w2.f2468a;
                            q2.getClass();
                            Intrinsics.checkNotNullParameter(config5, "config");
                            try {
                                if (config5.getAccountId$media_release() != null) {
                                    Intrinsics.checkNotNullExpressionValue("Q2", "TAG");
                                    config5.getType();
                                    config5.getAccountId$media_release();
                                    q2.a(config5, "account_id=? AND config_type=?", new String[]{config5.getAccountId$media_release(), config5.getType()});
                                }
                            } catch (Exception unused2) {
                            }
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            w2.f2468a.getType();
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            Objects.toString(w2.f2468a.toJson());
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            w2.f2468a.getAccountId$media_release();
                            Config config6 = w2.f2468a;
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            config6.getType();
                            config6.getAccountId$media_release();
                            ConcurrentHashMap concurrentHashMap2 = O2.e;
                            LinkedHashMap linkedHashMap6 = O2.f2380a;
                            Intrinsics.checkNotNullParameter(config6, "<this>");
                            HashMap hashMap3 = D3.f2258a;
                            concurrentHashMap2.put(D3.b(config6.getAccountId$media_release(), config6.getType()), config6);
                            M2.b(w2.f2468a);
                            break;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                            w2.f2468a.getType();
                            Config config7 = w2.f2468a;
                            if (config7.getAccountId$media_release() != null) {
                                lazy4 = O2.f;
                                Q2 q22 = (Q2) lazy4.getValue();
                                String type3 = config7.getType();
                                String accountId = config7.getAccountId$media_release();
                                Intrinsics.checkNotNull(accountId);
                                long currentTimeMillis = System.currentTimeMillis();
                                q22.getClass();
                                Intrinsics.checkNotNullParameter(type3, "type");
                                Intrinsics.checkNotNullParameter(accountId, "accountId");
                                Intrinsics.checkNotNullExpressionValue("Q2", "TAG");
                                Intrinsics.checkNotNullParameter(type3, "type");
                                Config config8 = (Config) q22.b("account_id=? AND config_type=?", new String[]{accountId, type3});
                                if (config8 != null) {
                                    config8.setLastUpdateTimeStamp(currentTimeMillis);
                                    q22.a(config8, "account_id=? AND config_type=?", new String[]{accountId, type3});
                                    break;
                                }
                            }
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                        w2.f2468a.getType();
                        break;
                    }
                    break;
                case 7:
                    Object obj7 = message.obj;
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type com.inmobi.commons.core.configs.ConfigNetworkResponse.IPAddress");
                    Z2 z22 = (Z2) obj7;
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    Objects.toString(z22);
                    if (!(z22 instanceof Y2)) {
                        if (z22 instanceof X2) {
                            I5.a();
                            break;
                        }
                    } else {
                        Boolean bool3 = AbstractC2564ab.b;
                        if (bool3 != null) {
                            r12 = bool3.booleanValue();
                        } else {
                            Context d2 = Uc.d();
                            if (d2 != null) {
                                ConcurrentHashMap concurrentHashMap3 = C6.b;
                                C6 a10 = B6.a(d2, "user_info_store");
                                Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                                AbstractC2564ab.b = Boolean.valueOf(a10.f2249a.getBoolean("user_age_restricted", false));
                            }
                            Boolean bool4 = AbstractC2564ab.b;
                            if (bool4 != null) {
                                r12 = bool4.booleanValue();
                            }
                        }
                        if (!r12) {
                            Lazy lazy5 = I5.f2313a;
                            String ipAddress = ((Y2) z22).f2490a;
                            Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
                            I5.b = ipAddress;
                            C6 c6 = (C6) I5.f2313a.getValue();
                            if (c6 != null) {
                                C6.a(c6, "cip", ipAddress, false, 4, (Object) null);
                                Unit unit3 = Unit.INSTANCE;
                            }
                            Intrinsics.checkNotNull(I5.c);
                            break;
                        } else {
                            I5.a();
                            break;
                        }
                    }
                    break;
                default:
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    break;
            }
        }
    }
}
