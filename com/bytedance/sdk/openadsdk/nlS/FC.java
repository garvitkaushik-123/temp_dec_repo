package com.bytedance.sdk.openadsdk.nlS;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* loaded from: classes3.dex */
public class FC {
    private int DbA = -1;
    private boolean Os = false;
    private final AudioManager eli;

    public FC(Context context) {
        this.eli = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int eli() {
        return this.DbA;
    }

    public void eli(boolean z) {
        eli(z, false);
    }

    public void eli(boolean z, boolean z2) {
        if (this.eli == null) {
            return;
        }
        int i = 0;
        if (z) {
            int kb = DeviceUtils.kb();
            if (kb != 0) {
                this.DbA = kb;
            } else if (!z2) {
                return;
            }
            eli(3, 0, 0);
            this.Os = true;
            return;
        }
        int i2 = this.DbA;
        if (i2 == 0) {
            i2 = DeviceUtils.FC() / 15;
        } else {
            if (i2 == -1) {
                if (!z2) {
                    return;
                } else {
                    i2 = DeviceUtils.FC() / 15;
                }
            }
            this.DbA = -1;
            eli(3, i2, i);
            this.Os = true;
        }
        i = 1;
        this.DbA = -1;
        eli(3, i2, i);
        this.Os = true;
    }

    private void eli(int i, int i2, int i3) {
        try {
            this.eli.setStreamVolume(i, i2, i3);
        } catch (Throwable unused) {
        }
    }
}
