package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.h0;

/* loaded from: classes6.dex */
public class BaseView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected RelativeLayout f4609a;
    protected RelativeLayout b;
    protected RelativeLayout c;
    protected ImageView d;
    protected TextView e;
    protected ProgressBar f;
    protected FrameLayout g;
    protected LinearLayout h;
    protected RelativeLayout i;
    public a style;

    public enum a {
        FULL_TOP_VIEW,
        FULL_MIDDLE_VIEW
    }

    public BaseView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(h0.a(getContext(), "mbridge_nativex_fullbasescreen", "layout"), this);
        this.i = (RelativeLayout) inflate;
        if (inflate != null) {
            this.f4609a = (RelativeLayout) inflate.findViewById(h0.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            this.b = (RelativeLayout) inflate.findViewById(h0.a(getContext(), "mbridge_full_player_parent", "id"));
            this.c = (RelativeLayout) inflate.findViewById(h0.a(getContext(), "mbridge_full_rl_close", "id"));
            this.d = (ImageView) inflate.findViewById(h0.a(getContext(), "mbridge_full_iv_close", "id"));
            this.e = (TextView) inflate.findViewById(h0.a(getContext(), "mbridge_full_tv_install", "id"));
            this.f = (ProgressBar) inflate.findViewById(h0.a(getContext(), "mbridge_full_pb_loading", "id"));
            this.g = (FrameLayout) inflate.findViewById(h0.a(getContext(), "mbridge_full_animation_content", "id"));
            this.h = (LinearLayout) inflate.findViewById(h0.a(getContext(), "mbridge_full_animation_player", "id"));
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public RelativeLayout getMBridgeFullClose() {
        return this.c;
    }

    public ImageView getMBridgeFullIvClose() {
        return this.d;
    }

    public ProgressBar getMBridgeFullPb() {
        return this.f;
    }

    public RelativeLayout getMBridgeFullPlayContainer() {
        return this.f4609a;
    }

    public RelativeLayout getMBridgeFullPlayerParent() {
        return this.b;
    }

    public TextView getMBridgeFullTvInstall() {
        return this.e;
    }

    public a getStytle() {
        return this.style;
    }

    public FrameLayout getmAnimationContent() {
        return this.g;
    }

    public LinearLayout getmAnimationPlayer() {
        return this.h;
    }

    public void setStytle(a aVar) {
        this.style = aVar;
    }
}
