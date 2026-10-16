package io.bidmachine.rendering.model;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/model/Padding;", "", "", "leftDp", "topDp", "rightDp", "bottomDp", "<init>", "(FFFF)V", "", "isZero", "()Z", "a", "F", "getLeftDp", "()F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getTopDp", "c", "getRightDp", "d", "getBottomDp", "Companion", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class Padding {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float leftDp;

    /* renamed from: b, reason: from kotlin metadata */
    private final float topDp;

    /* renamed from: c, reason: from kotlin metadata */
    private final float rightDp;

    /* renamed from: d, reason: from kotlin metadata */
    private final float bottomDp;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\f"}, d2 = {"Lio/bidmachine/rendering/model/Padding$Companion;", "", "()V", "parse", "Lio/bidmachine/rendering/model/Padding;", "value", "", "setPadding", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", VastAttributes.PADDING, "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Padding parse(String value) {
            List split$default = value != null ? StringsKt.split$default((CharSequence) value, new String[]{","}, false, 0, 6, (Object) null) : null;
            if (split$default != null && split$default.size() >= 4) {
                try {
                    return new Padding(Float.parseFloat(StringsKt.trim((CharSequence) split$default.get(0)).toString()), Float.parseFloat(StringsKt.trim((CharSequence) split$default.get(1)).toString()), Float.parseFloat(StringsKt.trim((CharSequence) split$default.get(2)).toString()), Float.parseFloat(StringsKt.trim((CharSequence) split$default.get(3)).toString()));
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @JvmStatic
        public final void setPadding(View view, Padding padding) {
            Intrinsics.checkNotNullParameter(view, "view");
            PaddingKt.setPadding(view, padding);
        }

        private Companion() {
        }
    }

    public Padding(float f, float f2, float f3, float f4) {
        this.leftDp = f;
        this.topDp = f2;
        this.rightDp = f3;
        this.bottomDp = f4;
    }

    @JvmStatic
    public static final Padding parse(String str) {
        return INSTANCE.parse(str);
    }

    @JvmStatic
    public static final void setPadding(View view, Padding padding) {
        INSTANCE.setPadding(view, padding);
    }

    public final float getBottomDp() {
        return this.bottomDp;
    }

    public final float getLeftDp() {
        return this.leftDp;
    }

    public final float getRightDp() {
        return this.rightDp;
    }

    public final float getTopDp() {
        return this.topDp;
    }

    public final boolean isZero() {
        return this.leftDp == 0.0f && this.topDp == 0.0f && this.rightDp == 0.0f && this.bottomDp == 0.0f;
    }
}
