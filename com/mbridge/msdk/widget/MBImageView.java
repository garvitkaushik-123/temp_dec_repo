package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.image.b;
import com.mbridge.msdk.foundation.same.image.c;
import com.mbridge.msdk.foundation.tools.p0;

/* loaded from: classes6.dex */
public class MBImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f5295a;
    private String b;

    class a implements c {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            p0.b("mb-widget-imageview", str2 + " load failed:" + str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            MBImageView.this.setImageBitmap(bitmap);
        }
    }

    public MBImageView(Context context) {
        super(context);
        this.f5295a = null;
    }

    private void a() {
        if (getContext() != null) {
            b.a(getContext()).a(this.b, new a());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f5295a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
        } else {
            p0.b("mb-widget-imageview", "onDraw bitmap recycled");
            a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f5295a = bitmap;
        if (bitmap == null) {
            super.setImageBitmap(bitmap);
        } else {
            if (!bitmap.isRecycled()) {
                super.setImageBitmap(bitmap);
                return;
            }
            this.f5295a = null;
            super.setImageBitmap(null);
            p0.b("mb-widget-imageview", "setImageBitmap recycled");
        }
    }

    public void setImageUrl(String str) {
        this.b = str;
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5295a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5295a = null;
    }
}
