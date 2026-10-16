package com.bytedance.sdk.component.eli;

import android.net.Uri;
import com.bytedance.sdk.component.eli.CMM;
import com.bytedance.sdk.component.eli.bf;
import com.bytedance.sdk.component.eli.du;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
class Xb {
    private final Set<String> DbA;
    private final CMM Os = dV.eli;
    private final bf aGH;
    private final Set<String> eli;
    private du.eli ui;

    Xb(bf bfVar, Set<String> set, Set<String> set2) {
        this.aGH = bfVar;
        if (set == null || set.isEmpty()) {
            this.eli = new LinkedHashSet();
        } else {
            this.eli = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.DbA = new LinkedHashSet();
        } else {
            this.DbA = new LinkedHashSet(set2);
        }
    }

    final synchronized ev eli(boolean z, String str, DbA dbA) throws bf.eli {
        ev DbA;
        du.eli eliVar;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        ev evVar = this.DbA.contains(dbA.eli()) ? ev.PUBLIC : null;
        for (String str2 : this.eli) {
            if (parse.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                evVar = ev.PRIVATE;
                break;
            }
        }
        if (evVar == null && (eliVar = this.ui) != null && eliVar.eli(str)) {
            if (this.ui.eli(str, dbA.eli())) {
                return null;
            }
            evVar = ev.PRIVATE;
        }
        if (z) {
            DbA = eli(str, dbA);
        } else {
            DbA = DbA(str, dbA);
        }
        return DbA != null ? DbA : evVar;
    }

    final synchronized ev eli(String str, DbA dbA) throws bf.eli {
        return eli(str, dbA, true);
    }

    final synchronized ev DbA(String str, DbA dbA) {
        return eli(str, dbA, false);
    }

    void eli(du.eli eliVar) {
        this.ui = eliVar;
    }

    void eli(CMM.eli eliVar) {
        if (this.Os != null) {
            throw null;
        }
    }

    void DbA(CMM.eli eliVar) {
        if (this.Os != null) {
            throw null;
        }
    }

    private ev eli(String str, DbA dbA, boolean z) {
        if (!z || this.aGH == null) {
            return null;
        }
        throw null;
    }
}
