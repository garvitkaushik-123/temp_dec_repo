package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J$\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0080\b¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, null);
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        int i;
        SnapshotIdSet snapshotIdSet;
        Function1 mergedWriteObserver;
        int i2;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            try {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet.set(i);
                SnapshotIdSet invalid$runtime_release = getInvalid();
                setInvalid$runtime_release(invalid$runtime_release.set(i));
                SnapshotIdSet addRange = SnapshotKt.addRange(invalid$runtime_release, getId() + 1, i);
                Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
                mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
                try {
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(i, addRange, mergedReadObserver$default, mergedWriteObserver, this);
                    if (!getApplied() && !getDisposed()) {
                        int id = getId();
                        synchronized (SnapshotKt.getLock()) {
                            i2 = SnapshotKt.nextSnapshotId;
                            SnapshotKt.nextSnapshotId = i2 + 1;
                            setId$runtime_release(i2);
                            snapshotIdSet2 = SnapshotKt.openSnapshots;
                            SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                            Unit unit = Unit.INSTANCE;
                        }
                        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
                    }
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3 A[LOOP:0: B:25:0x00d1->B:26:0x00d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2 A[LOOP:1: B:33:0x00f0->B:34:0x00f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        AtomicReference atomicReference;
        Function1 function1;
        IdentityArraySet<StateObject> modified$runtime_release;
        IdentityArraySet<StateObject> identityArraySet;
        IdentityArraySet<StateObject> identityArraySet2;
        int size;
        int i;
        int size2;
        int i2;
        AtomicReference atomicReference2;
        int i3;
        SnapshotIdSet snapshotIdSet;
        Function1 function12;
        AtomicReference atomicReference3;
        SnapshotIdSet snapshotIdSet2;
        AtomicReference atomicReference4;
        IdentityArraySet<StateObject> modified$runtime_release2 = getModified$runtime_release();
        if (modified$runtime_release2 != null) {
            atomicReference3 = SnapshotKt.currentGlobalSnapshot;
            MutableSnapshot mutableSnapshot = (MutableSnapshot) atomicReference3.get();
            snapshotIdSet2 = SnapshotKt.openSnapshots;
            atomicReference4 = SnapshotKt.currentGlobalSnapshot;
            map = SnapshotKt.optimisticMerges(mutableSnapshot, this, snapshotIdSet2.clear(((GlobalSnapshot) atomicReference4.get()).getId()));
        } else {
            map = null;
        }
        List emptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release2 != null && modified$runtime_release2.size() != 0) {
                atomicReference2 = SnapshotKt.currentGlobalSnapshot;
                GlobalSnapshot globalSnapshot = (GlobalSnapshot) atomicReference2.get();
                i3 = SnapshotKt.nextSnapshotId;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(i3, map, snapshotIdSet.clear(globalSnapshot.getId()));
                if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return innerApplyLocked$runtime_release;
                }
                closeLocked$runtime_release();
                function12 = SnapshotKt.emptyLambda;
                SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, function12);
                modified$runtime_release = globalSnapshot.getModified$runtime_release();
                setModified(null);
                globalSnapshot.setModified(null);
                emptyList = SnapshotKt.applyObservers;
                Unit unit = Unit.INSTANCE;
                this.applied = true;
                identityArraySet = modified$runtime_release;
                if (identityArraySet != null && !identityArraySet.isEmpty()) {
                    Intrinsics.checkNotNull(modified$runtime_release);
                    size2 = emptyList.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        ((Function2) emptyList.get(i2)).invoke(modified$runtime_release, this);
                    }
                }
                identityArraySet2 = modified$runtime_release2;
                if (identityArraySet2 != null && !identityArraySet2.isEmpty()) {
                    size = emptyList.size();
                    for (i = 0; i < size; i++) {
                        ((Function2) emptyList.get(i)).invoke(modified$runtime_release2, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    releasePinnedSnapshotsForCloseLocked$runtime_release();
                    SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                    if (modified$runtime_release != null) {
                        Object[] values = modified$runtime_release.getValues();
                        int size3 = modified$runtime_release.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            Object obj = values[i4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            SnapshotKt.processForUnusedRecordsLocked((StateObject) obj);
                        }
                    }
                    if (modified$runtime_release2 != null) {
                        Object[] values2 = modified$runtime_release2.getValues();
                        int size4 = modified$runtime_release2.size();
                        for (int i5 = 0; i5 < size4; i5++) {
                            Object obj2 = values2[i5];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            SnapshotKt.processForUnusedRecordsLocked((StateObject) obj2);
                        }
                    }
                    List<? extends StateObject> list = this.merged;
                    if (list != null) {
                        int size5 = list.size();
                        for (int i6 = 0; i6 < size5; i6++) {
                            SnapshotKt.processForUnusedRecordsLocked(list.get(i6));
                        }
                    }
                    this.merged = null;
                    Unit unit2 = Unit.INSTANCE;
                }
                return SnapshotApplyResult.Success.INSTANCE;
            }
            closeLocked$runtime_release();
            atomicReference = SnapshotKt.currentGlobalSnapshot;
            GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) atomicReference.get();
            function1 = SnapshotKt.emptyLambda;
            SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, function1);
            modified$runtime_release = globalSnapshot2.getModified$runtime_release();
            IdentityArraySet<StateObject> identityArraySet3 = modified$runtime_release;
            if (identityArraySet3 != null && !identityArraySet3.isEmpty()) {
                emptyList = SnapshotKt.applyObservers;
                Unit unit3 = Unit.INSTANCE;
                this.applied = true;
                identityArraySet = modified$runtime_release;
                if (identityArraySet != null) {
                    Intrinsics.checkNotNull(modified$runtime_release);
                    size2 = emptyList.size();
                    while (i2 < size2) {
                    }
                }
                identityArraySet2 = modified$runtime_release2;
                if (identityArraySet2 != null) {
                    size = emptyList.size();
                    while (i < size) {
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                }
            }
            modified$runtime_release = null;
            Unit unit32 = Unit.INSTANCE;
            this.applied = true;
            identityArraySet = modified$runtime_release;
            if (identityArraySet != null) {
            }
            identityArraySet2 = modified$runtime_release2;
            if (identityArraySet2 != null) {
            }
            synchronized (SnapshotKt.getLock()) {
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo3682nestedDeactivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        int i;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i2;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid(), id + 1, i), readObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo3681nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo3682nestedDeactivated$runtime_release(Snapshot snapshot) {
        int i = this.snapshots;
        if (i <= 0) {
            throw new IllegalArgumentException("no pending nested snapshots".toString());
        }
        int i2 = i - 1;
        this.snapshots = i2;
        if (i2 != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (this.applied) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (this.applied && ((Snapshot) this).pinningTrackingHandle < 0) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] values = modified$runtime_release.getValues();
            int size = modified$runtime_release.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                for (StateRecord firstStateRecord = ((StateObject) obj).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
                    if (firstStateRecord.getSnapshotId() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId()))) {
                        firstStateRecord.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0042, code lost:
    
        r15 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r11, getId(), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        StateRecord readable;
        SnapshotIdSet snapshotIdSet;
        StateRecord readable2;
        StateRecord readable3;
        StateRecord mergeRecords;
        SnapshotIdSet or = getInvalid().set(getId()).or(this.previousIds);
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (i < size) {
            Object obj = values[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            readable = SnapshotKt.readable(firstStateRecord, snapshotId, invalidSnapshots);
            if (readable == null || readable2 == null || Intrinsics.areEqual(readable, readable2)) {
                snapshotIdSet = or;
            } else {
                snapshotIdSet = or;
                readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid());
                if (readable3 == null) {
                    SnapshotKt.readError();
                    throw new KotlinNothingValueException();
                }
                if (optimisticMerges == null || (mergeRecords = optimisticMerges.get(readable)) == null) {
                    mergeRecords = stateObject.mergeRecords(readable2, readable, readable3);
                }
                if (mergeRecords == null) {
                    return new SnapshotApplyResult.Failure(this);
                }
                if (!Intrinsics.areEqual(mergeRecords, readable3)) {
                    if (Intrinsics.areEqual(mergeRecords, readable)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(TuplesKt.to(stateObject, readable.create()));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(stateObject);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(!Intrinsics.areEqual(mergeRecords, readable2) ? TuplesKt.to(stateObject, mergeRecords) : TuplesKt.to(stateObject, readable2.create()));
                    }
                }
            }
            i++;
            or = snapshotIdSet;
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Pair pair = (Pair) arrayList.get(i2);
                StateObject stateObject2 = (StateObject) pair.component1();
                StateRecord stateRecord = (StateRecord) pair.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (arrayList2 != null) {
            int size3 = arrayList2.size();
            for (int i3 = 0; i3 < size3; i3++) {
                modified$runtime_release.remove(arrayList2.get(i3));
            }
            List<? extends StateObject> list = this.merged;
            if (list != null) {
                arrayList2 = CollectionsKt.plus((Collection) list, (Iterable) arrayList2);
            }
            this.merged = arrayList2;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        int i;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        if (getApplied() || getDisposed()) {
            return invoke;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
            Unit unit = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
        return invoke;
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length != 0) {
            handles = ArraysKt.plus(iArr, handles);
        }
        this.previousPinnedSnapshots = handles;
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo3683recordModified$runtime_release(StateObject state) {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new IdentityArraySet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    /* compiled from: Snapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void advance$runtime_release() {
        int i;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
            Unit unit2 = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }
}
