package com.bytedance.adsdk.DbA.eli;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.DbA.MGA.ui;

/* loaded from: classes3.dex */
public class eli extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public eli() {
    }

    public eli(int i) {
        super(i);
    }

    public eli(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public eli(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((ui.eli(i, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        } else {
            super.setAlpha(ui.eli(i, 0, 255));
        }
    }
}
