package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: DefaultShowRewardListener.java */
/* loaded from: classes6.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f5025a = null;
    private Boolean b = null;

    public void a() {
        this.b = Boolean.TRUE;
    }

    public void b() {
        this.f5025a = Boolean.TRUE;
    }

    public Boolean c() {
        return this.b;
    }

    public Boolean d() {
        return this.f5025a;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        p0.a("ShowRewardListener", "onAdShow");
        this.f5025a = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        p0.a("ShowRewardListener", "onVideoComplete: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z, com.mbridge.msdk.videocommon.entity.c cVar2) {
        p0.a("ShowRewardListener", "onAdClose:isCompleteView:" + z + ",reward:" + cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        p0.a("ShowRewardListener", "onShowFail:" + str);
        this.b = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, String str, String str2) {
        p0.a("ShowRewardListener", "onVideoAdClicked:" + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, int i) {
        p0.a("ShowRewardListener", "onAdCloseWithIVReward: " + z + "  " + i);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        p0.a("ShowRewardListener", "onEndcardShow: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(int i, String str, String str2) {
        p0.a("ShowRewardListener", "onAutoLoad: " + str2);
    }
}
