package io.bidmachine.rendering.model;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.util.UtilsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b7\u0018\u0000 [2\u00020\u0001:\u0002\\[BÑ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b#\u0010\"J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b)\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u00107R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010=R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\bD\u00105\u001a\u0004\b\u000e\u00107R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\bE\u0010;\u001a\u0004\bF\u0010=R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\bH\u00101R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\bO\u0010;\u001a\u0004\bP\u0010=R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bQ\u0010/\u001a\u0004\bR\u00101R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\bS\u0010;\u001a\u0004\bT\u0010=R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bY\u0010/\u001a\u0004\bZ\u00101¨\u0006]"}, d2 = {"Lio/bidmachine/rendering/model/AppearanceParams;", "", "Lio/bidmachine/rendering/model/Background;", "background", "", "backgroundColor", "", VastAttributes.VISIBLE, "clickable", "", VastAttributes.OPACITY, "fontSize", "Lio/bidmachine/rendering/model/FontStyleType;", "fontStyleType", "isOutlined", "strokeWidth", "strokeColor", "fillColor", "shadowColor", "Lio/bidmachine/rendering/model/Padding;", VastAttributes.PADDING, "cornerRadius", "textMaxLines", "textLineSpacing", "Lio/bidmachine/rendering/model/HorizontalGravity;", "textHorizontalGravity", "<init>", "(Lio/bidmachine/rendering/model/Background;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Lio/bidmachine/rendering/model/FontStyleType;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Padding;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Lio/bidmachine/rendering/model/HorizontalGravity;)V", EventTaskParams.STATE_GROUP_DEFAULT, "getBackgroundOrDefault", "(I)I", "Landroid/content/Context;", "context", "getStrokeWidthPx", "(Landroid/content/Context;)Ljava/lang/Integer;", "getCornerRadiusPx", "getCornerRadiusPxOrDefault", "(Landroid/content/Context;I)I", "Lio/bidmachine/rendering/model/Border;", "getBorder", "(Landroid/content/Context;)Lio/bidmachine/rendering/model/Border;", "getTextLineSpacingPx", "a", "Lio/bidmachine/rendering/model/Background;", "getBackground", "()Lio/bidmachine/rendering/model/Background;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Integer;", "getBackgroundColor", "()Ljava/lang/Integer;", "getBackgroundColor$annotations", "()V", "c", "Ljava/lang/Boolean;", "getVisible", "()Ljava/lang/Boolean;", "d", "getClickable", "e", "Ljava/lang/Float;", "getOpacity", "()Ljava/lang/Float;", InneractiveMediationDefs.GENDER_FEMALE, "getFontSize", "g", "Lio/bidmachine/rendering/model/FontStyleType;", "getFontStyleType", "()Lio/bidmachine/rendering/model/FontStyleType;", "h", "i", "getStrokeWidth", j.b, "getStrokeColor", CampaignEx.JSON_KEY_AD_K, "getShadowColor", "l", "Lio/bidmachine/rendering/model/Padding;", "getPadding", "()Lio/bidmachine/rendering/model/Padding;", "m", "getCornerRadius", D5.q, "getTextMaxLines", "o", "getTextLineSpacing", "p", "Lio/bidmachine/rendering/model/HorizontalGravity;", "getTextHorizontalGravity", "()Lio/bidmachine/rendering/model/HorizontalGravity;", CampaignEx.JSON_KEY_AD_Q, "getFillColor", "Companion", "Builder", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class AppearanceParams {
    private static final HorizontalGravity r = HorizontalGravity.Center;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Background background;

    /* renamed from: b, reason: from kotlin metadata */
    private final Integer backgroundColor;

    /* renamed from: c, reason: from kotlin metadata */
    private final Boolean visible;

    /* renamed from: d, reason: from kotlin metadata */
    private final Boolean clickable;

    /* renamed from: e, reason: from kotlin metadata */
    private final Float opacity;

    /* renamed from: f, reason: from kotlin metadata */
    private final Float fontSize;

    /* renamed from: g, reason: from kotlin metadata */
    private final FontStyleType fontStyleType;

    /* renamed from: h, reason: from kotlin metadata */
    private final Boolean isOutlined;

    /* renamed from: i, reason: from kotlin metadata */
    private final Float strokeWidth;

    /* renamed from: j, reason: from kotlin metadata */
    private final Integer strokeColor;

    /* renamed from: k, reason: from kotlin metadata */
    private final Integer shadowColor;

    /* renamed from: l, reason: from kotlin metadata */
    private final Padding padding;

    /* renamed from: m, reason: from kotlin metadata */
    private final Float cornerRadius;

    /* renamed from: n, reason: from kotlin metadata */
    private final Integer textMaxLines;

    /* renamed from: o, reason: from kotlin metadata */
    private final Float textLineSpacing;

    /* renamed from: p, reason: from kotlin metadata */
    private final HorizontalGravity textHorizontalGravity;

    /* renamed from: q, reason: from kotlin metadata */
    private final Integer fillColor;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001d\u0010\u000fJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001f\u0010\u0015J\u0017\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b%\u0010\u000bJ\u0017\u0010(\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b+\u0010\u0015J\u0017\u0010-\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010/\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b/\u0010\u0015J\u0017\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010=R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0018\u0010F\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010@R\u0018\u0010 \u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010:R\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010:R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010:R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010*\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010@R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010:R\u0018\u0010.\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010@R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "", "<init>", "()V", "Lio/bidmachine/rendering/model/Background;", "background", "setBackground", "(Lio/bidmachine/rendering/model/Background;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "", "backgroundColor", "setBackgroundColor", "(Ljava/lang/Integer;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "", VastAttributes.VISIBLE, "setVisible", "(Ljava/lang/Boolean;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "clickable", "setClickable", "", VastAttributes.OPACITY, "setOpacity", "(Ljava/lang/Float;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "fontSize", "setFontSize", "Lio/bidmachine/rendering/model/FontStyleType;", "fontStyleType", "setFontStyleType", "(Lio/bidmachine/rendering/model/FontStyleType;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "isOutlined", "setOutlined", "strokeWidthDp", "setStrokeWidth", "strokeColor", "setStrokeColor", "fillColor", "setFillColor", "shadowColor", "setShadowColor", "Lio/bidmachine/rendering/model/Padding;", VastAttributes.PADDING, "setPadding", "(Lio/bidmachine/rendering/model/Padding;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "cornerRadius", "setCornerRadius", "textMaxLines", "setTextMaxLines", "textLineSpacing", "setTextLineSpacing", "Lio/bidmachine/rendering/model/HorizontalGravity;", "textHorizontalGravity", "setTextHorizontalGravity", "(Lio/bidmachine/rendering/model/HorizontalGravity;)Lio/bidmachine/rendering/model/AppearanceParams$Builder;", "Lio/bidmachine/rendering/model/AppearanceParams;", "build", "()Lio/bidmachine/rendering/model/AppearanceParams;", "a", "Lio/bidmachine/rendering/model/Background;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Integer;", "getBackgroundColor$annotations", "c", "Ljava/lang/Boolean;", "d", "e", "Ljava/lang/Float;", InneractiveMediationDefs.GENDER_FEMALE, "g", "Lio/bidmachine/rendering/model/FontStyleType;", "h", "i", "strokeWidth", j.b, CampaignEx.JSON_KEY_AD_K, "l", "m", "Lio/bidmachine/rendering/model/Padding;", D5.q, "o", "p", CampaignEx.JSON_KEY_AD_Q, "Lio/bidmachine/rendering/model/HorizontalGravity;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Background background;

        /* renamed from: b, reason: from kotlin metadata */
        private Integer backgroundColor;

        /* renamed from: c, reason: from kotlin metadata */
        private Boolean visible;

        /* renamed from: d, reason: from kotlin metadata */
        private Boolean clickable;

        /* renamed from: e, reason: from kotlin metadata */
        private Float opacity;

        /* renamed from: f, reason: from kotlin metadata */
        private Float fontSize;

        /* renamed from: g, reason: from kotlin metadata */
        private FontStyleType fontStyleType;

        /* renamed from: h, reason: from kotlin metadata */
        private Boolean isOutlined;

        /* renamed from: i, reason: from kotlin metadata */
        private Float strokeWidth;

        /* renamed from: j, reason: from kotlin metadata */
        private Integer strokeColor;

        /* renamed from: k, reason: from kotlin metadata */
        private Integer fillColor;

        /* renamed from: l, reason: from kotlin metadata */
        private Integer shadowColor;

        /* renamed from: m, reason: from kotlin metadata */
        private Padding padding;

        /* renamed from: n, reason: from kotlin metadata */
        private Float cornerRadius;

        /* renamed from: o, reason: from kotlin metadata */
        private Integer textMaxLines;

        /* renamed from: p, reason: from kotlin metadata */
        private Float textLineSpacing;

        /* renamed from: q, reason: from kotlin metadata */
        private HorizontalGravity textHorizontalGravity;

        public final AppearanceParams build() {
            Background background = this.background;
            Integer num = this.backgroundColor;
            Boolean bool = this.visible;
            Boolean bool2 = this.clickable;
            Float f = this.opacity;
            Float f2 = this.fontSize;
            FontStyleType fontStyleType = this.fontStyleType;
            Boolean bool3 = this.isOutlined;
            Float f3 = this.strokeWidth;
            Integer num2 = this.strokeColor;
            Integer num3 = this.fillColor;
            Integer num4 = this.shadowColor;
            Padding padding = this.padding;
            Float f4 = this.cornerRadius;
            Integer num5 = this.textMaxLines;
            Float f5 = this.textLineSpacing;
            HorizontalGravity horizontalGravity = this.textHorizontalGravity;
            if (horizontalGravity == null) {
                horizontalGravity = AppearanceParams.r;
            }
            return new AppearanceParams(background, num, bool, bool2, f, f2, fontStyleType, bool3, f3, num2, num3, num4, padding, f4, num5, f5, horizontalGravity);
        }

        public final Builder setBackground(Background background) {
            this.background = background;
            return this;
        }

        @Deprecated(message = "BackgroundColor has been replaced by the more versatile Background model", replaceWith = @ReplaceWith(expression = "", imports = {"io.bidmachine.rendering.model.Background"}))
        public final Builder setBackgroundColor(Integer backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public final Builder setClickable(Boolean clickable) {
            this.clickable = clickable;
            return this;
        }

        public final Builder setCornerRadius(Float cornerRadius) {
            this.cornerRadius = cornerRadius;
            return this;
        }

        public final Builder setFillColor(Integer fillColor) {
            this.fillColor = fillColor;
            return this;
        }

        public final Builder setFontSize(Float fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public final Builder setFontStyleType(FontStyleType fontStyleType) {
            this.fontStyleType = fontStyleType;
            return this;
        }

        public final Builder setOpacity(Float opacity) {
            this.opacity = opacity;
            return this;
        }

        public final Builder setOutlined(Boolean isOutlined) {
            this.isOutlined = isOutlined;
            return this;
        }

        public final Builder setPadding(Padding padding) {
            this.padding = padding;
            return this;
        }

        public final Builder setShadowColor(Integer shadowColor) {
            this.shadowColor = shadowColor;
            return this;
        }

        public final Builder setStrokeColor(Integer strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public final Builder setStrokeWidth(Float strokeWidthDp) {
            this.strokeWidth = strokeWidthDp;
            return this;
        }

        public final Builder setTextHorizontalGravity(HorizontalGravity textHorizontalGravity) {
            this.textHorizontalGravity = textHorizontalGravity;
            return this;
        }

        public final Builder setTextLineSpacing(Float textLineSpacing) {
            this.textLineSpacing = textLineSpacing;
            return this;
        }

        public final Builder setTextMaxLines(Integer textMaxLines) {
            this.textMaxLines = textMaxLines;
            return this;
        }

        public final Builder setVisible(Boolean visible) {
            this.visible = visible;
            return this;
        }
    }

    public AppearanceParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    @Deprecated(message = "BackgroundColor has been replaced by the more versatile Background model", replaceWith = @ReplaceWith(expression = "", imports = {"io.bidmachine.rendering.model.Background"}))
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static /* synthetic */ int getBackgroundOrDefault$default(AppearanceParams appearanceParams, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return appearanceParams.getBackgroundOrDefault(i);
    }

    public static /* synthetic */ int getCornerRadiusPxOrDefault$default(AppearanceParams appearanceParams, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return appearanceParams.getCornerRadiusPxOrDefault(context, i);
    }

    public final Background getBackground() {
        return this.background;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundOrDefault(int r2) {
        Integer num = this.backgroundColor;
        return num != null ? num.intValue() : r2;
    }

    public final Border getBorder(Context context) {
        Integer strokeWidthPx;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Intrinsics.areEqual(this.isOutlined, Boolean.TRUE) || this.strokeColor == null || (strokeWidthPx = getStrokeWidthPx(context)) == null || strokeWidthPx.intValue() <= 0) {
            return null;
        }
        return new Border(strokeWidthPx.intValue(), this.strokeColor.intValue());
    }

    public final Boolean getClickable() {
        return this.clickable;
    }

    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final Integer getCornerRadiusPx(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float f = this.cornerRadius;
        if (f != null) {
            return Integer.valueOf(UtilsKt.dpToPx(context, f.floatValue()));
        }
        return null;
    }

    public final int getCornerRadiusPxOrDefault(Context context, int r3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float f = this.cornerRadius;
        return f != null ? UtilsKt.dpToPx(context, f.floatValue()) : r3;
    }

    public final Integer getFillColor() {
        return this.fillColor;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final FontStyleType getFontStyleType() {
        return this.fontStyleType;
    }

    public final Float getOpacity() {
        return this.opacity;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final Integer getShadowColor() {
        return this.shadowColor;
    }

    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final Integer getStrokeWidthPx(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float f = this.strokeWidth;
        if (f != null) {
            return Integer.valueOf(UtilsKt.dpToPx(context, f.floatValue()));
        }
        return null;
    }

    public final HorizontalGravity getTextHorizontalGravity() {
        return this.textHorizontalGravity;
    }

    public final Float getTextLineSpacing() {
        return this.textLineSpacing;
    }

    public final Integer getTextLineSpacingPx(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Float f = this.textLineSpacing;
        if (f != null) {
            return Integer.valueOf(UtilsKt.dpToPx(context, f.floatValue()));
        }
        return null;
    }

    public final Integer getTextMaxLines() {
        return this.textMaxLines;
    }

    public final Boolean getVisible() {
        return this.visible;
    }

    /* renamed from: isOutlined, reason: from getter */
    public final Boolean getIsOutlined() {
        return this.isOutlined;
    }

    public AppearanceParams(Background background, Integer num, Boolean bool, Boolean bool2, Float f, Float f2, FontStyleType fontStyleType, Boolean bool3, Float f3, Integer num2, Integer num3, Integer num4, Padding padding, Float f4, Integer num5, Float f5, HorizontalGravity textHorizontalGravity) {
        Intrinsics.checkNotNullParameter(textHorizontalGravity, "textHorizontalGravity");
        this.background = background;
        this.backgroundColor = num;
        this.visible = bool;
        this.clickable = bool2;
        this.opacity = f;
        this.fontSize = f2;
        this.fontStyleType = fontStyleType;
        this.isOutlined = bool3;
        this.strokeWidth = f3;
        this.strokeColor = num2;
        this.shadowColor = num4;
        this.padding = padding;
        this.cornerRadius = f4;
        this.textMaxLines = num5;
        this.textLineSpacing = f5;
        this.textHorizontalGravity = textHorizontalGravity;
        this.fillColor = num3 != null ? num3 : num;
    }

    public /* synthetic */ AppearanceParams(Background background, Integer num, Boolean bool, Boolean bool2, Float f, Float f2, FontStyleType fontStyleType, Boolean bool3, Float f3, Integer num2, Integer num3, Integer num4, Padding padding, Float f4, Integer num5, Float f5, HorizontalGravity horizontalGravity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : background, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : f, (i & 32) != 0 ? null : f2, (i & 64) != 0 ? null : fontStyleType, (i & 128) != 0 ? null : bool3, (i & 256) != 0 ? null : f3, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : num4, (i & 4096) != 0 ? null : padding, (i & 8192) != 0 ? null : f4, (i & 16384) != 0 ? null : num5, (i & 32768) != 0 ? null : f5, (i & 65536) != 0 ? r : horizontalGravity);
    }
}
