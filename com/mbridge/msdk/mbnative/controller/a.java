package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

/* compiled from: DemandNativeController.java */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public Handler f4508a;

    public abstract void a(int i, long j, int i2, String str);

    public synchronized void a(long j, int i, boolean z, String str, String str2) {
        a(1, j, i, str2);
    }

    public void a(Context context, CampaignEx campaignEx) {
    }

    public void a(CampaignUnit campaignUnit) {
    }

    public void a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar, int i) {
    }

    public boolean a(com.mbridge.msdk.click.a aVar, Context context, CampaignEx campaignEx, String str, com.mbridge.msdk.widget.dialog.b bVar) {
        return false;
    }
}
