package com.bytedance.adsdk.DbA.eli.DbA;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class eli<K, A> {
    protected com.bytedance.adsdk.DbA.kb.DbA<A> Os;
    private final Os<K> ui;
    final List<InterfaceC0115eli> eli = new ArrayList(1);
    private boolean aGH = false;
    protected float DbA = 0.0f;
    private A MGA = null;
    private float kb = -1.0f;
    private float wC = -1.0f;

    private interface Os<T> {
        com.bytedance.adsdk.DbA.kb.eli<T> DbA();

        boolean DbA(float f);

        float Os();

        float aGH();

        boolean eli();

        boolean eli(float f);
    }

    /* renamed from: com.bytedance.adsdk.DbA.eli.DbA.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0115eli {
        void eli();
    }

    abstract A eli(com.bytedance.adsdk.DbA.kb.eli<K> eliVar, float f);

    eli(List<? extends com.bytedance.adsdk.DbA.kb.eli<K>> list) {
        this.ui = eli(list);
    }

    public void eli() {
        this.aGH = true;
    }

    public void eli(InterfaceC0115eli interfaceC0115eli) {
        this.eli.add(interfaceC0115eli);
    }

    public void eli(float f) {
        if (this.ui.eli()) {
            return;
        }
        if (f < FC()) {
            f = FC();
        } else if (f > MGA()) {
            f = MGA();
        }
        if (f == this.DbA) {
            return;
        }
        this.DbA = f;
        if (this.ui.eli(f)) {
            DbA();
        }
    }

    public void DbA() {
        for (int i = 0; i < this.eli.size(); i++) {
            this.eli.get(i).eli();
        }
    }

    protected com.bytedance.adsdk.DbA.kb.eli<K> Os() {
        com.bytedance.adsdk.DbA.ui.eli("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.DbA.kb.eli<K> DbA2 = this.ui.DbA();
        com.bytedance.adsdk.DbA.ui.DbA("BaseKeyframeAnimation#getCurrentKeyframe");
        return DbA2;
    }

    float aGH() {
        if (this.aGH) {
            return 0.0f;
        }
        com.bytedance.adsdk.DbA.kb.eli<K> Os2 = Os();
        if (Os2.ui()) {
            return 0.0f;
        }
        return (this.DbA - Os2.Os()) / (Os2.aGH() - Os2.Os());
    }

    protected float ui() {
        com.bytedance.adsdk.DbA.kb.eli<K> Os2 = Os();
        if (Os2 == null || Os2.ui()) {
            return 0.0f;
        }
        return Os2.Os.getInterpolation(aGH());
    }

    private float FC() {
        if (this.kb == -1.0f) {
            this.kb = this.ui.Os();
        }
        return this.kb;
    }

    float MGA() {
        if (this.wC == -1.0f) {
            this.wC = this.ui.aGH();
        }
        return this.wC;
    }

    public A kb() {
        A eli;
        float aGH2 = aGH();
        if (this.Os == null && this.ui.DbA(aGH2)) {
            return this.MGA;
        }
        com.bytedance.adsdk.DbA.kb.eli<K> Os2 = Os();
        if (Os2.aGH != null && Os2.ui != null) {
            eli = eli(Os2, aGH2, Os2.aGH.getInterpolation(aGH2), Os2.ui.getInterpolation(aGH2));
        } else {
            eli = eli(Os2, ui());
        }
        this.MGA = eli;
        return eli;
    }

    public float wC() {
        return this.DbA;
    }

    protected A eli(com.bytedance.adsdk.DbA.kb.eli<K> eliVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> Os<T> eli(List<? extends com.bytedance.adsdk.DbA.kb.eli<T>> list) {
        if (list.isEmpty()) {
            return new DbA();
        }
        if (list.size() == 1) {
            return new ui(list);
        }
        return new aGH(list);
    }

    private static final class DbA<T> implements Os<T> {
        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float Os() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float aGH() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli() {
            return true;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli(float f) {
            return false;
        }

        private DbA() {
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public com.bytedance.adsdk.DbA.kb.eli<T> DbA() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean DbA(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class ui<T> implements Os<T> {
        private float DbA = -1.0f;
        private final com.bytedance.adsdk.DbA.kb.eli<T> eli;

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli() {
            return false;
        }

        ui(List<? extends com.bytedance.adsdk.DbA.kb.eli<T>> list) {
            this.eli = list.get(0);
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli(float f) {
            return !this.eli.ui();
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public com.bytedance.adsdk.DbA.kb.eli<T> DbA() {
            return this.eli;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float Os() {
            return this.eli.Os();
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float aGH() {
            return this.eli.aGH();
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean DbA(float f) {
            if (this.DbA == f) {
                return true;
            }
            this.DbA = f;
            return false;
        }
    }

    private static final class aGH<T> implements Os<T> {
        private final List<? extends com.bytedance.adsdk.DbA.kb.eli<T>> eli;
        private com.bytedance.adsdk.DbA.kb.eli<T> Os = null;
        private float aGH = -1.0f;
        private com.bytedance.adsdk.DbA.kb.eli<T> DbA = Os(0.0f);

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli() {
            return false;
        }

        aGH(List<? extends com.bytedance.adsdk.DbA.kb.eli<T>> list) {
            this.eli = list;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean eli(float f) {
            if (this.DbA.eli(f)) {
                return !this.DbA.ui();
            }
            this.DbA = Os(f);
            return true;
        }

        private com.bytedance.adsdk.DbA.kb.eli<T> Os(float f) {
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar = this.eli.get(r0.size() - 1);
            if (f >= eliVar.Os()) {
                return eliVar;
            }
            for (int size = this.eli.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.DbA.kb.eli<T> eliVar2 = this.eli.get(size);
                if (this.DbA != eliVar2 && eliVar2.eli(f)) {
                    return eliVar2;
                }
            }
            return this.eli.get(0);
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public com.bytedance.adsdk.DbA.kb.eli<T> DbA() {
            return this.DbA;
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float Os() {
            return this.eli.get(0).Os();
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public float aGH() {
            return this.eli.get(r0.size() - 1).aGH();
        }

        @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.Os
        public boolean DbA(float f) {
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar = this.Os;
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar2 = this.DbA;
            if (eliVar == eliVar2 && this.aGH == f) {
                return true;
            }
            this.Os = eliVar2;
            this.aGH = f;
            return false;
        }
    }
}
