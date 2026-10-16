package com.unity3d.player;

import android.content.Context;
import android.widget.FrameLayout;
import com.unity3d.player.a.C3499g;

/* loaded from: classes7.dex */
public final class U extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final C3499g f6493a;
    public final UnityPlayerForActivityOrService b;
    public final com.unity3d.player.a.C c;

    public U(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(unityPlayerForActivityOrService.getContext());
        Context context = unityPlayerForActivityOrService.getContext();
        this.c = new com.unity3d.player.a.C(context);
        this.b = unityPlayerForActivityOrService;
        C3499g c3499g = new C3499g(unityPlayerForActivityOrService);
        this.f6493a = c3499g;
        c3499g.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        unityPlayerForActivityOrService.applySurfaceViewSettings(c3499g);
        c3499g.getHolder().addCallback(new T(this));
        c3499g.setFocusable(true);
        c3499g.setFocusableInTouchMode(true);
        c3499g.setContentDescription(context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName())));
        addView(c3499g, new FrameLayout.LayoutParams(-1, -1, 17));
    }
}
