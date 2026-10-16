package com.unity3d.services.core.di;

import com.ironsource.C3040d4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IServiceComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0086\b¨\u0006\u000b"}, d2 = {"get", "T", "", "Lcom/unity3d/services/core/di/IServiceComponent;", "named", "", "(Lcom/unity3d/services/core/di/IServiceComponent;Ljava/lang/String;)Ljava/lang/Object;", "inject", "Lkotlin/Lazy;", C3040d4.a.t, "Lkotlin/LazyThreadSafetyMode;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class IServiceComponentKt {
    public static /* synthetic */ Object get$default(IServiceComponent iServiceComponent, String named, int i, Object obj) {
        if ((i & 1) != 0) {
            named = "";
        }
        Intrinsics.checkNotNullParameter(iServiceComponent, "<this>");
        Intrinsics.checkNotNullParameter(named, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        return registry.getService(named, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> T get(IServiceComponent iServiceComponent, String named) {
        Intrinsics.checkNotNullParameter(iServiceComponent, "<this>");
        Intrinsics.checkNotNullParameter(named, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) registry.getService(named, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Lazy inject$default(IServiceComponent iServiceComponent, String named, LazyThreadSafetyMode mode, int i, Object obj) {
        if ((i & 1) != 0) {
            named = "";
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.NONE;
        }
        Intrinsics.checkNotNullParameter(iServiceComponent, "<this>");
        Intrinsics.checkNotNullParameter(named, "named");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new IServiceComponentKt$inject$1(iServiceComponent, named));
    }

    public static final /* synthetic */ <T> Lazy<T> inject(IServiceComponent iServiceComponent, String named, LazyThreadSafetyMode mode) {
        Intrinsics.checkNotNullParameter(iServiceComponent, "<this>");
        Intrinsics.checkNotNullParameter(named, "named");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new IServiceComponentKt$inject$1(iServiceComponent, named));
    }
}
