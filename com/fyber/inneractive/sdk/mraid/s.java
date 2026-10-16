package com.fyber.inneractive.sdk.mraid;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class s extends f {
    public s(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.mraid.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        ViewGroup viewGroup;
        com.fyber.inneractive.sdk.web.m mVar;
        j1 j1Var;
        int a2 = a("w");
        int a3 = a("h");
        int a4 = a("offsetX");
        int a5 = a("offsetY");
        boolean equals = "true".equals(this.b.get("allowOffscreen"));
        if (a2 <= 0) {
            a2 = this.c.Z;
        }
        if (a3 <= 0) {
            a3 = this.c.a0;
        }
        i0 i0Var = this.c;
        com.fyber.inneractive.sdk.web.m mVar2 = i0Var.b;
        if (mVar2 == null) {
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) mVar2.getRootView().findViewById(R.id.content);
            i0Var.R = viewGroup2;
            if (viewGroup2 == null) {
                IAlog.f("Couldn't find content in the view tree", new Object[0]);
                i0Var.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (i0Var.O == com.fyber.inneractive.sdk.web.z.DISABLED) {
                return;
            }
            f0 f0Var = i0Var.N;
            if (f0Var != f0.DEFAULT && f0Var != f0.RESIZED) {
                i0Var.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (a2 < 0 && a3 < 0) {
                i0Var.a(k.RESIZE, "Creative size passed to resize() was invalid.");
                return;
            }
            i0Var.X = false;
            j1 j1Var2 = i0Var.g;
            if (j1Var2 != null) {
                ((com.fyber.inneractive.sdk.web.b0) j1Var2).b(false);
            }
            com.fyber.inneractive.sdk.web.d0 d0Var = i0Var.P;
            if (d0Var == com.fyber.inneractive.sdk.web.d0.ALWAYS_VISIBLE || (!i0Var.X && d0Var != com.fyber.inneractive.sdk.web.d0.ALWAYS_HIDDEN)) {
                i0Var.c(true);
            }
            i0Var.d(false);
            i0Var.e0 = com.fyber.inneractive.sdk.util.o.b(a3);
            i0Var.d0 = com.fyber.inneractive.sdk.util.o.b(a2);
            if (!equals) {
                int i = (a4 + a2) - i0Var.Z;
                if (i > 0) {
                    a4 -= i;
                }
                if (a4 < 0) {
                    a4 = 0;
                }
                int i2 = (a5 + a3) - i0Var.a0;
                if (i2 > 0) {
                    a5 -= i2;
                }
                if (a5 < 0) {
                    a5 = 0;
                }
            }
            int b = com.fyber.inneractive.sdk.util.o.b(a2);
            int b2 = com.fyber.inneractive.sdk.util.o.b(a3);
            com.fyber.inneractive.sdk.web.m mVar3 = i0Var.b;
            ViewGroup.LayoutParams layoutParams = mVar3.getLayoutParams();
            layoutParams.width = b;
            layoutParams.height = b2;
            mVar3.setLayoutParams(layoutParams);
            com.fyber.inneractive.sdk.util.o.a(i0Var.b, 17);
            com.fyber.inneractive.sdk.web.m mVar4 = i0Var.b;
            ViewGroup.LayoutParams layoutParams2 = mVar4.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = a4;
                marginLayoutParams.topMargin = a5;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                mVar4.setLayoutParams(marginLayoutParams);
            }
            f0 f0Var2 = i0Var.N;
            f0 f0Var3 = f0.RESIZED;
            if (f0Var2 != f0Var3) {
                i0Var.N = f0Var3;
                i0Var.a(new d0(f0Var3));
                int i3 = i0Var.d0;
                if (i3 != -1 && i0Var.e0 != -1) {
                    i0Var.a(new x(com.fyber.inneractive.sdk.util.o.c(i3), com.fyber.inneractive.sdk.util.o.c(i0Var.e0)));
                }
            }
            i0Var.a(k.RESIZE);
            ViewGroup viewGroup3 = (ViewGroup) i0Var.b.getParent();
            if (viewGroup3 != null) {
                View findViewById = viewGroup3.findViewById(com.fyber.inneractive.sdk.R.id.ia_identifier_overlay);
                if (findViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) findViewById;
                    mVar = i0Var.b;
                    if (mVar != null && viewGroup != null) {
                        viewGroup.setLayoutParams(mVar.getLayoutParams());
                    }
                    j1Var = i0Var.g;
                    if (j1Var == null) {
                        ((com.fyber.inneractive.sdk.web.b0) j1Var).b();
                        return;
                    }
                    return;
                }
            }
            viewGroup = null;
            mVar = i0Var.b;
            if (mVar != null) {
                viewGroup.setLayoutParams(mVar.getLayoutParams());
            }
            j1Var = i0Var.g;
            if (j1Var == null) {
            }
        } catch (Exception unused) {
            IAlog.f("Couldn't find content in the view tree", new Object[0]);
            i0Var.a(k.RESIZE, "Ad can be resized only if it's state is default or resized.");
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final boolean b() {
        return true;
    }
}
