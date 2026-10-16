package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/VastActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/a;", "a", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/a;", CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, "Lkotlinx/coroutines/CoroutineScope;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlinx/coroutines/CoroutineScope;", "scope", "c", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class VastActivity extends ComponentActivity {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d = 8;
    public static final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> e = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    public static WeakReference<VastActivity> f = new WeakReference<>(null);
    public static com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a g;
    public static Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> h;
    public static Function0<Unit> i;
    public static Job j;
    public static z k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a ac;

    /* renamed from: b, reason: from kotlin metadata */
    public final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2", f = "VastActivity.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a, reason: collision with other inner class name */
        public static final class C0524a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6048a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a b;
            public final /* synthetic */ y c;
            public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> d;
            public final /* synthetic */ Context e;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1", f = "VastActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a, reason: collision with other inner class name */
            public static final class C0525a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f6049a;
                public /* synthetic */ Object b;
                public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> c;
                public final /* synthetic */ Context d;
                public final /* synthetic */ y e;

                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1", f = "VastActivity.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a, reason: collision with other inner class name */
                public static final class C0526a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f6050a;
                    public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> b;

                    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1$1", f = "VastActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a$a, reason: collision with other inner class name */
                    public static final class C0527a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Unit>, Object> {

                        /* renamed from: a, reason: collision with root package name */
                        public int f6051a;
                        public /* synthetic */ Object b;
                        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public C0527a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1, Continuation<? super C0527a> continuation) {
                            super(2, continuation);
                            this.c = function1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Unit> continuation) {
                            return ((C0527a) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C0527a c0527a = new C0527a(this.c, continuation);
                            c0527a.b = obj;
                            return c0527a;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.f6051a != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.c.invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b);
                            return Unit.INSTANCE;
                        }
                    }

                    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$1$2", f = "VastActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$a$b */
                    public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Boolean>, Object> {

                        /* renamed from: a, reason: collision with root package name */
                        public int f6052a;
                        public /* synthetic */ Object b;

                        public b(Continuation<? super b> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Boolean> continuation) {
                            return ((b) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            b bVar = new b(continuation);
                            bVar.b = obj;
                            return bVar;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.f6052a != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Boxing.boxBoolean(VastActivity.INSTANCE.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b));
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0526a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1, Continuation<? super C0526a> continuation) {
                        super(2, continuation);
                        this.b = function1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0526a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0526a(this.b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f6050a;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Flow onEach = FlowKt.onEach(VastActivity.e, new C0527a(this.b, null));
                            b bVar = new b(null);
                            this.f6050a = 1;
                            if (FlowKt.firstOrNull(onEach, bVar, this) == coroutine_suspended) {
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

                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$Companion$showAd$2$1$2", f = "VastActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$a$a$a$b */
                public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f6053a;
                    public final /* synthetic */ Context b;
                    public final /* synthetic */ y c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(Context context, y yVar, Continuation<? super b> continuation) {
                        super(2, continuation);
                        this.b = context;
                        this.c = yVar;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new b(this.b, this.c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.f6053a != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        Context context = this.b;
                        Intent intent = new Intent(this.b, (Class<?>) VastActivity.class);
                        y yVar = this.c;
                        r.c(intent, yVar.g());
                        r.a(intent, yVar.c());
                        r.b(intent, yVar.d());
                        r.a(intent, yVar.e());
                        r.c(intent, yVar.f());
                        r.b(intent, yVar.b());
                        r.a(intent, yVar.a());
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0525a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1, Context context, y yVar, Continuation<? super C0525a> continuation) {
                    super(2, continuation);
                    this.c = function1;
                    this.d = context;
                    this.e = yVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
                    return ((C0525a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0525a c0525a = new C0525a(this.c, this.d, this.e, continuation);
                    c0525a.b = obj;
                    return c0525a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Job launch$default;
                    Job launch$default2;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f6049a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.b;
                    Companion companion = VastActivity.INSTANCE;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0526a(this.c, null), 3, null);
                    VastActivity.j = launch$default;
                    launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new b(this.d, this.e, null), 3, null);
                    return launch$default2;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0524a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, y yVar, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1, Context context, Continuation<? super C0524a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = yVar;
                this.d = function1;
                this.e = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
                return ((C0524a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0524a(this.b, this.c, this.d, this.e, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6048a;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Companion companion = VastActivity.INSTANCE;
                        VastActivity.g = this.b;
                        VastActivity.h = this.c.h();
                        C0525a c0525a = new C0525a(this.d, this.e, this.c, null);
                        this.f6048a = 1;
                        obj = CoroutineScopeKt.coroutineScope(c0525a, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (Job) obj;
                } finally {
                    Companion companion2 = VastActivity.INSTANCE;
                    VastActivity b = companion2.b();
                    if (b != null) {
                        b.finish();
                    }
                    VastActivity.i = null;
                    VastActivity.g = null;
                    VastActivity.h = null;
                    companion2.a();
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final VastActivity b() {
            return (VastActivity) VastActivity.f.get();
        }

        public final void a(VastActivity vastActivity) {
            VastActivity.f = new WeakReference(vastActivity);
            if (vastActivity == null) {
                a();
            }
        }

        public final Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, Context context, y yVar, Function0<Unit> function0, z zVar, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1, Continuation<? super Unit> continuation) {
            VastActivity.k = zVar;
            VastActivity.i = function0;
            Object withContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getMain(), new C0524a(aVar, yVar, function1, context, null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }

        public final void a() {
            Job job = VastActivity.j;
            if (job == null || !job.isActive()) {
                return;
            }
            Job job2 = VastActivity.j;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            VastActivity.j = null;
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return (bVar instanceof b.f) || Intrinsics.areEqual(bVar, b.e.b);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity$onCreate$1", f = "VastActivity.kt", i = {0}, l = {97}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6054a;
        public /* synthetic */ Object b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Unit> continuation) {
            return ((b) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = VastActivity.this.new b(continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6054a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
                MutableSharedFlow mutableSharedFlow = VastActivity.e;
                this.b = bVar2;
                this.f6054a = 1;
                if (mutableSharedFlow.emit(bVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar = bVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
                ResultKt.throwOnFailure(obj);
            }
            if (VastActivity.INSTANCE.a(bVar)) {
                VastActivity.this.finish();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function2<Composer, Integer, Unit> {
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a b;
        public final /* synthetic */ Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> function2) {
            this.b = aVar;
            this.c = function2;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1009520481, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity.onCreate.<anonymous> (VastActivity.kt:104)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.c.a(VastActivity.this, this.b, this.c, VastActivity.k, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.moloco.sdk.internal.android_context.b.a(getApplicationContext());
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = g;
        if (aVar == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastActivity", "ad is missing", null, false, 12, null);
            finish();
            return;
        }
        Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> function2 = h;
        if (function2 == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastActivity", "VastRenderer is missing", null, false, 12, null);
            finish();
            return;
        }
        InterfaceC3463m f2 = a.h.f5756a.f();
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b2 = a.k.f5759a.b();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        boolean g2 = r.g(intent);
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
        Boolean e2 = r.e(intent2);
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "getIntent(...)");
        int f3 = r.f(intent3);
        Intent intent4 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent4, "getIntent(...)");
        int c2 = r.c(intent4);
        Intent intent5 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent5, "getIntent(...)");
        int d2 = r.d(intent5);
        Intent intent6 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent6, "getIntent(...)");
        boolean b3 = r.b(intent6);
        Intent intent7 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent7, "getIntent(...)");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a(aVar, f2, this, b2, g2, e2, f3, c2, d2, b3, r.a(intent7));
        this.ac = a2;
        INSTANCE.a(this);
        FlowKt.launchIn(FlowKt.onEach(a2.a(), new b(null)), this.scope);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1009520481, true, new c(a2, function2)), 1, null);
        a2.d();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Function0<Unit> function0 = i;
        if (function0 != null) {
            function0.invoke();
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.ac;
        if (aVar != null) {
            aVar.destroy();
        }
        this.ac = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        INSTANCE.a((VastActivity) null);
    }
}
