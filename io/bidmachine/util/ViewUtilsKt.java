package io.bidmachine.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import com.ironsource.C3061e8;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: ViewUtils.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0015\u0010\u000e\u001a\u00020\u0002*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\t\u001a5\u0010\u0013\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0015H\u0086\bø\u0001\u0001\u001a\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u0002\u001a\f\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u001a)\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u0002*\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e¢\u0006\u0002\u0010\u001f\u001a\f\u0010 \u001a\u0004\u0018\u00010!*\u00020\u0002\u001a\n\u0010\"\u001a\u00020#*\u00020\u0002\u001a\f\u0010$\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010%\u001a\u00020\u0011*\u00020\u0002\u001a\n\u0010&\u001a\u00020\u0011*\u00020\u0002\u001a\u0011\u0010'\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¢\u0006\u0002\u0010(\u001a\u001b\u0010)\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010+\u001a\u0016\u0010,\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007\u001a\f\u0010.\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006/"}, d2 = {"addPadding", "", "Landroid/view/View;", "leftPx", "", "topPx", "rightPx", "bottomPx", "addSingleViewSafely", "Landroid/view/ViewGroup;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "addViewSafely", "awaitLayout", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "belongTo", "", "parent", "doOnLayout", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "findActivity", "Landroid/app/Activity;", "findContentOrRootView", "findViewByClassName", "T", "viewClass", "Ljava/lang/Class;", "(Landroid/view/ViewGroup;Ljava/lang/Class;)Landroid/view/View;", "findWindow", "Landroid/view/Window;", "getLocationInWindow", "Landroid/graphics/Rect;", "hideViewSafely", "isViewTransparent", C3061e8.n, "removeFromParent", "(Landroid/view/View;)Lkotlin/Unit;", "setBackgroundColorSafely", "color", "(Landroid/view/View;Ljava/lang/Integer;)V", "setInsetsChanger", "typeInsets", "showViewSafely", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class ViewUtilsKt {
    public static final boolean belongTo(View view, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Object parent2 = view.getParent();
        if (parent2 instanceof ViewGroup) {
            return Intrinsics.areEqual(parent2, parent) || belongTo((View) parent2, parent);
        }
        return false;
    }

    public static final void showViewSafely(final View view) {
        if (view == null) {
            return;
        }
        UiUtils.onUiThread(new SafeRunnable() { // from class: io.bidmachine.util.ViewUtilsKt$showViewSafely$1
            @Override // io.bidmachine.util.SafeRunnable
            public void onRun() {
                view.setVisibility(0);
            }
        });
    }

    public static final void hideViewSafely(final View view) {
        if (view == null) {
            return;
        }
        UiUtils.onUiThread(new SafeRunnable() { // from class: io.bidmachine.util.ViewUtilsKt$hideViewSafely$1
            @Override // io.bidmachine.util.SafeRunnable
            public void onRun() {
                view.setVisibility(8);
            }
        });
    }

    public static final Unit removeFromParent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        viewGroup.removeView(view);
        return Unit.INSTANCE;
    }

    public static final boolean isViewVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewUtils.isViewVisible(view.getVisibility());
    }

    public static final Rect getLocationInWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    public static final boolean isViewTransparent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getAlpha() == 0.0f;
    }

    public static /* synthetic */ void setInsetsChanger$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        }
        setInsetsChanger(view, i);
    }

    public static final void setInsetsChanger(View view, final int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: io.bidmachine.util.ViewUtilsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                WindowInsets insetsChanger$lambda$3;
                insetsChanger$lambda$3 = ViewUtilsKt.setInsetsChanger$lambda$3(i, view2, windowInsets);
                return insetsChanger$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setInsetsChanger$lambda$3(int i, View selfView, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(selfView, "selfView");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(i);
        Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(typeInsets)");
        selfView.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsets;
    }

    public static /* synthetic */ void addViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = null;
        }
        addViewSafely(viewGroup, view, layoutParams);
    }

    public static final void addViewSafely(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            removeFromParent(view);
            if (layoutParams != null) {
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void addSingleViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = null;
        }
        addSingleViewSafely(viewGroup, view, layoutParams);
    }

    public static final void addSingleViewSafely(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            viewGroup.removeAllViews();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
        addViewSafely(viewGroup, view, layoutParams);
    }

    public static final <T extends View> T findViewByClassName(ViewGroup viewGroup, Class<T> viewClass) {
        T t;
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        try {
            if (Intrinsics.areEqual(viewGroup.getClass(), viewClass)) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ViewGroup) && (t = (T) findViewByClassName((ViewGroup) childAt, viewClass)) != null) {
                    return t;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final View findContentOrRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        View view2 = null;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view2;
            }
        }
        return view2;
    }

    public static final Activity findActivity(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        View findContentOrRootView = findContentOrRootView(view);
        Context context = findContentOrRootView != null ? findContentOrRootView.getContext() : null;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static final Window findWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Activity findActivity = findActivity(view);
        if (findActivity != null) {
            return findActivity.getWindow();
        }
        return null;
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            action.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new ViewUtilsKt$doOnLayout$1(action));
        }
    }

    public static final void addPadding(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft() + i, view.getPaddingTop() + i2, view.getPaddingRight() + i3, view.getPaddingBottom() + i4);
    }

    public static final void setBackgroundColorSafely(View view, Integer num) {
        if (view == null || num == null) {
            return;
        }
        try {
            view.setBackgroundColor(num.intValue());
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [io.bidmachine.util.ViewUtilsKt$awaitLayout$2$listener$1] */
    public static final Object awaitLayout(final View view, Continuation<? super View> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m10241constructorimpl(view));
        } else {
            final ?? r2 = new View.OnLayoutChangeListener() { // from class: io.bidmachine.util.ViewUtilsKt$awaitLayout$2$listener$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    view.removeOnLayoutChangeListener(this);
                    CancellableContinuation<View> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m10241constructorimpl(view2));
                }
            };
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: io.bidmachine.util.ViewUtilsKt$awaitLayout$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    view.removeOnLayoutChangeListener(r2);
                }
            });
            view.addOnLayoutChangeListener((View.OnLayoutChangeListener) r2);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
