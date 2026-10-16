package io.bidmachine.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.bidmachine.analytics.internal.AbstractC3565e;
import io.bidmachine.analytics.internal.AbstractC3567g;
import io.bidmachine.analytics.internal.q0;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class O extends AbstractC3565e {
    public static final a k = new a(null);
    private d i;
    private final String h = "mimp";
    private final Lazy j = LazyKt.lazy(e.f6668a);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private static final class b implements AppLovinCommunicatorSubscriber {
        @Override // com.applovin.communicator.AppLovinCommunicatorEntity
        public String getCommunicatorId() {
            return "";
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
        public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        }
    }

    private static final class c implements AppLovinCommunicatorSubscriber {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC3566f f6665a;
        private final Lazy b = LazyKt.lazy(a.f6666a);

        static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final a f6666a = new a();

            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }

        public c(InterfaceC3566f interfaceC3566f) {
            this.f6665a = interfaceC3566f;
        }

        private final String a() {
            return (String) this.b.getValue();
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorEntity
        public String getCommunicatorId() {
            return a();
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
        public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
            Object q0Var;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (appLovinCommunicatorMessage != null && Intrinsics.areEqual(com.moloco.sdk.internal.ilrd.provider.a.k, appLovinCommunicatorMessage.getTopic())) {
                    Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                    if (messageData == null || messageData.size() <= 0) {
                        this.f6665a.a(new q0("mimp", q0.a.MONITOR_NO_CONTENT, null, 4, null));
                        return;
                    }
                    try {
                        this.f6665a.a(s0.a(messageData));
                        q0Var = Unit.INSTANCE;
                    } catch (Throwable th) {
                        q0Var = new q0("mimp", q0.a.MONITOR_BAD_CONTENT, s0.a(th));
                    }
                    Result.m10241constructorimpl(q0Var);
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public static final class d implements AppLovinBroadcastManager.Receiver {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f6667a;
        private volatile AppLovinCommunicatorSubscriber b;

        public final void a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
            this.b = appLovinCommunicatorSubscriber;
        }

        @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
        public void onReceive(Intent intent, Map map) {
            AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber;
            if (this.f6667a && (intent instanceof AppLovinCommunicatorMessage) && (appLovinCommunicatorSubscriber = this.b) != null) {
                appLovinCommunicatorSubscriber.onMessageReceived((AppLovinCommunicatorMessage) intent);
            }
        }

        public final void a(boolean z) {
            this.f6667a = z;
        }
    }

    static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f6668a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b();
        }
    }

    private final AppLovinCommunicatorSubscriber c() {
        return (AppLovinCommunicatorSubscriber) this.j.getValue();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public String a() {
        return this.h;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void d(Context context) {
        d dVar = new d();
        AppLovinBroadcastManager.registerReceiver(dVar, new IntentFilter(com.moloco.sdk.internal.ilrd.provider.a.k));
        this.i = dVar;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void e(Context context) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(false);
        }
        AppLovinCommunicator.getInstance(context).unsubscribe(c(), com.moloco.sdk.internal.ilrd.provider.a.k);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3565e, io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        super.f(context);
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(true);
        }
        AppLovinCommunicator.getInstance(context).subscribe(c(), com.moloco.sdk.internal.ilrd.provider.a.k);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    /* renamed from: a */
    public void b(AbstractC3567g.a aVar) {
        super.b(aVar);
        d dVar = this.i;
        if (dVar == null) {
            return;
        }
        dVar.a(new c(this));
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3565e
    public AbstractC3565e.b b(Map map) {
        String obj;
        Float a2 = a0.a(map.get("revenue"));
        if (a2 != null) {
            float floatValue = a2.floatValue();
            Object obj2 = map.get("network_name");
            if (obj2 != null && (obj = obj2.toString()) != null) {
                return new AbstractC3565e.b(0, floatValue, obj, 1, null);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r3.equals("BANNER") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0073, code lost:
    
        return io.bidmachine.analytics.internal.AbstractC3565e.a.BANNER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r3.equals("REWARDED_INTERSTITIAL") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        return io.bidmachine.analytics.internal.AbstractC3565e.a.REWARDED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r3.equals("REWARDED") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r3.equals("INTER") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        return io.bidmachine.analytics.internal.AbstractC3565e.a.INTERSTITIAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if (r3.equals("MREC") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if (r3.equals("INTERSTITIAL") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        if (r3.equals("LEADER") == false) goto L44;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.bidmachine.analytics.internal.AbstractC3565e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC3565e.a c(Map map) {
        String obj;
        String upperCase;
        Object obj2 = map.get(FirebaseAnalytics.Param.AD_FORMAT);
        if (obj2 != null && (obj = obj2.toString()) != null && (upperCase = obj.toUpperCase(Locale.US)) != null) {
            switch (upperCase.hashCode()) {
                case -2053424887:
                    break;
                case -1999289321:
                    if (upperCase.equals("NATIVE")) {
                        return AbstractC3565e.a.NATIVE;
                    }
                    break;
                case -1372958932:
                    break;
                case 2374915:
                    break;
                case 69823676:
                    break;
                case 543046670:
                    break;
                case 1854800829:
                    break;
                case 1951953708:
                    break;
            }
        }
        return null;
    }
}
