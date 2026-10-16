package com.bytedance.sdk.component.DbA.eli;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class ui extends NU {
    List<String> DbA;
    List<String> eli;

    ui(List<String> list, List<String> list2) {
        this.eli = list;
        this.DbA = list2;
    }

    public static final class eli {
        private final List<String> eli = new ArrayList();
        private final List<String> DbA = new ArrayList();

        public eli eli(String str, String str2) {
            this.eli.add(str);
            this.DbA.add(str2);
            return this;
        }

        public ui eli() {
            return new ui(this.eli, this.DbA);
        }
    }
}
