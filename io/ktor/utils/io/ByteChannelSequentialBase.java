package io.ktor.utils.io;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.OutputPrimitivesKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: ByteChannelSequential.kt */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b&\u0018\u00002\u00030Ö\u00012\u00030×\u00012\u00030Ø\u00012\u00020{2\u00030Ù\u00012\u00030Ú\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0084@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J\u001b\u0010.\u001a\u0002002\u0006\u00101\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u00102J#\u00104\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010,J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010,J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010,J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010,J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010,JA\u0010G\u001a\u0002002\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002002\u0006\u00101\u001a\u000200H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020\u000bH\u0004¢\u0006\u0004\bH\u0010,J\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020IH\u0080@ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ+\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0004¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\bT\u0010\u0019J\u0013\u0010U\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0019J\u0013\u0010W\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0019J\u0013\u0010X\u001a\u00020VH\u0082@ø\u0001\u0000¢\u0006\u0004\bX\u0010\u0019J\u0013\u0010Z\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0019J\u0013\u0010[\u001a\u00020YH\u0082@ø\u0001\u0000¢\u0006\u0004\b[\u0010\u0019J\u0013\u0010]\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u0019J\u0013\u0010^\u001a\u00020\\H\u0082@ø\u0001\u0000¢\u0006\u0004\b^\u0010\u0019J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010aJ+\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010QJ#\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010`J+\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010QJ\u0013\u0010c\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0019J\u0013\u0010d\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bd\u0010\u0019J\u0013\u0010e\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\be\u0010\u0019J\u0013\u0010f\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u0019J\u001b\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bi\u0010\u0013J#\u0010k\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010g\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001b\u0010n\u001a\u00020h2\u0006\u0010m\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\bn\u00102J#\u0010o\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010m\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ(\u0010u\u001a\u00020\u000b2\u0017\u0010t\u001a\u0013\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u000b0q¢\u0006\u0002\bsH\u0017¢\u0006\u0004\bu\u0010vJ\u0013\u0010x\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0019J\u0013\u0010y\u001a\u00020wH\u0082@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0019J<\u0010~\u001a\u00020\u000b2'\u0010t\u001a#\b\u0001\u0012\u0004\u0012\u00020{\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ \u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0081\u0001\u0010\u0013J8\u0010\u0086\u0001\u001a\u00020\u0003\"\u000f\b\u0000\u0010\u0084\u0001*\b0\u0082\u0001j\u0003`\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00028\u00002\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u0012\u0010\u008b\u0001\u001a\u00020{H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\"\u0010\u008f\u0001\u001a\u0002002\u0006\u0010J\u001a\u00020\u00002\u0006\u0010m\u001a\u000200H\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001e\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010NJ.\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010QJ\u001e\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010NJ.\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010QJ\u001f\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001f\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J7\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020@2\u0007\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\tH\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001e\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020IH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010LJ.\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010QJ\u001e\u0010£\u0001\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010\u0013J\u001e\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010¤\u0001\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u00102J\u001f\u0010§\u0001\u001a\u00020\u000b2\u0007\u0010¦\u0001\u001a\u00020hH\u0096@ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010©\u0001\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J?\u0010\u00ad\u0001\u001a\u00020\u000b2(\u0010¬\u0001\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010\u007fR\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0004\u0010®\u0001\u001a\u0005\b¯\u0001\u0010>R\u0016\u0010±\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010SR\u0016\u0010³\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010SR)\u0010¸\u0001\u001a\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u00038D@DX\u0084\u000e¢\u0006\u000f\u001a\u0005\bµ\u0001\u0010>\"\u0006\b¶\u0001\u0010·\u0001R.\u0010½\u0001\u001a\u0004\u0018\u00010!2\t\u0010´\u0001\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u0017\u0010¾\u0001\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Á\u0001\u001a\u00070}j\u0003`À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010Ã\u0001\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010>R\u0016\u0010Ä\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010>R\u0016\u0010Å\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010>R\u001f\u0010Æ\u0001\u001a\u00020h8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Ï\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Î\u0001R\u001f\u0010Ò\u0001\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÒ\u0001\u0010¿\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Õ\u0001"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "initial", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "<init>", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ZLio/ktor/utils/io/pool/ObjectPool;)V", "", "count", "", "addBytesRead", "(I)V", "addBytesWritten", "afterRead", "afterWrite", "atLeast", "await", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastNBytesAvailableForRead$ktor_io", "awaitAtLeastNBytesAvailableForRead", "awaitAtLeastNBytesAvailableForWrite$ktor_io", "awaitAtLeastNBytesAvailableForWrite", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "awaitInternalAtLeast1$ktor_io", "awaitInternalAtLeast1", "awaitSuspend", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "remaining", "Lio/ktor/utils/io/core/BytePacketBuilder;", "closeable", "checkClosed", "(ILio/ktor/utils/io/core/BytePacketBuilder;)V", "close", "completeReading", "()V", D5.q, "discard", "(I)I", "", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endReadSession", "written", "endWriteSession", "ensureNotClosed", "ensureNotFailed", "(Lio/ktor/utils/io/core/BytePacketBuilder;)V", "flush", "flushImpl", "()Z", "flushWrittenBytes", "Lio/ktor/utils/io/bits/Memory;", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "offset", "min", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "prepareFlushedBytes", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAvailable$ktor_io", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailableClosed", "()I", "readBoolean", "readBooleanSlow", "", "readByte", "readByteSlow", "", "readDouble", "readDoubleSlow", "", "readFloat", "readFloatSlow", "readFully", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "readInt", "readIntSlow", "readLong", "readLongSlow", ContentDisposition.Parameters.Size, "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "builder", "readPacketSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "limit", "readRemaining", "readRemainingSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "consumer", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readShortSlow", "Lkotlin/Function2;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lkotlin/coroutines/Continuation;", "", "readSuspendableSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", AdActivity.REQUEST_KEY_EXTRA, "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestNextView", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "transferTo$ktor_io", "(Lio/ktor/utils/io/ByteChannelSequentialBase;J)J", "transferTo", "src", "writeAvailable", "writeAvailableSuspend", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", InneractiveMediationDefs.GENDER_FEMALE, "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "i", "writeInt", "l", "writeLong", "packet", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visitor", "writeSuspendSession", "Z", "getAutoFlush", "getAvailableForRead", "availableForRead", "getAvailableForWrite", "availableForWrite", "<anonymous parameter 0>", "getClosed", "setClosed", "(Z)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "closedCause", "flushBuffer", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "flushMutex", "Ljava/lang/Object;", "isCancelled", "isClosedForRead", "isClosedForWrite", "readable", "Lio/ktor/utils/io/core/ByteReadPacket;", "getReadable", "()Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/internal/AwaitingSlot;", "slot", "Lio/ktor/utils/io/internal/AwaitingSlot;", "getTotalBytesRead", "()J", "totalBytesRead", "getTotalBytesWritten", "totalBytesWritten", "writable", "getWritable", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private final boolean autoFlush;
    private volatile /* synthetic */ int channelSize;
    private final BytePacketBuilder flushBuffer;
    private final Object flushMutex;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;
    private final ByteReadPacket readable;
    private final AwaitingSlot slot;
    private final BytePacketBuilder writable;
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesRead$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesWritten$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");
    private static final /* synthetic */ AtomicIntegerFieldUpdater channelSize$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");

    @Override // io.ktor.utils.io.SuspendableReadSession
    public Object await(int i, Continuation<? super Boolean> continuation) {
        return await$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        return awaitContent$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readBoolean(Continuation<? super Boolean> continuation) {
        return readBoolean$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readByte(Continuation<? super Byte> continuation) {
        return readByte$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readDouble(Continuation<? super Double> continuation) {
        return readDouble$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFloat(Continuation<? super Float> continuation) {
        return readFloat$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readInt(Continuation<? super Integer> continuation) {
        return readInt$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readLong(Continuation<? super Long> continuation) {
        return readLong$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readPacket(int i, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readShort(Continuation<? super Short> continuation) {
        return readShort$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineTo$suspendImpl(this, a2, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeByte(byte b, Continuation<? super Unit> continuation) {
        return writeByte$suspendImpl(this, b, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeDouble(double d, Continuation<? super Unit> continuation) {
        return writeDouble$suspendImpl(this, d, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFloat(float f, Continuation<? super Unit> continuation) {
        return writeFloat$suspendImpl(this, f, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(Buffer buffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, buffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: writeFully-JT6ljtQ */
    public Object mo9956writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m9957writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeInt(int i, Continuation<? super Unit> continuation) {
        return writeInt$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeLong(long j, Continuation<? super Unit> continuation) {
        return writeLong$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeShort(short s, Continuation<? super Unit> continuation) {
        return writeShort$suspendImpl(this, s, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    @Deprecated(message = "Use write { } instead.")
    public Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return writeSuspendSession$suspendImpl(this, function2, continuation);
    }

    public ByteChannelSequentialBase(ChunkBuffer initial, boolean z, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this._lastReadView = ChunkBuffer.INSTANCE.getEmpty();
        this._totalBytesRead = 0L;
        this._totalBytesWritten = 0L;
        this._availableForRead = 0;
        this.channelSize = 0;
        this._closed = null;
        this.writable = new BytePacketBuilder(pool);
        this.readable = new ByteReadPacket(initial, pool);
        this.lastReadAvailable$delegate = 0;
        this.lastReadView$delegate = ChunkBuffer.INSTANCE.getEmpty();
        this.slot = new AwaitingSlot();
        this.flushMutex = new Object();
        this.flushBuffer = new BytePacketBuilder(null, 1, null);
        int remainingAll = (int) BuffersKt.remainingAll(initial);
        afterWrite(remainingAll);
        _availableForRead$FU.addAndGet(this, remainingAll);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteChannelSequentialBase(ChunkBuffer chunkBuffer, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkBuffer, z, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
    }

    private final boolean isCancelled() {
        CloseElement closeElement = (CloseElement) this._closed;
        return (closeElement != null ? closeElement.getCause() : null) != null;
    }

    protected final boolean getClosed() {
        return this._closed != null;
    }

    protected final void setClosed(boolean z) {
        throw new IllegalStateException("Setting is not allowed for closed".toString());
    }

    protected final BytePacketBuilder getWritable() {
        return this.writable;
    }

    protected final ByteReadPacket getReadable() {
        return this.readable;
    }

    /* renamed from: getLastReadAvailable, reason: from getter */
    private final int getLastReadAvailable$delegate() {
        return this.lastReadAvailable$delegate;
    }

    private final void setLastReadAvailable(int i) {
        this.lastReadAvailable$delegate = i;
    }

    private final ChunkBuffer getLastReadView() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    private final void setLastReadView(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getAvailableForRead, reason: from getter */
    public int get_availableForRead() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int getAvailableForWrite() {
        return Math.max(0, 4088 - this.channelSize);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        if (isCancelled()) {
            return true;
        }
        return getClosed() && this.channelSize == 0;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getTotalBytesRead, reason: from getter */
    public long get_totalBytesRead() {
        return this._totalBytesRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: getTotalBytesWritten, reason: from getter */
    public long get_totalBytesWritten() {
        return this._totalBytesWritten;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable getClosedCause() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.getCause();
        }
        return null;
    }

    public final void setClosedCause(Throwable th) {
        throw new IllegalStateException("Closed cause shouldn't be changed directly".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitAtLeastNBytesAvailableForWrite$ktor_io(final int i, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1;
        int i2;
        final ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) continuation;
            if ((byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.I$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (byteChannelSequentialBase.getAvailableForWrite() < i && !byteChannelSequentialBase.getClosed()) {
                    if (byteChannelSequentialBase.flushImpl()) {
                        AwaitingSlot awaitingSlot = byteChannelSequentialBase.slot;
                        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(ByteChannelSequentialBase.this.getAvailableForWrite() < i && !ByteChannelSequentialBase.this.getClosed());
                            }
                        };
                        byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.L$0 = byteChannelSequentialBase;
                        byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.I$0 = i;
                        byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label = 1;
                        if (awaitingSlot.sleep(function0, byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label;
        if (i2 != 0) {
        }
        while (byteChannelSequentialBase.getAvailableForWrite() < i) {
            if (byteChannelSequentialBase.flushImpl()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:11:0x003c->B:20:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitAtLeastNBytesAvailableForRead$ktor_io(final int i, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1;
        Object coroutine_suspended;
        int i2;
        final ByteChannelSequentialBase byteChannelSequentialBase;
        AwaitingSlot awaitingSlot;
        Function0<Boolean> function0;
        if (continuation instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) continuation;
            if ((byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.I$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (byteChannelSequentialBase.get_availableForRead() < i && !byteChannelSequentialBase.isClosedForRead()) {
                    awaitingSlot = byteChannelSequentialBase.slot;
                    function0 = new Function0<Boolean>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(ByteChannelSequentialBase.this.get_availableForRead() < i && !ByteChannelSequentialBase.this.isClosedForRead());
                        }
                    };
                    byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.I$0 = i;
                    byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label = 1;
                    if (awaitingSlot.sleep(function0, byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label;
        if (i2 != 0) {
        }
        while (byteChannelSequentialBase.get_availableForRead() < i) {
            awaitingSlot = byteChannelSequentialBase.slot;
            function0 = new Function0<Boolean>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ByteChannelSequentialBase.this.get_availableForRead() < i && !ByteChannelSequentialBase.this.isClosedForRead());
                }
            };
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.L$0 = byteChannelSequentialBase;
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.I$0 = i;
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label = 1;
            if (awaitingSlot.sleep(function0, byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) != coroutine_suspended) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        flushImpl();
    }

    private final boolean flushImpl() {
        if (this.writable.isEmpty()) {
            this.slot.resume();
            return false;
        }
        flushWrittenBytes();
        this.slot.resume();
        return true;
    }

    private final void flushWrittenBytes() {
        synchronized (this.flushMutex) {
            int size = this.writable.getSize();
            ChunkBuffer stealAll$ktor_io = this.writable.stealAll$ktor_io();
            Intrinsics.checkNotNull(stealAll$ktor_io);
            this.flushBuffer.writeChunkBuffer$ktor_io(stealAll$ktor_io);
            _availableForRead$FU.addAndGet(this, size);
        }
    }

    protected final void prepareFlushedBytes() {
        synchronized (this.flushMutex) {
            UnsafeKt.unsafeAppend(this.readable, this.flushBuffer);
        }
    }

    private final void ensureNotClosed() {
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException("Channel " + this + " is already closed");
        }
    }

    private final void ensureNotFailed() {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotFailed(BytePacketBuilder closeable) {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return;
        }
        closeable.release();
        throw closedCause;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte b, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeByte$1 byteChannelSequentialBase$writeByte$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeByte$1) {
            byteChannelSequentialBase$writeByte$1 = (ByteChannelSequentialBase$writeByte$1) continuation;
            if ((byteChannelSequentialBase$writeByte$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeByte$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeByte$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeByte$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeByte$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeByte$1.B$0 = b;
                    byteChannelSequentialBase$writeByte$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeByte$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b = byteChannelSequentialBase$writeByte$1.B$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeByte$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                byteChannelSequentialBase.writable.writeByte(b);
                byteChannelSequentialBase.afterWrite(1);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeByte$1 = new ByteChannelSequentialBase$writeByte$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeByte$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeByte$1.label;
        if (i != 0) {
        }
        byteChannelSequentialBase.writable.writeByte(b);
        byteChannelSequentialBase.afterWrite(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, short s, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeShort$1 byteChannelSequentialBase$writeShort$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeShort$1) {
            byteChannelSequentialBase$writeShort$1 = (ByteChannelSequentialBase$writeShort$1) continuation;
            if ((byteChannelSequentialBase$writeShort$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeShort$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeShort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeShort$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeShort$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeShort$1.S$0 = s;
                    byteChannelSequentialBase$writeShort$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(2, byteChannelSequentialBase$writeShort$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s = byteChannelSequentialBase$writeShort$1.S$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeShort$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                OutputPrimitivesKt.writeShort(byteChannelSequentialBase.writable, s);
                byteChannelSequentialBase.afterWrite(2);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeShort$1 = new ByteChannelSequentialBase$writeShort$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeShort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeShort$1.label;
        if (i != 0) {
        }
        OutputPrimitivesKt.writeShort(byteChannelSequentialBase.writable, s);
        byteChannelSequentialBase.afterWrite(2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeInt$1 byteChannelSequentialBase$writeInt$1;
        int i2;
        if (continuation instanceof ByteChannelSequentialBase$writeInt$1) {
            byteChannelSequentialBase$writeInt$1 = (ByteChannelSequentialBase$writeInt$1) continuation;
            if ((byteChannelSequentialBase$writeInt$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeInt$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeInt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$writeInt$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeInt$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeInt$1.I$0 = i;
                    byteChannelSequentialBase$writeInt$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(4, byteChannelSequentialBase$writeInt$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteChannelSequentialBase$writeInt$1.I$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeInt$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                OutputPrimitivesKt.writeInt(byteChannelSequentialBase.writable, i);
                byteChannelSequentialBase.afterWrite(4);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeInt$1 = new ByteChannelSequentialBase$writeInt$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeInt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$writeInt$1.label;
        if (i2 != 0) {
        }
        OutputPrimitivesKt.writeInt(byteChannelSequentialBase.writable, i);
        byteChannelSequentialBase.afterWrite(4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeLong$1 byteChannelSequentialBase$writeLong$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeLong$1) {
            byteChannelSequentialBase$writeLong$1 = (ByteChannelSequentialBase$writeLong$1) continuation;
            if ((byteChannelSequentialBase$writeLong$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeLong$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeLong$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeLong$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeLong$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeLong$1.J$0 = j;
                    byteChannelSequentialBase$writeLong$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(8, byteChannelSequentialBase$writeLong$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = byteChannelSequentialBase$writeLong$1.J$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeLong$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                OutputPrimitivesKt.writeLong(byteChannelSequentialBase.writable, j);
                byteChannelSequentialBase.afterWrite(8);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeLong$1 = new ByteChannelSequentialBase$writeLong$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeLong$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeLong$1.label;
        if (i != 0) {
        }
        OutputPrimitivesKt.writeLong(byteChannelSequentialBase.writable, j);
        byteChannelSequentialBase.afterWrite(8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, float f, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeFloat$1 byteChannelSequentialBase$writeFloat$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeFloat$1) {
            byteChannelSequentialBase$writeFloat$1 = (ByteChannelSequentialBase$writeFloat$1) continuation;
            if ((byteChannelSequentialBase$writeFloat$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeFloat$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeFloat$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeFloat$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeFloat$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeFloat$1.F$0 = f;
                    byteChannelSequentialBase$writeFloat$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(4, byteChannelSequentialBase$writeFloat$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f = byteChannelSequentialBase$writeFloat$1.F$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeFloat$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                OutputPrimitivesKt.writeFloat(byteChannelSequentialBase.writable, f);
                byteChannelSequentialBase.afterWrite(4);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeFloat$1 = new ByteChannelSequentialBase$writeFloat$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeFloat$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeFloat$1.label;
        if (i != 0) {
        }
        OutputPrimitivesKt.writeFloat(byteChannelSequentialBase.writable, f);
        byteChannelSequentialBase.afterWrite(4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, double d, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeDouble$1 byteChannelSequentialBase$writeDouble$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeDouble$1) {
            byteChannelSequentialBase$writeDouble$1 = (ByteChannelSequentialBase$writeDouble$1) continuation;
            if ((byteChannelSequentialBase$writeDouble$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeDouble$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeDouble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeDouble$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeDouble$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeDouble$1.D$0 = d;
                    byteChannelSequentialBase$writeDouble$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(8, byteChannelSequentialBase$writeDouble$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d = byteChannelSequentialBase$writeDouble$1.D$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeDouble$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                OutputPrimitivesKt.writeDouble(byteChannelSequentialBase.writable, d);
                byteChannelSequentialBase.afterWrite(8);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeDouble$1 = new ByteChannelSequentialBase$writeDouble$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeDouble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeDouble$1.label;
        if (i != 0) {
        }
        OutputPrimitivesKt.writeDouble(byteChannelSequentialBase.writable, d);
        byteChannelSequentialBase.afterWrite(8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writePacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writePacket$1 byteChannelSequentialBase$writePacket$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writePacket$1) {
            byteChannelSequentialBase$writePacket$1 = (ByteChannelSequentialBase$writePacket$1) continuation;
            if ((byteChannelSequentialBase$writePacket$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writePacket$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writePacket$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writePacket$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writePacket$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writePacket$1.L$1 = byteReadPacket;
                    byteChannelSequentialBase$writePacket$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writePacket$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteReadPacket = (ByteReadPacket) byteChannelSequentialBase$writePacket$1.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writePacket$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                int remaining = (int) byteReadPacket.getRemaining();
                byteChannelSequentialBase.writable.writePacket(byteReadPacket);
                byteChannelSequentialBase.afterWrite(remaining);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writePacket$1 = new ByteChannelSequentialBase$writePacket$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writePacket$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writePacket$1.label;
        if (i != 0) {
        }
        int remaining2 = (int) byteReadPacket.getRemaining();
        byteChannelSequentialBase.writable.writePacket(byteReadPacket);
        byteChannelSequentialBase.afterWrite(remaining2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Buffer buffer, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeFully$1 byteChannelSequentialBase$writeFully$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$writeFully$1) {
            byteChannelSequentialBase$writeFully$1 = (ByteChannelSequentialBase$writeFully$1) continuation;
            if ((byteChannelSequentialBase$writeFully$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeFully$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeFully$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeFully$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeFully$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$writeFully$1.L$1 = buffer;
                    byteChannelSequentialBase$writeFully$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeFully$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) byteChannelSequentialBase$writeFully$1.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeFully$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
                OutputKt.writeFully$default(byteChannelSequentialBase.writable, buffer, 0, 2, null);
                byteChannelSequentialBase.afterWrite(writePosition);
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$writeFully$1 = new ByteChannelSequentialBase$writeFully$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeFully$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeFully$1.label;
        if (i != 0) {
        }
        int writePosition2 = buffer.getWritePosition() - buffer.getReadPosition();
        OutputKt.writeFully$default(byteChannelSequentialBase.writable, buffer, 0, 2, null);
        byteChannelSequentialBase.afterWrite(writePosition2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:10:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeFully$2 byteChannelSequentialBase$writeFully$2;
        int i3;
        ByteChannelSequentialBase byteChannelSequentialBase2;
        int i4;
        int i5;
        byte[] bArr2;
        if (continuation instanceof ByteChannelSequentialBase$writeFully$2) {
            byteChannelSequentialBase$writeFully$2 = (ByteChannelSequentialBase$writeFully$2) continuation;
            if ((byteChannelSequentialBase$writeFully$2.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeFully$2.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeFully$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$writeFully$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase2 = byteChannelSequentialBase;
                    i4 = i2 + i;
                    i5 = i;
                    bArr2 = bArr;
                    if (i5 < i4) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i4 = byteChannelSequentialBase$writeFully$2.I$1;
                    int i6 = byteChannelSequentialBase$writeFully$2.I$0;
                    bArr2 = (byte[]) byteChannelSequentialBase$writeFully$2.L$1;
                    ByteChannelSequentialBase byteChannelSequentialBase3 = (ByteChannelSequentialBase) byteChannelSequentialBase$writeFully$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    i5 = i6;
                    byteChannelSequentialBase2 = byteChannelSequentialBase3;
                    int min = Math.min(byteChannelSequentialBase2.getAvailableForWrite(), i4 - i5);
                    OutputKt.writeFully((Output) byteChannelSequentialBase2.writable, bArr2, i5, min);
                    i5 += min;
                    byteChannelSequentialBase2.afterWrite(min);
                    if (i5 < i4) {
                        byteChannelSequentialBase$writeFully$2.L$0 = byteChannelSequentialBase2;
                        byteChannelSequentialBase$writeFully$2.L$1 = bArr2;
                        byteChannelSequentialBase$writeFully$2.I$0 = i5;
                        byteChannelSequentialBase$writeFully$2.I$1 = i4;
                        byteChannelSequentialBase$writeFully$2.label = 1;
                        if (byteChannelSequentialBase2.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeFully$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int min2 = Math.min(byteChannelSequentialBase2.getAvailableForWrite(), i4 - i5);
                        OutputKt.writeFully((Output) byteChannelSequentialBase2.writable, bArr2, i5, min2);
                        i5 += min2;
                        byteChannelSequentialBase2.afterWrite(min2);
                        if (i5 < i4) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        byteChannelSequentialBase$writeFully$2 = new ByteChannelSequentialBase$writeFully$2(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeFully$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$writeFully$2.label;
        if (i3 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0056 -> B:10:0x0059). Please report as a decompilation issue!!! */
    /* renamed from: writeFully-JT6ljtQ$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object m9957writeFullyJT6ljtQ$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$writeFully$3 byteChannelSequentialBase$writeFully$3;
        int i3;
        if (continuation instanceof ByteChannelSequentialBase$writeFully$3) {
            byteChannelSequentialBase$writeFully$3 = (ByteChannelSequentialBase$writeFully$3) continuation;
            if ((byteChannelSequentialBase$writeFully$3.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeFully$3.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeFully$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$writeFully$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i < i2) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = byteChannelSequentialBase$writeFully$3.I$1;
                    int i5 = byteChannelSequentialBase$writeFully$3.I$0;
                    ByteBuffer byteBuffer2 = (ByteBuffer) byteChannelSequentialBase$writeFully$3.L$1;
                    ByteChannelSequentialBase byteChannelSequentialBase2 = (ByteChannelSequentialBase) byteChannelSequentialBase$writeFully$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i4;
                    byteChannelSequentialBase = byteChannelSequentialBase2;
                    i2 = i5;
                    byteBuffer = byteBuffer2;
                    int min = Math.min(byteChannelSequentialBase.getAvailableForWrite(), i2 - i);
                    OutputKt.m10182writeFullyUAd2zVI((Output) byteChannelSequentialBase.writable, byteBuffer, i, min);
                    i += min;
                    byteChannelSequentialBase.afterWrite(min);
                    if (i < i2) {
                        byteChannelSequentialBase$writeFully$3.L$0 = byteChannelSequentialBase;
                        byteChannelSequentialBase$writeFully$3.L$1 = byteBuffer;
                        byteChannelSequentialBase$writeFully$3.I$0 = i2;
                        byteChannelSequentialBase$writeFully$3.I$1 = i;
                        byteChannelSequentialBase$writeFully$3.label = 1;
                        if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeFully$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int min2 = Math.min(byteChannelSequentialBase.getAvailableForWrite(), i2 - i);
                        OutputKt.m10182writeFullyUAd2zVI((Output) byteChannelSequentialBase.writable, byteBuffer, i, min2);
                        i += min2;
                        byteChannelSequentialBase.afterWrite(min2);
                        if (i < i2) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        byteChannelSequentialBase$writeFully$3 = new ByteChannelSequentialBase$writeFully$3(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$writeFully$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$writeFully$3.label;
        if (i3 != 0) {
        }
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        int writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
        if (writePosition == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(writePosition, byteChannelSequentialBase.getAvailableForWrite());
        if (min == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(chunkBuffer, continuation);
        }
        OutputKt.writeFully(byteChannelSequentialBase.writable, chunkBuffer2, min);
        byteChannelSequentialBase.afterWrite(min);
        return Boxing.boxInt(min);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        if (i2 == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(i2, byteChannelSequentialBase.getAvailableForWrite());
        if (min == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(bArr, i, i2, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.writable, bArr, i, min);
        byteChannelSequentialBase.afterWrite(min);
        return Boxing.boxInt(min);
    }

    @Deprecated(message = "Use write { } instead.")
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object invoke = function2.invoke(byteChannelSequentialBase.beginWriteSession(), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        return new WriterSuspendSession() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$beginWriteSession$1
            @Override // io.ktor.utils.io.WriterSession
            public ChunkBuffer request(int min) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() == 0) {
                    return null;
                }
                return ByteChannelSequentialBase.this.getWritable().prepareWriteHead(min);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void written(int n) {
                ByteChannelSequentialBase.this.getWritable().afterHeadWrite();
                ByteChannelSequentialBase.this.afterWrite(n);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void flush() {
                ByteChannelSequentialBase.this.flush();
            }

            @Override // io.ktor.utils.io.WriterSuspendSession
            public Object tryAwait(int i, Continuation<? super Unit> continuation) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() < i) {
                    Object awaitAtLeastNBytesAvailableForWrite$ktor_io = ByteChannelSequentialBase.this.awaitAtLeastNBytesAvailableForWrite$ktor_io(i, continuation);
                    return awaitAtLeastNBytesAvailableForWrite$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAtLeastNBytesAvailableForWrite$ktor_io : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public void endWriteSession(int written) {
        this.writable.afterHeadWrite();
        afterWrite(written);
    }

    static /* synthetic */ Object readByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Byte> continuation) {
        if (!byteChannelSequentialBase.readable.getEndOfInput()) {
            byte readByte = byteChannelSequentialBase.readable.readByte();
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxByte(readByte);
        }
        return byteChannelSequentialBase.readByteSlow(continuation);
    }

    static /* synthetic */ void checkClosed$default(ByteChannelSequentialBase byteChannelSequentialBase, int i, BytePacketBuilder bytePacketBuilder, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
        }
        if ((i2 & 2) != 0) {
            bytePacketBuilder = null;
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
    }

    private final void checkClosed(int remaining, BytePacketBuilder closeable) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            if (closeable != null) {
                closeable.close();
                throw closedCause;
            }
            throw closedCause;
        }
        if (!getClosed() || get_availableForRead() >= remaining) {
            return;
        }
        if (closeable != null) {
            closeable.close();
        }
        throw new EOFException(remaining + " bytes required but EOF reached");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:10:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readByteSlow(Continuation<? super Byte> continuation) {
        ByteChannelSequentialBase$readByteSlow$1 byteChannelSequentialBase$readByteSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readByteSlow$1) {
            byteChannelSequentialBase$readByteSlow$1 = (ByteChannelSequentialBase$readByteSlow$1) continuation;
            if ((byteChannelSequentialBase$readByteSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readByteSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readByteSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readByteSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                    byteChannelSequentialBase$readByteSlow$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$readByteSlow$1.label = 1;
                    if (byteChannelSequentialBase.awaitSuspend(1, byteChannelSequentialBase$readByteSlow$1) == coroutine_suspended) {
                    }
                    if (!byteChannelSequentialBase.readable.getEndOfInput()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readByteSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!byteChannelSequentialBase.readable.getEndOfInput()) {
                        Byte boxByte = Boxing.boxByte(byteChannelSequentialBase.readable.readByte());
                        boxByte.byteValue();
                        byteChannelSequentialBase.afterRead(1);
                        return boxByte;
                    }
                    checkClosed$default(byteChannelSequentialBase, 1, null, 2, null);
                    byteChannelSequentialBase$readByteSlow$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$readByteSlow$1.label = 1;
                    if (byteChannelSequentialBase.awaitSuspend(1, byteChannelSequentialBase$readByteSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!byteChannelSequentialBase.readable.getEndOfInput()) {
                    }
                }
            }
        }
        byteChannelSequentialBase$readByteSlow$1 = new ByteChannelSequentialBase$readByteSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readByteSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readByteSlow$1.label;
        if (i != 0) {
        }
    }

    static /* synthetic */ Object readShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Short> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(2)) {
            short readShort = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(2);
            return Boxing.boxShort(readShort);
        }
        return byteChannelSequentialBase.readShortSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readShortSlow(Continuation<? super Short> continuation) {
        ByteChannelSequentialBase$readShortSlow$1 byteChannelSequentialBase$readShortSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readShortSlow$1) {
            byteChannelSequentialBase$readShortSlow$1 = (ByteChannelSequentialBase$readShortSlow$1) continuation;
            if ((byteChannelSequentialBase$readShortSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readShortSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readShortSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readShortSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readShortSlow$1.L$0 = this;
                    byteChannelSequentialBase$readShortSlow$1.label = 1;
                    if (awaitSuspend(2, byteChannelSequentialBase$readShortSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readShortSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                short readShort = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
                byteChannelSequentialBase.afterRead(2);
                return Boxing.boxShort(readShort);
            }
        }
        byteChannelSequentialBase$readShortSlow$1 = new ByteChannelSequentialBase$readShortSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readShortSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readShortSlow$1.label;
        if (i != 0) {
        }
        short readShort2 = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(2);
        return Boxing.boxShort(readShort2);
    }

    protected final void afterRead(int count) {
        addBytesRead(count);
        this.slot.resume();
    }

    static /* synthetic */ Object readInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Integer> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            int readInt = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxInt(readInt);
        }
        return byteChannelSequentialBase.readIntSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readIntSlow(Continuation<? super Integer> continuation) {
        ByteChannelSequentialBase$readIntSlow$1 byteChannelSequentialBase$readIntSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readIntSlow$1) {
            byteChannelSequentialBase$readIntSlow$1 = (ByteChannelSequentialBase$readIntSlow$1) continuation;
            if ((byteChannelSequentialBase$readIntSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readIntSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readIntSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readIntSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readIntSlow$1.L$0 = this;
                    byteChannelSequentialBase$readIntSlow$1.label = 1;
                    if (awaitSuspend(4, byteChannelSequentialBase$readIntSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readIntSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                int readInt = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
                byteChannelSequentialBase.afterRead(4);
                return Boxing.boxInt(readInt);
            }
        }
        byteChannelSequentialBase$readIntSlow$1 = new ByteChannelSequentialBase$readIntSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readIntSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readIntSlow$1.label;
        if (i != 0) {
        }
        int readInt2 = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxInt(readInt2);
    }

    static /* synthetic */ Object readLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Long> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            long readLong = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxLong(readLong);
        }
        return byteChannelSequentialBase.readLongSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLongSlow(Continuation<? super Long> continuation) {
        ByteChannelSequentialBase$readLongSlow$1 byteChannelSequentialBase$readLongSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readLongSlow$1) {
            byteChannelSequentialBase$readLongSlow$1 = (ByteChannelSequentialBase$readLongSlow$1) continuation;
            if ((byteChannelSequentialBase$readLongSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readLongSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readLongSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readLongSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readLongSlow$1.L$0 = this;
                    byteChannelSequentialBase$readLongSlow$1.label = 1;
                    if (awaitSuspend(8, byteChannelSequentialBase$readLongSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readLongSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long readLong = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
                byteChannelSequentialBase.afterRead(8);
                return Boxing.boxLong(readLong);
            }
        }
        byteChannelSequentialBase$readLongSlow$1 = new ByteChannelSequentialBase$readLongSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readLongSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readLongSlow$1.label;
        if (i != 0) {
        }
        long readLong2 = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxLong(readLong2);
    }

    static /* synthetic */ Object readFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Float> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            float readFloat = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxFloat(readFloat);
        }
        return byteChannelSequentialBase.readFloatSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFloatSlow(Continuation<? super Float> continuation) {
        ByteChannelSequentialBase$readFloatSlow$1 byteChannelSequentialBase$readFloatSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readFloatSlow$1) {
            byteChannelSequentialBase$readFloatSlow$1 = (ByteChannelSequentialBase$readFloatSlow$1) continuation;
            if ((byteChannelSequentialBase$readFloatSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readFloatSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readFloatSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readFloatSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readFloatSlow$1.L$0 = this;
                    byteChannelSequentialBase$readFloatSlow$1.label = 1;
                    if (awaitSuspend(4, byteChannelSequentialBase$readFloatSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readFloatSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                float readFloat = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
                byteChannelSequentialBase.afterRead(4);
                return Boxing.boxFloat(readFloat);
            }
        }
        byteChannelSequentialBase$readFloatSlow$1 = new ByteChannelSequentialBase$readFloatSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readFloatSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readFloatSlow$1.label;
        if (i != 0) {
        }
        float readFloat2 = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxFloat(readFloat2);
    }

    static /* synthetic */ Object readDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Double> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            double readDouble = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxDouble(readDouble);
        }
        return byteChannelSequentialBase.readDoubleSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDoubleSlow(Continuation<? super Double> continuation) {
        ByteChannelSequentialBase$readDoubleSlow$1 byteChannelSequentialBase$readDoubleSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readDoubleSlow$1) {
            byteChannelSequentialBase$readDoubleSlow$1 = (ByteChannelSequentialBase$readDoubleSlow$1) continuation;
            if ((byteChannelSequentialBase$readDoubleSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readDoubleSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readDoubleSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readDoubleSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readDoubleSlow$1.L$0 = this;
                    byteChannelSequentialBase$readDoubleSlow$1.label = 1;
                    if (awaitSuspend(8, byteChannelSequentialBase$readDoubleSlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readDoubleSlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                double readDouble = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
                byteChannelSequentialBase.afterRead(8);
                return Boxing.boxDouble(readDouble);
            }
        }
        byteChannelSequentialBase$readDoubleSlow$1 = new ByteChannelSequentialBase$readDoubleSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readDoubleSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readDoubleSlow$1.label;
        if (i != 0) {
        }
        double readDouble2 = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxDouble(readDouble2);
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super ByteReadPacket> continuation) {
        byteChannelSequentialBase.ensureNotFailed();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        long min = Math.min(j, byteChannelSequentialBase.readable.getRemaining());
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
        byteChannelSequentialBase.afterRead((int) min);
        if (j - bytePacketBuilder.getSize() == 0 || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
            return bytePacketBuilder.build();
        }
        return byteChannelSequentialBase.readRemainingSuspend(bytePacketBuilder, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readRemainingSuspend(BytePacketBuilder bytePacketBuilder, long j, Continuation<? super ByteReadPacket> continuation) {
        ByteChannelSequentialBase$readRemainingSuspend$1 byteChannelSequentialBase$readRemainingSuspend$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readRemainingSuspend$1) {
            byteChannelSequentialBase$readRemainingSuspend$1 = (ByteChannelSequentialBase$readRemainingSuspend$1) continuation;
            if ((byteChannelSequentialBase$readRemainingSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readRemainingSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readRemainingSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readRemainingSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j2 = byteChannelSequentialBase$readRemainingSuspend$1.J$0;
                    BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) byteChannelSequentialBase$readRemainingSuspend$1.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readRemainingSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    bytePacketBuilder = bytePacketBuilder2;
                    j = j2;
                }
                while (bytePacketBuilder.getSize() < j) {
                    long min = Math.min(j - bytePacketBuilder.getSize(), byteChannelSequentialBase.readable.getRemaining());
                    bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
                    byteChannelSequentialBase.afterRead((int) min);
                    byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
                    if (byteChannelSequentialBase.isClosedForRead() || bytePacketBuilder.getSize() == ((int) j)) {
                        break;
                    }
                    byteChannelSequentialBase$readRemainingSuspend$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$readRemainingSuspend$1.L$1 = bytePacketBuilder;
                    byteChannelSequentialBase$readRemainingSuspend$1.J$0 = j;
                    byteChannelSequentialBase$readRemainingSuspend$1.label = 1;
                    if (byteChannelSequentialBase.awaitSuspend(1, byteChannelSequentialBase$readRemainingSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
                return bytePacketBuilder.build();
            }
        }
        byteChannelSequentialBase$readRemainingSuspend$1 = new ByteChannelSequentialBase$readRemainingSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readRemainingSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readRemainingSuspend$1.label;
        if (i != 0) {
        }
        while (bytePacketBuilder.getSize() < j) {
        }
        byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
        return bytePacketBuilder.build();
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super ByteReadPacket> continuation) {
        checkClosed$default(byteChannelSequentialBase, i, null, 2, null);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        int min = (int) Math.min(i, byteChannelSequentialBase.readable.getRemaining());
        int i2 = i - min;
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
        byteChannelSequentialBase.afterRead(min);
        byteChannelSequentialBase.checkClosed(i2, bytePacketBuilder);
        if (i2 > 0) {
            return byteChannelSequentialBase.readPacketSuspend(bytePacketBuilder, i2, continuation);
        }
        return bytePacketBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readPacketSuspend(BytePacketBuilder bytePacketBuilder, int i, Continuation<? super ByteReadPacket> continuation) {
        ByteChannelSequentialBase$readPacketSuspend$1 byteChannelSequentialBase$readPacketSuspend$1;
        int i2;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readPacketSuspend$1) {
            byteChannelSequentialBase$readPacketSuspend$1 = (ByteChannelSequentialBase$readPacketSuspend$1) continuation;
            if ((byteChannelSequentialBase$readPacketSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readPacketSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readPacketSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$readPacketSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = byteChannelSequentialBase$readPacketSuspend$1.I$0;
                    BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) byteChannelSequentialBase$readPacketSuspend$1.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readPacketSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    bytePacketBuilder = bytePacketBuilder2;
                }
                while (i > 0) {
                    int min = (int) Math.min(i, byteChannelSequentialBase.readable.getRemaining());
                    i -= min;
                    bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
                    byteChannelSequentialBase.afterRead(min);
                    byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
                    if (i > 0) {
                        byteChannelSequentialBase$readPacketSuspend$1.L$0 = byteChannelSequentialBase;
                        byteChannelSequentialBase$readPacketSuspend$1.L$1 = bytePacketBuilder;
                        byteChannelSequentialBase$readPacketSuspend$1.I$0 = i;
                        byteChannelSequentialBase$readPacketSuspend$1.label = 1;
                        if (byteChannelSequentialBase.awaitSuspend(1, byteChannelSequentialBase$readPacketSuspend$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
                return bytePacketBuilder.build();
            }
        }
        byteChannelSequentialBase$readPacketSuspend$1 = new ByteChannelSequentialBase$readPacketSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readPacketSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$readPacketSuspend$1.label;
        if (i2 != 0) {
        }
        while (i > 0) {
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
        return bytePacketBuilder.build();
    }

    protected final int readAvailableClosed() {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (get_availableForRead() <= 0) {
            return -1;
        }
        prepareFlushedBytes();
        return -1;
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        return byteChannelSequentialBase.readAvailable$ktor_io(chunkBuffer, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAvailable$ktor_io(Buffer buffer, Continuation<? super Integer> continuation) {
        ByteChannelSequentialBase$readAvailable$2 byteChannelSequentialBase$readAvailable$2;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readAvailable$2) {
            byteChannelSequentialBase$readAvailable$2 = (ByteChannelSequentialBase$readAvailable$2) continuation;
            if ((byteChannelSequentialBase$readAvailable$2.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readAvailable$2.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readAvailable$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readAvailable$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable closedCause = getClosedCause();
                    if (closedCause != null) {
                        throw closedCause;
                    }
                    if (getClosed() && get_availableForRead() == 0) {
                        return Boxing.boxInt(-1);
                    }
                    if (buffer.getLimit() - buffer.getWritePosition() == 0) {
                        return Boxing.boxInt(0);
                    }
                    if (get_availableForRead() == 0) {
                        byteChannelSequentialBase$readAvailable$2.L$0 = this;
                        byteChannelSequentialBase$readAvailable$2.L$1 = buffer;
                        byteChannelSequentialBase$readAvailable$2.label = 1;
                        if (awaitSuspend(1, byteChannelSequentialBase$readAvailable$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) byteChannelSequentialBase$readAvailable$2.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readAvailable$2.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!byteChannelSequentialBase.readable.canRead()) {
                    byteChannelSequentialBase.prepareFlushedBytes();
                }
                int min = (int) Math.min(buffer.getLimit() - buffer.getWritePosition(), byteChannelSequentialBase.readable.getRemaining());
                InputArraysKt.readFully(byteChannelSequentialBase.readable, buffer, min);
                byteChannelSequentialBase.afterRead(min);
                return Boxing.boxInt(min);
            }
        }
        byteChannelSequentialBase$readAvailable$2 = new ByteChannelSequentialBase$readAvailable$2(this, continuation);
        Object obj2 = byteChannelSequentialBase$readAvailable$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readAvailable$2.label;
        if (i != 0) {
        }
        if (!byteChannelSequentialBase.readable.canRead()) {
        }
        int min2 = (int) Math.min(buffer.getLimit() - buffer.getWritePosition(), byteChannelSequentialBase.readable.getRemaining());
        InputArraysKt.readFully(byteChannelSequentialBase.readable, buffer, min2);
        byteChannelSequentialBase.afterRead(min2);
        return Boxing.boxInt(min2);
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        Object readFully = byteChannelSequentialBase.readFully((Buffer) chunkBuffer, i, continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r2.readFully(r6, r7, r0) != r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(Buffer buffer, int i, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$readFullySuspend$1 byteChannelSequentialBase$readFullySuspend$1;
        int i2;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readFullySuspend$1) {
            byteChannelSequentialBase$readFullySuspend$1 = (ByteChannelSequentialBase$readFullySuspend$1) continuation;
            if ((byteChannelSequentialBase$readFullySuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readFullySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readFullySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$readFullySuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readFullySuspend$1.L$0 = this;
                    byteChannelSequentialBase$readFullySuspend$1.L$1 = buffer;
                    byteChannelSequentialBase$readFullySuspend$1.I$0 = i;
                    byteChannelSequentialBase$readFullySuspend$1.label = 1;
                    if (awaitSuspend(i, byteChannelSequentialBase$readFullySuspend$1) != coroutine_suspended) {
                        byteChannelSequentialBase = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                i = byteChannelSequentialBase$readFullySuspend$1.I$0;
                buffer = (Buffer) byteChannelSequentialBase$readFullySuspend$1.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readFullySuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                byteChannelSequentialBase$readFullySuspend$1.L$0 = null;
                byteChannelSequentialBase$readFullySuspend$1.L$1 = null;
                byteChannelSequentialBase$readFullySuspend$1.label = 2;
            }
        }
        byteChannelSequentialBase$readFullySuspend$1 = new ByteChannelSequentialBase$readFullySuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readFullySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$readFullySuspend$1.label;
        if (i2 != 0) {
        }
        byteChannelSequentialBase$readFullySuspend$1.L$0 = null;
        byteChannelSequentialBase$readFullySuspend$1.L$1 = null;
        byteChannelSequentialBase$readFullySuspend$1.label = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        ByteChannelSequentialBase$readAvailable$4 byteChannelSequentialBase$readAvailable$4;
        int i3;
        if (continuation instanceof ByteChannelSequentialBase$readAvailable$4) {
            byteChannelSequentialBase$readAvailable$4 = (ByteChannelSequentialBase$readAvailable$4) continuation;
            if ((byteChannelSequentialBase$readAvailable$4.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readAvailable$4.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readAvailable$4.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$readAvailable$4.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable closedCause = byteChannelSequentialBase.getClosedCause();
                    if (closedCause != null) {
                        throw closedCause;
                    }
                    if (byteChannelSequentialBase.getClosed() && byteChannelSequentialBase.get_availableForRead() == 0) {
                        return Boxing.boxInt(-1);
                    }
                    if (i2 == 0) {
                        return Boxing.boxInt(0);
                    }
                    if (byteChannelSequentialBase.get_availableForRead() == 0) {
                        byteChannelSequentialBase$readAvailable$4.L$0 = byteChannelSequentialBase;
                        byteChannelSequentialBase$readAvailable$4.L$1 = bArr;
                        byteChannelSequentialBase$readAvailable$4.I$0 = i;
                        byteChannelSequentialBase$readAvailable$4.I$1 = i2;
                        byteChannelSequentialBase$readAvailable$4.label = 1;
                        if (byteChannelSequentialBase.awaitSuspend(1, byteChannelSequentialBase$readAvailable$4) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = byteChannelSequentialBase$readAvailable$4.I$1;
                    int i5 = byteChannelSequentialBase$readAvailable$4.I$0;
                    byte[] bArr2 = (byte[]) byteChannelSequentialBase$readAvailable$4.L$1;
                    ByteChannelSequentialBase byteChannelSequentialBase2 = (ByteChannelSequentialBase) byteChannelSequentialBase$readAvailable$4.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i4;
                    byteChannelSequentialBase = byteChannelSequentialBase2;
                    i = i5;
                    bArr = bArr2;
                }
                if (!byteChannelSequentialBase.readable.canRead()) {
                    byteChannelSequentialBase.prepareFlushedBytes();
                }
                int min = (int) Math.min(i2, byteChannelSequentialBase.readable.getRemaining());
                InputArraysKt.readFully((Input) byteChannelSequentialBase.readable, bArr, i, min);
                byteChannelSequentialBase.afterRead(min);
                return Boxing.boxInt(min);
            }
        }
        byteChannelSequentialBase$readAvailable$4 = new ByteChannelSequentialBase$readAvailable$4(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$readAvailable$4.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$readAvailable$4.label;
        if (i3 != 0) {
        }
        if (!byteChannelSequentialBase.readable.canRead()) {
        }
        int min2 = (int) Math.min(i2, byteChannelSequentialBase.readable.getRemaining());
        InputArraysKt.readFully((Input) byteChannelSequentialBase.readable, bArr, i, min2);
        byteChannelSequentialBase.afterRead(min2);
        return Boxing.boxInt(min2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        if (r5.readFullySuspend(r6, r7 + r9, r8 - r9, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r9 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$readFully$6 byteChannelSequentialBase$readFully$6;
        int i3;
        int intValue;
        if (continuation instanceof ByteChannelSequentialBase$readFully$6) {
            byteChannelSequentialBase$readFully$6 = (ByteChannelSequentialBase$readFully$6) continuation;
            if ((byteChannelSequentialBase$readFully$6.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readFully$6.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readFully$6.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$readFully$6.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readFully$6.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$readFully$6.L$1 = bArr;
                    byteChannelSequentialBase$readFully$6.I$0 = i;
                    byteChannelSequentialBase$readFully$6.I$1 = i2;
                    byteChannelSequentialBase$readFully$6.label = 1;
                    obj = byteChannelSequentialBase.readAvailable(bArr, i, i2, byteChannelSequentialBase$readFully$6);
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    i2 = byteChannelSequentialBase$readFully$6.I$1;
                    i = byteChannelSequentialBase$readFully$6.I$0;
                    bArr = (byte[]) byteChannelSequentialBase$readFully$6.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readFully$6.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                intValue = ((Number) obj).intValue();
                if (intValue != i2) {
                    return Unit.INSTANCE;
                }
                if (intValue == -1) {
                    throw new EOFException("Unexpected end of stream");
                }
                byteChannelSequentialBase$readFully$6.L$0 = null;
                byteChannelSequentialBase$readFully$6.L$1 = null;
                byteChannelSequentialBase$readFully$6.label = 2;
            }
        }
        byteChannelSequentialBase$readFully$6 = new ByteChannelSequentialBase$readFully$6(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$readFully$6.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$readFully$6.label;
        if (i3 != 0) {
        }
        intValue = ((Number) obj2).intValue();
        if (intValue != i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:10:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$readFullySuspend$2 byteChannelSequentialBase$readFullySuspend$2;
        int i3;
        byte[] bArr2;
        int i4;
        int i5;
        int i6;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readFullySuspend$2) {
            byteChannelSequentialBase$readFullySuspend$2 = (ByteChannelSequentialBase$readFullySuspend$2) continuation;
            if ((byteChannelSequentialBase$readFullySuspend$2.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readFullySuspend$2.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readFullySuspend$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$readFullySuspend$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bArr2 = bArr;
                    i4 = 0;
                    i5 = i2;
                    i6 = i;
                    byteChannelSequentialBase = this;
                    if (i4 >= i5) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i4 = byteChannelSequentialBase$readFullySuspend$2.I$2;
                    int i7 = byteChannelSequentialBase$readFullySuspend$2.I$1;
                    i6 = byteChannelSequentialBase$readFullySuspend$2.I$0;
                    byte[] bArr3 = (byte[]) byteChannelSequentialBase$readFullySuspend$2.L$1;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readFullySuspend$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    ByteChannelSequentialBase$readFullySuspend$2 byteChannelSequentialBase$readFullySuspend$22 = byteChannelSequentialBase$readFullySuspend$2;
                    int i8 = i7;
                    bArr2 = bArr3;
                    ByteChannelSequentialBase$readFullySuspend$2 byteChannelSequentialBase$readFullySuspend$23 = byteChannelSequentialBase$readFullySuspend$22;
                    int intValue = ((Number) obj).intValue();
                    if (intValue == -1) {
                        i4 += intValue;
                        i5 = i8;
                        byteChannelSequentialBase$readFullySuspend$2 = byteChannelSequentialBase$readFullySuspend$23;
                        if (i4 >= i5) {
                            byteChannelSequentialBase$readFullySuspend$2.L$0 = byteChannelSequentialBase;
                            byteChannelSequentialBase$readFullySuspend$2.L$1 = bArr2;
                            byteChannelSequentialBase$readFullySuspend$2.I$0 = i6;
                            byteChannelSequentialBase$readFullySuspend$2.I$1 = i5;
                            byteChannelSequentialBase$readFullySuspend$2.I$2 = i4;
                            byteChannelSequentialBase$readFullySuspend$2.label = 1;
                            Object readAvailable = byteChannelSequentialBase.readAvailable(bArr2, i6 + i4, i5 - i4, byteChannelSequentialBase$readFullySuspend$2);
                            if (readAvailable == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            byteChannelSequentialBase$readFullySuspend$22 = byteChannelSequentialBase$readFullySuspend$2;
                            i8 = i5;
                            obj = readAvailable;
                            ByteChannelSequentialBase$readFullySuspend$2 byteChannelSequentialBase$readFullySuspend$232 = byteChannelSequentialBase$readFullySuspend$22;
                            int intValue2 = ((Number) obj).intValue();
                            if (intValue2 == -1) {
                                throw new EOFException("Unexpected end of stream");
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        byteChannelSequentialBase$readFullySuspend$2 = new ByteChannelSequentialBase$readFullySuspend$2(this, continuation);
        Object obj2 = byteChannelSequentialBase$readFullySuspend$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$readFullySuspend$2.label;
        if (i3 != 0) {
        }
    }

    static /* synthetic */ Object readBoolean$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Boolean> continuation) {
        if (byteChannelSequentialBase.readable.canRead()) {
            boolean z = byteChannelSequentialBase.readable.readByte() == 1;
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxBoolean(z);
        }
        return byteChannelSequentialBase.readBooleanSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readBooleanSlow(Continuation<? super Boolean> continuation) {
        ByteChannelSequentialBase$readBooleanSlow$1 byteChannelSequentialBase$readBooleanSlow$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$readBooleanSlow$1) {
            byteChannelSequentialBase$readBooleanSlow$1 = (ByteChannelSequentialBase$readBooleanSlow$1) continuation;
            if ((byteChannelSequentialBase$readBooleanSlow$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readBooleanSlow$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$readBooleanSlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$readBooleanSlow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$readBooleanSlow$1.L$0 = this;
                    byteChannelSequentialBase$readBooleanSlow$1.label = 1;
                    if (awaitSuspend(1, byteChannelSequentialBase$readBooleanSlow$1) != coroutine_suspended) {
                        byteChannelSequentialBase = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$readBooleanSlow$1.L$0;
                ResultKt.throwOnFailure(obj);
                checkClosed$default(byteChannelSequentialBase, 1, null, 2, null);
                byteChannelSequentialBase$readBooleanSlow$1.L$0 = null;
                byteChannelSequentialBase$readBooleanSlow$1.label = 2;
                Object readBoolean = byteChannelSequentialBase.readBoolean(byteChannelSequentialBase$readBooleanSlow$1);
                return readBoolean != coroutine_suspended ? coroutine_suspended : readBoolean;
            }
        }
        byteChannelSequentialBase$readBooleanSlow$1 = new ByteChannelSequentialBase$readBooleanSlow$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$readBooleanSlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readBooleanSlow$1.label;
        if (i != 0) {
        }
        checkClosed$default(byteChannelSequentialBase, 1, null, 2, null);
        byteChannelSequentialBase$readBooleanSlow$1.L$0 = null;
        byteChannelSequentialBase$readBooleanSlow$1.label = 2;
        Object readBoolean2 = byteChannelSequentialBase.readBoolean(byteChannelSequentialBase$readBooleanSlow$1);
        if (readBoolean2 != coroutine_suspended2) {
        }
    }

    private final void completeReading() {
        ChunkBuffer lastReadView = getLastReadView();
        int lastReadAvailable$delegate = getLastReadAvailable$delegate() - (lastReadView.getWritePosition() - lastReadView.getReadPosition());
        if (getLastReadView() != Buffer.INSTANCE.getEmpty()) {
            UnsafeKt.completeReadHead(this.readable, getLastReadView());
        }
        if (lastReadAvailable$delegate > 0) {
            afterRead(lastReadAvailable$delegate);
        }
        setLastReadAvailable(0);
        setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
    }

    static /* synthetic */ Object await$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super Boolean> continuation) {
        if (i < 0) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
        }
        long j = i;
        if (j > 4088) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
        }
        byteChannelSequentialBase.completeReading();
        if (i == 0) {
            return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead());
        }
        return byteChannelSequentialBase.readable.getRemaining() >= j ? Boxing.boxBoolean(true) : byteChannelSequentialBase.awaitSuspend(i, continuation);
    }

    public final Object awaitInternalAtLeast1$ktor_io(Continuation<? super Boolean> continuation) {
        if (this.readable.getEndOfInput()) {
            return awaitSuspend(1, continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final Object awaitSuspend(int i, Continuation<? super Boolean> continuation) {
        ByteChannelSequentialBase$awaitSuspend$1 byteChannelSequentialBase$awaitSuspend$1;
        int i2;
        ByteChannelSequentialBase byteChannelSequentialBase;
        Throwable closedCause;
        if (continuation instanceof ByteChannelSequentialBase$awaitSuspend$1) {
            byteChannelSequentialBase$awaitSuspend$1 = (ByteChannelSequentialBase$awaitSuspend$1) continuation;
            if ((byteChannelSequentialBase$awaitSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$awaitSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$awaitSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i < 0) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    byteChannelSequentialBase$awaitSuspend$1.L$0 = this;
                    byteChannelSequentialBase$awaitSuspend$1.I$0 = i;
                    byteChannelSequentialBase$awaitSuspend$1.label = 1;
                    if (awaitAtLeastNBytesAvailableForRead$ktor_io(i, byteChannelSequentialBase$awaitSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialBase = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteChannelSequentialBase$awaitSuspend$1.I$0;
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                byteChannelSequentialBase.prepareFlushedBytes();
                closedCause = byteChannelSequentialBase.getClosedCause();
                if (closedCause != null) {
                    return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead() && byteChannelSequentialBase.get_availableForRead() >= i);
                }
                throw closedCause;
            }
        }
        byteChannelSequentialBase$awaitSuspend$1 = new ByteChannelSequentialBase$awaitSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$awaitSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$awaitSuspend$1.label;
        if (i2 != 0) {
        }
        byteChannelSequentialBase.prepareFlushedBytes();
        closedCause = byteChannelSequentialBase.getClosedCause();
        if (closedCause != null) {
        }
    }

    @Override // io.ktor.utils.io.ReadSession
    public int discard(int n) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (n == 0) {
            return 0;
        }
        int discard = this.readable.discard(n);
        afterRead(n);
        requestNextView(1);
        return discard;
    }

    @Override // io.ktor.utils.io.ReadSession
    public ChunkBuffer request(int atLeast) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        completeReading();
        return requestNextView(atLeast);
    }

    private final ChunkBuffer requestNextView(int atLeast) {
        if (this.readable.getEndOfInput()) {
            prepareFlushedBytes();
        }
        ChunkBuffer prepareReadHead$ktor_io = this.readable.prepareReadHead$ktor_io(atLeast);
        if (prepareReadHead$ktor_io == null) {
            setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
            setLastReadAvailable(0);
            return prepareReadHead$ktor_io;
        }
        setLastReadView(prepareReadHead$ktor_io);
        ChunkBuffer chunkBuffer = prepareReadHead$ktor_io;
        setLastReadAvailable(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
        return prepareReadHead$ktor_io;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super Long> continuation) {
        long discard = byteChannelSequentialBase.readable.discard(j);
        byteChannelSequentialBase.afterRead((int) discard);
        if (discard == j || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed();
            return Boxing.boxLong(discard);
        }
        return byteChannelSequentialBase.discardSuspend(j, discard, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (r2.isClosedForRead() == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004d -> B:10:0x0050). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object discardSuspend(long j, long j2, Continuation<? super Long> continuation) {
        ByteChannelSequentialBase$discardSuspend$1 byteChannelSequentialBase$discardSuspend$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$discardSuspend$1) {
            byteChannelSequentialBase$discardSuspend$1 = (ByteChannelSequentialBase$discardSuspend$1) continuation;
            if ((byteChannelSequentialBase$discardSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$discardSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$discardSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$discardSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase = this;
                    byteChannelSequentialBase$discardSuspend$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$discardSuspend$1.J$0 = j;
                    byteChannelSequentialBase$discardSuspend$1.J$1 = j2;
                    byteChannelSequentialBase$discardSuspend$1.label = 1;
                    obj = byteChannelSequentialBase.await(1, byteChannelSequentialBase$discardSuspend$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    byteChannelSequentialBase.ensureNotFailed();
                    return Boxing.boxLong(j2);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j3 = byteChannelSequentialBase$discardSuspend$1.J$1;
                long j4 = byteChannelSequentialBase$discardSuspend$1.J$0;
                byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$discardSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                j2 = j3;
                j = j4;
                if (((Boolean) obj).booleanValue()) {
                    long discard = byteChannelSequentialBase.readable.discard(j - j2);
                    byteChannelSequentialBase.afterRead((int) discard);
                    j2 += discard;
                    if (j2 < j) {
                    }
                }
                byteChannelSequentialBase.ensureNotFailed();
                return Boxing.boxLong(j2);
            }
        }
        byteChannelSequentialBase$discardSuspend$1 = new ByteChannelSequentialBase$discardSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$discardSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$discardSuspend$1.label;
        if (i != 0) {
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public void readSession(Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        try {
            consumer.invoke(this);
        } finally {
            completeReading();
        }
    }

    @Override // io.ktor.utils.io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public void endReadSession() {
        completeReading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    @Deprecated(message = "Use read instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object readSuspendableSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$readSuspendableSession$1 byteChannelSequentialBase$readSuspendableSession$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase2;
        try {
            if (continuation instanceof ByteChannelSequentialBase$readSuspendableSession$1) {
                byteChannelSequentialBase$readSuspendableSession$1 = (ByteChannelSequentialBase$readSuspendableSession$1) continuation;
                if ((byteChannelSequentialBase$readSuspendableSession$1.label & Integer.MIN_VALUE) != 0) {
                    byteChannelSequentialBase$readSuspendableSession$1.label -= Integer.MIN_VALUE;
                    Object obj = byteChannelSequentialBase$readSuspendableSession$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteChannelSequentialBase$readSuspendableSession$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        byteChannelSequentialBase$readSuspendableSession$1.L$0 = byteChannelSequentialBase;
                        byteChannelSequentialBase$readSuspendableSession$1.label = 1;
                        Object invoke = function2.invoke(byteChannelSequentialBase, byteChannelSequentialBase$readSuspendableSession$1);
                        byteChannelSequentialBase2 = byteChannelSequentialBase;
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ByteChannelSequentialBase byteChannelSequentialBase3 = (ByteChannelSequentialBase) byteChannelSequentialBase$readSuspendableSession$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        byteChannelSequentialBase2 = byteChannelSequentialBase3;
                    }
                    byteChannelSequentialBase2.completeReading();
                    byteChannelSequentialBase = Unit.INSTANCE;
                    return byteChannelSequentialBase;
                }
            }
            if (i != 0) {
            }
            byteChannelSequentialBase2.completeReading();
            byteChannelSequentialBase = Unit.INSTANCE;
            return byteChannelSequentialBase;
        } catch (Throwable th) {
            byteChannelSequentialBase.completeReading();
            throw th;
        }
        byteChannelSequentialBase$readSuspendableSession$1 = new ByteChannelSequentialBase$readSuspendableSession$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$readSuspendableSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$readSuspendableSession$1.label;
    }

    static /* synthetic */ <A extends Appendable> Object readUTF8LineTo$suspendImpl(final ByteChannelSequentialBase byteChannelSequentialBase, A a2, int i, Continuation<? super Boolean> continuation) {
        if (byteChannelSequentialBase.isClosedForRead()) {
            Throwable closedCause = byteChannelSequentialBase.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        return UTF8Kt.decodeUTF8LineLoopSuspend(a2, i, new ByteChannelSequentialBase$readUTF8LineTo$2(byteChannelSequentialBase, null), new Function1<Integer, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                ByteChannelSequentialBase.this.afterRead(i2);
            }
        }, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object readUTF8Line$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super String> continuation) {
        ByteChannelSequentialBase$readUTF8Line$1 byteChannelSequentialBase$readUTF8Line$1;
        Object obj;
        int i2;
        StringBuilder sb;
        if (continuation instanceof ByteChannelSequentialBase$readUTF8Line$1) {
            byteChannelSequentialBase$readUTF8Line$1 = (ByteChannelSequentialBase$readUTF8Line$1) continuation;
            if ((byteChannelSequentialBase$readUTF8Line$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$readUTF8Line$1.label -= Integer.MIN_VALUE;
                obj = byteChannelSequentialBase$readUTF8Line$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialBase$readUTF8Line$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb2 = new StringBuilder();
                    byteChannelSequentialBase$readUTF8Line$1.L$0 = sb2;
                    byteChannelSequentialBase$readUTF8Line$1.label = 1;
                    Object readUTF8LineTo = byteChannelSequentialBase.readUTF8LineTo(sb2, i, byteChannelSequentialBase$readUTF8Line$1);
                    if (readUTF8LineTo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = readUTF8LineTo;
                    sb = sb2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sb = (StringBuilder) byteChannelSequentialBase$readUTF8Line$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    return null;
                }
                return sb.toString();
            }
        }
        byteChannelSequentialBase$readUTF8Line$1 = new ByteChannelSequentialBase$readUTF8Line$1(byteChannelSequentialBase, continuation);
        obj = byteChannelSequentialBase$readUTF8Line$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialBase$readUTF8Line$1.label;
        if (i2 != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (getClosedCause() != null || getClosed()) {
            return false;
        }
        if (cause == null) {
            cause = new CancellationException("Channel cancelled");
        }
        return close(cause);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable cause) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closed$FU, this, null, cause == null ? CloseElementKt.getCLOSED_SUCCESS() : new CloseElement(cause))) {
            return false;
        }
        if (cause != null) {
            this.readable.release();
            this.writable.release();
            this.flushBuffer.release();
        } else {
            flush();
            this.writable.release();
        }
        this.slot.cancel(cause);
        return true;
    }

    public final long transferTo$ktor_io(ByteChannelSequentialBase dst, long limit) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        long remaining = this.readable.getRemaining();
        if (remaining > limit) {
            return 0L;
        }
        dst.writable.writePacket(this.readable);
        int i = (int) remaining;
        dst.afterWrite(i);
        afterRead(i);
        return remaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAvailableSuspend(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ByteChannelSequentialBase$writeAvailableSuspend$1 byteChannelSequentialBase$writeAvailableSuspend$1;
        int i;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$writeAvailableSuspend$1) {
            byteChannelSequentialBase$writeAvailableSuspend$1 = (ByteChannelSequentialBase$writeAvailableSuspend$1) continuation;
            if ((byteChannelSequentialBase$writeAvailableSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeAvailableSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeAvailableSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$writeAvailableSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeAvailableSuspend$1.L$0 = this;
                    byteChannelSequentialBase$writeAvailableSuspend$1.L$1 = chunkBuffer;
                    byteChannelSequentialBase$writeAvailableSuspend$1.label = 1;
                    if (awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeAvailableSuspend$1) != coroutine_suspended) {
                        byteChannelSequentialBase = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                chunkBuffer = (ChunkBuffer) byteChannelSequentialBase$writeAvailableSuspend$1.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeAvailableSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                byteChannelSequentialBase$writeAvailableSuspend$1.L$0 = null;
                byteChannelSequentialBase$writeAvailableSuspend$1.L$1 = null;
                byteChannelSequentialBase$writeAvailableSuspend$1.label = 2;
                Object writeAvailable = byteChannelSequentialBase.writeAvailable(chunkBuffer, byteChannelSequentialBase$writeAvailableSuspend$1);
                return writeAvailable != coroutine_suspended ? coroutine_suspended : writeAvailable;
            }
        }
        byteChannelSequentialBase$writeAvailableSuspend$1 = new ByteChannelSequentialBase$writeAvailableSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$writeAvailableSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$writeAvailableSuspend$1.label;
        if (i != 0) {
        }
        byteChannelSequentialBase$writeAvailableSuspend$1.L$0 = null;
        byteChannelSequentialBase$writeAvailableSuspend$1.L$1 = null;
        byteChannelSequentialBase$writeAvailableSuspend$1.label = 2;
        Object writeAvailable2 = byteChannelSequentialBase.writeAvailable(chunkBuffer, byteChannelSequentialBase$writeAvailableSuspend$1);
        if (writeAvailable2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAvailableSuspend(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        ByteChannelSequentialBase$writeAvailableSuspend$2 byteChannelSequentialBase$writeAvailableSuspend$2;
        int i3;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$writeAvailableSuspend$2) {
            byteChannelSequentialBase$writeAvailableSuspend$2 = (ByteChannelSequentialBase$writeAvailableSuspend$2) continuation;
            if ((byteChannelSequentialBase$writeAvailableSuspend$2.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$writeAvailableSuspend$2.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$writeAvailableSuspend$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteChannelSequentialBase$writeAvailableSuspend$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase$writeAvailableSuspend$2.L$0 = this;
                    byteChannelSequentialBase$writeAvailableSuspend$2.L$1 = bArr;
                    byteChannelSequentialBase$writeAvailableSuspend$2.I$0 = i;
                    byteChannelSequentialBase$writeAvailableSuspend$2.I$1 = i2;
                    byteChannelSequentialBase$writeAvailableSuspend$2.label = 1;
                    if (awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$writeAvailableSuspend$2) != coroutine_suspended) {
                        byteChannelSequentialBase = this;
                    }
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                i2 = byteChannelSequentialBase$writeAvailableSuspend$2.I$1;
                i = byteChannelSequentialBase$writeAvailableSuspend$2.I$0;
                bArr = (byte[]) byteChannelSequentialBase$writeAvailableSuspend$2.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$writeAvailableSuspend$2.L$0;
                ResultKt.throwOnFailure(obj);
                byteChannelSequentialBase$writeAvailableSuspend$2.L$0 = null;
                byteChannelSequentialBase$writeAvailableSuspend$2.L$1 = null;
                byteChannelSequentialBase$writeAvailableSuspend$2.label = 2;
                Object writeAvailable = byteChannelSequentialBase.writeAvailable(bArr, i, i2, byteChannelSequentialBase$writeAvailableSuspend$2);
                return writeAvailable != coroutine_suspended ? coroutine_suspended : writeAvailable;
            }
        }
        byteChannelSequentialBase$writeAvailableSuspend$2 = new ByteChannelSequentialBase$writeAvailableSuspend$2(this, continuation);
        Object obj2 = byteChannelSequentialBase$writeAvailableSuspend$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteChannelSequentialBase$writeAvailableSuspend$2.label;
        if (i3 != 0) {
        }
        byteChannelSequentialBase$writeAvailableSuspend$2.L$0 = null;
        byteChannelSequentialBase$writeAvailableSuspend$2.L$1 = null;
        byteChannelSequentialBase$writeAvailableSuspend$2.label = 2;
        Object writeAvailable2 = byteChannelSequentialBase.writeAvailable(bArr, i, i2, byteChannelSequentialBase$writeAvailableSuspend$2);
        if (writeAvailable2 != coroutine_suspended2) {
        }
    }

    protected final void afterWrite(int count) {
        addBytesWritten(count);
        if (getClosed()) {
            this.writable.release();
            ensureNotClosed();
        }
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object awaitFreeSpace$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Unit> continuation) {
        ByteChannelSequentialBase$awaitFreeSpace$1 byteChannelSequentialBase$awaitFreeSpace$1;
        int i;
        if (continuation instanceof ByteChannelSequentialBase$awaitFreeSpace$1) {
            byteChannelSequentialBase$awaitFreeSpace$1 = (ByteChannelSequentialBase$awaitFreeSpace$1) continuation;
            if ((byteChannelSequentialBase$awaitFreeSpace$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitFreeSpace$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$awaitFreeSpace$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$awaitFreeSpace$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialBase.flush();
                    byteChannelSequentialBase$awaitFreeSpace$1.L$0 = byteChannelSequentialBase;
                    byteChannelSequentialBase$awaitFreeSpace$1.label = 1;
                    if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialBase$awaitFreeSpace$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitFreeSpace$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                byteChannelSequentialBase.ensureNotClosed();
                return Unit.INSTANCE;
            }
        }
        byteChannelSequentialBase$awaitFreeSpace$1 = new ByteChannelSequentialBase$awaitFreeSpace$1(byteChannelSequentialBase, continuation);
        Object obj2 = byteChannelSequentialBase$awaitFreeSpace$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$awaitFreeSpace$1.label;
        if (i != 0) {
        }
        byteChannelSequentialBase.ensureNotClosed();
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Unit> continuation) {
        Object await = byteChannelSequentialBase.await(1, continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: peekTo-lBXzO7A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo9955peekTolBXzO7A(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation) {
        ByteChannelSequentialBase$peekTo$1 byteChannelSequentialBase$peekTo$1;
        int i;
        Ref.LongRef longRef;
        if (continuation instanceof ByteChannelSequentialBase$peekTo$1) {
            byteChannelSequentialBase$peekTo$1 = (ByteChannelSequentialBase$peekTo$1) continuation;
            if ((byteChannelSequentialBase$peekTo$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$peekTo$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialBase$peekTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialBase$peekTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> byteChannelSequentialBase$peekTo$2 = new ByteChannelSequentialBase$peekTo$2(j3, j2, longRef2, j4, byteBuffer, j, null);
                    byteChannelSequentialBase$peekTo$1.L$0 = longRef2;
                    byteChannelSequentialBase$peekTo$1.label = 1;
                    if (readSuspendableSession(byteChannelSequentialBase$peekTo$2, byteChannelSequentialBase$peekTo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    longRef = longRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    longRef = (Ref.LongRef) byteChannelSequentialBase$peekTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxLong(longRef.element);
            }
        }
        byteChannelSequentialBase$peekTo$1 = new ByteChannelSequentialBase$peekTo$1(this, continuation);
        Object obj2 = byteChannelSequentialBase$peekTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialBase$peekTo$1.label;
        if (i != 0) {
        }
        return Boxing.boxLong(longRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readFully(Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (i > buffer.getLimit() - buffer.getWritePosition()) {
            throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + i + " bytes").toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException("n shouldn't be negative".toString());
        }
        if (getClosedCause() != null) {
            Throwable closedCause = getClosedCause();
            Intrinsics.checkNotNull(closedCause);
            throw closedCause;
        }
        if (this.readable.getRemaining() < i) {
            if (getClosed()) {
                throw new EOFException("Channel is closed and not enough bytes available: required " + i + " but " + get_availableForRead() + " available");
            }
            Object readFullySuspend = readFullySuspend(buffer, i, continuation);
            return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
        }
        InputArraysKt.readFully(this.readable, buffer, i);
        Unit unit = Unit.INSTANCE;
        afterRead(i);
        return Unit.INSTANCE;
    }

    private final void addBytesRead(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't read negative amount of bytes: " + count).toString());
        }
        int i = -count;
        channelSize$FU.getAndAdd(this, i);
        _totalBytesRead$FU.addAndGet(this, count);
        _availableForRead$FU.getAndAdd(this, i);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
        if (get_availableForRead() < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
    }

    private final void addBytesWritten(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't write negative amount of bytes: " + count).toString());
        }
        channelSize$FU.getAndAdd(this, count);
        _totalBytesWritten$FU.addAndGet(this, count);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + count + " in " + this).toString());
        }
    }
}
