package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$a, reason: collision with other inner class name */
    public static final class C0563a implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Unit f6323a;

        public C0563a(Unit unit) {
            this.f6323a = unit;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1018657295, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView.<anonymous>.<anonymous> (AdWebView.kt:40)");
            }
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

    public static final class b implements DisposableEffectResult {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f6324a;

        public b(WebView webView) {
            this.f6324a = webView;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public void dispose() {
            ViewParent parent = this.f6324a.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.f6324a);
            }
        }
    }

    public static final Unit a(WebView webView, Modifier modifier, z zVar, int i, int i2, Composer composer, int i3) {
        a(webView, modifier, zVar, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void a(final WebView webView, Modifier modifier, final z zVar, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Composer startRestartGroup = composer.startRestartGroup(-1111633024);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(webView) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(zVar) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1111633024, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView (AdWebView.kt:13)");
            }
            startRestartGroup.startReplaceableGroup(1539490980);
            startRestartGroup.startReplaceableGroup(1539458953);
            boolean changed = startRestartGroup.changed(webView);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.a(webView, (Context) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) rememberedValue, modifier3, null, startRestartGroup, i3 & 112, 4);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1539491745);
            if (zVar != null) {
                zVar.a(ComposableLambdaKt.composableLambda(startRestartGroup, 1018657295, true, new C0563a(unit)), startRestartGroup, ((i3 >> 3) & 112) | 6);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1539498319);
            boolean changed2 = startRestartGroup.changed(webView);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.a(webView, (DisposableEffectScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(webView, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(webView, modifier2, zVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final FrameLayout a(WebView webView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FrameLayout frameLayout = new FrameLayout(it);
        webView.setBackgroundColor(0);
        webView.setVisibility(0);
        frameLayout.addView(webView, new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public static final DisposableEffectResult a(WebView webView, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new b(webView);
    }
}
