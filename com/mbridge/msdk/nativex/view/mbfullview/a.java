package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import java.lang.ref.WeakReference;

/* compiled from: FullViewManager.java */
/* loaded from: classes6.dex */
public class a {
    private static volatile a b;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f4611a;

    /* compiled from: FullViewManager.java */
    /* renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$a, reason: collision with other inner class name */
    class RunnableC0365a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseView f4612a;
        final /* synthetic */ boolean b;

        RunnableC0365a(BaseView baseView, boolean z) {
            this.f4612a = baseView;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4612a.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
            this.f4612a.getmAnimationPlayer().getBackground().setAlpha(this.b ? 200 : 255);
            a.this.a(this.f4612a.getmAnimationPlayer());
        }
    }

    /* compiled from: FullViewManager.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4613a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            f4613a = iArr;
            try {
                iArr[BaseView.a.FULL_TOP_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4613a[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FullViewManager.java */
    private class c implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MBridgeTopFullView> f4614a;

        public c(MBridgeTopFullView mBridgeTopFullView) {
            this.f4614a = new WeakReference<>(mBridgeTopFullView);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            WeakReference<MBridgeTopFullView> weakReference = this.f4614a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f4614a.get().getMBridgeFullViewDisplayIcon().setImageBitmap(a.this.a(bitmap, 25));
        }
    }

    private a(Context context) {
        this.f4611a = new WeakReference<>(context);
    }

    public void b(boolean z, boolean z2, BaseView baseView) {
        if (z2) {
            new Handler().postDelayed(new RunnableC0365a(baseView, z), 1000L);
        }
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    public void a(BaseView.a aVar, CampaignEx campaignEx, BaseView baseView) {
        int i = b.f4613a[aVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            baseView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            return;
        }
        MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
        if (mBridgeTopFullView != null) {
            Context context = this.f4611a.get();
            if (context != null) {
                com.mbridge.msdk.foundation.same.image.b.a(context).a(campaignEx.getIconUrl(), new c(mBridgeTopFullView));
            }
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setText(campaignEx.getAppName());
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setText(campaignEx.getAppDesc());
            mBridgeTopFullView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            mBridgeTopFullView.getStarLevelLayoutView().setRating((int) campaignEx.getRating());
        }
    }

    public void a(boolean z, BaseView baseView) {
        if (baseView instanceof MBridgeTopFullView) {
            MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
            int i = z ? 0 : 8;
            mBridgeTopFullView.getMBridgeFullViewDisplayIcon().setVisibility(i);
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setVisibility(i);
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setVisibility(i);
            mBridgeTopFullView.getStarLevelLayoutView().setVisibility(i);
        }
    }

    public void a(boolean z, BaseView baseView, int i) {
        RelativeLayout.LayoutParams layoutParams;
        Context context = this.f4611a.get();
        if (context != null) {
            if (z) {
                layoutParams = new RelativeLayout.LayoutParams((int) (a(z) / 3.0f), u0.a(context, 45.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = u0.a(context, 10.0f);
                layoutParams.rightMargin = (e.a(context) && i == 0) ? u0.c(context) + u0.a(context, 8.0f) : u0.a(context, 8.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, u0.a(context, 45.0f));
                layoutParams.addRule(12);
            }
            baseView.getmAnimationContent().setLayoutParams(layoutParams);
        }
    }

    private float a(boolean z) {
        try {
            Context context = this.f4611a.get();
            if (context == null) {
                return 0.0f;
            }
            float i = u0.i(context);
            return z ? i + u0.c(context) : i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public void a(boolean z, boolean z2, BaseView baseView) {
        int parseColor = Color.parseColor("#ff264870");
        baseView.getmAnimationPlayer().setBackgroundColor(parseColor);
        Context context = this.f4611a.get();
        if (!z) {
            if (baseView.style == BaseView.a.FULL_MIDDLE_VIEW) {
                b(z, z2, baseView);
                return;
            } else {
                if (context != null) {
                    baseView.getmAnimationContent().setBackgroundResource(h0.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                    baseView.getmAnimationPlayer().setBackgroundResource(h0.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                    return;
                }
                return;
            }
        }
        if (baseView.style == BaseView.a.FULL_TOP_VIEW && context != null) {
            baseView.getmAnimationContent().setBackgroundResource(h0.a(context, "mbridge_nativex_fullview_background", "drawable"));
            baseView.getmAnimationPlayer().setBackgroundColor(parseColor);
        }
        if (z2) {
            baseView.getmAnimationPlayer().getBackground().setAlpha(80);
        } else {
            baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
            baseView.getmAnimationPlayer().getBackground().setAlpha(200);
        }
        b(z, z2, baseView);
    }

    public void a(BaseView baseView) {
        baseView.getmAnimationPlayer().clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(800L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(1);
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        bitmap.getWidth();
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void a(View view, BaseView baseView) {
        if (view == null || baseView == null) {
            return;
        }
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        baseView.i.addView(view);
    }

    public void a(BaseView baseView, boolean z) {
        if (baseView != null) {
            baseView.setSystemUiVisibility(z ? 0 : 4098);
        }
    }
}
