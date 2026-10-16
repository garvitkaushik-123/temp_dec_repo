package io.bidmachine.rendering.internal.view.privacy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.R;
import io.bidmachine.util.UtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u000f\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lio/bidmachine/rendering/internal/view/privacy/c;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "subtitle", "setSubtitle", "Lkotlin/Function0;", "clickListener", "setOnCloseButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/graphics/drawable/Drawable;", "actionIcon", "a", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function0;)V", "()V", "Landroid/widget/TextView;", "Lkotlin/Lazy;", "getTitleTextView", "()Landroid/widget/TextView;", "titleTextView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSubtitleTextView", "subtitleTextView", "Landroid/view/View;", "c", "getCloseButton", "()Landroid/view/View;", "closeButton", "d", "getActionButtonsContainer", "()Landroid/widget/LinearLayout;", "actionButtonsContainer", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c extends LinearLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleTextView;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy subtitleTextView;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy closeButton;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy actionButtonsContainer;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "a", "()Landroid/widget/LinearLayout;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<LinearLayout> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinearLayout invoke() {
            return (LinearLayout) c.this.findViewById(R.id.bmPrivacySheetActionButtonsContainer);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "()Landroid/view/View;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<View> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke() {
            return c.this.findViewById(R.id.bmPrivacySheetClose);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "()Landroid/widget/TextView;"}, k = 3, mv = {1, 7, 1})
    /* renamed from: io.bidmachine.rendering.internal.view.privacy.c$c, reason: collision with other inner class name */
    static final class C0632c extends Lambda implements Function0<TextView> {
        C0632c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextView invoke() {
            return (TextView) c.this.findViewById(R.id.bmPrivacySheetSubtitle);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "()Landroid/widget/TextView;"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function0<TextView> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TextView invoke() {
            return (TextView) c.this.findViewById(R.id.bmPrivacySheetTitle);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleTextView = LazyKt.lazy(new d());
        this.subtitleTextView = LazyKt.lazy(new C0632c());
        this.closeButton = LazyKt.lazy(new b());
        this.actionButtonsContainer = LazyKt.lazy(new a());
        View.inflate(context, R.layout.bm_privacy_sheet, this);
        setOrientation(1);
        setBackgroundResource(R.drawable.bm_bg_privacy_sheet);
        int dpToPx = UtilsKt.dpToPx(context, 16.0f);
        setPadding(dpToPx, dpToPx, dpToPx, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 clickListener, View view) {
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        clickListener.invoke();
    }

    private final LinearLayout getActionButtonsContainer() {
        Object value = this.actionButtonsContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-actionButtonsContainer>(...)");
        return (LinearLayout) value;
    }

    private final View getCloseButton() {
        Object value = this.closeButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeButton>(...)");
        return (View) value;
    }

    private final TextView getSubtitleTextView() {
        Object value = this.subtitleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subtitleTextView>(...)");
        return (TextView) value;
    }

    private final TextView getTitleTextView() {
        Object value = this.titleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleTextView>(...)");
        return (TextView) value;
    }

    public final void a(String title, Drawable actionIcon, final Function0<Unit> clickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        LinearLayout actionButtonsContainer = getActionButtonsContainer();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        io.bidmachine.rendering.internal.view.privacy.a aVar = new io.bidmachine.rendering.internal.view.privacy.a(context);
        aVar.setText(title);
        aVar.setActionIcon(actionIcon);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.rendering.internal.view.privacy.c$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.a(Function0.this, view);
            }
        });
        actionButtonsContainer.addView(aVar, -1, -2);
    }

    public final void setOnCloseButtonClickListener(final Function0<Unit> clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        getCloseButton().setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.rendering.internal.view.privacy.c$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.b(Function0.this, view);
            }
        });
    }

    public final void setSubtitle(String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        getSubtitleTextView().setText(subtitle);
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        getTitleTextView().setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function0 clickListener, View view) {
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        clickListener.invoke();
    }

    public final void a() {
        getActionButtonsContainer().removeAllViews();
    }
}
