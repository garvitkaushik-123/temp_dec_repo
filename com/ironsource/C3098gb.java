package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import java.util.Date;

/* renamed from: com.ironsource.gb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3098gb implements SegmentListener {

    /* renamed from: a, reason: collision with root package name */
    private SegmentListener f3316a;
    private final a b;
    protected long c;

    /* renamed from: com.ironsource.gb$a */
    private class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private Handler f3317a;

        private a() {
        }

        public Handler a() {
            return this.f3317a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f3317a = new Handler();
            Looper.loop();
        }
    }

    public C3098gb() {
        a aVar = new a();
        this.b = aVar;
        aVar.start();
        this.c = new Date().getTime();
    }

    protected boolean a(Object obj) {
        return (obj == null || this.b == null) ? false : true;
    }

    @Override // com.ironsource.mediationsdk.sdk.SegmentListener
    public void onSegmentReceived(final String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onSegmentReceived(" + str + ")", 1);
        if (a((Object) this.f3316a)) {
            a(new Runnable() { // from class: com.ironsource.gb$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3098gb.this.a(str);
                }
            });
        }
    }

    protected void a(Runnable runnable) {
        Handler a2;
        a aVar = this.b;
        if (aVar == null || (a2 = aVar.a()) == null) {
            return;
        }
        a2.post(runnable);
    }

    public void a(SegmentListener segmentListener) {
        this.f3316a = segmentListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3316a.onSegmentReceived(str);
    }
}
