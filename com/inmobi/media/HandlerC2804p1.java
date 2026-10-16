package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.p1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerC2804p1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2666a;
    public final C2787o1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2804p1(Looper looper, C2868t1 assetStore) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(assetStore, "assetStore");
        this.f2666a = new WeakReference(assetStore);
        this.b = new C2787o1(this);
    }

    public final void a() {
        try {
            sendEmptyMessage(1);
        } catch (Exception unused) {
            C2868t1 c2868t1 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
        } catch (Exception e) {
            C2868t1 c2868t1 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
        if (C2868t1.m.get()) {
            C2868t1 c2868t12 = (C2868t1) this.f2666a.get();
            int i = msg.what;
            if (i == 1) {
                if (c2868t12 != null) {
                    AdConfig.AssetCacheConfig assetCacheConfig = C2868t1.c;
                    if (assetCacheConfig == null) {
                        LinkedHashMap linkedHashMap = O2.f2380a;
                        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), null);
                        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
                        assetCacheConfig = ((AdConfig) a2).getAssetCache();
                    }
                    ArrayList b = Nc.a().b();
                    if (b.isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                        C2868t1.d();
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    C2705j c2705j = (C2705j) b.get(0);
                    Iterator it = b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C2705j c2705j2 = (C2705j) it.next();
                        if (!C2868t1.k.containsKey(c2705j.b)) {
                            c2705j = c2705j2;
                            break;
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    long currentTimeMillis = System.currentTimeMillis() - c2705j.e;
                    try {
                        if (currentTimeMillis < assetCacheConfig.getRetryInterval() * 1000) {
                            sendMessageDelayed(obtain, (assetCacheConfig.getRetryInterval() * 1000) - currentTimeMillis);
                            return;
                        }
                        if (C2868t1.k.containsKey(c2705j.b)) {
                            sendMessageDelayed(obtain, assetCacheConfig.getRetryInterval() * 1000);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                        Message obtain2 = Message.obtain();
                        obtain2.what = 2;
                        obtain2.obj = c2705j.b;
                        sendMessage(obtain2);
                        return;
                    } catch (Exception unused) {
                        C2868t1 c2868t13 = C2868t1.f2707a;
                        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                        return;
                    }
                }
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    a();
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (c2868t12 != null) {
                    Object obj = msg.obj;
                    C2705j asset = obj instanceof C2705j ? (C2705j) obj : null;
                    if (asset != null) {
                        C2755m1 a3 = Nc.a();
                        a3.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        a3.a("id = ?", new String[]{String.valueOf(asset.f2604a)});
                    }
                }
                a();
                return;
            }
            if (c2868t12 != null) {
                Object obj2 = msg.obj;
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str == null) {
                    return;
                }
                C2705j b2 = Nc.a().b(str);
                if (b2 == null) {
                    a();
                    return;
                }
                if (b2.a()) {
                    Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    try {
                        sendEmptyMessage(3);
                    } catch (Exception unused2) {
                        C2868t1 c2868t14 = C2868t1.f2707a;
                        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    }
                    c2868t12.a(b2, (byte) -1);
                    return;
                }
                AdConfig.AssetCacheConfig assetCacheConfig2 = C2868t1.c;
                if (assetCacheConfig2 != null) {
                    assetCacheConfig2.getMaxRetries();
                }
                if (b2.d <= 0) {
                    b2.l = (byte) 6;
                    c2868t12.a(b2, (byte) 6);
                    try {
                        Message obtain3 = Message.obtain();
                        obtain3.what = 4;
                        obtain3.obj = b2;
                        sendMessage(obtain3);
                        return;
                    } catch (Exception unused3) {
                        C2868t1 c2868t15 = C2868t1.f2707a;
                        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                        return;
                    }
                }
                boolean z = T9.f2439a;
                if (T9.a(false) != null) {
                    c2868t12.a(b2, b2.l);
                    C2868t1.d();
                    return;
                } else if (C2868t1.a(b2, this.b)) {
                    Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    return;
                } else {
                    Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
                    a();
                    return;
                }
            }
            return;
            C2868t1 c2868t16 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            S5 s52 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
