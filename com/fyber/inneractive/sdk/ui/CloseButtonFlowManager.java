package com.fyber.inneractive.sdk.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.util.o;

/* loaded from: classes4.dex */
public class CloseButtonFlowManager implements com.fyber.inneractive.sdk.flow.storepromo.observer.a, CloseButtonConfigurationChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f1735a;
    public final TextView b;
    public final View c;
    public final ImageView d;
    public final FrameLayout e;
    public boolean f = false;
    public final CloseButtonConfiguration g = new CloseButtonConfiguration(this);

    public CloseButtonFlowManager(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        View findViewById = inneractiveFullscreenAdActivity.findViewById(R.id.ia_fl_close_button);
        this.f1735a = findViewById;
        this.b = (TextView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_tv_close_button);
        View findViewById2 = inneractiveFullscreenAdActivity.findViewById(R.id.ia_clickable_close_button);
        this.c = findViewById2;
        this.d = (ImageView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_iv_close_button);
        this.e = (FrameLayout) inneractiveFullscreenAdActivity.findViewById(R.id.close_button_container);
        findViewById.setVisibility(8);
        findViewById2.setOnClickListener(new a(inneractiveFullscreenAdActivity));
    }

    @Override // com.fyber.inneractive.sdk.ui.CloseButtonConfigurationChangeListener
    public final void a(CloseButtonConfiguration closeButtonConfiguration) {
        int i;
        int i2;
        if (closeButtonConfiguration.f) {
            this.f1735a.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            return;
        }
        CloseButtonConfiguration closeButtonConfiguration2 = this.g;
        if (closeButtonConfiguration2.b) {
            if (!closeButtonConfiguration2.c || this.f) {
                this.f1735a.setAlpha(1.0f);
                this.d.setAlpha(1.0f);
            } else {
                this.f1735a.setAlpha(0.0f);
                this.d.setAlpha(0.0f);
            }
            this.b.setText("");
            this.b.setVisibility(8);
            int i3 = closeButtonConfiguration2.d;
            if (i3 >= 5) {
                int a2 = o.a(i3);
                this.d.getLayoutParams().width = a2;
                this.d.getLayoutParams().height = a2;
            }
            int i4 = closeButtonConfiguration2.e;
            if (i4 >= 5) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f1735a.getLayoutParams();
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
                int a3 = o.a(i4);
                int i5 = layoutParams.width;
                int i6 = a3 - i5;
                if (a3 <= i5 || i6 <= (i2 = layoutParams2.rightMargin)) {
                    layoutParams3.width = a3;
                    layoutParams3.height = a3;
                    i = layoutParams2.rightMargin;
                    if (i6 < i) {
                        i -= i6 / 2;
                    }
                } else {
                    int i7 = (i5 / 2) + (a3 / 2) + i2;
                    layoutParams3.width = i7;
                    layoutParams3.height = i7;
                    layoutParams2.gravity = 53;
                    i = 0;
                }
                layoutParams3.setMargins(i, i, i, i);
                layoutParams3.gravity = 17;
            }
        }
        this.f1735a.setVisibility((closeButtonConfiguration.f1734a || closeButtonConfiguration.b) ? 0 : 8);
        this.b.setVisibility(closeButtonConfiguration.f1734a ? 0 : 8);
        int i8 = closeButtonConfiguration.b ? 0 : 8;
        this.d.setVisibility(i8);
        this.c.setVisibility(i8);
        this.c.setEnabled(closeButtonConfiguration.b);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.observer.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar) {
        CloseButtonConfiguration closeButtonConfiguration = this.g;
        closeButtonConfiguration.f = bVar.f1235a;
        closeButtonConfiguration.g.a(closeButtonConfiguration);
    }
}
