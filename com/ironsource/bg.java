package com.ironsource;

import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class bg extends Oc {
    public static final a f = new a(null);
    private static final String g = "ViewVisibilityTrigger";
    private final b d;
    private final dg e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements InterfaceC3420zc {
        b() {
        }

        @Override // com.ironsource.InterfaceC3420zc
        public void a(boolean z) {
            bg.this.a(!z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(View view) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(view, "view");
        b bVar = new b();
        this.d = bVar;
        dg dgVar = new dg(bVar);
        this.e = dgVar;
        dgVar.a(view);
        a(!dgVar.c());
    }

    @Override // com.ironsource.Oc
    public String b() {
        return g;
    }

    public final void e() {
        this.e.b();
    }
}
