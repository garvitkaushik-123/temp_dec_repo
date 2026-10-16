package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.h0;

/* loaded from: classes6.dex */
public class SoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4111a;

    public SoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4111a = true;
    }

    public boolean getStatus() {
        return this.f4111a;
    }

    public void setSoundStatus(boolean z) {
        this.f4111a = z;
        if (z) {
            setImageResource(h0.a(getContext(), "mbridge_reward_sound_open", "drawable"));
        } else {
            setImageResource(h0.a(getContext(), "mbridge_reward_sound_close", "drawable"));
        }
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4111a = true;
    }

    public SoundImageView(Context context) {
        super(context);
        this.f4111a = true;
    }
}
