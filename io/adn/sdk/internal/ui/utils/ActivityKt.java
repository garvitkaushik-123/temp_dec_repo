package io.adn.sdk.internal.ui.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Activity.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"hideSystemUI", "", "Landroid/app/Activity;", "setOrientation", "orientation", "", "(Landroid/app/Activity;Ljava/lang/Integer;)V", "rootContainer", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "disableBackPressed", "Landroidx/appcompat/app/AppCompatActivity;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ActivityKt {
    public static final void hideSystemUI(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View decorView = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(activity.getWindow(), activity.getWindow().getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
            return;
        }
        decorView.setSystemUiVisibility(5894);
    }

    public static final void setOrientation(Activity activity, Integer num) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (num == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRequestedOrientation(num.intValue());
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final ViewGroup rootContainer(Context context) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl((ViewGroup) ((Activity) context).findViewById(R.id.content));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (ViewGroup) m10241constructorimpl;
    }

    public static final void disableBackPressed(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        appCompatActivity.getOnBackPressedDispatcher().addCallback(appCompatActivity, new OnBackPressedCallback() { // from class: io.adn.sdk.internal.ui.utils.ActivityKt$disableBackPressed$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
    }
}
