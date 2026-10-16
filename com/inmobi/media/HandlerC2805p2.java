package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.p2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerC2805p2 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC2971z5 f2667a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2805p2(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
    }

    public final void a(C2740l2 click) {
        List list;
        InterfaceC2971z5 interfaceC2971z5 = this.f2667a;
        if (interfaceC2971z5 != null) {
            String f = C2933x2.f();
            ((A5) interfaceC2971z5).a(f, H6.a(f, "access$getTAG$p(...)", "Retry attemps exhausted for click (").append(click.b).append(')').toString());
        }
        b(click);
        C2933x2.f2748a.a(click, "RETRY_EXHAUSTED");
        C2756m2 b = Nc.b();
        b.getClass();
        Intrinsics.checkNotNullParameter(click, "click");
        b.a("id = ?", new String[]{String.valueOf(click.f2628a)});
        list = C2933x2.e;
        list.remove(click);
    }

    public final void b(C2740l2 c2740l2) {
        List list;
        List list2;
        List list3;
        AdConfig.ImaiConfig imaiConfig;
        list = C2933x2.e;
        int indexOf = CollectionsKt.indexOf((List<? extends C2740l2>) list, c2740l2);
        if (-1 != indexOf) {
            list2 = C2933x2.e;
            int i = indexOf == list2.size() + (-1) ? 0 : indexOf + 1;
            list3 = C2933x2.e;
            C2740l2 c2740l22 = (C2740l2) list3.get(i);
            Message obtain = Message.obtain();
            obtain.what = c2740l22.e ? 3 : 2;
            obtain.obj = c2740l22;
            imaiConfig = C2933x2.g;
            long pingInterval = (imaiConfig != null ? imaiConfig.getPingInterval() : 0) * 1000;
            if (System.currentTimeMillis() - c2740l22.g < pingInterval) {
                sendMessageDelayed(obtain, pingInterval);
            } else {
                sendMessage(obtain);
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        AtomicBoolean atomicBoolean;
        AdConfig.ImaiConfig imaiConfig;
        List list;
        List<C2740l2> list2;
        List list3;
        AtomicBoolean atomicBoolean2;
        AdConfig.ImaiConfig imaiConfig2;
        AtomicBoolean atomicBoolean3;
        AdConfig.ImaiConfig imaiConfig3;
        AtomicBoolean atomicBoolean4;
        List list4;
        List list5;
        List list6;
        AtomicBoolean atomicBoolean5;
        Intrinsics.checkNotNullParameter(msg, "msg");
        atomicBoolean = C2933x2.h;
        if (atomicBoolean.get()) {
            try {
                int i = msg.what;
                int i2 = 3;
                if (i == 1) {
                    if (C2933x2.f2748a.g()) {
                        imaiConfig = C2933x2.g;
                        C2756m2 b = Nc.b();
                        if (imaiConfig == null) {
                            InterfaceC2971z5 interfaceC2971z5 = this.f2667a;
                            if (interfaceC2971z5 != null) {
                                String f = C2933x2.f();
                                Intrinsics.checkNotNullExpressionValue(f, "access$getTAG$p(...)");
                                ((A5) interfaceC2971z5).b(f, "Unhandled message due to ImaiConfig Null");
                                return;
                            }
                            return;
                        }
                        C2933x2.e = b.a(imaiConfig.getMaxEventBatch(), imaiConfig.getPingInterval());
                        list = C2933x2.e;
                        if (list.isEmpty()) {
                            if (T1.a(b, null, null, 63) == 0) {
                                atomicBoolean2 = C2933x2.f;
                                atomicBoolean2.set(false);
                                return;
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                sendMessageDelayed(obtain, imaiConfig.getPingInterval() * 1000);
                                return;
                            }
                        }
                        InterfaceC2971z5 interfaceC2971z52 = this.f2667a;
                        if (interfaceC2971z52 != null) {
                            String f2 = C2933x2.f();
                            Intrinsics.checkNotNullExpressionValue(f2, "access$getTAG$p(...)");
                            ((A5) interfaceC2971z52).a(f2, "Processing following click batch");
                        }
                        list2 = C2933x2.e;
                        for (C2740l2 c2740l2 : list2) {
                            Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
                            String str = c2740l2.b;
                        }
                        list3 = C2933x2.e;
                        C2740l2 c2740l22 = (C2740l2) list3.get(0);
                        Message obtain2 = Message.obtain();
                        if (!c2740l22.e) {
                            i2 = 2;
                        }
                        obtain2.what = i2;
                        obtain2.obj = c2740l22;
                        long currentTimeMillis = System.currentTimeMillis() - c2740l22.g;
                        if (currentTimeMillis < imaiConfig.getPingInterval() * 1000) {
                            sendMessageDelayed(obtain2, (imaiConfig.getPingInterval() * 1000) - currentTimeMillis);
                            return;
                        } else {
                            sendMessage(obtain2);
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    boolean z = T9.f2439a;
                    if (T9.a(false) != null) {
                        atomicBoolean3 = C2933x2.f;
                        atomicBoolean3.set(false);
                        C2933x2.a(C2933x2.f2748a);
                        return;
                    }
                    Object obj = msg.obj;
                    imaiConfig2 = C2933x2.g;
                    if ((obj instanceof C2740l2) && imaiConfig2 != null) {
                        if (((C2740l2) obj).f != 0) {
                            C2740l2 c2740l23 = (C2740l2) obj;
                            long pingCacheExpiry = imaiConfig2.getPingCacheExpiry();
                            c2740l23.getClass();
                            if (System.currentTimeMillis() - c2740l23.h <= pingCacheExpiry * 1000) {
                                int maxRetries = (imaiConfig2.getMaxRetries() - ((C2740l2) obj).f) + 1;
                                if (maxRetries == 0) {
                                    InterfaceC2971z5 interfaceC2971z53 = this.f2667a;
                                    if (interfaceC2971z53 != null) {
                                        String f3 = C2933x2.f();
                                        Intrinsics.checkNotNullExpressionValue(f3, "access$getTAG$p(...)");
                                        ((A5) interfaceC2971z53).a(f3, "Pinging click (" + ((C2740l2) obj).b + ") over HTTP");
                                    }
                                } else {
                                    InterfaceC2971z5 interfaceC2971z54 = this.f2667a;
                                    if (interfaceC2971z54 != null) {
                                        String f4 = C2933x2.f();
                                        Intrinsics.checkNotNullExpressionValue(f4, "access$getTAG$p(...)");
                                        ((A5) interfaceC2971z54).a(f4, "Retry attempt #" + maxRetries + " for click (" + ((C2740l2) obj).b + ") over HTTP");
                                    }
                                }
                                new C2852s2(new C2772n2(this), this.f2667a).a((C2740l2) obj);
                                return;
                            }
                        }
                        a((C2740l2) obj);
                        return;
                    }
                    InterfaceC2971z5 interfaceC2971z55 = this.f2667a;
                    if (interfaceC2971z55 != null) {
                        String f5 = C2933x2.f();
                        Intrinsics.checkNotNullExpressionValue(f5, "access$getTAG$p(...)");
                        ((A5) interfaceC2971z55).b(f5, "Unhandled message due to ImaiConfig Null");
                        return;
                    }
                    return;
                }
                if (i == 3) {
                    boolean z2 = T9.f2439a;
                    if (T9.a(false) != null) {
                        atomicBoolean4 = C2933x2.f;
                        atomicBoolean4.set(false);
                        C2933x2.a(C2933x2.f2748a);
                        return;
                    }
                    Object obj2 = msg.obj;
                    imaiConfig3 = C2933x2.g;
                    if ((obj2 instanceof C2740l2) && imaiConfig3 != null) {
                        if (((C2740l2) obj2).f != 0) {
                            C2740l2 c2740l24 = (C2740l2) obj2;
                            long pingCacheExpiry2 = imaiConfig3.getPingCacheExpiry();
                            c2740l24.getClass();
                            if (System.currentTimeMillis() - c2740l24.h <= pingCacheExpiry2 * 1000) {
                                int maxRetries2 = (imaiConfig3.getMaxRetries() - ((C2740l2) obj2).f) + 1;
                                if (maxRetries2 == 0) {
                                    InterfaceC2971z5 interfaceC2971z56 = this.f2667a;
                                    if (interfaceC2971z56 != null) {
                                        String f6 = C2933x2.f();
                                        Intrinsics.checkNotNullExpressionValue(f6, "access$getTAG$p(...)");
                                        ((A5) interfaceC2971z56).a(f6, "Pinging click (" + ((C2740l2) obj2).b + ") in WebView");
                                    }
                                } else {
                                    InterfaceC2971z5 interfaceC2971z57 = this.f2667a;
                                    if (interfaceC2971z57 != null) {
                                        String f7 = C2933x2.f();
                                        Intrinsics.checkNotNullExpressionValue(f7, "access$getTAG$p(...)");
                                        ((A5) interfaceC2971z57).b(f7, "Retry attempt #" + maxRetries2 + " for click (" + ((C2740l2) obj2).b + ") using WebView");
                                    }
                                }
                                new C2836r2(new C2788o2(this), this.f2667a).a((C2740l2) obj2);
                                return;
                            }
                        }
                        a((C2740l2) obj2);
                        return;
                    }
                    InterfaceC2971z5 interfaceC2971z58 = this.f2667a;
                    if (interfaceC2971z58 != null) {
                        String f8 = C2933x2.f();
                        Intrinsics.checkNotNullExpressionValue(f8, "access$getTAG$p(...)");
                        ((A5) interfaceC2971z58).b(f8, "Unhandled message due to ImaiConfig Null");
                        return;
                    }
                    return;
                }
                if (i != 4) {
                    InterfaceC2971z5 interfaceC2971z59 = this.f2667a;
                    if (interfaceC2971z59 != null) {
                        String f9 = C2933x2.f();
                        Intrinsics.checkNotNullExpressionValue(f9, "access$getTAG$p(...)");
                        ((A5) interfaceC2971z59).b(f9, "Unhandled message ( " + msg.what + " ) in pingHandler");
                        return;
                    }
                    return;
                }
                Object obj3 = msg.obj;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.inmobi.ads.core.Click");
                C2740l2 click = (C2740l2) obj3;
                InterfaceC2971z5 interfaceC2971z510 = this.f2667a;
                if (interfaceC2971z510 != null) {
                    String f10 = C2933x2.f();
                    Intrinsics.checkNotNullExpressionValue(f10, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z510).a(f10, "Processing click (" + click.b + ") completed");
                }
                C2933x2.b(C2933x2.f2748a, click);
                C2756m2 b2 = Nc.b();
                b2.getClass();
                Intrinsics.checkNotNullParameter(click, "click");
                b2.a("id = ?", new String[]{String.valueOf(click.f2628a)});
                list4 = C2933x2.e;
                list4.remove(click);
                list5 = C2933x2.e;
                if (!list5.isEmpty()) {
                    list6 = C2933x2.e;
                    C2740l2 c2740l25 = (C2740l2) list6.get(0);
                    Message obtain3 = Message.obtain();
                    if (c2740l25 == null || !c2740l25.e) {
                        i2 = 2;
                    }
                    obtain3.what = i2;
                    obtain3.obj = c2740l25;
                    sendMessage(obtain3);
                    return;
                }
                C2756m2 b3 = Nc.b();
                b3.getClass();
                if (T1.a(b3, null, null, 63) != 0) {
                    Message obtain4 = Message.obtain();
                    obtain4.what = 1;
                    sendMessage(obtain4);
                    return;
                }
                InterfaceC2971z5 interfaceC2971z511 = this.f2667a;
                if (interfaceC2971z511 != null) {
                    String f11 = C2933x2.f();
                    Intrinsics.checkNotNullExpressionValue(f11, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z511).a(f11, "Done processing all clicks!");
                }
                atomicBoolean5 = C2933x2.f;
                atomicBoolean5.set(false);
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z512 = this.f2667a;
                if (interfaceC2971z512 != null) {
                    String f12 = C2933x2.f();
                    ((A5) interfaceC2971z512).b(f12, rf.a(e, H6.a(f12, "access$getTAG$p(...)", "SDK encountered unexpected error in processing ping; ")));
                }
            }
        }
    }
}
