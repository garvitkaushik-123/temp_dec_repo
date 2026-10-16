package io.bidmachine.rendering.internal.detector.brokencreative.algorithm;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\t\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\u0010J\u0015\u0010\t\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\t\u0010\u0013J!\u0010\t\u001a\u00020\u0011*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\t\u0010\u0016J\u0015\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000b\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\t\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "<init>", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;)V", "Landroid/graphics/Bitmap;", "image", "", "a", "(Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "result", "isBroken", "", "(Ljava/lang/Float;Ljava/lang/Boolean;)V", "", "color", "(I)F", VastAttributes.HORIZONTAL_POSITION, VastAttributes.VERTICAL_POSITION, "(Landroid/graphics/Bitmap;II)I", "(I)I", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "()Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BrokenCreativeAlgorithmParams algorithmParams;

    public a(BrokenCreativeAlgorithmParams algorithmParams) {
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
        this.algorithmParams = algorithmParams;
    }

    /* renamed from: a, reason: from getter */
    public final BrokenCreativeAlgorithmParams getAlgorithmParams() {
        return this.algorithmParams;
    }

    public abstract Boolean a(Bitmap image);

    public final Boolean b(Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        try {
            return a(image);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(Float result, Boolean isBroken) {
        if (o.b()) {
            o.b("BrokenCreativeDetector", this.algorithmParams.getType().name() + " result - " + result + " (isBroken - " + isBroken + ')', new Object[0]);
        }
    }

    public final int b(int color) {
        return (int) ((Color.red(color) * 0.299f) + (Color.green(color) * 0.587f) + (Color.blue(color) * 0.114f));
    }

    public final float a(int color) {
        return (Utils.redToRatio(color) * 0.299f) + (Utils.greenToRatio(color) * 0.587f) + (Utils.blueToRatio(color) * 0.114f);
    }

    public final int a(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        return b(bitmap.getPixel(i, i2));
    }
}
