package io.bidmachine.nativead.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.bidmachine.LabelData;
import io.bidmachine.PositionData;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.core.Utils;
import io.bidmachine.nativead.NativeData;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.util.UtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdOverlayContainer.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lio/bidmachine/nativead/view/NativeAdOverlayContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindNativeData", "", "nativeData", "Lio/bidmachine/nativead/NativeData;", "buildLabelView", "Landroid/widget/ImageView;", "labelData", "Lio/bidmachine/LabelData;", "leftMargin", "rightMargin", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeAdOverlayContainer extends FrameLayout {

    /* compiled from: NativeAdOverlayContainer.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PositionData.values().length];
            try {
                iArr[PositionData.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PositionData.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PositionData.BottomLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PositionData.BottomRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeAdOverlayContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeAdOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NativeAdOverlayContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdOverlayContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void bindNativeData(NativeData nativeData) {
        int i;
        Intrinsics.checkNotNullParameter(nativeData, "nativeData");
        removeAllViews();
        Context context = getContext();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LabelData adLabelData = nativeData.getAdLabelData();
        int i2 = 0;
        if (adLabelData != null) {
            PositionData positionData = adLabelData.getPositionData();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(buildLabelView(adLabelData, 0, 0));
            linkedHashMap.put(positionData, linearLayout);
        }
        final PrivacySheetData privacySheetData = nativeData.getPrivacySheetData();
        if (privacySheetData != null) {
            LabelData labelData = privacySheetData.getLabelData();
            PositionData positionData2 = labelData.getPositionData();
            LinearLayout linearLayout2 = (LinearLayout) linkedHashMap.get(positionData2);
            if (linearLayout2 == null) {
                linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(0);
            }
            linkedHashMap.put(positionData2, linearLayout2);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int dpToPx = UtilsKt.dpToPx(context, 5.0f);
            int childCount = linearLayout2.getChildCount();
            if (positionData2 == PositionData.TopLeft || positionData2 == PositionData.BottomLeft) {
                i = 0;
                if (childCount <= 0) {
                    dpToPx = 0;
                }
            } else {
                i = linearLayout2.getChildCount();
                if (childCount > 0) {
                    dpToPx = 0;
                    i2 = dpToPx;
                } else {
                    dpToPx = 0;
                }
            }
            ImageView buildLabelView = buildLabelView(labelData, i2, dpToPx);
            linearLayout2.addView(buildLabelView, i);
            buildLabelView.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.nativead.view.NativeAdOverlayContainer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NativeAdOverlayContainer.bindNativeData$lambda$4$lambda$3(PrivacySheetData.this, view);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dpToPx2 = UtilsKt.dpToPx(context, 8.0f);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PositionData positionData3 = (PositionData) entry.getKey();
            LinearLayout linearLayout3 = (LinearLayout) entry.getValue();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            int i3 = WhenMappings.$EnumSwitchMapping$0[positionData3.ordinal()];
            if (i3 == 1) {
                layoutParams.gravity = 51;
            } else if (i3 == 2) {
                layoutParams.gravity = 53;
            } else if (i3 == 3) {
                layoutParams.gravity = 83;
            } else if (i3 == 4) {
                layoutParams.gravity = 85;
            }
            addView(linearLayout3, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindNativeData$lambda$4$lambda$3(PrivacySheetData privacySheetData, View v) {
        Intrinsics.checkNotNullParameter(privacySheetData, "$privacySheetData");
        Intrinsics.checkNotNullParameter(v, "v");
        PrivacySheetDialog.Companion companion = PrivacySheetDialog.INSTANCE;
        Context findDialogContext = Utils.findDialogContext(v.getContext(), v);
        Intrinsics.checkNotNullExpressionValue(findDialogContext, "findDialogContext(v.context, v)");
        companion.show(findDialogContext, privacySheetData.getPrivacySheetParams());
    }

    private final ImageView buildLabelView(LabelData labelData, int leftMargin, int rightMargin) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(labelData.getImage());
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dpToPx = UtilsKt.dpToPx(context, labelData.getWidthDp());
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, UtilsKt.dpToPx(context2, labelData.getHeightDp()));
        layoutParams.setMargins(leftMargin, 0, rightMargin, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
