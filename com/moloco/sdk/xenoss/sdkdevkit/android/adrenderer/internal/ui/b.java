package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends FrameLayout {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC3463m f6001a;
    public final int b;
    public final ImageButton c;
    public Function1<? super a.AbstractC0571a.c, Unit> d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC3463m externalLinkHandler, Context context) {
        this(externalLinkHandler, context, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(b bVar, View view) {
        bVar.f6001a.a(a.f5995a);
    }

    public final ImageButton getAdButton() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            float f = getResources().getDisplayMetrics().density;
            this.c.getLocationOnScreen(new int[2]);
            a.AbstractC0571a.c cVar = new a.AbstractC0571a.c(a.AbstractC0571a.c.EnumC0573a.i, new a.AbstractC0571a.f(r6[0] / f, r6[1] / f), new a.AbstractC0571a.g(this.c.getWidth() / f, this.c.getHeight() / f));
            Function1<? super a.AbstractC0571a.c, Unit> function1 = this.d;
            if (function1 != null) {
                function1.invoke(cVar);
            }
        }
    }

    public final void setOnButtonRenderedListener(Function1<? super a.AbstractC0571a.c, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
    }

    public final void setPrivacyUrl(final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.a(b.this, url, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC3463m externalLinkHandler, Context context, AttributeSet attributeSet) {
        this(externalLinkHandler, context, attributeSet, 0, 8, null);
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(b bVar, String str, View view) {
        bVar.f6001a.a(str);
    }

    public /* synthetic */ b(InterfaceC3463m interfaceC3463m, Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC3463m, context, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC3463m externalLinkHandler, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6001a = externalLinkHandler;
        this.b = 12;
        ImageButton imageButton = new ImageButton(context);
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(c.a(12, context), c.a(12, context)));
        imageButton.setImageResource(R.drawable.info_badge);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setClipToOutline(true);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.a(b.this, view);
            }
        });
        this.c = imageButton;
        addView(imageButton);
        imageButton.setContentDescription("Ad Badge");
        imageButton.setTag("Ad Badge");
    }
}
