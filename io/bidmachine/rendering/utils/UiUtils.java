package io.bidmachine.rendering.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.utils.taskmanager.TaskManager;
import io.bidmachine.rendering.utils.taskmanager.UITaskManager;
import io.bidmachine.util.Executable;
import io.bidmachine.util.ViewUtils;

/* loaded from: classes8.dex */
public class UiUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final TaskManager f7198a = new UITaskManager();

    public static void applyInsets(Activity activity, View contentView) {
        applyInsets(activity, contentView, true);
    }

    public static void cancelOnUiThread(Runnable runnable) {
        f7198a.cancel(runnable);
    }

    public static int dpToPx(Context context, float value) {
        if (value == 0.0f) {
            return 0;
        }
        return io.bidmachine.iab.utils.Utils.dpToPx(context, value);
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static Rect getLocationInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    public static float getNotOverlappedAreaPercent(Rect mainRect, Rect coverRect) {
        int width = mainRect.width() * mainRect.height();
        if (width == 0) {
            return 0.0f;
        }
        return (width - (Math.max(0, Math.min(mainRect.right, coverRect.right) - Math.max(mainRect.left, coverRect.left)) * Math.max(0, Math.min(mainRect.bottom, coverRect.bottom) - Math.max(mainRect.top, coverRect.top)))) / width;
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static boolean isViewVisible(int visibility) {
        return visibility == 0;
    }

    public static void onUiThread(Runnable runnable) {
        f7198a.execute(runnable);
    }

    public static <I> void onUiThreadWithArgSafely(final I input, final Executable<I> postMethod) {
        if (postMethod == null) {
            return;
        }
        io.bidmachine.util.UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.utils.UiUtils$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                Executable.this.execute(input);
            }
        });
    }

    public static void setupActivityOrientation(Activity activity, Orientation orientation) {
        activity.setRequestedOrientation(orientation != null ? orientation.getActivityOrientation() : 4);
    }

    public static String toString(int visibility) {
        return visibility != 0 ? visibility != 4 ? visibility != 8 ? "unknown" : "GONE" : "INVISIBLE" : "VISIBLE";
    }

    public static void applyInsets(Activity activity, View contentView, boolean isRequestApplyInsets) {
        if (Build.VERSION.SDK_INT >= 35) {
            Window window = activity.getWindow();
            View decorView = window != null ? window.getDecorView() : contentView;
            contentView.setPadding(0, 0, 0, 0);
            ViewUtils.setInsetsChanger(decorView);
            if (isRequestApplyInsets) {
                decorView.requestApplyInsets();
            }
        }
    }

    public static void onUiThread(Runnable runnable, long delayMs) {
        f7198a.schedule(runnable, delayMs);
    }
}
