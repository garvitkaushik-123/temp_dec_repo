package com.bytedance.sdk.openadsdk.core.nlS.aGH;

import com.bykv.vk.openvk.eli.eli.DbA.Os.aGH;
import com.bykv.vk.openvk.eli.eli.eli.eli;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends aGH {
    private final eli aGH;
    private final List<DbA> eli = Collections.synchronizedList(new ArrayList());
    private int DbA = 1;
    private int Os = 1;

    public interface DbA extends eli.InterfaceC0110eli {
        void eli(int i, int i2);
    }

    static /* synthetic */ int eli(Os os) {
        int i = os.Os;
        os.Os = i + 1;
        return i;
    }

    public Os() {
        eli eliVar = new eli();
        this.aGH = eliVar;
        super.eli(eliVar);
        eli(500);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.aGH
    public long dV() {
        return super.dV() * this.DbA;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.aGH
    public long nGm() {
        long nGm = super.nGm();
        return this.DbA == 1 ? nGm : nGm + ((this.Os - 1) * super.dV());
    }

    public void Os(int i) {
        this.DbA = Math.max(1, i);
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.aGH
    public void eli(eli.InterfaceC0110eli interfaceC0110eli) {
        if (interfaceC0110eli instanceof DbA) {
            if (this.eli.contains(interfaceC0110eli)) {
                return;
            }
            this.eli.add((DbA) interfaceC0110eli);
            return;
        }
        super.eli(interfaceC0110eli);
    }

    public int bf() {
        return this.Os;
    }

    private class eli implements eli.InterfaceC0110eli {
        private eli() {
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            Os.eli(Os.this);
            if (Os.this.Os <= Os.this.DbA) {
                Iterator it = Os.this.eli.iterator();
                while (it.hasNext()) {
                    ((DbA) it.next()).eli(Os.this.Os, Os.this.DbA);
                }
                Os.this.FC();
                return;
            }
            Iterator it2 = Os.this.eli.iterator();
            while (it2.hasNext()) {
                ((DbA) it2.next()).eli(eliVar);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, long j) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, j);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).DbA(eliVar);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar2) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, eliVar2);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, boolean z) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, z);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void Os(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).Os(eliVar);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, i, i2);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2, int i3) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, i, i2, i3);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).DbA(eliVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, long j, long j2) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).eli(eliVar, j, j2);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void aGH(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).aGH(eliVar);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void ui(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            Iterator it = Os.this.eli.iterator();
            while (it.hasNext()) {
                ((DbA) it.next()).ui(eliVar);
            }
        }
    }
}
