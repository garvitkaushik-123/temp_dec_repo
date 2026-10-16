package io.bidmachine.rendering.internal;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 {2\u00020\u0001:\u0003\u0016\u0013\u001cB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\bB\u0011\b\u0012\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\u000bJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u000f\u0010\u0013\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0013\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J/\u0010\u0016\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b\u0016\u0010$J\u0017\u0010'\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0016\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010*J3\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u001c\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010,J!\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010/J\u0017\u00102\u001a\u00020\u00122\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u00104\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010,J\u0017\u00106\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u0006H\u0014¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u001aH\u0016¢\u0006\u0004\b8\u0010\u001bJ\u000f\u00109\u001a\u00020\fH\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b;\u0010,J\u000f\u0010<\u001a\u00020\fH\u0016¢\u0006\u0004\b<\u0010:J\u0011\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010A\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00122\u0006\u0010G\u001a\u00020%H\u0014¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\fH\u0014¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u001aH\u0017¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\fH\u0017¢\u0006\u0004\bP\u0010:J\u000f\u0010Q\u001a\u00020\fH\u0016¢\u0006\u0004\bQ\u0010:J\u000f\u0010R\u001a\u00020\fH\u0016¢\u0006\u0004\bR\u0010:J\u0011\u0010T\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020\u00122\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0001H\u0016¢\u0006\u0004\bZ\u0010[R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\\R\u0014\u0010^\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010]R\u0014\u0010G\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010`R\u0014\u0010c\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010bR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010bR\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010bR\u0016\u0010s\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010u\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010]R\u0016\u0010w\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010rR\u0016\u0010z\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006|"}, d2 = {"Lio/bidmachine/rendering/internal/j;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "Lio/bidmachine/rendering/internal/j$c;", "orientation", "", "colors", "(Lio/bidmachine/rendering/internal/j$c;[I)V", "Lio/bidmachine/rendering/internal/j$b;", "gradientState", "(Lio/bidmachine/rendering/internal/j$b;)V", "", "widthPx", "color", "", "dashWidthPx", "dashGapPx", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(IIFF)V", "alpha", "a", "(I)I", "Landroid/graphics/Path;", "(Lio/bidmachine/rendering/internal/j$b;)Landroid/graphics/Path;", "", "()Z", "c", "d", "Landroid/graphics/BlendModeColorFilter;", "blendFilter", "Landroid/content/res/ColorStateList;", "tint", "Landroid/graphics/BlendMode;", "blendMode", "(Landroid/graphics/BlendModeColorFilter;Landroid/content/res/ColorStateList;Landroid/graphics/BlendMode;)Landroid/graphics/BlendModeColorFilter;", "Landroid/graphics/Rect;", VastAttributes.PADDING, "getPadding", "(Landroid/graphics/Rect;)Z", "radiusPx", "(F)V", "gradient", "(I)V", "gradientRadius", "radiusType", "(FI)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "argb", "stateSet", "onStateChange", "([I)Z", "isStateful", "getChangingConfigurations", "()I", "setAlpha", "getAlpha", "Landroid/graphics/ColorFilter;", "getColorFilter", "()Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "setTintList", "(Landroid/content/res/ColorStateList;)V", "setTintBlendMode", "(Landroid/graphics/BlendMode;)V", "rect", "onBoundsChange", "(Landroid/graphics/Rect;)V", "level", "onLevelChange", "(I)Z", "dither", "setDither", "(Z)V", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/graphics/Outline;", "outline", "getOutline", "(Landroid/graphics/Outline;)V", "mutate", "()Landroid/graphics/drawable/Drawable;", "Lio/bidmachine/rendering/internal/j$b;", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "fillPaint", "e", "Landroid/graphics/Rect;", InneractiveMediationDefs.GENDER_FEMALE, "strokePaint", "g", "Landroid/graphics/ColorFilter;", "h", "Landroid/graphics/BlendModeColorFilter;", "blendModeColorFilter", "i", "I", com.mbridge.msdk.foundation.same.report.j.b, "layerPaint", CampaignEx.JSON_KEY_AD_K, "Z", "gradientIsDirty", "l", "ringPath", "m", "pathIsDirty", D5.q, "F", "gradientRadiusPx", "o", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class j extends Drawable {
    private static final c p = c.TOP_BOTTOM;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b gradientState;

    /* renamed from: b, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: c, reason: from kotlin metadata */
    private final RectF rect;

    /* renamed from: d, reason: from kotlin metadata */
    private final Paint fillPaint;

    /* renamed from: e, reason: from kotlin metadata */
    private Rect padding;

    /* renamed from: f, reason: from kotlin metadata */
    private Paint strokePaint;

    /* renamed from: g, reason: from kotlin metadata */
    private ColorFilter colorFilter;

    /* renamed from: h, reason: from kotlin metadata */
    private BlendModeColorFilter blendModeColorFilter;

    /* renamed from: i, reason: from kotlin metadata */
    private int alpha;

    /* renamed from: j, reason: from kotlin metadata */
    private Paint layerPaint;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean gradientIsDirty;

    /* renamed from: l, reason: from kotlin metadata */
    private Path ringPath;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean pathIsDirty;

    /* renamed from: n, reason: from kotlin metadata */
    private float gradientRadiusPx;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0017\u0010\u001aJ/\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u0017\u0010\u001fJ\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0004\b\u0017\u0010!J\u001d\u0010\u0017\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010$J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010%R\"\u0010(\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u000f\"\u0004\b\u0017\u0010\u0015R(\u0010,\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010&\u0012\u0004\b+\u0010%\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0015R(\u00101\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b-\u0010&\u0012\u0004\b0\u0010%\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0015R\"\u00105\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010&\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010?\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u001aR$\u0010C\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010\u001aR,\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bE\u0010G\"\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010U\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010&\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0015R\"\u0010Z\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010!R\"\u0010^\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010!R\"\u0010 \u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010V\u001a\u0004\b`\u0010X\"\u0004\ba\u0010!R$\u0010e\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010L\u001a\u0004\bc\u0010N\"\u0004\bd\u0010PR$\u0010m\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010&\u001a\u0004\bo\u0010\u000f\"\u0004\bp\u0010\u0015R\"\u0010r\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010&\u001a\u0004\b[\u0010\u000f\"\u0004\bq\u0010\u0015R\"\u0010t\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010V\u001a\u0004\bb\u0010X\"\u0004\bs\u0010!R\"\u0010w\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010V\u001a\u0004\bu\u0010X\"\u0004\bv\u0010!R\"\u0010y\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010&\u001a\u0004\b_\u0010\u000f\"\u0004\bx\u0010\u0015R\"\u0010|\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010&\u001a\u0004\bz\u0010\u000f\"\u0004\b{\u0010\u0015R$\u0010\u0081\u0001\u001a\u00020}8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b)\u0010~\u001a\u0004\b@\u0010\u007f\"\u0005\b\u0017\u0010\u0080\u0001R$\u0010\u0083\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b<\u0010V\u001a\u0004\b-\u0010X\"\u0005\b\u0082\u0001\u0010!R$\u0010\u0085\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bA\u0010V\u001a\u0004\b2\u0010X\"\u0005\b\u0084\u0001\u0010!R#\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\\\u0010V\u001a\u0004\bK\u0010X\"\u0005\b\u0086\u0001\u0010!R+\u0010\u0089\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u001a\n\u0004\bW\u0010&\u0012\u0005\b\u0088\u0001\u0010%\u001a\u0004\bR\u0010\u000f\"\u0005\b\u0087\u0001\u0010\u0015R%\u0010\u008b\u0001\u001a\u00020}8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bS\u0010~\u001a\u0004\bg\u0010\u007f\"\u0006\b\u008a\u0001\u0010\u0080\u0001R%\u0010\u008d\u0001\u001a\u00020}8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bz\u0010~\u001a\u0004\bn\u0010\u007f\"\u0006\b\u008c\u0001\u0010\u0080\u0001R&\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bu\u0010;\u001a\u0005\b\u008e\u0001\u0010=\"\u0004\b\u0014\u0010\u001aR*\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u008e\u0001\u0010\u0091\u0001\u001a\u0005\b\u0014\u0010\u0092\u0001\"\u0005\b\u0017\u0010\u0093\u0001¨\u0006\u0095\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/j$b;", "Landroid/graphics/drawable/Drawable$ConstantState;", "Lio/bidmachine/rendering/internal/j$c;", "orientation", "", "gradientColors", "<init>", "(Lio/bidmachine/rendering/internal/j$c;[I)V", "originalGradientState", "(Lio/bidmachine/rendering/internal/j$b;)V", "Landroid/graphics/drawable/Drawable;", "newDrawable", "()Landroid/graphics/drawable/Drawable;", "", "getChangingConfigurations", "()I", InneractiveMediationDefs.GENDER_FEMALE, "()[I", "gradient", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(I)V", "colors", "a", "([I)V", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "widthPx", "", "dashWidthPx", "dashGapPx", "(ILandroid/content/res/ColorStateList;FF)V", "radiusPx", "(F)V", "gradientRadius", "type", "(FI)V", "()V", "I", "e", "changingConfigurationsParam", "v", "setShape", "getShape$annotations", "shape", "c", CampaignEx.JSON_KEY_AD_K, "setGradientType", "getGradientType$annotations", "gradientType", "d", "getAngle", "setAngle", "angle", "Lio/bidmachine/rendering/internal/j$c;", CampaignEx.JSON_KEY_AD_Q, "()Lio/bidmachine/rendering/internal/j$c;", "setOrientation", "(Lio/bidmachine/rendering/internal/j$c;)V", "Landroid/content/res/ColorStateList;", "w", "()Landroid/content/res/ColorStateList;", "setSolidColors", "solidColors", "g", VastAttributes.HORIZONTAL_POSITION, "setStrokeColors", "strokeColors", "", "h", "[Landroid/content/res/ColorStateList;", "()[Landroid/content/res/ColorStateList;", "setGradientColors", "([Landroid/content/res/ColorStateList;)V", "", "i", "[F", "s", "()[F", "setPositions", "([F)V", "positions", com.mbridge.msdk.foundation.same.report.j.b, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setStrokeWidthPx", "strokeWidthPx", "F", "z", "()F", "setStrokeDashWidthPx", "strokeDashWidthPx", "l", VastAttributes.VERTICAL_POSITION, "setStrokeDashGapPx", "strokeDashGapPx", "m", "t", "setRadiusPx", D5.q, "u", "setRadiusPxArray", "radiusPxArray", "Landroid/graphics/Rect;", "o", "Landroid/graphics/Rect;", "r", "()Landroid/graphics/Rect;", "setPadding", "(Landroid/graphics/Rect;)V", VastAttributes.PADDING, "p", ExifInterface.LONGITUDE_EAST, "setWidthPx", "setHeightPx", "heightPx", "setInnerRadiusRatio", "innerRadiusRatio", "C", "setThicknessRatio", "thicknessRatio", "setInnerRadiusPx", "innerRadiusPx", "B", "setThicknessPx", "thicknessPx", "", "Z", "()Z", "(Z)V", "dither", "setCenterX", "centerX", "setCenterY", "centerY", "setGradientRadius", "setGradientRadiusType", "getGradientRadiusType$annotations", "gradientRadiusType", "setOpaqueOverBounds", "opaqueOverBounds", "setOpaqueOverShape", "opaqueOverShape", "D", "tint", "Landroid/graphics/BlendMode;", "Landroid/graphics/BlendMode;", "()Landroid/graphics/BlendMode;", "(Landroid/graphics/BlendMode;)V", "blendMode", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Drawable.ConstantState {

        /* renamed from: A, reason: from kotlin metadata */
        private boolean opaqueOverBounds;

        /* renamed from: B, reason: from kotlin metadata */
        private boolean opaqueOverShape;

        /* renamed from: C, reason: from kotlin metadata */
        private ColorStateList tint;

        /* renamed from: D, reason: from kotlin metadata */
        private BlendMode blendMode;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int changingConfigurationsParam;

        /* renamed from: b, reason: from kotlin metadata */
        private int shape;

        /* renamed from: c, reason: from kotlin metadata */
        private int gradientType;

        /* renamed from: d, reason: from kotlin metadata */
        private int angle;

        /* renamed from: e, reason: from kotlin metadata */
        private c orientation;

        /* renamed from: f, reason: from kotlin metadata */
        private ColorStateList solidColors;

        /* renamed from: g, reason: from kotlin metadata */
        private ColorStateList strokeColors;

        /* renamed from: h, reason: from kotlin metadata */
        private ColorStateList[] gradientColors;

        /* renamed from: i, reason: from kotlin metadata */
        private float[] positions;

        /* renamed from: j, reason: from kotlin metadata */
        private int strokeWidthPx;

        /* renamed from: k, reason: from kotlin metadata */
        private float strokeDashWidthPx;

        /* renamed from: l, reason: from kotlin metadata */
        private float strokeDashGapPx;

        /* renamed from: m, reason: from kotlin metadata */
        private float radiusPx;

        /* renamed from: n, reason: from kotlin metadata */
        private float[] radiusPxArray;

        /* renamed from: o, reason: from kotlin metadata */
        private Rect padding;

        /* renamed from: p, reason: from kotlin metadata */
        private int widthPx;

        /* renamed from: q, reason: from kotlin metadata */
        private int heightPx;

        /* renamed from: r, reason: from kotlin metadata */
        private float innerRadiusRatio;

        /* renamed from: s, reason: from kotlin metadata */
        private float thicknessRatio;

        /* renamed from: t, reason: from kotlin metadata */
        private int innerRadiusPx;

        /* renamed from: u, reason: from kotlin metadata */
        private int thicknessPx;

        /* renamed from: v, reason: from kotlin metadata */
        private boolean dither;

        /* renamed from: w, reason: from kotlin metadata */
        private float centerX;

        /* renamed from: x, reason: from kotlin metadata */
        private float centerY;

        /* renamed from: y, reason: from kotlin metadata */
        private float gradientRadius;

        /* renamed from: z, reason: from kotlin metadata */
        private int gradientRadiusType;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/res/ColorStateList;", "it", "", "a", "(Landroid/content/res/ColorStateList;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1})
        static final class a extends Lambda implements Function1<ColorStateList, Integer> {

            /* renamed from: a, reason: collision with root package name */
            public static final a f7075a = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(ColorStateList colorStateList) {
                if (colorStateList != null) {
                    return Integer.valueOf(colorStateList.getDefaultColor());
                }
                return null;
            }
        }

        public b(c orientation, int[] iArr) {
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            this.strokeWidthPx = -1;
            this.widthPx = -1;
            this.heightPx = -1;
            this.innerRadiusRatio = 3.0f;
            this.thicknessRatio = 9.0f;
            this.innerRadiusPx = -1;
            this.thicknessPx = -1;
            this.centerX = 0.5f;
            this.centerY = 0.5f;
            this.gradientRadius = 0.5f;
            this.blendMode = Build.VERSION.SDK_INT >= 29 ? BlendMode.SRC_IN : null;
            this.orientation = orientation;
            a(iArr);
        }

        /* renamed from: A, reason: from getter */
        public final int getStrokeWidthPx() {
            return this.strokeWidthPx;
        }

        /* renamed from: B, reason: from getter */
        public final int getThicknessPx() {
            return this.thicknessPx;
        }

        /* renamed from: C, reason: from getter */
        public final float getThicknessRatio() {
            return this.thicknessRatio;
        }

        /* renamed from: D, reason: from getter */
        public final ColorStateList getTint() {
            return this.tint;
        }

        /* renamed from: E, reason: from getter */
        public final int getWidthPx() {
            return this.widthPx;
        }

        public final void a(int i) {
            this.changingConfigurationsParam = i;
        }

        public final void b(ColorStateList colorStateList) {
            this.tint = colorStateList;
        }

        /* renamed from: c, reason: from getter */
        public final float getCenterX() {
            return this.centerX;
        }

        /* renamed from: d, reason: from getter */
        public final float getCenterY() {
            return this.centerY;
        }

        /* renamed from: e, reason: from getter */
        public final int getChangingConfigurationsParam() {
            return this.changingConfigurationsParam;
        }

        public final int[] f() {
            ColorStateList[] colorStateListArr = this.gradientColors;
            if (colorStateListArr != null) {
                return k.a(colorStateListArr, a.f7075a);
            }
            return null;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getDither() {
            return this.dither;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.changingConfigurationsParam;
            ColorStateList colorStateList = this.strokeColors;
            int changingConfigurations = i | (colorStateList != null ? colorStateList.getChangingConfigurations() : 0);
            ColorStateList colorStateList2 = this.solidColors;
            int changingConfigurations2 = changingConfigurations | (colorStateList2 != null ? colorStateList2.getChangingConfigurations() : 0);
            ColorStateList colorStateList3 = this.tint;
            return changingConfigurations2 | (colorStateList3 != null ? colorStateList3.getChangingConfigurations() : 0);
        }

        /* renamed from: h, reason: from getter */
        public final ColorStateList[] getGradientColors() {
            return this.gradientColors;
        }

        /* renamed from: i, reason: from getter */
        public final float getGradientRadius() {
            return this.gradientRadius;
        }

        /* renamed from: j, reason: from getter */
        public final int getGradientRadiusType() {
            return this.gradientRadiusType;
        }

        /* renamed from: k, reason: from getter */
        public final int getGradientType() {
            return this.gradientType;
        }

        /* renamed from: l, reason: from getter */
        public final int getHeightPx() {
            return this.heightPx;
        }

        /* renamed from: m, reason: from getter */
        public final int getInnerRadiusPx() {
            return this.innerRadiusPx;
        }

        /* renamed from: n, reason: from getter */
        public final float getInnerRadiusRatio() {
            return this.innerRadiusRatio;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j(this, (DefaultConstructorMarker) null);
        }

        /* renamed from: o, reason: from getter */
        public final boolean getOpaqueOverBounds() {
            return this.opaqueOverBounds;
        }

        /* renamed from: p, reason: from getter */
        public final boolean getOpaqueOverShape() {
            return this.opaqueOverShape;
        }

        /* renamed from: q, reason: from getter */
        public final c getOrientation() {
            return this.orientation;
        }

        /* renamed from: r, reason: from getter */
        public final Rect getPadding() {
            return this.padding;
        }

        /* renamed from: s, reason: from getter */
        public final float[] getPositions() {
            return this.positions;
        }

        /* renamed from: t, reason: from getter */
        public final float getRadiusPx() {
            return this.radiusPx;
        }

        /* renamed from: u, reason: from getter */
        public final float[] getRadiusPxArray() {
            return this.radiusPxArray;
        }

        /* renamed from: v, reason: from getter */
        public final int getShape() {
            return this.shape;
        }

        /* renamed from: w, reason: from getter */
        public final ColorStateList getSolidColors() {
            return this.solidColors;
        }

        /* renamed from: x, reason: from getter */
        public final ColorStateList getStrokeColors() {
            return this.strokeColors;
        }

        /* renamed from: y, reason: from getter */
        public final float getStrokeDashGapPx() {
            return this.strokeDashGapPx;
        }

        /* renamed from: z, reason: from getter */
        public final float getStrokeDashWidthPx() {
            return this.strokeDashWidthPx;
        }

        public final void a(boolean z) {
            this.dither = z;
        }

        /* renamed from: b, reason: from getter */
        public final BlendMode getBlendMode() {
            return this.blendMode;
        }

        public final void a(BlendMode blendMode) {
            this.blendMode = blendMode;
        }

        public final void b(int gradient) {
            this.gradientType = gradient;
        }

        public final void a(int[] colors) {
            ColorStateList[] colorStateListArr;
            if (colors != null) {
                colorStateListArr = this.gradientColors;
                if (colorStateListArr == null || colorStateListArr.length != colors.length) {
                    colorStateListArr = new ColorStateList[colors.length];
                }
                int length = colors.length;
                for (int i = 0; i < length; i++) {
                    ColorStateList valueOf = ColorStateList.valueOf(colors[i]);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(it)");
                    colorStateListArr[i] = valueOf;
                }
            } else {
                colorStateListArr = null;
            }
            this.gradientColors = colorStateListArr;
            this.solidColors = null;
            a();
        }

        public final void a(ColorStateList colors) {
            this.gradientColors = null;
            this.solidColors = colors;
            a();
        }

        public final void a(int widthPx, ColorStateList colors, float dashWidthPx, float dashGapPx) {
            this.strokeWidthPx = widthPx;
            this.strokeColors = colors;
            this.strokeDashWidthPx = dashWidthPx;
            this.strokeDashGapPx = dashGapPx;
            a();
        }

        public final void a(float radiusPx) {
            if (radiusPx < 0.0f) {
                radiusPx = 0.0f;
            }
            this.radiusPx = radiusPx;
            this.radiusPxArray = null;
            a();
        }

        public b(b originalGradientState) {
            Intrinsics.checkNotNullParameter(originalGradientState, "originalGradientState");
            this.strokeWidthPx = -1;
            this.widthPx = -1;
            this.heightPx = -1;
            this.innerRadiusRatio = 3.0f;
            this.thicknessRatio = 9.0f;
            this.innerRadiusPx = -1;
            this.thicknessPx = -1;
            this.centerX = 0.5f;
            this.centerY = 0.5f;
            this.gradientRadius = 0.5f;
            this.blendMode = Build.VERSION.SDK_INT >= 29 ? BlendMode.SRC_IN : null;
            this.changingConfigurationsParam = originalGradientState.changingConfigurationsParam;
            this.shape = originalGradientState.shape;
            this.gradientType = originalGradientState.gradientType;
            this.angle = originalGradientState.angle;
            this.orientation = originalGradientState.orientation;
            this.solidColors = originalGradientState.solidColors;
            this.strokeColors = originalGradientState.strokeColors;
            ColorStateList[] colorStateListArr = originalGradientState.gradientColors;
            if (colorStateListArr != null) {
                this.gradientColors = (ColorStateList[]) colorStateListArr.clone();
            }
            float[] fArr = originalGradientState.positions;
            if (fArr != null) {
                this.positions = (float[]) fArr.clone();
            }
            this.strokeWidthPx = originalGradientState.strokeWidthPx;
            this.strokeDashWidthPx = originalGradientState.strokeDashWidthPx;
            this.strokeDashGapPx = originalGradientState.strokeDashGapPx;
            this.radiusPx = originalGradientState.radiusPx;
            float[] fArr2 = originalGradientState.radiusPxArray;
            if (fArr2 != null) {
                this.radiusPxArray = (float[]) fArr2.clone();
            }
            Rect rect = originalGradientState.padding;
            if (rect != null) {
                this.padding = new Rect(rect);
            }
            this.widthPx = originalGradientState.widthPx;
            this.heightPx = originalGradientState.heightPx;
            this.innerRadiusRatio = originalGradientState.innerRadiusRatio;
            this.thicknessRatio = originalGradientState.thicknessRatio;
            this.innerRadiusPx = originalGradientState.innerRadiusPx;
            this.thicknessPx = originalGradientState.thicknessPx;
            this.dither = originalGradientState.dither;
            this.centerX = originalGradientState.centerX;
            this.centerY = originalGradientState.centerY;
            this.gradientRadius = originalGradientState.gradientRadius;
            this.gradientRadiusType = originalGradientState.gradientRadiusType;
            this.opaqueOverBounds = originalGradientState.opaqueOverBounds;
            this.opaqueOverShape = originalGradientState.opaqueOverShape;
            this.tint = originalGradientState.tint;
            this.blendMode = originalGradientState.blendMode;
        }

        public final void a(float gradientRadius, int type) {
            this.gradientRadius = gradientRadius;
            this.gradientRadiusType = type;
        }

        public final void a() {
            Boolean bool;
            boolean z;
            boolean z2 = false;
            this.opaqueOverBounds = false;
            this.opaqueOverShape = false;
            ColorStateList[] colorStateListArr = this.gradientColors;
            if (colorStateListArr == null && this.solidColors == null) {
                return;
            }
            if (colorStateListArr != null) {
                int length = colorStateListArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        ColorStateList colorStateList = colorStateListArr[i];
                        if (colorStateList != null && !k.a(colorStateList.getDefaultColor())) {
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        z = false;
                        break;
                    }
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return;
            }
            this.opaqueOverShape = true;
            if (this.shape == 0 && this.radiusPx <= 0.0f && this.radiusPxArray == null) {
                z2 = true;
            }
            this.opaqueOverBounds = z2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lio/bidmachine/rendering/internal/j$c;", "", "<init>", "(Ljava/lang/String;I)V", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "h", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum c {
        TOP_BOTTOM,
        TR_BL,
        RIGHT_LEFT,
        BR_TL,
        BOTTOM_TOP,
        BL_TR,
        LEFT_RIGHT,
        TL_BR
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[c.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[c.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[c.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[c.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ j(b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar);
    }

    private final void b(int widthPx, int color, float dashWidthPx, float dashGapPx) {
        Paint paint = this.strokePaint;
        if (paint == null) {
            paint = new Paint(1);
            this.strokePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
        }
        paint.setStrokeWidth(widthPx);
        paint.setColor(color);
        paint.setPathEffect(dashWidthPx > 0.0f ? new DashPathEffect(new float[]{dashWidthPx, dashGapPx}, 0.0f) : null);
        this.gradientIsDirty = true;
        invalidateSelf();
    }

    private final void d() {
        b bVar = this.gradientState;
        ColorStateList solidColors = bVar.getSolidColors();
        if (solidColors != null) {
            this.fillPaint.setColor(solidColors.getColorForState(getState(), 0));
        } else if (bVar.getGradientColors() == null) {
            this.fillPaint.setColor(0);
        } else {
            this.fillPaint.setColor(-16777216);
        }
        this.padding = bVar.getPadding();
        int strokeWidthPx = bVar.getStrokeWidthPx();
        if (strokeWidthPx >= 0) {
            Paint paint = this.strokePaint;
            if (paint == null) {
                paint = new Paint(1);
                this.strokePaint = paint;
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(strokeWidthPx);
            }
            ColorStateList strokeColors = bVar.getStrokeColors();
            if (strokeColors != null) {
                paint.setColor(strokeColors.getColorForState(getState(), 0));
            }
            float strokeDashWidthPx = bVar.getStrokeDashWidthPx();
            if (strokeDashWidthPx != 0.0f) {
                paint.setPathEffect(new DashPathEffect(new float[]{strokeDashWidthPx, bVar.getStrokeDashGapPx()}, 0.0f));
            }
        }
        this.blendModeColorFilter = a(this.blendModeColorFilter, bVar.getTint(), bVar.getBlendMode());
        this.gradientIsDirty = true;
        bVar.a();
    }

    public final void a(float radiusPx) {
        this.gradientState.a(radiusPx);
        this.pathIsDirty = true;
        invalidateSelf();
    }

    public final void c(int gradient) {
        this.gradientState.b(gradient);
        this.gradientIsDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        Paint paint5;
        Paint paint6;
        Paint paint7;
        Paint paint8;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (b()) {
            int alpha = this.fillPaint.getAlpha();
            Paint paint9 = this.strokePaint;
            int alpha2 = paint9 != null ? paint9.getAlpha() : 0;
            int a2 = a(alpha);
            int a3 = a(alpha2);
            Paint paint10 = this.strokePaint;
            float strokeWidth = paint10 != null ? paint10.getStrokeWidth() : 0.0f;
            boolean z = a3 > 0 && strokeWidth > 0.0f;
            boolean z2 = a2 > 0;
            b bVar = this.gradientState;
            ColorFilter colorFilter = this.colorFilter;
            if (colorFilter == null) {
                colorFilter = this.blendModeColorFilter;
            }
            boolean z3 = z && z2 && bVar.getShape() != 2 && a3 < 255 && (this.alpha < 255 || colorFilter != null);
            if (z3) {
                Paint paint11 = this.layerPaint;
                if (paint11 == null) {
                    paint11 = new Paint();
                    this.layerPaint = paint11;
                }
                Paint paint12 = paint11;
                paint12.setDither(bVar.getDither());
                paint12.setAlpha(this.alpha);
                paint12.setColorFilter(colorFilter);
                RectF rectF = this.rect;
                f = 0.0f;
                canvas.saveLayer(rectF.left - strokeWidth, rectF.top - strokeWidth, rectF.right + strokeWidth, strokeWidth + rectF.bottom, paint12);
                this.fillPaint.setColorFilter(null);
                Paint paint13 = this.strokePaint;
                if (paint13 != null) {
                    paint13.setColorFilter(null);
                }
            } else {
                f = 0.0f;
                this.fillPaint.setAlpha(a2);
                this.fillPaint.setDither(bVar.getDither());
                this.fillPaint.setColorFilter(colorFilter);
                if (colorFilter != null && bVar.getSolidColors() == null) {
                    this.fillPaint.setColor(this.alpha << 24);
                }
                if (z && (paint = this.strokePaint) != null) {
                    paint.setAlpha(a3);
                    paint.setDither(bVar.getDither());
                    paint.setColorFilter(colorFilter);
                }
            }
            int shape = bVar.getShape();
            if (shape != 0) {
                if (shape == 1) {
                    canvas.drawOval(this.rect, this.fillPaint);
                    if (z && (paint6 = this.strokePaint) != null) {
                        canvas.drawOval(this.rect, paint6);
                    }
                } else if (shape == 2) {
                    RectF rectF2 = this.rect;
                    float centerY = rectF2.centerY();
                    if (z && (paint7 = this.strokePaint) != null) {
                        canvas.drawLine(rectF2.left, centerY, rectF2.right, centerY, paint7);
                    }
                } else if (shape == 3) {
                    Path a4 = a(bVar);
                    canvas.drawPath(a4, this.fillPaint);
                    if (z && (paint8 = this.strokePaint) != null) {
                        canvas.drawPath(a4, paint8);
                    }
                }
            } else if (bVar.getRadiusPxArray() != null) {
                a();
                canvas.drawPath(this.path, this.fillPaint);
                if (z && (paint4 = this.strokePaint) != null) {
                    canvas.drawPath(this.path, paint4);
                }
            } else if (bVar.getRadiusPx() > f) {
                float min = (float) Math.min(bVar.getRadiusPx(), Math.min(this.rect.width(), this.rect.height()) * 0.5f);
                canvas.drawRoundRect(this.rect, min, min, this.fillPaint);
                if (z && (paint3 = this.strokePaint) != null) {
                    canvas.drawRoundRect(this.rect, min, min, paint3);
                }
            } else {
                if (this.fillPaint.getColor() != 0 || colorFilter != null || this.fillPaint.getShader() != null) {
                    canvas.drawRect(this.rect, this.fillPaint);
                }
                if (z && (paint2 = this.strokePaint) != null) {
                    canvas.drawRect(this.rect, paint2);
                }
            }
            if (z3) {
                canvas.restore();
                return;
            }
            this.fillPaint.setAlpha(alpha);
            if (!z || (paint5 = this.strokePaint) == null) {
                return;
            }
            paint5.setAlpha(alpha2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.gradientState.getChangingConfigurationsParam();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        b bVar = this.gradientState;
        bVar.a(getChangingConfigurations());
        return bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.gradientState.getHeightPx();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.gradientState.getWidthPx();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return (this.alpha == 255 && this.gradientState.getOpaqueOverBounds() && c()) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        b bVar = this.gradientState;
        Paint paint = this.strokePaint;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds()");
        outline.setAlpha((bVar.getOpaqueOverShape() && (this.gradientState.getStrokeWidthPx() <= 0 || paint == null || paint.getAlpha() == this.fillPaint.getAlpha())) ? a(this.fillPaint.getAlpha()) / 255.0f : 0.0f);
        int shape = bVar.getShape();
        if (shape != 0) {
            if (shape == 1) {
                outline.setOval(bounds);
                return;
            } else {
                if (shape != 2) {
                    return;
                }
                float strokeWidth = paint != null ? paint.getStrokeWidth() * 0.5f : 1.0E-4f;
                float centerY = bounds.centerY();
                outline.setRect(bounds.left, (int) Math.floor(centerY - strokeWidth), bounds.right, (int) Math.ceil(centerY + strokeWidth));
                return;
            }
        }
        float[] radiusPxArray = bVar.getRadiusPxArray();
        if (radiusPxArray == null) {
            outline.setRoundRect(bounds, bVar.getRadiusPx() > 0.0f ? (float) Math.min(bVar.getRadiusPx(), Math.min(bounds.width(), bounds.height()) * 0.5f) : 0.0f);
            return;
        }
        a();
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.path);
        } else {
            outline.setRoundRect(bounds, ArraysKt.sum(radiusPxArray));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Rect rect = this.padding;
        if (rect == null) {
            return super.getPadding(padding);
        }
        padding.set(rect);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList solidColors;
        ColorStateList strokeColors;
        ColorStateList tint;
        b bVar = this.gradientState;
        return super.isStateful() || ((solidColors = bVar.getSolidColors()) != null && solidColors.isStateful()) || (((strokeColors = bVar.getStrokeColors()) != null && strokeColors.isStateful()) || ((tint = bVar.getTint()) != null && tint.isStateful()));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (super.mutate() == this) {
            this.gradientState = new b(this.gradientState);
            d();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        super.onBoundsChange(rect);
        this.ringPath = null;
        this.pathIsDirty = true;
        this.gradientIsDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        super.onLevelChange(level);
        this.gradientIsDirty = true;
        this.pathIsDirty = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] stateSet) {
        boolean z;
        ColorStateList strokeColors;
        int colorForState;
        int colorForState2;
        Intrinsics.checkNotNullParameter(stateSet, "stateSet");
        b bVar = this.gradientState;
        ColorStateList solidColors = bVar.getSolidColors();
        if (solidColors == null || this.fillPaint.getColor() == (colorForState2 = solidColors.getColorForState(stateSet, 0))) {
            z = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z = true;
        }
        Paint paint = this.strokePaint;
        if (paint != null && (strokeColors = bVar.getStrokeColors()) != null && paint.getColor() != (colorForState = strokeColors.getColorForState(stateSet, 0))) {
            paint.setColor(colorForState);
            z = true;
        }
        if (bVar.getTint() != null && bVar.getBlendMode() != null) {
            this.blendModeColorFilter = a(this.blendModeColorFilter, bVar.getTint(), bVar.getBlendMode());
            z = true;
        }
        if (!z) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.alpha != alpha) {
            this.alpha = alpha;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public void setDither(boolean dither) {
        if (this.gradientState.getDither() != dither) {
            this.gradientState.a(dither);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode blendMode) {
        this.gradientState.a(blendMode);
        this.blendModeColorFilter = a(this.blendModeColorFilter, this.gradientState.getTint(), blendMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        this.gradientState.b(tint);
        this.blendModeColorFilter = a(this.blendModeColorFilter, tint, this.gradientState.getBlendMode());
        invalidateSelf();
    }

    public j() {
        this(new b(p, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(c orientation, int[] iArr) {
        this(new b(orientation, iArr));
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    private j(b bVar) {
        this.path = new Path();
        this.rect = new RectF();
        this.fillPaint = new Paint(1);
        this.alpha = 255;
        this.pathIsDirty = true;
        this.gradientState = bVar;
        d();
    }

    public static /* synthetic */ void a(j jVar, int i, int i2, float f, float f2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f2 = 0.0f;
        }
        jVar.a(i, i2, f, f2);
    }

    private final boolean c() {
        Paint paint = this.strokePaint;
        if (this.gradientState.getStrokeWidthPx() < 0 || paint == null || k.a(paint.getColor())) {
            return this.gradientState.getGradientColors() != null || k.a(this.fillPaint.getColor());
        }
        return false;
    }

    public final void a(int widthPx, int color, float dashWidthPx, float dashGapPx) {
        this.gradientState.a(widthPx, ColorStateList.valueOf(color), dashWidthPx, dashGapPx);
        b(widthPx, color, dashWidthPx, dashGapPx);
    }

    public static /* synthetic */ void a(j jVar, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.5f;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        jVar.a(f, i);
    }

    public final void b(int argb) {
        this.gradientState.a(ColorStateList.valueOf(argb));
        this.fillPaint.setColor(argb);
        invalidateSelf();
    }

    public final void a(float gradientRadius, int radiusType) {
        this.gradientState.a(gradientRadius, radiusType);
        this.gradientIsDirty = true;
        invalidateSelf();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0054. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b() {
        double min;
        float width;
        float height;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (this.gradientIsDirty) {
            this.gradientIsDirty = false;
            Paint paint = this.strokePaint;
            Intrinsics.checkNotNullExpressionValue(getBounds(), "getBounds()");
            float strokeWidth = paint != null ? paint.getStrokeWidth() * 0.5f : 0.0f;
            b bVar = this.gradientState;
            this.rect.set(r3.left + strokeWidth, r3.top + strokeWidth, r3.right - strokeWidth, r3.bottom - strokeWidth);
            int[] f15 = bVar.f();
            if (f15 != null) {
                RectF rectF = this.rect;
                if (bVar.getGradientType() == 0) {
                    switch (d.$EnumSwitchMapping$0[bVar.getOrientation().ordinal()]) {
                        case 1:
                            f = rectF.left;
                            f2 = rectF.top;
                            f3 = rectF.bottom;
                            f11 = f3 * 1.0f;
                            f12 = f;
                            f13 = f12;
                            f14 = f2;
                            break;
                        case 2:
                            f4 = rectF.right;
                            f5 = rectF.top;
                            f6 = rectF.left * 1.0f;
                            f7 = rectF.bottom;
                            f11 = f7 * 1.0f;
                            f12 = f4;
                            f14 = f5;
                            f13 = f6;
                            break;
                        case 3:
                            f8 = rectF.right;
                            f9 = rectF.top;
                            f10 = rectF.left;
                            f13 = f10 * 1.0f;
                            f12 = f8;
                            f14 = f9;
                            f11 = f14;
                            break;
                        case 4:
                            f4 = rectF.right;
                            f5 = rectF.bottom;
                            f6 = rectF.left * 1.0f;
                            f7 = rectF.top;
                            f11 = f7 * 1.0f;
                            f12 = f4;
                            f14 = f5;
                            f13 = f6;
                            break;
                        case 5:
                            f = rectF.left;
                            f2 = rectF.bottom;
                            f3 = rectF.top;
                            f11 = f3 * 1.0f;
                            f12 = f;
                            f13 = f12;
                            f14 = f2;
                            break;
                        case 6:
                            f4 = rectF.left;
                            f5 = rectF.bottom;
                            f6 = rectF.right * 1.0f;
                            f7 = rectF.top;
                            f11 = f7 * 1.0f;
                            f12 = f4;
                            f14 = f5;
                            f13 = f6;
                            break;
                        case 7:
                            f8 = rectF.left;
                            f9 = rectF.top;
                            f10 = rectF.right;
                            f13 = f10 * 1.0f;
                            f12 = f8;
                            f14 = f9;
                            f11 = f14;
                            break;
                        default:
                            f4 = rectF.left;
                            f5 = rectF.top;
                            f6 = rectF.right * 1.0f;
                            f7 = rectF.bottom;
                            f11 = f7 * 1.0f;
                            f12 = f4;
                            f14 = f5;
                            f13 = f6;
                            break;
                    }
                    this.fillPaint.setShader(new LinearGradient(f12, f14, f13, f11, f15, bVar.getPositions(), Shader.TileMode.CLAMP));
                } else if (bVar.getGradientType() == 1) {
                    float f16 = rectF.left;
                    float centerX = f16 + ((rectF.right - f16) * bVar.getCenterX());
                    float f17 = rectF.top;
                    float centerY = f17 + ((rectF.bottom - f17) * bVar.getCenterY());
                    float gradientRadius = bVar.getGradientRadius();
                    if (bVar.getGradientRadiusType() == 1) {
                        if (bVar.getWidthPx() >= 0) {
                            width = bVar.getWidthPx();
                        } else {
                            width = rectF.width();
                        }
                        if (bVar.getHeightPx() >= 0) {
                            height = bVar.getHeightPx();
                        } else {
                            height = rectF.height();
                        }
                        min = Math.min(width, height);
                    } else {
                        if (bVar.getGradientRadiusType() == 2) {
                            min = Math.min(rectF.width(), rectF.height());
                        }
                        this.gradientRadiusPx = gradientRadius;
                        if (gradientRadius <= 0.0f) {
                            gradientRadius = 0.001f;
                        }
                        this.fillPaint.setShader(new RadialGradient(centerX, centerY, gradientRadius, f15, (float[]) null, Shader.TileMode.CLAMP));
                    }
                    gradientRadius *= (float) min;
                    this.gradientRadiusPx = gradientRadius;
                    if (gradientRadius <= 0.0f) {
                    }
                    this.fillPaint.setShader(new RadialGradient(centerX, centerY, gradientRadius, f15, (float[]) null, Shader.TileMode.CLAMP));
                } else if (bVar.getGradientType() == 2) {
                    float f18 = rectF.left;
                    float centerX2 = f18 + ((rectF.right - f18) * bVar.getCenterX());
                    float f19 = rectF.top;
                    this.fillPaint.setShader(new SweepGradient(centerX2, f19 + ((rectF.bottom - f19) * bVar.getCenterY()), f15, (float[]) null));
                }
                if (bVar.getSolidColors() == null) {
                    this.fillPaint.setColor(-16777216);
                }
            }
        }
        return !this.rect.isEmpty();
    }

    private final int a(int alpha) {
        int i = this.alpha;
        return (alpha * (i + (i >> 7))) >> 8;
    }

    private final void a() {
        b bVar = this.gradientState;
        if (this.pathIsDirty) {
            b();
            this.path.reset();
            float[] radiusPxArray = bVar.getRadiusPxArray();
            if (radiusPxArray != null) {
                this.path.addRoundRect(this.rect, radiusPxArray, Path.Direction.CW);
            }
            this.pathIsDirty = false;
        }
    }

    private final Path a(b gradientState) {
        float width;
        float width2;
        Path path = this.ringPath;
        if (path != null && !this.pathIsDirty) {
            return path;
        }
        this.pathIsDirty = false;
        float level = (getLevel() * 360.0f) / 10000.0f;
        RectF rectF = new RectF(this.rect);
        float width3 = rectF.width() / 2.0f;
        float height = rectF.height() / 2.0f;
        if (gradientState.getThicknessPx() != -1) {
            width = gradientState.getThicknessPx();
        } else {
            width = rectF.width() / gradientState.getThicknessRatio();
        }
        if (gradientState.getInnerRadiusPx() != -1) {
            width2 = gradientState.getInnerRadiusPx();
        } else {
            width2 = rectF.width() / gradientState.getInnerRadiusRatio();
        }
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(width3 - width2, height - width2);
        RectF rectF3 = new RectF(rectF2);
        float f = -width;
        rectF3.inset(f, f);
        Path path2 = this.ringPath;
        if (path2 != null) {
            path2.reset();
        } else {
            path2 = new Path();
            this.ringPath = path2;
        }
        if (level < 360.0f && level > -360.0f) {
            path2.setFillType(Path.FillType.EVEN_ODD);
            float f2 = width3 + width2;
            path2.moveTo(f2, height);
            path2.lineTo(f2 + width, height);
            path2.arcTo(rectF3, 0.0f, level, false);
            path2.arcTo(rectF2, level, -level, false);
            path2.close();
        } else {
            path2.addOval(rectF3, Path.Direction.CW);
            path2.addOval(rectF2, Path.Direction.CCW);
        }
        path2.addOval(rectF3, Path.Direction.CW);
        path2.addOval(rectF2, Path.Direction.CCW);
        return path2;
    }

    private final BlendModeColorFilter a(BlendModeColorFilter blendFilter, ColorStateList tint, BlendMode blendMode) {
        if (tint == null || blendMode == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return blendFilter;
        }
        int colorForState = tint.getColorForState(getState(), 0);
        return (blendFilter != null && blendFilter.getColor() == colorForState && blendFilter.getMode() == blendMode) ? blendFilter : new BlendModeColorFilter(colorForState, blendMode);
    }
}
