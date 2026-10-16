package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes7.dex */
public class IabVideoTexture extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    private int f6928a;
    private int b;

    public IabVideoTexture(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        if (r1 > r6) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int defaultSize = View.getDefaultSize(this.f6928a, widthMeasureSpec);
        int defaultSize2 = View.getDefaultSize(this.b, heightMeasureSpec);
        if (this.f6928a > 0 && this.b > 0) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i2 = this.f6928a;
                int i3 = i2 * size2;
                int i4 = this.b;
                int i5 = size * i4;
                if (i3 < i5) {
                    defaultSize = i3 / i4;
                    defaultSize2 = size2;
                } else {
                    if (i3 > i5) {
                        defaultSize2 = i5 / i2;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i6 = (this.b * size) / this.f6928a;
                if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                    defaultSize2 = i6;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                if (mode2 == 1073741824) {
                    i = (this.f6928a * size2) / this.b;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    int i7 = this.f6928a;
                    int i8 = this.b;
                    if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                        i = i7;
                        size2 = i8;
                    } else {
                        i = (size2 * i7) / i8;
                    }
                    if (mode == Integer.MIN_VALUE && i > size) {
                        defaultSize2 = (i8 * size) / i7;
                        defaultSize = size;
                    }
                }
                defaultSize = i;
                defaultSize2 = size2;
            }
        }
        Log.e("Size", defaultSize + RemoteSettings.FORWARD_SLASH_STRING + defaultSize2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setVideoSize(int width, int height) {
        this.f6928a = width;
        this.b = height;
        requestLayout();
    }
}
