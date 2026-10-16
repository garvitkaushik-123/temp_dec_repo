package androidx.compose.runtime.collection;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [Key] */
/* compiled from: IdentityArrayMap.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.collection.IdentityArrayMap$asMap$1$keys$1$iterator$1", f = "IdentityArrayMap.kt", i = {0, 0}, l = {251}, m = "invokeSuspend", n = {"$this$sequence", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
/* loaded from: classes.dex */
final class IdentityArrayMap$asMap$1$keys$1$iterator$1<Key> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Key>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IdentityArrayMap<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IdentityArrayMap$asMap$1$keys$1$iterator$1(IdentityArrayMap<Key, Value> identityArrayMap, Continuation<? super IdentityArrayMap$asMap$1$keys$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = identityArrayMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IdentityArrayMap$asMap$1$keys$1$iterator$1 identityArrayMap$asMap$1$keys$1$iterator$1 = new IdentityArrayMap$asMap$1$keys$1$iterator$1(this.this$0, continuation);
        identityArrayMap$asMap$1$keys$1$iterator$1.L$0 = obj;
        return identityArrayMap$asMap$1$keys$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Key> sequenceScope, Continuation<? super Unit> continuation) {
        return ((IdentityArrayMap$asMap$1$keys$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x004c -> B:5:0x004f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int size;
        int i;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            size = this.this$0.getSize();
            i = 0;
            sequenceScope = sequenceScope2;
            if (i < size) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = this.I$1;
            i = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i++;
            if (i < size) {
                Object obj2 = this.this$0.getKeys()[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                this.L$0 = sequenceScope;
                this.I$0 = i;
                this.I$1 = size;
                this.label = 1;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                if (i < size) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
