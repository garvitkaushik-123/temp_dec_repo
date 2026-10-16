package io.ktor.utils.io;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.charsets.UTFKt;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferPrimitivesJvmKt;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.FailedLookAhead;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadSessionImpl;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.ReadWriteBufferStateKt;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.TerminatedLookAhead;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;

/* compiled from: ByteBufferChannel.kt */
@Metadata(d1 = {"\u0000Ò\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0010\u0018\u0000 ó\u00022\u00030õ\u00022\u00030ö\u00022\u00030÷\u00022\u00020k2\u00030ø\u00022\u00030ù\u0002:\u0002ó\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B)\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ/\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0082@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b%\u0010&J'\u0010*\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b/\u0010.JP\u00105\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000526\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000501H\u0082\b¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b7\u00108J-\u0010@\u001a\u00020:2\u0006\u00109\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010<H\u0080@ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u000f\u0010D\u001a\u00020AH\u0000¢\u0006\u0004\bB\u0010CJ,\u0010G\u001a\u00020\u00142\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082Hø\u0001\u0000¢\u0006\u0004\bG\u0010HJ4\u0010I\u001a\u00020\u00142\u0006\u0010=\u001a\u00020<2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082Hø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010L\u001a\u00020:2\u0006\u0010K\u001a\u00020:H\u0096@ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ#\u0010O\u001a\u00020:2\u0006\u0010N\u001a\u00020:2\u0006\u0010K\u001a\u00020:H\u0082@ø\u0001\u0000¢\u0006\u0004\bO\u0010PJA\u0010S\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010R\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082\b¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0014H\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u00108J\u0017\u0010Y\u001a\u00020\u00142\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0014H\u0016¢\u0006\u0004\b[\u0010VJ\u0017\u0010]\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020\nH\u0002¢\u0006\u0004\b]\u00108J\u0011\u0010`\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0004\b^\u0010_J#\u0010d\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00002\u0006\u0010a\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\bb\u0010cJ+\u0010e\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00002\u0006\u0010a\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<H\u0082@ø\u0001\u0000¢\u0006\u0004\be\u0010fJ.\u0010i\u001a\u00028\u0000\"\u0004\b\u0000\u0010g2\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bEH\u0017¢\u0006\u0004\bi\u0010jJB\u0010n\u001a\u00028\u0000\"\u0004\b\u0000\u0010g2'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020k\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000l\u0012\u0006\u0012\u0004\u0018\u00010m01¢\u0006\u0002\bEH\u0097@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\bH\u0002¢\u0006\u0004\bp\u0010qJA\u0010x\u001a\u00020:2\u0006\u0010s\u001a\u00020r2\u0006\u0010t\u001a\u00020:2\u0006\u0010u\u001a\u00020:2\u0006\u0010\u001f\u001a\u00020:2\u0006\u0010K\u001a\u00020:H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u001f\u0010|\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010y\u001a\u00020\nH\u0000¢\u0006\u0004\bz\u0010{J/\u0010~\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0096@ø\u0001\u0000¢\u0006\u0004\b~\u0010#J/\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\b\b\u0002\u00107\u001a\u00020\n2\b\b\u0002\u0010K\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0083\u0001J-\u0010\u0081\u0001\u001a\u00020\n2\b\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0086\u0001J \u0010\u0088\u0001\u001a\u00020\n2\b\u0010\u0080\u0001\u001a\u00030\u0087\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001f\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u008a\u0001J1\u0010\u0088\u0001\u001a\u00020\n2\b\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u008b\u0001J.\u0010\u0088\u0001\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u008c\u0001J \u0010\u008d\u0001\u001a\u00020\n2\b\u0010\u0080\u0001\u001a\u00030\u0087\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u0089\u0001J\u001f\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008a\u0001J1\u0010\u008d\u0001\u001a\u00020\n2\b\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008b\u0001J1\u0010\u008e\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u008e\u0001\u0010#J\u0015\u0010\u008f\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008f\u0001\u0010\u001cJ\u0016\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010\u001cJ\u0016\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0093\u0001\u0010\u001cJ\u0016\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0095\u0001\u0010\u001cJ(\u0010\u0096\u0001\u001a\u00020\u00142\b\u0010\u0080\u0001\u001a\u00030\u0087\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001f\u0010\u0096\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u008a\u0001J1\u0010\u0096\u0001\u001a\u00020\u00142\b\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u008b\u0001J(\u0010\u0098\u0001\u001a\u00020\u00142\b\u0010\u0080\u0001\u001a\u00030\u0087\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u0097\u0001J(\u0010\u0098\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u00012\u0007\u0010\u0099\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u009a\u0001J1\u0010\u0098\u0001\u001a\u00020\u00142\b\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u008b\u0001J\u0015\u0010\u009b\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u001cJ\u0015\u0010\u009c\u0001\u001a\u00020:H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009c\u0001\u0010\u001cJ\u001e\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0006\u0010Q\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010\u0019J1\u0010¡\u0001\u001a\u00030\u009d\u00012\u0006\u0010Q\u001a\u00020\n2\b\u0010 \u0001\u001a\u00030\u009f\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001JC\u0010¦\u0001\u001a\u00028\u0000\"\n\b\u0000\u0010¤\u0001*\u00030£\u00012\u0006\u0010Q\u001a\u00020\n2\u0018\u0010¥\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bEH\u0082Hø\u0001\u0000¢\u0006\u0005\b¦\u0001\u0010#J\u001e\u0010§\u0001\u001a\u00030\u009d\u00012\u0006\u0010;\u001a\u00020:H\u0096@ø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010MJ\u001e\u0010¨\u0001\u001a\u00030\u009d\u00012\u0006\u0010;\u001a\u00020:H\u0082@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010MJ,\u0010ª\u0001\u001a\u00020\u00142\u0018\u0010}\u001a\u0014\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0017¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0016\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010\u001cJ\u001d\u0010®\u0001\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b®\u0001\u0010\u0019J\u001d\u0010¯\u0001\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b¯\u0001\u0010\u0019J\u001d\u0010°\u0001\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010\u0019J\u001b\u0010±\u0001\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\nH\u0082\b¢\u0006\u0006\b±\u0001\u0010²\u0001J?\u0010´\u0001\u001a\u00020\u00142(\u0010}\u001a$\b\u0001\u0012\u0005\u0012\u00030³\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140l\u0012\u0006\u0012\u0004\u0018\u00010m01¢\u0006\u0002\bEH\u0097@ø\u0001\u0000¢\u0006\u0005\b´\u0001\u0010oJ \u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00012\u0006\u0010;\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0005\b¶\u0001\u0010\u0019J8\u0010»\u0001\u001a\u00020\u0005\"\u000f\b\u0000\u0010¹\u0001*\b0·\u0001j\u0003`¸\u00012\u0007\u0010º\u0001\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J-\u0010½\u0001\u001a\u00020\u00052\r\u0010º\u0001\u001a\b0·\u0001j\u0003`¸\u00012\u0006\u0010;\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¼\u0001J-\u0010¾\u0001\u001a\u00020\u00052\r\u0010º\u0001\u001a\b0·\u0001j\u0003`¸\u00012\u0006\u0010;\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b¾\u0001\u0010¼\u0001J2\u0010¿\u0001\u001a\u00020\u00052\u001d\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000501¢\u0006\u0002\bEH\u0082\b¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u001a\u0010Á\u0001\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u001b\u0010Ã\u0001\u001a\u00030\u009d\u00012\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J&\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010Å\u0001\u001a\u00020\n2\u0007\u0010Æ\u0001\u001a\u00020\nH\u0016¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u0012\u0010Ë\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J&\u0010Î\u0001\u001a\u0004\u0018\u00010\u00002\u0007\u0010Ì\u0001\u001a\u00020\u00002\u0007\u0010Í\u0001\u001a\u00020<H\u0002¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0011\u0010Ð\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bÐ\u0001\u0010VJ\u0011\u0010Ò\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0005\bÑ\u0001\u0010VJ\u001c\u0010Ó\u0001\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0011\u0010Õ\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bÕ\u0001\u0010VJ#\u0010Õ\u0001\u001a\u00020\u00142\u000e\u0010×\u0001\u001a\t\u0012\u0004\u0012\u00020+0Ö\u0001H\u0082\b¢\u0006\u0006\bÕ\u0001\u0010Ø\u0001J\u0011\u0010Ù\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bÙ\u0001\u0010VJ#\u0010Û\u0001\u001a\u00020<2\u0007\u0010Ú\u0001\u001a\u00020\u00002\u0006\u0010a\u001a\u00020\u0005H\u0002¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u0014\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J\u0014\u0010à\u0001\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0006\bß\u0001\u0010Þ\u0001J\u0012\u0010á\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001J\u0013\u0010ã\u0001\u001a\u00030³\u0001H\u0016¢\u0006\u0006\bã\u0001\u0010ä\u0001J(\u0010æ\u0001\u001a\u00020m2\u0006\u0010Q\u001a\u00020\n2\r\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050lH\u0002¢\u0006\u0005\bæ\u0001\u0010\u0019J\u0013\u0010ç\u0001\u001a\u00030µ\u0001H\u0016¢\u0006\u0006\bç\u0001\u0010è\u0001J\u001a\u0010é\u0001\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001J\u001b\u0010ì\u0001\u001a\u00020\u00052\u0007\u0010ë\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\bì\u0001\u0010í\u0001J\u0012\u0010ï\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0006\bî\u0001\u0010â\u0001J\u001c\u0010ñ\u0001\u001a\u00020\n2\b\u0010ð\u0001\u001a\u00030\u009d\u0001H\u0002¢\u0006\u0006\bñ\u0001\u0010ò\u0001J\u001d\u0010ô\u0001\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0005\bó\u0001\u0010\u0019J1\u0010õ\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0096@ø\u0001\u0000¢\u0006\u0005\bõ\u0001\u0010#J\u001a\u0010ö\u0001\u001a\u00020\n2\u0006\u00109\u001a\u00020\u007fH\u0002¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u001a\u0010ö\u0001\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0001H\u0002¢\u0006\u0006\bö\u0001\u0010\u0083\u0001J,\u0010ö\u0001\u001a\u00020\n2\u0007\u00109\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\bö\u0001\u0010\u0086\u0001J\u001f\u0010ø\u0001\u001a\u00020\n2\u0007\u00109\u001a\u00030\u0087\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010\u0089\u0001J\u001e\u0010ø\u0001\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010\u008a\u0001J0\u0010ø\u0001\u001a\u00020\n2\u0007\u00109\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010\u008b\u0001J.\u0010ø\u0001\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\bø\u0001\u0010\u008c\u0001J\u001f\u0010ù\u0001\u001a\u00020\n2\u0007\u00109\u001a\u00030\u0087\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\bù\u0001\u0010\u0089\u0001J\u001e\u0010ù\u0001\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\bù\u0001\u0010\u008a\u0001J \u0010û\u0001\u001a\u00020\u00142\b\u0010ú\u0001\u001a\u00030\u0090\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\bû\u0001\u0010ü\u0001J \u0010þ\u0001\u001a\u00020\u00142\b\u0010ý\u0001\u001a\u00030\u0092\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001J \u0010\u0081\u0002\u001a\u00020\u00142\b\u0010\u0080\u0002\u001a\u00030\u0094\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J7\u0010\u0088\u0002\u001a\u00020\u00142\u0007\u0010\u0083\u0002\u001a\u00020r2\u0007\u0010\u0084\u0002\u001a\u00020\n2\u0007\u0010\u0085\u0002\u001a\u00020\nH\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002J\u001e\u0010\u0088\u0002\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u007fH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J\u001e\u0010\u0088\u0002\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0002\u0010\u008a\u0001J0\u0010\u0088\u0002\u001a\u00020\u00142\u0007\u00109\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0002\u0010\u008b\u0001J\u001e\u0010\u008a\u0002\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u007fH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0002\u0010\u0089\u0002J\u001e\u0010\u008a\u0002\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0002\u0010\u008a\u0001J0\u0010\u008a\u0002\u001a\u00020\u00142\u0007\u00109\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0002\u0010\u008b\u0001J\u001e\u0010\u008c\u0002\u001a\u00020\u00142\u0007\u0010\u008b\u0002\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u008c\u0002\u0010\u0019J\u001e\u0010\u008e\u0002\u001a\u00020\u00142\u0007\u0010\u008d\u0002\u001a\u00020:H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u008e\u0002\u0010MJ \u0010\u008f\u0002\u001a\u00020\u00142\b\u0010ð\u0001\u001a\u00030\u009d\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u008f\u0002\u0010\u0090\u0002J \u0010\u0091\u0002\u001a\u00020\u00142\b\u0010ð\u0001\u001a\u00030\u009d\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0091\u0002\u0010\u0090\u0002JQ\u0010\u0093\u0002\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\n2\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bE2\u0018\u0010\u0092\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082Hø\u0001\u0000¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J \u0010\u0096\u0002\u001a\u00020\u00142\b\u0010\u0095\u0002\u001a\u00030¬\u0001H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0096\u0002\u0010\u0097\u0002J0\u0010\u0098\u0002\u001a\u00020\n2\u0007\u00109\u001a\u00030\u0084\u00012\u0006\u0010u\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0098\u0002\u0010\u008b\u0001J\u001d\u0010\u0098\u0002\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0098\u0002\u0010\u0019J*\u0010\u009b\u0002\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\n2\u000e\u0010\u009a\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140\u0099\u0002H\u0002¢\u0006\u0006\b\u009b\u0002\u0010\u009c\u0002J\u001a\u0010\u009d\u0002\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\nH\u0002¢\u0006\u0006\b\u009d\u0002\u0010²\u0001J>\u0010\u009e\u0002\u001a\u00020\u00142'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140l\u0012\u0006\u0012\u0004\u0018\u00010m01¢\u0006\u0002\bEH\u0097@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0002\u0010oJ)\u0010\u009f\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0002\u0010HJ7\u0010 \u0002\u001a\u00020\u00052\u0007\u0010\u0080\u0001\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b \u0002\u0010¡\u0002J&\u0010¢\u0002\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b¢\u0002\u0010£\u0002J)\u0010¤\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0082@ø\u0001\u0000¢\u0006\u0005\b¤\u0002\u0010HJ9\u0010¦\u0002\u001a\u00020\u00142$\u0010!\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140¥\u0002¢\u0006\u0002\bEH\u0082\b¢\u0006\u0006\b¦\u0002\u0010§\u0002J%\u0010¨\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b¨\u0002\u0010)J%\u0010©\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b©\u0002\u0010)J\u0015\u0010ª\u0002\u001a\u00020\u0014*\u00020\u0001H\u0002¢\u0006\u0005\bª\u0002\u0010\u0004J\u001f\u0010¬\u0002\u001a\u00020\n*\u00020\u00012\u0007\u0010«\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002J(\u0010°\u0002\u001a\u00020\u0014*\u00020\u00012\u0007\u0010®\u0002\u001a\u00020\n2\u0007\u0010¯\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b°\u0002\u0010±\u0002J\u001d\u0010²\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0005\b²\u0002\u0010{J@\u0010³\u0002\u001a\u00020\u0005*\u00020\u00012\u0006\u0010Q\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010R\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082\b¢\u0006\u0006\b³\u0002\u0010´\u0002J]\u0010µ\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010Q\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bE2\u0018\u0010\u0092\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bEH\u0082Hø\u0001\u0000¢\u0006\u0006\bµ\u0002\u0010¶\u0002R\u001b\u0010·\u0002\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010¹\u0002\u001a\u0006\bº\u0002\u0010â\u0001R\u0017\u0010½\u0002\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\b»\u0002\u0010¼\u0002R\u0017\u0010¿\u0002\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¾\u0002\u0010¼\u0002R0\u0010Æ\u0002\u001a\u0005\u0018\u00010À\u00022\n\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00028B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002R\u0019\u0010É\u0002\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R\u0017\u0010Ê\u0002\u001a\u00020\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bÊ\u0002\u0010â\u0001R\u0017\u0010Ë\u0002\u001a\u00020\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010â\u0001R\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Ì\u0002R\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010Í\u0002R:\u0010Ò\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010l2\u000f\u0010Á\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010l8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R\u0019\u0010Ó\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0002\u0010Ô\u0002R\u001f\u0010ª\u0001\u001a\u00030Õ\u00028\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\bª\u0001\u0010Ö\u0002\u0012\u0005\b×\u0002\u0010VR\u001e\u0010Ù\u0002\u001a\t\u0012\u0004\u0012\u00020\u00050Ø\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0002\u0010Ú\u0002R\u001d\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u000b\u0010Ô\u0002\u001a\u0006\bÛ\u0002\u0010¼\u0002R\u0016\u0010Ý\u0002\u001a\u00020A8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0002\u0010CR2\u0010ß\u0002\u001a\u00020:2\u0007\u0010Þ\u0002\u001a\u00020:8\u0016@PX\u0096\u000e¢\u0006\u0018\n\u0006\bß\u0002\u0010à\u0002\u001a\u0006\bá\u0002\u0010â\u0002\"\u0006\bã\u0002\u0010ä\u0002R2\u0010å\u0002\u001a\u00020:2\u0007\u0010Þ\u0002\u001a\u00020:8\u0016@PX\u0096\u000e¢\u0006\u0018\n\u0006\bå\u0002\u0010à\u0002\u001a\u0006\bæ\u0002\u0010â\u0002\"\u0006\bç\u0002\u0010ä\u0002R:\u0010ê\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010l2\u000f\u0010Á\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010l8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\bè\u0002\u0010Ï\u0002\"\u0006\bé\u0002\u0010Ñ\u0002R\u0019\u0010ë\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0002\u0010Ô\u0002R\u0018\u0010í\u0002\u001a\u00030ì\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bí\u0002\u0010î\u0002R\u001e\u0010ï\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140Ø\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0002\u0010Ú\u0002R)\u0010ð\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140l\u0012\u0004\u0012\u00020m0 8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0002\u0010ñ\u0002R\u0019\u0010ò\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0002\u0010Ô\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006ô\u0002"}, d2 = {"Lio/ktor/utils/io/ByteBufferChannel;", "Ljava/nio/ByteBuffer;", "content", "<init>", "(Ljava/nio/ByteBuffer;)V", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "pool", "", "reservedSize", "(ZLio/ktor/utils/io/pool/ObjectPool;I)V", "buffer", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "capacity", "afterBufferVisited", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;)I", "Lkotlinx/coroutines/Job;", "job", "", "attachJob", "(Lkotlinx/coroutines/Job;)V", D5.q, "awaitAtLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastSuspend", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitContent", "awaitFreeSpace", "min", "Lkotlin/Function1;", "block", "awaitFreeSpaceOrDelegate", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "count", "bytesWrittenFromSession$ktor_io", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;I)V", "bytesWrittenFromSession", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "close", "last", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "visitor", "consumeEachBufferRangeFast", "(ZLkotlin/jvm/functions/Function2;)Z", "consumed", "(I)V", "src", "", "limit", "Lio/ktor/utils/io/internal/JoiningState;", "joined", "copyDirect$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;JLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyDirect", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState$ktor_io", "()Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState", "Lkotlin/ExtensionFunctionType;", "channelWriter", "delegatePrimitive", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delegateSuspend", "(Lio/ktor/utils/io/internal/JoiningState;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "max", "discard", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", ContentDisposition.Parameters.Size, "writer", "doWritePrimitive", "(ILjava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)V", "endReadSession", "()V", "written", "endWriteSession", "ensureClosedJoined", "(Lio/ktor/utils/io/internal/JoiningState;)V", "flush", "minWriteSize", "flushImpl", "getJoining$ktor_io", "()Lio/ktor/utils/io/internal/JoiningState;", "getJoining", "delegateClose", "joinFrom$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinFrom", "joinFromSuspend", "(Lio/ktor/utils/io/ByteBufferChannel;ZLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lio/ktor/utils/io/LookAheadSession;", "lookAhead", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "lookAheadSuspend", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuffer", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Lio/ktor/utils/io/bits/Memory;", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "offset", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "lockedSpace", "prepareWriteBuffer$ktor_io", "(Ljava/nio/ByteBuffer;I)V", "prepareWriteBuffer", "consumer", "read", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;II)I", "(Ljava/nio/ByteBuffer;)I", "", "length", "([BII)I", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(ILkotlin/jvm/functions/Function1;)I", "readAvailableSuspend", "readBlockSuspend", "readBoolean", "", "readByte", "", "readDouble", "", "readFloat", "readFully", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "readLong", "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "Lio/ktor/utils/io/core/BytePacketBuilder;", "builder", "readPacketSuspend", "(ILio/ktor/utils/io/core/BytePacketBuilder;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "T", "getter", "readPrimitive", "readRemaining", "readRemainingSuspend", "Lio/ktor/utils/io/ReadSession;", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readSuspend", "readSuspendImpl", "readSuspendLoop", "readSuspendPredicate", "(I)Z", "Lio/ktor/utils/io/SuspendableReadSession;", "readSuspendableSession", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUTF8LineToAscii", "readUTF8LineToUtf8Suspend", "reading", "(Lkotlin/jvm/functions/Function2;)Z", "releaseBuffer", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "remainingPacket", "(J)Lio/ktor/utils/io/core/ByteReadPacket;", "skip", "atLeast", AdActivity.REQUEST_KEY_EXTRA, "(II)Ljava/nio/ByteBuffer;", "resolveChannelInstance$ktor_io", "()Lio/ktor/utils/io/ByteBufferChannel;", "resolveChannelInstance", "current", "joining", "resolveDelegation", "(Lio/ktor/utils/io/ByteBufferChannel;Lio/ktor/utils/io/internal/JoiningState;)Lio/ktor/utils/io/ByteBufferChannel;", "restoreStateAfterRead", "restoreStateAfterWrite$ktor_io", "restoreStateAfterWrite", "resumeClosed", "(Ljava/lang/Throwable;)V", "resumeReadOp", "Lkotlin/Function0;", "exception", "(Lkotlin/jvm/functions/Function0;)V", "resumeWriteOp", "delegate", "setupDelegateTo", "(Lio/ktor/utils/io/ByteBufferChannel;Z)Lio/ktor/utils/io/internal/JoiningState;", "setupStateForRead", "()Ljava/nio/ByteBuffer;", "setupStateForWrite$ktor_io", "setupStateForWrite", "shouldResumeReadOp", "()Z", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "continuation", "suspensionForSize", "toString", "()Ljava/lang/String;", "tryCompleteJoining", "(Lio/ktor/utils/io/internal/JoiningState;)Z", "forceTermination", "tryReleaseBuffer", "(Z)Z", "tryTerminate$ktor_io", "tryTerminate", "packet", "tryWritePacketPart", "(Lio/ktor/utils/io/core/ByteReadPacket;)I", "tryWriteSuspend$ktor_io", "tryWriteSuspend", "write", "writeAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;)I", "writeAvailable", "writeAvailableSuspend", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", InneractiveMediationDefs.GENDER_FEMALE, "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFullySuspend", "i", "writeInt", "l", "writeLong", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "bufferWriter", "writePrimitive", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspend", "Lkotlinx/coroutines/CancellableContinuation;", "c", "writeSuspendBlock", "(ILkotlinx/coroutines/CancellableContinuation;)V", "writeSuspendPredicate", "writeSuspendSession", "writeWhile", "writeWhileLoop", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeWhileNoSuspend", "(Lkotlin/jvm/functions/Function1;)Z", "writeWhileSuspend", "Lkotlin/Function3;", "writing", "(Lkotlin/jvm/functions/Function3;)V", "bytesRead", "bytesWritten", "carry", "idx", "carryIndex", "(Ljava/nio/ByteBuffer;I)I", C3040d4.h.L, "available", "prepareBuffer", "(Ljava/nio/ByteBuffer;II)V", "rollBytes", "tryWritePrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeSuspendPrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachedJob", "Lkotlinx/coroutines/Job;", "Z", "getAutoFlush", "getAvailableForRead", "()I", "availableForRead", "getAvailableForWrite", "availableForWrite", "Lio/ktor/utils/io/internal/ClosedElement;", "value", "getClosed", "()Lio/ktor/utils/io/internal/ClosedElement;", "setClosed", "(Lio/ktor/utils/io/internal/ClosedElement;)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "isClosedForWrite", "Lio/ktor/utils/io/internal/JoiningState;", "Lio/ktor/utils/io/pool/ObjectPool;", "getReadOp", "()Lkotlin/coroutines/Continuation;", "setReadOp", "(Lkotlin/coroutines/Continuation;)V", "readOp", "readPosition", "I", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "getReadSession$annotations", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "readSuspendContinuationCache", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "getReservedSize$ktor_io", "getState", "state", "<set-?>", "totalBytesRead", "J", "getTotalBytesRead", "()J", "setTotalBytesRead$ktor_io", "(J)V", "totalBytesWritten", "getTotalBytesWritten", "setTotalBytesWritten$ktor_io", "getWriteOp", "setWriteOp", "writeOp", "writePosition", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSession", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSuspendContinuationCache", "writeSuspension", "Lkotlin/jvm/functions/Function1;", "writeSuspensionSize", "Companion", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {
    private static final int ReservedLongIndex = -8;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    private volatile Job attachedJob;
    private final boolean autoFlush;
    private volatile JoiningState joining;
    private final ObjectPool<ReadWriteBufferState.Initial> pool;
    private int readPosition;
    private final ReadSessionImpl readSession;
    private final CancellableReusableContinuation<Boolean> readSuspendContinuationCache;
    private final int reservedSize;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private int writePosition;
    private final WriteSessionImpl writeSession;
    private final CancellableReusableContinuation<Unit> writeSuspendContinuationCache;
    private final Function1<Continuation<? super Unit>, Object> writeSuspension;
    private volatile int writeSuspensionSize;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _readOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");
    static final /* synthetic */ AtomicReferenceFieldUpdater _writeOp$FU = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");

    private static /* synthetic */ void getReadSession$annotations() {
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
    @Deprecated(message = "Use read { } instead.")
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return lookAheadSuspend$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: peekTo-lBXzO7A, reason: not valid java name */
    public Object mo9955peekTolBXzO7A(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation) {
        return m9953peekTolBXzO7A$suspendImpl(this, byteBuffer, j, j2, j3, j4, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return read$suspendImpl(this, i, function1, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, byteBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
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
    @Deprecated(message = "Use read { } instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineToAscii(a2, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return write$suspendImpl(this, i, function1, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, byteBuffer, continuation);
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
    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, byteBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: writeFully-JT6ljtQ, reason: not valid java name */
    public Object mo9956writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m9954writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
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

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        return writeWhile$suspendImpl(this, function1, continuation);
    }

    public ByteBufferChannel(boolean z, ObjectPool<ReadWriteBufferState.Initial> pool, int i) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this.pool = pool;
        this.reservedSize = i;
        this._state = ReadWriteBufferState.IdleEmpty.INSTANCE;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.readSession = new ReadSessionImpl(this);
        this.writeSession = new WriteSessionImpl(this);
        this.readSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspension = new Function1<Continuation<? super Unit>, Object>() { // from class: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1
            {
                super(1);
            }

            /* JADX WARN: Incorrect condition in loop: B:14:0x0043 */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invoke(Continuation<? super Unit> ucont) {
                int i2;
                ClosedElement closed;
                boolean writeSuspendPredicate;
                boolean shouldResumeReadOp;
                Continuation writeOp;
                boolean writeSuspendPredicate2;
                boolean writeSuspendPredicate3;
                Throwable sendException;
                Intrinsics.checkNotNullParameter(ucont, "ucont");
                i2 = ByteBufferChannel.this.writeSuspensionSize;
                while (true) {
                    closed = ByteBufferChannel.this.getClosed();
                    if (closed != null && (sendException = closed.getSendException()) != null) {
                        ByteBufferChannelKt.rethrowClosed(sendException);
                        throw new KotlinNothingValueException();
                    }
                    writeSuspendPredicate = ByteBufferChannel.this.writeSuspendPredicate(i2);
                    if (!writeSuspendPredicate) {
                        Result.Companion companion = Result.INSTANCE;
                        ucont.resumeWith(Result.m10241constructorimpl(Unit.INSTANCE));
                        break;
                    }
                    ByteBufferChannel byteBufferChannel = ByteBufferChannel.this;
                    Continuation intercepted = IntrinsicsKt.intercepted(ucont);
                    ByteBufferChannel byteBufferChannel2 = ByteBufferChannel.this;
                    while (writeOp == null) {
                        writeSuspendPredicate2 = byteBufferChannel2.writeSuspendPredicate(i2);
                        if (writeSuspendPredicate2) {
                            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ByteBufferChannel._writeOp$FU, byteBufferChannel, null, intercepted)) {
                                writeSuspendPredicate3 = byteBufferChannel2.writeSuspendPredicate(i2);
                                if (writeSuspendPredicate3 || !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ByteBufferChannel._writeOp$FU, byteBufferChannel, intercepted, null)) {
                                    break;
                                }
                            }
                        }
                    }
                    throw new IllegalStateException("Operation is already in progress".toString());
                }
                ByteBufferChannel.this.flushImpl(i2);
                shouldResumeReadOp = ByteBufferChannel.this.shouldResumeReadOp();
                if (shouldResumeReadOp) {
                    ByteBufferChannel.this.resumeReadOp();
                }
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        };
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteBufferChannel(boolean z, ObjectPool objectPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? ObjectPoolKt.getBufferObjectPool() : objectPool, (i2 & 4) != 0 ? 8 : i);
    }

    /* renamed from: getReservedSize$ktor_io, reason: from getter */
    public final int getReservedSize() {
        return this.reservedSize;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer content) {
        this(false, ObjectPoolKt.getBufferObjectNoPool(), 0);
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer slice = content.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(slice, 0);
        initial.capacity.resetForRead();
        this._state = initial.startWriting$ktor_io();
        restoreStateAfterWrite$ktor_io();
        ByteWriteChannelKt.close(this);
        tryTerminate$ktor_io();
    }

    private final ReadWriteBufferState getState() {
        return (ReadWriteBufferState) this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClosedElement getClosed() {
        return (ClosedElement) this._closed;
    }

    private final void setClosed(ClosedElement closedElement) {
        this._closed = closedElement;
    }

    private final Continuation<Boolean> getReadOp() {
        return (Continuation) this._readOp;
    }

    private final void setReadOp(Continuation<? super Boolean> continuation) {
        this._readOp = continuation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Continuation<Unit> getWriteOp() {
        return (Continuation) this._writeOp;
    }

    private final void setWriteOp(Continuation<? super Unit> continuation) {
        this._writeOp = continuation;
    }

    public final ReadWriteBufferState currentState$ktor_io() {
        return getState();
    }

    /* renamed from: getJoining$ktor_io, reason: from getter */
    public final JoiningState getJoining() {
        return this.joining;
    }

    @Override // io.ktor.utils.io.ByteChannel
    @Deprecated(message = DeprecationKt.IO_DEPRECATION_MESSAGE)
    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$attachJob$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ByteBufferChannel.this.attachedJob = null;
                if (th == null) {
                    return;
                }
                ByteBufferChannel.this.cancel(ExceptionUtilsKt.unwrapCancellationException(th));
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getAvailableForRead */
    public int get_availableForRead() {
        return getState().capacity._availableForRead$internal;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int getAvailableForWrite() {
        return getState().capacity._availableForWrite$internal;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return getState() == ReadWriteBufferState.Terminated.INSTANCE && getClosed() != null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed() != null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getTotalBytesRead, reason: from getter */
    public long get_totalBytesRead() {
        return this.totalBytesRead;
    }

    public void setTotalBytesRead$ktor_io(long j) {
        this.totalBytesRead = j;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: getTotalBytesWritten, reason: from getter */
    public long get_totalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void setTotalBytesWritten$ktor_io(long j) {
        this.totalBytesWritten = j;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        ClosedElement closed = getClosed();
        if (closed != null) {
            return closed.getCause();
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable cause) {
        ClosedElement closedElement;
        JoiningState joiningState;
        if (getClosed() != null) {
            return false;
        }
        if (cause == null) {
            closedElement = ClosedElement.INSTANCE.getEmptyCause();
        } else {
            closedElement = new ClosedElement(cause);
        }
        getState().capacity.flush();
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closed$FU, this, null, closedElement)) {
            return false;
        }
        getState().capacity.flush();
        if (getState().capacity.isEmpty() || cause != null) {
            tryTerminate$ktor_io();
        }
        resumeClosed(cause);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE && (joiningState = this.joining) != null) {
            ensureClosedJoined(joiningState);
        }
        if (cause != null) {
            Job job = this.attachedJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.readSuspendContinuationCache.close(cause);
            this.writeSuspendContinuationCache.close(cause);
            return true;
        }
        this.writeSuspendContinuationCache.close(new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE));
        this.readSuspendContinuationCache.close((CancellableReusableContinuation<Boolean>) Boolean.valueOf(getState().capacity.flush()));
        return true;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel has been cancelled");
        }
        return close(cause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushImpl(int minWriteSize) {
        ReadWriteBufferState state;
        ByteBufferChannel delegatedTo;
        JoiningState joiningState = this.joining;
        if (joiningState != null && (delegatedTo = joiningState.getDelegatedTo()) != null) {
            delegatedTo.flush();
        }
        do {
            state = getState();
            if (state == ReadWriteBufferState.Terminated.INSTANCE) {
                return;
            } else {
                state.capacity.flush();
            }
        } while (state != getState());
        int i = state.capacity._availableForWrite$internal;
        if (state.capacity._availableForRead$internal >= 1) {
            resumeReadOp();
        }
        JoiningState joiningState2 = this.joining;
        if (i >= minWriteSize) {
            if (joiningState2 == null || getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                resumeWriteOp();
            }
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        flushImpl(1);
    }

    public final void prepareWriteBuffer$ktor_io(ByteBuffer buffer, int lockedSpace) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        prepareBuffer(buffer, this.writePosition, lockedSpace);
    }

    private final void prepareBuffer(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        byteBuffer.limit(RangesKt.coerceAtMost(i2 + i, byteBuffer.capacity() - this.reservedSize));
        byteBuffer.position(i);
    }

    public final ByteBuffer setupStateForWrite$ktor_io() {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.Writing startWriting$ktor_io;
        Continuation<Unit> writeOp = getWriteOp();
        if (writeOp != null) {
            throw new IllegalStateException("Write operation is already in progress: " + writeOp);
        }
        ReadWriteBufferState readWriteBufferState2 = null;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            readWriteBufferState = (ReadWriteBufferState) obj;
            if (this.joining != null) {
                if (initial != null) {
                    releaseBuffer(initial);
                }
                return null;
            }
            if (getClosed() != null) {
                if (initial != null) {
                    releaseBuffer(initial);
                }
                ClosedElement closed = getClosed();
                Intrinsics.checkNotNull(closed);
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                if (initial == null) {
                    initial = newBuffer();
                }
                startWriting$ktor_io = initial.startWriting$ktor_io();
            } else {
                if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    if (this.joining != null) {
                        return null;
                    }
                    ClosedElement closed2 = getClosed();
                    Intrinsics.checkNotNull(closed2);
                    ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                    throw new KotlinNothingValueException();
                }
                startWriting$ktor_io = readWriteBufferState.startWriting$ktor_io();
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, obj, startWriting$ktor_io));
        if (getClosed() != null) {
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
            ClosedElement closed3 = getClosed();
            Intrinsics.checkNotNull(closed3);
            ByteBufferChannelKt.rethrowClosed(closed3.getSendException());
            throw new KotlinNothingValueException();
        }
        ByteBuffer writeBuffer = startWriting$ktor_io.getWriteBuffer();
        if (initial != null) {
            if (readWriteBufferState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("old");
            } else {
                readWriteBufferState2 = readWriteBufferState;
            }
            if (readWriteBufferState2 != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                releaseBuffer(initial);
            }
        }
        prepareBuffer(writeBuffer, this.writePosition, startWriting$ktor_io.capacity._availableForWrite$internal);
        return writeBuffer;
    }

    private final JoiningState setupDelegateTo(ByteBufferChannel delegate, boolean delegateClose) {
        if (this == delegate) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JoiningState joiningState = new JoiningState(delegate, delegateClose);
        this.joining = joiningState;
        ClosedElement closed = getClosed();
        if (closed == null) {
            flush();
            return joiningState;
        }
        if (closed.getCause() != null) {
            delegate.close(closed.getCause());
            return joiningState;
        }
        if (delegateClose && getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            ByteWriteChannelKt.close(delegate);
            return joiningState;
        }
        delegate.flush();
        return joiningState;
    }

    private final boolean tryCompleteJoining(JoiningState joined) {
        if (!tryReleaseBuffer(true)) {
            return false;
        }
        ensureClosedJoined(joined);
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(new IllegalStateException("Joining is in progress"))));
        }
        resumeWriteOp();
        return true;
    }

    public final boolean tryTerminate$ktor_io() {
        if (getClosed() == null || !tryReleaseBuffer(false)) {
            return false;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ensureClosedJoined(joiningState);
        }
        resumeReadOp();
        resumeWriteOp();
        return true;
    }

    private final int carryIndex(ByteBuffer byteBuffer, int i) {
        return i >= byteBuffer.capacity() - this.reservedSize ? i - (byteBuffer.capacity() - this.reservedSize) : i;
    }

    private final void writing(Function3<? super ByteBufferChannel, ? super ByteBuffer, ? super RingBufferCapacity, Unit> block) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            block.invoke(byteBufferChannel, byteBuffer, ringBufferCapacity);
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final boolean reading(Function2<? super ByteBuffer, ? super RingBufferCapacity, Boolean> block) {
        ByteBuffer byteBuffer = setupStateForRead();
        if (byteBuffer == null) {
            return false;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        try {
            if (ringBufferCapacity._availableForRead$internal == 0) {
                return false;
            }
            return block.invoke(byteBuffer, ringBufferCapacity).booleanValue();
        } finally {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        int readAsMuchAsPossible = readAsMuchAsPossible(bArr, i, i2);
        if (readAsMuchAsPossible < i2) {
            Object readFullySuspend = readFullySuspend(bArr, i + readAsMuchAsPossible, i2 - readAsMuchAsPossible, continuation);
            return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int readAsMuchAsPossible = readAsMuchAsPossible(byteBuffer);
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(readAsMuchAsPossible) : readFullySuspend(byteBuffer, readAsMuchAsPossible, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:10:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(ByteBuffer byteBuffer, int i, Continuation<? super Integer> continuation) {
        ByteBufferChannel$readFullySuspend$1 byteBufferChannel$readFullySuspend$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readFullySuspend$1) {
            byteBufferChannel$readFullySuspend$1 = (ByteBufferChannel$readFullySuspend$1) continuation;
            if ((byteBufferChannel$readFullySuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readFullySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readFullySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readFullySuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (!byteBuffer.hasRemaining()) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = byteBufferChannel$readFullySuspend$1.I$0;
                    ByteBuffer byteBuffer2 = (ByteBuffer) byteBufferChannel$readFullySuspend$1.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readFullySuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        ByteBuffer byteBuffer3 = byteBuffer2;
                        i = i3 + byteBufferChannel.readAsMuchAsPossible(byteBuffer2);
                        byteBuffer = byteBuffer3;
                        if (!byteBuffer.hasRemaining()) {
                            byteBufferChannel$readFullySuspend$1.L$0 = byteBufferChannel;
                            byteBufferChannel$readFullySuspend$1.L$1 = byteBuffer;
                            byteBufferChannel$readFullySuspend$1.I$0 = i;
                            byteBufferChannel$readFullySuspend$1.label = 1;
                            obj = byteBufferChannel.readSuspend(1, byteBufferChannel$readFullySuspend$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i4 = i;
                            byteBuffer2 = byteBuffer;
                            i3 = i4;
                            if (!((Boolean) obj).booleanValue()) {
                                throw new ClosedReceiveChannelException("Unexpected EOF: expected " + byteBuffer2.remaining() + " more bytes");
                            }
                        } else {
                            return Boxing.boxInt(i);
                        }
                    }
                }
            }
        }
        byteBufferChannel$readFullySuspend$1 = new ByteBufferChannel$readFullySuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$readFullySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readFullySuspend$1.label;
        if (i2 != 0) {
        }
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        int readAsMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer, 0, i, 2, null);
        if (readAsMuchAsPossible$default == i) {
            return Unit.INSTANCE;
        }
        Object readFullySuspend = byteBufferChannel.readFullySuspend(chunkBuffer, i - readAsMuchAsPossible$default, continuation);
        return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:10:0x0067). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        ByteBufferChannel$readFullySuspend$2 byteBufferChannel$readFullySuspend$2;
        int i2;
        int i3;
        ByteBufferChannel byteBufferChannel;
        ChunkBuffer chunkBuffer2;
        if (continuation instanceof ByteBufferChannel$readFullySuspend$2) {
            byteBufferChannel$readFullySuspend$2 = (ByteBufferChannel$readFullySuspend$2) continuation;
            if ((byteBufferChannel$readFullySuspend$2.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readFullySuspend$2.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readFullySuspend$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readFullySuspend$2.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i3 = 0;
                    byteBufferChannel = this;
                    chunkBuffer2 = chunkBuffer;
                    if (chunkBuffer2.getLimit() <= chunkBuffer2.getWritePosition()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = byteBufferChannel$readFullySuspend$2.I$1;
                i = byteBufferChannel$readFullySuspend$2.I$0;
                ChunkBuffer chunkBuffer3 = (ChunkBuffer) byteBufferChannel$readFullySuspend$2.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readFullySuspend$2.L$0;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    i3 = readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer3, 0, i - i4, 2, null) + i4;
                    chunkBuffer = chunkBuffer3;
                    chunkBuffer2 = chunkBuffer;
                    if (chunkBuffer2.getLimit() <= chunkBuffer2.getWritePosition() && i3 < i) {
                        byteBufferChannel$readFullySuspend$2.L$0 = byteBufferChannel;
                        byteBufferChannel$readFullySuspend$2.L$1 = chunkBuffer;
                        byteBufferChannel$readFullySuspend$2.I$0 = i;
                        byteBufferChannel$readFullySuspend$2.I$1 = i3;
                        byteBufferChannel$readFullySuspend$2.label = 1;
                        Object readSuspend = byteBufferChannel.readSuspend(1, byteBufferChannel$readFullySuspend$2);
                        if (readSuspend == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        chunkBuffer3 = chunkBuffer;
                        i4 = i3;
                        obj = readSuspend;
                        if (!((Boolean) obj).booleanValue()) {
                            throw new ClosedReceiveChannelException("Unexpected EOF: expected " + (i - i4) + " more bytes");
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        byteBufferChannel$readFullySuspend$2 = new ByteBufferChannel$readFullySuspend$2(this, continuation);
        Object obj2 = byteBufferChannel$readFullySuspend$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readFullySuspend$2.label;
        if (i2 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0058 -> B:10:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteBufferChannel$readFullySuspend$3 byteBufferChannel$readFullySuspend$3;
        int i3;
        int i4;
        ByteBufferChannel byteBufferChannel;
        Object readSuspend;
        if (continuation instanceof ByteBufferChannel$readFullySuspend$3) {
            byteBufferChannel$readFullySuspend$3 = (ByteBufferChannel$readFullySuspend$3) continuation;
            if ((byteBufferChannel$readFullySuspend$3.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readFullySuspend$3.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readFullySuspend$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteBufferChannel$readFullySuspend$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i4 = 0;
                    byteBufferChannel = this;
                    byteBufferChannel$readFullySuspend$3.L$0 = byteBufferChannel;
                    byteBufferChannel$readFullySuspend$3.L$1 = bArr;
                    byteBufferChannel$readFullySuspend$3.I$0 = i;
                    byteBufferChannel$readFullySuspend$3.I$1 = i2;
                    byteBufferChannel$readFullySuspend$3.I$2 = i4;
                    byteBufferChannel$readFullySuspend$3.label = 1;
                    readSuspend = byteBufferChannel.readSuspend(1, byteBufferChannel$readFullySuspend$3);
                    if (readSuspend != coroutine_suspended) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i5 = byteBufferChannel$readFullySuspend$3.I$2;
                    int i6 = byteBufferChannel$readFullySuspend$3.I$1;
                    int i7 = byteBufferChannel$readFullySuspend$3.I$0;
                    byte[] bArr2 = (byte[]) byteBufferChannel$readFullySuspend$3.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readFullySuspend$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("Unexpected EOF: expected " + i6 + " more bytes");
                    }
                    int i8 = i7 + i5;
                    int i9 = i6 - i5;
                    i4 = byteBufferChannel.readAsMuchAsPossible(bArr2, i8, i9);
                    if (i4 < i9) {
                        i = i8;
                        i2 = i9;
                        bArr = bArr2;
                        byteBufferChannel$readFullySuspend$3.L$0 = byteBufferChannel;
                        byteBufferChannel$readFullySuspend$3.L$1 = bArr;
                        byteBufferChannel$readFullySuspend$3.I$0 = i;
                        byteBufferChannel$readFullySuspend$3.I$1 = i2;
                        byteBufferChannel$readFullySuspend$3.I$2 = i4;
                        byteBufferChannel$readFullySuspend$3.label = 1;
                        readSuspend = byteBufferChannel.readSuspend(1, byteBufferChannel$readFullySuspend$3);
                        if (readSuspend != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bArr2 = bArr;
                        i5 = i4;
                        obj = readSuspend;
                        int i10 = i2;
                        i7 = i;
                        i6 = i10;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        byteBufferChannel$readFullySuspend$3 = new ByteBufferChannel$readFullySuspend$3(this, continuation);
        Object obj2 = byteBufferChannel$readFullySuspend$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteBufferChannel$readFullySuspend$3.label;
        if (i3 != 0) {
        }
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(bArr, i, i2);
        if (readAsMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(bArr, i, i2) : -1;
        } else if (readAsMuchAsPossible <= 0 && i2 != 0) {
            return byteBufferChannel.readAvailableSuspend(bArr, i, i2, continuation);
        }
        return Boxing.boxInt(readAsMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(byteBuffer);
        if (readAsMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(byteBuffer) : -1;
        } else if (readAsMuchAsPossible <= 0 && byteBuffer.hasRemaining()) {
            return byteBufferChannel.readAvailableSuspend(byteBuffer, continuation);
        }
        return Boxing.boxInt(readAsMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        int readAsMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer2, 0, 0, 6, null);
        if (readAsMuchAsPossible$default == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible$default = byteBufferChannel.getState().capacity.flush() ? readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer2, 0, 0, 6, null) : -1;
        } else if (readAsMuchAsPossible$default <= 0 && chunkBuffer2.getLimit() > chunkBuffer2.getWritePosition()) {
            return byteBufferChannel.readAvailableSuspend(chunkBuffer, continuation);
        }
        return Boxing.boxInt(readAsMuchAsPossible$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAvailableSuspend(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        ByteBufferChannel$readAvailableSuspend$1 byteBufferChannel$readAvailableSuspend$1;
        Object obj;
        int i3;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readAvailableSuspend$1) {
            byteBufferChannel$readAvailableSuspend$1 = (ByteBufferChannel$readAvailableSuspend$1) continuation;
            if ((byteBufferChannel$readAvailableSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readAvailableSuspend$1.label -= Integer.MIN_VALUE;
                obj = byteBufferChannel$readAvailableSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteBufferChannel$readAvailableSuspend$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$readAvailableSuspend$1.L$0 = this;
                    byteBufferChannel$readAvailableSuspend$1.L$1 = bArr;
                    byteBufferChannel$readAvailableSuspend$1.I$0 = i;
                    byteBufferChannel$readAvailableSuspend$1.I$1 = i2;
                    byteBufferChannel$readAvailableSuspend$1.label = 1;
                    obj = readSuspend(1, byteBufferChannel$readAvailableSuspend$1);
                    if (obj != coroutine_suspended) {
                        byteBufferChannel = this;
                    }
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                i2 = byteBufferChannel$readAvailableSuspend$1.I$1;
                i = byteBufferChannel$readAvailableSuspend$1.I$0;
                bArr = (byte[]) byteBufferChannel$readAvailableSuspend$1.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readAvailableSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return Boxing.boxInt(-1);
                }
                byteBufferChannel$readAvailableSuspend$1.L$0 = null;
                byteBufferChannel$readAvailableSuspend$1.L$1 = null;
                byteBufferChannel$readAvailableSuspend$1.label = 2;
                Object readAvailable = byteBufferChannel.readAvailable(bArr, i, i2, byteBufferChannel$readAvailableSuspend$1);
                return readAvailable == coroutine_suspended ? coroutine_suspended : readAvailable;
            }
        }
        byteBufferChannel$readAvailableSuspend$1 = new ByteBufferChannel$readAvailableSuspend$1(this, continuation);
        obj = byteBufferChannel$readAvailableSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteBufferChannel$readAvailableSuspend$1.label;
        if (i3 != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAvailableSuspend(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel$readAvailableSuspend$2 byteBufferChannel$readAvailableSuspend$2;
        Object obj;
        int i;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readAvailableSuspend$2) {
            byteBufferChannel$readAvailableSuspend$2 = (ByteBufferChannel$readAvailableSuspend$2) continuation;
            if ((byteBufferChannel$readAvailableSuspend$2.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readAvailableSuspend$2.label -= Integer.MIN_VALUE;
                obj = byteBufferChannel$readAvailableSuspend$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readAvailableSuspend$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$readAvailableSuspend$2.L$0 = this;
                    byteBufferChannel$readAvailableSuspend$2.L$1 = byteBuffer;
                    byteBufferChannel$readAvailableSuspend$2.label = 1;
                    obj = readSuspend(1, byteBufferChannel$readAvailableSuspend$2);
                    if (obj != coroutine_suspended) {
                        byteBufferChannel = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                byteBuffer = (ByteBuffer) byteBufferChannel$readAvailableSuspend$2.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readAvailableSuspend$2.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return Boxing.boxInt(-1);
                }
                byteBufferChannel$readAvailableSuspend$2.L$0 = null;
                byteBufferChannel$readAvailableSuspend$2.L$1 = null;
                byteBufferChannel$readAvailableSuspend$2.label = 2;
                Object readAvailable = byteBufferChannel.readAvailable(byteBuffer, byteBufferChannel$readAvailableSuspend$2);
                return readAvailable == coroutine_suspended ? coroutine_suspended : readAvailable;
            }
        }
        byteBufferChannel$readAvailableSuspend$2 = new ByteBufferChannel$readAvailableSuspend$2(this, continuation);
        obj = byteBufferChannel$readAvailableSuspend$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readAvailableSuspend$2.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAvailableSuspend(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel$readAvailableSuspend$3 byteBufferChannel$readAvailableSuspend$3;
        Object obj;
        int i;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readAvailableSuspend$3) {
            byteBufferChannel$readAvailableSuspend$3 = (ByteBufferChannel$readAvailableSuspend$3) continuation;
            if ((byteBufferChannel$readAvailableSuspend$3.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readAvailableSuspend$3.label -= Integer.MIN_VALUE;
                obj = byteBufferChannel$readAvailableSuspend$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readAvailableSuspend$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$readAvailableSuspend$3.L$0 = this;
                    byteBufferChannel$readAvailableSuspend$3.L$1 = chunkBuffer;
                    byteBufferChannel$readAvailableSuspend$3.label = 1;
                    obj = readSuspend(1, byteBufferChannel$readAvailableSuspend$3);
                    if (obj != coroutine_suspended) {
                        byteBufferChannel = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                chunkBuffer = (ChunkBuffer) byteBufferChannel$readAvailableSuspend$3.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readAvailableSuspend$3.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return Boxing.boxInt(-1);
                }
                byteBufferChannel$readAvailableSuspend$3.L$0 = null;
                byteBufferChannel$readAvailableSuspend$3.L$1 = null;
                byteBufferChannel$readAvailableSuspend$3.label = 2;
                Object readAvailable = byteBufferChannel.readAvailable(chunkBuffer, byteBufferChannel$readAvailableSuspend$3);
                return readAvailable == coroutine_suspended ? coroutine_suspended : readAvailable;
            }
        }
        byteBufferChannel$readAvailableSuspend$3 = new ByteBufferChannel$readAvailableSuspend$3(this, continuation);
        obj = byteBufferChannel$readAvailableSuspend$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readAvailableSuspend$3.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object readPacket$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Continuation<? super ByteReadPacket> continuation) {
        Throwable cause;
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed != null && (cause = closed.getCause()) != null) {
            ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        }
        if (i == 0) {
            return ByteReadPacket.INSTANCE.getEmpty();
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        ByteBuffer borrow = ObjectPoolKt.getBufferPool().borrow();
        while (i > 0) {
            try {
                borrow.clear();
                if (borrow.remaining() > i) {
                    borrow.limit(i);
                }
                int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(borrow);
                if (readAsMuchAsPossible == 0) {
                    break;
                }
                borrow.flip();
                OutputArraysJVMKt.writeFully(bytePacketBuilder, borrow);
                i -= readAsMuchAsPossible;
            } catch (Throwable th) {
                ObjectPoolKt.getBufferPool().recycle(borrow);
                bytePacketBuilder.release();
                throw th;
            }
        }
        if (i == 0) {
            ObjectPoolKt.getBufferPool().recycle(borrow);
            return bytePacketBuilder.build();
        }
        return byteBufferChannel.readPacketSuspend(i, bytePacketBuilder, borrow, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #0 {all -> 0x0085, blocks: (B:14:0x0068, B:16:0x004b, B:18:0x0054, B:19:0x0057, B:23:0x0079), top: B:13:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:14:0x0068, B:16:0x004b, B:18:0x0054, B:19:0x0057, B:23:0x0079), top: B:13:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:13:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readPacketSuspend(int i, BytePacketBuilder bytePacketBuilder, ByteBuffer byteBuffer, Continuation<? super ByteReadPacket> continuation) {
        ByteBufferChannel$readPacketSuspend$1 byteBufferChannel$readPacketSuspend$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        Throwable th;
        if (continuation instanceof ByteBufferChannel$readPacketSuspend$1) {
            byteBufferChannel$readPacketSuspend$1 = (ByteBufferChannel$readPacketSuspend$1) continuation;
            if ((byteBufferChannel$readPacketSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readPacketSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readPacketSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readPacketSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (i > 0) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteBufferChannel$readPacketSuspend$1.I$0;
                    ByteBuffer byteBuffer2 = (ByteBuffer) byteBufferChannel$readPacketSuspend$1.L$2;
                    BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) byteBufferChannel$readPacketSuspend$1.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readPacketSuspend$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        byteBuffer = byteBuffer2;
                        bytePacketBuilder = bytePacketBuilder2;
                        try {
                            int intValue = ((Number) obj).intValue();
                            byteBuffer.flip();
                            OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
                            i -= intValue;
                            if (i > 0) {
                                byteBuffer2.clear();
                                if (byteBuffer2.remaining() > i) {
                                    byteBuffer2.limit(i);
                                }
                                byteBufferChannel$readPacketSuspend$1.L$0 = byteBufferChannel;
                                byteBufferChannel$readPacketSuspend$1.L$1 = bytePacketBuilder;
                                byteBufferChannel$readPacketSuspend$1.L$2 = byteBuffer2;
                                byteBufferChannel$readPacketSuspend$1.I$0 = i;
                                byteBufferChannel$readPacketSuspend$1.label = 1;
                                obj = byteBufferChannel.readFully(byteBuffer2, byteBufferChannel$readPacketSuspend$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                int intValue2 = ((Number) obj).intValue();
                                byteBuffer.flip();
                                OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
                                i -= intValue2;
                                if (i > 0) {
                                    return bytePacketBuilder.build();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            ByteBuffer byteBuffer3 = byteBuffer;
                            bytePacketBuilder2 = bytePacketBuilder;
                            byteBuffer2 = byteBuffer3;
                            try {
                                bytePacketBuilder2.release();
                                throw th;
                            } finally {
                                ObjectPoolKt.getBufferPool().recycle(byteBuffer2);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bytePacketBuilder2.release();
                        throw th;
                    }
                }
            }
        }
        byteBufferChannel$readPacketSuspend$1 = new ByteBufferChannel$readPacketSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$readPacketSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readPacketSuspend$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readBoolean(Continuation<? super Boolean> continuation) {
        ByteBufferChannel$readBoolean$1 byteBufferChannel$readBoolean$1;
        int i;
        if (continuation instanceof ByteBufferChannel$readBoolean$1) {
            byteBufferChannel$readBoolean$1 = (ByteBufferChannel$readBoolean$1) continuation;
            if ((byteBufferChannel$readBoolean$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readBoolean$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readBoolean$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readBoolean$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$readBoolean$1.label = 1;
                    obj = readByte(byteBufferChannel$readBoolean$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(((Number) obj).byteValue() != 0);
            }
        }
        byteBufferChannel$readBoolean$1 = new ByteBufferChannel$readBoolean$1(this, continuation);
        Object obj2 = byteBufferChannel$readBoolean$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readBoolean$1.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(((Number) obj2).byteValue() != 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Byte] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0097 -> B:10:0x009a). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readByte(Continuation<? super Byte> continuation) {
        ByteBufferChannel$readByte$1 byteBufferChannel$readByte$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        if (continuation instanceof ByteBufferChannel$readByte$1) {
            byteBufferChannel$readByte$1 = (ByteBufferChannel$readByte$1) continuation;
            if ((byteBufferChannel$readByte$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readByte$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readByte$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readByte$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 1;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readByte$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readByte$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxByte(byteBuffer.get());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element != 0) {
                            return (Number) objectRef2.element;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("result");
                        return null;
                    }
                    byteBufferChannel$readByte$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readByte$1.I$0 = i2;
                    byteBufferChannel$readByte$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readByte$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readByte$1 = new ByteBufferChannel$readByte$1(this, continuation);
        Object obj2 = byteBufferChannel$readByte$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readByte$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Short] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0098 -> B:10:0x009b). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readShort(Continuation<? super Short> continuation) {
        ByteBufferChannel$readShort$1 byteBufferChannel$readShort$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        if (continuation instanceof ByteBufferChannel$readShort$1) {
            byteBufferChannel$readShort$1 = (ByteBufferChannel$readShort$1) continuation;
            if ((byteBufferChannel$readShort$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readShort$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readShort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readShort$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 2;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readShort$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readShort$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxShort(byteBuffer.getShort());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element != 0) {
                            return (Number) objectRef2.element;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("result");
                        return null;
                    }
                    byteBufferChannel$readShort$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readShort$1.I$0 = i2;
                    byteBufferChannel$readShort$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readShort$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readShort$1 = new ByteBufferChannel$readShort$1(this, continuation);
        Object obj2 = byteBufferChannel$readShort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readShort$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0098 -> B:10:0x009b). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readInt(Continuation<? super Integer> continuation) {
        ByteBufferChannel$readInt$1 byteBufferChannel$readInt$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        if (continuation instanceof ByteBufferChannel$readInt$1) {
            byteBufferChannel$readInt$1 = (ByteBufferChannel$readInt$1) continuation;
            if ((byteBufferChannel$readInt$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readInt$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readInt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readInt$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 4;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readInt$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readInt$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxInt(byteBuffer.getInt());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element != 0) {
                            return (Number) objectRef2.element;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("result");
                        return null;
                    }
                    byteBufferChannel$readInt$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readInt$1.I$0 = i2;
                    byteBufferChannel$readInt$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readInt$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readInt$1 = new ByteBufferChannel$readInt$1(this, continuation);
        Object obj2 = byteBufferChannel$readInt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readInt$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0099 -> B:10:0x009c). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLong(Continuation<? super Long> continuation) {
        ByteBufferChannel$readLong$1 byteBufferChannel$readLong$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        if (continuation instanceof ByteBufferChannel$readLong$1) {
            byteBufferChannel$readLong$1 = (ByteBufferChannel$readLong$1) continuation;
            if ((byteBufferChannel$readLong$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readLong$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readLong$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readLong$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 8;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readLong$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readLong$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxLong(byteBuffer.getLong());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element != 0) {
                            return (Number) objectRef2.element;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("result");
                        return null;
                    }
                    byteBufferChannel$readLong$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readLong$1.I$0 = i2;
                    byteBufferChannel$readLong$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readLong$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readLong$1 = new ByteBufferChannel$readLong$1(this, continuation);
        Object obj2 = byteBufferChannel$readLong$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readLong$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00a4 -> B:10:0x00a7). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFloat(Continuation<? super Float> continuation) {
        ByteBufferChannel$readFloat$1 byteBufferChannel$readFloat$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        Number number;
        if (continuation instanceof ByteBufferChannel$readFloat$1) {
            byteBufferChannel$readFloat$1 = (ByteBufferChannel$readFloat$1) continuation;
            if ((byteBufferChannel$readFloat$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readFloat$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readFloat$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readFloat$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 4;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readFloat$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readFloat$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxInt(byteBuffer.getInt());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("result");
                            number = null;
                        } else {
                            number = (Number) objectRef2.element;
                        }
                        return Boxing.boxFloat(Float.intBitsToFloat(number.intValue()));
                    }
                    byteBufferChannel$readFloat$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readFloat$1.I$0 = i2;
                    byteBufferChannel$readFloat$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readFloat$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readFloat$1 = new ByteBufferChannel$readFloat$1(this, continuation);
        Object obj2 = byteBufferChannel$readFloat$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readFloat$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00a5 -> B:10:0x00a8). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDouble(Continuation<? super Double> continuation) {
        ByteBufferChannel$readDouble$1 byteBufferChannel$readDouble$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        int i2;
        ByteBuffer byteBuffer;
        boolean z;
        Number number;
        if (continuation instanceof ByteBufferChannel$readDouble$1) {
            byteBufferChannel$readDouble$1 = (ByteBufferChannel$readDouble$1) continuation;
            if ((byteBufferChannel$readDouble$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readDouble$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readDouble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$readDouble$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    i2 = 8;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = byteBufferChannel$readDouble$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readDouble$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        throw new ClosedReceiveChannelException("EOF while " + i2 + " bytes expected");
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                        try {
                            if (ringBufferCapacity._availableForRead$internal != 0 && ringBufferCapacity.tryReadExact(i2)) {
                                if (byteBuffer.remaining() < i2) {
                                    byteBufferChannel.rollBytes(byteBuffer, i2);
                                }
                                objectRef2.element = Boxing.boxLong(byteBuffer.getLong());
                                byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, i2);
                                z = true;
                            }
                        } finally {
                            byteBufferChannel.restoreStateAfterRead();
                            byteBufferChannel.tryTerminate$ktor_io();
                        }
                    }
                    if (z) {
                        if (objectRef2.element == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("result");
                            number = null;
                        } else {
                            number = (Number) objectRef2.element;
                        }
                        return Boxing.boxDouble(Double.longBitsToDouble(number.longValue()));
                    }
                    byteBufferChannel$readDouble$1.L$0 = byteBufferChannel;
                    byteBufferChannel$readDouble$1.I$0 = i2;
                    byteBufferChannel$readDouble$1.label = 1;
                    obj = byteBufferChannel.readSuspend(i2, byteBufferChannel$readDouble$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                    byteBuffer = byteBufferChannel.setupStateForRead();
                    z = false;
                    if (byteBuffer != null) {
                    }
                    if (z) {
                    }
                }
            }
        }
        byteBufferChannel$readDouble$1 = new ByteBufferChannel$readDouble$1(this, continuation);
        Object obj2 = byteBufferChannel$readDouble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readDouble$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends Number> Object readPrimitive(int i, Function1<? super ByteBuffer, ? extends T> function1, Continuation<? super T> continuation) {
        do {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ByteBuffer byteBuffer = setupStateForRead();
            boolean z = false;
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        RingBufferCapacity ringBufferCapacity2 = ringBufferCapacity;
                        ByteBuffer byteBuffer2 = byteBuffer;
                        if (ringBufferCapacity.tryReadExact(i)) {
                            if (byteBuffer.remaining() < i) {
                                rollBytes(byteBuffer, i);
                            }
                            objectRef.element = function1.invoke(byteBuffer);
                            bytesRead(byteBuffer, ringBufferCapacity, i);
                            z = true;
                        }
                        Boolean valueOf = Boolean.valueOf(z);
                        Boolean bool = valueOf;
                        z = valueOf.booleanValue();
                    }
                } finally {
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                }
            }
            if (z) {
                if (objectRef.element != 0) {
                    return (Number) objectRef.element;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                return null;
            }
        } while (((Boolean) readSuspend(i, continuation)).booleanValue());
        throw new ClosedReceiveChannelException("EOF while " + i + " bytes expected");
    }

    private final void rollBytes(ByteBuffer byteBuffer, int i) {
        int remaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i);
        int i2 = i - remaining;
        for (int i3 = 0; i3 < i2; i3++) {
            byteBuffer.put((byteBuffer.capacity() - 8) + i3, byteBuffer.get(i3));
        }
    }

    private final void carry(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - this.reservedSize;
        int position = byteBuffer.position();
        for (int i = capacity; i < position; i++) {
            byteBuffer.put(i - capacity, byteBuffer.get(i));
        }
    }

    public final void bytesWrittenFromSession$ktor_io(ByteBuffer buffer, RingBufferCapacity capacity, int count) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(capacity, "capacity");
        bytesWritten(buffer, capacity, count);
    }

    private final void bytesWritten(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.writePosition = carryIndex(byteBuffer, this.writePosition + i);
        ringBufferCapacity.completeWrite(i);
        setTotalBytesWritten$ktor_io(get_totalBytesWritten() + i);
    }

    private final void bytesRead(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.readPosition = carryIndex(byteBuffer, this.readPosition + i);
        ringBufferCapacity.completeRead(i);
        setTotalBytesRead$ktor_io(get_totalBytesRead() + i);
        resumeWriteOp();
    }

    public final ByteBufferChannel resolveChannelInstance$ktor_io() {
        ByteBufferChannel resolveDelegation;
        JoiningState joiningState = this.joining;
        return (joiningState == null || (resolveDelegation = resolveDelegation(this, joiningState)) == null) ? this : resolveDelegation;
    }

    private final ByteBufferChannel resolveDelegation(ByteBufferChannel current, JoiningState joining) {
        while (current.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            current = joining.getDelegatedTo();
            joining = current.joining;
            if (joining == null) {
                return current;
            }
        }
        return null;
    }

    private final Object delegateSuspend(JoiningState joiningState, Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) {
        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            writeSuspend(1, continuation);
        }
        function1.invoke(joiningState.getDelegatedTo());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0141, code lost:
    
        if (r2.getDelegatedTo().writeByte(r8, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0121, code lost:
    
        if (r9.getDelegatedTo().writeByte(r10, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f8, code lost:
    
        if (r8.writeSuspend(r9, r0) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
    
        if (r2.getDelegatedTo().writeByte(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0082, code lost:
    
        if (r10.writeByte(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a5, code lost:
    
        if (r10.getDelegatedTo().writeByte(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f8 -> B:25:0x00fb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeByte$suspendImpl(ByteBufferChannel byteBufferChannel, byte b, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeByte$1 byteBufferChannel$writeByte$1;
        RingBufferCapacity ringBufferCapacity;
        ByteBuffer byteBuffer;
        byte b2;
        int i;
        JoiningState joiningState;
        Throwable th;
        ByteBufferChannel byteBufferChannel2;
        JoiningState joiningState2;
        ByteBufferChannel byteBufferChannel3;
        byte b3;
        if (continuation instanceof ByteBufferChannel$writeByte$1) {
            byteBufferChannel$writeByte$1 = (ByteBufferChannel$writeByte$1) continuation;
            if ((byteBufferChannel$writeByte$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeByte$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeByte$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteBufferChannel$writeByte$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        JoiningState joiningState3 = byteBufferChannel.joining;
                        if (joiningState3 != null && (r10 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState3)) != null) {
                            byteBufferChannel$writeByte$1.label = 1;
                            break;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferChannel.setupStateForWrite$ktor_io();
                            if (byteBuffer2 == null) {
                                JoiningState joiningState4 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState4);
                                if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                    joiningState = joiningState4;
                                    while (true) {
                                        if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            byteBufferChannel$writeByte$1.L$0 = null;
                                            byteBufferChannel$writeByte$1.L$1 = null;
                                            byteBufferChannel$writeByte$1.label = 3;
                                            break;
                                        } else {
                                            byteBufferChannel$writeByte$1.L$0 = joiningState;
                                            byteBufferChannel$writeByte$1.L$1 = byteBufferChannel;
                                            byteBufferChannel$writeByte$1.B$0 = b;
                                            byteBufferChannel$writeByte$1.label = 4;
                                            if (byteBufferChannel.writeSuspend(1, byteBufferChannel$writeByte$1) == coroutine_suspended) {
                                            }
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                byteBufferChannel$writeByte$1.label = 2;
                                break;
                            } else {
                                RingBufferCapacity ringBufferCapacity2 = byteBufferChannel.getState().capacity;
                                if (ringBufferCapacity2.tryWriteExact(1)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer2, 1);
                                    if (byteBuffer2.remaining() < 1) {
                                        byteBuffer2.limit(byteBuffer2.capacity());
                                        byteBuffer2.put(b);
                                        byteBufferChannel.carry(byteBuffer2);
                                    } else {
                                        byteBuffer2.put(b);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer2, ringBufferCapacity2, 1);
                                    if (ringBufferCapacity2.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                } else {
                                    ringBufferCapacity = ringBufferCapacity2;
                                    byteBuffer = byteBuffer2;
                                    b2 = b;
                                    i = 1;
                                    try {
                                        byteBufferChannel$writeByte$1.L$0 = ringBufferCapacity;
                                        byteBufferChannel$writeByte$1.L$1 = byteBufferChannel;
                                        byteBufferChannel$writeByte$1.L$2 = byteBuffer;
                                        byteBufferChannel$writeByte$1.B$0 = b2;
                                        byteBufferChannel$writeByte$1.I$0 = i;
                                        byteBufferChannel$writeByte$1.label = 5;
                                        break;
                                    } catch (Throwable th2) {
                                        byteBufferChannel2 = byteBufferChannel;
                                        th = th2;
                                        byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                                        byteBufferChannel2.tryTerminate$ktor_io();
                                        throw th;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        byte b4 = byteBufferChannel$writeByte$1.B$0;
                        ByteBufferChannel byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$writeByte$1.L$1;
                        joiningState = (JoiningState) byteBufferChannel$writeByte$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        b = b4;
                        byteBufferChannel = byteBufferChannel4;
                        while (true) {
                            if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        int i2 = byteBufferChannel$writeByte$1.I$0;
                        byte b5 = byteBufferChannel$writeByte$1.B$0;
                        byteBuffer = (ByteBuffer) byteBufferChannel$writeByte$1.L$2;
                        byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$writeByte$1.L$1;
                        ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$writeByte$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            b2 = b5;
                            i = i2;
                            byteBufferChannel = byteBufferChannel2;
                            if (byteBufferChannel.joining == null) {
                                if (ringBufferCapacity.tryWriteExact(i)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer, i);
                                    if (byteBuffer.remaining() < i) {
                                        byteBuffer.limit(byteBuffer.capacity());
                                        byteBuffer.put(b2);
                                        byteBufferChannel.carry(byteBuffer);
                                    } else {
                                        byteBuffer.put(b2);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
                                    if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                }
                                byteBufferChannel$writeByte$1.L$0 = ringBufferCapacity;
                                byteBufferChannel$writeByte$1.L$1 = byteBufferChannel;
                                byteBufferChannel$writeByte$1.L$2 = byteBuffer;
                                byteBufferChannel$writeByte$1.B$0 = b2;
                                byteBufferChannel$writeByte$1.I$0 = i;
                                byteBufferChannel$writeByte$1.label = 5;
                                break;
                            } else {
                                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                JoiningState joiningState5 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState5);
                                if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                                    byteBufferChannel$writeByte$1.L$0 = null;
                                    byteBufferChannel$writeByte$1.L$1 = null;
                                    byteBufferChannel$writeByte$1.L$2 = null;
                                    byteBufferChannel$writeByte$1.label = 6;
                                    break;
                                } else {
                                    joiningState2 = joiningState5;
                                    byteBufferChannel3 = byteBufferChannel;
                                    b3 = b2;
                                    while (true) {
                                        if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            byteBufferChannel$writeByte$1.L$0 = null;
                                            byteBufferChannel$writeByte$1.L$1 = null;
                                            byteBufferChannel$writeByte$1.L$2 = null;
                                            byteBufferChannel$writeByte$1.label = 7;
                                            break;
                                        } else {
                                            byteBufferChannel$writeByte$1.L$0 = joiningState2;
                                            byteBufferChannel$writeByte$1.L$1 = byteBufferChannel3;
                                            byteBufferChannel$writeByte$1.L$2 = null;
                                            byteBufferChannel$writeByte$1.B$0 = b3;
                                            byteBufferChannel$writeByte$1.label = 8;
                                            if (byteBufferChannel3.writeSuspend(1, byteBufferChannel$writeByte$1) == coroutine_suspended) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            throw th;
                        }
                    case 8:
                        b3 = byteBufferChannel$writeByte$1.B$0;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$writeByte$1.L$1;
                        joiningState2 = (JoiningState) byteBufferChannel$writeByte$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteBufferChannel$writeByte$1 = new ByteBufferChannel$writeByte$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$writeByte$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteBufferChannel$writeByte$1.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x013f, code lost:
    
        if (r2.getDelegatedTo().writeShort(r8, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011e, code lost:
    
        if (r10.getDelegatedTo().writeShort(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f5, code lost:
    
        if (r8.writeSuspend(r2, r0) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
    
        if (r2.getDelegatedTo().writeShort(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0082, code lost:
    
        if (r10.writeShort(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a5, code lost:
    
        if (r10.getDelegatedTo().writeShort(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f5 -> B:25:0x00f8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeShort$suspendImpl(ByteBufferChannel byteBufferChannel, short s, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeShort$1 byteBufferChannel$writeShort$1;
        ByteBuffer byteBuffer;
        int i;
        RingBufferCapacity ringBufferCapacity;
        JoiningState joiningState;
        Throwable th;
        ByteBufferChannel byteBufferChannel2;
        ByteBufferChannel byteBufferChannel3;
        short s2;
        JoiningState joiningState2;
        if (continuation instanceof ByteBufferChannel$writeShort$1) {
            byteBufferChannel$writeShort$1 = (ByteBufferChannel$writeShort$1) continuation;
            if ((byteBufferChannel$writeShort$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeShort$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeShort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteBufferChannel$writeShort$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        JoiningState joiningState3 = byteBufferChannel.joining;
                        if (joiningState3 != null && (r10 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState3)) != null) {
                            byteBufferChannel$writeShort$1.label = 1;
                            break;
                        } else {
                            byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
                            i = 2;
                            if (byteBuffer == null) {
                                JoiningState joiningState4 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState4);
                                if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                    joiningState = joiningState4;
                                    while (true) {
                                        if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            byteBufferChannel$writeShort$1.L$0 = null;
                                            byteBufferChannel$writeShort$1.L$1 = null;
                                            byteBufferChannel$writeShort$1.label = 3;
                                            break;
                                        } else {
                                            byteBufferChannel$writeShort$1.L$0 = joiningState;
                                            byteBufferChannel$writeShort$1.L$1 = byteBufferChannel;
                                            byteBufferChannel$writeShort$1.S$0 = s;
                                            byteBufferChannel$writeShort$1.label = 4;
                                            if (byteBufferChannel.writeSuspend(1, byteBufferChannel$writeShort$1) == coroutine_suspended) {
                                            }
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                byteBufferChannel$writeShort$1.label = 2;
                                break;
                            } else {
                                RingBufferCapacity ringBufferCapacity2 = byteBufferChannel.getState().capacity;
                                if (ringBufferCapacity2.tryWriteExact(2)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer, 2);
                                    if (byteBuffer.remaining() < 2) {
                                        byteBuffer.limit(byteBuffer.capacity());
                                        byteBuffer.putShort(s);
                                        byteBufferChannel.carry(byteBuffer);
                                    } else {
                                        byteBuffer.putShort(s);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity2, 2);
                                    if (ringBufferCapacity2.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                } else {
                                    ringBufferCapacity = ringBufferCapacity2;
                                    try {
                                        byteBufferChannel$writeShort$1.L$0 = ringBufferCapacity;
                                        byteBufferChannel$writeShort$1.L$1 = byteBufferChannel;
                                        byteBufferChannel$writeShort$1.L$2 = byteBuffer;
                                        byteBufferChannel$writeShort$1.S$0 = s;
                                        byteBufferChannel$writeShort$1.I$0 = i;
                                        byteBufferChannel$writeShort$1.label = 5;
                                        break;
                                    } catch (Throwable th2) {
                                        byteBufferChannel2 = byteBufferChannel;
                                        th = th2;
                                        byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                                        byteBufferChannel2.tryTerminate$ktor_io();
                                        throw th;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        short s3 = byteBufferChannel$writeShort$1.S$0;
                        ByteBufferChannel byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$writeShort$1.L$1;
                        joiningState = (JoiningState) byteBufferChannel$writeShort$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        s = s3;
                        byteBufferChannel = byteBufferChannel4;
                        while (true) {
                            if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        int i2 = byteBufferChannel$writeShort$1.I$0;
                        s = byteBufferChannel$writeShort$1.S$0;
                        ByteBuffer byteBuffer2 = (ByteBuffer) byteBufferChannel$writeShort$1.L$2;
                        byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$writeShort$1.L$1;
                        ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$writeShort$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            byteBuffer = byteBuffer2;
                            i = i2;
                            byteBufferChannel = byteBufferChannel2;
                            if (byteBufferChannel.joining == null) {
                                if (ringBufferCapacity.tryWriteExact(i)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer, i);
                                    if (byteBuffer.remaining() < i) {
                                        byteBuffer.limit(byteBuffer.capacity());
                                        byteBuffer.putShort(s);
                                        byteBufferChannel.carry(byteBuffer);
                                    } else {
                                        byteBuffer.putShort(s);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
                                    if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                }
                                byteBufferChannel$writeShort$1.L$0 = ringBufferCapacity;
                                byteBufferChannel$writeShort$1.L$1 = byteBufferChannel;
                                byteBufferChannel$writeShort$1.L$2 = byteBuffer;
                                byteBufferChannel$writeShort$1.S$0 = s;
                                byteBufferChannel$writeShort$1.I$0 = i;
                                byteBufferChannel$writeShort$1.label = 5;
                                break;
                            } else {
                                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                JoiningState joiningState5 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState5);
                                if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                                    byteBufferChannel$writeShort$1.L$0 = null;
                                    byteBufferChannel$writeShort$1.L$1 = null;
                                    byteBufferChannel$writeShort$1.L$2 = null;
                                    byteBufferChannel$writeShort$1.label = 6;
                                    break;
                                } else {
                                    short s4 = s;
                                    byteBufferChannel3 = byteBufferChannel;
                                    s2 = s4;
                                    joiningState2 = joiningState5;
                                    while (true) {
                                        if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            byteBufferChannel$writeShort$1.L$0 = null;
                                            byteBufferChannel$writeShort$1.L$1 = null;
                                            byteBufferChannel$writeShort$1.L$2 = null;
                                            byteBufferChannel$writeShort$1.label = 7;
                                            break;
                                        } else {
                                            byteBufferChannel$writeShort$1.L$0 = joiningState2;
                                            byteBufferChannel$writeShort$1.L$1 = byteBufferChannel3;
                                            byteBufferChannel$writeShort$1.L$2 = null;
                                            byteBufferChannel$writeShort$1.S$0 = s2;
                                            byteBufferChannel$writeShort$1.label = 8;
                                            if (byteBufferChannel3.writeSuspend(1, byteBufferChannel$writeShort$1) == coroutine_suspended) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            throw th;
                        }
                    case 8:
                        s2 = byteBufferChannel$writeShort$1.S$0;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$writeShort$1.L$1;
                        joiningState2 = (JoiningState) byteBufferChannel$writeShort$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteBufferChannel$writeShort$1 = new ByteBufferChannel$writeShort$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$writeShort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteBufferChannel$writeShort$1.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x013b, code lost:
    
        if (r9.writeInt(r8, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011b, code lost:
    
        if (r8.writeInt(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f3, code lost:
    
        if (r8.writeSuspend(r3, r0) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c0, code lost:
    
        if (r8.writeInt(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0082, code lost:
    
        if (r10.writeInt(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a4, code lost:
    
        if (r8.writeInt(r9, r0) == r1) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f3 -> B:25:0x00f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeInt$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeInt$1 byteBufferChannel$writeInt$1;
        RingBufferCapacity ringBufferCapacity;
        ByteBuffer byteBuffer;
        JoiningState joiningState;
        Throwable th;
        ByteBufferChannel byteBufferChannel2;
        ByteBufferChannel byteBufferChannel3;
        int i2;
        JoiningState joiningState2;
        if (continuation instanceof ByteBufferChannel$writeInt$1) {
            byteBufferChannel$writeInt$1 = (ByteBufferChannel$writeInt$1) continuation;
            if ((byteBufferChannel$writeInt$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeInt$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeInt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = 4;
                switch (byteBufferChannel$writeInt$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        JoiningState joiningState3 = byteBufferChannel.joining;
                        if (joiningState3 != null && (r10 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState3)) != null) {
                            byteBufferChannel$writeInt$1.label = 1;
                            break;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferChannel.setupStateForWrite$ktor_io();
                            if (byteBuffer2 == null) {
                                JoiningState joiningState4 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState4);
                                if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                                    ByteBufferChannel delegatedTo = joiningState4.getDelegatedTo();
                                    byteBufferChannel$writeInt$1.label = 2;
                                    break;
                                } else {
                                    joiningState = joiningState4;
                                    while (true) {
                                        if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            ByteBufferChannel delegatedTo2 = joiningState.getDelegatedTo();
                                            byteBufferChannel$writeInt$1.L$0 = null;
                                            byteBufferChannel$writeInt$1.L$1 = null;
                                            byteBufferChannel$writeInt$1.label = 3;
                                            break;
                                        } else {
                                            byteBufferChannel$writeInt$1.L$0 = joiningState;
                                            byteBufferChannel$writeInt$1.L$1 = byteBufferChannel;
                                            byteBufferChannel$writeInt$1.I$0 = i;
                                            byteBufferChannel$writeInt$1.label = 4;
                                            if (byteBufferChannel.writeSuspend(1, byteBufferChannel$writeInt$1) == coroutine_suspended) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                RingBufferCapacity ringBufferCapacity2 = byteBufferChannel.getState().capacity;
                                if (ringBufferCapacity2.tryWriteExact(4)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer2, 4);
                                    if (byteBuffer2.remaining() < 4) {
                                        byteBuffer2.limit(byteBuffer2.capacity());
                                        byteBuffer2.putInt(i);
                                        byteBufferChannel.carry(byteBuffer2);
                                    } else {
                                        byteBuffer2.putInt(i);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer2, ringBufferCapacity2, 4);
                                    if (ringBufferCapacity2.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                } else {
                                    ringBufferCapacity = ringBufferCapacity2;
                                    byteBuffer = byteBuffer2;
                                    try {
                                        byteBufferChannel$writeInt$1.L$0 = ringBufferCapacity;
                                        byteBufferChannel$writeInt$1.L$1 = byteBufferChannel;
                                        byteBufferChannel$writeInt$1.L$2 = byteBuffer;
                                        byteBufferChannel$writeInt$1.I$0 = i;
                                        byteBufferChannel$writeInt$1.I$1 = i3;
                                        byteBufferChannel$writeInt$1.label = 5;
                                        break;
                                    } catch (Throwable th2) {
                                        byteBufferChannel2 = byteBufferChannel;
                                        th = th2;
                                        byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                                        byteBufferChannel2.tryTerminate$ktor_io();
                                        throw th;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        int i4 = byteBufferChannel$writeInt$1.I$0;
                        ByteBufferChannel byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$writeInt$1.L$1;
                        joiningState = (JoiningState) byteBufferChannel$writeInt$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i4;
                        byteBufferChannel = byteBufferChannel4;
                        while (true) {
                            if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return Unit.INSTANCE;
                    case 5:
                        int i5 = byteBufferChannel$writeInt$1.I$1;
                        i = byteBufferChannel$writeInt$1.I$0;
                        byteBuffer = (ByteBuffer) byteBufferChannel$writeInt$1.L$2;
                        byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$writeInt$1.L$1;
                        ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$writeInt$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = i5;
                            byteBufferChannel = byteBufferChannel2;
                            if (byteBufferChannel.joining == null) {
                                if (ringBufferCapacity.tryWriteExact(i3)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer, i3);
                                    if (byteBuffer.remaining() < i3) {
                                        byteBuffer.limit(byteBuffer.capacity());
                                        byteBuffer.putInt(i);
                                        byteBufferChannel.carry(byteBuffer);
                                    } else {
                                        byteBuffer.putInt(i);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i3);
                                    if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                }
                                byteBufferChannel$writeInt$1.L$0 = ringBufferCapacity;
                                byteBufferChannel$writeInt$1.L$1 = byteBufferChannel;
                                byteBufferChannel$writeInt$1.L$2 = byteBuffer;
                                byteBufferChannel$writeInt$1.I$0 = i;
                                byteBufferChannel$writeInt$1.I$1 = i3;
                                byteBufferChannel$writeInt$1.label = 5;
                                break;
                            } else {
                                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                JoiningState joiningState5 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState5);
                                if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                    int i6 = i;
                                    byteBufferChannel3 = byteBufferChannel;
                                    i2 = i6;
                                    joiningState2 = joiningState5;
                                    while (true) {
                                        if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            ByteBufferChannel delegatedTo3 = joiningState2.getDelegatedTo();
                                            byteBufferChannel$writeInt$1.L$0 = null;
                                            byteBufferChannel$writeInt$1.L$1 = null;
                                            byteBufferChannel$writeInt$1.L$2 = null;
                                            byteBufferChannel$writeInt$1.label = 7;
                                            break;
                                        } else {
                                            byteBufferChannel$writeInt$1.L$0 = joiningState2;
                                            byteBufferChannel$writeInt$1.L$1 = byteBufferChannel3;
                                            byteBufferChannel$writeInt$1.L$2 = null;
                                            byteBufferChannel$writeInt$1.I$0 = i2;
                                            byteBufferChannel$writeInt$1.label = 8;
                                            if (byteBufferChannel3.writeSuspend(1, byteBufferChannel$writeInt$1) == coroutine_suspended) {
                                            }
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                ByteBufferChannel delegatedTo4 = joiningState5.getDelegatedTo();
                                byteBufferChannel$writeInt$1.L$0 = null;
                                byteBufferChannel$writeInt$1.L$1 = null;
                                byteBufferChannel$writeInt$1.L$2 = null;
                                byteBufferChannel$writeInt$1.label = 6;
                                break;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            throw th;
                        }
                    case 8:
                        i2 = byteBufferChannel$writeInt$1.I$0;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$writeInt$1.L$1;
                        joiningState2 = (JoiningState) byteBufferChannel$writeInt$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return coroutine_suspended;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteBufferChannel$writeInt$1 = new ByteBufferChannel$writeInt$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$writeInt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i32 = 4;
        switch (byteBufferChannel$writeInt$1.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x013f, code lost:
    
        if (r12.writeLong(r10, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011f, code lost:
    
        if (r10.writeLong(r12, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        if (r10.writeSuspend(r11, r0) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c1, code lost:
    
        if (r10.writeLong(r11, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0083, code lost:
    
        if (r13.writeLong(r11, r0) == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a5, code lost:
    
        if (r10.writeLong(r11, r0) == r1) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f7 -> B:25:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeLong$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeLong$1 byteBufferChannel$writeLong$1;
        RingBufferCapacity ringBufferCapacity;
        ByteBuffer byteBuffer;
        long j2;
        int i;
        JoiningState joiningState;
        Throwable th;
        ByteBufferChannel byteBufferChannel2;
        JoiningState joiningState2;
        ByteBufferChannel byteBufferChannel3;
        long j3;
        if (continuation instanceof ByteBufferChannel$writeLong$1) {
            byteBufferChannel$writeLong$1 = (ByteBufferChannel$writeLong$1) continuation;
            if ((byteBufferChannel$writeLong$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeLong$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeLong$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteBufferChannel$writeLong$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        JoiningState joiningState3 = byteBufferChannel.joining;
                        if (joiningState3 != null && (r13 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState3)) != null) {
                            byteBufferChannel$writeLong$1.label = 1;
                            break;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferChannel.setupStateForWrite$ktor_io();
                            if (byteBuffer2 == null) {
                                JoiningState joiningState4 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState4);
                                if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                    joiningState = joiningState4;
                                    while (true) {
                                        if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            ByteBufferChannel delegatedTo = joiningState.getDelegatedTo();
                                            byteBufferChannel$writeLong$1.L$0 = null;
                                            byteBufferChannel$writeLong$1.L$1 = null;
                                            byteBufferChannel$writeLong$1.label = 3;
                                            break;
                                        } else {
                                            byteBufferChannel$writeLong$1.L$0 = joiningState;
                                            byteBufferChannel$writeLong$1.L$1 = byteBufferChannel;
                                            byteBufferChannel$writeLong$1.J$0 = j;
                                            byteBufferChannel$writeLong$1.label = 4;
                                            if (byteBufferChannel.writeSuspend(1, byteBufferChannel$writeLong$1) == coroutine_suspended) {
                                            }
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                ByteBufferChannel delegatedTo2 = joiningState4.getDelegatedTo();
                                byteBufferChannel$writeLong$1.label = 2;
                                break;
                            } else {
                                RingBufferCapacity ringBufferCapacity2 = byteBufferChannel.getState().capacity;
                                if (ringBufferCapacity2.tryWriteExact(8)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer2, 8);
                                    if (byteBuffer2.remaining() < 8) {
                                        byteBuffer2.limit(byteBuffer2.capacity());
                                        byteBuffer2.putLong(j);
                                        byteBufferChannel.carry(byteBuffer2);
                                    } else {
                                        byteBuffer2.putLong(j);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer2, ringBufferCapacity2, 8);
                                    if (ringBufferCapacity2.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                } else {
                                    ringBufferCapacity = ringBufferCapacity2;
                                    byteBuffer = byteBuffer2;
                                    j2 = j;
                                    i = 8;
                                    try {
                                        byteBufferChannel$writeLong$1.L$0 = ringBufferCapacity;
                                        byteBufferChannel$writeLong$1.L$1 = byteBufferChannel;
                                        byteBufferChannel$writeLong$1.L$2 = byteBuffer;
                                        byteBufferChannel$writeLong$1.J$0 = j2;
                                        byteBufferChannel$writeLong$1.I$0 = i;
                                        byteBufferChannel$writeLong$1.label = 5;
                                        break;
                                    } catch (Throwable th2) {
                                        byteBufferChannel2 = byteBufferChannel;
                                        th = th2;
                                        byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                                        byteBufferChannel2.tryTerminate$ktor_io();
                                        throw th;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        long j4 = byteBufferChannel$writeLong$1.J$0;
                        ByteBufferChannel byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$writeLong$1.L$1;
                        joiningState = (JoiningState) byteBufferChannel$writeLong$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        byteBufferChannel = byteBufferChannel4;
                        j = j4;
                        while (true) {
                            if (byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        int i2 = byteBufferChannel$writeLong$1.I$0;
                        long j5 = byteBufferChannel$writeLong$1.J$0;
                        byteBuffer = (ByteBuffer) byteBufferChannel$writeLong$1.L$2;
                        byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$writeLong$1.L$1;
                        ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$writeLong$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            j2 = j5;
                            i = i2;
                            byteBufferChannel = byteBufferChannel2;
                            if (byteBufferChannel.joining == null) {
                                if (ringBufferCapacity.tryWriteExact(i)) {
                                    byteBufferChannel.prepareWriteBuffer$ktor_io(byteBuffer, i);
                                    if (byteBuffer.remaining() < i) {
                                        byteBuffer.limit(byteBuffer.capacity());
                                        byteBuffer.putLong(j2);
                                        byteBufferChannel.carry(byteBuffer);
                                    } else {
                                        byteBuffer.putLong(j2);
                                    }
                                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
                                    if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                                        byteBufferChannel.flush();
                                    }
                                    byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel.tryTerminate$ktor_io();
                                }
                                byteBufferChannel$writeLong$1.L$0 = ringBufferCapacity;
                                byteBufferChannel$writeLong$1.L$1 = byteBufferChannel;
                                byteBufferChannel$writeLong$1.L$2 = byteBuffer;
                                byteBufferChannel$writeLong$1.J$0 = j2;
                                byteBufferChannel$writeLong$1.I$0 = i;
                                byteBufferChannel$writeLong$1.label = 5;
                                break;
                            } else {
                                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                                JoiningState joiningState5 = byteBufferChannel.joining;
                                Intrinsics.checkNotNull(joiningState5);
                                if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                                    ByteBufferChannel delegatedTo3 = joiningState5.getDelegatedTo();
                                    byteBufferChannel$writeLong$1.L$0 = null;
                                    byteBufferChannel$writeLong$1.L$1 = null;
                                    byteBufferChannel$writeLong$1.L$2 = null;
                                    byteBufferChannel$writeLong$1.label = 6;
                                    break;
                                } else {
                                    joiningState2 = joiningState5;
                                    long j6 = j2;
                                    byteBufferChannel3 = byteBufferChannel;
                                    j3 = j6;
                                    while (true) {
                                        if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                            ByteBufferChannel delegatedTo4 = joiningState2.getDelegatedTo();
                                            byteBufferChannel$writeLong$1.L$0 = null;
                                            byteBufferChannel$writeLong$1.L$1 = null;
                                            byteBufferChannel$writeLong$1.L$2 = null;
                                            byteBufferChannel$writeLong$1.label = 7;
                                            break;
                                        } else {
                                            byteBufferChannel$writeLong$1.L$0 = joiningState2;
                                            byteBufferChannel$writeLong$1.L$1 = byteBufferChannel3;
                                            byteBufferChannel$writeLong$1.L$2 = null;
                                            byteBufferChannel$writeLong$1.J$0 = j3;
                                            byteBufferChannel$writeLong$1.label = 8;
                                            if (byteBufferChannel3.writeSuspend(1, byteBufferChannel$writeLong$1) == coroutine_suspended) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            byteBufferChannel2.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            throw th;
                        }
                    case 8:
                        j3 = byteBufferChannel$writeLong$1.J$0;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$writeLong$1.L$1;
                        joiningState2 = (JoiningState) byteBufferChannel$writeLong$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (true) {
                            if (byteBufferChannel3.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            }
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteBufferChannel$writeLong$1 = new ByteBufferChannel$writeLong$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$writeLong$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteBufferChannel$writeLong$1.label) {
        }
    }

    static /* synthetic */ Object writeDouble$suspendImpl(ByteBufferChannel byteBufferChannel, double d, Continuation<? super Unit> continuation) {
        Object writeLong = byteBufferChannel.writeLong(Double.doubleToRawLongBits(d), continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFloat$suspendImpl(ByteBufferChannel byteBufferChannel, float f, Continuation<? super Unit> continuation) {
        Object writeInt = byteBufferChannel.writeInt(Float.floatToRawIntBits(f), continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    private final Object writePrimitive(int i, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = resolveDelegation(this, joiningState);
            if (resolveDelegation != null) {
                function1.invoke(resolveDelegation);
                return Unit.INSTANCE;
            }
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            if (ringBufferCapacity.tryWriteExact(i)) {
                prepareWriteBuffer$ktor_io(byteBuffer, i);
                if (byteBuffer.remaining() < i) {
                    byteBuffer.limit(byteBuffer.capacity());
                    function12.invoke(byteBuffer);
                    carry(byteBuffer);
                } else {
                    function12.invoke(byteBuffer);
                }
                bytesWritten(byteBuffer, ringBufferCapacity, i);
                Unit unit = Unit.INSTANCE;
                if (ringBufferCapacity.isFull() || getAutoFlush()) {
                    flush();
                }
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
                return Unit.INSTANCE;
            }
            while (true) {
                try {
                    writeSuspend(i, continuation);
                    if (this.joining != null) {
                        restoreStateAfterWrite$ktor_io();
                        JoiningState joiningState2 = this.joining;
                        Intrinsics.checkNotNull(joiningState2);
                        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                            function1.invoke(joiningState2.getDelegatedTo());
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                writeSuspend(1, continuation);
                            }
                            function1.invoke(joiningState2.getDelegatedTo());
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                            Unit unit5 = Unit.INSTANCE;
                        }
                        Unit unit6 = Unit.INSTANCE;
                    } else if (ringBufferCapacity.tryWriteExact(i)) {
                        prepareWriteBuffer$ktor_io(byteBuffer, i);
                        if (byteBuffer.remaining() < i) {
                            byteBuffer.limit(byteBuffer.capacity());
                            function12.invoke(byteBuffer);
                            carry(byteBuffer);
                        } else {
                            function12.invoke(byteBuffer);
                        }
                        bytesWritten(byteBuffer, ringBufferCapacity, i);
                        Unit unit7 = Unit.INSTANCE;
                        if (ringBufferCapacity.isFull() || getAutoFlush()) {
                            flush();
                        }
                        restoreStateAfterWrite$ktor_io();
                        tryTerminate$ktor_io();
                        Unit unit8 = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    restoreStateAfterWrite$ktor_io();
                    tryTerminate$ktor_io();
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
        JoiningState joiningState3 = this.joining;
        Intrinsics.checkNotNull(joiningState3);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            function1.invoke(joiningState3.getDelegatedTo());
            Unit unit9 = Unit.INSTANCE;
        } else {
            while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                writeSuspend(1, continuation);
            }
            function1.invoke(joiningState3.getDelegatedTo());
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final boolean tryWritePrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBuffer, Unit> function1) {
        if (!ringBufferCapacity.tryWriteExact(i)) {
            return false;
        }
        prepareWriteBuffer$ktor_io(byteBuffer, i);
        if (byteBuffer.remaining() < i) {
            byteBuffer.limit(byteBuffer.capacity());
            function1.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function1.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
        return true;
    }

    private final void doWritePrimitive(int size, ByteBuffer buffer, RingBufferCapacity capacity, Function1<? super ByteBuffer, Unit> writer) {
        if (buffer.remaining() < size) {
            buffer.limit(buffer.capacity());
            writer.invoke(buffer);
            carry(buffer);
        } else {
            writer.invoke(buffer);
        }
        bytesWritten(buffer, capacity, size);
        if (capacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
    }

    private final Object writeSuspendPrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) {
        do {
            try {
                writeSuspend(i, continuation);
                if (this.joining != null) {
                    restoreStateAfterWrite$ktor_io();
                    JoiningState joiningState = this.joining;
                    Intrinsics.checkNotNull(joiningState);
                    if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                        function1.invoke(joiningState.getDelegatedTo());
                        Unit unit = Unit.INSTANCE;
                    } else {
                        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            writeSuspend(1, continuation);
                        }
                        function1.invoke(joiningState.getDelegatedTo());
                        Unit unit2 = Unit.INSTANCE;
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            } catch (Throwable th) {
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
                throw th;
            }
        } while (!ringBufferCapacity.tryWriteExact(i));
        prepareWriteBuffer$ktor_io(byteBuffer, i);
        if (byteBuffer.remaining() < i) {
            byteBuffer.limit(byteBuffer.capacity());
            function12.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function12.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        Unit unit5 = Unit.INSTANCE;
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
        return Unit.INSTANCE;
    }

    private final Object delegatePrimitive(Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) {
        JoiningState joiningState = this.joining;
        Intrinsics.checkNotNull(joiningState);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            function1.invoke(joiningState.getDelegatedTo());
            return Unit.INSTANCE;
        }
        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            writeSuspend(1, continuation);
        }
        function1.invoke(joiningState.getDelegatedTo());
        Unit unit = Unit.INSTANCE;
        Unit unit2 = Unit.INSTANCE;
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object awaitFreeSpace$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation<? super Unit> continuation) {
        Object writeSuspend = byteBufferChannel.writeSuspend(1, continuation);
        return writeSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeSuspend : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel resolveDelegation;
        ByteBufferChannel resolveDelegation2;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
            return resolveDelegation2.writeAvailable(byteBuffer, continuation);
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        return (joiningState2 == null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2)) == null) ? byteBufferChannel.writeAvailableSuspend(byteBuffer, continuation) : resolveDelegation.writeAvailableSuspend(byteBuffer, continuation);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel resolveDelegation;
        ByteBufferChannel resolveDelegation2;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
            return resolveDelegation2.writeAvailable(chunkBuffer, continuation);
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(chunkBuffer);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        return (joiningState2 == null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2)) == null) ? byteBufferChannel.writeAvailableSuspend(chunkBuffer, continuation) : resolveDelegation.writeAvailableSuspend(chunkBuffer, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAvailableSuspend(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel$writeAvailableSuspend$1 byteBufferChannel$writeAvailableSuspend$1;
        Object coroutine_suspended;
        int i;
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState;
        Object writeAvailable;
        ByteBufferChannel resolveDelegation;
        if (continuation instanceof ByteBufferChannel$writeAvailableSuspend$1) {
            byteBufferChannel$writeAvailableSuspend$1 = (ByteBufferChannel$writeAvailableSuspend$1) continuation;
            if ((byteBufferChannel$writeAvailableSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeAvailableSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeAvailableSuspend$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$writeAvailableSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$writeAvailableSuspend$1.L$0 = this;
                    byteBufferChannel$writeAvailableSuspend$1.L$1 = byteBuffer;
                    byteBufferChannel$writeAvailableSuspend$1.label = 1;
                    if (writeSuspend(1, byteBufferChannel$writeAvailableSuspend$1) != coroutine_suspended) {
                        byteBufferChannel = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                byteBuffer = (ByteBuffer) byteBufferChannel$writeAvailableSuspend$1.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeAvailableSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                joiningState = byteBufferChannel.joining;
                if (joiningState != null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                    byteBufferChannel$writeAvailableSuspend$1.L$0 = null;
                    byteBufferChannel$writeAvailableSuspend$1.L$1 = null;
                    byteBufferChannel$writeAvailableSuspend$1.label = 3;
                    writeAvailable = byteBufferChannel.writeAvailable(byteBuffer, byteBufferChannel$writeAvailableSuspend$1);
                    if (writeAvailable != coroutine_suspended) {
                        return writeAvailable;
                    }
                } else {
                    byteBufferChannel$writeAvailableSuspend$1.L$0 = null;
                    byteBufferChannel$writeAvailableSuspend$1.L$1 = null;
                    byteBufferChannel$writeAvailableSuspend$1.label = 2;
                    Object writeAvailableSuspend = resolveDelegation.writeAvailableSuspend(byteBuffer, byteBufferChannel$writeAvailableSuspend$1);
                    if (writeAvailableSuspend != coroutine_suspended) {
                        return writeAvailableSuspend;
                    }
                }
                return coroutine_suspended;
            }
        }
        byteBufferChannel$writeAvailableSuspend$1 = new ByteBufferChannel$writeAvailableSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$writeAvailableSuspend$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeAvailableSuspend$1.label;
        if (i != 0) {
        }
        joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
        }
        byteBufferChannel$writeAvailableSuspend$1.L$0 = null;
        byteBufferChannel$writeAvailableSuspend$1.L$1 = null;
        byteBufferChannel$writeAvailableSuspend$1.label = 3;
        writeAvailable = byteBufferChannel.writeAvailable(byteBuffer, byteBufferChannel$writeAvailableSuspend$1);
        if (writeAvailable != coroutine_suspended) {
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAvailableSuspend(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        ByteBufferChannel$writeAvailableSuspend$3 byteBufferChannel$writeAvailableSuspend$3;
        Object coroutine_suspended;
        int i;
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState;
        Object writeAvailable;
        ByteBufferChannel resolveDelegation;
        if (continuation instanceof ByteBufferChannel$writeAvailableSuspend$3) {
            byteBufferChannel$writeAvailableSuspend$3 = (ByteBufferChannel$writeAvailableSuspend$3) continuation;
            if ((byteBufferChannel$writeAvailableSuspend$3.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeAvailableSuspend$3.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeAvailableSuspend$3.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$writeAvailableSuspend$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$writeAvailableSuspend$3.L$0 = this;
                    byteBufferChannel$writeAvailableSuspend$3.L$1 = chunkBuffer;
                    byteBufferChannel$writeAvailableSuspend$3.label = 1;
                    if (writeSuspend(1, byteBufferChannel$writeAvailableSuspend$3) != coroutine_suspended) {
                        byteBufferChannel = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                chunkBuffer = (ChunkBuffer) byteBufferChannel$writeAvailableSuspend$3.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeAvailableSuspend$3.L$0;
                ResultKt.throwOnFailure(obj);
                joiningState = byteBufferChannel.joining;
                if (joiningState != null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                    byteBufferChannel$writeAvailableSuspend$3.L$0 = null;
                    byteBufferChannel$writeAvailableSuspend$3.L$1 = null;
                    byteBufferChannel$writeAvailableSuspend$3.label = 3;
                    writeAvailable = byteBufferChannel.writeAvailable(chunkBuffer, byteBufferChannel$writeAvailableSuspend$3);
                    if (writeAvailable != coroutine_suspended) {
                        return writeAvailable;
                    }
                } else {
                    byteBufferChannel$writeAvailableSuspend$3.L$0 = null;
                    byteBufferChannel$writeAvailableSuspend$3.L$1 = null;
                    byteBufferChannel$writeAvailableSuspend$3.label = 2;
                    Object writeAvailableSuspend = resolveDelegation.writeAvailableSuspend(chunkBuffer, byteBufferChannel$writeAvailableSuspend$3);
                    if (writeAvailableSuspend != coroutine_suspended) {
                        return writeAvailableSuspend;
                    }
                }
                return coroutine_suspended;
            }
        }
        byteBufferChannel$writeAvailableSuspend$3 = new ByteBufferChannel$writeAvailableSuspend$3(this, continuation);
        Object obj2 = byteBufferChannel$writeAvailableSuspend$3.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeAvailableSuspend$3.label;
        if (i != 0) {
        }
        joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
        }
        byteBufferChannel$writeAvailableSuspend$3.L$0 = null;
        byteBufferChannel$writeAvailableSuspend$3.L$1 = null;
        byteBufferChannel$writeAvailableSuspend$3.label = 3;
        writeAvailable = byteBufferChannel.writeAvailable(chunkBuffer, byteBufferChannel$writeAvailableSuspend$3);
        if (writeAvailable != coroutine_suspended) {
            return coroutine_suspended;
        }
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        Object writeFullySuspend;
        ByteBufferChannel resolveDelegation;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState == null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
            byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
            return (byteBuffer.hasRemaining() && (writeFullySuspend = byteBufferChannel.writeFullySuspend(byteBuffer, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? writeFullySuspend : Unit.INSTANCE;
        }
        Object writeFully = resolveDelegation.writeFully(byteBuffer, continuation);
        return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, Buffer buffer, Continuation<? super Unit> continuation) {
        byteBufferChannel.writeAsMuchAsPossible(buffer);
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = byteBufferChannel.writeFullySuspend(buffer, continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    /* renamed from: writeFully-JT6ljtQ$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m9954writeFullyJT6ljtQ$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        Object writeFully = byteBufferChannel.writeFully(Memory.m9976slice87lwejk(byteBuffer, i, i2 - i), continuation);
        return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if (r7.writeFully(r6, r0) == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        if (r2.tryWriteSuspend$ktor_io(1, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0055 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeFullySuspend(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeFullySuspend$1 byteBufferChannel$writeFullySuspend$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$writeFullySuspend$1) {
            byteBufferChannel$writeFullySuspend$1 = (ByteBufferChannel$writeFullySuspend$1) continuation;
            if ((byteBufferChannel$writeFullySuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeFullySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeFullySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$writeFullySuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (!byteBuffer.hasRemaining()) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    byteBuffer = (ByteBuffer) byteBufferChannel$writeFullySuspend$1.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeFullySuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    JoiningState joiningState = byteBufferChannel.joining;
                    if (joiningState == null || (r7 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                        byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
                        if (!byteBuffer.hasRemaining()) {
                            byteBufferChannel$writeFullySuspend$1.L$0 = byteBufferChannel;
                            byteBufferChannel$writeFullySuspend$1.L$1 = byteBuffer;
                            byteBufferChannel$writeFullySuspend$1.label = 1;
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        byteBufferChannel$writeFullySuspend$1.L$0 = null;
                        byteBufferChannel$writeFullySuspend$1.L$1 = null;
                        byteBufferChannel$writeFullySuspend$1.label = 2;
                    }
                }
            }
        }
        byteBufferChannel$writeFullySuspend$1 = new ByteBufferChannel$writeFullySuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$writeFullySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeFullySuspend$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        if (r8.writeFully(r7, r0) == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        if (r2.tryWriteSuspend$ktor_io(1, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0059 -> B:17:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeFullySuspend(Buffer buffer, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeFullySuspend$3 byteBufferChannel$writeFullySuspend$3;
        int i;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$writeFullySuspend$3) {
            byteBufferChannel$writeFullySuspend$3 = (ByteBufferChannel$writeFullySuspend$3) continuation;
            if ((byteBufferChannel$writeFullySuspend$3.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeFullySuspend$3.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeFullySuspend$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$writeFullySuspend$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    buffer = (Buffer) byteBufferChannel$writeFullySuspend$3.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeFullySuspend$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    JoiningState joiningState = byteBufferChannel.joining;
                    if (joiningState == null || (r8 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                        byteBufferChannel.writeAsMuchAsPossible(buffer);
                        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                            byteBufferChannel$writeFullySuspend$3.L$0 = byteBufferChannel;
                            byteBufferChannel$writeFullySuspend$3.L$1 = buffer;
                            byteBufferChannel$writeFullySuspend$3.label = 1;
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        byteBufferChannel$writeFullySuspend$3.L$0 = null;
                        byteBufferChannel$writeFullySuspend$3.L$1 = null;
                        byteBufferChannel$writeFullySuspend$3.label = 2;
                    }
                }
            }
        }
        byteBufferChannel$writeFullySuspend$3 = new ByteBufferChannel$writeFullySuspend$3(this, continuation);
        Object obj2 = byteBufferChannel$writeFullySuspend$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeFullySuspend$3.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitClose(Continuation<? super Unit> continuation) {
        if (getClosed() != null) {
            return Unit.INSTANCE;
        }
        JoiningState joiningState = this.joining;
        if (joiningState == null) {
            if (getClosed() == null) {
                throw new IllegalStateException("Only works for joined.".toString());
            }
            return Unit.INSTANCE;
        }
        Object awaitClose = joiningState.awaitClose(continuation);
        return awaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitClose : Unit.INSTANCE;
    }

    public final Object joinFrom$ktor_io(ByteBufferChannel byteBufferChannel, boolean z, Continuation<? super Unit> continuation) {
        if (byteBufferChannel.getClosed() != null && byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            if (z) {
                ClosedElement closed = byteBufferChannel.getClosed();
                Intrinsics.checkNotNull(closed);
                close(closed.getCause());
            }
            return Unit.INSTANCE;
        }
        ClosedElement closed2 = getClosed();
        if (closed2 != null) {
            if (byteBufferChannel.getClosed() == null) {
                ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                throw new KotlinNothingValueException();
            }
            return Unit.INSTANCE;
        }
        JoiningState joiningState = byteBufferChannel.setupDelegateTo(this, z);
        if (byteBufferChannel.tryCompleteJoining(joiningState)) {
            Object awaitClose = byteBufferChannel.awaitClose(continuation);
            return awaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitClose : Unit.INSTANCE;
        }
        Object joinFromSuspend = joinFromSuspend(byteBufferChannel, z, joiningState, continuation);
        return joinFromSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinFromSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r9.awaitClose(r6) != r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object joinFromSuspend(ByteBufferChannel byteBufferChannel, boolean z, JoiningState joiningState, Continuation<? super Unit> continuation) {
        ByteBufferChannel$joinFromSuspend$1 byteBufferChannel$joinFromSuspend$1;
        ByteBufferChannel$joinFromSuspend$1 byteBufferChannel$joinFromSuspend$12;
        int i;
        ByteBufferChannel byteBufferChannel2;
        ByteBufferChannel byteBufferChannel3;
        if (continuation instanceof ByteBufferChannel$joinFromSuspend$1) {
            byteBufferChannel$joinFromSuspend$1 = (ByteBufferChannel$joinFromSuspend$1) continuation;
            if ((byteBufferChannel$joinFromSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$joinFromSuspend$1.label -= Integer.MIN_VALUE;
                byteBufferChannel$joinFromSuspend$12 = byteBufferChannel$joinFromSuspend$1;
                Object obj = byteBufferChannel$joinFromSuspend$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$joinFromSuspend$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$joinFromSuspend$12.L$0 = this;
                    byteBufferChannel$joinFromSuspend$12.L$1 = byteBufferChannel;
                    byteBufferChannel$joinFromSuspend$12.Z$0 = z;
                    byteBufferChannel$joinFromSuspend$12.label = 1;
                    if (copyDirect$ktor_io(byteBufferChannel, Long.MAX_VALUE, joiningState, byteBufferChannel$joinFromSuspend$12) != coroutine_suspended) {
                        byteBufferChannel2 = this;
                        byteBufferChannel3 = byteBufferChannel;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                z = byteBufferChannel$joinFromSuspend$12.Z$0;
                byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$joinFromSuspend$12.L$1;
                byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$joinFromSuspend$12.L$0;
                ResultKt.throwOnFailure(obj);
                if (!z && byteBufferChannel3.isClosedForRead()) {
                    ByteWriteChannelKt.close(byteBufferChannel2);
                    return Unit.INSTANCE;
                }
                byteBufferChannel2.flush();
                byteBufferChannel$joinFromSuspend$12.L$0 = null;
                byteBufferChannel$joinFromSuspend$12.L$1 = null;
                byteBufferChannel$joinFromSuspend$12.label = 2;
            }
        }
        byteBufferChannel$joinFromSuspend$1 = new ByteBufferChannel$joinFromSuspend$1(this, continuation);
        byteBufferChannel$joinFromSuspend$12 = byteBufferChannel$joinFromSuspend$1;
        Object obj2 = byteBufferChannel$joinFromSuspend$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$joinFromSuspend$12.label;
        if (i != 0) {
        }
        if (!z) {
        }
        byteBufferChannel2.flush();
        byteBufferChannel$joinFromSuspend$12.L$0 = null;
        byteBufferChannel$joinFromSuspend$12.L$1 = null;
        byteBufferChannel$joinFromSuspend$12.label = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0159, code lost:
    
        r4 = r27;
        r7 = r30;
        r14 = r15;
        r12 = r16;
        r8 = r18;
        r27 = r19;
        r11 = r22;
        r16 = r0;
        r15 = r1;
        r0 = r2;
        r2 = r3;
        r3 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02f8 A[Catch: all -> 0x03c0, TryCatch #0 {all -> 0x03c0, blocks: (B:95:0x02e7, B:97:0x02ed, B:100:0x02f8, B:101:0x0307, B:103:0x02f3), top: B:94:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0271 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03e7 A[Catch: all -> 0x007c, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03f2 A[Catch: all -> 0x007c, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0203 A[Catch: all -> 0x02c2, TRY_LEAVE, TryCatch #2 {all -> 0x02c2, blocks: (B:87:0x01e4, B:128:0x0203), top: B:86:0x01e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0408 A[Catch: all -> 0x007c, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0123 A[Catch: all -> 0x007c, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0315 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x033a A[Catch: all -> 0x007c, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0396 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #13 {all -> 0x007c, blocks: (B:13:0x0048, B:16:0x011d, B:18:0x0123, B:20:0x0127, B:22:0x012e, B:26:0x0315, B:29:0x031d, B:31:0x0329, B:32:0x0334, B:34:0x033a, B:36:0x0343, B:42:0x036c, B:45:0x0376, B:51:0x0392, B:53:0x0396, B:57:0x037f, B:61:0x013a, B:119:0x03e1, B:121:0x03e7, B:124:0x03f2, B:125:0x03ff, B:126:0x0405, B:127:0x03ed, B:187:0x0408, B:188:0x040b, B:193:0x0073), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015f A[Catch: all -> 0x03c4, TryCatch #4 {all -> 0x03c4, blocks: (B:68:0x0159, B:70:0x015f, B:72:0x0163), top: B:67:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a9 A[Catch: all -> 0x01c3, TRY_LEAVE, TryCatch #3 {all -> 0x01c3, blocks: (B:82:0x01a5, B:84:0x01a9), top: B:81:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ed A[Catch: all -> 0x03c0, TryCatch #0 {all -> 0x03c0, blocks: (B:95:0x02e7, B:97:0x02ed, B:100:0x02f8, B:101:0x0307, B:103:0x02f3), top: B:94:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0329 -> B:16:0x011d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0394 -> B:15:0x03ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x03b7 -> B:15:0x03ba). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object copyDirect$ktor_io(ByteBufferChannel byteBufferChannel, long j, JoiningState joiningState, Continuation<? super Long> continuation) {
        ByteBufferChannel$copyDirect$1 byteBufferChannel$copyDirect$1;
        int i;
        ByteBufferChannel byteBufferChannel2;
        ByteBufferChannel byteBufferChannel3;
        ByteBufferChannel$copyDirect$1 byteBufferChannel$copyDirect$12;
        Ref.LongRef longRef;
        JoiningState joiningState2;
        boolean z;
        long j2;
        ByteBufferChannel byteBufferChannel4;
        long j3;
        ByteBufferChannel byteBufferChannel5;
        ByteBufferChannel byteBufferChannel6;
        RingBufferCapacity ringBufferCapacity;
        Throwable th;
        ByteBufferChannel byteBufferChannel7;
        long j4;
        long j5;
        Ref.LongRef longRef2;
        JoiningState joiningState3;
        ByteBufferChannel byteBufferChannel8;
        Object obj;
        JoiningState joiningState4;
        long j6;
        JoiningState joiningState5;
        ByteBufferChannel byteBufferChannel9;
        RingBufferCapacity ringBufferCapacity2;
        ByteBuffer byteBuffer;
        ByteBufferChannel byteBufferChannel10;
        RingBufferCapacity ringBufferCapacity3;
        RingBufferCapacity ringBufferCapacity4;
        Ref.IntRef intRef;
        ByteBuffer byteBuffer2;
        boolean z2;
        ByteBufferChannel$copyDirect$1 byteBufferChannel$copyDirect$13;
        ByteBufferChannel byteBufferChannel11;
        long j7;
        long j8;
        long j9;
        Object obj2;
        RingBufferCapacity ringBufferCapacity5;
        ByteBufferChannel byteBufferChannel12;
        ByteBufferChannel byteBufferChannel13;
        ByteBufferChannel byteBufferChannel14;
        JoiningState joiningState6;
        ByteBufferChannel byteBufferChannel15;
        long j10;
        JoiningState joiningState7;
        ByteBufferChannel byteBufferChannel16;
        long j11;
        Ref.LongRef longRef3;
        ByteBufferChannel byteBufferChannel17;
        ByteBufferChannel byteBufferChannel18 = byteBufferChannel;
        try {
            if (continuation instanceof ByteBufferChannel$copyDirect$1) {
                byteBufferChannel$copyDirect$1 = (ByteBufferChannel$copyDirect$1) continuation;
                if ((byteBufferChannel$copyDirect$1.label & Integer.MIN_VALUE) != 0) {
                    byteBufferChannel$copyDirect$1.label -= Integer.MIN_VALUE;
                    Object obj3 = byteBufferChannel$copyDirect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteBufferChannel$copyDirect$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        if (byteBufferChannel18.isClosedForRead()) {
                            if (joiningState != null && !byteBufferChannel18.tryCompleteJoining(joiningState)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            if (byteBufferChannel18.getClosedCause() != null) {
                                close(byteBufferChannel18.getClosedCause());
                            }
                            return Boxing.boxLong(0L);
                        }
                        if (joiningState != null && byteBufferChannel18.tryCompleteJoining(joiningState)) {
                            return Boxing.boxLong(0L);
                        }
                        boolean autoFlush = getAutoFlush();
                        try {
                            byteBufferChannel3 = this;
                            byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                            longRef = new Ref.LongRef();
                            joiningState2 = joiningState;
                            z = autoFlush;
                            j2 = j;
                            if (longRef.element < j2) {
                            }
                            if (z) {
                            }
                            return Boxing.boxLong(longRef.element);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBufferChannel2 = this;
                            byteBufferChannel2.close(th);
                            throw th;
                        }
                    }
                    if (i != 1) {
                        if (i == 2) {
                            boolean z3 = byteBufferChannel$copyDirect$1.Z$0;
                            j11 = byteBufferChannel$copyDirect$1.J$0;
                            longRef3 = (Ref.LongRef) byteBufferChannel$copyDirect$1.L$3;
                            JoiningState joiningState8 = (JoiningState) byteBufferChannel$copyDirect$1.L$2;
                            byteBufferChannel16 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$1;
                            byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            joiningState4 = joiningState8;
                            z = z3;
                            obj = coroutine_suspended;
                            if (((Boolean) obj3).booleanValue()) {
                            }
                            coroutine_suspended = obj;
                            byteBufferChannel18 = byteBufferChannel16;
                            if (longRef.element < j2) {
                            }
                            if (z) {
                            }
                            return Boxing.boxLong(longRef.element);
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z4 = byteBufferChannel$copyDirect$1.Z$0;
                        long j12 = byteBufferChannel$copyDirect$1.J$0;
                        Ref.LongRef longRef4 = (Ref.LongRef) byteBufferChannel$copyDirect$1.L$3;
                        JoiningState joiningState9 = (JoiningState) byteBufferChannel$copyDirect$1.L$2;
                        byteBufferChannel16 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$1;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                        joiningState2 = joiningState9;
                        z = z4;
                        obj = coroutine_suspended;
                        longRef = longRef4;
                        j2 = j12;
                        coroutine_suspended = obj;
                        byteBufferChannel18 = byteBufferChannel16;
                        if (longRef.element < j2) {
                            JoiningState joiningState10 = byteBufferChannel3.joining;
                            if (joiningState10 == null || (byteBufferChannel17 = byteBufferChannel3.resolveDelegation(byteBufferChannel3, joiningState10)) == null) {
                                byteBufferChannel17 = byteBufferChannel3;
                            }
                            byteBuffer = byteBufferChannel17.setupStateForWrite$ktor_io();
                            if (byteBuffer == null) {
                                joiningState4 = joiningState2;
                                j6 = j2;
                                byteBufferChannel8 = byteBufferChannel18;
                                obj = coroutine_suspended;
                                if (joiningState4 != null) {
                                    if (!byteBufferChannel8.tryCompleteJoining(joiningState4)) {
                                        if (byteBufferChannel8.getState().capacity.flush()) {
                                            byteBufferChannel8.resumeWriteOp();
                                            coroutine_suspended = obj;
                                            byteBufferChannel18 = byteBufferChannel8;
                                            j2 = j6;
                                            joiningState2 = joiningState4;
                                            if (longRef.element < j2) {
                                            }
                                        }
                                    }
                                }
                                if (longRef.element < j6) {
                                    byteBufferChannel3.flush();
                                    if (byteBufferChannel8.get_availableForRead() == 0) {
                                        byteBufferChannel$copyDirect$12.L$0 = byteBufferChannel3;
                                        byteBufferChannel$copyDirect$12.L$1 = byteBufferChannel8;
                                        byteBufferChannel$copyDirect$12.L$2 = joiningState4;
                                        byteBufferChannel$copyDirect$12.L$3 = longRef;
                                        byteBufferChannel$copyDirect$12.L$4 = null;
                                        byteBufferChannel$copyDirect$12.L$5 = null;
                                        byteBufferChannel$copyDirect$12.L$6 = null;
                                        byteBufferChannel$copyDirect$12.L$7 = null;
                                        byteBufferChannel$copyDirect$12.L$8 = null;
                                        byteBufferChannel$copyDirect$12.L$9 = null;
                                        byteBufferChannel$copyDirect$12.J$0 = j6;
                                        byteBufferChannel$copyDirect$12.Z$0 = z;
                                        byteBufferChannel$copyDirect$12.label = 2;
                                        Object readSuspendImpl = byteBufferChannel8.readSuspendImpl(1, byteBufferChannel$copyDirect$12);
                                        if (readSuspendImpl == obj) {
                                            return obj;
                                        }
                                        byteBufferChannel16 = byteBufferChannel8;
                                        j11 = j6;
                                        byteBufferChannel$copyDirect$1 = byteBufferChannel$copyDirect$12;
                                        longRef3 = longRef;
                                        obj3 = readSuspendImpl;
                                        if (((Boolean) obj3).booleanValue()) {
                                            if (joiningState4 != null && byteBufferChannel16.tryCompleteJoining(joiningState4)) {
                                                longRef = longRef3;
                                            }
                                            longRef = longRef3;
                                            byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                                            j2 = j11;
                                            joiningState2 = joiningState4;
                                            if (byteBufferChannel3.joining != null) {
                                            }
                                        } else {
                                            if (joiningState4 != null) {
                                                if (!byteBufferChannel16.tryCompleteJoining(joiningState4)) {
                                                }
                                                longRef = longRef3;
                                                byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                                                j2 = j11;
                                                joiningState2 = joiningState4;
                                                if (byteBufferChannel3.joining != null) {
                                                    byteBufferChannel$copyDirect$12.L$0 = byteBufferChannel3;
                                                    byteBufferChannel$copyDirect$12.L$1 = byteBufferChannel16;
                                                    byteBufferChannel$copyDirect$12.L$2 = joiningState2;
                                                    byteBufferChannel$copyDirect$12.L$3 = longRef;
                                                    byteBufferChannel$copyDirect$12.L$4 = null;
                                                    byteBufferChannel$copyDirect$12.L$5 = null;
                                                    byteBufferChannel$copyDirect$12.L$6 = null;
                                                    byteBufferChannel$copyDirect$12.L$7 = null;
                                                    byteBufferChannel$copyDirect$12.L$8 = null;
                                                    byteBufferChannel$copyDirect$12.L$9 = null;
                                                    byteBufferChannel$copyDirect$12.J$0 = j2;
                                                    byteBufferChannel$copyDirect$12.Z$0 = z;
                                                    byteBufferChannel$copyDirect$12.label = 3;
                                                    if (byteBufferChannel3.tryWriteSuspend$ktor_io(1, byteBufferChannel$copyDirect$12) == obj) {
                                                        return obj;
                                                    }
                                                }
                                            }
                                            longRef = longRef3;
                                        }
                                        coroutine_suspended = obj;
                                        byteBufferChannel18 = byteBufferChannel16;
                                        if (longRef.element < j2) {
                                        }
                                    } else {
                                        byteBufferChannel16 = byteBufferChannel8;
                                        j2 = j6;
                                        joiningState2 = joiningState4;
                                        if (byteBufferChannel3.joining != null) {
                                        }
                                        coroutine_suspended = obj;
                                        byteBufferChannel18 = byteBufferChannel16;
                                        if (longRef.element < j2) {
                                        }
                                    }
                                }
                            } else {
                                RingBufferCapacity ringBufferCapacity6 = byteBufferChannel17.getState().capacity;
                                long j13 = byteBufferChannel17.get_totalBytesWritten();
                                try {
                                    ClosedElement closed = byteBufferChannel17.getClosed();
                                    if (closed != null) {
                                        ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                                        throw new KotlinNothingValueException();
                                    }
                                    try {
                                        ByteBufferChannel byteBufferChannel19 = byteBufferChannel17;
                                        if (longRef2.element < j8) {
                                            int i2 = ringBufferCapacity5._availableForWrite$internal;
                                            if (i2 == 0) {
                                                try {
                                                    byteBufferChannel$copyDirect$12.L$0 = byteBufferChannel13;
                                                    byteBufferChannel$copyDirect$12.L$1 = byteBufferChannel18;
                                                    byteBufferChannel$copyDirect$12.L$2 = joiningState2;
                                                    byteBufferChannel$copyDirect$12.L$3 = longRef2;
                                                    byteBufferChannel$copyDirect$12.L$4 = byteBufferChannel3;
                                                    byteBufferChannel$copyDirect$12.L$5 = byteBufferChannel6;
                                                    byteBufferChannel$copyDirect$12.L$6 = ringBufferCapacity6;
                                                    byteBufferChannel$copyDirect$12.L$7 = ringBufferCapacity5;
                                                    byteBufferChannel$copyDirect$12.L$8 = byteBuffer;
                                                    byteBufferChannel$copyDirect$12.L$9 = byteBufferChannel12;
                                                    byteBufferChannel$copyDirect$12.J$0 = j8;
                                                    z = z2;
                                                    byteBufferChannel$copyDirect$12.Z$0 = z;
                                                    byteBufferChannel$copyDirect$12.J$1 = j10;
                                                    byteBufferChannel$copyDirect$12.label = 1;
                                                    byteBufferChannel14 = byteBufferChannel18;
                                                    coroutine_suspended = obj2;
                                                    if (byteBufferChannel12.tryWriteSuspend$ktor_io(1, byteBufferChannel$copyDirect$12) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    j4 = j8;
                                                    byteBufferChannel4 = byteBufferChannel15;
                                                    ByteBufferChannel byteBufferChannel20 = byteBufferChannel12;
                                                    joiningState6 = joiningState7;
                                                    byteBufferChannel10 = byteBufferChannel20;
                                                    byteBufferChannel$copyDirect$1 = byteBufferChannel$copyDirect$12;
                                                    ringBufferCapacity = ringBufferCapacity6;
                                                    j3 = j10;
                                                    try {
                                                        if (byteBufferChannel10.joining != null) {
                                                            try {
                                                                byteBufferChannel10.prepareBuffer(byteBuffer, byteBufferChannel10.writePosition, i2);
                                                                intRef = new Ref.IntRef();
                                                                int i3 = i2;
                                                                byteBuffer2 = byteBufferChannel8.setupStateForRead();
                                                                if (byteBuffer2 != null) {
                                                                    z2 = z;
                                                                    byteBufferChannel$copyDirect$13 = byteBufferChannel$copyDirect$12;
                                                                } else {
                                                                    try {
                                                                        z2 = z;
                                                                        RingBufferCapacity ringBufferCapacity7 = byteBufferChannel8.getState().capacity;
                                                                        if (ringBufferCapacity7._availableForRead$internal != 0) {
                                                                            try {
                                                                                try {
                                                                                    int tryWriteAtMost = ringBufferCapacity3.tryWriteAtMost((int) Math.min(byteBuffer2.remaining(), Math.min(byteBuffer.remaining(), j4 - longRef2.element)));
                                                                                    if (tryWriteAtMost > 0) {
                                                                                        if (!ringBufferCapacity7.tryReadExact(tryWriteAtMost)) {
                                                                                            throw new AssertionError();
                                                                                        }
                                                                                        byteBuffer2.limit(byteBuffer2.position() + tryWriteAtMost);
                                                                                        byteBuffer.put(byteBuffer2);
                                                                                        intRef.element = tryWriteAtMost;
                                                                                        byteBufferChannel8.bytesRead(byteBuffer2, ringBufferCapacity7, tryWriteAtMost);
                                                                                    }
                                                                                    byteBufferChannel8.restoreStateAfterRead();
                                                                                    byteBufferChannel8.tryTerminate$ktor_io();
                                                                                    if (intRef.element > 0) {
                                                                                        try {
                                                                                            byteBufferChannel10.bytesWritten(byteBuffer, ringBufferCapacity3, intRef.element);
                                                                                            longRef2.element += intRef.element;
                                                                                            if (i3 - intRef.element == 0 || z2) {
                                                                                                byteBufferChannel10.flush();
                                                                                            }
                                                                                            joiningState2 = joiningState5;
                                                                                            byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$13;
                                                                                            byteBufferChannel3 = byteBufferChannel9;
                                                                                            j8 = j4;
                                                                                            byteBufferChannel6 = byteBufferChannel11;
                                                                                            j9 = j7;
                                                                                            ringBufferCapacity6 = ringBufferCapacity4;
                                                                                            obj2 = obj;
                                                                                            ringBufferCapacity5 = ringBufferCapacity3;
                                                                                            byteBufferChannel18 = byteBufferChannel8;
                                                                                            byteBufferChannel12 = byteBufferChannel10;
                                                                                            byteBufferChannel13 = byteBufferChannel7;
                                                                                            if (longRef2.element < j8) {
                                                                                            }
                                                                                        } catch (Throwable th3) {
                                                                                            th = th3;
                                                                                            byteBufferChannel5 = byteBufferChannel9;
                                                                                            byteBufferChannel6 = byteBufferChannel11;
                                                                                            j3 = j7;
                                                                                            ringBufferCapacity = ringBufferCapacity4;
                                                                                            if (!ringBufferCapacity.isFull() || byteBufferChannel6.getAutoFlush()) {
                                                                                                byteBufferChannel6.flush();
                                                                                            }
                                                                                            if (byteBufferChannel6 != byteBufferChannel5) {
                                                                                                byteBufferChannel5.setTotalBytesWritten$ktor_io(byteBufferChannel5.get_totalBytesWritten() + (byteBufferChannel6.get_totalBytesWritten() - j3));
                                                                                            }
                                                                                            byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                                                            byteBufferChannel6.tryTerminate$ktor_io();
                                                                                            throw th;
                                                                                        }
                                                                                    } else {
                                                                                        joiningState3 = joiningState5;
                                                                                        z = z2;
                                                                                        byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$13;
                                                                                        byteBufferChannel3 = byteBufferChannel9;
                                                                                        byteBufferChannel6 = byteBufferChannel11;
                                                                                        j5 = j7;
                                                                                        ringBufferCapacity6 = ringBufferCapacity4;
                                                                                        if (!ringBufferCapacity6.isFull()) {
                                                                                        }
                                                                                        byteBufferChannel6.flush();
                                                                                        if (byteBufferChannel6 != byteBufferChannel3) {
                                                                                        }
                                                                                        byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                                                        byteBufferChannel6.tryTerminate$ktor_io();
                                                                                        joiningState4 = joiningState3;
                                                                                        longRef = longRef2;
                                                                                        j6 = j4;
                                                                                        byteBufferChannel3 = byteBufferChannel7;
                                                                                        if (joiningState4 != null) {
                                                                                        }
                                                                                        if (longRef.element < j6) {
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    byteBufferChannel8.restoreStateAfterRead();
                                                                                    byteBufferChannel8.tryTerminate$ktor_io();
                                                                                    throw th;
                                                                                }
                                                                                byteBufferChannel7 = byteBufferChannel4;
                                                                                ringBufferCapacity4 = ringBufferCapacity2;
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                                byteBufferChannel7 = byteBufferChannel4;
                                                                                ringBufferCapacity4 = ringBufferCapacity2;
                                                                                byteBufferChannel8.restoreStateAfterRead();
                                                                                byteBufferChannel8.tryTerminate$ktor_io();
                                                                                throw th;
                                                                            }
                                                                            byteBufferChannel11 = byteBufferChannel6;
                                                                            j7 = j3;
                                                                        } else {
                                                                            try {
                                                                                byteBufferChannel8.restoreStateAfterRead();
                                                                                byteBufferChannel8.tryTerminate$ktor_io();
                                                                            } catch (Throwable th6) {
                                                                                th = th6;
                                                                                ringBufferCapacity = ringBufferCapacity2;
                                                                                byteBufferChannel5 = byteBufferChannel9;
                                                                                if (!ringBufferCapacity.isFull()) {
                                                                                }
                                                                                byteBufferChannel6.flush();
                                                                                if (byteBufferChannel6 != byteBufferChannel5) {
                                                                                }
                                                                                byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                                                byteBufferChannel6.tryTerminate$ktor_io();
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        byteBufferChannel11 = byteBufferChannel6;
                                                                        j7 = j3;
                                                                    }
                                                                    byteBufferChannel$copyDirect$13 = byteBufferChannel$copyDirect$12;
                                                                }
                                                                byteBufferChannel11 = byteBufferChannel6;
                                                                j7 = j3;
                                                                byteBufferChannel7 = byteBufferChannel4;
                                                                ringBufferCapacity4 = ringBufferCapacity2;
                                                                if (intRef.element > 0) {
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                byteBufferChannel7 = byteBufferChannel4;
                                                                ringBufferCapacity4 = ringBufferCapacity2;
                                                                byteBufferChannel5 = byteBufferChannel9;
                                                            }
                                                            JoiningState joiningState11 = joiningState6;
                                                            byteBufferChannel8 = byteBufferChannel14;
                                                            joiningState5 = joiningState11;
                                                            Object obj4 = coroutine_suspended;
                                                            i2 = ringBufferCapacity5._availableForWrite$internal;
                                                            obj = obj4;
                                                            ringBufferCapacity3 = ringBufferCapacity5;
                                                            byteBufferChannel9 = byteBufferChannel3;
                                                            ringBufferCapacity2 = ringBufferCapacity;
                                                            byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                                                        } else {
                                                            obj = coroutine_suspended;
                                                            byteBufferChannel7 = byteBufferChannel4;
                                                            j5 = j3;
                                                            ringBufferCapacity6 = ringBufferCapacity;
                                                            byteBufferChannel$copyDirect$12 = byteBufferChannel$copyDirect$1;
                                                            joiningState3 = joiningState6;
                                                            byteBufferChannel8 = byteBufferChannel14;
                                                            if (!ringBufferCapacity6.isFull()) {
                                                            }
                                                            byteBufferChannel6.flush();
                                                            if (byteBufferChannel6 != byteBufferChannel3) {
                                                            }
                                                            byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                            byteBufferChannel6.tryTerminate$ktor_io();
                                                            joiningState4 = joiningState3;
                                                            longRef = longRef2;
                                                            j6 = j4;
                                                            byteBufferChannel3 = byteBufferChannel7;
                                                            if (joiningState4 != null) {
                                                            }
                                                            if (longRef.element < j6) {
                                                            }
                                                        }
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        byteBufferChannel5 = byteBufferChannel3;
                                                        if (!ringBufferCapacity.isFull()) {
                                                        }
                                                        byteBufferChannel6.flush();
                                                        if (byteBufferChannel6 != byteBufferChannel5) {
                                                        }
                                                        byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                        byteBufferChannel6.tryTerminate$ktor_io();
                                                        throw th;
                                                    }
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    ringBufferCapacity = ringBufferCapacity6;
                                                    byteBufferChannel5 = byteBufferChannel3;
                                                    j3 = j10;
                                                    if (!ringBufferCapacity.isFull()) {
                                                    }
                                                    byteBufferChannel6.flush();
                                                    if (byteBufferChannel6 != byteBufferChannel5) {
                                                    }
                                                    byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                    byteBufferChannel6.tryTerminate$ktor_io();
                                                    throw th;
                                                }
                                                byteBufferChannel15 = byteBufferChannel13;
                                                joiningState7 = joiningState2;
                                                j10 = j9;
                                            } else {
                                                z = z2;
                                                ByteBufferChannel byteBufferChannel21 = byteBufferChannel13;
                                                long j14 = j9;
                                                ByteBufferChannel byteBufferChannel22 = byteBufferChannel18;
                                                obj = obj2;
                                                j4 = j8;
                                                ringBufferCapacity3 = ringBufferCapacity5;
                                                byteBufferChannel4 = byteBufferChannel21;
                                                byteBufferChannel9 = byteBufferChannel3;
                                                ringBufferCapacity2 = ringBufferCapacity6;
                                                j3 = j14;
                                                byteBufferChannel10 = byteBufferChannel12;
                                                byteBufferChannel8 = byteBufferChannel22;
                                                joiningState5 = joiningState2;
                                                byteBufferChannel10.prepareBuffer(byteBuffer, byteBufferChannel10.writePosition, i2);
                                                intRef = new Ref.IntRef();
                                                int i32 = i2;
                                                byteBuffer2 = byteBufferChannel8.setupStateForRead();
                                                if (byteBuffer2 != null) {
                                                }
                                                byteBufferChannel11 = byteBufferChannel6;
                                                j7 = j3;
                                                byteBufferChannel7 = byteBufferChannel4;
                                                ringBufferCapacity4 = ringBufferCapacity2;
                                                if (intRef.element > 0) {
                                                }
                                            }
                                        } else {
                                            z = z2;
                                            ByteBufferChannel byteBufferChannel23 = byteBufferChannel13;
                                            long j15 = j9;
                                            ByteBufferChannel byteBufferChannel24 = byteBufferChannel18;
                                            obj = obj2;
                                            byteBufferChannel8 = byteBufferChannel24;
                                            byteBufferChannel7 = byteBufferChannel23;
                                            j4 = j8;
                                            j5 = j15;
                                            joiningState3 = joiningState2;
                                            try {
                                                if (!ringBufferCapacity6.isFull() || byteBufferChannel6.getAutoFlush()) {
                                                    byteBufferChannel6.flush();
                                                }
                                                if (byteBufferChannel6 != byteBufferChannel3) {
                                                    byteBufferChannel3.setTotalBytesWritten$ktor_io(byteBufferChannel3.get_totalBytesWritten() + (byteBufferChannel6.get_totalBytesWritten() - j5));
                                                }
                                                byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                                byteBufferChannel6.tryTerminate$ktor_io();
                                                joiningState4 = joiningState3;
                                                longRef = longRef2;
                                                j6 = j4;
                                                byteBufferChannel3 = byteBufferChannel7;
                                                if (joiningState4 != null) {
                                                }
                                                if (longRef.element < j6) {
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                byteBufferChannel2 = byteBufferChannel7;
                                                byteBufferChannel2.close(th);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        byteBufferChannel15 = byteBufferChannel13;
                                        j10 = j9;
                                    }
                                    obj2 = coroutine_suspended;
                                    z2 = z;
                                    ringBufferCapacity5 = ringBufferCapacity6;
                                    j9 = j13;
                                    j8 = j2;
                                    byteBufferChannel12 = byteBufferChannel17;
                                    byteBufferChannel13 = byteBufferChannel3;
                                    longRef2 = longRef;
                                    byteBufferChannel6 = byteBufferChannel12;
                                } catch (Throwable th13) {
                                    th = th13;
                                    byteBufferChannel6 = byteBufferChannel17;
                                    ringBufferCapacity = ringBufferCapacity6;
                                    j3 = j13;
                                    byteBufferChannel5 = byteBufferChannel3;
                                    if (!ringBufferCapacity.isFull()) {
                                    }
                                    byteBufferChannel6.flush();
                                    if (byteBufferChannel6 != byteBufferChannel5) {
                                    }
                                    byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                                    byteBufferChannel6.tryTerminate$ktor_io();
                                    throw th;
                                }
                            }
                        }
                        if (z) {
                            byteBufferChannel3.flush();
                        }
                        return Boxing.boxLong(longRef.element);
                    }
                    j3 = byteBufferChannel$copyDirect$1.J$1;
                    boolean z5 = byteBufferChannel$copyDirect$1.Z$0;
                    long j16 = byteBufferChannel$copyDirect$1.J$0;
                    ByteBufferChannel byteBufferChannel25 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$9;
                    ByteBuffer byteBuffer3 = (ByteBuffer) byteBufferChannel$copyDirect$1.L$8;
                    ringBufferCapacity5 = (RingBufferCapacity) byteBufferChannel$copyDirect$1.L$7;
                    ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$copyDirect$1.L$6;
                    byteBufferChannel6 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$5;
                    byteBufferChannel5 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$4;
                    longRef2 = (Ref.LongRef) byteBufferChannel$copyDirect$1.L$3;
                    JoiningState joiningState12 = (JoiningState) byteBufferChannel$copyDirect$1.L$2;
                    ByteBufferChannel byteBufferChannel26 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$1;
                    ByteBufferChannel byteBufferChannel27 = (ByteBufferChannel) byteBufferChannel$copyDirect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        byteBufferChannel4 = byteBufferChannel27;
                        j4 = j16;
                        byteBufferChannel10 = byteBufferChannel25;
                        byteBufferChannel3 = byteBufferChannel5;
                        joiningState6 = joiningState12;
                        byteBuffer = byteBuffer3;
                        z = z5;
                        byteBufferChannel14 = byteBufferChannel26;
                        if (byteBufferChannel10.joining != null) {
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        if (!ringBufferCapacity.isFull()) {
                        }
                        byteBufferChannel6.flush();
                        if (byteBufferChannel6 != byteBufferChannel5) {
                        }
                        byteBufferChannel6.restoreStateAfterWrite$ktor_io();
                        byteBufferChannel6.tryTerminate$ktor_io();
                        throw th;
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th15) {
            th = th15;
        }
        byteBufferChannel$copyDirect$1 = new ByteBufferChannel$copyDirect$1(this, continuation);
        Object obj32 = byteBufferChannel$copyDirect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$copyDirect$1.label;
    }

    private final void ensureClosedJoined(JoiningState joined) {
        ClosedElement closed = getClosed();
        if (closed == null) {
            return;
        }
        this.joining = null;
        if (!joined.getDelegateClose()) {
            joined.getDelegatedTo().flush();
            joined.complete();
            return;
        }
        ReadWriteBufferState state = joined.getDelegatedTo().getState();
        boolean z = (state instanceof ReadWriteBufferState.Writing) || (state instanceof ReadWriteBufferState.ReadingWriting);
        if (closed.getCause() != null || !z) {
            joined.getDelegatedTo().close(closed.getCause());
        } else {
            joined.getDelegatedTo().flush();
        }
        joined.complete();
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteBufferChannel resolveDelegation;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
            Object writeFully = resolveDelegation.writeFully(bArr, i, i2, continuation);
            return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
        }
        while (i2 > 0) {
            int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
            if (writeAsMuchAsPossible == 0) {
                break;
            }
            i += writeAsMuchAsPossible;
            i2 -= writeAsMuchAsPossible;
        }
        if (i2 == 0) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = byteBufferChannel.writeFullySuspend(bArr, i, i2, continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:10:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeFullySuspend(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeFullySuspend$5 byteBufferChannel$writeFullySuspend$5;
        int i3;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$writeFullySuspend$5) {
            byteBufferChannel$writeFullySuspend$5 = (ByteBufferChannel$writeFullySuspend$5) continuation;
            if ((byteBufferChannel$writeFullySuspend$5.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeFullySuspend$5.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeFullySuspend$5.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteBufferChannel$writeFullySuspend$5.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (i2 > 0) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = byteBufferChannel$writeFullySuspend$5.I$1;
                    i = byteBufferChannel$writeFullySuspend$5.I$0;
                    byte[] bArr2 = (byte[]) byteBufferChannel$writeFullySuspend$5.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeFullySuspend$5.L$0;
                    ResultKt.throwOnFailure(obj);
                    int intValue = ((Number) obj).intValue();
                    i += intValue;
                    byte[] bArr3 = bArr2;
                    i2 = i4 - intValue;
                    bArr = bArr3;
                    if (i2 > 0) {
                        byteBufferChannel$writeFullySuspend$5.L$0 = byteBufferChannel;
                        byteBufferChannel$writeFullySuspend$5.L$1 = bArr;
                        byteBufferChannel$writeFullySuspend$5.I$0 = i;
                        byteBufferChannel$writeFullySuspend$5.I$1 = i2;
                        byteBufferChannel$writeFullySuspend$5.label = 1;
                        obj = byteBufferChannel.writeAvailable(bArr, i, i2, byteBufferChannel$writeFullySuspend$5);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i5 = i2;
                        bArr2 = bArr;
                        i4 = i5;
                        int intValue2 = ((Number) obj).intValue();
                        i += intValue2;
                        byte[] bArr32 = bArr2;
                        i2 = i4 - intValue2;
                        bArr = bArr32;
                        if (i2 > 0) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        byteBufferChannel$writeFullySuspend$5 = new ByteBufferChannel$writeFullySuspend$5(this, continuation);
        Object obj2 = byteBufferChannel$writeFullySuspend$5.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteBufferChannel$writeFullySuspend$5.label;
        if (i3 != 0) {
        }
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        ByteBufferChannel resolveDelegation;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
            return resolveDelegation.writeAvailable(bArr, i, i2, continuation);
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        return byteBufferChannel.writeSuspend(bArr, i, i2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        if (r2.tryWriteSuspend$ktor_io(1, r0) != r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x005a -> B:16:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeSuspend(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        ByteBufferChannel$writeSuspend$1 byteBufferChannel$writeSuspend$1;
        int i3;
        ByteBufferChannel byteBufferChannel;
        ByteBufferChannel resolveDelegation;
        if (continuation instanceof ByteBufferChannel$writeSuspend$1) {
            byteBufferChannel$writeSuspend$1 = (ByteBufferChannel$writeSuspend$1) continuation;
            if ((byteBufferChannel$writeSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = byteBufferChannel$writeSuspend$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    byteBufferChannel$writeSuspend$1.L$0 = byteBufferChannel;
                    byteBufferChannel$writeSuspend$1.L$1 = bArr;
                    byteBufferChannel$writeSuspend$1.I$0 = i;
                    byteBufferChannel$writeSuspend$1.I$1 = i2;
                    byteBufferChannel$writeSuspend$1.label = 1;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    int i4 = byteBufferChannel$writeSuspend$1.I$1;
                    i = byteBufferChannel$writeSuspend$1.I$0;
                    byte[] bArr2 = (byte[]) byteBufferChannel$writeSuspend$1.L$1;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i4;
                    bArr = bArr2;
                    JoiningState joiningState = byteBufferChannel.joining;
                    if (joiningState != null && (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
                        byteBufferChannel$writeSuspend$1.L$0 = null;
                        byteBufferChannel$writeSuspend$1.L$1 = null;
                        byteBufferChannel$writeSuspend$1.label = 2;
                        Object writeSuspend = resolveDelegation.writeSuspend(bArr, i, i2, byteBufferChannel$writeSuspend$1);
                        return writeSuspend == coroutine_suspended ? coroutine_suspended : writeSuspend;
                    }
                    int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
                    if (writeAsMuchAsPossible > 0) {
                        return Boxing.boxInt(writeAsMuchAsPossible);
                    }
                    byteBufferChannel$writeSuspend$1.L$0 = byteBufferChannel;
                    byteBufferChannel$writeSuspend$1.L$1 = bArr;
                    byteBufferChannel$writeSuspend$1.I$0 = i;
                    byteBufferChannel$writeSuspend$1.I$1 = i2;
                    byteBufferChannel$writeSuspend$1.label = 1;
                }
            }
        }
        byteBufferChannel$writeSuspend$1 = new ByteBufferChannel$writeSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$writeSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = byteBufferChannel$writeSuspend$1.label;
        if (i3 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object write$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteBufferChannel$write$1 byteBufferChannel$write$1;
        int i2;
        if (continuation instanceof ByteBufferChannel$write$1) {
            byteBufferChannel$write$1 = (ByteBufferChannel$write$1) continuation;
            if ((byteBufferChannel$write$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$write$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$write$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$write$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i <= 0) {
                        throw new IllegalArgumentException("min should be positive".toString());
                    }
                    if (i > 4088) {
                        throw new IllegalArgumentException(("Min(" + i + ") should'nt be greater than (4088)").toString());
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = byteBufferChannel$write$1.I$0;
                    Function1<? super ByteBuffer, Unit> function12 = (Function1) byteBufferChannel$write$1.L$1;
                    ByteBufferChannel byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$write$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    byteBufferChannel = byteBufferChannel2;
                    function1 = function12;
                }
                while (byteBufferChannel.writeAvailable(i, function1) < 0) {
                    byteBufferChannel$write$1.L$0 = byteBufferChannel;
                    byteBufferChannel$write$1.L$1 = function1;
                    byteBufferChannel$write$1.I$0 = i;
                    byteBufferChannel$write$1.label = 1;
                    if (byteBufferChannel.awaitFreeSpaceOrDelegate(i, function1, byteBufferChannel$write$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        byteBufferChannel$write$1 = new ByteBufferChannel$write$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$write$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$write$1.label;
        if (i2 != 0) {
        }
        while (byteBufferChannel.writeAvailable(i, function1) < 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        if (r8.write(r6, r7, r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitFreeSpaceOrDelegate(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteBufferChannel$awaitFreeSpaceOrDelegate$1 byteBufferChannel$awaitFreeSpaceOrDelegate$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState;
        if (continuation instanceof ByteBufferChannel$awaitFreeSpaceOrDelegate$1) {
            byteBufferChannel$awaitFreeSpaceOrDelegate$1 = (ByteBufferChannel$awaitFreeSpaceOrDelegate$1) continuation;
            if ((byteBufferChannel$awaitFreeSpaceOrDelegate$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$awaitFreeSpaceOrDelegate$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$awaitFreeSpaceOrDelegate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$awaitFreeSpaceOrDelegate$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$0 = this;
                    byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$1 = function1;
                    byteBufferChannel$awaitFreeSpaceOrDelegate$1.I$0 = i;
                    byteBufferChannel$awaitFreeSpaceOrDelegate$1.label = 1;
                    if (writeSuspend(i, byteBufferChannel$awaitFreeSpaceOrDelegate$1) != coroutine_suspended) {
                        byteBufferChannel = this;
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
                i = byteBufferChannel$awaitFreeSpaceOrDelegate$1.I$0;
                function1 = (Function1) byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$0;
                ResultKt.throwOnFailure(obj);
                joiningState = byteBufferChannel.joining;
                if (joiningState != null || (r8 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                    return Unit.INSTANCE;
                }
                byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$0 = null;
                byteBufferChannel$awaitFreeSpaceOrDelegate$1.L$1 = null;
                byteBufferChannel$awaitFreeSpaceOrDelegate$1.label = 2;
            }
        }
        byteBufferChannel$awaitFreeSpaceOrDelegate$1 = new ByteBufferChannel$awaitFreeSpaceOrDelegate$1(this, continuation);
        Object obj2 = byteBufferChannel$awaitFreeSpaceOrDelegate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$awaitFreeSpaceOrDelegate$1.label;
        if (i2 != 0) {
        }
        joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object writeWhile$suspendImpl(ByteBufferChannel byteBufferChannel, Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        if (!byteBufferChannel.writeWhileNoSuspend(function1)) {
            return Unit.INSTANCE;
        }
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed != null) {
            ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        }
        Object writeWhileSuspend = byteBufferChannel.writeWhileSuspend(function1, continuation);
        return writeWhileSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeWhileSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d7, code lost:
    
        if (r4.getClosed() != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0128, code lost:
    
        if (r5.writeWhile(r0, r2) == r3) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:18:0x0060, B:20:0x00c5, B:22:0x00c9, B:24:0x00cf, B:26:0x00d3, B:28:0x00a8), top: B:17:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c2 -> B:20:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeWhileSuspend(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeWhileSuspend$1 byteBufferChannel$writeWhileSuspend$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        RingBufferCapacity ringBufferCapacity;
        long j;
        ByteBufferChannel byteBufferChannel2;
        Ref.BooleanRef booleanRef;
        ByteBufferChannel byteBufferChannel3;
        ByteBuffer byteBuffer;
        RingBufferCapacity ringBufferCapacity2;
        ByteBufferChannel byteBufferChannel4;
        Function1<? super ByteBuffer, Boolean> function12;
        ByteBufferChannel resolveDelegation;
        if (continuation instanceof ByteBufferChannel$writeWhileSuspend$1) {
            byteBufferChannel$writeWhileSuspend$1 = (ByteBufferChannel$writeWhileSuspend$1) continuation;
            if ((byteBufferChannel$writeWhileSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeWhileSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeWhileSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$writeWhileSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = true;
                    JoiningState joiningState = this.joining;
                    byteBufferChannel = (joiningState == null || (resolveDelegation = resolveDelegation(this, joiningState)) == null) ? this : resolveDelegation;
                    ByteBuffer byteBuffer2 = byteBufferChannel.setupStateForWrite$ktor_io();
                    if (byteBuffer2 == null) {
                        booleanRef = booleanRef2;
                        byteBufferChannel3 = this;
                        function12 = function1;
                        if (!booleanRef.element) {
                        }
                    } else {
                        ringBufferCapacity = byteBufferChannel.getState().capacity;
                        j = byteBufferChannel.get_totalBytesWritten();
                        try {
                            ClosedElement closed = byteBufferChannel.getClosed();
                            if (closed != null) {
                                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                                throw new KotlinNothingValueException();
                            }
                            ByteBufferChannel byteBufferChannel5 = byteBufferChannel;
                            booleanRef = booleanRef2;
                            byteBufferChannel3 = this;
                            byteBufferChannel2 = byteBufferChannel3;
                            byteBuffer = byteBuffer2;
                            ringBufferCapacity2 = ringBufferCapacity;
                            byteBufferChannel4 = byteBufferChannel;
                            function12 = function1;
                            byteBufferChannel$writeWhileSuspend$1.L$0 = byteBufferChannel3;
                            byteBufferChannel$writeWhileSuspend$1.L$1 = function12;
                            byteBufferChannel$writeWhileSuspend$1.L$2 = booleanRef;
                            byteBufferChannel$writeWhileSuspend$1.L$3 = byteBufferChannel2;
                            byteBufferChannel$writeWhileSuspend$1.L$4 = byteBufferChannel;
                            byteBufferChannel$writeWhileSuspend$1.L$5 = ringBufferCapacity;
                            byteBufferChannel$writeWhileSuspend$1.L$6 = ringBufferCapacity2;
                            byteBufferChannel$writeWhileSuspend$1.L$7 = byteBuffer;
                            byteBufferChannel$writeWhileSuspend$1.L$8 = byteBufferChannel4;
                            byteBufferChannel$writeWhileSuspend$1.J$0 = j;
                            byteBufferChannel$writeWhileSuspend$1.label = 1;
                            if (byteBufferChannel4.writeSuspend(1, byteBufferChannel$writeWhileSuspend$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (byteBufferChannel4.joining == null) {
                            }
                            if (!ringBufferCapacity.isFull()) {
                            }
                            byteBufferChannel.flush();
                            if (byteBufferChannel != byteBufferChannel2) {
                            }
                            byteBufferChannel.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel.tryTerminate$ktor_io();
                            if (!booleanRef.element) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            byteBufferChannel2 = this;
                            if (!ringBufferCapacity.isFull()) {
                            }
                            byteBufferChannel.flush();
                            if (byteBufferChannel != byteBufferChannel2) {
                            }
                            byteBufferChannel.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel.tryTerminate$ktor_io();
                            throw th;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    j = byteBufferChannel$writeWhileSuspend$1.J$0;
                    byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$writeWhileSuspend$1.L$8;
                    byteBuffer = (ByteBuffer) byteBufferChannel$writeWhileSuspend$1.L$7;
                    ringBufferCapacity2 = (RingBufferCapacity) byteBufferChannel$writeWhileSuspend$1.L$6;
                    ringBufferCapacity = (RingBufferCapacity) byteBufferChannel$writeWhileSuspend$1.L$5;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeWhileSuspend$1.L$4;
                    byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$writeWhileSuspend$1.L$3;
                    booleanRef = (Ref.BooleanRef) byteBufferChannel$writeWhileSuspend$1.L$2;
                    Function1<? super ByteBuffer, Boolean> function13 = (Function1) byteBufferChannel$writeWhileSuspend$1.L$1;
                    byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$writeWhileSuspend$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        function12 = function13;
                        if (byteBufferChannel4.joining == null) {
                            if (!byteBufferChannel4.writeWhileLoop(byteBuffer, ringBufferCapacity2, function12)) {
                                booleanRef.element = false;
                            }
                        }
                        if (!ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != byteBufferChannel2) {
                            byteBufferChannel2.setTotalBytesWritten$ktor_io(byteBufferChannel2.get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
                        }
                        byteBufferChannel.restoreStateAfterWrite$ktor_io();
                        byteBufferChannel.tryTerminate$ktor_io();
                        if (!booleanRef.element) {
                            return Unit.INSTANCE;
                        }
                        ClosedElement closed2 = byteBufferChannel3.getClosed();
                        if (closed2 != null) {
                            ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                            throw new KotlinNothingValueException();
                        }
                        if (byteBufferChannel3.joining == null) {
                            return Unit.INSTANCE;
                        }
                        byteBufferChannel$writeWhileSuspend$1.L$0 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$1 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$2 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$3 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$4 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$5 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$6 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$7 = null;
                        byteBufferChannel$writeWhileSuspend$1.L$8 = null;
                        byteBufferChannel$writeWhileSuspend$1.label = 2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != byteBufferChannel2) {
                            byteBufferChannel2.setTotalBytesWritten$ktor_io(byteBufferChannel2.get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
                        }
                        byteBufferChannel.restoreStateAfterWrite$ktor_io();
                        byteBufferChannel.tryTerminate$ktor_io();
                        throw th;
                    }
                }
            }
        }
        byteBufferChannel$writeWhileSuspend$1 = new ByteBufferChannel$writeWhileSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$writeWhileSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeWhileSuspend$1.label;
        if (i != 0) {
        }
    }

    private final boolean writeWhileLoop(ByteBuffer dst, RingBufferCapacity capacity, Function1<? super ByteBuffer, Boolean> block) {
        int capacity2 = dst.capacity() - this.reservedSize;
        boolean z = true;
        while (z) {
            int tryWriteAtLeast = capacity.tryWriteAtLeast(1);
            if (tryWriteAtLeast == 0) {
                break;
            }
            int i = this.writePosition;
            int coerceAtMost = RangesKt.coerceAtMost(i + tryWriteAtLeast, capacity2);
            dst.limit(coerceAtMost);
            dst.position(i);
            try {
                boolean booleanValue = block.invoke(dst).booleanValue();
                if (dst.limit() != coerceAtMost) {
                    throw new IllegalStateException("Buffer limit modified.".toString());
                }
                int position = dst.position() - i;
                if (position < 0) {
                    throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                }
                bytesWritten(dst, capacity, position);
                if (position < tryWriteAtLeast) {
                    capacity.completeRead(tryWriteAtLeast - position);
                }
                z = booleanValue;
            } catch (Throwable th) {
                capacity.completeRead(tryWriteAtLeast);
                throw th;
            }
        }
        return z;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this.readSession;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public void endReadSession() {
        this.readSession.completed();
        ReadWriteBufferState state = getState();
        if ((state instanceof ReadWriteBufferState.Reading) || (state instanceof ReadWriteBufferState.ReadingWriting)) {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        WriteSessionImpl writeSessionImpl = this.writeSession;
        writeSessionImpl.begin();
        return writeSessionImpl;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public void endWriteSession(int written) {
        this.writeSession.written(written);
        this.writeSession.complete();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public void readSession(final Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$readSession$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                ReadSessionImpl readSessionImpl;
                ReadSessionImpl readSessionImpl2;
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                try {
                    Function1<ReadSession, Unit> function1 = consumer;
                    readSessionImpl2 = this.readSession;
                    function1.invoke(readSessionImpl2);
                } finally {
                    readSessionImpl = this.readSession;
                    readSessionImpl.completed();
                }
            }
        });
    }

    @Deprecated(message = "Use read { } instead.")
    static /* synthetic */ Object readSuspendableSession$suspendImpl(ByteBufferChannel byteBufferChannel, Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object lookAheadSuspend = byteBufferChannel.lookAheadSuspend(new ByteBufferChannel$readSuspendableSession$2(function2, byteBufferChannel, null), continuation);
        return lookAheadSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? lookAheadSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0081, code lost:
    
        if (((java.lang.Boolean) r14).booleanValue() != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0078 -> B:10:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object discardSuspend(long j, long j2, Continuation<? super Long> continuation) {
        ByteBufferChannel$discardSuspend$1 byteBufferChannel$discardSuspend$1;
        int i;
        long j3;
        Ref.LongRef longRef;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$discardSuspend$1) {
            byteBufferChannel$discardSuspend$1 = (ByteBufferChannel$discardSuspend$1) continuation;
            if ((byteBufferChannel$discardSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$discardSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$discardSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$discardSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = j;
                    j3 = j2;
                    longRef = longRef2;
                    byteBufferChannel = this;
                    while (longRef.element < j3) {
                        ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
                        if (byteBuffer != null) {
                            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                            try {
                                if (ringBufferCapacity._availableForRead$internal != 0) {
                                    int tryReadAtMost = ringBufferCapacity.tryReadAtMost((int) Math.min(2147483647L, j3 - longRef.element));
                                    byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                                    longRef.element += tryReadAtMost;
                                }
                            } finally {
                                byteBufferChannel.restoreStateAfterRead();
                                byteBufferChannel.tryTerminate$ktor_io();
                            }
                        }
                        if (!byteBufferChannel.isClosedForRead()) {
                            byteBufferChannel$discardSuspend$1.L$0 = byteBufferChannel;
                            byteBufferChannel$discardSuspend$1.L$1 = longRef;
                            byteBufferChannel$discardSuspend$1.J$0 = j3;
                            byteBufferChannel$discardSuspend$1.label = 1;
                            obj = byteBufferChannel.readSuspend(1, byteBufferChannel$discardSuspend$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Boxing.boxLong(longRef.element);
                    }
                    return Boxing.boxLong(longRef.element);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = byteBufferChannel$discardSuspend$1.J$0;
                longRef = (Ref.LongRef) byteBufferChannel$discardSuspend$1.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$discardSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
        }
        byteBufferChannel$discardSuspend$1 = new ByteBufferChannel$discardSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$discardSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$discardSuspend$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
    
        if (r2.read(r6, r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readBlockSuspend(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteBufferChannel$readBlockSuspend$1 byteBufferChannel$readBlockSuspend$1;
        Object obj;
        int i2;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readBlockSuspend$1) {
            byteBufferChannel$readBlockSuspend$1 = (ByteBufferChannel$readBlockSuspend$1) continuation;
            if ((byteBufferChannel$readBlockSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readBlockSuspend$1.label -= Integer.MIN_VALUE;
                obj = byteBufferChannel$readBlockSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readBlockSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int coerceAtLeast = RangesKt.coerceAtLeast(i, 1);
                    byteBufferChannel$readBlockSuspend$1.L$0 = this;
                    byteBufferChannel$readBlockSuspend$1.L$1 = function1;
                    byteBufferChannel$readBlockSuspend$1.I$0 = i;
                    byteBufferChannel$readBlockSuspend$1.label = 1;
                    obj = readSuspend(coerceAtLeast, byteBufferChannel$readBlockSuspend$1);
                    if (obj != coroutine_suspended) {
                        byteBufferChannel = this;
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
                i = byteBufferChannel$readBlockSuspend$1.I$0;
                function1 = (Function1) byteBufferChannel$readBlockSuspend$1.L$1;
                byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readBlockSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    if (i > 0) {
                        throw new EOFException("Got EOF but at least " + i + " bytes were expected");
                    }
                    return Unit.INSTANCE;
                }
                byteBufferChannel$readBlockSuspend$1.L$0 = null;
                byteBufferChannel$readBlockSuspend$1.L$1 = null;
                byteBufferChannel$readBlockSuspend$1.label = 2;
            }
        }
        byteBufferChannel$readBlockSuspend$1 = new ByteBufferChannel$readBlockSuspend$1(this, continuation);
        obj = byteBufferChannel$readBlockSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readBlockSuspend$1.label;
        if (i2 != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    static /* synthetic */ Object writePacket$suspendImpl(ByteBufferChannel byteBufferChannel, ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        ByteBufferChannel resolveDelegation;
        ByteBufferChannel resolveDelegation2;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) != null) {
            Object writePacket = resolveDelegation2.writePacket(byteReadPacket, continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        }
        do {
            try {
                if (byteReadPacket.getEndOfInput()) {
                    break;
                }
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        } while (byteBufferChannel.tryWritePacketPart(byteReadPacket) != 0);
        if (byteReadPacket.getRemaining() > 0) {
            JoiningState joiningState2 = byteBufferChannel.joining;
            if (joiningState2 == null || (resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2)) == null) {
                Object writePacketSuspend = byteBufferChannel.writePacketSuspend(byteReadPacket, continuation);
                return writePacketSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacketSuspend : Unit.INSTANCE;
            }
            Object writePacket2 = resolveDelegation.writePacket(byteReadPacket, continuation);
            return writePacket2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket2 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        if (r7.writePacket(r6, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:12:0x002d, B:13:0x0076, B:21:0x0041, B:22:0x005e, B:24:0x0062, B:26:0x0068, B:29:0x007c, B:30:0x004b, B:32:0x0051), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x005b -> B:22:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writePacketSuspend(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writePacketSuspend$1 byteBufferChannel$writePacketSuspend$1;
        int i;
        ByteBufferChannel byteBufferChannel;
        try {
            if (continuation instanceof ByteBufferChannel$writePacketSuspend$1) {
                byteBufferChannel$writePacketSuspend$1 = (ByteBufferChannel$writePacketSuspend$1) continuation;
                if ((byteBufferChannel$writePacketSuspend$1.label & Integer.MIN_VALUE) != 0) {
                    byteBufferChannel$writePacketSuspend$1.label -= Integer.MIN_VALUE;
                    Object obj = byteBufferChannel$writePacketSuspend$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteBufferChannel$writePacketSuspend$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        byteBufferChannel = this;
                        if (!byteReadPacket.getEndOfInput()) {
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            byteReadPacket = (ByteReadPacket) byteBufferChannel$writePacketSuspend$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        byteReadPacket = (ByteReadPacket) byteBufferChannel$writePacketSuspend$1.L$1;
                        byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writePacketSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        JoiningState joiningState = byteBufferChannel.joining;
                        if (joiningState != null || (r7 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState)) == null) {
                            byteBufferChannel.tryWritePacketPart(byteReadPacket);
                            if (!byteReadPacket.getEndOfInput()) {
                                byteBufferChannel$writePacketSuspend$1.L$0 = byteBufferChannel;
                                byteBufferChannel$writePacketSuspend$1.L$1 = byteReadPacket;
                                byteBufferChannel$writePacketSuspend$1.label = 1;
                                if (byteBufferChannel.writeSuspend(1, byteBufferChannel$writePacketSuspend$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                JoiningState joiningState2 = byteBufferChannel.joining;
                                if (joiningState2 != null) {
                                }
                                byteBufferChannel.tryWritePacketPart(byteReadPacket);
                                if (!byteReadPacket.getEndOfInput()) {
                                    byteReadPacket.release();
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            byteBufferChannel$writePacketSuspend$1.L$0 = byteReadPacket;
                            byteBufferChannel$writePacketSuspend$1.L$1 = null;
                            byteBufferChannel$writePacketSuspend$1.label = 2;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } finally {
            byteReadPacket.release();
        }
        byteBufferChannel$writePacketSuspend$1 = new ByteBufferChannel$writePacketSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$writePacketSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writePacketSuspend$1.label;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            return visitor.invoke(new FailedLookAhead(closedCause));
        }
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            return visitor.invoke(TerminatedLookAhead.INSTANCE);
        }
        boolean z = false;
        R r = null;
        if (setupStateForRead() != null) {
            try {
                if (getState().capacity._availableForRead$internal != 0) {
                    r = visitor.invoke(this);
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                    z = true;
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        if (!z) {
            Throwable closedCause2 = getClosedCause();
            return closedCause2 != null ? visitor.invoke(new FailedLookAhead(closedCause2)) : visitor.invoke(TerminatedLookAhead.INSTANCE);
        }
        Intrinsics.checkNotNull(r);
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Deprecated(message = "Use read { } instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <R> Object lookAheadSuspend$suspendImpl(ByteBufferChannel byteBufferChannel, Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ByteBufferChannel$lookAheadSuspend$1 byteBufferChannel$lookAheadSuspend$1;
        Ref.ObjectRef objectRef;
        ByteBufferChannel byteBufferChannel2;
        Throwable th;
        ByteBufferChannel byteBufferChannel3;
        Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function22;
        Ref.ObjectRef objectRef2;
        T t;
        Ref.ObjectRef objectRef3;
        ByteBufferChannel byteBufferChannel4;
        Throwable th2;
        Ref.ObjectRef objectRef4;
        T t2;
        Ref.ObjectRef objectRef5;
        ReadWriteBufferState state;
        ReadWriteBufferState state2;
        if (continuation instanceof ByteBufferChannel$lookAheadSuspend$1) {
            byteBufferChannel$lookAheadSuspend$1 = (ByteBufferChannel$lookAheadSuspend$1) continuation;
            if ((byteBufferChannel$lookAheadSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$lookAheadSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$lookAheadSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (byteBufferChannel$lookAheadSuspend$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Throwable closedCause = byteBufferChannel.getClosedCause();
                        if (closedCause != null) {
                            FailedLookAhead failedLookAhead = new FailedLookAhead(closedCause);
                            byteBufferChannel$lookAheadSuspend$1.label = 1;
                            Object invoke = function2.invoke(failedLookAhead, byteBufferChannel$lookAheadSuspend$1);
                            if (invoke != coroutine_suspended) {
                                return invoke;
                            }
                        } else if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                            TerminatedLookAhead terminatedLookAhead = TerminatedLookAhead.INSTANCE;
                            byteBufferChannel$lookAheadSuspend$1.label = 2;
                            Object invoke2 = function2.invoke(terminatedLookAhead, byteBufferChannel$lookAheadSuspend$1);
                            if (invoke2 != coroutine_suspended) {
                                return invoke2;
                            }
                        } else {
                            objectRef = new Ref.ObjectRef();
                            if (byteBufferChannel.setupStateForRead() != null) {
                                try {
                                    if (byteBufferChannel.getState().capacity._availableForRead$internal != 0) {
                                        byteBufferChannel$lookAheadSuspend$1.L$0 = byteBufferChannel;
                                        byteBufferChannel$lookAheadSuspend$1.L$1 = function2;
                                        byteBufferChannel$lookAheadSuspend$1.L$2 = objectRef;
                                        byteBufferChannel$lookAheadSuspend$1.L$3 = byteBufferChannel;
                                        byteBufferChannel$lookAheadSuspend$1.L$4 = objectRef;
                                        byteBufferChannel$lookAheadSuspend$1.label = 3;
                                        Object invoke3 = function2.invoke(byteBufferChannel, byteBufferChannel$lookAheadSuspend$1);
                                        if (invoke3 != coroutine_suspended) {
                                            byteBufferChannel3 = byteBufferChannel;
                                            function22 = function2;
                                            byteBufferChannel2 = byteBufferChannel3;
                                            objectRef2 = objectRef;
                                            t = invoke3;
                                            objectRef3 = objectRef2;
                                            objectRef2.element = t;
                                            byteBufferChannel2.restoreStateAfterRead();
                                            byteBufferChannel2.tryTerminate$ktor_io();
                                            objectRef = objectRef3;
                                            function2 = function22;
                                            byteBufferChannel = byteBufferChannel3;
                                            if (!z) {
                                                Throwable closedCause2 = byteBufferChannel.getClosedCause();
                                                if (closedCause2 != null) {
                                                    FailedLookAhead failedLookAhead2 = new FailedLookAhead(closedCause2);
                                                    byteBufferChannel$lookAheadSuspend$1.L$0 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$1 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$2 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$3 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$4 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.label = 4;
                                                    Object invoke4 = function2.invoke(failedLookAhead2, byteBufferChannel$lookAheadSuspend$1);
                                                    if (invoke4 != coroutine_suspended) {
                                                        return invoke4;
                                                    }
                                                } else if (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                                                    TerminatedLookAhead terminatedLookAhead2 = TerminatedLookAhead.INSTANCE;
                                                    byteBufferChannel$lookAheadSuspend$1.L$0 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$1 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$2 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$3 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.L$4 = null;
                                                    byteBufferChannel$lookAheadSuspend$1.label = 5;
                                                    Object invoke5 = function2.invoke(terminatedLookAhead2, byteBufferChannel$lookAheadSuspend$1);
                                                    if (invoke5 != coroutine_suspended) {
                                                        return invoke5;
                                                    }
                                                } else {
                                                    try {
                                                        byteBufferChannel$lookAheadSuspend$1.L$0 = byteBufferChannel;
                                                        byteBufferChannel$lookAheadSuspend$1.L$1 = objectRef;
                                                        byteBufferChannel$lookAheadSuspend$1.L$2 = objectRef;
                                                        byteBufferChannel$lookAheadSuspend$1.L$3 = null;
                                                        byteBufferChannel$lookAheadSuspend$1.L$4 = null;
                                                        byteBufferChannel$lookAheadSuspend$1.label = 6;
                                                        Object invoke6 = function2.invoke(byteBufferChannel, byteBufferChannel$lookAheadSuspend$1);
                                                        if (invoke6 != coroutine_suspended) {
                                                            byteBufferChannel4 = byteBufferChannel;
                                                            objectRef4 = objectRef;
                                                            t2 = invoke6;
                                                            objectRef5 = objectRef4;
                                                            objectRef4.element = t2;
                                                            state2 = byteBufferChannel4.getState();
                                                            if (!state2.getIdle() && state2 != ReadWriteBufferState.Terminated.INSTANCE) {
                                                                if (!(state2 instanceof ReadWriteBufferState.Reading) || (state2 instanceof ReadWriteBufferState.ReadingWriting)) {
                                                                    byteBufferChannel4.restoreStateAfterRead();
                                                                }
                                                                byteBufferChannel4.tryTerminate$ktor_io();
                                                            }
                                                            objectRef = objectRef5;
                                                        }
                                                    } catch (Throwable th3) {
                                                        byteBufferChannel4 = byteBufferChannel;
                                                        th2 = th3;
                                                        state = byteBufferChannel4.getState();
                                                        if (!state.getIdle() && state != ReadWriteBufferState.Terminated.INSTANCE) {
                                                            if (!(state instanceof ReadWriteBufferState.Reading) || (state instanceof ReadWriteBufferState.ReadingWriting)) {
                                                                byteBufferChannel4.restoreStateAfterRead();
                                                            }
                                                            byteBufferChannel4.tryTerminate$ktor_io();
                                                        }
                                                        throw th2;
                                                    }
                                                }
                                            }
                                            return objectRef.element;
                                        }
                                    } else {
                                        byteBufferChannel.restoreStateAfterRead();
                                        byteBufferChannel.tryTerminate$ktor_io();
                                    }
                                } catch (Throwable th4) {
                                    byteBufferChannel2 = byteBufferChannel;
                                    th = th4;
                                    byteBufferChannel2.restoreStateAfterRead();
                                    byteBufferChannel2.tryTerminate$ktor_io();
                                    throw th;
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            return objectRef.element;
                        }
                        return coroutine_suspended;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    case 3:
                        objectRef2 = (Ref.ObjectRef) byteBufferChannel$lookAheadSuspend$1.L$4;
                        byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$lookAheadSuspend$1.L$3;
                        objectRef3 = (Ref.ObjectRef) byteBufferChannel$lookAheadSuspend$1.L$2;
                        function22 = (Function2) byteBufferChannel$lookAheadSuspend$1.L$1;
                        byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$lookAheadSuspend$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            t = obj;
                            objectRef2.element = t;
                            byteBufferChannel2.restoreStateAfterRead();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            objectRef = objectRef3;
                            function2 = function22;
                            byteBufferChannel = byteBufferChannel3;
                            if (!z) {
                            }
                            return objectRef.element;
                        } catch (Throwable th5) {
                            th = th5;
                            byteBufferChannel2.restoreStateAfterRead();
                            byteBufferChannel2.tryTerminate$ktor_io();
                            throw th;
                        }
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    case 6:
                        objectRef4 = (Ref.ObjectRef) byteBufferChannel$lookAheadSuspend$1.L$2;
                        objectRef5 = (Ref.ObjectRef) byteBufferChannel$lookAheadSuspend$1.L$1;
                        byteBufferChannel4 = (ByteBufferChannel) byteBufferChannel$lookAheadSuspend$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            t2 = obj;
                            objectRef4.element = t2;
                            state2 = byteBufferChannel4.getState();
                            if (!state2.getIdle()) {
                                if (!(state2 instanceof ReadWriteBufferState.Reading)) {
                                    break;
                                }
                                byteBufferChannel4.restoreStateAfterRead();
                                byteBufferChannel4.tryTerminate$ktor_io();
                                break;
                            }
                            objectRef = objectRef5;
                            return objectRef.element;
                        } catch (Throwable th6) {
                            th2 = th6;
                            state = byteBufferChannel4.getState();
                            if (!state.getIdle()) {
                                if (!(state instanceof ReadWriteBufferState.Reading)) {
                                    break;
                                }
                                byteBufferChannel4.restoreStateAfterRead();
                                byteBufferChannel4.tryTerminate$ktor_io();
                                break;
                            }
                            throw th2;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteBufferChannel$lookAheadSuspend$1 = new ByteBufferChannel$lookAheadSuspend$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$lookAheadSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (byteBufferChannel$lookAheadSuspend$1.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    @Deprecated(message = "Use write { } instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteBufferChannel byteBufferChannel, Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeSuspendSession$1 byteBufferChannel$writeSuspendSession$1;
        int i;
        WriteSessionImpl writeSessionImpl;
        try {
            if (continuation instanceof ByteBufferChannel$writeSuspendSession$1) {
                byteBufferChannel$writeSuspendSession$1 = (ByteBufferChannel$writeSuspendSession$1) continuation;
                if ((byteBufferChannel$writeSuspendSession$1.label & Integer.MIN_VALUE) != 0) {
                    byteBufferChannel$writeSuspendSession$1.label -= Integer.MIN_VALUE;
                    Object obj = byteBufferChannel$writeSuspendSession$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteBufferChannel$writeSuspendSession$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        writeSessionImpl = byteBufferChannel.writeSession;
                        writeSessionImpl.begin();
                        byteBufferChannel$writeSuspendSession$1.L$0 = writeSessionImpl;
                        byteBufferChannel$writeSuspendSession$1.label = 1;
                        if (function2.invoke(writeSessionImpl, byteBufferChannel$writeSuspendSession$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        writeSessionImpl = (WriteSessionImpl) byteBufferChannel$writeSuspendSession$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    writeSessionImpl.complete();
                    byteBufferChannel = Unit.INSTANCE;
                    return byteBufferChannel;
                }
            }
            if (i != 0) {
            }
            writeSessionImpl.complete();
            byteBufferChannel = Unit.INSTANCE;
            return byteBufferChannel;
        } catch (Throwable th) {
            byteBufferChannel.complete();
            throw th;
        }
        byteBufferChannel$writeSuspendSession$1 = new ByteBufferChannel$writeSuspendSession$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$writeSuspendSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$writeSuspendSession$1.label;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    /* renamed from: consumed */
    public void mo10232consumed(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ReadWriteBufferState state = getState();
        if (!state.capacity.tryReadExact(n)) {
            throw new IllegalStateException("Unable to consume " + n + " bytes: not enough available bytes");
        }
        if (n > 0) {
            bytesRead(state.getReadBuffer(), state.capacity, n);
        }
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) {
        if (i < 0) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
        }
        if (i > 4088) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
        }
        if (getState().capacity._availableForRead$internal >= i) {
            if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
                setupStateForRead();
            }
            return Boxing.boxBoolean(true);
        }
        if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
            return awaitAtLeastSuspend(i, continuation);
        }
        if (i == 1) {
            return readSuspendImpl(1, continuation);
        }
        return readSuspend(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitAtLeastSuspend(int i, Continuation<? super Boolean> continuation) {
        ByteBufferChannel$awaitAtLeastSuspend$1 byteBufferChannel$awaitAtLeastSuspend$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        boolean booleanValue;
        if (continuation instanceof ByteBufferChannel$awaitAtLeastSuspend$1) {
            byteBufferChannel$awaitAtLeastSuspend$1 = (ByteBufferChannel$awaitAtLeastSuspend$1) continuation;
            if ((byteBufferChannel$awaitAtLeastSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$awaitAtLeastSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$awaitAtLeastSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$awaitAtLeastSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel$awaitAtLeastSuspend$1.L$0 = this;
                    byteBufferChannel$awaitAtLeastSuspend$1.label = 1;
                    obj = readSuspend(i, byteBufferChannel$awaitAtLeastSuspend$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteBufferChannel = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$awaitAtLeastSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                if (booleanValue && byteBufferChannel.getState().getIdle()) {
                    byteBufferChannel.setupStateForRead();
                }
                return Boxing.boxBoolean(booleanValue);
            }
        }
        byteBufferChannel$awaitAtLeastSuspend$1 = new ByteBufferChannel$awaitAtLeastSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$awaitAtLeastSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$awaitAtLeastSuspend$1.label;
        if (i2 != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        if (booleanValue) {
            byteBufferChannel.setupStateForRead();
        }
        return Boxing.boxBoolean(booleanValue);
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public ByteBuffer request(int skip, int atLeast) {
        ReadWriteBufferState state = getState();
        int i = state.capacity._availableForRead$internal;
        int i2 = this.readPosition;
        if (i < atLeast + skip) {
            return null;
        }
        if (state.getIdle() || (!(state instanceof ReadWriteBufferState.Reading) && !(state instanceof ReadWriteBufferState.ReadingWriting))) {
            if (setupStateForRead() == null) {
                return null;
            }
            return request(skip, atLeast);
        }
        ByteBuffer readBuffer = state.getReadBuffer();
        prepareBuffer(readBuffer, carryIndex(readBuffer, i2 + skip), i - skip);
        if (readBuffer.remaining() >= atLeast) {
            return readBuffer;
        }
        return null;
    }

    private final int afterBufferVisited(ByteBuffer buffer, RingBufferCapacity capacity) {
        int position = buffer.position() - this.readPosition;
        if (position <= 0) {
            return position;
        }
        if (!capacity.tryReadExact(position)) {
            throw new IllegalStateException("Consumed more bytes than available");
        }
        bytesRead(buffer, capacity, position);
        prepareBuffer(buffer, this.readPosition, capacity._availableForRead$internal);
        return position;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readUTF8LineToAscii(Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        return readUTF8LineToUtf8Suspend(appendable, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:46|47|48|49|50|51|52|53|(17:55|34|35|36|(1:38)|64|(0)|67|(1:69)|79|14|(0)|21|23|25|18|19)) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0120, code lost:
    
        r20 = r5;
        r9 = r18;
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013b, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0126, code lost:
    
        r0 = r16;
        r12 = r17;
        r7 = r19;
        r9 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        if (r1.read(1, r5, r4) == r3) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0119 -> B:34:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x013b -> B:34:0x013c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readUTF8LineToUtf8Suspend(Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        ByteBufferChannel$readUTF8LineToUtf8Suspend$1 byteBufferChannel$readUTF8LineToUtf8Suspend$1;
        ByteBufferChannel byteBufferChannel;
        int i2;
        boolean z;
        Ref.IntRef intRef;
        final Appendable appendable2;
        final int i3;
        final char[] cArr;
        final Ref.ObjectRef objectRef;
        final Ref.IntRef intRef2;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Ref.IntRef intRef3;
        ByteBufferChannel$readUTF8LineToUtf8Suspend$1 byteBufferChannel$readUTF8LineToUtf8Suspend$12;
        ByteBufferChannel byteBufferChannel2;
        Ref.BooleanRef booleanRef3;
        final Ref.BooleanRef booleanRef4;
        Ref.BooleanRef booleanRef5;
        Ref.BooleanRef booleanRef6;
        Ref.IntRef intRef4;
        Ref.BooleanRef booleanRef7;
        Ref.BooleanRef booleanRef8;
        Ref.BooleanRef booleanRef9;
        if (continuation instanceof ByteBufferChannel$readUTF8LineToUtf8Suspend$1) {
            byteBufferChannel$readUTF8LineToUtf8Suspend$1 = (ByteBufferChannel$readUTF8LineToUtf8Suspend$1) continuation;
            if ((byteBufferChannel$readUTF8LineToUtf8Suspend$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readUTF8LineToUtf8Suspend$1.label -= Integer.MIN_VALUE;
                byteBufferChannel = this;
                Object obj = byteBufferChannel$readUTF8LineToUtf8Suspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readUTF8LineToUtf8Suspend$1.label;
                z = true;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    intRef = new Ref.IntRef();
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    intRef5.element = 1;
                    Ref.BooleanRef booleanRef10 = new Ref.BooleanRef();
                    Ref.BooleanRef booleanRef11 = new Ref.BooleanRef();
                    appendable2 = appendable;
                    i3 = i;
                    cArr = new char[8192];
                    objectRef = new Ref.ObjectRef();
                    intRef2 = new Ref.IntRef();
                    booleanRef = booleanRef11;
                    booleanRef2 = booleanRef10;
                    intRef3 = intRef5;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12 = byteBufferChannel$readUTF8LineToUtf8Suspend$1;
                    byteBufferChannel2 = byteBufferChannel;
                    if (byteBufferChannel2.isClosedForRead()) {
                    }
                    booleanRef3 = booleanRef2;
                    booleanRef4 = booleanRef;
                    if (objectRef.element != 0) {
                    }
                    if (byteBufferChannel2.isClosedForRead()) {
                    }
                    booleanRef5 = booleanRef4;
                    booleanRef6 = booleanRef3;
                    if (byteBufferChannel2.isClosedForRead()) {
                    }
                    z = false;
                    return Boxing.boxBoolean(z);
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef8 = (Ref.BooleanRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$3;
                    booleanRef7 = (Ref.BooleanRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$2;
                    intRef4 = (Ref.IntRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$1;
                    byteBufferChannel2 = (ByteBufferChannel) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (EOFException unused) {
                    }
                    booleanRef5 = booleanRef8;
                    booleanRef6 = booleanRef7;
                    intRef = intRef4;
                    if ((byteBufferChannel2.isClosedForRead() || intRef.element <= 0) && !booleanRef5.element && !booleanRef6.element) {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
                int i4 = byteBufferChannel$readUTF8LineToUtf8Suspend$1.I$0;
                Ref.IntRef intRef6 = (Ref.IntRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$8;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$7;
                char[] cArr2 = (char[]) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$6;
                Ref.BooleanRef booleanRef12 = (Ref.BooleanRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$5;
                Ref.BooleanRef booleanRef13 = (Ref.BooleanRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$4;
                Ref.IntRef intRef7 = (Ref.IntRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$3;
                Ref.IntRef intRef8 = (Ref.IntRef) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$2;
                Appendable appendable3 = (Appendable) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$1;
                ByteBufferChannel byteBufferChannel3 = (ByteBufferChannel) byteBufferChannel$readUTF8LineToUtf8Suspend$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    intRef2 = intRef6;
                    intRef = intRef8;
                    appendable2 = appendable3;
                    i3 = i4;
                    objectRef = objectRef2;
                    booleanRef2 = booleanRef13;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12 = byteBufferChannel$readUTF8LineToUtf8Suspend$1;
                    byteBufferChannel2 = byteBufferChannel3;
                    cArr = cArr2;
                    booleanRef = booleanRef12;
                } catch (EOFException unused2) {
                    intRef2 = intRef6;
                    intRef3 = intRef7;
                    intRef = intRef8;
                    appendable2 = appendable3;
                    i3 = i4;
                    objectRef = objectRef2;
                    booleanRef2 = booleanRef13;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12 = byteBufferChannel$readUTF8LineToUtf8Suspend$1;
                    byteBufferChannel2 = byteBufferChannel3;
                    cArr = cArr2;
                    booleanRef = booleanRef12;
                }
                intRef3 = intRef7;
                if (byteBufferChannel2.isClosedForRead() && !booleanRef.element && !booleanRef2.element && (i3 == Integer.MAX_VALUE || intRef.element <= i3)) {
                    try {
                    } catch (EOFException unused3) {
                        intRef7 = intRef3;
                        booleanRef9 = booleanRef2;
                    }
                    int i5 = intRef3.element;
                    final Ref.IntRef intRef9 = intRef;
                    final Ref.IntRef intRef10 = intRef3;
                    final Ref.BooleanRef booleanRef14 = booleanRef2;
                    final Ref.BooleanRef booleanRef15 = booleanRef;
                    intRef = intRef9;
                    intRef7 = intRef10;
                    booleanRef9 = booleanRef14;
                    Appendable appendable4 = appendable2;
                    Ref.IntRef intRef11 = intRef2;
                    Function1<ByteBuffer, Unit> function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                            invoke2(byteBuffer);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.Object] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ByteBuffer buffer) {
                            Intrinsics.checkNotNullParameter(buffer, "buffer");
                            int position = buffer.position();
                            ByteBuffer byteBuffer = objectRef.element;
                            if (byteBuffer != null) {
                                int limit = buffer.limit();
                                buffer.limit(Math.min(buffer.limit(), buffer.position() + byteBuffer.remaining()));
                                byteBuffer.put(buffer);
                                byteBuffer.flip();
                                buffer.limit(limit);
                            } else {
                                byteBuffer = buffer;
                            }
                            int i6 = i3;
                            long decodeUTF8Line = UTFKt.decodeUTF8Line(byteBuffer, cArr, 0, i6 == Integer.MAX_VALUE ? cArr.length : Math.min(cArr.length, i6 - intRef9.element));
                            ByteBuffer byteBuffer2 = objectRef.element;
                            if (byteBuffer2 != null) {
                                Ref.IntRef intRef12 = intRef2;
                                Ref.ObjectRef<ByteBuffer> objectRef3 = objectRef;
                                buffer.position((position + byteBuffer2.position()) - intRef12.element);
                                ObjectPoolKt.getBufferPool().recycle(byteBuffer2);
                                objectRef3.element = null;
                                intRef12.element = 0;
                            }
                            int i7 = (int) (decodeUTF8Line >> 32);
                            int i8 = (int) (decodeUTF8Line & 4294967295L);
                            intRef10.element = Math.max(1, i8);
                            if (i8 == -1) {
                                booleanRef15.element = true;
                            }
                            if (i8 != -1 && buffer.hasRemaining() && buffer.get(buffer.position()) == 13) {
                                buffer.position(buffer.position() + 1);
                                booleanRef14.element = true;
                            }
                            if (i8 != -1 && buffer.hasRemaining() && buffer.get(buffer.position()) == 10) {
                                buffer.position(buffer.position() + 1);
                                booleanRef15.element = true;
                            }
                            Appendable appendable5 = appendable2;
                            if (appendable5 instanceof StringBuilder) {
                                ((StringBuilder) appendable5).append(cArr, 0, i7);
                            } else {
                                appendable2.append(CharBuffer.wrap(cArr, 0, i7), 0, i7);
                            }
                            intRef9.element += i7;
                            if (i7 == 0 && buffer.remaining() < i8) {
                                Ref.ObjectRef<ByteBuffer> objectRef4 = objectRef;
                                ?? borrow = ObjectPoolKt.getBufferPool().borrow();
                                intRef2.element = buffer.remaining();
                                ((ByteBuffer) borrow).put(buffer);
                                objectRef4.element = borrow;
                            }
                            if (i3 != Integer.MAX_VALUE && intRef9.element >= i3 && !booleanRef15.element) {
                                throw new TooLongLineException("Line is longer than limit");
                            }
                        }
                    };
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$0 = byteBufferChannel2;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$1 = appendable4;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$2 = intRef;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$3 = intRef7;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$4 = booleanRef9;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$5 = booleanRef15;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$6 = cArr;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$7 = objectRef;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$8 = intRef11;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.I$0 = i3;
                    byteBufferChannel$readUTF8LineToUtf8Suspend$12.label = 1;
                    if (byteBufferChannel2.read(i5, function1, byteBufferChannel$readUTF8LineToUtf8Suspend$12) != coroutine_suspended) {
                        appendable2 = appendable4;
                        booleanRef = booleanRef15;
                        intRef2 = intRef11;
                        booleanRef2 = booleanRef9;
                        intRef3 = intRef7;
                        if (byteBufferChannel2.isClosedForRead()) {
                        }
                        booleanRef3 = booleanRef2;
                        booleanRef4 = booleanRef;
                        if (objectRef.element != 0) {
                        }
                        if (byteBufferChannel2.isClosedForRead()) {
                        }
                        booleanRef5 = booleanRef4;
                        booleanRef6 = booleanRef3;
                        if (byteBufferChannel2.isClosedForRead()) {
                        }
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                } else {
                    booleanRef3 = booleanRef2;
                    booleanRef4 = booleanRef;
                    if (objectRef.element != 0) {
                        ObjectPool<ByteBuffer> bufferPool = ObjectPoolKt.getBufferPool();
                        T t = objectRef.element;
                        Intrinsics.checkNotNull(t);
                        bufferPool.recycle(t);
                    }
                    if (byteBufferChannel2.isClosedForRead() && booleanRef3.element && !booleanRef4.element) {
                        try {
                            Function1<ByteBuffer, Unit> function12 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                                    invoke2(byteBuffer);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ByteBuffer it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (it.get(it.position()) == 10) {
                                        it.position(it.position() + 1);
                                        Ref.BooleanRef.this.element = true;
                                    }
                                }
                            };
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$0 = byteBufferChannel2;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$1 = intRef;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$2 = booleanRef3;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$3 = booleanRef4;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$4 = null;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$5 = null;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$6 = null;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$7 = null;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.L$8 = null;
                            byteBufferChannel$readUTF8LineToUtf8Suspend$12.label = 2;
                        } catch (EOFException unused4) {
                        }
                    } else {
                        booleanRef5 = booleanRef4;
                        booleanRef6 = booleanRef3;
                        if (byteBufferChannel2.isClosedForRead()) {
                        }
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                }
                return coroutine_suspended;
            }
        }
        byteBufferChannel = this;
        byteBufferChannel$readUTF8LineToUtf8Suspend$1 = new ByteBufferChannel$readUTF8LineToUtf8Suspend$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$readUTF8LineToUtf8Suspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readUTF8LineToUtf8Suspend$1.label;
        z = true;
        if (i2 != 0) {
        }
        intRef4 = intRef;
        booleanRef7 = booleanRef3;
        booleanRef8 = booleanRef4;
        booleanRef5 = booleanRef8;
        booleanRef6 = booleanRef7;
        intRef = intRef4;
        if (byteBufferChannel2.isClosedForRead()) {
        }
        z = false;
        return Boxing.boxBoolean(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object readUTF8Line$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Continuation<? super String> continuation) {
        ByteBufferChannel$readUTF8Line$1 byteBufferChannel$readUTF8Line$1;
        Object obj;
        int i2;
        StringBuilder sb;
        if (continuation instanceof ByteBufferChannel$readUTF8Line$1) {
            byteBufferChannel$readUTF8Line$1 = (ByteBufferChannel$readUTF8Line$1) continuation;
            if ((byteBufferChannel$readUTF8Line$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readUTF8Line$1.label -= Integer.MIN_VALUE;
                obj = byteBufferChannel$readUTF8Line$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readUTF8Line$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb2 = new StringBuilder();
                    byteBufferChannel$readUTF8Line$1.L$0 = sb2;
                    byteBufferChannel$readUTF8Line$1.label = 1;
                    Object readUTF8LineTo = byteBufferChannel.readUTF8LineTo(sb2, i, byteBufferChannel$readUTF8Line$1);
                    if (readUTF8LineTo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = readUTF8LineTo;
                    sb = sb2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sb = (StringBuilder) byteBufferChannel$readUTF8Line$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    return null;
                }
                return sb.toString();
            }
        }
        byteBufferChannel$readUTF8Line$1 = new ByteBufferChannel$readUTF8Line$1(byteBufferChannel, continuation);
        obj = byteBufferChannel$readUTF8Line$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readUTF8Line$1.label;
        if (i2 != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation<? super ByteReadPacket> continuation) {
        if (byteBufferChannel.isClosedForWrite()) {
            Throwable closedCause = byteBufferChannel.getClosedCause();
            if (closedCause != null) {
                ByteBufferChannelKt.rethrowClosed(closedCause);
                throw new KotlinNothingValueException();
            }
            return byteBufferChannel.remainingPacket(j);
        }
        return byteBufferChannel.readRemainingSuspend(j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00bd A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003a, B:13:0x00b0, B:17:0x00bd, B:18:0x0068, B:20:0x007b, B:21:0x0081, B:23:0x0097, B:25:0x009d), top: B:11:0x003a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:12:0x003a, B:13:0x00b0, B:17:0x00bd, B:18:0x0068, B:20:0x007b, B:21:0x0081, B:23:0x0097, B:25:0x009d), top: B:11:0x003a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c2 A[Catch: all -> 0x00d5, TRY_ENTER, TryCatch #0 {all -> 0x00d5, blocks: (B:29:0x00c2, B:31:0x00cb, B:33:0x00d0, B:38:0x00d1, B:39:0x00d4, B:12:0x003a, B:13:0x00b0, B:17:0x00bd, B:18:0x0068, B:20:0x007b, B:21:0x0081, B:23:0x0097, B:25:0x009d), top: B:7:0x0022, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ad -> B:13:0x00b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ba -> B:16:0x00bb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readRemainingSuspend(long j, Continuation<? super ByteReadPacket> continuation) {
        ByteBufferChannel$readRemainingSuspend$1 byteBufferChannel$readRemainingSuspend$1;
        int i;
        BytePacketBuilder bytePacketBuilder;
        Throwable th;
        BytePacketBuilder bytePacketBuilder2;
        Output output;
        ChunkBuffer prepareWriteHead;
        ByteBufferChannel byteBufferChannel;
        Ref.LongRef longRef;
        boolean z;
        ChunkBuffer chunkBuffer;
        try {
            if (continuation instanceof ByteBufferChannel$readRemainingSuspend$1) {
                byteBufferChannel$readRemainingSuspend$1 = (ByteBufferChannel$readRemainingSuspend$1) continuation;
                if ((byteBufferChannel$readRemainingSuspend$1.label & Integer.MIN_VALUE) != 0) {
                    byteBufferChannel$readRemainingSuspend$1.label -= Integer.MIN_VALUE;
                    Object obj = byteBufferChannel$readRemainingSuspend$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteBufferChannel$readRemainingSuspend$1.label;
                    int i2 = 1;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        bytePacketBuilder2 = new BytePacketBuilder(null, i2, 0 == true ? 1 : 0);
                        try {
                            Ref.LongRef longRef2 = new Ref.LongRef();
                            longRef2.element = j;
                            BytePacketBuilder bytePacketBuilder3 = bytePacketBuilder2;
                            output = bytePacketBuilder3;
                            prepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder3, 1, null);
                            byteBufferChannel = this;
                            longRef = longRef2;
                            bytePacketBuilder = bytePacketBuilder2;
                            chunkBuffer = prepareWriteHead;
                            if (chunkBuffer.getLimit() - chunkBuffer.getWritePosition() > longRef.element) {
                            }
                            longRef.element -= readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer, 0, 0, 6, null);
                            if (longRef.element > 0) {
                                byteBufferChannel$readRemainingSuspend$1.L$0 = byteBufferChannel;
                                byteBufferChannel$readRemainingSuspend$1.L$1 = bytePacketBuilder;
                                byteBufferChannel$readRemainingSuspend$1.L$2 = longRef;
                                byteBufferChannel$readRemainingSuspend$1.L$3 = output;
                                byteBufferChannel$readRemainingSuspend$1.L$4 = prepareWriteHead;
                                byteBufferChannel$readRemainingSuspend$1.label = 1;
                                obj = byteBufferChannel.readSuspend(1, byteBufferChannel$readRemainingSuspend$1);
                                if (obj == coroutine_suspended) {
                                }
                                if (((Boolean) obj).booleanValue()) {
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bytePacketBuilder2.release();
                            throw th;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        prepareWriteHead = (ChunkBuffer) byteBufferChannel$readRemainingSuspend$1.L$4;
                        output = (Output) byteBufferChannel$readRemainingSuspend$1.L$3;
                        longRef = (Ref.LongRef) byteBufferChannel$readRemainingSuspend$1.L$2;
                        bytePacketBuilder = (BytePacketBuilder) byteBufferChannel$readRemainingSuspend$1.L$1;
                        byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readRemainingSuspend$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                z = true;
                                if (z) {
                                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                                    chunkBuffer = prepareWriteHead;
                                    if (chunkBuffer.getLimit() - chunkBuffer.getWritePosition() > longRef.element) {
                                        chunkBuffer.resetForWrite((int) longRef.element);
                                    }
                                    longRef.element -= readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer, 0, 0, 6, null);
                                    if (longRef.element > 0 && !byteBufferChannel.isClosedForRead()) {
                                        byteBufferChannel$readRemainingSuspend$1.L$0 = byteBufferChannel;
                                        byteBufferChannel$readRemainingSuspend$1.L$1 = bytePacketBuilder;
                                        byteBufferChannel$readRemainingSuspend$1.L$2 = longRef;
                                        byteBufferChannel$readRemainingSuspend$1.L$3 = output;
                                        byteBufferChannel$readRemainingSuspend$1.L$4 = prepareWriteHead;
                                        byteBufferChannel$readRemainingSuspend$1.label = 1;
                                        obj = byteBufferChannel.readSuspend(1, byteBufferChannel$readRemainingSuspend$1);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (((Boolean) obj).booleanValue()) {
                                        }
                                    }
                                } else {
                                    output.afterHeadWrite();
                                    Throwable closedCause = byteBufferChannel.getClosedCause();
                                    if (closedCause != null) {
                                        throw closedCause;
                                    }
                                    return bytePacketBuilder.build();
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        } catch (Throwable th3) {
                            output.afterHeadWrite();
                            throw th3;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            bytePacketBuilder2 = bytePacketBuilder;
        }
        byteBufferChannel$readRemainingSuspend$1 = new ByteBufferChannel$readRemainingSuspend$1(this, continuation);
        Object obj2 = byteBufferChannel$readRemainingSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$readRemainingSuspend$1.label;
        int i22 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeReadOp() {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            ClosedElement closed = getClosed();
            Throwable cause = closed != null ? closed.getCause() : null;
            if (cause != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(cause)));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m10241constructorimpl(true));
            }
        }
    }

    private final void resumeReadOp(Function0<? extends Throwable> exception) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(exception.invoke())));
        }
    }

    private final void resumeWriteOp() {
        Continuation<Unit> writeOp;
        ClosedElement closed;
        Object createFailure;
        do {
            writeOp = getWriteOp();
            if (writeOp == null) {
                return;
            }
            closed = getClosed();
            if (closed == null && this.joining != null) {
                ReadWriteBufferState state = getState();
                if (!(state instanceof ReadWriteBufferState.Writing) && !(state instanceof ReadWriteBufferState.ReadingWriting) && state != ReadWriteBufferState.Terminated.INSTANCE) {
                    return;
                }
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_writeOp$FU, this, writeOp, null));
        if (closed == null) {
            Result.Companion companion = Result.INSTANCE;
            createFailure = Unit.INSTANCE;
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            createFailure = ResultKt.createFailure(closed.getSendException());
        }
        writeOp.resumeWith(Result.m10241constructorimpl(createFailure));
    }

    private final void resumeClosed(Throwable cause) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, null);
        if (continuation != null) {
            if (cause != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(cause)));
            } else {
                Boolean valueOf = Boolean.valueOf(getState().capacity._availableForRead$internal > 0);
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m10241constructorimpl(valueOf));
            }
        }
        Continuation continuation2 = (Continuation) _writeOp$FU.getAndSet(this, null);
        if (continuation2 != null) {
            Result.Companion companion3 = Result.INSTANCE;
            if (cause == null) {
                cause = new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE);
            }
            continuation2.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(cause)));
        }
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation<? super Unit> continuation) {
        Object readSuspend = byteBufferChannel.readSuspend(1, continuation);
        return readSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readSuspend(int i, Continuation<? super Boolean> continuation) {
        if (getState().capacity._availableForRead$internal >= i) {
            return Boxing.boxBoolean(true);
        }
        ClosedElement closed = getClosed();
        if (closed == null) {
            if (i == 1) {
                return readSuspendImpl(1, continuation);
            }
            return readSuspendLoop(i, continuation);
        }
        Throwable cause = closed.getCause();
        if (cause != null) {
            ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        boolean z = ringBufferCapacity.flush() && ringBufferCapacity._availableForRead$internal >= i;
        if (getReadOp() != null) {
            throw new IllegalStateException("Read operation is already in progress");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0093 -> B:10:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readSuspendLoop(int i, Continuation<? super Boolean> continuation) {
        ByteBufferChannel$readSuspendLoop$1 byteBufferChannel$readSuspendLoop$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readSuspendLoop$1) {
            byteBufferChannel$readSuspendLoop$1 = (ByteBufferChannel$readSuspendLoop$1) continuation;
            if ((byteBufferChannel$readSuspendLoop$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readSuspendLoop$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readSuspendLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readSuspendLoop$1.label;
                boolean z = false;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                    if (byteBufferChannel.getState().capacity._availableForRead$internal >= i) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteBufferChannel$readSuspendLoop$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readSuspendLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        return Boxing.boxBoolean(false);
                    }
                    if (byteBufferChannel.getState().capacity._availableForRead$internal >= i) {
                        ClosedElement closed = byteBufferChannel.getClosed();
                        if (closed != null) {
                            if (closed.getCause() != null) {
                                ByteBufferChannelKt.rethrowClosed(closed.getCause());
                                throw new KotlinNothingValueException();
                            }
                            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                            if (ringBufferCapacity.flush() && ringBufferCapacity._availableForRead$internal >= i) {
                                z = true;
                            }
                            if (byteBufferChannel.getReadOp() != null) {
                                throw new IllegalStateException("Read operation is already in progress");
                            }
                            return Boxing.boxBoolean(z);
                        }
                        byteBufferChannel$readSuspendLoop$1.L$0 = byteBufferChannel;
                        byteBufferChannel$readSuspendLoop$1.I$0 = i;
                        byteBufferChannel$readSuspendLoop$1.label = 1;
                        obj = byteBufferChannel.readSuspendImpl(i, byteBufferChannel$readSuspendLoop$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!((Boolean) obj).booleanValue()) {
                        }
                        if (byteBufferChannel.getState().capacity._availableForRead$internal >= i) {
                            return Boxing.boxBoolean(true);
                        }
                    }
                }
            }
        }
        byteBufferChannel$readSuspendLoop$1 = new ByteBufferChannel$readSuspendLoop$1(this, continuation);
        Object obj2 = byteBufferChannel$readSuspendLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readSuspendLoop$1.label;
        boolean z2 = false;
        if (i2 != 0) {
        }
    }

    private final boolean readSuspendPredicate(int size) {
        ReadWriteBufferState state = getState();
        if (state.capacity._availableForRead$internal >= size) {
            return false;
        }
        if (this.joining == null || getWriteOp() == null) {
            return true;
        }
        return (state == ReadWriteBufferState.IdleEmpty.INSTANCE || (state instanceof ReadWriteBufferState.IdleNonEmpty)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readSuspendImpl(int i, Continuation<? super Boolean> continuation) {
        ByteBufferChannel$readSuspendImpl$1 byteBufferChannel$readSuspendImpl$1;
        int i2;
        ByteBufferChannel byteBufferChannel;
        if (continuation instanceof ByteBufferChannel$readSuspendImpl$1) {
            byteBufferChannel$readSuspendImpl$1 = (ByteBufferChannel$readSuspendImpl$1) continuation;
            if ((byteBufferChannel$readSuspendImpl$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$readSuspendImpl$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$readSuspendImpl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$readSuspendImpl$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ReadWriteBufferState state = getState();
                    if (state.capacity._availableForRead$internal >= i || (this.joining != null && getWriteOp() != null && (state == ReadWriteBufferState.IdleEmpty.INSTANCE || (state instanceof ReadWriteBufferState.IdleNonEmpty)))) {
                        return Boxing.boxBoolean(true);
                    }
                    try {
                        byteBufferChannel$readSuspendImpl$1.L$0 = this;
                        byteBufferChannel$readSuspendImpl$1.I$0 = i;
                        byteBufferChannel$readSuspendImpl$1.label = 1;
                        CancellableReusableContinuation<Boolean> cancellableReusableContinuation = this.readSuspendContinuationCache;
                        suspensionForSize(i, cancellableReusableContinuation);
                        Object completeSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt.intercepted(byteBufferChannel$readSuspendImpl$1));
                        if (completeSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(byteBufferChannel$readSuspendImpl$1);
                        }
                        return completeSuspendBlock == coroutine_suspended ? coroutine_suspended : completeSuspendBlock;
                    } catch (Throwable th) {
                        th = th;
                        byteBufferChannel = this;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = byteBufferChannel$readSuspendImpl$1.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$readSuspendImpl$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                byteBufferChannel.setReadOp(null);
                throw th;
            }
        }
        byteBufferChannel$readSuspendImpl$1 = new ByteBufferChannel$readSuspendImpl$1(this, continuation);
        Object obj2 = byteBufferChannel$readSuspendImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$readSuspendImpl$1.label;
        if (i2 != 0) {
        }
        byteBufferChannel.setReadOp(null);
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldResumeReadOp() {
        if (this.joining != null) {
            return getState() == ReadWriteBufferState.IdleEmpty.INSTANCE || (getState() instanceof ReadWriteBufferState.IdleNonEmpty);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean writeSuspendPredicate(int size) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState state = getState();
        if (getClosed() != null) {
            return false;
        }
        return joiningState == null ? state.capacity._availableForWrite$internal < size && state != ReadWriteBufferState.IdleEmpty.INSTANCE : (state == ReadWriteBufferState.Terminated.INSTANCE || (state instanceof ReadWriteBufferState.Writing) || (state instanceof ReadWriteBufferState.ReadingWriting)) ? false : true;
    }

    public final Object tryWriteSuspend$ktor_io(int i, Continuation<? super Unit> continuation) {
        Throwable sendException;
        if (!writeSuspendPredicate(i)) {
            ClosedElement closed = getClosed();
            if (closed != null && (sendException = closed.getSendException()) != null) {
                ByteBufferChannelKt.rethrowClosed(sendException);
                throw new KotlinNothingValueException();
            }
            return Unit.INSTANCE;
        }
        this.writeSuspensionSize = i;
        if (this.attachedJob != null) {
            Object invoke = this.writeSuspension.invoke(continuation);
            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        CancellableReusableContinuation<Unit> cancellableReusableContinuation = this.writeSuspendContinuationCache;
        this.writeSuspension.invoke(cancellableReusableContinuation);
        Object completeSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt.intercepted(continuation));
        if (completeSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return completeSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? completeSuspendBlock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeSuspend(int i, Continuation<? super Unit> continuation) {
        ByteBufferChannel$writeSuspend$3 byteBufferChannel$writeSuspend$3;
        int i2;
        ByteBufferChannel byteBufferChannel;
        ClosedElement closed;
        Throwable sendException;
        if (continuation instanceof ByteBufferChannel$writeSuspend$3) {
            byteBufferChannel$writeSuspend$3 = (ByteBufferChannel$writeSuspend$3) continuation;
            if ((byteBufferChannel$writeSuspend$3.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$writeSuspend$3.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$writeSuspend$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteBufferChannel$writeSuspend$3.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBufferChannel = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteBufferChannel$writeSuspend$3.I$0;
                    byteBufferChannel = (ByteBufferChannel) byteBufferChannel$writeSuspend$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (byteBufferChannel.writeSuspendPredicate(i)) {
                    byteBufferChannel$writeSuspend$3.L$0 = byteBufferChannel;
                    byteBufferChannel$writeSuspend$3.I$0 = i;
                    byteBufferChannel$writeSuspend$3.label = 1;
                    ByteBufferChannel$writeSuspend$3 byteBufferChannel$writeSuspend$32 = byteBufferChannel$writeSuspend$3;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(byteBufferChannel$writeSuspend$32), 1);
                    cancellableContinuationImpl.initCancellability();
                    byteBufferChannel.writeSuspendBlock(i, cancellableContinuationImpl);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(byteBufferChannel$writeSuspend$32);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                closed = byteBufferChannel.getClosed();
                if (closed == null && (sendException = closed.getSendException()) != null) {
                    ByteBufferChannelKt.rethrowClosed(sendException);
                    throw new KotlinNothingValueException();
                }
                return Unit.INSTANCE;
            }
        }
        byteBufferChannel$writeSuspend$3 = new ByteBufferChannel$writeSuspend$3(this, continuation);
        Object obj2 = byteBufferChannel$writeSuspend$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteBufferChannel$writeSuspend$3.label;
        if (i2 != 0) {
        }
        while (byteBufferChannel.writeSuspendPredicate(i)) {
        }
        closed = byteBufferChannel.getClosed();
        if (closed == null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeSuspendBlock(int size, CancellableContinuation<? super Unit> c) {
        Throwable sendException;
        while (true) {
            ClosedElement closed = getClosed();
            if (closed != null && (sendException = closed.getSendException()) != null) {
                ByteBufferChannelKt.rethrowClosed(sendException);
                throw new KotlinNothingValueException();
            }
            if (!writeSuspendPredicate(size)) {
                Result.Companion companion = Result.INSTANCE;
                c.resumeWith(Result.m10241constructorimpl(Unit.INSTANCE));
                break;
            }
            while (getWriteOp() == null) {
                if (!writeSuspendPredicate(size)) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _writeOp$FU;
                CancellableContinuation<? super Unit> cancellableContinuation = c;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, null, cancellableContinuation)) {
                    if (writeSuspendPredicate(size) || !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, cancellableContinuation, null)) {
                        break;
                    }
                }
            }
            throw new IllegalStateException("Operation is already in progress".toString());
        }
        flushImpl(size);
        if (shouldResumeReadOp()) {
            resumeReadOp();
        }
    }

    private final ReadWriteBufferState.Initial newBuffer() {
        ReadWriteBufferState.Initial borrow = this.pool.borrow();
        borrow.capacity.resetForWrite();
        return borrow;
    }

    private final void releaseBuffer(ReadWriteBufferState.Initial buffer) {
        this.pool.recycle(buffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: peekTo-lBXzO7A$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object m9953peekTolBXzO7A$suspendImpl(ByteBufferChannel byteBufferChannel, final ByteBuffer byteBuffer, final long j, final long j2, long j3, final long j4, Continuation<? super Long> continuation) {
        ByteBufferChannel$peekTo$1 byteBufferChannel$peekTo$1;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof ByteBufferChannel$peekTo$1) {
            byteBufferChannel$peekTo$1 = (ByteBufferChannel$peekTo$1) continuation;
            if ((byteBufferChannel$peekTo$1.label & Integer.MIN_VALUE) != 0) {
                byteBufferChannel$peekTo$1.label -= Integer.MIN_VALUE;
                Object obj = byteBufferChannel$peekTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteBufferChannel$peekTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.IntRef intRef2 = new Ref.IntRef();
                    int coerceAtMost = (int) RangesKt.coerceAtMost(j3 + j2, 4088L);
                    try {
                        Function1<? super ByteBuffer, Unit> function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$peekTo$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer2) {
                                invoke2(byteBuffer2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ByteBuffer nioBuffer) {
                                Intrinsics.checkNotNullParameter(nioBuffer, "nioBuffer");
                                if (nioBuffer.remaining() > j2) {
                                    ByteBuffer duplicate = nioBuffer.duplicate();
                                    Intrinsics.checkNotNull(duplicate);
                                    duplicate.position(duplicate.position() + ((int) j2));
                                    int limit = duplicate.limit();
                                    duplicate.limit((int) Math.min(duplicate.limit(), Math.min(j4, byteBuffer.limit() - j) + j2));
                                    intRef2.element = duplicate.remaining();
                                    MemoryJvmKt.m9987copyToSG11BkQ(duplicate, byteBuffer, (int) j);
                                    duplicate.limit(limit);
                                }
                            }
                        };
                        byteBufferChannel$peekTo$1.L$0 = intRef2;
                        byteBufferChannel$peekTo$1.label = 1;
                        if (byteBufferChannel.read(coerceAtMost, function1, byteBufferChannel$peekTo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (EOFException unused) {
                    }
                    intRef = intRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = (Ref.IntRef) byteBufferChannel$peekTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (EOFException unused2) {
                    }
                }
                return Boxing.boxLong(intRef.element);
            }
        }
        byteBufferChannel$peekTo$1 = new ByteBufferChannel$peekTo$1(byteBufferChannel, continuation);
        Object obj2 = byteBufferChannel$peekTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteBufferChannel$peekTo$1.label;
        if (i != 0) {
        }
        return Boxing.boxLong(intRef.element);
    }

    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + getState() + ')';
    }

    public final void restoreStateAfterWrite$ktor_io() {
        Object obj;
        ReadWriteBufferState stopWriting$ktor_io;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            obj = this._state;
            stopWriting$ktor_io = ((ReadWriteBufferState) obj).stopWriting$ktor_io();
            if ((stopWriting$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && stopWriting$ktor_io.capacity.isEmpty()) {
                stopWriting$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                readWriteBufferState = stopWriting$ktor_io;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, obj, stopWriting$ktor_io));
        if (stopWriting$ktor_io != ReadWriteBufferState.IdleEmpty.INSTANCE || (idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState) == null) {
            return;
        }
        releaseBuffer(idleNonEmpty.getInitial());
    }

    private final ByteBuffer setupStateForRead() {
        Object obj;
        Throwable cause;
        ReadWriteBufferState startReading$ktor_io;
        Throwable cause2;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.Terminated.INSTANCE) ? true : Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.IdleEmpty.INSTANCE)) {
                ClosedElement closed = getClosed();
                if (closed == null || (cause = closed.getCause()) == null) {
                    return null;
                }
                ByteBufferChannelKt.rethrowClosed(cause);
                throw new KotlinNothingValueException();
            }
            ClosedElement closed2 = getClosed();
            if (closed2 != null && (cause2 = closed2.getCause()) != null) {
                ByteBufferChannelKt.rethrowClosed(cause2);
                throw new KotlinNothingValueException();
            }
            if (readWriteBufferState.capacity._availableForRead$internal == 0) {
                return null;
            }
            startReading$ktor_io = readWriteBufferState.startReading$ktor_io();
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, obj, startReading$ktor_io));
        ByteBuffer readBuffer = startReading$ktor_io.getReadBuffer();
        prepareBuffer(readBuffer, this.readPosition, startReading$ktor_io.capacity._availableForRead$internal);
        return readBuffer;
    }

    private final void restoreStateAfterRead() {
        Object obj;
        ReadWriteBufferState stopReading$ktor_io;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty != null) {
                idleNonEmpty.capacity.resetForWrite();
                resumeWriteOp();
                readWriteBufferState = null;
            }
            stopReading$ktor_io = readWriteBufferState2.stopReading$ktor_io();
            if ((stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && getState() == readWriteBufferState2 && stopReading$ktor_io.capacity.tryLockForRelease()) {
                stopReading$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                readWriteBufferState = stopReading$ktor_io;
            }
            atomicReferenceFieldUpdater = _state$FU;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, stopReading$ktor_io));
        if (stopReading$ktor_io == ReadWriteBufferState.IdleEmpty.INSTANCE) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty2 != null) {
                releaseBuffer(idleNonEmpty2.getInitial());
            }
            resumeWriteOp();
            return;
        }
        if ((stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && stopReading$ktor_io.capacity.isEmpty() && stopReading$ktor_io.capacity.tryLockForRelease() && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, stopReading$ktor_io, ReadWriteBufferState.IdleEmpty.INSTANCE)) {
            stopReading$ktor_io.capacity.resetForWrite();
            releaseBuffer(((ReadWriteBufferState.IdleNonEmpty) stopReading$ktor_io).getInitial());
            resumeWriteOp();
        }
    }

    private final boolean tryReleaseBuffer(boolean forceTermination) {
        Object obj;
        ReadWriteBufferState.Terminated terminated;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ClosedElement closed = getClosed();
            if (initial != null) {
                if ((closed != null ? closed.getCause() : null) == null) {
                    initial.capacity.resetForWrite();
                }
                resumeWriteOp();
                initial = null;
            }
            if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                return true;
            }
            if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            } else if (closed != null && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState.capacity.tryLockForRelease() || closed.getCause() != null)) {
                if (closed.getCause() != null) {
                    readWriteBufferState.capacity.forceLockForRelease();
                }
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).getInitial();
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            } else {
                if (!forceTermination || !(readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) || !readWriteBufferState.capacity.tryLockForRelease()) {
                    return false;
                }
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).getInitial();
                terminated = ReadWriteBufferState.Terminated.INSTANCE;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, obj, terminated));
        if (initial != null && getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            releaseBuffer(initial);
        }
        return true;
    }

    private final int readAsMuchAsPossible(ByteBuffer dst) {
        ByteBuffer byteBuffer = setupStateForRead();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        try {
            if (ringBufferCapacity._availableForRead$internal != 0) {
                int capacity = byteBuffer.capacity() - this.reservedSize;
                while (true) {
                    int remaining = dst.remaining();
                    if (remaining == 0) {
                        break;
                    }
                    int i2 = this.readPosition;
                    int tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(capacity - i2, remaining));
                    if (tryReadAtMost == 0) {
                        break;
                    }
                    byteBuffer.limit(i2 + tryReadAtMost);
                    byteBuffer.position(i2);
                    dst.put(byteBuffer);
                    bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                    i += tryReadAtMost;
                }
            }
            return i;
        } finally {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    private final int readAsMuchAsPossible(Buffer dst, int consumed, int max) {
        int tryReadAtMost;
        do {
            ByteBuffer byteBuffer = setupStateForRead();
            boolean z = false;
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int limit = dst.getLimit() - dst.getWritePosition();
                        tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(byteBuffer.remaining(), Math.min(limit, max)));
                        if (tryReadAtMost > 0) {
                            if (limit < byteBuffer.remaining()) {
                                byteBuffer.limit(byteBuffer.position() + limit);
                            }
                            BufferPrimitivesJvmKt.writeFully(dst, byteBuffer);
                            bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                            z = true;
                        }
                        consumed += tryReadAtMost;
                        max -= tryReadAtMost;
                        if (z || dst.getLimit() <= dst.getWritePosition()) {
                            break;
                            break;
                        }
                    }
                } finally {
                    restoreStateAfterRead();
                    tryTerminate$ktor_io();
                }
            }
            tryReadAtMost = 0;
            consumed += tryReadAtMost;
            max -= tryReadAtMost;
            if (z) {
                break;
            }
        } while (getState().capacity._availableForRead$internal > 0);
        return consumed;
    }

    static /* synthetic */ int readAsMuchAsPossible$default(ByteBufferChannel byteBufferChannel, Buffer buffer, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = buffer.getLimit() - buffer.getWritePosition();
        }
        return byteBufferChannel.readAsMuchAsPossible(buffer, i, i2);
    }

    private final int readAsMuchAsPossible(byte[] dst, int offset, int length) {
        ByteBuffer byteBuffer = setupStateForRead();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        try {
            if (ringBufferCapacity._availableForRead$internal != 0) {
                int capacity = byteBuffer.capacity() - this.reservedSize;
                while (true) {
                    int i2 = length - i;
                    if (i2 == 0) {
                        break;
                    }
                    int i3 = this.readPosition;
                    int tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(capacity - i3, i2));
                    if (tryReadAtMost == 0) {
                        break;
                    }
                    byteBuffer.limit(i3 + tryReadAtMost);
                    byteBuffer.position(i3);
                    byteBuffer.get(dst, offset + i, tryReadAtMost);
                    bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                    i += tryReadAtMost;
                }
            }
            return i;
        } finally {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0076 A[RETURN] */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readAvailable(int min, Function1<? super ByteBuffer, Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        if (min <= 0) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (min > 4088) {
            throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 4088").toString());
        }
        ByteBuffer byteBuffer = setupStateForRead();
        boolean z = false;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int tryReadAtLeast = ringBufferCapacity.tryReadAtLeast(min);
                    if (tryReadAtLeast > 0 && tryReadAtLeast >= min) {
                        int position = byteBuffer.position();
                        int limit = byteBuffer.limit();
                        block.invoke(byteBuffer);
                        if (limit != byteBuffer.limit()) {
                            throw new IllegalStateException("Buffer limit shouldn't be modified.".toString());
                        }
                        i = byteBuffer.position() - position;
                        if (i < 0) {
                            throw new IllegalStateException("Position shouldn't been moved backwards.".toString());
                        }
                        bytesRead(byteBuffer, ringBufferCapacity, i);
                        if (i < tryReadAtLeast) {
                            ringBufferCapacity.completeWrite(tryReadAtLeast - i);
                            ringBufferCapacity.flush();
                        }
                        z = true;
                        if (z) {
                            return i;
                        }
                        return -1;
                    }
                    i = 0;
                    if (z) {
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        i = 0;
        if (z) {
        }
    }

    private final int writeAsMuchAsPossible(ByteBuffer src) {
        ByteBufferChannel byteBufferChannel;
        int tryWriteAtMost;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
            int limit = src.limit();
            while (true) {
                int position = limit - src.position();
                if (position == 0 || (tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(position, byteBuffer.remaining()))) == 0) {
                    break;
                }
                if (tryWriteAtMost <= 0) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                src.limit(src.position() + tryWriteAtMost);
                byteBuffer.put(src);
                i += tryWriteAtMost;
                byteBufferChannel.prepareBuffer(byteBuffer, byteBufferChannel.carryIndex(byteBuffer, byteBufferChannel.writePosition + i), ringBufferCapacity._availableForWrite$internal);
            }
            src.limit(limit);
            byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
            return i;
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final int writeAsMuchAsPossible(Buffer src) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
            while (true) {
                int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(src.getWritePosition() - src.getReadPosition(), byteBuffer.remaining()));
                if (tryWriteAtMost == 0) {
                    break;
                }
                BufferUtilsJvmKt.readFully(src, byteBuffer, tryWriteAtMost);
                i += tryWriteAtMost;
                byteBufferChannel.prepareBuffer(byteBuffer, byteBufferChannel.carryIndex(byteBuffer, byteBufferChannel.writePosition + i), ringBufferCapacity._availableForWrite$internal);
            }
            byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
            return i;
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final int writeAsMuchAsPossible(byte[] src, int offset, int length) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
            while (true) {
                int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(length - i, byteBuffer.remaining()));
                if (tryWriteAtMost == 0) {
                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, i);
                    return i;
                }
                if (tryWriteAtMost <= 0) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                byteBuffer.put(src, offset + i, tryWriteAtMost);
                i += tryWriteAtMost;
                byteBufferChannel.prepareBuffer(byteBuffer, byteBufferChannel.carryIndex(byteBuffer, byteBufferChannel.writePosition + i), ringBufferCapacity._availableForWrite$internal);
            }
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block) {
        ByteBufferChannel byteBufferChannel;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        if (min <= 0) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (min > 4088) {
            throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 4088").toString());
        }
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        int i3 = 0;
        if (byteBuffer == null) {
            i2 = 0;
        } else {
            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
            long j = byteBufferChannel.get_totalBytesWritten();
            try {
                ClosedElement closed = byteBufferChannel.getClosed();
                if (closed != null) {
                    ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                    throw new KotlinNothingValueException();
                }
                ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                int tryWriteAtLeast = ringBufferCapacity.tryWriteAtLeast(min);
                if (tryWriteAtLeast <= 0) {
                    i = 0;
                } else {
                    byteBufferChannel.prepareBuffer(byteBuffer, byteBufferChannel.writePosition, tryWriteAtLeast);
                    int position = byteBuffer.position();
                    int limit = byteBuffer.limit();
                    block.invoke(byteBuffer);
                    if (limit != byteBuffer.limit()) {
                        throw new IllegalStateException("Buffer limit modified".toString());
                    }
                    int position2 = byteBuffer.position() - position;
                    if (position2 < 0) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());
                    }
                    if (position2 < 0) {
                        throw new IllegalStateException();
                    }
                    byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, position2);
                    if (position2 < tryWriteAtLeast) {
                        ringBufferCapacity.completeRead(tryWriteAtLeast - position2);
                    }
                    i = 1;
                    i3 = position2;
                }
                if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
                }
                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                byteBufferChannel.tryTerminate$ktor_io();
                int i4 = i3;
                i3 = i;
                i2 = i4;
            } catch (Throwable th) {
                if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
                }
                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                byteBufferChannel.tryTerminate$ktor_io();
                throw th;
            }
        }
        if (i3 == 0) {
            return -1;
        }
        return i2;
    }

    private final boolean writeWhileNoSuspend(Function1<? super ByteBuffer, Boolean> block) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return true;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
            return byteBufferChannel.writeWhileLoop(byteBuffer, ringBufferCapacity, block);
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    static /* synthetic */ Object read$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        int i2;
        if (i < 0) {
            throw new IllegalArgumentException("min should be positive or zero".toString());
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0 && (i2 = ringBufferCapacity._availableForRead$internal) > 0 && i2 >= i) {
                    int position = byteBuffer.position();
                    int limit = byteBuffer.limit();
                    function1.invoke(byteBuffer);
                    if (!(limit == byteBuffer.limit())) {
                        throw new IllegalStateException("Buffer limit modified.".toString());
                    }
                    int position2 = byteBuffer.position() - position;
                    if (!(position2 >= 0)) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                    }
                    if (!ringBufferCapacity.tryReadExact(position2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, position2);
                    r1 = true;
                }
            } finally {
                byteBufferChannel.restoreStateAfterRead();
                byteBufferChannel.tryTerminate$ktor_io();
            }
        }
        if (!r1) {
            if (byteBufferChannel.isClosedForRead() && i > 0) {
                throw new EOFException("Got EOF but at least " + i + " bytes were expected");
            }
            Object readBlockSuspend = byteBufferChannel.readBlockSuspend(i, function1, continuation);
            return readBlockSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readBlockSuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation<? super Long> continuation) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("max shouldn't be negative: " + j).toString());
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int tryReadAtMost = ringBufferCapacity.tryReadAtMost((int) Math.min(2147483647L, j));
                    byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                    j2 = tryReadAtMost;
                }
            } finally {
                byteBufferChannel.restoreStateAfterRead();
                byteBufferChannel.tryTerminate$ktor_io();
            }
        }
        long j3 = j2;
        if (j3 == j || byteBufferChannel.isClosedForRead()) {
            return Boxing.boxLong(j3);
        }
        return byteBufferChannel.discardSuspend(j3, j, continuation);
    }

    private final int tryWritePacketPart(ByteReadPacket packet) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long j = byteBufferChannel.get_totalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed != null) {
                ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
            int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost((int) Math.min(packet.getRemaining(), byteBuffer.remaining()));
            if (tryWriteAtMost > 0) {
                byteBuffer.limit(byteBuffer.position() + tryWriteAtMost);
                ByteBuffersKt.readFully(packet, byteBuffer);
                byteBufferChannel.bytesWritten(byteBuffer, ringBufferCapacity, tryWriteAtMost);
            }
            return tryWriteAtMost;
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(get_totalBytesWritten() + (byteBufferChannel.get_totalBytesWritten() - j));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final boolean consumeEachBufferRangeFast(boolean last, Function2<? super ByteBuffer, ? super Boolean, Boolean> visitor) {
        ByteBuffer byteBuffer = setupStateForRead();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    while (true) {
                        if (!byteBuffer.hasRemaining() && !last) {
                            break;
                        }
                        boolean booleanValue = visitor.invoke(byteBuffer, Boolean.valueOf(last)).booleanValue();
                        afterBufferVisited(byteBuffer, ringBufferCapacity);
                        if (!booleanValue || (last && !byteBuffer.hasRemaining())) {
                            break;
                        }
                    }
                    return true;
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        last = false;
        if (last || getClosed() == null) {
            return last;
        }
        visitor.invoke(ReadWriteBufferStateKt.getEmptyByteBuffer(), true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ByteReadPacket remainingPacket(long limit) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
            ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder2, 1, null);
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareWriteHead;
                    if (chunkBuffer.getLimit() - chunkBuffer.getWritePosition() > limit) {
                        chunkBuffer.resetForWrite((int) limit);
                    }
                    limit -= readAsMuchAsPossible$default(this, chunkBuffer, 0, 0, 6, null);
                    if (limit <= 0 || isClosedForRead()) {
                        break;
                    }
                    prepareWriteHead = UnsafeKt.prepareWriteHead(bytePacketBuilder2, 1, prepareWriteHead);
                } catch (Throwable th) {
                    bytePacketBuilder2.afterHeadWrite();
                    throw th;
                }
            }
            bytePacketBuilder2.afterHeadWrite();
            return bytePacketBuilder.build();
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00e7, code lost:
    
        return kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object suspensionForSize(int size, Continuation<? super Boolean> continuation) {
        while (true) {
            ReadWriteBufferState state = getState();
            if (state.capacity._availableForRead$internal >= size || !(this.joining == null || getWriteOp() == null || (state != ReadWriteBufferState.IdleEmpty.INSTANCE && !(state instanceof ReadWriteBufferState.IdleNonEmpty)))) {
                break;
            }
            ClosedElement closed = getClosed();
            if (closed != null) {
                if (closed.getCause() != null) {
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(closed.getCause())));
                    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
                }
                boolean flush = getState().capacity.flush();
                boolean z = getState().capacity._availableForRead$internal >= size;
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m10241constructorimpl(Boolean.valueOf(flush && z)));
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            while (getReadOp() == null) {
                if (getClosed() == null) {
                    ReadWriteBufferState state2 = getState();
                    if (state2.capacity._availableForRead$internal < size && (this.joining == null || getWriteOp() == null || (state2 != ReadWriteBufferState.IdleEmpty.INSTANCE && !(state2 instanceof ReadWriteBufferState.IdleNonEmpty)))) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _readOp$FU;
                        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, null, continuation)) {
                            if (getClosed() == null) {
                                ReadWriteBufferState state3 = getState();
                                if (state3.capacity._availableForRead$internal < size) {
                                    if (this.joining == null) {
                                        break;
                                    }
                                    if (getWriteOp() == null) {
                                        break;
                                    }
                                    if (state3 != ReadWriteBufferState.IdleEmpty.INSTANCE && !(state3 instanceof ReadWriteBufferState.IdleNonEmpty)) {
                                        break;
                                    }
                                }
                            }
                            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, continuation, null)) {
                                break;
                            }
                        }
                    }
                }
            }
            throw new IllegalStateException("Operation is already in progress".toString());
        }
    }
}
