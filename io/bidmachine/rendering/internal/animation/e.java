package io.bidmachine.rendering.internal.animation;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/bidmachine/rendering/internal/animation/e;", "", "", "alpha", "translationX", "translationY", "<init>", "(FFF)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "(Landroid/view/View;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "F", "()F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float alpha;

    /* renamed from: b, reason: from kotlin metadata */
    private final float translationX;

    /* renamed from: c, reason: from kotlin metadata */
    private final float translationY;

    public e(float f, float f2, float f3) {
        this.alpha = f;
        this.translationX = f2;
        this.translationY = f3;
    }

    /* renamed from: a, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: b, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* renamed from: c, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return Float.compare(this.alpha, eVar.alpha) == 0 && Float.compare(this.translationX, eVar.translationX) == 0 && Float.compare(this.translationY, eVar.translationY) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.alpha) * 31) + Float.hashCode(this.translationX)) * 31) + Float.hashCode(this.translationY);
    }

    public String toString() {
        return "AdAnimationValues(alpha=" + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(View view) {
        this(view.getAlpha(), view.getTranslationX(), view.getTranslationY());
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
