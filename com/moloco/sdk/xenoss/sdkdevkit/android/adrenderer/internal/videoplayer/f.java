package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class f implements e {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public final c f6321a;
    public final CoroutineScope b;
    public final MutableSharedFlow<Boolean> c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.VisibilityAwareVideoPlayer$1", f = "VisibilityAwareVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6322a;
        public /* synthetic */ boolean b;
        public /* synthetic */ boolean c;

        public a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, boolean z2, Continuation<? super Unit> continuation) {
            a aVar = f.this.new a(continuation);
            aVar.b = z;
            aVar.c = z2;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), bool2.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6322a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            boolean z2 = this.c;
            if (z && z2) {
                f.this.f6321a.play();
            } else {
                f.this.f6321a.pause();
            }
            return Unit.INSTANCE;
        }
    }

    public f(c basePlayer, K viewVisibilityTracker) {
        Flow b;
        Intrinsics.checkNotNullParameter(basePlayer, "basePlayer");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        this.f6321a = basePlayer;
        CoroutineScope MainScope = CoroutineScopeKt.MainScope();
        this.b = MainScope;
        MutableSharedFlow<Boolean> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this.c = MutableSharedFlow$default;
        b = g.b(viewVisibilityTracker, basePlayer.N());
        FlowKt.launchIn(FlowKt.combine(b, MutableSharedFlow$default, new a(null)), MainScope);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public boolean E() {
        return this.f6321a.E();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public View N() {
        return this.f6321a.N();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public Object a(Continuation<? super Unit> continuation) {
        return this.f6321a.a(continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public void b(boolean z) {
        this.f6321a.b(z);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.b, null, 1, null);
        this.f6321a.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public StateFlow<l> f() {
        return this.f6321a.f();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a> isPlaying() {
        return this.f6321a.isPlaying();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public String n() {
        return this.f6321a.n();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public StateFlow<i> p() {
        return this.f6321a.p();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public void pause() {
        this.c.tryEmit(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public void play() {
        this.c.tryEmit(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public void seekTo(long j) {
        this.f6321a.seekTo(j);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e
    public void a(String str) {
        this.f6321a.a(str);
    }
}
