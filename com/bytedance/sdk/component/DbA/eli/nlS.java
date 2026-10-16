package com.bytedance.sdk.component.DbA.eli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class nlS {
    public com.bytedance.sdk.component.Os.eli.eli DbA = new com.bytedance.sdk.component.Os.eli.eli();
    public du eli;

    public abstract kb DbA();

    public abstract String MGA();

    public abstract String Os();

    public abstract Map<String, List<String>> aGH();

    public abstract Object eli();

    public abstract int kb();

    public abstract com.bytedance.sdk.component.DbA.eli.eli ui();

    public NU wC() {
        return null;
    }

    public void eli(du duVar) {
        this.eli = duVar;
    }

    public eli FC() {
        return new eli(this);
    }

    public static class eli {
        Map<String, List<String>> DbA;
        NU MGA;
        kb Os;
        String aGH;
        com.bytedance.sdk.component.DbA.eli.eli eli;
        int kb;
        Object ui;
        String wC;

        public eli() {
            this.DbA = new HashMap();
        }

        public eli eli(com.bytedance.sdk.component.DbA.eli.eli eliVar) {
            this.eli = eliVar;
            return this;
        }

        public eli eli(String str) {
            this.wC = str;
            return this;
        }

        public eli eli(int i) {
            this.kb = i;
            return this;
        }

        eli(nlS nls) {
            this.Os = nls.DbA();
            this.aGH = nls.Os();
            this.DbA = nls.aGH();
            this.ui = nls.eli();
            this.MGA = nls.wC();
            this.eli = nls.ui();
            this.kb = nls.kb();
            this.wC = nls.MGA();
        }

        public eli eli(Object obj) {
            this.ui = obj;
            return this;
        }

        public eli DbA(String str) {
            return eli(kb.Os(str));
        }

        public eli eli(kb kbVar) {
            this.Os = kbVar;
            return this;
        }

        public eli eli(String str, String str2) {
            return DbA(str, str2);
        }

        public eli DbA(String str, String str2) {
            if (!this.DbA.containsKey(str)) {
                this.DbA.put(str, new ArrayList());
            }
            this.DbA.get(str).add(str2);
            return this;
        }

        public eli eli() {
            return eli("GET", (NU) null);
        }

        private eli eli(String str, NU nu) {
            this.aGH = str;
            this.MGA = nu;
            return this;
        }

        public eli eli(NU nu) {
            return eli("POST", nu);
        }

        public nlS DbA() {
            return new nlS() { // from class: com.bytedance.sdk.component.DbA.eli.nlS.eli.1
                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public Object eli() {
                    return eli.this.ui;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public kb DbA() {
                    return eli.this.Os;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public String Os() {
                    return eli.this.aGH;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public Map aGH() {
                    return eli.this.DbA;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public com.bytedance.sdk.component.DbA.eli.eli ui() {
                    return eli.this.eli;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public String MGA() {
                    return eli.this.wC;
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public int kb() {
                    return eli.this.kb;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.DbA.eli.nlS
                public NU wC() {
                    return eli.this.MGA;
                }
            };
        }
    }
}
