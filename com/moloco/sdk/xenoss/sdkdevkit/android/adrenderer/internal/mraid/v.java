package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3454d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3455e;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class v extends C3454d {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "MraidWebView";
    public final w c;
    public final StateFlow<Boolean> d;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2", f = "MraidWebView.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5915a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ v c;
        public final /* synthetic */ String d;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1", f = "MraidWebView.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5916a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ v c;
            public final /* synthetic */ String d;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1$1", f = "MraidWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.v$b$a$a, reason: collision with other inner class name */
            public static final class C0486a extends SuspendLambda implements Function3<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Continuation<? super Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5917a;
                public /* synthetic */ boolean b;
                public /* synthetic */ Object c;

                public C0486a(Continuation<? super C0486a> continuation) {
                    super(3, continuation);
                }

                public final Object a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, Continuation<? super Pair<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                    C0486a c0486a = new C0486a(continuation);
                    c0486a.b = z;
                    c0486a.c = dVar;
                    return c0486a.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, Continuation<? super Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                    return a(bool.booleanValue(), dVar, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5917a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    boolean z = this.b;
                    return TuplesKt.to(Boxing.boxBoolean(z), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) this.c);
                }
            }

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidWebView$loadHtml$2$1$2", f = "MraidWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.v$b$a$b, reason: collision with other inner class name */
            public static final class C0487b extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>, Continuation<? super Boolean>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5918a;
                public /* synthetic */ Object b;

                public C0487b(Continuation<? super C0487b> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Pair<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> pair, Continuation<? super Boolean> continuation) {
                    return ((C0487b) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0487b c0487b = new C0487b(continuation);
                    c0487b.b = obj;
                    return c0487b;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5918a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) this.b;
                    return Boxing.boxBoolean(((Boolean) pair.component1()).booleanValue() || ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) pair.component2()) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z, v vVar, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = z;
                this.c = vVar;
                this.d = str;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5916a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        if (this.b) {
                            Context context = this.c.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            C3455e.a(this.c, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.i(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.c(context), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.e(), null, 4, null).a(this.d));
                        } else {
                            C3455e.a(this.c, this.d);
                        }
                        Flow flowCombine = FlowKt.flowCombine(this.c.c.b(), this.c.c.a(), new C0486a(null));
                        C0487b c0487b = new C0487b(null);
                        this.f5916a = 1;
                        obj = FlowKt.first(flowCombine, c0487b, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, v.h, e.toString(), null, false, 12, null);
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.c);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) pair.component2();
                return dVar != null ? new v.a(dVar) : booleanValue ? new v.b(new c(null, 1, null)) : new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.d);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, v vVar, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = z;
            this.c = vVar;
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5915a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineContext main = com.moloco.sdk.internal.scheduling.b.a().getMain();
            a aVar = new a(this.b, this.c, this.d, null);
            this.f5915a = 1;
            Object withContext = BuildersKt.withContext(main, aVar, this);
            return withContext == coroutine_suspended ? coroutine_suspended : withContext;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context context, o mraidJsCommandUrlSource) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidJsCommandUrlSource, "mraidJsCommandUrlSource");
        WebView.setWebContentsDebuggingEnabled(false);
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setScrollContainer(false);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
        setVisibility(8);
        w wVar = new w(context, mraidJsCommandUrlSource);
        setWebViewClient(wVar);
        this.c = wVar;
        this.d = wVar.b();
        this.e = wVar.a();
    }

    public final StateFlow<Boolean> c() {
        return this.d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3454d, android.webkit.WebView
    public void destroy() {
        super.destroy();
        setWebViewClient(new WebViewClientCompat());
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> getUnrecoverableError() {
        return this.e;
    }

    public final Object a(String str, boolean z, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
        return CoroutineScopeKt.coroutineScope(new b(z, this, str, null), continuation);
    }
}
