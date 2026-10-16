package com.moloco.sdk.internal.publisher.nativead.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5569a = new a(null);
    public static final int b = 0;
    public static final int c = 16;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ c(Context context, Uri uri, z zVar, Function0 function0, InterfaceC3463m interfaceC3463m, h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, zVar, function0, (i & 16) != 0 ? a.h.f5756a.f() : interfaceC3463m, (i & 32) != 0 ? j.a() : hVar);
    }

    public static final void a(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final Unit a(h hVar, a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        hVar.a(button);
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, Uri imageUri, z watermark, final Function0<Unit> function0, InterfaceC3463m externalLinkHandler, final h buttonTracker) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        ImageView imageView = new ImageView(context);
        imageView.setImageURI(imageUri);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.internal.publisher.nativead.ui.c$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.a(Function0.this, view);
            }
        });
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b(externalLinkHandler, context, null, 0, 12, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        bVar.setPadding(16, 0, 0, 16);
        bVar.setOnButtonRenderedListener(new Function1() { // from class: com.moloco.sdk.internal.publisher.nativead.ui.c$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return c.a(h.this, (a.AbstractC0571a.c) obj);
            }
        });
        bVar.setLayoutParams(layoutParams);
        watermark.a(imageView);
        addView(imageView);
        addView(bVar);
    }
}
