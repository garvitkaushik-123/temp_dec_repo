package com.bytedance.sdk.component.DbA.eli.eli.eli;

import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.DbA.eli.wC;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class Os implements wC.eli {
    nlS DbA;
    int Os = 0;
    List<com.bytedance.sdk.component.DbA.eli.wC> eli;

    Os(List<com.bytedance.sdk.component.DbA.eli.wC> list, nlS nls) {
        this.eli = list;
        this.DbA = nls;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.wC.eli
    public nlS eli() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.wC.eli
    public nn eli(nlS nls) throws IOException {
        this.DbA = nls;
        int i = this.Os + 1;
        this.Os = i;
        if (i >= this.eli.size()) {
            return null;
        }
        return this.eli.get(this.Os).eli(this);
    }
}
