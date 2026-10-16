package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.ironsource.InterfaceC3063ea;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class T9 extends WebView implements InterfaceC3080fa {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC3063ea f3059a;
    private Ac b;

    public /* synthetic */ T9(Context context, InterfaceC3063ea interfaceC3063ea, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new InterfaceC3063ea.a(0, 1, null) : interfaceC3063ea);
    }

    @Override // com.ironsource.InterfaceC3080fa
    public void a(String script) {
        Intrinsics.checkNotNullParameter(script, "script");
        InterfaceC3063ea interfaceC3063ea = this.f3059a;
        InterfaceC3063ea interfaceC3063ea2 = null;
        if (interfaceC3063ea == null) {
            Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
            interfaceC3063ea = null;
        }
        if (!interfaceC3063ea.a()) {
            InterfaceC3063ea interfaceC3063ea3 = this.f3059a;
            if (interfaceC3063ea3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
                interfaceC3063ea3 = null;
            }
            interfaceC3063ea3.a(this);
        }
        InterfaceC3063ea interfaceC3063ea4 = this.f3059a;
        if (interfaceC3063ea4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("javascriptEngine");
        } else {
            interfaceC3063ea2 = interfaceC3063ea4;
        }
        interfaceC3063ea2.a(script);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent event) {
        Ac ac;
        Intrinsics.checkNotNullParameter(event, "event");
        if (i == 4 && (ac = this.b) != null && ac.onBackButtonPressed()) {
            return true;
        }
        return super.onKeyDown(i, event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public T9(Context context, InterfaceC3063ea javascriptEngine) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(javascriptEngine, "javascriptEngine");
        this.f3059a = javascriptEngine;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T9(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(Ac ac) {
        this.b = ac;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T9(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void a() {
        this.b = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T9(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }
}
