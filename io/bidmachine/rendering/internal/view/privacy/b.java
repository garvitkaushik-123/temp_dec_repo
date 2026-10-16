package io.bidmachine.rendering.internal.view.privacy;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.view.privacy.b;
import io.bidmachine.util.UtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ/\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\bJ7\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lio/bidmachine/rendering/internal/view/privacy/b;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "subtitle", "setSubtitle", "Landroid/graphics/drawable/Drawable;", "actionIcon", "Lkotlin/Function0;", "clickListener", "a", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "child", "", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "measureChildWithMargins", "(Landroid/view/View;IIII)V", "Lio/bidmachine/rendering/internal/view/privacy/c;", "Lkotlin/Lazy;", "getPrivacySheetView", "()Lio/bidmachine/rendering/internal/view/privacy/c;", "privacySheetView", "Lkotlin/jvm/functions/Function0;", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onCloseClickListener", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy privacySheetView;

    /* renamed from: b, reason: from kotlin metadata */
    private Function0<Unit> onCloseClickListener;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        public final void a() {
            b.this.getOnCloseClickListener().invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 7, 1})
    /* renamed from: io.bidmachine.rendering.internal.view.privacy.b$b, reason: collision with other inner class name */
    static final class C0631b extends Lambda implements Function0<Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0631b f7114a = new C0631b();

        C0631b() {
            super(0);
        }

        public final void a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/rendering/internal/view/privacy/c;", "a", "()Lio/bidmachine/rendering/internal/view/privacy/c;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<io.bidmachine.rendering.internal.view.privacy.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7115a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.f7115a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View view) {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.bidmachine.rendering.internal.view.privacy.c invoke() {
            io.bidmachine.rendering.internal.view.privacy.c cVar = new io.bidmachine.rendering.internal.view.privacy.c(this.f7115a);
            cVar.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.rendering.internal.view.privacy.b$c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.c.a(view);
                }
            });
            return cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.privacySheetView = LazyKt.lazy(new c(context));
        this.onCloseClickListener = C0631b.f7114a;
        setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.rendering.internal.view.privacy.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.a(b.this, view);
            }
        });
        io.bidmachine.rendering.internal.view.privacy.c privacySheetView = getPrivacySheetView();
        privacySheetView.setOnCloseButtonClickListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        Unit unit = Unit.INSTANCE;
        addView(privacySheetView, layoutParams);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCloseClickListener.invoke();
    }

    private final void b() {
        final int paddingBottom = getPrivacySheetView().getPaddingBottom();
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: io.bidmachine.rendering.internal.view.privacy.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets a2;
                a2 = b.a(b.this, paddingBottom, view, windowInsets);
                return a2;
            }
        });
    }

    private final io.bidmachine.rendering.internal.view.privacy.c getPrivacySheetView() {
        return (io.bidmachine.rendering.internal.view.privacy.c) this.privacySheetView.getValue();
    }

    public final Function0<Unit> getOnCloseClickListener() {
        return this.onCloseClickListener;
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        Intrinsics.checkNotNullParameter(child, "child");
        int size = View.MeasureSpec.getSize(parentWidthMeasureSpec);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dpToPx = UtilsKt.dpToPx(context, 600.0f);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        if (size >= UtilsKt.dpToPx(context2, 32.0f) + dpToPx) {
            parentWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    public final void setOnCloseClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onCloseClickListener = function0;
    }

    public final void setSubtitle(String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        getPrivacySheetView().setSubtitle(subtitle);
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        getPrivacySheetView().setTitle(title);
    }

    public final void a(String title, Drawable actionIcon, Function0<Unit> clickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        getPrivacySheetView().a(title, actionIcon, clickListener);
    }

    public final void a() {
        getPrivacySheetView().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets a(b this$0, int i, View view, WindowInsets insets) {
        Rect rect;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (Build.VERSION.SDK_INT >= 30) {
            Insets insets2 = insets.getInsets(WindowInsets.Type.systemBars());
            rect = new Rect(insets2.left, insets2.top, insets2.right, insets2.bottom);
        } else {
            rect = new Rect(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
        }
        this$0.getPrivacySheetView().setPadding(this$0.getPrivacySheetView().getPaddingLeft(), this$0.getPrivacySheetView().getPaddingTop(), this$0.getPrivacySheetView().getPaddingRight(), i + rect.bottom);
        this$0.setPadding(0, rect.top, 0, 0);
        return insets;
    }
}
