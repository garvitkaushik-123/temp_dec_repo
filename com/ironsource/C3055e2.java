package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.e2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3055e2 implements Fc {

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3263a;
    private final com.ironsource.mediationsdk.e b;
    private boolean c;

    public C3055e2(V0 adTools, com.ironsource.mediationsdk.e auctionHandler) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(auctionHandler, "auctionHandler");
        this.f3263a = adTools;
        this.b = auctionHandler;
    }

    @Override // com.ironsource.Fc
    public void a(AbstractC3407z instance, String str, Z9 publisherDataHolder) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        this.b.a(instance.h(), instance.r(), instance.m(), str);
        a(publisherDataHolder, instance.h(), str);
    }

    @Override // com.ironsource.Fc
    public void a(List<? extends AbstractC3407z> waterfallInstances, AbstractC3407z winnerInstance) {
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        Intrinsics.checkNotNullParameter(winnerInstance, "winnerInstance");
        if (this.c) {
            return;
        }
        this.c = true;
        C3207n2 h = winnerInstance.h();
        this.b.a(h, winnerInstance.r(), winnerInstance.m());
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, C3207n2> concurrentHashMap = new ConcurrentHashMap<>();
        for (AbstractC3407z abstractC3407z : waterfallInstances) {
            arrayList.add(abstractC3407z.p());
            concurrentHashMap.put(abstractC3407z.p(), abstractC3407z.h());
        }
        this.b.a(arrayList, concurrentHashMap, winnerInstance.r(), winnerInstance.m(), h);
    }

    private final void a(Z9 z9, C3207n2 c3207n2, String str) {
        if (c3207n2 != null) {
            final ImpressionData a2 = c3207n2.a(str);
            if (a2 != null) {
                for (final ImpressionDataListener impressionDataListener : new HashSet(z9.a())) {
                    this.f3263a.e(new Runnable() { // from class: com.ironsource.e2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3055e2.a(C3055e2.this, impressionDataListener, a2);
                        }
                    });
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.error(C3205n0.a(this.f3263a, "reportImpressionDataToPublisher - no auctionResponseItem or listener", (String) null, 2, (Object) null));
        this.f3263a.e().h().g("reportImpressionDataToPublisher - no auctionResponseItem or listener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3055e2 this$0, ImpressionDataListener listener, ImpressionData impressionData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        IronLog.CALLBACK.verbose(C3205n0.a(this$0.f3263a, "onImpressionSuccess " + listener.getClass().getSimpleName() + ": " + impressionData, (String) null, 2, (Object) null));
        listener.onImpressionSuccess(impressionData);
    }
}
