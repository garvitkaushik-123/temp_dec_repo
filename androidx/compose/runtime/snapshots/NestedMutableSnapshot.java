package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(i, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo3681nestedActivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r3 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:11:0x0031, B:13:0x0039, B:16:0x0040, B:21:0x005a, B:23:0x0062, B:25:0x0076, B:27:0x007e, B:28:0x0083, B:33:0x006a, B:34:0x0073), top: B:10:0x0031 }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        if (this.parent.getApplied() || this.parent.getDisposed()) {
            return new SnapshotApplyResult.Failure(this);
        }
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        int id = getId();
        if (modified$runtime_release != null) {
            MutableSnapshot mutableSnapshot = this.parent;
            map = SnapshotKt.optimisticMerges(mutableSnapshot, this, mutableSnapshot.getInvalid());
        } else {
            map = null;
        }
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.validateOpen(this);
            if (modified$runtime_release != null && modified$runtime_release.size() != 0) {
                SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(this.parent.getId(), map, this.parent.getInvalid());
                if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return innerApplyLocked$runtime_release;
                }
                IdentityArraySet<StateObject> modified$runtime_release2 = this.parent.getModified$runtime_release();
                if (modified$runtime_release2 != null) {
                    modified$runtime_release2.addAll((Collection<? extends StateObject>) modified$runtime_release);
                }
                this.parent.setModified(modified$runtime_release);
                setModified(null);
                if (this.parent.getId() < id) {
                    this.parent.advance$runtime_release();
                }
                MutableSnapshot mutableSnapshot2 = this.parent;
                mutableSnapshot2.setInvalid$runtime_release(mutableSnapshot2.getInvalid().clear(id).andNot(getPreviousIds()));
                this.parent.recordPrevious$runtime_release(id);
                this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
                this.parent.recordPreviousList$runtime_release(getPreviousIds());
                this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots());
                Unit unit = Unit.INSTANCE;
                setApplied$runtime_release(true);
                deactivate();
                return SnapshotApplyResult.Success.INSTANCE;
            }
            closeAndReleasePinning$runtime_release();
            if (this.parent.getId() < id) {
            }
            MutableSnapshot mutableSnapshot22 = this.parent;
            mutableSnapshot22.setInvalid$runtime_release(mutableSnapshot22.getInvalid().clear(id).andNot(getPreviousIds()));
            this.parent.recordPrevious$runtime_release(id);
            this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
            this.parent.recordPreviousList$runtime_release(getPreviousIds());
            this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots());
            Unit unit2 = Unit.INSTANCE;
            setApplied$runtime_release(true);
            deactivate();
            return SnapshotApplyResult.Success.INSTANCE;
        }
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo3682nestedDeactivated$runtime_release(this);
    }
}
