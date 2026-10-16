package com.fyber.inneractive.sdk.flow.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.g1;

/* loaded from: classes4.dex */
public final class f extends a {
    public final ViewGroup c;
    public final Button d;
    public final TextView e;

    public f(b bVar) {
        super(bVar);
        View inflate = LayoutInflater.from(IAConfigManager.O.v.a()).inflate(R.layout.ia_layout_default_video_end_card, (ViewGroup) null);
        this.d = (Button) inflate.findViewById(R.id.ia_b_end_card_call_to_action);
        this.e = (TextView) inflate.findViewById(R.id.ia_endcard_tv_app_info_button);
        this.c = a.a(inflate);
    }

    public final void a(com.fyber.inneractive.sdk.player.ui.b bVar, com.fyber.inneractive.sdk.player.ui.n nVar) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        Context context = this.d.getContext();
        this.d.setAllCaps(bVar.b);
        this.d.setVisibility(0);
        if (IAConfigManager.O.E.n() && (mVar = bVar.i) != null && mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP) {
            this.d.setText(R.string.ia_video_instant_install_text);
            if (bVar.g) {
                String str = bVar.h;
                if (str != null && str.length() == 1) {
                    TextView textView = this.e;
                    int dimensionPixelSize = textView.getContext().getResources().getDimensionPixelSize(R.dimen.ia_image_control_size);
                    textView.setBackgroundResource(R.drawable.ia_bg_circle_overlay);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    textView.setLayoutParams(layoutParams);
                }
                this.e.setText(str);
                this.e.setVisibility(0);
            }
        } else {
            this.e.setVisibility(8);
            Button button = this.d;
            Context context2 = this.c.getContext();
            String str2 = bVar.c;
            button.setText(!TextUtils.isEmpty(str2) ? g1.a(str2, 15) : context2.getString(R.string.ia_video_install_now_text));
        }
        this.d.setBackgroundResource(R.drawable.ia_bg_green);
        this.d.setTextSize(0, context.getResources().getDimension(R.dimen.ia_video_overlay_text_large_plus));
        TextView textView2 = this.e;
        if (nVar != null) {
            textView2.setOnTouchListener(new e(10, nVar));
        } else {
            textView2.setOnTouchListener(null);
        }
        Button button2 = this.d;
        if (nVar != null) {
            button2.setOnTouchListener(new e(8, nVar));
        } else {
            button2.setOnTouchListener(null);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final View b() {
        return this.c;
    }
}
