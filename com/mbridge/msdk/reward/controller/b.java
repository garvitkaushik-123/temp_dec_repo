package com.mbridge.msdk.reward.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.reward.controller.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RewardVideoControllerHandler.java */
/* loaded from: classes6.dex */
public class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final a f4684a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f4684a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        Object obj = message.obj;
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = this.f4684a.a(message);
        CopyOnWriteArrayList<CampaignEx> i2 = this.f4684a.i();
        List<CampaignEx> h = this.f4684a.h();
        com.mbridge.msdk.reward.adapter.c n = this.f4684a.n();
        boolean s = this.f4684a.s();
        String l = this.f4684a.l();
        String p = this.f4684a.p();
        a.h k = this.f4684a.k();
        InterVideoOutListener o = this.f4684a.o();
        boolean r = this.f4684a.r();
        MBridgeIds g = this.f4684a.g();
        boolean t = this.f4684a.t();
        switch (i) {
            case 8:
                if (i2 != null && i2.size() > 0) {
                    boolean z = (h == null || h.size() <= 0) ? false : !TextUtils.isEmpty(h.get(0).getCMPTEntryUrl());
                    int nscpt = i2.get(0).getNscpt();
                    if (n != null && n.a(i2, z, nscpt)) {
                        if (k != null && s) {
                            k.c(l, p, a2);
                            break;
                        }
                    } else if (k != null && s) {
                        com.mbridge.msdk.videocommon.a.a(p);
                        com.mbridge.msdk.videocommon.a.a();
                        com.mbridge.msdk.foundation.error.b a3 = com.mbridge.msdk.foundation.error.a.a(880010, "load timeout");
                        if (a2 != null) {
                            a2.a(a3);
                        }
                        k.a(a3, a2);
                        break;
                    }
                }
                break;
            case 9:
                if (o != null && s) {
                    if (r) {
                        this.f4684a.a();
                    }
                    o.onVideoLoadSuccess(g);
                    break;
                }
                break;
            case 16:
            case 18:
                if (o != null && s) {
                    String obj2 = obj instanceof String ? obj.toString() : "";
                    if (a2 != null && a2.p() != null) {
                        obj2 = a2.p().g();
                    }
                    com.mbridge.msdk.videocommon.a.a(p);
                    com.mbridge.msdk.videocommon.a.a();
                    if (r) {
                        this.f4684a.a();
                    }
                    o.onVideoLoadFail(g, obj2);
                    break;
                }
                break;
            case 17:
                if (o != null && s) {
                    if (r) {
                        this.f4684a.a();
                    }
                    o.onLoadSuccess(g);
                    break;
                }
                break;
            case 1001001:
                this.f4684a.a(false, d.b().a(0, t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, p, true, 1));
                break;
            case 1001002:
                if (n != null) {
                    if (!n.l()) {
                        if (!n.g(false)) {
                            if (n.g(true)) {
                                if (!n.l()) {
                                    n.h(true);
                                    break;
                                } else if (k != null) {
                                    n.f(true);
                                    CopyOnWriteArrayList<CampaignEx> h2 = n.h();
                                    if (h2 != null && h2.size() == 0) {
                                        h2 = n.f();
                                    }
                                    this.f4684a.a(h2);
                                    com.mbridge.msdk.foundation.same.report.metrics.c a4 = this.f4684a.a(h2, a2);
                                    if (a4 != null) {
                                        a4.b(h2);
                                    }
                                    k.d(l, p, a4);
                                    break;
                                }
                            }
                        } else if (!n.l()) {
                            n.h(false);
                            if (n.g(true)) {
                                if (!n.l()) {
                                    n.h(true);
                                    break;
                                } else if (k != null) {
                                    n.f(true);
                                    CopyOnWriteArrayList<CampaignEx> h3 = n.h();
                                    if (h3 != null && h3.size() == 0) {
                                        h3 = n.f();
                                    }
                                    this.f4684a.a(h3);
                                    com.mbridge.msdk.foundation.same.report.metrics.c a5 = this.f4684a.a(h3, a2);
                                    if (a5 != null) {
                                        a5.b(h3);
                                    }
                                    k.d(l, p, a5);
                                    break;
                                }
                            }
                        } else if (k != null) {
                            n.f(false);
                            CopyOnWriteArrayList<CampaignEx> h4 = n.h();
                            if (h4 != null && h4.size() == 0) {
                                h4 = n.f();
                            }
                            this.f4684a.a(h4);
                            com.mbridge.msdk.foundation.same.report.metrics.c a6 = this.f4684a.a(h4, a2);
                            if (a6 != null) {
                                a6.b(h4);
                            }
                            k.d(l, p, a6);
                            break;
                        }
                    } else if (k != null) {
                        CopyOnWriteArrayList<CampaignEx> h5 = n.h();
                        if (h5 != null && h5.size() == 0) {
                            h5 = n.f();
                        }
                        this.f4684a.a(h5);
                        com.mbridge.msdk.foundation.same.report.metrics.c a7 = this.f4684a.a(h5, a2);
                        if (a7 != null) {
                            a7.b(h5);
                        }
                        k.d(l, p, a7);
                        break;
                    }
                }
                break;
        }
    }
}
