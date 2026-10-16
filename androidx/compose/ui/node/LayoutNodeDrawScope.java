package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b$\u0010%Jq\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106Jq\u0010&\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:JY\u0010;\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>JY\u0010;\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u001eH\u0016J2\u0010B\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\bC\u0010DJO\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJm\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJw\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010R\u001a\u00020SH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJk\u0010V\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_Jk\u0010V\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJY\u0010b\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJY\u0010b\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u0010'\u001a\u00020(2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bj\u0010kJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u00107\u001a\u0002082\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJY\u0010w\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010dJY\u0010w\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010fJc\u0010z\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jd\u0010z\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0013\u0010\u0081\u0001\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001e\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00020\u000bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001f\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00030\u0083\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008f\u0001J\u001b\u0010\u0090\u0001\u001a\u00030\u0091\u0001*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000b*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u008e\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000b*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u008c\u0001J\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001*\u00030\u0099\u0001H\u0097\u0001J\u001b\u0010\u009a\u0001\u001a\u00020\u001b*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u0093\u0001J\u001c\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001e\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00020\u000bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010\u009e\u0001J\u001f\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00030\u0083\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeDrawScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-illE91I */
    public void mo4513drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4513drawArcillE91I(brush, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public void mo4514drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4514drawArcyD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-V9BoPsw */
    public void mo4515drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4515drawCircleV9BoPsw(brush, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo4516drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4516drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo4517drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4517drawImage9jGpkUE(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo4518drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo4518drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo4519drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4519drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo4520drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4520drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public void mo4521drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4521drawLineNGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-AsUm42w */
    public void mo4522drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4522drawOvalAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-n-J9OG0 */
    public void mo4523drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4523drawOvalnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo4524drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4524drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo4525drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4525drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8 */
    public void mo4526drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4526drawPointsF8ZwMP8(points, pointMode, color, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-Gsft0Ws */
    public void mo4527drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4527drawPointsGsft0Ws(points, pointMode, brush, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo4528drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4528drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo4529drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4529drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo4530drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4530drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo4531drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4531drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo4611getCenterF1C5BW0() {
        return this.canvasDrawScope.mo4611getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo4612getSizeNHjbRc() {
        return this.canvasDrawScope.mo4612getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo623roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.mo623roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo624roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo624roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo625toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo625toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo626toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo626toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo627toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo627toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo628toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo628toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo629toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo629toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo630toPx0680j_4(float f) {
        return this.canvasDrawScope.mo630toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo631toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo631toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo632toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo632toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo633toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo633toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo634toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.mo634toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        DelegatingNode nextDrawNode;
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        DrawModifierNode drawModifierNode2 = drawModifierNode;
        nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode2);
        if (nextDrawNode == 0) {
            NodeCoordinator m5436requireCoordinator64DMado = DelegatableNodeKt.m5436requireCoordinator64DMado(drawModifierNode2, NodeKind.m5539constructorimpl(4));
            if (m5436requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                m5436requireCoordinator64DMado = m5436requireCoordinator64DMado.getWrapped();
                Intrinsics.checkNotNull(m5436requireCoordinator64DMado);
            }
            m5436requireCoordinator64DMado.performDraw(canvas);
            return;
        }
        int m5539constructorimpl = NodeKind.m5539constructorimpl(4);
        MutableVector mutableVector = null;
        while (nextDrawNode != 0) {
            if (nextDrawNode instanceof DrawModifierNode) {
                performDraw((DrawModifierNode) nextDrawNode, canvas);
            } else if ((nextDrawNode.getKindSet() & m5539constructorimpl) != 0 && (nextDrawNode instanceof DelegatingNode)) {
                Modifier.Node delegate = nextDrawNode.getDelegate();
                int i = 0;
                nextDrawNode = nextDrawNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            nextDrawNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nextDrawNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(nextDrawNode);
                                }
                                nextDrawNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    nextDrawNode = nextDrawNode;
                }
                if (i == 1) {
                }
            }
            nextDrawNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas) {
        NodeCoordinator m5436requireCoordinator64DMado = DelegatableNodeKt.m5436requireCoordinator64DMado(drawModifierNode, NodeKind.m5539constructorimpl(4));
        m5436requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m5473drawDirectx_KDEd0$ui_release(canvas, IntSizeKt.m6569toSizeozmzZPI(m5436requireCoordinator64DMado.mo5340getSizeYbymL2g()), m5436requireCoordinator64DMado, drawModifierNode);
    }

    /* renamed from: drawDirect-x_KDEd0$ui_release, reason: not valid java name */
    public final void m5473drawDirectx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas2 = drawParams.getCanvas();
        long size2 = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(coordinator);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m4536setSizeuvyYCjk(size);
        canvas.save();
        drawNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas2);
        drawParams3.m4536setSizeuvyYCjk(size2);
        this.drawNode = drawModifierNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* renamed from: draw-x_KDEd0$ui_release, reason: not valid java name */
    public final void m5472drawx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode) {
        Canvas canvas2;
        long j;
        NodeCoordinator nodeCoordinator;
        Modifier.Node node;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(4);
        MutableVector mutableVector = null;
        for (DrawModifierNode drawModifierNode = drawNode; drawModifierNode != 0; drawModifierNode = node) {
            if (drawModifierNode instanceof DrawModifierNode) {
                canvas2 = canvas;
                j = size;
                nodeCoordinator = coordinator;
                m5473drawDirectx_KDEd0$ui_release(canvas2, j, nodeCoordinator, drawModifierNode);
            } else {
                canvas2 = canvas;
                j = size;
                nodeCoordinator = coordinator;
                if ((drawModifierNode.getKindSet() & m5539constructorimpl) != 0 && (drawModifierNode instanceof DelegatingNode)) {
                    Modifier.Node delegate = drawModifierNode.getDelegate();
                    int i = 0;
                    node = drawModifierNode;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        node = node;
                    }
                    if (i == 1) {
                        canvas = canvas2;
                        size = j;
                        coordinator = nodeCoordinator;
                    }
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
            canvas = canvas2;
            size = j;
            coordinator = nodeCoordinator;
        }
    }
}
