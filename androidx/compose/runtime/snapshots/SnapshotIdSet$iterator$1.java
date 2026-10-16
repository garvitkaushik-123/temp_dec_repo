package androidx.compose.runtime.snapshots;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", FirebaseAnalytics.Param.INDEX, "$this$sequence", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes.dex */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ba, code lost:
    
        if (r13.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r19.this$0.lowerBound + r2), r19) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        if (r15.yield(kotlin.coroutines.jvm.internal.Boxing.boxInt(r14[r13]), r19) == r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x00d8 -> B:8:0x00fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00f9 -> B:7:0x00fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009e -> B:22:0x00bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ba -> B:22:0x00bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x007c -> B:33:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        SequenceScope sequenceScope2;
        int length;
        int[] iArr;
        int i;
        long j;
        SequenceScope sequenceScope3;
        int i2;
        SequenceScope sequenceScope4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 0;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            int[] iArr2 = this.this$0.belowBound;
            if (iArr2 != null) {
                sequenceScope2 = sequenceScope;
                length = iArr2.length;
                iArr = iArr2;
                i = 0;
                if (i < length) {
                }
            }
            j = 1;
            if (this.this$0.lowerSet != 0) {
            }
            if (this.this$0.upperSet != 0) {
            }
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            length = this.I$1;
            i = this.I$0;
            iArr = (int[]) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i++;
            if (i < length) {
                sequenceScope = sequenceScope2;
                j = 1;
                if (this.this$0.lowerSet != 0) {
                    sequenceScope3 = sequenceScope;
                    i2 = 0;
                    if (i2 >= 64) {
                    }
                }
                if (this.this$0.upperSet != 0) {
                }
                return Unit.INSTANCE;
            }
            this.L$0 = sequenceScope2;
            this.L$1 = iArr;
            this.I$0 = i;
            this.I$1 = length;
            this.label = 1;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i5 = this.I$0;
                sequenceScope4 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                j = 1;
                i4 = i5;
                i4++;
                if (i4 < 64) {
                    if ((this.this$0.upperSet & (j << i4)) != 0) {
                        this.L$0 = sequenceScope4;
                        this.L$1 = null;
                        this.I$0 = i4;
                        this.label = 3;
                        if (sequenceScope4.yield(Boxing.boxInt(i4 + 64 + this.this$0.lowerBound), this) != coroutine_suspended) {
                            i5 = i4;
                            i4 = i5;
                        }
                        return coroutine_suspended;
                    }
                    i4++;
                    if (i4 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            i2 = this.I$0;
            sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            j = 1;
            i2++;
            if (i2 >= 64) {
                sequenceScope = sequenceScope3;
                if (this.this$0.upperSet != 0) {
                    sequenceScope4 = sequenceScope;
                    if (i4 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            if ((this.this$0.lowerSet & (j << i2)) != 0) {
                this.L$0 = sequenceScope3;
                this.L$1 = null;
                this.I$0 = i2;
                this.label = 2;
            }
            i2++;
            if (i2 >= 64) {
            }
        }
    }
}
