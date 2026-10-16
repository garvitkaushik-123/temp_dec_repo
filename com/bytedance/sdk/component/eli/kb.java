package com.bytedance.sdk.component.eli;

import com.bytedance.sdk.component.eli.CMM;
import com.bytedance.sdk.component.eli.QX;
import com.bytedance.sdk.component.eli.aGH;
import com.bytedance.sdk.component.eli.bf;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* loaded from: classes3.dex */
class kb implements CMM.eli {
    private final Xb DbA;
    private final boolean FC;
    private final com.bytedance.sdk.component.eli.eli aAs;
    private final wC eli;
    private final NU kb;
    private final boolean wC;
    private final Map<String, DbA> Os = new HashMap();
    private final Map<String, aGH.DbA> aGH = new HashMap();
    private final List<aqO> ui = new ArrayList();
    private final Set<aGH> MGA = new HashSet();

    kb(aAs aas, com.bytedance.sdk.component.eli.eli eliVar, bf bfVar) {
        this.aAs = eliVar;
        this.eli = aas.aGH;
        Xb xb = new Xb(bfVar, aas.nlS, aas.NU);
        this.DbA = xb;
        xb.eli(this);
        xb.eli(aas.aqO);
        this.kb = aas.FC;
        this.wC = aas.wC;
        this.FC = aas.Dfc;
    }

    eli eli(aqO aqo, MGA mga) throws Exception {
        DbA dbA = this.Os.get(aqo.aGH);
        if (dbA != null) {
            try {
                ev DbA = DbA(mga.DbA, dbA);
                mga.aGH = DbA;
                if (DbA == null) {
                    new StringBuilder("Permission denied, call: ").append(aqo);
                    throw new nGm(-1);
                }
                if (dbA instanceof ui) {
                    new StringBuilder("Processing stateless call: ").append(aqo);
                    return eli(aqo, (ui) dbA, mga);
                }
                if (dbA instanceof Os) {
                    new StringBuilder("Processing raw call: ").append(aqo);
                    return eli(aqo, (Os) dbA, DbA);
                }
            } catch (bf.eli unused) {
                new StringBuilder("No remote permission config fetched, call pending: ").append(aqo);
                this.ui.add(aqo);
                return new eli(false, Vy.eli());
            }
        }
        aGH.DbA dbA2 = this.aGH.get(aqo.aGH);
        if (dbA2 != null) {
            aGH eli2 = dbA2.eli();
            eli2.eli(aqo.aGH);
            ev DbA2 = DbA(mga.DbA, eli2);
            mga.aGH = DbA2;
            if (DbA2 == null) {
                new StringBuilder("Permission denied, call: ").append(aqo);
                eli2.aGH();
                throw new nGm(-1);
            }
            new StringBuilder("Processing stateful call: ").append(aqo);
            return eli(aqo, eli2, mga);
        }
        new StringBuilder("Received call: ").append(aqo);
        return null;
    }

    void eli(String str, ui<?, ?> uiVar) {
        uiVar.eli(str);
        this.Os.put(str, uiVar);
    }

    void eli(String str, aGH.DbA dbA) {
        this.aGH.put(str, dbA);
    }

    void eli() {
        Iterator<aGH> it = this.MGA.iterator();
        while (it.hasNext()) {
            it.next().ui();
        }
        this.MGA.clear();
        this.Os.clear();
        this.aGH.clear();
        this.DbA.DbA(this);
    }

    private eli eli(aqO aqo, ui uiVar, MGA mga) throws Exception {
        return new eli(true, Vy.eli(this.eli.eli((wC) uiVar.eli(eli(aqo.ui, (DbA) uiVar), mga))));
    }

    private eli eli(final aqO aqo, final aGH agh, MGA mga) throws Exception {
        this.MGA.add(agh);
        agh.eli(eli(aqo.ui, agh), mga, new aGH.eli() { // from class: com.bytedance.sdk.component.eli.kb.1
            @Override // com.bytedance.sdk.component.eli.aGH.eli
            public void eli(Object obj) {
                if (kb.this.aAs == null) {
                    return;
                }
                kb.this.aAs.DbA(Vy.eli(kb.this.eli.eli((wC) obj)), aqo);
                kb.this.MGA.remove(agh);
            }

            @Override // com.bytedance.sdk.component.eli.aGH.eli
            public void eli(Throwable th) {
                if (kb.this.aAs == null) {
                    return;
                }
                kb.this.aAs.DbA(Vy.eli(th), aqo);
                kb.this.MGA.remove(agh);
            }
        });
        return new eli(false, Vy.eli());
    }

    private eli eli(final aqO aqo, Os os, ev evVar) throws Exception {
        new QX(aqo.aGH, evVar, new QX.eli() { // from class: com.bytedance.sdk.component.eli.kb.2
        });
        return new eli(false, Vy.eli());
    }

    private Object eli(String str, DbA dbA) throws JSONException {
        return this.eli.eli(str, eli(dbA)[0]);
    }

    private ev DbA(String str, DbA dbA) {
        if (this.FC) {
            return ev.PRIVATE;
        }
        return this.DbA.eli(this.wC, str, dbA);
    }

    private static Type[] eli(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    static final class eli {
        String DbA;
        boolean eli;

        private eli(boolean z, String str) {
            this.eli = z;
            this.DbA = str;
        }
    }
}
