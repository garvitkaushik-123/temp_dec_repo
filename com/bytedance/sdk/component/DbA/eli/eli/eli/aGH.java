package com.bytedance.sdk.component.DbA.eli.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;

/* loaded from: classes3.dex */
public class aGH extends du {
    public eli FC;
    public MGA wC;

    public aGH(du.eli eliVar) {
        super(eliVar);
        this.wC = new MGA();
        this.FC = new eli(this.wC.DbA());
    }

    @Override // com.bytedance.sdk.component.DbA.eli.du
    public com.bytedance.sdk.component.DbA.eli.aGH eli() {
        return this.wC;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.du
    public com.bytedance.sdk.component.DbA.eli.DbA eli(nlS nls) {
        nls.eli(this);
        if (nls == null || nls.DbA() == null || nls.DbA().eli() == null || TextUtils.isEmpty(nls.DbA().eli().toString())) {
            return null;
        }
        if (eli.eli != null && eli.eli.DbA() && this.FC.ui() && !"setting".equals(nls.MGA())) {
            DbA dbA = new DbA(nls, this.FC);
            this.FC.Os().add(dbA);
            return dbA;
        }
        DbA dbA2 = new DbA(nls, this.wC);
        this.wC.Os().add(dbA2);
        return dbA2;
    }
}
