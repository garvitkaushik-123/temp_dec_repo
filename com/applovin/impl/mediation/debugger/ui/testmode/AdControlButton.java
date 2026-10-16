package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.m0;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final GradientDrawable f580a;
    private final Button b;
    private final com.applovin.impl.a c;
    private b d;
    private MaxAdFormat e;
    private a f;

    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    private int a(b bVar) {
        return b.LOAD == bVar ? m0.a(R.color.applovin_sdk_brand_color, getContext()) : b.LOADING == bVar ? m0.a(R.color.applovin_sdk_brand_color, getContext()) : m0.a(R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    private String b(b bVar) {
        return b.LOAD == bVar ? "Load" : b.LOADING == bVar ? "" : "Show";
    }

    private void c(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.c.a();
        } else {
            setEnabled(true);
            this.c.b();
        }
        this.b.setText(b(bVar));
        this.f580a.setColor(a(bVar));
    }

    public b getControlState() {
        return this.d;
    }

    public MaxAdFormat getFormat() {
        return this.e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.d != bVar) {
            c(bVar);
        }
        this.d = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.e = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.f = aVar;
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f580a = gradientDrawable;
        Button button = new Button(getContext());
        this.b = button;
        com.applovin.impl.a aVar = new com.applovin.impl.a(getContext(), 20, android.R.attr.progressBarStyleSmall);
        this.c = aVar;
        b bVar = b.LOAD;
        this.d = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        gradientDrawable.setCornerRadius(20.0f);
        button.setBackground(gradientDrawable);
        a();
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        c(bVar);
    }

    private void a() {
        this.b.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{m0.a(R.color.applovin_sdk_highlightTextColor, getContext()), -1}));
    }
}
