package io.adn.sdk.internal.ui.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.common.model.Destroyable;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: View.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\u000e\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\b\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0003H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\u0002\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0080@¢\u0006\u0002\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\u0002*\u00020\u0006H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0013*\u00020\u0006H\u0000¨\u0006\u001b"}, d2 = {"detachFromParent", "Lkotlin/Result;", "", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Object;", "detachView", "Landroid/view/ViewGroup;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "(Landroid/view/ViewGroup;Landroid/view/View;)Ljava/lang/Object;", "addView", FirebaseAnalytics.Param.INDEX, "", "width", "height", "(Landroid/view/ViewGroup;Landroid/view/View;III)Ljava/lang/Object;", "addViewWithMatchParent", "getVisiblePercent", "", "isWithinWindowBounds", "", "setImageFile", "Landroid/widget/ImageView;", C3040d4.h.b, "Ljava/io/File;", "(Landroid/widget/ImageView;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyAndClearViews", "isEmpty", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ViewKt {
    public static final Object detachFromParent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            ViewParent parent = view.getParent();
            Unit unit = null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
                unit = Unit.INSTANCE;
            }
            return Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final Object detachView(ViewGroup viewGroup, View view) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (view != null && viewGroup != null) {
                viewGroup.removeView(view);
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final Object addView(ViewGroup viewGroup, View view, int i, int i2, int i3) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (view != null && viewGroup != null) {
                viewGroup.addView(view, i, new ViewGroup.LayoutParams(i2, i3));
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final Object addViewWithMatchParent(ViewGroup viewGroup, View view) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (view != null && viewGroup != null) {
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final float getVisiblePercent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!view.isShown() || view.getAlpha() == 0.0f || !view.hasWindowFocus() || !isWithinWindowBounds(view)) {
            return 0.0f;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return 0.0f;
        }
        float width = view.getWidth() * view.getHeight();
        if (width == 0.0f) {
            return 0.0f;
        }
        return (r0.width() * r0.height()) / width;
    }

    private static final boolean isWithinWindowBounds(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return false;
        }
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect2, rect);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(10:5|6|7|(1:(2:10|11)(2:26|27))(7:28|29|(2:31|(1:33))|(1:16)(1:25)|17|18|(2:20|21)(1:23))|12|(1:14)|(0)(0)|17|18|(0)(0)))|36|6|7|(0)(0)|12|(0)|(0)(0)|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r7 = kotlin.Result.INSTANCE;
        r6 = kotlin.Result.m10241constructorimpl(kotlin.ResultKt.createFailure(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x006f, TryCatch #0 {all -> 0x006f, blocks: (B:11:0x002c, B:12:0x005a, B:14:0x005e, B:17:0x0066, B:29:0x003b, B:31:0x0042), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setImageFile(ImageView imageView, File file, Continuation<? super Boolean> continuation) {
        ViewKt$setImageFile$1 viewKt$setImageFile$1;
        int i;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (continuation instanceof ViewKt$setImageFile$1) {
            viewKt$setImageFile$1 = (ViewKt$setImageFile$1) continuation;
            if ((viewKt$setImageFile$1.label & Integer.MIN_VALUE) != 0) {
                viewKt$setImageFile$1.label -= Integer.MIN_VALUE;
                Object obj = viewKt$setImageFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = viewKt$setImageFile$1.label;
                bitmap = null;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.INSTANCE;
                    imageView.setImageBitmap(null);
                    if (file != null) {
                        CoroutineDispatcher io2 = Dispatchers.getIO();
                        ViewKt$setImageFile$2$1$1 viewKt$setImageFile$2$1$1 = new ViewKt$setImageFile$2$1$1(file, null);
                        viewKt$setImageFile$1.L$0 = imageView;
                        viewKt$setImageFile$1.label = 1;
                        obj = BuildersKt.withContext(io2, viewKt$setImageFile$2$1$1, viewKt$setImageFile$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (bitmap == null) {
                        z = false;
                    }
                    Object m10241constructorimpl = Result.m10241constructorimpl(Boxing.boxBoolean(z));
                    return Result.m10247isFailureimpl(m10241constructorimpl) ? Boxing.boxBoolean(false) : m10241constructorimpl;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageView = (ImageView) viewKt$setImageFile$1.L$0;
                ResultKt.throwOnFailure(obj);
                bitmap2 = (Bitmap) obj;
                if (bitmap2 != null) {
                    imageView.setImageBitmap(bitmap2);
                    bitmap = bitmap2;
                }
                if (bitmap == null) {
                }
                Object m10241constructorimpl2 = Result.m10241constructorimpl(Boxing.boxBoolean(z));
                if (Result.m10247isFailureimpl(m10241constructorimpl2)) {
                }
            }
        }
        viewKt$setImageFile$1 = new ViewKt$setImageFile$1(continuation);
        Object obj2 = viewKt$setImageFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = viewKt$setImageFile$1.label;
        bitmap = null;
        boolean z2 = true;
        if (i != 0) {
        }
        bitmap2 = (Bitmap) obj2;
        if (bitmap2 != null) {
        }
        if (bitmap == null) {
        }
        Object m10241constructorimpl22 = Result.m10241constructorimpl(Boxing.boxBoolean(z2));
        if (Result.m10247isFailureimpl(m10241constructorimpl22)) {
        }
    }

    public static final void destroyAndClearViews(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ComposeView) {
                ((ComposeView) childAt).disposeComposition();
            } else if (childAt instanceof Destroyable) {
                ((Destroyable) childAt).destroy();
            }
        }
        viewGroup.removeAllViews();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }
}
