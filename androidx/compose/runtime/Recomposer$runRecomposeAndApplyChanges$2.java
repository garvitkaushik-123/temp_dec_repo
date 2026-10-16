package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {540, 551}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "alreadyComposed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
/* loaded from: classes.dex */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00af  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0102 -> B:6:0x010a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0110 -> B:7:0x00a7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MonotonicFrameClock monotonicFrameClock;
        LinkedHashSet linkedHashSet;
        List list;
        IdentityArraySet identityArraySet;
        List list2;
        IdentityArraySet identityArraySet2;
        List list3;
        Set set;
        final Set set2;
        final List list4;
        final Set set3;
        final List list5;
        final List list6;
        final IdentityArraySet identityArraySet3;
        boolean recordComposerModifications;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            IdentityArraySet identityArraySet4 = new IdentityArraySet();
            list = arrayList;
            identityArraySet = new IdentityArraySet();
            list2 = arrayList2;
            identityArraySet2 = identityArraySet4;
            list3 = arrayList3;
            set = linkedHashSet2;
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
            }
        } else if (i == 1) {
            IdentityArraySet identityArraySet5 = (IdentityArraySet) this.L$7;
            identityArraySet2 = (IdentityArraySet) this.L$6;
            Set set4 = (Set) this.L$5;
            Set set5 = (Set) this.L$4;
            List list7 = (List) this.L$3;
            List list8 = (List) this.L$2;
            List list9 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            list5 = list8;
            list6 = list9;
            monotonicFrameClock = monotonicFrameClock2;
            set2 = set4;
            list4 = list7;
            identityArraySet3 = identityArraySet5;
            set3 = set5;
            final IdentityArraySet identityArraySet6 = identityArraySet2;
            recordComposerModifications = this.this$0.recordComposerModifications();
            if (recordComposerModifications) {
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            identityArraySet = (IdentityArraySet) this.L$7;
            identityArraySet2 = (IdentityArraySet) this.L$6;
            set = (Set) this.L$5;
            linkedHashSet = (Set) this.L$4;
            list3 = (List) this.L$3;
            list2 = (List) this.L$2;
            list = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = monotonicFrameClock3;
            this.this$0.discardUnusedValues();
            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                this.L$0 = monotonicFrameClock;
                this.L$1 = list;
                this.L$2 = list2;
                this.L$3 = list3;
                this.L$4 = linkedHashSet;
                this.L$5 = set;
                this.L$6 = identityArraySet2;
                this.L$7 = identityArraySet;
                this.label = 1;
                awaitWorkAvailable = this.this$0.awaitWorkAvailable(this);
                if (awaitWorkAvailable != coroutine_suspended) {
                    List list10 = list;
                    list5 = list2;
                    list6 = list10;
                    set2 = set;
                    set3 = linkedHashSet;
                    list4 = list3;
                    identityArraySet3 = identityArraySet;
                    final IdentityArraySet identityArraySet62 = identityArraySet2;
                    recordComposerModifications = this.this$0.recordComposerModifications();
                    if (recordComposerModifications) {
                        List list11 = list5;
                        list = list6;
                        list2 = list11;
                        identityArraySet2 = identityArraySet62;
                        identityArraySet = identityArraySet3;
                        linkedHashSet = set3;
                        list3 = list4;
                        set = set2;
                        shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                        if (!shouldKeepRecomposing) {
                        }
                    } else {
                        final Recomposer recomposer = this.this$0;
                        this.L$0 = monotonicFrameClock;
                        this.L$1 = list6;
                        this.L$2 = list5;
                        this.L$3 = list4;
                        this.L$4 = set3;
                        this.L$5 = set2;
                        this.L$6 = identityArraySet62;
                        this.L$7 = identityArraySet3;
                        this.label = 2;
                        if (monotonicFrameClock.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j) {
                                boolean hasBroadcastFrameClockAwaiters;
                                Object beginSection;
                                List<ControlledComposition> list12;
                                List performInsertValues;
                                ControlledComposition performRecompose;
                                List<ControlledComposition> list13;
                                BroadcastFrameClock broadcastFrameClock;
                                hasBroadcastFrameClockAwaiters = Recomposer.this.getHasBroadcastFrameClockAwaiters();
                                if (hasBroadcastFrameClockAwaiters) {
                                    Recomposer recomposer2 = Recomposer.this;
                                    beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
                                    try {
                                        broadcastFrameClock = recomposer2.broadcastFrameClock;
                                        broadcastFrameClock.sendFrame(j);
                                        Snapshot.INSTANCE.sendApplyNotifications();
                                        Unit unit = Unit.INSTANCE;
                                    } finally {
                                    }
                                }
                                Recomposer recomposer3 = Recomposer.this;
                                IdentityArraySet<Object> identityArraySet7 = identityArraySet62;
                                IdentityArraySet<ControlledComposition> identityArraySet8 = identityArraySet3;
                                List<ControlledComposition> list14 = list6;
                                List<MovableContentStateReference> list15 = list5;
                                Set<ControlledComposition> set6 = set3;
                                List<ControlledComposition> list16 = list4;
                                Set<ControlledComposition> set7 = set2;
                                beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                try {
                                    recomposer3.recordComposerModifications();
                                    synchronized (recomposer3.stateLock) {
                                        List list17 = recomposer3.compositionInvalidations;
                                        int size = list17.size();
                                        for (int i2 = 0; i2 < size; i2++) {
                                            list14.add((ControlledComposition) list17.get(i2));
                                        }
                                        recomposer3.compositionInvalidations.clear();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    identityArraySet7.clear();
                                    identityArraySet8.clear();
                                    while (true) {
                                        if (list14.isEmpty() && list15.isEmpty()) {
                                            break;
                                        }
                                        try {
                                            try {
                                                int size2 = list14.size();
                                                for (int i3 = 0; i3 < size2; i3++) {
                                                    ControlledComposition controlledComposition = list14.get(i3);
                                                    identityArraySet8.add(controlledComposition);
                                                    performRecompose = recomposer3.performRecompose(controlledComposition, identityArraySet7);
                                                    if (performRecompose != null) {
                                                        list16.add(performRecompose);
                                                    }
                                                }
                                                list14.clear();
                                                if (identityArraySet7.isNotEmpty()) {
                                                    synchronized (recomposer3.stateLock) {
                                                        List knownCompositions = recomposer3.getKnownCompositions();
                                                        int size3 = knownCompositions.size();
                                                        for (int i4 = 0; i4 < size3; i4++) {
                                                            ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositions.get(i4);
                                                            if (!identityArraySet8.contains(controlledComposition2) && controlledComposition2.observesAnyOf(identityArraySet7)) {
                                                                list14.add(controlledComposition2);
                                                            }
                                                        }
                                                        Unit unit3 = Unit.INSTANCE;
                                                    }
                                                }
                                                if (list14.isEmpty()) {
                                                    try {
                                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list15, recomposer3);
                                                        while (!list15.isEmpty()) {
                                                            performInsertValues = recomposer3.performInsertValues(list15, identityArraySet7);
                                                            CollectionsKt.addAll(set6, performInsertValues);
                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list15, recomposer3);
                                                        }
                                                    } catch (Exception e) {
                                                        Recomposer.processCompositionError$default(recomposer3, e, null, true, 2, null);
                                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list14, list15, list16, set6, set7, identityArraySet7, identityArraySet8);
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                Recomposer.processCompositionError$default(recomposer3, e2, null, true, 2, null);
                                                list12 = list14;
                                                try {
                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list12, list15, list16, set6, set7, identityArraySet7, identityArraySet8);
                                                    list12.clear();
                                                } catch (Throwable th) {
                                                    th = th;
                                                    list12.clear();
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            list12 = list14;
                                            list12.clear();
                                            throw th;
                                        }
                                    }
                                    if (!list16.isEmpty()) {
                                        recomposer3.changeCount = recomposer3.getChangeCount() + 1;
                                        try {
                                            try {
                                                int size4 = list16.size();
                                                for (int i5 = 0; i5 < size4; i5++) {
                                                    set7.add(list16.get(i5));
                                                }
                                                int size5 = list16.size();
                                                for (int i6 = 0; i6 < size5; i6++) {
                                                    list16.get(i6).applyChanges();
                                                }
                                                list16.clear();
                                            } catch (Exception e3) {
                                                Recomposer.processCompositionError$default(recomposer3, e3, null, false, 6, null);
                                                try {
                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list14, list15, list16, set6, set7, identityArraySet7, identityArraySet8);
                                                    list16.clear();
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    list13 = list16;
                                                    list13.clear();
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            list13 = list16;
                                            list13.clear();
                                            throw th;
                                        }
                                    }
                                    if (!set6.isEmpty()) {
                                        try {
                                            try {
                                                CollectionsKt.addAll(set7, set6);
                                                Iterator<T> it = set6.iterator();
                                                while (it.hasNext()) {
                                                    ((ControlledComposition) it.next()).applyLateChanges();
                                                }
                                                set6.clear();
                                            } catch (Exception e4) {
                                                Recomposer.processCompositionError$default(recomposer3, e4, null, false, 6, null);
                                                try {
                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list14, list15, list16, set6, set7, identityArraySet7, identityArraySet8);
                                                    set6.clear();
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    set6 = set6;
                                                    set6.clear();
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            set6.clear();
                                            throw th;
                                        }
                                    }
                                    if (!set7.isEmpty()) {
                                        try {
                                            try {
                                                Iterator<T> it2 = set7.iterator();
                                                while (it2.hasNext()) {
                                                    ((ControlledComposition) it2.next()).changesApplied();
                                                }
                                                set7.clear();
                                            } catch (Exception e5) {
                                                Recomposer.processCompositionError$default(recomposer3, e5, null, false, 6, null);
                                                try {
                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list14, list15, list16, set6, set7, identityArraySet7, identityArraySet8);
                                                    set7.clear();
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    set7 = set7;
                                                    set7.clear();
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            set7.clear();
                                            throw th;
                                        }
                                    }
                                    synchronized (recomposer3.stateLock) {
                                        recomposer3.deriveStateLocked();
                                    }
                                    Snapshot.INSTANCE.notifyObjectsInitialized();
                                    identityArraySet8.clear();
                                    identityArraySet7.clear();
                                    recomposer3.compositionsRemoved = null;
                                    Unit unit4 = Unit.INSTANCE;
                                } finally {
                                }
                            }
                        }, this) != coroutine_suspended) {
                            List list12 = list5;
                            list = list6;
                            list2 = list12;
                            identityArraySet2 = identityArraySet62;
                            identityArraySet = identityArraySet3;
                            linkedHashSet = set3;
                            list3 = list4;
                            set = set2;
                            this.this$0.discardUnusedValues();
                            shouldKeepRecomposing = this.this$0.getShouldKeepRecomposing();
                            if (!shouldKeepRecomposing) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2, IdentityArraySet<Object> identityArraySet, IdentityArraySet<ControlledComposition> identityArraySet2) {
        list.clear();
        list2.clear();
        list3.clear();
        set.clear();
        set2.clear();
        identityArraySet.clear();
        identityArraySet2.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        List list2;
        List list3;
        list.clear();
        synchronized (recomposer.stateLock) {
            list2 = recomposer.compositionValuesAwaitingInsert;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) list2.get(i));
            }
            list3 = recomposer.compositionValuesAwaitingInsert;
            list3.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
