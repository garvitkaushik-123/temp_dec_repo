package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.advanced.middle.c;

/* loaded from: classes6.dex */
public class MBOutNativeAdvancedViewGroup extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private c f4029a;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4030a;

        a(int i) {
            this.f4030a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBOutNativeAdvancedViewGroup.this.f4029a != null) {
                MBOutNativeAdvancedViewGroup.this.f4029a.i(this.f4030a);
            }
        }
    }

    public MBOutNativeAdvancedViewGroup(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4029a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f4029a;
        if (cVar != null) {
            cVar.f(1);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        c cVar = this.f4029a;
        if (cVar != null) {
            cVar.f(2);
        }
    }

    public void setProvider(c cVar) {
        this.f4029a = cVar;
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i) {
        postDelayed(new a(i), 200L);
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
