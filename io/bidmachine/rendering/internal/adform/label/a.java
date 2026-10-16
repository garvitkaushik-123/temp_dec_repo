package io.bidmachine.rendering.internal.adform.label;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.event.b;
import io.bidmachine.rendering.internal.j;
import io.bidmachine.rendering.internal.z;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.Border;
import io.bidmachine.rendering.model.FontStyleType;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0019B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lio/bidmachine/rendering/internal/adform/label/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)V", "Landroid/view/View;", "v", "()Landroid/view/View;", "", "c", "()V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/internal/z;", "viewBackgroundSetter", "a", "(Landroid/view/View;Lio/bidmachine/rendering/internal/z;)V", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "label", "s", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final TextView label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.label = new TextView(context);
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void a(View view, z viewBackgroundSetter) {
        Intrinsics.checkNotNullParameter(view, "view");
        int cornerRadiusPxOrDefault$default = AppearanceParams.getCornerRadiusPxOrDefault$default(getAppearanceParams(), getApplicationContext(), 0, 2, null);
        Border border = getAppearanceParams().getBorder(getApplicationContext());
        if (viewBackgroundSetter != null) {
            viewBackgroundSetter.a(this.label, Integer.valueOf(cornerRadiusPxOrDefault$default), border);
            return;
        }
        TextView textView = this.label;
        j jVar = new j();
        jVar.b(AppearanceParams.getBackgroundOrDefault$default(getAppearanceParams(), 0, 1, null));
        jVar.a(cornerRadiusPxOrDefault$default);
        if (border != null) {
            j.a(jVar, border.getStrokeWidthPx(), border.getStrokeColor(), 0.0f, 0.0f, 12, null);
            this.label.setPadding(border.getStrokeWidthPx(), border.getStrokeWidthPx() - UtilsKt.dpToPx(getApplicationContext(), 2.0f), border.getStrokeWidthPx(), border.getStrokeWidthPx() + UtilsKt.dpToPx(getApplicationContext(), 2.0f));
        }
        textView.setBackground(jVar);
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        this.label.setText(getAdElementParams().getText());
        Integer strokeColor = getAppearanceParams().getStrokeColor();
        if (strokeColor != null) {
            this.label.setTextColor(strokeColor.intValue());
        }
        Float fontSize = getAppearanceParams().getFontSize();
        if (fontSize != null && fontSize.floatValue() > 0.0f) {
            this.label.setTextSize(1, fontSize.floatValue());
        }
        FontStyleType fontStyleType = getAppearanceParams().getFontStyleType();
        if (fontStyleType != null) {
            this.label.setTypeface(Typeface.create(Typeface.DEFAULT, fontStyleType.getTypeface()));
        }
        Integer textMaxLines = getAppearanceParams().getTextMaxLines();
        if (textMaxLines != null && textMaxLines.intValue() > 0) {
            this.label.setMaxLines(textMaxLines.intValue());
        }
        if (getAppearanceParams().getTextLineSpacingPx(getApplicationContext()) != null) {
            this.label.setLineSpacing(r0.intValue(), 1.0f);
        }
        this.label.setGravity(getAppearanceParams().getTextHorizontalGravity().getValue() | 16);
        Integer shadowColor = getAppearanceParams().getShadowColor();
        if (shadowColor != null) {
            int intValue = shadowColor.intValue();
            float dpToPx = UtilsKt.dpToPx(getApplicationContext(), 1.0f);
            this.label.setShadowLayer(UtilsKt.dpToPx(getApplicationContext(), 1.0f), dpToPx, dpToPx, intValue);
        }
        this.label.setIncludeFontPadding(false);
        getAdFormListener().b(this);
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        return this.label;
    }
}
