package com.bytedance.sdk.openadsdk.Os;

import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs {
    private JSONObject Dfc;
    protected IListenerManager MGA;
    private String NU;
    private int QX;
    private FilterWord Xb;
    private String aqO;
    private ev dV;
    private String du;
    private int nGm;
    private String nlS;
    private String nn;
    public static FilterWord eli = new FilterWord("", "");
    public static int DbA = 1;
    public static int Os = 2;
    public static int aGH = 3;
    public static int ui = 4;
    private final Set<Os> kb = new HashSet();
    private final Set<DbA> wC = new HashSet();
    private final Set<aGH> FC = new HashSet();
    private final Set<eli> aAs = new HashSet();

    public interface DbA {
        void eli(int i);
    }

    public interface Os {
        void eli(FilterWord filterWord);
    }

    public interface aGH {
        void eli(String str);
    }

    public interface eli {
        void eli(List<FilterWord> list);
    }

    public void eli() {
        this.kb.clear();
        this.wC.clear();
        this.FC.clear();
        this.aAs.clear();
    }

    public void eli(String str) {
        this.du = str;
    }

    public void DbA(String str) {
        this.nlS = str;
    }

    public void eli(FilterWord filterWord) {
        this.Xb = filterWord;
        aAs();
    }

    public FilterWord DbA() {
        return this.Xb;
    }

    public boolean Os() {
        FilterWord filterWord = this.Xb;
        return (filterWord == null || filterWord.equals(eli)) ? false : true;
    }

    private void aAs() {
        Iterator<Os> it = this.kb.iterator();
        while (it.hasNext()) {
            it.next().eli(this.Xb);
        }
    }

    public void eli(Os os) {
        this.kb.add(os);
    }

    public void eli(DbA dbA) {
        this.wC.add(dbA);
    }

    public void eli(aGH agh) {
        this.FC.add(agh);
    }

    public void eli(eli eliVar) {
        this.aAs.add(eliVar);
    }

    public void aGH() {
        if (!Os() && !TextUtils.isEmpty(this.nn)) {
            this.Xb = new FilterWord("0:00", this.nn);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Xb);
        if (!TextUtils.isEmpty(this.du)) {
            if (TextUtils.isEmpty(this.nn)) {
                com.bytedance.sdk.openadsdk.Os.DbA.eli().eli(this.du, arrayList, this.nlS);
            } else {
                if (this.Dfc == null) {
                    ev evVar = this.dV;
                    if (evVar != null) {
                        this.Dfc = evVar.iOb();
                    } else {
                        try {
                            this.Dfc = new JSONObject(this.aqO);
                        } catch (Throwable th) {
                            Xb.eli("TTDislikeManager", "creative info to json exception", th);
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.Os.DbA.eli().eli(this.du, arrayList, this.Dfc, this.nn, this.nlS);
            }
        }
        if (!TextUtils.isEmpty(this.NU)) {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                aGH("onItemClickClosed");
            } else {
                kb.eli ui2 = com.bytedance.sdk.openadsdk.core.FC.DbA().ui(this.NU);
                if (ui2 != null) {
                    ui2.eli();
                    com.bytedance.sdk.openadsdk.core.FC.DbA().MGA(this.NU);
                }
            }
        }
        Iterator<DbA> it = this.wC.iterator();
        while (it.hasNext()) {
            it.next().eli(DbA);
        }
        eli(eli);
        Os("");
    }

    public void ui() {
        Iterator<DbA> it = this.wC.iterator();
        while (it.hasNext()) {
            it.next().eli(Os);
        }
    }

    public void MGA() {
        Iterator<DbA> it = this.wC.iterator();
        while (it.hasNext()) {
            it.next().eli(ui);
        }
    }

    public void eli(List<FilterWord> list) {
        Iterator<eli> it = this.aAs.iterator();
        while (it.hasNext()) {
            it.next().eli(list);
        }
    }

    private void aGH(final String str) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.Os.aAs.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(aAs.this.NU)) {
                        return;
                    }
                    aAs.this.eli(6).executeDisLikeClosedCallback(aAs.this.NU, str);
                } catch (Throwable th) {
                    Xb.eli("TTDislikeManager", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected IListenerManager eli(int i) {
        if (this.MGA == null) {
            this.MGA = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(i));
        }
        return this.MGA;
    }

    public static void eli(final int i, final String str, final kb.eli eliVar) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            cyF.Os(new com.bytedance.sdk.component.wC.wC("DislikeClosed_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.Os.aAs.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli eli2 = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli();
                    if (i != 6 || eliVar == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.openadsdk.multipro.aidl.DbA.DbA dbA = new com.bytedance.sdk.openadsdk.multipro.aidl.DbA.DbA(str, eliVar);
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.eli.aGH.asInterface(eli2.eli(6));
                        if (asInterface != null) {
                            asInterface.registerDisLikeClosedListener(str, dbA);
                        }
                    } catch (RemoteException e) {
                        Xb.Os("TTDislikeManager", e.getMessage());
                    }
                }
            }, 5);
        }
    }

    public static void eli(final int i, final String str) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            cyF.Os(new com.bytedance.sdk.component.wC.wC("DislikeClosed_unregisterMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.Os.aAs.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli eli2 = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli();
                    if (i == 6) {
                        try {
                            IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.eli.aGH.asInterface(eli2.eli(6));
                            if (asInterface != null) {
                                asInterface.unregisterDisLikeClosedListener(str);
                            }
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }, 5);
        }
    }

    public void Os(String str) {
        this.nn = str;
        Iterator<aGH> it = this.FC.iterator();
        while (it.hasNext()) {
            it.next().eli(this.nn);
        }
    }

    public String kb() {
        return this.nn;
    }

    public void eli(String str, ev evVar) {
        this.aqO = str;
        this.dV = evVar;
    }

    public void eli(int i, int i2) {
        this.nGm = i;
        this.QX = i2;
    }

    public int wC() {
        return this.nGm;
    }

    public boolean FC() {
        return this.nGm < this.QX;
    }
}
