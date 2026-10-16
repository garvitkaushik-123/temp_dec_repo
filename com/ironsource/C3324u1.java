package com.ironsource;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.ironsource.C3324u1;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.u1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3324u1 implements N1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ironsource.u1$a */
    static final class a implements LifecycleEventObserver {

        /* renamed from: a, reason: collision with root package name */
        private final W9 f3854a;

        /* renamed from: com.ironsource.u1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0309a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3855a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f3855a = iArr;
            }
        }

        public a(W9 listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f3854a = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Lifecycle.Event event, a this$0) {
            Intrinsics.checkNotNullParameter(event, "$event");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = C0309a.f3855a[event.ordinal()];
            if (i == 1) {
                this$0.f3854a.b();
                return;
            }
            if (i == 2) {
                this$0.f3854a.c();
            } else if (i == 3) {
                this$0.f3854a.d();
            } else {
                if (i != 4) {
                    return;
                }
                this$0.f3854a.a();
            }
        }

        public boolean equals(Object obj) {
            W9 w9 = this.f3854a;
            a aVar = obj instanceof a ? (a) obj : null;
            return Intrinsics.areEqual(w9, aVar != null ? aVar.f3854a : null);
        }

        public int hashCode() {
            return this.f3854a.hashCode();
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, final Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.u1$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3324u1.a.a(Lifecycle.Event.this, this);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(new a(observer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        ProcessLifecycleOwner.INSTANCE.get().getLifecycle().removeObserver(new a(observer));
    }

    @Override // com.ironsource.N1
    public void a(final W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IronLog.INTERNAL.verbose("Adding lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.u1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3324u1.c(W9.this);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.N1
    public void b(final W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IronLog.INTERNAL.verbose("Removing lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.u1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3324u1.d(W9.this);
            }
        }, 0L, 2, null);
    }
}
