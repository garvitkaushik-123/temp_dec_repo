package com.inmobi.media;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class F extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2277a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(I i) {
        super(0);
        this.f2277a = i;
    }

    public final void a() {
        I i = this.f2277a;
        i.getClass();
        L3 l3 = L3.f2348a;
        if (l3.A()) {
            GestureDetectorOnGestureListenerC2634ec view = i.f2309a;
            H windowInsetListener = i.m;
            InterfaceC2971z5 interfaceC2971z5 = i.e;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(windowInsetListener, "windowInsetListener");
            Df listener = new Df(null, windowInsetListener, interfaceC2971z5);
            if (l3.F()) {
                listener.c = view;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("WindowInsetsHandler", "startListeningToInsets");
                }
                WeakHashMap weakHashMap = Df.g;
                Object obj = weakHashMap.get(view);
                if (obj == null) {
                    obj = new zf(view);
                    weakHashMap.put(view, obj);
                }
                Intrinsics.checkNotNullParameter(listener, "listener");
                ((zf) obj).f2777a.add(listener);
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("WindowInsetsHandler_INSTANCE", listener + " created - " + weakHashMap.size());
                }
            } else if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler", "WindowInsetsHandler is not supported for this version");
            }
            i.l = listener;
        } else {
            InterfaceC2971z5 interfaceC2971z52 = i.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("AdExposureTracker", "Cannot calculate curved areas for this Android OS");
            }
        }
        final I i2 = this.f2277a;
        i2.k = i2.i.scheduleWithFixedDelay(new Runnable() { // from class: com.inmobi.media.F$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                F.a(I.this);
            }
        }, 0L, this.f2277a.c, TimeUnit.MILLISECONDS);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }

    public static final void a(I this$0) {
        InterfaceC2971z5 interfaceC2971z5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(C2.a(new E(this$0)));
        if (m10244exceptionOrNullimpl == null || (interfaceC2971z5 = this$0.e) == null) {
            return;
        }
        ((A5) interfaceC2971z5).b("AdExposureTracker", "Error calculating exposure metrics - " + m10244exceptionOrNullimpl.getMessage());
    }
}
