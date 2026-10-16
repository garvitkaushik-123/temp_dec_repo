package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.webkit.WebView;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m extends e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g {
    public static final int q = 8;
    public final Function0<Unit> n;
    public final Function0<Unit> o;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidInline", f = "MraidInline.kt", i = {0}, l = {41}, m = "load", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5904a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return m.this.c(this);
        }
    }

    public /* synthetic */ m(Context context, String str, Function0 function0, Function0 function02, Function0 function03, Function1 function1, boolean z, InterfaceC3463m interfaceC3463m, f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, function0, function02, function03, function1, z, interfaceC3463m, fVar, (i & 512) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a() : hVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void U() {
        super.U();
        this.n.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.p.a(button);
    }

    public final WebView c() {
        return J().c();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void t() {
        super.t();
        this.o.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.p.a(buttonType);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation<? super WebView> continuation) {
        a aVar;
        Object obj;
        int i;
        m mVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.d = i2 - Integer.MIN_VALUE;
                obj = aVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    aVar.f5904a = this;
                    aVar.d = 1;
                    obj = b(aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mVar = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mVar = (m) aVar.f5904a;
                    ResultKt.throwOnFailure(obj);
                }
                if (obj instanceof v.b) {
                    return null;
                }
                return mVar.J().c();
            }
        }
        aVar = new a(continuation);
        obj = aVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.d;
        if (i != 0) {
        }
        if (obj instanceof v.b) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, String adm, Function0<Unit> onNeedToDetachAdViewBeforeExpand, Function0<Unit> onExpandAdViewClosed, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> onError, boolean z, InterfaceC3463m externalLinkHandler, f mraidBridge, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, adm, r.b, onClick, onError, externalLinkHandler, z, mraidBridge);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(onNeedToDetachAdViewBeforeExpand, "onNeedToDetachAdViewBeforeExpand");
        Intrinsics.checkNotNullParameter(onExpandAdViewClosed, "onExpandAdViewClosed");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.n = onNeedToDetachAdViewBeforeExpand;
        this.o = onExpandAdViewClosed;
        this.p = buttonTracker;
    }
}
