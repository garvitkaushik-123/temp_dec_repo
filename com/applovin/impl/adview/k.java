package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.applovin.impl.b2;

/* loaded from: classes2.dex */
public class k extends View {

    /* renamed from: a, reason: collision with root package name */
    private final b2 f390a;
    private boolean b;

    interface a {
        void a();

        void onFailure();
    }

    public k(b2 b2Var, Context context) {
        super(context);
        this.f390a = b2Var;
        setClickable(false);
        setFocusable(false);
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        a(null);
    }

    public String getIdentifier() {
        return this.f390a.b();
    }

    public void a(a aVar) {
        if (this.b) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        Drawable a2 = this.f390a.a();
        if (a2 == null) {
            if (aVar != null) {
                aVar.onFailure();
            }
        } else {
            setBackground(a2);
            this.b = true;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
