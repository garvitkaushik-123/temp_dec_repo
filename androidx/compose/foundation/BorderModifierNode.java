package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Border.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                DrawResult drawContentWithoutBorder;
                DrawResult m541drawRectBorderNsqcLGU;
                DrawResult m544drawRoundRectBorderJqoCqck;
                DrawResult drawGenericBorder;
                if (cacheDrawScope.mo630toPx0680j_4(BorderModifierNode.this.getWidth()) < 0.0f || Size.m3890getMinDimensionimpl(cacheDrawScope.m3729getSizeNHjbRc()) <= 0.0f) {
                    drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
                    return drawContentWithoutBorder;
                }
                float f2 = 2;
                float min = Math.min(Dp.m6394equalsimpl0(BorderModifierNode.this.getWidth(), Dp.INSTANCE.m6407getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo630toPx0680j_4(BorderModifierNode.this.getWidth())), (float) Math.ceil(Size.m3890getMinDimensionimpl(cacheDrawScope.m3729getSizeNHjbRc()) / f2));
                float f3 = min / f2;
                long Offset = OffsetKt.Offset(f3, f3);
                long Size = SizeKt.Size(Size.m3891getWidthimpl(cacheDrawScope.m3729getSizeNHjbRc()) - min, Size.m3888getHeightimpl(cacheDrawScope.m3729getSizeNHjbRc()) - min);
                boolean z = f2 * min > Size.m3890getMinDimensionimpl(cacheDrawScope.m3729getSizeNHjbRc());
                Outline mo577createOutlinePq9zytI = BorderModifierNode.this.getShape().mo577createOutlinePq9zytI(cacheDrawScope.m3729getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (mo577createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = BorderModifierNode.this;
                    drawGenericBorder = borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) mo577createOutlinePq9zytI, z, min);
                    return drawGenericBorder;
                }
                if (mo577createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                    m544drawRoundRectBorderJqoCqck = borderModifierNode2.m544drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) mo577createOutlinePq9zytI, Offset, Size, z, min);
                    return m544drawRoundRectBorderJqoCqck;
                }
                if (!(mo577createOutlinePq9zytI instanceof Outline.Rectangle)) {
                    throw new NoWhenBranchMatchedException();
                }
                m541drawRectBorderNsqcLGU = BorderKt.m541drawRectBorderNsqcLGU(cacheDrawScope, BorderModifierNode.this.getBrush(), Offset, Size, z, min);
                return m541drawRectBorderNsqcLGU;
            }
        }));
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m546setWidth0680j_4(float f) {
        if (Dp.m6394equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d4, code lost:
    
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m4278equalsimpl(r8, r7 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.m4276boximpl(r7.mo3930getConfig_sVssgQ()) : null) != false) goto L27;
     */
    /* JADX WARN: Type inference failed for: r21v2, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) {
        int m4284getArgb8888_sVssgQ;
        ColorFilter colorFilter;
        BorderCache borderCache;
        ImageBitmap imageBitmap;
        Canvas canvas;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    DrawScope.m4602drawPathGBMwjPU$default(contentDrawScope, Outline.Generic.this.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            m4284getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m4283getAlpha8_sVssgQ();
            colorFilter = ColorFilter.Companion.m4104tintxETnrds$default(ColorFilter.INSTANCE, ((SolidColor) brush).getValue(), 0, 2, null);
        } else {
            m4284getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m4284getArgb8888_sVssgQ();
            colorFilter = null;
        }
        int i = m4284getArgb8888_sVssgQ;
        final Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        Path obtainPath = borderCache2.obtainPath();
        obtainPath.reset();
        obtainPath.addRect(bounds);
        obtainPath.mo3955opN5in7k0(obtainPath, generic.getPath(), PathOperation.INSTANCE.m4354getDifferenceb3I0S0c());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final long IntSize = IntSizeKt.IntSize((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()));
        BorderCache borderCache3 = this.borderCache;
        Intrinsics.checkNotNull(borderCache3);
        ImageBitmap imageBitmap2 = borderCache3.imageBitmap;
        Canvas canvas2 = borderCache3.canvas;
        ImageBitmapConfig m4276boximpl = imageBitmap2 != null ? ImageBitmapConfig.m4276boximpl(imageBitmap2.mo3930getConfig_sVssgQ()) : null;
        boolean z2 = false;
        if (!(m4276boximpl == null ? false : ImageBitmapConfig.m4279equalsimpl0(m4276boximpl.m4282unboximpl(), ImageBitmapConfig.INSTANCE.m4284getArgb8888_sVssgQ()))) {
        }
        z2 = true;
        if (imageBitmap2 == null || canvas2 == null || Size.m3891getWidthimpl(cacheDrawScope.m3729getSizeNHjbRc()) > imageBitmap2.getWidth() || Size.m3888getHeightimpl(cacheDrawScope.m3729getSizeNHjbRc()) > imageBitmap2.getHeight() || !z2) {
            borderCache = borderCache3;
            ImageBitmap m4289ImageBitmapx__hDU$default = ImageBitmapKt.m4289ImageBitmapx__hDU$default(IntSize.m6559getWidthimpl(IntSize), IntSize.m6558getHeightimpl(IntSize), i, false, null, 24, null);
            borderCache.imageBitmap = m4289ImageBitmapx__hDU$default;
            Canvas Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(m4289ImageBitmapx__hDU$default);
            borderCache.canvas = Canvas;
            imageBitmap = m4289ImageBitmapx__hDU$default;
            canvas = Canvas;
        } else {
            borderCache = borderCache3;
            canvas = canvas2;
            imageBitmap = imageBitmap2;
        }
        CanvasDrawScope canvasDrawScope = borderCache.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        long m6569toSizeozmzZPI = IntSizeKt.m6569toSizeozmzZPI(IntSize);
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m4536setSizeuvyYCjk(m6569toSizeozmzZPI);
        canvas.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        DrawScope.m4607drawRectnJ9OG0$default(canvasDrawScope3, Color.INSTANCE.m4089getBlack0d7_KjU(), 0L, m6569toSizeozmzZPI, 0.0f, null, null, BlendMode.INSTANCE.m3978getClear0nO6VwU(), 58, null);
        float f2 = -bounds.getLeft();
        float f3 = -bounds.getTop();
        canvasDrawScope3.getDrawContext().getTransform().translate(f2, f3);
        final ColorFilter colorFilter2 = colorFilter;
        ?? r21 = imageBitmap;
        DrawScope.m4602drawPathGBMwjPU$default(canvasDrawScope3, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        float f4 = 1;
        float m3891getWidthimpl = (Size.m3891getWidthimpl(canvasDrawScope3.mo4612getSizeNHjbRc()) + f4) / Size.m3891getWidthimpl(canvasDrawScope3.mo4612getSizeNHjbRc());
        float m3888getHeightimpl = (Size.m3888getHeightimpl(canvasDrawScope3.mo4612getSizeNHjbRc()) + f4) / Size.m3888getHeightimpl(canvasDrawScope3.mo4612getSizeNHjbRc());
        long mo4611getCenterF1C5BW0 = canvasDrawScope3.mo4611getCenterF1C5BW0();
        DrawContext drawContext = canvasDrawScope3.getDrawContext();
        long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo4544scale0AR0LA0(m3891getWidthimpl, m3888getHeightimpl, mo4611getCenterF1C5BW0);
        DrawScope.m4602drawPathGBMwjPU$default(canvasDrawScope3, obtainPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m3978getClear0nO6VwU(), 28, null);
        drawContext.getCanvas().restore();
        drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
        canvasDrawScope3.getDrawContext().getTransform().translate(-f2, -f3);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas3);
        drawParams3.m4536setSizeuvyYCjk(size);
        r21.prepareToDraw();
        objectRef.element = r21;
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                float left = Rect.this.getLeft();
                float top = Rect.this.getTop();
                Ref.ObjectRef<ImageBitmap> objectRef2 = objectRef;
                long j = IntSize;
                ColorFilter colorFilter3 = colorFilter2;
                contentDrawScope2.getDrawContext().getTransform().translate(left, top);
                DrawScope.m4596drawImageAZ2fEMs$default(contentDrawScope2, objectRef2.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter3, 0, 0, 890, null);
                contentDrawScope2.getDrawContext().getTransform().translate(-left, -top);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m544drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m3872getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m3872getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    long m542shrinkKibmq7A;
                    contentDrawScope.drawContent();
                    if (z) {
                        DrawScope.m4608drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, m3872getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float m3797getXimpl = CornerRadius.m3797getXimpl(m3872getTopLeftCornerRadiuskKHJgLs);
                    float f3 = f2;
                    if (m3797getXimpl < f3) {
                        ContentDrawScope contentDrawScope2 = contentDrawScope;
                        float f4 = f;
                        float m3891getWidthimpl = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f;
                        float m3888getHeightimpl = Size.m3888getHeightimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f;
                        int m4051getDifferencertfAjoo = ClipOp.INSTANCE.m4051getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j3 = m3872getTopLeftCornerRadiuskKHJgLs;
                        DrawContext drawContext = contentDrawScope2.getDrawContext();
                        long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        drawContext.getTransform().mo4540clipRectN_I0leg(f4, f4, m3891getWidthimpl, m3888getHeightimpl, m4051getDifferencertfAjoo);
                        DrawScope.m4608drawRoundRectZuiqVtQ$default(contentDrawScope2, brush2, 0L, 0L, j3, 0.0f, null, null, 0, 246, null);
                        drawContext.getCanvas().restore();
                        drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
                        return;
                    }
                    Brush brush3 = brush;
                    long j4 = j;
                    long j5 = j2;
                    m542shrinkKibmq7A = BorderKt.m542shrinkKibmq7A(m3872getTopLeftCornerRadiuskKHJgLs, f3);
                    DrawScope.m4608drawRoundRectZuiqVtQ$default(contentDrawScope, brush3, j4, j5, m542shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m4602drawPathGBMwjPU$default(contentDrawScope, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}
