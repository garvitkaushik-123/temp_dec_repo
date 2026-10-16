package com.inmobi.media;

import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.c0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2588c0 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2605d0 f2530a;
    public final /* synthetic */ AdQualityResult b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2588c0(C2605d0 c2605d0, AdQualityResult adQualityResult) {
        super(1);
        this.f2530a = c2605d0;
        this.b = adQualityResult;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Jb jb;
        Jb jb2;
        I9 i9 = (I9) obj;
        if (EnumC2790o4.d.equals(i9)) {
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("no network... skipping cleanup", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityBeaconExecutor", "no network... skipping cleanup");
        } else {
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("beacon hit completed... cleaning up", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityBeaconExecutor", "beacon hit completed... cleaning up");
            if (i9 == null) {
                WeakReference weakReference = (WeakReference) this.f2530a.d.get(this.b.getBeaconUrl());
                if (weakReference != null && (jb2 = (Jb) weakReference.get()) != null) {
                    jb2.f2327a.c("window.mraidview.broadcastEvent('AdReportSuccess')");
                }
            } else {
                WeakReference weakReference2 = (WeakReference) this.f2530a.d.get(this.b.getBeaconUrl());
                if (weakReference2 != null && (jb = (Jb) weakReference2.get()) != null) {
                    jb.f2327a.c("window.mraidview.broadcastEvent('AdReportFailed')");
                }
            }
            C2605d0 c2605d0 = this.f2530a;
            AdQualityResult result = this.b;
            c2605d0.getClass();
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
                C2656g0 c2656g0 = (C2656g0) Nc.f2375a.getValue();
                c2656g0.getClass();
                Intrinsics.checkNotNullParameter(result, "result");
                Log.i("AdQualityDao", "de-queueing");
                c2656g0.a("image_location=?", new String[]{result.getImageLocation()});
                if (c2656g0.b != null) {
                    Log.i("AdQualityDao", "sending callback - dequeue");
                }
                if (result.getImageLocation().length() == 0) {
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter("no image to clear. clean up done.", PglCryptUtils.KEY_MESSAGE);
                    Log.i("AdQualityBeaconExecutor", "no image to clear. clean up done.");
                } else {
                    File file = new File(result.getImageLocation());
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter("deleting file", PglCryptUtils.KEY_MESSAGE);
                    Log.i("AdQualityBeaconExecutor", "deleting file");
                    String message = "delete file result - " + file.delete();
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter(message, "message");
                    Log.i("AdQualityBeaconExecutor", message);
                }
            } catch (Exception e) {
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("exception while cleanup", PglCryptUtils.KEY_MESSAGE);
                Log.e("AdQualityBeaconExecutor", "exception while cleanup", e);
            }
        }
        return Unit.INSTANCE;
    }
}
