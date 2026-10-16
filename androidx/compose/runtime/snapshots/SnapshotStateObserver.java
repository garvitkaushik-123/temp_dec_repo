package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SnapshotStateObserver.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
            boolean drainChanges;
            SnapshotStateObserver.this.addChanges(set);
            drainChanges = SnapshotStateObserver.this.drainChanges();
            if (drainChanges) {
                SnapshotStateObserver.this.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            boolean z;
            MutableVector mutableVector;
            SnapshotStateObserver.ObservedScopeMap observedScopeMap;
            z = SnapshotStateObserver.this.isPaused;
            if (z) {
                return;
            }
            mutableVector = SnapshotStateObserver.this.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
            synchronized (mutableVector) {
                observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> removeChanges = removeChanges();
            if (removeChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        if (!content[i].recordInvalidation(removeChanges) && !z2) {
                            z2 = false;
                            i++;
                        }
                        z2 = true;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableVector mutableVector;
                boolean z;
                boolean drainChanges;
                MutableVector mutableVector2;
                do {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        z = snapshotStateObserver.sendingNotifications;
                        if (!z) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size > 0) {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((SnapshotStateObserver.ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } finally {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    drainChanges = SnapshotStateObserver.this.drainChanges();
                } while (drainChanges);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List plus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                plus = set;
            } else if (obj instanceof Set) {
                plus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                plus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, plus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object obj2;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    block.invoke(content[i]);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (block.invoke(mutableVector.getContent()[i2]).booleanValue()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap ensureMap;
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(onValueChangedForScope);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1 && j != ActualJvm_jvmKt.currentThreadId()) {
            throw new IllegalArgumentException(("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.").toString());
        }
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            this.currentMapThreadId = Thread.currentThread().getId();
            ensureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i = 0;
            do {
                observedScopeMap = content[i];
                if (observedScopeMap.getOnChanged() == onChanged) {
                    break;
                }
                i++;
            } while (i < size);
        }
        observedScopeMap = null;
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final ScopeMap<Object> valueToScopes = new ScopeMap<>();
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                int i;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                i = observedScopeMap.deriveStateScopeCount;
                observedScopeMap.deriveStateScopeCount = i + 1;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                int i;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                i = observedScopeMap.deriveStateScopeCount;
                observedScopeMap.deriveStateScopeCount = i - 1;
            }
        };
        private final ScopeMap<DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            int i2 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.scopeToValues = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, obj, mutableObjectIntMap);
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i;
            int i2;
            int i3;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int put = recordedValues.put(value, currentToken, -1);
            int i4 = 2;
            if (!(value instanceof DerivedState) || put == currentToken) {
                i = 2;
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                ScopeMap<DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    i3 = i4;
                                    StateObject stateObject = (StateObject) objArr[(i5 << 3) + i7];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        ((StateObjectImpl) stateObject).m3698recordReadInh_f27i8$runtime_release(ReaderKind.m3685constructorimpl(i3));
                                    }
                                    scopeMap.add(stateObject, value);
                                } else {
                                    i3 = i4;
                                }
                                j >>= 8;
                                i7++;
                                i4 = i3;
                            }
                            i = i4;
                            if (i6 != 8) {
                                break;
                            }
                        } else {
                            i = i4;
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        i4 = i;
                    }
                } else {
                    i = 2;
                }
                i2 = -1;
            }
            if (put == i2) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m3698recordReadInh_f27i8$runtime_release(ReaderKind.m3685constructorimpl(i));
                }
                this.valueToScopes.add(value, currentScope);
            }
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Object obj = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                derivedStateObservers.add(derivedStateObserver);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(scope, obj);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> remove = this.scopeToValues.remove(scope);
            if (remove == null) {
                return;
            }
            MutableObjectIntMap<Object> mutableObjectIntMap = remove;
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(scope, obj);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            long j3;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j4 = jArr3[i2];
                char c2 = 7;
                long j5 = -9187201950435737472L;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j4 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j5;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            Boolean invoke = predicate.invoke(obj);
                            if (invoke.booleanValue()) {
                                MutableObjectIntMap mutableObjectIntMap2 = mutableObjectIntMap;
                                Object[] objArr = mutableObjectIntMap2.keys;
                                int[] iArr = mutableObjectIntMap2.values;
                                long[] jArr4 = mutableObjectIntMap2.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j4;
                                    int i8 = 0;
                                    while (true) {
                                        long j6 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j6) << c) & j6 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j6 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    j3 = j6;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                } else {
                                                    j3 = j6;
                                                }
                                                j6 = j3 >> i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                        }
                                        if (i8 == length2) {
                                            break;
                                        }
                                        i8++;
                                        jArr4 = jArr5;
                                        i7 = 8;
                                    }
                                    if (invoke.booleanValue()) {
                                        mutableScatterMap.removeValueAt(i6);
                                    }
                                    i = 8;
                                }
                            }
                            jArr2 = jArr3;
                            j = j4;
                            if (invoke.booleanValue()) {
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j4;
                            c = c2;
                            j2 = j5;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j4 = j >> i;
                        c2 = c;
                        j5 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if (!(value instanceof DerivedState) || this.valueToScopes.contains(value)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:222:0x04c4  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0251  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x02a1 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z;
            Iterator it;
            String str;
            Object obj;
            int i;
            Object obj2;
            long[] jArr;
            Object[] objArr;
            Iterator it2;
            ScopeMap<DerivedState<?>> scopeMap;
            long[] jArr2;
            String str2;
            Object[] objArr2;
            long j;
            long[] jArr3;
            int i2;
            long[] jArr4;
            char c;
            int i3;
            ScopeMap<DerivedState<?>> scopeMap2;
            ScopeMap<Object> scopeMap3;
            Object[] objArr3;
            int i4;
            int i5;
            long j2;
            Object obj3;
            int i6;
            Object obj4;
            int i7;
            ScopeMap<DerivedState<?>> scopeMap4;
            ScopeMap<Object> scopeMap5;
            Object[] objArr4;
            long j3;
            int i8;
            ScopeMap<DerivedState<?>> scopeMap6 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> hashMap = this.recordedDerivedStateValues;
            ScopeMap<Object> scopeMap7 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str3 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i9 = 2;
            int i10 = 0;
            if (changes instanceof IdentityArraySet) {
                IdentityArraySet identityArraySet = (IdentityArraySet) changes;
                Object[] values = identityArraySet.getValues();
                int size = identityArraySet.size();
                int i11 = 0;
                z = false;
                while (i11 < size) {
                    Object obj5 = values[i11];
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (obj5 instanceof StateObjectImpl) {
                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                        c = 7;
                        if (!((StateObjectImpl) obj5).m3697isReadInh_f27i8$runtime_release(ReaderKind.m3685constructorimpl(i9))) {
                            i3 = size;
                            scopeMap2 = scopeMap6;
                            scopeMap3 = scopeMap7;
                            objArr3 = values;
                            i4 = i11;
                            i5 = i9;
                            i11 = i4 + 1;
                            i9 = i5;
                            size = i3;
                            scopeMap6 = scopeMap2;
                            scopeMap7 = scopeMap3;
                            values = objArr3;
                        }
                    } else {
                        c = 7;
                    }
                    if (!scopeMap6.contains(obj5) || (obj4 = scopeMap6.getMap().get(obj5)) == null) {
                        i3 = size;
                        scopeMap2 = scopeMap6;
                        scopeMap3 = scopeMap7;
                        objArr3 = values;
                        i4 = i11;
                        i5 = i9;
                    } else {
                        if (obj4 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj4;
                            Object[] objArr5 = mutableScatterSet2.elements;
                            long[] jArr5 = mutableScatterSet2.metadata;
                            i5 = i9;
                            int length = jArr5.length - 2;
                            if (length >= 0) {
                                i4 = i11;
                                int i12 = 0;
                                j2 = -9187201950435737472L;
                                while (true) {
                                    int i13 = 8;
                                    long j4 = jArr5[i12];
                                    long[] jArr6 = jArr5;
                                    Object[] objArr6 = objArr5;
                                    if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i14 = 8 - ((~(i12 - length)) >>> 31);
                                        int i15 = 0;
                                        while (i15 < i14) {
                                            if ((j4 & 255) < 128) {
                                                int i16 = i13;
                                                DerivedState<?> derivedState = (DerivedState) objArr6[(i12 << 3) + i15];
                                                Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                i7 = size;
                                                Object obj6 = hashMap.get(derivedState);
                                                SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                if (policy == null) {
                                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                                }
                                                scopeMap5 = scopeMap7;
                                                objArr4 = values;
                                                if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj6)) {
                                                    scopeMap4 = scopeMap6;
                                                    j3 = j4;
                                                    this.statesToReread.add(derivedState);
                                                } else {
                                                    Object obj7 = scopeMap5.getMap().get(derivedState);
                                                    if (obj7 != null) {
                                                        if (obj7 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj7;
                                                            Object[] objArr7 = mutableScatterSet3.elements;
                                                            long[] jArr7 = mutableScatterSet3.metadata;
                                                            int length2 = jArr7.length - 2;
                                                            if (length2 >= 0) {
                                                                j3 = j4;
                                                                int i17 = 0;
                                                                while (true) {
                                                                    long j5 = jArr7[i17];
                                                                    long[] jArr8 = jArr7;
                                                                    scopeMap4 = scopeMap6;
                                                                    if ((((~j5) << c) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i18 = 8 - ((~(i17 - length2)) >>> 31);
                                                                        int i19 = 0;
                                                                        while (i19 < i18) {
                                                                            if ((j5 & 255) < 128) {
                                                                                i8 = i19;
                                                                                mutableScatterSet.add(objArr7[(i17 << 3) + i19]);
                                                                                z = true;
                                                                            } else {
                                                                                i8 = i19;
                                                                            }
                                                                            j5 >>= i16;
                                                                            i19 = i8 + 1;
                                                                        }
                                                                        if (i18 != i16) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (i17 == length2) {
                                                                        break;
                                                                    }
                                                                    i17++;
                                                                    scopeMap6 = scopeMap4;
                                                                    jArr7 = jArr8;
                                                                    i16 = 8;
                                                                }
                                                            }
                                                        } else {
                                                            scopeMap4 = scopeMap6;
                                                            j3 = j4;
                                                            mutableScatterSet.add(obj7);
                                                            z = true;
                                                        }
                                                    }
                                                    scopeMap4 = scopeMap6;
                                                    j3 = j4;
                                                }
                                                i13 = 8;
                                            } else {
                                                i7 = size;
                                                scopeMap4 = scopeMap6;
                                                scopeMap5 = scopeMap7;
                                                objArr4 = values;
                                                j3 = j4;
                                            }
                                            j4 = j3 >> i13;
                                            i15++;
                                            size = i7;
                                            scopeMap6 = scopeMap4;
                                            scopeMap7 = scopeMap5;
                                            values = objArr4;
                                        }
                                        i3 = size;
                                        scopeMap2 = scopeMap6;
                                        scopeMap3 = scopeMap7;
                                        objArr3 = values;
                                        if (i14 != i13) {
                                            break;
                                        }
                                    } else {
                                        i3 = size;
                                        scopeMap2 = scopeMap6;
                                        scopeMap3 = scopeMap7;
                                        objArr3 = values;
                                    }
                                    if (i12 == length) {
                                        break;
                                    }
                                    i12++;
                                    objArr5 = objArr6;
                                    jArr5 = jArr6;
                                    size = i3;
                                    scopeMap6 = scopeMap2;
                                    scopeMap7 = scopeMap3;
                                    values = objArr3;
                                }
                            } else {
                                i3 = size;
                                scopeMap2 = scopeMap6;
                                scopeMap3 = scopeMap7;
                                objArr3 = values;
                                i4 = i11;
                            }
                        } else {
                            i3 = size;
                            scopeMap2 = scopeMap6;
                            scopeMap3 = scopeMap7;
                            objArr3 = values;
                            i4 = i11;
                            i5 = i9;
                            j2 = -9187201950435737472L;
                            DerivedState<?> derivedState2 = (DerivedState) obj4;
                            Object obj8 = hashMap.get(derivedState2);
                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                            if (policy2 == null) {
                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj8)) {
                                this.statesToReread.add(derivedState2);
                            } else {
                                Object obj9 = scopeMap3.getMap().get(derivedState2);
                                if (obj9 != null) {
                                    if (obj9 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj9;
                                        Object[] objArr8 = mutableScatterSet4.elements;
                                        long[] jArr9 = mutableScatterSet4.metadata;
                                        int length3 = jArr9.length - 2;
                                        if (length3 >= 0) {
                                            int i20 = 0;
                                            while (true) {
                                                long j6 = jArr9[i20];
                                                if ((((~j6) << c) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i21 = 8 - ((~(i20 - length3)) >>> 31);
                                                    for (int i22 = 0; i22 < i21; i22++) {
                                                        if ((j6 & 255) < 128) {
                                                            mutableScatterSet.add(objArr8[(i20 << 3) + i22]);
                                                            z = true;
                                                        }
                                                        j6 >>= 8;
                                                    }
                                                    if (i21 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i20 == length3) {
                                                    break;
                                                }
                                                i20++;
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.add(obj9);
                                        z = true;
                                    }
                                }
                            }
                        }
                        obj3 = scopeMap3.getMap().get(obj5);
                        if (obj3 != null) {
                            if (obj3 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj3;
                                Object[] objArr9 = mutableScatterSet5.elements;
                                long[] jArr10 = mutableScatterSet5.metadata;
                                int length4 = jArr10.length - 2;
                                if (length4 >= 0) {
                                    while (true) {
                                        long j7 = jArr10[i6];
                                        if ((((~j7) << c) & j7 & j2) != j2) {
                                            int i23 = 8 - ((~(i6 - length4)) >>> 31);
                                            for (int i24 = 0; i24 < i23; i24++) {
                                                if ((j7 & 255) < 128) {
                                                    mutableScatterSet.add(objArr9[(i6 << 3) + i24]);
                                                    z = true;
                                                }
                                                j7 >>= 8;
                                            }
                                            if (i23 != 8) {
                                                break;
                                            }
                                        }
                                        i6 = i6 != length4 ? i6 + 1 : 0;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj3);
                                z = true;
                            }
                        }
                        i11 = i4 + 1;
                        i9 = i5;
                        size = i3;
                        scopeMap6 = scopeMap2;
                        scopeMap7 = scopeMap3;
                        values = objArr3;
                    }
                    j2 = -9187201950435737472L;
                    obj3 = scopeMap3.getMap().get(obj5);
                    if (obj3 != null) {
                    }
                    i11 = i4 + 1;
                    i9 = i5;
                    size = i3;
                    scopeMap6 = scopeMap2;
                    scopeMap7 = scopeMap3;
                    values = objArr3;
                }
            } else {
                ScopeMap<DerivedState<?>> scopeMap8 = scopeMap6;
                Iterator it3 = changes.iterator();
                z = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (next instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (!((StateObjectImpl) next).m3697isReadInh_f27i8$runtime_release(ReaderKind.m3685constructorimpl(2))) {
                            it = it3;
                            str = str3;
                            it3 = it;
                            str3 = str;
                        }
                    }
                    ScopeMap<DerivedState<?>> scopeMap9 = scopeMap8;
                    if (scopeMap9.contains(next) && (obj2 = scopeMap9.getMap().get(next)) != null) {
                        if (obj2 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj2;
                            Object[] objArr10 = mutableScatterSet6.elements;
                            long[] jArr11 = mutableScatterSet6.metadata;
                            int length5 = jArr11.length - 2;
                            if (length5 >= 0) {
                                int i25 = 0;
                                while (true) {
                                    long j8 = jArr11[i25];
                                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i26 = 8 - ((~(i25 - length5)) >>> 31);
                                        int i27 = 0;
                                        while (i27 < i26) {
                                            if ((j8 & 255) < 128) {
                                                DerivedState<?> derivedState3 = (DerivedState) objArr10[(i25 << 3) + i27];
                                                Intrinsics.checkNotNull(derivedState3, str3);
                                                it2 = it3;
                                                Object obj10 = hashMap.get(derivedState3);
                                                SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                if (policy3 == null) {
                                                    policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                }
                                                scopeMap = scopeMap9;
                                                jArr2 = jArr11;
                                                if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj10)) {
                                                    str2 = str3;
                                                    objArr2 = objArr10;
                                                    j = j8;
                                                    this.statesToReread.add(derivedState3);
                                                } else {
                                                    Object obj11 = scopeMap7.getMap().get(derivedState3);
                                                    if (obj11 != null) {
                                                        if (obj11 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj11;
                                                            Object[] objArr11 = mutableScatterSet7.elements;
                                                            long[] jArr12 = mutableScatterSet7.metadata;
                                                            int length6 = jArr12.length - 2;
                                                            if (length6 >= 0) {
                                                                str2 = str3;
                                                                objArr2 = objArr10;
                                                                int i28 = 0;
                                                                while (true) {
                                                                    long j9 = jArr12[i28];
                                                                    j = j8;
                                                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i29 = 8 - ((~(i28 - length6)) >>> 31);
                                                                        i2 = i28;
                                                                        int i30 = 0;
                                                                        while (i30 < i29) {
                                                                            if ((j9 & 255) < 128) {
                                                                                jArr4 = jArr12;
                                                                                mutableScatterSet.add(objArr11[(i2 << 3) + i30]);
                                                                                z = true;
                                                                            } else {
                                                                                jArr4 = jArr12;
                                                                            }
                                                                            j9 >>= 8;
                                                                            i30++;
                                                                            jArr12 = jArr4;
                                                                        }
                                                                        jArr3 = jArr12;
                                                                        if (i29 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr12;
                                                                        i2 = i28;
                                                                    }
                                                                    if (i2 != length6) {
                                                                        i28 = i2 + 1;
                                                                        j8 = j;
                                                                        jArr12 = jArr3;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            str2 = str3;
                                                            objArr2 = objArr10;
                                                            j = j8;
                                                            mutableScatterSet.add(obj11);
                                                            z = true;
                                                        }
                                                    }
                                                }
                                                j8 = j >> 8;
                                                i27++;
                                                it3 = it2;
                                                str3 = str2;
                                                jArr11 = jArr2;
                                                objArr10 = objArr2;
                                                scopeMap9 = scopeMap;
                                            } else {
                                                it2 = it3;
                                                scopeMap = scopeMap9;
                                                jArr2 = jArr11;
                                            }
                                            str2 = str3;
                                            objArr2 = objArr10;
                                            j = j8;
                                            j8 = j >> 8;
                                            i27++;
                                            it3 = it2;
                                            str3 = str2;
                                            jArr11 = jArr2;
                                            objArr10 = objArr2;
                                            scopeMap9 = scopeMap;
                                        }
                                        it = it3;
                                        scopeMap8 = scopeMap9;
                                        jArr = jArr11;
                                        str = str3;
                                        objArr = objArr10;
                                        if (i26 != 8) {
                                            break;
                                        }
                                    } else {
                                        it = it3;
                                        scopeMap8 = scopeMap9;
                                        jArr = jArr11;
                                        str = str3;
                                        objArr = objArr10;
                                    }
                                    if (i25 == length5) {
                                        break;
                                    }
                                    i25++;
                                    it3 = it;
                                    str3 = str;
                                    jArr11 = jArr;
                                    objArr10 = objArr;
                                    scopeMap9 = scopeMap8;
                                }
                            }
                        } else {
                            it = it3;
                            scopeMap8 = scopeMap9;
                            str = str3;
                            DerivedState<?> derivedState4 = (DerivedState) obj2;
                            Object obj12 = hashMap.get(derivedState4);
                            SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                            if (policy4 == null) {
                                policy4 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj12)) {
                                this.statesToReread.add(derivedState4);
                            } else {
                                Object obj13 = scopeMap7.getMap().get(derivedState4);
                                if (obj13 != null) {
                                    if (obj13 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj13;
                                        Object[] objArr12 = mutableScatterSet8.elements;
                                        long[] jArr13 = mutableScatterSet8.metadata;
                                        int length7 = jArr13.length - 2;
                                        if (length7 >= 0) {
                                            int i31 = 0;
                                            while (true) {
                                                long j10 = jArr13[i31];
                                                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i32 = 8 - ((~(i31 - length7)) >>> 31);
                                                    for (int i33 = 0; i33 < i32; i33++) {
                                                        if ((j10 & 255) < 128) {
                                                            mutableScatterSet.add(objArr12[(i31 << 3) + i33]);
                                                            z = true;
                                                        }
                                                        j10 >>= 8;
                                                    }
                                                    if (i32 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i31 == length7) {
                                                    break;
                                                }
                                                i31++;
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.add(obj13);
                                        z = true;
                                    }
                                }
                            }
                        }
                        obj = scopeMap7.getMap().get(next);
                        if (obj != null) {
                            if (obj instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj;
                                Object[] objArr13 = mutableScatterSet9.elements;
                                long[] jArr14 = mutableScatterSet9.metadata;
                                int length8 = jArr14.length - 2;
                                if (length8 >= 0) {
                                    while (true) {
                                        long j11 = jArr14[i];
                                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i34 = 8 - ((~(i - length8)) >>> 31);
                                            for (int i35 = 0; i35 < i34; i35++) {
                                                if ((j11 & 255) < 128) {
                                                    mutableScatterSet.add(objArr13[(i << 3) + i35]);
                                                    z = true;
                                                }
                                                j11 >>= 8;
                                            }
                                            if (i34 != 8) {
                                                break;
                                            }
                                        }
                                        i = i != length8 ? i + 1 : 0;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj);
                                z = true;
                            }
                            it3 = it;
                            str3 = str;
                        }
                        it3 = it;
                        str3 = str;
                    }
                    it = it3;
                    scopeMap8 = scopeMap9;
                    str = str3;
                    obj = scopeMap7.getMap().get(next);
                    if (obj != null) {
                    }
                    it3 = it;
                    str3 = str;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size2 = mutableVector.getSize();
                if (size2 > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    while (true) {
                        rereadDerivedState(content[i10]);
                        int i36 = i10 + 1;
                        if (i36 >= size2) {
                            break;
                        }
                        i10 = i36;
                    }
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(0, 1, null);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr3 = mutableScatterSet.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr3[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            i = i3;
                            Object obj2 = objArr[(i2 << 3) + i5];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            jArr2 = jArr3;
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, id, obj2, mutableObjectIntMap);
                        } else {
                            jArr2 = jArr3;
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] objArr = mutableScatterSet2.elements;
            long[] jArr = mutableScatterSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                observedScopeMap.clearScopeObservations(scope);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                observedScopeMap.removeScopeIf(predicate);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
