package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import com.ironsource.N6;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SingletonAsyncImagePainter.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001ah\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", N6.B, "", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-19ie5dc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "rememberAsyncImagePainter-EHKIwbg", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "rememberAsyncImagePainter-MqR-F_0", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-HtA5bXE", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "coil-compose-singleton_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SingletonAsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-HtA5bXE, reason: not valid java name */
    public static final AsyncImagePainter m6746rememberAsyncImagePainterHtA5bXE(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1445305568);
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        Painter painter5 = (i3 & 4) != 0 ? null : painter2;
        Painter painter6 = (i3 & 8) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i3 & 16) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i3 & 32) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i3 & 64) == 0 ? function13 : null;
        ContentScale fit = (i3 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m4614getDefaultFilterQualityfv9h1I = (i3 & 256) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        EqualityDelegate defaultModelEqualityDelegate = (i3 & 512) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1445305568, i2, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:59)");
        }
        int i4 = i2 << 3;
        AsyncImagePainter m6719rememberAsyncImagePainter10Xjiaw = AsyncImagePainterKt.m6719rememberAsyncImagePainter10Xjiaw(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), painter4, painter5, painter6, function14, function15, function16, fit, m4614getDefaultFilterQualityfv9h1I, defaultModelEqualityDelegate, composer, (i4 & 1879048192) | (458752 & i4) | 37448 | (3670016 & i4) | (29360128 & i4) | (234881024 & i4), (i2 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m6719rememberAsyncImagePainter10Xjiaw;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-MqR-F_0, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m6747rememberAsyncImagePainterMqRF_0(Object obj, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(533921043);
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        Painter painter5 = (i3 & 4) != 0 ? null : painter2;
        Painter painter6 = (i3 & 8) != 0 ? painter5 : painter3;
        Function1 function14 = (i3 & 16) != 0 ? null : function1;
        Function1 function15 = (i3 & 32) != 0 ? null : function12;
        Function1 function16 = (i3 & 64) == 0 ? function13 : null;
        ContentScale fit = (i3 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m4614getDefaultFilterQualityfv9h1I = (i3 & 256) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(533921043, i2, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:86)");
        }
        int i4 = i2 << 3;
        AsyncImagePainter m6719rememberAsyncImagePainter10Xjiaw = AsyncImagePainterKt.m6719rememberAsyncImagePainter10Xjiaw(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), painter4, painter5, painter6, function14, function15, function16, fit, m4614getDefaultFilterQualityfv9h1I, null, composer, (458752 & i4) | 37448 | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), 0, 1024);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m6719rememberAsyncImagePainter10Xjiaw;
    }

    /* renamed from: rememberAsyncImagePainter-EHKIwbg, reason: not valid java name */
    public static final AsyncImagePainter m6745rememberAsyncImagePainterEHKIwbg(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(236159766);
        if ((i3 & 2) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13 = function1;
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        Function1<? super AsyncImagePainter.State, Unit> function14 = function12;
        if ((i3 & 8) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 16) != 0) {
            i = DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I();
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            equalityDelegate = EqualityDelegateKt.getDefaultModelEqualityDelegate();
        }
        EqualityDelegate equalityDelegate2 = equalityDelegate;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(236159766, i2, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:133)");
        }
        int i5 = i2 << 3;
        AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), function13, function14, contentScale2, i4, equalityDelegate2, composer, (i5 & 896) | 72 | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m6718rememberAsyncImagePainter0YpotYA;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: rememberAsyncImagePainter-19ie5dc, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m6744rememberAsyncImagePainter19ie5dc(Object obj, Function1 function1, Function1 function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-1494234083);
        Function1 defaultTransform = (i3 & 2) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1 function13 = (i3 & 4) != 0 ? null : function12;
        ContentScale fit = (i3 & 8) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m4614getDefaultFilterQualityfv9h1I = (i3 & 16) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1494234083, i2, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:152)");
        }
        int i4 = i2 << 3;
        AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), defaultTransform, function13, fit, m4614getDefaultFilterQualityfv9h1I, null, composer, (i4 & 896) | 72 | (i4 & 7168) | (57344 & i4) | (i4 & 458752), 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m6718rememberAsyncImagePainter0YpotYA;
    }
}
