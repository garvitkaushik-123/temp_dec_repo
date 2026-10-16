package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.profileinstaller.ProfileVerifier;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.google.android.exoplayer2.C;
import com.ironsource.N6;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¸\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aÌ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%2\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aÖ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2&\b\u0002\u0010(\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010+\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010-\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a¬\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\b\u0002\u0010(\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010+\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010-\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u0095\u0001\u00106\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010(\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010+\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010-\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010)¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u00107\u001a[\u00108\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010;\u001ae\u00108\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"SubcomposeAsyncImage", "", "state", "Lcoil/compose/AsyncImageState;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil/compose/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", N6.B, "", "imageLoader", "Lcoil/ImageLoader;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "SubcomposeAsyncImage-FSyRiR8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-TCQMD7g", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubcomposeAsyncImageKt {
    /* renamed from: SubcomposeAsyncImage-TCQMD7g, reason: not valid java name */
    public static final void m6754SubcomposeAsyncImageTCQMD7g(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(428575962);
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i4 & 1024) != 0 ? null : function14;
        Alignment center = (i4 & 2048) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) != 0 ? null : colorFilter;
        int m4614getDefaultFilterQualityfv9h1I = (i4 & 32768) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 65536) != 0 ? true : z;
        EqualityDelegate defaultModelEqualityDelegate = (i4 & 131072) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate;
        ColorFilter colorFilter3 = colorFilter2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428575962, i2, i3, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:75)");
        }
        AsyncImageState asyncImageState = new AsyncImageState(obj, defaultModelEqualityDelegate, imageLoader);
        Function1<AsyncImagePainter.State, Unit> onStateOf = UtilsKt.onStateOf(function15, function16, function17);
        Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf = contentOf(function44, function45, function46);
        int i5 = i2 >> 3;
        int i6 = (i2 & 112) | (i5 & 896) | (i5 & 7168);
        int i7 = i3 << 12;
        m6755SubcomposeAsyncImagegl8XCv8(asyncImageState, str, companion, defaultTransform, onStateOf, center, fit, f2, colorFilter3, m4614getDefaultFilterQualityfv9h1I, z2, contentOf, composer, i6 | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), (i3 >> 18) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final /* synthetic */ void m6753SubcomposeAsyncImageQ4Kwu38(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function4 function4, Function4 function42, Function4 function43, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(934816934);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function4 function44 = (i4 & 16) != 0 ? null : function4;
        Function4 function45 = (i4 & 32) != 0 ? null : function42;
        Function4 function46 = (i4 & 64) != 0 ? null : function43;
        Function1 function14 = (i4 & 128) != 0 ? null : function1;
        Function1 function15 = (i4 & 256) != 0 ? null : function12;
        Function1 function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        int m4614getDefaultFilterQualityfv9h1I = (i4 & 16384) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(934816934, i2, i3, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:109)");
        }
        int i5 = i3 << 15;
        m6755SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, modifier2, AsyncImagePainter.INSTANCE.getDefaultTransform(), UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, colorFilter2, m4614getDefaultFilterQualityfv9h1I, true, contentOf(function44, function45, function46), composer, (i2 & 112) | 3072 | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: SubcomposeAsyncImage-FSyRiR8, reason: not valid java name */
    public static final void m6752SubcomposeAsyncImageFSyRiR8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-2125038415);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) != 0 ? null : colorFilter;
        int m4614getDefaultFilterQualityfv9h1I = (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 2048) != 0 ? true : z;
        EqualityDelegate defaultModelEqualityDelegate = (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2125038415, i2, i3, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:168)");
        }
        int i5 = i2 >> 3;
        m6755SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, defaultModelEqualityDelegate, imageLoader), str, modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, m4614getDefaultFilterQualityfv9h1I, z2, function3, composer, (i5 & 234881024) | (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | ((i3 << 27) & 1879048192), ((i3 >> 3) & 14) | ((i3 >> 6) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final /* synthetic */ void m6756SubcomposeAsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Function3 function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(10937794);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1 defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1 function13 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) != 0 ? null : colorFilter;
        int m4614getDefaultFilterQualityfv9h1I = (i4 & 1024) != 0 ? DrawScope.INSTANCE.m4614getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10937794, i2, i3, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:199)");
        }
        int i5 = i2 >> 3;
        m6755SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, m4614getDefaultFilterQualityfv9h1I, true, function3, composer, (i5 & 234881024) | (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | ((i3 << 27) & 1879048192), (i3 & 112) | 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /* renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m6755SubcomposeAsyncImagegl8XCv8(AsyncImageState asyncImageState, final String str, Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        AsyncImageState asyncImageState2;
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        final SizeResolver sizeResolver;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-892827826);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            asyncImageState2 = asyncImageState;
        } else {
            asyncImageState2 = asyncImageState;
            if ((i2 & 14) == 0) {
                i5 = (startRestartGroup.changed(asyncImageState2) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changed(str) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                if ((i4 & 8) != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    i5 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                    if ((i4 & 16) == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 57344) == 0) {
                        i5 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
                    }
                    if ((i4 & 32) == 0) {
                        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((i2 & 458752) == 0) {
                            i7 = startRestartGroup.changed(alignment) ? 131072 : 65536;
                        }
                        if ((i4 & 64) == 0) {
                            i9 = (i2 & 3670016) == 0 ? startRestartGroup.changed(contentScale) ? 1048576 : 524288 : 1572864;
                            if ((i4 & 128) == 0) {
                                i5 |= 12582912;
                            } else if ((29360128 & i2) == 0) {
                                i5 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                                if ((i4 & 256) != 0) {
                                    i5 |= 100663296;
                                } else if ((234881024 & i2) == 0) {
                                    i5 |= startRestartGroup.changed(colorFilter) ? 67108864 : 33554432;
                                    if ((i4 & 512) == 0) {
                                        i5 |= C.ENCODING_PCM_32BIT;
                                    } else if ((1879048192 & i2) == 0) {
                                        i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                                        if ((i4 & 1024) != 0) {
                                            i8 = i3 | 6;
                                        } else if ((i3 & 14) == 0) {
                                            i8 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
                                        } else {
                                            i8 = i3;
                                        }
                                        if ((i4 & 2048) != 0) {
                                            i8 |= 48;
                                        } else if ((i3 & 112) == 0) {
                                            i8 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                                        }
                                        int i10 = i8;
                                        if ((i5 & 1533916891) == 306783378 || (i10 & 91) != 18 || !startRestartGroup.getSkipping()) {
                                            Modifier modifier5 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-892827826, i5, i10, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:228)");
                                            }
                                            ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                                            int i11 = i5;
                                            int i12 = i11 >> 3;
                                            int i13 = i11 >> 6;
                                            int i14 = i11 >> 12;
                                            final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i12 & 7168) | (i12 & 896) | 72 | (i13 & 57344) | (i14 & 458752), 64);
                                            sizeResolver = requestOfWithSizeResolver.getSizeResolver();
                                            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                                                startRestartGroup.startReplaceableGroup(-247974462);
                                                startRestartGroup.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment, true, startRestartGroup, (((((i13 & 14) | 384) | (i14 & 112)) >> 3) & 14) | 48);
                                                startRestartGroup.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
                                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                startRestartGroup.startReusableNode();
                                                if (startRestartGroup.getInserting()) {
                                                    startRestartGroup.createNode(constructor);
                                                } else {
                                                    startRestartGroup.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                                startRestartGroup.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, m6718rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), startRestartGroup, Integer.valueOf(i10 & 112));
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                startRestartGroup.endReplaceableGroup();
                                                startRestartGroup.endNode();
                                                startRestartGroup.endReplaceableGroup();
                                                startRestartGroup.endReplaceableGroup();
                                                startRestartGroup.endReplaceableGroup();
                                                startRestartGroup = startRestartGroup;
                                                modifier3 = modifier5;
                                            } else {
                                                startRestartGroup.startReplaceableGroup(-247973763);
                                                startRestartGroup = startRestartGroup;
                                                modifier3 = modifier5;
                                                BoxWithConstraintsKt.BoxWithConstraints(modifier3, alignment, true, ComposableLambdaKt.composableLambda(startRestartGroup, 748478484, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i15) {
                                                        if ((i15 & 14) == 0) {
                                                            i15 |= composer2.changed(boxWithConstraintsScope) ? 4 : 2;
                                                        }
                                                        if ((i15 & 91) != 18 || !composer2.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(748478484, i15, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:274)");
                                                            }
                                                            ((ConstraintsSizeResolver) SizeResolver.this).m6726setConstraintsBRTryo0(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                                            function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, m6718rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), composer2, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer2.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, (i13 & 14) | 3456 | (i14 & 112), 0);
                                                startRestartGroup.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            modifier4 = modifier2;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            final AsyncImageState asyncImageState3 = asyncImageState2;
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i15) {
                                                    SubcomposeAsyncImageKt.m6755SubcomposeAsyncImagegl8XCv8(AsyncImageState.this, str, modifier4, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    if ((i4 & 1024) != 0) {
                                    }
                                    if ((i4 & 2048) != 0) {
                                    }
                                    int i102 = i8;
                                    if ((i5 & 1533916891) == 306783378) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ImageRequest requestOfWithSizeResolver2 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                                    int i112 = i5;
                                    int i122 = i112 >> 3;
                                    int i132 = i112 >> 6;
                                    int i142 = i112 >> 12;
                                    final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA2 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver2, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i122 & 7168) | (i122 & 896) | 72 | (i132 & 57344) | (i142 & 458752), 64);
                                    sizeResolver = requestOfWithSizeResolver2.getSizeResolver();
                                    if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier4 = modifier3;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                if ((i4 & 512) == 0) {
                                }
                                if ((i4 & 1024) != 0) {
                                }
                                if ((i4 & 2048) != 0) {
                                }
                                int i1022 = i8;
                                if ((i5 & 1533916891) == 306783378) {
                                }
                                if (i6 != 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ImageRequest requestOfWithSizeResolver22 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                                int i1122 = i5;
                                int i1222 = i1122 >> 3;
                                int i1322 = i1122 >> 6;
                                int i1422 = i1122 >> 12;
                                final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA22 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver22, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i1222 & 7168) | (i1222 & 896) | 72 | (i1322 & 57344) | (i1422 & 458752), 64);
                                sizeResolver = requestOfWithSizeResolver22.getSizeResolver();
                                if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            if ((i4 & 256) != 0) {
                            }
                            if ((i4 & 512) == 0) {
                            }
                            if ((i4 & 1024) != 0) {
                            }
                            if ((i4 & 2048) != 0) {
                            }
                            int i10222 = i8;
                            if ((i5 & 1533916891) == 306783378) {
                            }
                            if (i6 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ImageRequest requestOfWithSizeResolver222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                            int i11222 = i5;
                            int i12222 = i11222 >> 3;
                            int i13222 = i11222 >> 6;
                            int i14222 = i11222 >> 12;
                            final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i12222 & 7168) | (i12222 & 896) | 72 | (i13222 & 57344) | (i14222 & 458752), 64);
                            sizeResolver = requestOfWithSizeResolver222.getSizeResolver();
                            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i5 |= i9;
                        if ((i4 & 128) == 0) {
                        }
                        if ((i4 & 256) != 0) {
                        }
                        if ((i4 & 512) == 0) {
                        }
                        if ((i4 & 1024) != 0) {
                        }
                        if ((i4 & 2048) != 0) {
                        }
                        int i102222 = i8;
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        if (i6 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ImageRequest requestOfWithSizeResolver2222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                        int i112222 = i5;
                        int i122222 = i112222 >> 3;
                        int i132222 = i112222 >> 6;
                        int i142222 = i112222 >> 12;
                        final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA2222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver2222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i122222 & 7168) | (i122222 & 896) | 72 | (i132222 & 57344) | (i142222 & 458752), 64);
                        sizeResolver = requestOfWithSizeResolver2222.getSizeResolver();
                        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i5 |= i7;
                    if ((i4 & 64) == 0) {
                    }
                    i5 |= i9;
                    if ((i4 & 128) == 0) {
                    }
                    if ((i4 & 256) != 0) {
                    }
                    if ((i4 & 512) == 0) {
                    }
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i4 & 2048) != 0) {
                    }
                    int i1022222 = i8;
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ImageRequest requestOfWithSizeResolver22222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                    int i1122222 = i5;
                    int i1222222 = i1122222 >> 3;
                    int i1322222 = i1122222 >> 6;
                    int i1422222 = i1122222 >> 12;
                    final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA22222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver22222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i1222222 & 7168) | (i1222222 & 896) | 72 | (i1322222 & 57344) | (i1422222 & 458752), 64);
                    sizeResolver = requestOfWithSizeResolver22222.getSizeResolver();
                    if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i4 & 16) == 0) {
                }
                if ((i4 & 32) == 0) {
                }
                i5 |= i7;
                if ((i4 & 64) == 0) {
                }
                i5 |= i9;
                if ((i4 & 128) == 0) {
                }
                if ((i4 & 256) != 0) {
                }
                if ((i4 & 512) == 0) {
                }
                if ((i4 & 1024) != 0) {
                }
                if ((i4 & 2048) != 0) {
                }
                int i10222222 = i8;
                if ((i5 & 1533916891) == 306783378) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ImageRequest requestOfWithSizeResolver222222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
                int i11222222 = i5;
                int i12222222 = i11222222 >> 3;
                int i13222222 = i11222222 >> 6;
                int i14222222 = i11222222 >> 12;
                final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA222222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver222222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i12222222 & 7168) | (i12222222 & 896) | 72 | (i13222222 & 57344) | (i14222222 & 458752), 64);
                sizeResolver = requestOfWithSizeResolver222222.getSizeResolver();
                if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i4 & 8) != 0) {
            }
            if ((i4 & 16) == 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i7;
            if ((i4 & 64) == 0) {
            }
            i5 |= i9;
            if ((i4 & 128) == 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if ((i4 & 512) == 0) {
            }
            if ((i4 & 1024) != 0) {
            }
            if ((i4 & 2048) != 0) {
            }
            int i102222222 = i8;
            if ((i5 & 1533916891) == 306783378) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ImageRequest requestOfWithSizeResolver2222222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
            int i112222222 = i5;
            int i122222222 = i112222222 >> 3;
            int i132222222 = i112222222 >> 6;
            int i142222222 = i112222222 >> 12;
            final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA2222222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver2222222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i122222222 & 7168) | (i122222222 & 896) | 72 | (i132222222 & 57344) | (i142222222 & 458752), 64);
            sizeResolver = requestOfWithSizeResolver2222222.getSizeResolver();
            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        if ((i4 & 8) != 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i7;
        if ((i4 & 64) == 0) {
        }
        i5 |= i9;
        if ((i4 & 128) == 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if ((i4 & 512) == 0) {
        }
        if ((i4 & 1024) != 0) {
        }
        if ((i4 & 2048) != 0) {
        }
        int i1022222222 = i8;
        if ((i5 & 1533916891) == 306783378) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ImageRequest requestOfWithSizeResolver22222222 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, ((i5 >> 15) & 112) | 8);
        int i1122222222 = i5;
        int i1222222222 = i1122222222 >> 3;
        int i1322222222 = i1122222222 >> 6;
        int i1422222222 = i1122222222 >> 12;
        final AsyncImagePainter m6718rememberAsyncImagePainter0YpotYA22222222 = AsyncImagePainterKt.m6718rememberAsyncImagePainter0YpotYA(requestOfWithSizeResolver22222222, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, startRestartGroup, (i1222222222 & 7168) | (i1222222222 & 896) | 72 | (i1322222222 & 57344) | (i1422222222 & 458752), 64);
        sizeResolver = requestOfWithSizeResolver22222222.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, final int i, final int i2) {
        SubcomposeAsyncImageScope subcomposeAsyncImageScope2;
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        ColorFilter colorFilter2;
        boolean z2;
        AsyncImagePainter asyncImagePainter;
        String str3;
        Alignment alignment3;
        ContentScale contentScale3;
        float f3;
        ColorFilter colorFilter3;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final String str4;
        final Modifier modifier3;
        final Alignment alignment4;
        final ContentScale contentScale4;
        final float f4;
        final ColorFilter colorFilter4;
        ScopeUpdateScope endRestartGroup;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(880638523);
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
        } else if ((i & 14) == 0) {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = (startRestartGroup.changed(subcomposeAsyncImageScope2) ? 4 : 2) | i;
        } else {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 4) == 0) {
                    str2 = str;
                    if (startRestartGroup.changed(str2)) {
                        i10 = 2048;
                        i3 |= i10;
                    }
                } else {
                    str2 = str;
                }
                i10 = 1024;
                i3 |= i10;
            } else {
                str2 = str;
            }
            if ((57344 & i) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    if (startRestartGroup.changed(alignment2)) {
                        i9 = 16384;
                        i3 |= i9;
                    }
                } else {
                    alignment2 = alignment;
                }
                i9 = 8192;
                i3 |= i9;
            } else {
                alignment2 = alignment;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    if (startRestartGroup.changed(contentScale2)) {
                        i8 = 131072;
                        i3 |= i8;
                    }
                } else {
                    contentScale2 = contentScale;
                }
                i8 = 65536;
                i3 |= i8;
            } else {
                contentScale2 = contentScale;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    if (startRestartGroup.changed(f2)) {
                        i7 = 1048576;
                        i3 |= i7;
                    }
                } else {
                    f2 = f;
                }
                i7 = 524288;
                i3 |= i7;
            } else {
                f2 = f;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 64) == 0) {
                    colorFilter2 = colorFilter;
                    if (startRestartGroup.changed(colorFilter2)) {
                        i6 = 8388608;
                        i3 |= i6;
                    }
                } else {
                    colorFilter2 = colorFilter;
                }
                i6 = 4194304;
                i3 |= i6;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 128) == 0) {
                    z2 = z;
                    if (startRestartGroup.changed(z2)) {
                        i5 = 67108864;
                        i3 |= i5;
                    }
                } else {
                    z2 = z;
                }
                i5 = 33554432;
                i3 |= i5;
            } else {
                z2 = z;
            }
            if (i4 != 2 && (191739611 & i3) == 38347922 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str4 = str2;
                alignment4 = alignment2;
                contentScale4 = contentScale2;
                f4 = f2;
                colorFilter4 = colorFilter2;
            } else {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                        asyncImagePainter = subcomposeAsyncImageScope2.getPainter();
                        i3 &= -897;
                    } else {
                        asyncImagePainter = painter;
                    }
                    if ((i2 & 4) == 0) {
                        str3 = subcomposeAsyncImageScope2.getContentDescription();
                        i3 &= -7169;
                    } else {
                        str3 = str2;
                    }
                    if ((i2 & 8) == 0) {
                        alignment3 = subcomposeAsyncImageScope2.getAlignment();
                        i3 &= -57345;
                    } else {
                        alignment3 = alignment2;
                    }
                    if ((i2 & 16) == 0) {
                        contentScale3 = subcomposeAsyncImageScope2.getContentScale();
                        i3 &= -458753;
                    } else {
                        contentScale3 = contentScale2;
                    }
                    if ((i2 & 32) == 0) {
                        f3 = subcomposeAsyncImageScope2.getAlpha();
                        i3 &= -3670017;
                    } else {
                        f3 = f2;
                    }
                    if ((i2 & 64) == 0) {
                        colorFilter3 = subcomposeAsyncImageScope2.getColorFilter();
                        i3 &= -29360129;
                    } else {
                        colorFilter3 = colorFilter2;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                        z2 = subcomposeAsyncImageScope2.getClipToBounds();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if (i4 != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                    }
                    asyncImagePainter = painter;
                    str3 = str2;
                    alignment3 = alignment2;
                    contentScale3 = contentScale2;
                    f3 = f2;
                    colorFilter3 = colorFilter2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(880638523, i3, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:335)");
                }
                Modifier contentDescription = UtilsKt.contentDescription(modifier2, str3);
                if (z2) {
                    contentDescription = ClipKt.clipToBounds(contentDescription);
                }
                painter = asyncImagePainter;
                Modifier then = contentDescription.then(new ContentPainterElement(painter, alignment3, contentScale3, f3, colorFilter3));
                SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2 subcomposeAsyncImageKt$SubcomposeAsyncImageContent$2 = new MeasurePolicy() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        return MeasureScope.layout$default(measureScope, Constraints.m6347getMinWidthimpl(j), Constraints.m6346getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                startRestartGroup.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$$inlined$Layout$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final ComposeUiNode invoke() {
                            return Function0.this.invoke();
                        }
                    });
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, subcomposeAsyncImageKt$SubcomposeAsyncImageContent$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m3600setimpl(m3593constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier3 = modifier2;
                alignment4 = alignment3;
                contentScale4 = contentScale3;
                f4 = f3;
                colorFilter4 = colorFilter3;
            }
            final Painter painter2 = painter;
            final boolean z3 = z2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(SubcomposeAsyncImageScope.this, modifier3, painter2, str4, alignment4, contentScale4, f4, colorFilter4, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        if ((29360128 & i) != 0) {
        }
        if ((234881024 & i) != 0) {
        }
        if (i4 != 2) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier contentDescription2 = UtilsKt.contentDescription(modifier2, str3);
        if (z2) {
        }
        painter = asyncImagePainter;
        Modifier then2 = contentDescription2.then(new ContentPainterElement(painter, alignment3, contentScale3, f3, colorFilter3));
        SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2 subcomposeAsyncImageKt$SubcomposeAsyncImageContent$22 = new MeasurePolicy() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                return MeasureScope.layout$default(measureScope, Constraints.m6347getMinWidthimpl(j), Constraints.m6346getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
        };
        startRestartGroup.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        final Function0 constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        startRestartGroup.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, subcomposeAsyncImageKt$SubcomposeAsyncImageContent$22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m3600setimpl(m3593constructorimpl, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        str4 = str3;
        modifier3 = modifier2;
        alignment4 = alignment3;
        contentScale4 = contentScale3;
        f4 = f3;
        colorFilter4 = colorFilter3;
        final Painter painter22 = painter;
        final boolean z32 = z2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014e  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        SubcomposeAsyncImageScope subcomposeAsyncImageScope2;
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        int i5;
        final ColorFilter colorFilter2;
        int i6;
        AsyncImagePainter asyncImagePainter;
        Painter painter2;
        ColorFilter colorFilter3;
        int i7;
        Alignment alignment3;
        Modifier modifier3;
        int i8;
        int i9;
        float f3;
        ContentScale contentScale3;
        String str3;
        Composer composer2;
        final Modifier modifier4;
        final Painter painter3;
        final String str4;
        final Alignment alignment4;
        final ContentScale contentScale4;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-263982313);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
        } else {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(subcomposeAsyncImageScope2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i14 = i2 & 1;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 4) == 0) {
                    str2 = str;
                    if (startRestartGroup.changed(str2)) {
                        i13 = 2048;
                        i3 |= i13;
                    }
                } else {
                    str2 = str;
                }
                i13 = 1024;
                i3 |= i13;
            } else {
                str2 = str;
            }
            if ((i & 57344) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    if (startRestartGroup.changed(alignment2)) {
                        i12 = 16384;
                        i3 |= i12;
                    }
                } else {
                    alignment2 = alignment;
                }
                i12 = 8192;
                i3 |= i12;
            } else {
                alignment2 = alignment;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    if (startRestartGroup.changed(contentScale2)) {
                        i11 = 131072;
                        i3 |= i11;
                    }
                } else {
                    contentScale2 = contentScale;
                }
                i11 = 65536;
                i3 |= i11;
            } else {
                contentScale2 = contentScale;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    if (startRestartGroup.changed(f2)) {
                        i10 = 1048576;
                        i3 |= i10;
                    }
                } else {
                    f2 = f;
                }
                i10 = 524288;
                i3 |= i10;
            } else {
                f2 = f;
            }
            if ((i & 29360128) != 0) {
                i5 = 57344;
                colorFilter2 = colorFilter;
                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(colorFilter2)) ? 8388608 : 4194304;
            } else {
                i5 = 57344;
                colorFilter2 = colorFilter;
            }
            if (i4 != 2) {
                i6 = 458752;
                if ((23967451 & i3) == 4793490 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    painter3 = painter;
                    composer2 = startRestartGroup;
                    modifier4 = modifier2;
                    str4 = str2;
                    alignment4 = alignment2;
                    contentScale4 = contentScale2;
                    f4 = f2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(SubcomposeAsyncImageScope.this, modifier4, painter3, str4, alignment4, contentScale4, f4, colorFilter2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                i6 = 458752;
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                    asyncImagePainter = subcomposeAsyncImageScope2.getPainter();
                    i3 &= -897;
                } else {
                    asyncImagePainter = painter;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                    str2 = subcomposeAsyncImageScope2.getContentDescription();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                    alignment2 = subcomposeAsyncImageScope2.getAlignment();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                    contentScale2 = subcomposeAsyncImageScope2.getContentScale();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                    f2 = subcomposeAsyncImageScope2.getAlpha();
                }
                if ((i2 & 64) == 0) {
                    i3 &= -29360129;
                    int i15 = i6;
                    colorFilter3 = subcomposeAsyncImageScope2.getColorFilter();
                    i7 = 3670016;
                    alignment3 = alignment2;
                    modifier3 = modifier2;
                    i8 = i15;
                    painter2 = asyncImagePainter;
                    i9 = 29360128;
                    f3 = f2;
                    contentScale3 = contentScale2;
                    str3 = str2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-263982313, i3, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:363)");
                    }
                    composer2 = startRestartGroup;
                    SubcomposeAsyncImageContent(subcomposeAsyncImageScope2, modifier3, painter2, str3, alignment3, contentScale3, f3, colorFilter3, false, composer2, (i3 & 14) | 512 | (i3 & 112) | (i3 & 7168) | (i3 & i5) | (i8 & i3) | (i7 & i3) | (i3 & i9), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    painter3 = painter2;
                    str4 = str3;
                    alignment4 = alignment3;
                    contentScale4 = contentScale3;
                    f4 = f3;
                    colorFilter2 = colorFilter3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                } else {
                    painter2 = asyncImagePainter;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if (i4 != 0) {
                    i3 &= -897;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -29360129;
                }
                painter2 = painter;
            }
            i7 = 3670016;
            i9 = 29360128;
            alignment3 = alignment2;
            f3 = f2;
            modifier3 = modifier2;
            contentScale3 = contentScale2;
            i8 = i6;
            str3 = str2;
            colorFilter3 = colorFilter2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            SubcomposeAsyncImageContent(subcomposeAsyncImageScope2, modifier3, painter2, str3, alignment3, contentScale3, f3, colorFilter3, false, composer2, (i3 & 14) | 512 | (i3 & 112) | (i3 & 7168) | (i3 & i5) | (i8 & i3) | (i7 & i3) | (i3 & i9), 128);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            painter3 = painter2;
            str4 = str3;
            alignment4 = alignment3;
            contentScale4 = contentScale3;
            f4 = f3;
            colorFilter2 = colorFilter3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if (i4 != 2) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m6725getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$contentOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00c8  */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                int i2;
                if ((i & 14) == 0) {
                    i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1302781228, i2, -1, "coil.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:381)");
                    }
                    AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
                    boolean z = false;
                    boolean z2 = true;
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        composer.startReplaceableGroup(-418317557);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function44 = function4;
                        if (function44 != 0) {
                            function44.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else if (state instanceof AsyncImagePainter.State.Success) {
                        composer.startReplaceableGroup(-418317557);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function45 = function42;
                        if (function45 != 0) {
                            function45.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else {
                        if (!(state instanceof AsyncImagePainter.State.Error)) {
                            if (state instanceof AsyncImagePainter.State.Empty) {
                                composer.startReplaceableGroup(-418301399);
                                composer.endReplaceableGroup();
                            } else {
                                composer.startReplaceableGroup(-418301339);
                                composer.endReplaceableGroup();
                            }
                            if (z2) {
                                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                return;
                            }
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        composer.startReplaceableGroup(-418317557);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function46 = function43;
                        if (function46 != 0) {
                            function46.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    }
                    z2 = z;
                    if (z2) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    composer.skipToGroupEnd();
                }
            }
        });
    }
}
