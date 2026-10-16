package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/* renamed from: com.ironsource.y3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class CallableC3394y3 implements Callable<C3> {

    /* renamed from: a, reason: collision with root package name */
    private final int f3944a;
    private final String b;
    private final AdData c;
    private final A3 d;
    private final InterfaceC3411z3 e;
    private final NetworkSettings f;

    /* renamed from: com.ironsource.y3$a */
    class a implements BiddingDataCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3126i5 f3945a;
        final /* synthetic */ BlockingQueue b;

        a(C3126i5 c3126i5, BlockingQueue blockingQueue) {
            this.f3945a = c3126i5;
            this.b = blockingQueue;
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onFailure(String str) {
            this.b.add(new C3(CallableC3394y3.this.d(), CallableC3394y3.this.c(), null, C3126i5.a(this.f3945a), str));
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onSuccess(Map<String, Object> map) {
            this.b.add(new C3(CallableC3394y3.this.d(), CallableC3394y3.this.c(), map, C3126i5.a(this.f3945a), null));
        }
    }

    public CallableC3394y3(int i, String str, AdData adData, A3 a3, InterfaceC3411z3 interfaceC3411z3, NetworkSettings networkSettings) {
        this.f3944a = i;
        this.b = str;
        this.c = adData;
        this.d = a3;
        this.e = interfaceC3411z3;
        this.f = networkSettings;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3 call() throws Exception {
        C3126i5 c3126i5 = new C3126i5();
        IronLog.INTERNAL.verbose(c() + " fetching bidding data");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        try {
            b().collectBiddingData(this.c, new a(c3126i5, arrayBlockingQueue));
        } catch (Exception e) {
            C3260q4.d().a(e);
            String str = "Exception while calling collectBiddingData - " + e.getMessage();
            IronLog.INTERNAL.error(str);
            InterfaceC3411z3 interfaceC3411z3 = this.e;
            if (interfaceC3411z3 != null) {
                interfaceC3411z3.a(str);
            }
        } catch (NoClassDefFoundError e2) {
            C3260q4.d().a(e2);
            String str2 = "Error while calling collectBiddingData - " + e2.getMessage();
            IronLog.INTERNAL.error(str2);
            InterfaceC3411z3 interfaceC3411z32 = this.e;
            if (interfaceC3411z32 != null) {
                interfaceC3411z32.a(str2);
            }
        }
        InterfaceC3411z3 interfaceC3411z33 = this.e;
        if (interfaceC3411z33 != null) {
            interfaceC3411z33.a(this.f);
        }
        return (C3) arrayBlockingQueue.take();
    }

    public A3 b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f3944a;
    }
}
