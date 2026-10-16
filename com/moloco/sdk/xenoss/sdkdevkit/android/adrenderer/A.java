package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class A implements z {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public String f5760a;

    public static final class a implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<Composer, Integer, Unit> f5761a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.f5761a = function2;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586795374, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.WatermarkImpl.ApplyWatermark.<anonymous> (Watermark.kt:47)");
            }
            this.f5761a.invoke(composer, 0);
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

    /* JADX WARN: Multi-variable type inference failed */
    public A() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final Unit a(A a2, Function2 function2, int i, Composer composer, int i2) {
        a2.a(function2, composer, i | 1);
        return Unit.INSTANCE;
    }

    public A(String str) {
        this.f5760a = str;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z
    public void a(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(412679763);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412679763, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.WatermarkImpl.ApplyWatermark (Watermark.kt:45)");
            }
            B.a(this.f5760a, ComposableLambdaKt.composableLambda(startRestartGroup, 586795374, true, new a(content)), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return A.a(A.this, content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public /* synthetic */ A(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z
    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bitmap a2 = B.a(this.f5760a);
        if (a2 == null) {
            return;
        }
        com.moloco.sdk.service_locator.a aVar = com.moloco.sdk.service_locator.a.f5748a;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.a().getResources(), a2);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setTargetDensity(aVar.a().getResources().getDisplayMetrics());
        view.setForeground(bitmapDrawable);
        view.setClickable(false);
        view.setFocusable(false);
    }
}
