package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: BannerDelivery.java */
/* loaded from: classes6.dex */
public class a {
    private static final String c = "a";

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4474a = new Handler(Looper.getMainLooper());
    private boolean b;

    /* compiled from: BannerDelivery.java */
    /* renamed from: com.mbridge.msdk.mbbanner.common.util.a$a, reason: collision with other inner class name */
    class RunnableC0352a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f4475a;
        final /* synthetic */ String b;
        final /* synthetic */ CampaignUnit c;

        RunnableC0352a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, CampaignUnit campaignUnit) {
            this.f4475a = bVar;
            this.b = str;
            this.c = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f4475a;
            if (bVar != null) {
                bVar.a(this.b, this.c, a.this.b);
            }
        }
    }

    /* compiled from: BannerDelivery.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f4476a;
        final /* synthetic */ com.mbridge.msdk.foundation.error.b b;

        b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f4476a = bVar;
            this.b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4476a != null) {
                this.b.a(a.this.b);
                this.f4476a.a(this.b);
            }
        }
    }

    /* compiled from: BannerDelivery.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f4477a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        c(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i) {
            this.f4477a = bVar;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f4477a;
            if (bVar != null) {
                bVar.a(this.b, this.c, a.this.b);
            }
        }
    }

    /* compiled from: BannerDelivery.java */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f4478a;
        final /* synthetic */ com.mbridge.msdk.foundation.error.b b;

        d(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f4478a = bVar;
            this.b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4478a != null) {
                this.b.a(a.this.b);
                this.f4478a.b(this.b);
            }
        }
    }

    public void b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        p0.b(c, "postResourceFail unitId=" + bVar2);
        this.f4474a.post(new d(bVar, bVar2));
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, CampaignUnit campaignUnit, String str) {
        p0.b(c, "postCampaignSuccess unitId=" + str);
        this.f4474a.post(new RunnableC0352a(bVar, str, campaignUnit));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        this.f4474a.post(new b(bVar, bVar2));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i) {
        p0.b(c, "postResourceSuccess unitId=" + str);
        this.f4474a.post(new c(bVar, str, i));
    }
}
