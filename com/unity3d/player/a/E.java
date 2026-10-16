package com.unity3d.player.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/* loaded from: classes7.dex */
public final class E extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Button f6512a;
    public final EditText b;
    public final Context c;
    public final Rect d;
    public final Rect e;

    public E(Context context, EditText editText) {
        super(context);
        this.b = editText;
        this.c = context;
        this.d = new Rect(16, 16, 16, 16);
        this.e = new Rect(0, 0, 0, 0);
        createUI();
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6512a.setOnClickListener(onClickListener);
    }

    public void createUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button = new Button(this.c);
        this.f6512a = button;
        button.setId(View.generateViewId());
        this.f6512a.setText(this.c.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f6512a.setLayoutParams(layoutParams);
        this.f6512a.setBackgroundColor(0);
        addView(this.f6512a);
        this.b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f6512a.getId());
        this.b.setLayoutParams(layoutParams2);
        addView(this.b);
        Rect rect = this.d;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
