package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Map;

/* compiled from: VideoViewStatisticsListener.java */
/* loaded from: classes6.dex */
public class o extends k {
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    protected int t;
    private Map<Integer, String> u;
    private MBridgeVideoView.u v;
    private int w;

    /* compiled from: VideoViewStatisticsListener.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5159a;

        a(Object obj) {
            this.f5159a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f5159a;
            if (obj instanceof String) {
                o.this.b((String) obj);
            }
        }
    }

    public o(CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        this.s = false;
        this.t = 0;
        this.w = -1;
        if (this.f5152a) {
            this.u = campaignEx.getAdvImpList();
        }
        this.t = campaignEx.getVideoCompleteTime();
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        int i2;
        CampaignEx campaignEx;
        try {
            if (i != 2) {
                int i3 = 0;
                if (i != 20) {
                    if (i != 130) {
                        if (i != 6) {
                            if (i != 7) {
                                if (i == 15) {
                                    j();
                                    h();
                                    i();
                                    if (r0.a().a("i_l_s_t_r_i", false) && !this.q) {
                                        this.q = true;
                                        MBridgeVideoView.u uVar = this.v;
                                        if (uVar != null) {
                                            uVar.a();
                                        }
                                    }
                                    if (obj == null || !(obj instanceof MBridgeVideoView.v)) {
                                        i2 = 0;
                                    } else {
                                        int i4 = ((MBridgeVideoView.v) obj).f5146a;
                                        i3 = ((MBridgeVideoView.v) obj).b;
                                        i2 = i4;
                                    }
                                    if (i3 == 0 && (campaignEx = this.b) != null) {
                                        i3 = campaignEx.getVideoLength();
                                    }
                                    com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, i2, i3, this.j);
                                    com.mbridge.msdk.video.module.report.b.a(this.b, this.u, this.g, i2);
                                    if (!this.r) {
                                        this.r = true;
                                        com.mbridge.msdk.video.module.report.b.a(this.b, this.g);
                                    }
                                    if (!this.s) {
                                        int i5 = this.t;
                                        if (i5 != 0) {
                                            i3 = i5;
                                        }
                                        if (i2 >= i3) {
                                            this.s = true;
                                            i = 17;
                                        }
                                    }
                                    p0.b("NotifyListener", "onPlayProgress:" + i2);
                                    this.w = i2;
                                } else if (i != 16) {
                                    switch (i) {
                                        case 11:
                                            a();
                                            l();
                                            break;
                                        case 12:
                                            a aVar = new a(obj);
                                            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                                                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
                                            } else {
                                                aVar.run();
                                            }
                                            l();
                                            c();
                                            b();
                                            e();
                                            a();
                                            break;
                                        case 13:
                                            c();
                                            b();
                                            break;
                                    }
                                }
                            } else if (this.f5152a && obj != null && (obj instanceof Integer)) {
                                int intValue = ((Integer) obj).intValue();
                                if (intValue == 2) {
                                    if (!this.o) {
                                        this.o = true;
                                        com.mbridge.msdk.video.module.report.b.e(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                                    }
                                } else if (intValue == 1 && !this.n) {
                                    this.n = true;
                                    com.mbridge.msdk.video.module.report.b.f(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                                }
                            }
                        }
                    } else if (obj instanceof Integer) {
                        this.t = ((Integer) obj).intValue();
                    }
                } else if (r0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                    this.v = (MBridgeVideoView.u) obj;
                }
                this.i.a(i, obj);
            }
            if (this.f5152a && !this.p) {
                this.p = true;
                l();
                com.mbridge.msdk.video.module.report.b.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
            }
            this.i.a(i, obj);
        } catch (Throwable th) {
            p0.b("NotifyListener", th.getMessage(), th);
        }
    }
}
