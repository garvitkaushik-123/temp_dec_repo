package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.mbridge.msdk.MBridgeConstans;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineContext f6251a = com.moloco.sdk.internal.scheduling.b.a().getMain();

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$1$jobs$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6252a;
        public /* synthetic */ Object b;
        public final /* synthetic */ MutableState<Boolean> c;
        public final /* synthetic */ MutableState<Boolean> d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e e;
        public final /* synthetic */ State<Function1<Boolean, Unit>> f;
        public final /* synthetic */ State<Function1<Boolean, Unit>> g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, State<? extends Function1<? super Boolean, Unit>> state, State<? extends Function1<? super Boolean, Unit>> state2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = mutableState;
            this.d = mutableState2;
            this.e = eVar;
            this.f = state;
            this.g = state2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a aVar, Continuation<? super Unit> continuation) {
            return ((a) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, this.e, this.f, this.g, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6252a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a) this.b;
            q.a(this.f).invoke(Boxing.boxBoolean(aVar.e()));
            this.c.setValue(Boxing.boxBoolean(aVar.e()));
            this.d.setValue(Boxing.boxBoolean(aVar.d()));
            q.b(this.g).invoke(Boxing.boxBoolean(aVar.f()));
            View N = this.e.N();
            if (N != null) {
                N.setKeepScreenOn(aVar.d());
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$1$jobs$2", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6253a;
        public /* synthetic */ Object b;
        public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> state, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = state;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Continuation<? super Unit> continuation) {
            return ((b) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6253a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            q.c(this.c).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$1$jobs$3", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6254a;
        public /* synthetic */ Object b;
        public final /* synthetic */ State<Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> state, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = state;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar, Continuation<? super Unit> continuation) {
            return ((c) create(lVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.c, continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6254a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            q.d(this.c).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l) this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$2$1", f = "VastVideoPlayer.kt", i = {0, 1}, l = {112, 114}, m = "invokeSuspend", n = {MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW}, s = {"L$0", "L$0"})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f6255a;
        public int b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        
            if (r1.a(r7) == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            View N;
            View view;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                N = this.c.N();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar = this.c;
                if (N != null) {
                    N.setVisibility(4);
                }
                this.f6255a = N;
                this.b = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    view = (View) this.f6255a;
                    ResultKt.throwOnFailure(obj);
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    return Unit.INSTANCE;
                }
                View view2 = (View) this.f6255a;
                ResultKt.throwOnFailure(obj);
                N = view2;
            }
            if (N != null) {
                N.setVisibility(0);
            }
            this.f6255a = N;
            this.b = 2;
            if (DelayKt.delay(50L, this) != coroutine_suspended) {
                view = N;
                if (view != null) {
                }
                if (view != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3$1", f = "VastVideoPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6256a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> e;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3$1$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6257a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
            public final /* synthetic */ String c;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> d;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = eVar;
                this.c = str;
                this.d = mVar;
                this.e = mVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6257a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar = this.b;
                String str = this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar = this.d;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2 = this.e;
                eVar.a(str);
                eVar.seekTo(mVar.a().longValue());
                q.b(eVar, mVar2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = eVar;
            this.c = str;
            this.d = mVar;
            this.e = mVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6256a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f6251a;
                a aVar = new a(this.b, this.c, this.d, this.e, null);
                this.f6256a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4$1", f = "VastVideoPlayer.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6258a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4$1$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6259a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = eVar;
                this.c = mVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6259a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                q.b(this.b, this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = eVar;
            this.c = mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6258a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f6251a;
                a aVar = new a(this.b, this.c, null);
                this.f6258a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5$1", f = "VastVideoPlayer.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6260a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
        public final /* synthetic */ boolean c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5$1$1", f = "VastVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6261a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
            public final /* synthetic */ boolean c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, boolean z, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = eVar;
                this.c = z;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6261a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.b(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, boolean z, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = eVar;
            this.c = z;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6260a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = q.f6251a;
                a aVar = new a(this.b, this.c, null);
                this.f6260a = 1;
                if (BuildersKt.withContext(coroutineContext, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class h implements DisposableEffectResult {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6262a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e b;
        public final /* synthetic */ State c;

        public h(List list, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, State state) {
            this.f6262a = list;
            this.b = eVar;
            this.c = state;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public void dispose() {
            Iterator it = this.f6262a.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
            }
            this.b.destroy();
            q.a(this.c).invoke(Boolean.FALSE);
        }
    }

    public static final Unit a(String str, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m mVar2, boolean z2, Function1 function1, Function1 function12, K k, Function1 function13, Function1 function14, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        a(str, z, mVar, mVar2, z2, function1, function12, k, function13, function14, modifier, composer, i | 1, i2, i3);
        return Unit.INSTANCE;
    }

    public static final MutableState b() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    public static final MutableState c() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    public static final void b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar) {
        if (mVar.a().booleanValue()) {
            eVar.play();
        } else {
            eVar.pause();
        }
    }

    public static final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> c(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit>> state) {
        return (Function1) state.getValue();
    }

    public static final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> d(State<? extends Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d9, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L134;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x041a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final String uri, final boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> play, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> seekToMillis, final boolean z2, final Function1<? super Boolean, Unit> isPlaying, final Function1<? super Boolean, Unit> isVisible, final K viewVisibilityTracker, final Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Unit> onProgressChanged, final Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, Unit> onError, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        boolean changed;
        int i10;
        final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar2;
        boolean changed3;
        Object rememberedValue5;
        boolean changed4;
        Object rememberedValue6;
        int i11;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar3;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar;
        boolean changed5;
        Object rememberedValue7;
        boolean changed6;
        Object rememberedValue8;
        final View N;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(seekToMillis, "seekToMillis");
        Intrinsics.checkNotNullParameter(isPlaying, "isPlaying");
        Intrinsics.checkNotNullParameter(isVisible, "isVisible");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Composer startRestartGroup = composer.startRestartGroup(32444032);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(uri) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(play) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(seekToMillis) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i3 & 32) != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changed(isPlaying) ? 131072 : 65536;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i4 |= startRestartGroup.changed(isVisible) ? 1048576 : 524288;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i4 |= startRestartGroup.changed(viewVisibilityTracker) ? 8388608 : 4194304;
        }
        if ((i3 & 256) != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= startRestartGroup.changed(onProgressChanged) ? 67108864 : 33554432;
        }
        if ((i3 & 512) == 0) {
            if ((805306368 & i) == 0) {
                i5 = startRestartGroup.changed(onError) ? 536870912 : 268435456;
            }
            i6 = i4;
            i7 = i3 & 1024;
            if (i7 == 0) {
                modifier2 = modifier;
                i8 = i7;
                i9 = i2 | 6;
            } else {
                modifier2 = modifier;
                if ((i2 & 6) == 0) {
                    i8 = i7;
                    i9 = i2 | (startRestartGroup.changed(modifier2) ? 4 : 2);
                } else {
                    i8 = i7;
                    i9 = i2;
                }
            }
            if ((i6 & 306783379) != 306783378 && (i9 & 3) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                mVar = play;
                composer2 = startRestartGroup;
                modifier4 = modifier2;
            } else {
                Modifier modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32444032, i6, i9, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayer (VastVideoPlayer.kt:47)");
                }
                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Lifecycle lifecycle = ((LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
                startRestartGroup.startReplaceableGroup(-794104450);
                changed = startRestartGroup.changed(context) | startRestartGroup.changed(z) | startRestartGroup.changed(lifecycle);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (changed) {
                    i10 = i9;
                } else {
                    i10 = i9;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context, z, a.g.f5755a.a(), lifecycle), viewVisibilityTracker);
                startRestartGroup.updateRememberedValue(fVar4);
                rememberedValue9 = fVar4;
                fVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f) rememberedValue9;
                startRestartGroup.endReplaceableGroup();
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return q.a();
                    }
                };
                startRestartGroup.startReplaceableGroup(773894976);
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext) function0.invoke(), startRestartGroup));
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(isPlaying, startRestartGroup, (i6 >> 15) & 14);
                final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(isVisible, startRestartGroup, (i6 >> 18) & 14);
                Object[] objArr = new Object[0];
                startRestartGroup.startReplaceableGroup(-794074476);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return q.b();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState mutableState = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) null, (String) null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                Object[] objArr2 = new Object[0];
                startRestartGroup.startReplaceableGroup(-794071564);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return q.c();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) rememberedValue3, startRestartGroup, 3072, 6);
                final State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onProgressChanged, startRestartGroup, (i6 >> 24) & 14);
                final State rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(onError, startRestartGroup, (i6 >> 27) & 14);
                startRestartGroup.startReplaceableGroup(-794063918);
                changed2 = startRestartGroup.changed(fVar) | startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changed(coroutineScope) | startRestartGroup.changed(rememberUpdatedState3) | startRestartGroup.changed(rememberUpdatedState4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return q.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e.this, coroutineScope, mutableState2, mutableState, rememberUpdatedState, rememberUpdatedState2, rememberUpdatedState3, rememberUpdatedState4, (DisposableEffectScope) obj);
                        }
                    };
                    fVar2 = fVar;
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                } else {
                    fVar2 = fVar;
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(fVar2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(-794027148);
                changed3 = startRestartGroup.changed(fVar2);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed3 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new d(fVar2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-794015629);
                changed4 = startRestartGroup.changed(fVar2) | startRestartGroup.changed(uri) | startRestartGroup.changed(seekToMillis) | startRestartGroup.changed(play);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed4 || rememberedValue6 == companion.getEmpty()) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar5 = fVar2;
                    i11 = i6;
                    e eVar = new e(fVar5, uri, seekToMillis, play, null);
                    fVar3 = fVar5;
                    mVar = play;
                    startRestartGroup.updateRememberedValue(eVar);
                    rememberedValue6 = eVar;
                } else {
                    i11 = i6;
                    mVar = play;
                    fVar3 = fVar2;
                }
                startRestartGroup.endReplaceableGroup();
                int i12 = i11 >> 3;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar6 = fVar3;
                EffectsKt.LaunchedEffect(fVar6, uri, seekToMillis, (Function2) rememberedValue6, startRestartGroup, ((i11 << 3) & 112) | (i12 & 896));
                startRestartGroup.startReplaceableGroup(-793998962);
                changed5 = startRestartGroup.changed(fVar6) | startRestartGroup.changed(mVar);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (!changed5 || rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new f(fVar6, mVar, null);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(fVar6, mVar, (Function2) rememberedValue7, startRestartGroup, i12 & 112);
                Boolean valueOf = Boolean.valueOf(z2);
                startRestartGroup.startReplaceableGroup(-793993338);
                changed6 = startRestartGroup.changed(fVar6) | startRestartGroup.changed(z2);
                rememberedValue8 = startRestartGroup.rememberedValue();
                if (!changed6 || rememberedValue8 == companion.getEmpty()) {
                    rememberedValue8 = new g(fVar6, z2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(fVar6, valueOf, (Function2) rememberedValue8, startRestartGroup, (i11 >> 9) & 112);
                N = fVar6.N();
                if (N != null) {
                    modifier3 = modifier5;
                    composer2 = startRestartGroup;
                } else {
                    startRestartGroup.startReplaceableGroup(-1928433433);
                    boolean changed7 = startRestartGroup.changed(N);
                    Object rememberedValue10 = startRestartGroup.rememberedValue();
                    if (changed7 || rememberedValue10 == companion.getEmpty()) {
                        rememberedValue10 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return q.a(N, (Context) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier3 = modifier5;
                    AndroidView_androidKt.AndroidView((Function1) rememberedValue10, modifier3, null, startRestartGroup, (i10 << 3) & 112, 4);
                    composer2 = startRestartGroup;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2 = mVar;
                endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return q.a(uri, z, mVar2, seekToMillis, z2, isPlaying, isVisible, viewVisibilityTracker, onProgressChanged, onError, modifier4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i5 = C.ENCODING_PCM_32BIT;
        i4 |= i5;
        i6 = i4;
        i7 = i3 & 1024;
        if (i7 == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Lifecycle lifecycle2 = ((LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
        startRestartGroup.startReplaceableGroup(-794104450);
        changed = startRestartGroup.changed(context2) | startRestartGroup.changed(z) | startRestartGroup.changed(lifecycle2);
        Object rememberedValue92 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar42 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(context2, z, a.g.f5755a.a(), lifecycle2), viewVisibilityTracker);
        startRestartGroup.updateRememberedValue(fVar42);
        rememberedValue92 = fVar42;
        fVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f) rememberedValue92;
        startRestartGroup.endReplaceableGroup();
        Function0 function02 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.a();
            }
        };
        startRestartGroup.startReplaceableGroup(773894976);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        final State rememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(isPlaying, startRestartGroup, (i6 >> 15) & 14);
        final State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(isVisible, startRestartGroup, (i6 >> 18) & 14);
        Object[] objArr3 = new Object[0];
        startRestartGroup.startReplaceableGroup(-794074476);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr3, (Saver) null, (String) null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
        Object[] objArr22 = new Object[0];
        startRestartGroup.startReplaceableGroup(-794071564);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState22 = (MutableState) RememberSaveableKt.m3680rememberSaveable(objArr22, (Saver) null, (String) null, (Function0) rememberedValue3, startRestartGroup, 3072, 6);
        final State rememberUpdatedState32 = SnapshotStateKt.rememberUpdatedState(onProgressChanged, startRestartGroup, (i6 >> 24) & 14);
        final State rememberUpdatedState42 = SnapshotStateKt.rememberUpdatedState(onError, startRestartGroup, (i6 >> 27) & 14);
        startRestartGroup.startReplaceableGroup(-794063918);
        changed2 = startRestartGroup.changed(fVar) | startRestartGroup.changed(rememberUpdatedState5) | startRestartGroup.changed(mutableState22) | startRestartGroup.changed(mutableState3) | startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changed(coroutineScope2) | startRestartGroup.changed(rememberUpdatedState32) | startRestartGroup.changed(rememberUpdatedState42);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (changed2) {
        }
        rememberedValue4 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.q$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return q.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e.this, coroutineScope2, mutableState22, mutableState3, rememberUpdatedState5, rememberUpdatedState22, rememberUpdatedState32, rememberUpdatedState42, (DisposableEffectScope) obj);
            }
        };
        fVar2 = fVar;
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(fVar2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, 0);
        Unit unit2 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(-794027148);
        changed3 = startRestartGroup.changed(fVar2);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue5 = new d(fVar2, null);
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-794015629);
        changed4 = startRestartGroup.changed(fVar2) | startRestartGroup.changed(uri) | startRestartGroup.changed(seekToMillis) | startRestartGroup.changed(play);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (changed4) {
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar52 = fVar2;
        i11 = i6;
        e eVar2 = new e(fVar52, uri, seekToMillis, play, null);
        fVar3 = fVar52;
        mVar = play;
        startRestartGroup.updateRememberedValue(eVar2);
        rememberedValue6 = eVar2;
        startRestartGroup.endReplaceableGroup();
        int i122 = i11 >> 3;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar62 = fVar3;
        EffectsKt.LaunchedEffect(fVar62, uri, seekToMillis, (Function2) rememberedValue6, startRestartGroup, ((i11 << 3) & 112) | (i122 & 896));
        startRestartGroup.startReplaceableGroup(-793998962);
        changed5 = startRestartGroup.changed(fVar62) | startRestartGroup.changed(mVar);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changed5) {
        }
        rememberedValue7 = new f(fVar62, mVar, null);
        startRestartGroup.updateRememberedValue(rememberedValue7);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(fVar62, mVar, (Function2) rememberedValue7, startRestartGroup, i122 & 112);
        Boolean valueOf2 = Boolean.valueOf(z2);
        startRestartGroup.startReplaceableGroup(-793993338);
        changed6 = startRestartGroup.changed(fVar62) | startRestartGroup.changed(z2);
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (!changed6) {
        }
        rememberedValue8 = new g(fVar62, z2, null);
        startRestartGroup.updateRememberedValue(rememberedValue8);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(fVar62, valueOf2, (Function2) rememberedValue8, startRestartGroup, (i11 >> 9) & 112);
        N = fVar62.N();
        if (N != null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final Function1<Boolean, Unit> b(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    public static final CoroutineContext a() {
        return f6251a;
    }

    public static final DisposableEffectResult a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e eVar, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, State state, State state2, State state3, State state4, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new h(CollectionsKt.listOf((Object[]) new Job[]{FlowKt.launchIn(FlowKt.onEach(eVar.isPlaying(), new a(mutableState, mutableState2, eVar, state, state2, null)), coroutineScope), FlowKt.launchIn(FlowKt.onEach(eVar.p(), new b(state3, null)), coroutineScope), FlowKt.launchIn(FlowKt.onEach(FlowKt.filterNotNull(eVar.f()), new c(state4, null)), coroutineScope)}), eVar, state);
    }

    public static final FrameLayout a(View view, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FrameLayout frameLayout = new FrameLayout(it);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public static final Function1<Boolean, Unit> a(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }
}
