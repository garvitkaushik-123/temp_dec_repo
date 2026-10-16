package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3451a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J'\u0010\u000f\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0012J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0014*\u00020\u0013H\u0002¢\u0006\u0004\b\u000f\u0010\u0015J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u000f\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/renderer/fullscreen/FullscreenWebviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/orientation/b;", "expectedOrientationSettings", "Lkotlinx/coroutines/CoroutineScope;", "scope", "a", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/CoroutineScope;)V", "orientationSettings", "(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/orientation/b;)V", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/orientation/a;", "", "(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/orientation/a;)Ljava/lang/Integer;", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/a;", "webviewAd", "(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/a;)V", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "backCallback", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class FullscreenWebviewActivity extends AppCompatActivity {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int c = 8;
    public static final String d = "FullscreenWebviewActivity";
    public static WeakReference<a> e = new WeakReference<>(null);
    public static WeakReference<FullscreenWebviewActivity> f = new WeakReference<>(null);
    public static MutableStateFlow<Boolean> g;
    public static MutableStateFlow<Boolean> h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public OnBackPressedCallback backCallback;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.fullscreen.FullscreenWebviewActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, MutableStateFlow<Boolean> isAdDisplayingEvent, a webviewAd, MutableStateFlow<Boolean> isAdForciblyClosed) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(isAdDisplayingEvent, "isAdDisplayingEvent");
            Intrinsics.checkNotNullParameter(webviewAd, "webviewAd");
            Intrinsics.checkNotNullParameter(isAdForciblyClosed, "isAdForciblyClosed");
            Companion companion = FullscreenWebviewActivity.INSTANCE;
            FullscreenWebviewActivity.e = new WeakReference(webviewAd);
            FullscreenWebviewActivity.g = isAdDisplayingEvent;
            FullscreenWebviewActivity.h = isAdForciblyClosed;
            Intent intent = new Intent(context, (Class<?>) FullscreenWebviewActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }

        public Companion() {
        }

        public final void a() {
            FullscreenWebviewActivity.e.clear();
            MutableStateFlow mutableStateFlow = FullscreenWebviewActivity.g;
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(Boolean.FALSE);
            }
            FullscreenWebviewActivity.g = null;
            FullscreenWebviewActivity fullscreenWebviewActivity = (FullscreenWebviewActivity) FullscreenWebviewActivity.f.get();
            if (fullscreenWebviewActivity != null && !fullscreenWebviewActivity.isFinishing() && !fullscreenWebviewActivity.isDestroyed()) {
                fullscreenWebviewActivity.finish();
            }
            FullscreenWebviewActivity.f.clear();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5992a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5992a = iArr;
        }
    }

    public /* synthetic */ class c extends AdaptedFunctionReference implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b, Continuation<? super Unit>, Object>, SuspendFunction {
        public c(Object obj) {
            super(2, obj, FullscreenWebviewActivity.class, "setOrientation", "setOrientation(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/templates/ad/orientation/OrientationSettings;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b bVar, Continuation<? super Unit> continuation) {
            return FullscreenWebviewActivity.b((FullscreenWebviewActivity) this.receiver, bVar, continuation);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        this.backCallback = OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.fullscreen.FullscreenWebviewActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FullscreenWebviewActivity.a((OnBackPressedCallback) obj);
            }
        }, 2, null);
        f = new WeakReference<>(this);
        a aVar = e.get();
        if (aVar == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, d, "WebviewAd is null, something went wrong", null, false, 12, null);
            finish();
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b q = aVar.q();
        if (q.getParent() != null) {
            ViewParent parent = q.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(q);
        }
        setContentView(q);
        MutableStateFlow<Boolean> mutableStateFlow = g;
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(Boolean.TRUE);
        }
        a(aVar);
        C3451a.a(this);
        a(this, aVar.y(), null, 2, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MutableStateFlow<Boolean> mutableStateFlow = h;
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(Boolean.TRUE);
        }
        h = null;
        OnBackPressedCallback onBackPressedCallback = this.backCallback;
        if (onBackPressedCallback != null && onBackPressedCallback.getIsEnabled()) {
            onBackPressedCallback.remove();
        }
        INSTANCE.a();
    }

    public static final /* synthetic */ Object b(FullscreenWebviewActivity fullscreenWebviewActivity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b bVar, Continuation continuation) {
        fullscreenWebviewActivity.a(bVar);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void a(FullscreenWebviewActivity fullscreenWebviewActivity, StateFlow stateFlow, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        }
        fullscreenWebviewActivity.a(stateFlow, coroutineScope);
    }

    public final void a(StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> expectedOrientationSettings, CoroutineScope scope) {
        a(expectedOrientationSettings.getValue());
        FlowKt.launchIn(FlowKt.onEach(expectedOrientationSettings, new c(this)), scope);
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b orientationSettings) {
        if (orientationSettings.d() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d) {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, d, "Orientation is none, not setting requested orientation", false, 4, null);
            return;
        }
        Integer a2 = a(orientationSettings.d());
        if (a2 != null) {
            setRequestedOrientation(a2.intValue());
        }
    }

    public final Integer a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a aVar) {
        int i = b.f5992a[aVar.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Unit a(OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, d, "Back press detected, but disabled", false, 4, null);
        return Unit.INSTANCE;
    }

    public final void a(final a webviewAd) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b q = webviewAd.q();
        webviewAd.t().a();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(q);
        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        if (lifecycle != null) {
            lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.fullscreen.FullscreenWebviewActivity$subscribeWebviewBridgeToLifecycleEvents$1$1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onPause(LifecycleOwner owner) {
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    super.onPause(owner);
                    FullscreenWebviewActivity fullscreenWebviewActivity = FullscreenWebviewActivity.this;
                    a aVar = webviewAd;
                    if (fullscreenWebviewActivity.isFinishing() || fullscreenWebviewActivity.isDestroyed()) {
                        return;
                    }
                    aVar.t().a(false);
                }

                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onResume(LifecycleOwner owner) {
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    super.onResume(owner);
                    webviewAd.t().a(true);
                }
            });
        }
    }
}
