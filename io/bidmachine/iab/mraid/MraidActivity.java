package io.bidmachine.iab.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.internal.ActivityC3588a;
import io.bidmachine.rendering.internal.C3589b;
import io.bidmachine.util.UiUtils;

/* loaded from: classes7.dex */
public class MraidActivity extends ActivityC3588a {
    private static final SparseArray<MraidInterstitial> d = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    private Integer f6798a;
    private MraidInterstitial b;
    private boolean c = false;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6799a;

        static {
            int[] iArr = new int[MraidType.values().length];
            f6799a = iArr;
            try {
                iArr[MraidType.Static.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6799a[MraidType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6799a[MraidType.Rewarded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void a(MraidInterstitial interstitial) {
        d.put(interstitial.id, interstitial);
    }

    private void c() {
        a(this.f6798a);
    }

    public static void show(Context context, MraidInterstitial mraidInterstitial, MraidType mraidType) {
        if (mraidInterstitial == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "MraidInterstitial is null during showing MraidActivity", new Object[0]);
            return;
        }
        if (context == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "Context is null during showing MraidActivity", new Object[0]);
            mraidInterstitial.c(IabError.noRequiredArguments("Context is null during showing MraidActivity"));
            return;
        }
        if (mraidType == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "MraidType is null during showing MraidActivity", new Object[0]);
            mraidInterstitial.c(IabError.noRequiredArguments("MraidType is null during showing MraidActivity"));
            return;
        }
        try {
            a(mraidInterstitial);
            context.startActivity(a(context, mraidType, mraidInterstitial.id));
        } catch (Throwable th) {
            MraidLog.e("Exception during showing MraidActivity", th);
            mraidInterstitial.c(IabError.throwable("Exception during showing MraidActivity", th));
            a(Integer.valueOf(mraidInterstitial.id));
        }
    }

    @Override // io.bidmachine.rendering.internal.ActivityC3588a, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getIntent().hasExtra("InterstitialId")) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "Mraid display cache id not provided", new Object[0]);
            UiUtils.finishActivityWithoutAnimation(this);
            return;
        }
        Integer valueOf = Integer.valueOf(getIntent().getIntExtra("InterstitialId", 0));
        this.f6798a = valueOf;
        MraidInterstitial mraidInterstitial = d.get(valueOf.intValue());
        this.b = mraidInterstitial;
        if (mraidInterstitial == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "Mraid interstitial not found in display cache, id=%s", this.f6798a);
            UiUtils.finishActivityWithoutAnimation(this);
            return;
        }
        MraidType mraidType = (MraidType) getIntent().getSerializableExtra("InterstitialType");
        if (mraidType == null) {
            MraidLog.e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.h, "MraidType is null", new Object[0]);
            UiUtils.finishActivityWithoutAnimation(this);
            this.b.c(IabError.internal("MraidType is null"));
            return;
        }
        Utils.applyFullscreenActivityFlags(this);
        int i = a.f6799a[mraidType.ordinal()];
        if (i == 1 || i == 2) {
            this.c = true;
        } else if (i == 3) {
            this.c = false;
        }
        try {
            this.b.a((Activity) this, false);
        } catch (Exception e) {
            MraidLog.e("Exception during showing MraidInterstial in MraidActivity", e);
            UiUtils.finishActivityWithoutAnimation(this);
            this.b.c(IabError.throwable("Exception during showing MraidInterstial in MraidActivity", e));
            c();
        }
        Utils.applyWindowInsets(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.b == null || isChangingConfigurations()) {
            return;
        }
        this.b.b();
        c();
    }

    private static void a(Integer interstitialId) {
        if (interstitialId == null) {
            return;
        }
        d.remove(interstitialId.intValue());
    }

    private static Intent a(Context context, MraidType mraidType, int interstitialId) {
        Intent a2 = C3589b.a(context, MraidActivity.class);
        a2.putExtra("InterstitialId", interstitialId);
        a2.putExtra("InterstitialType", mraidType);
        return a2;
    }

    @Override // io.bidmachine.rendering.internal.ActivityC3588a
    protected void a() {
        if (this.c) {
            MraidInterstitial mraidInterstitial = this.b;
            if (mraidInterstitial != null) {
                mraidInterstitial.dispatchClose();
            } else {
                UiUtils.finishActivityWithoutAnimation(this);
            }
        }
    }
}
