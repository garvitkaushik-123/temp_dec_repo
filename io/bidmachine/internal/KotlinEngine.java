package io.bidmachine.internal;

import com.ironsource.C3040d4;
import io.bidmachine.BidMachine;
import io.bidmachine.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: KotlinEngine.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lio/bidmachine/internal/KotlinEngine;", "", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", C3040d4.a.f, "", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class KotlinEngine {
    public static final KotlinEngine INSTANCE = new KotlinEngine();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));

    private KotlinEngine() {
    }

    @JvmStatic
    public static final void init() {
        Logger.d(BidMachine.NAME, "Init Kt");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new KotlinEngine$init$1(null), 3, null);
    }
}
