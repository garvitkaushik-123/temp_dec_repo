package com.bytedance.sdk.component.adexpress.eli.DbA;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.eli.Os.eli;
import com.bytedance.sdk.component.utils.VM;
import com.ironsource.D5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Os {
    public abstract File eli();

    protected boolean eli(Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar = map.get(it.next());
            if (eliVar != null && !eli(eliVar.MGA())) {
                return false;
            }
        }
        return true;
    }

    protected boolean eli(List<eli.C0143eli> list) {
        if (list == null || list.size() <= 0 || eli() == null) {
            return false;
        }
        for (eli.C0143eli c0143eli : list) {
            String eli = com.bytedance.sdk.component.utils.ui.eli(c0143eli.eli());
            if (TextUtils.isEmpty(eli)) {
                return false;
            }
            File file = new File(eli(), eli);
            String eli2 = com.bytedance.sdk.component.utils.ui.eli(file);
            if (!file.exists() || !file.isFile() || c0143eli.DbA() == null || !c0143eli.DbA().equals(eli2)) {
                return false;
            }
        }
        return true;
    }

    protected boolean eli(eli.DbA dbA) {
        if (dbA == null || eli() == null) {
            return false;
        }
        List<Pair<String, String>> DbA = dbA.DbA();
        if (DbA == null || DbA.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = DbA.iterator();
        while (it.hasNext()) {
            File file = new File(eli(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<eli.C0143eli> eli(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli = eliVar.eli();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (eli.size() == 0) {
            if (eliVar2 != null && eliVar2.eli().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2 = eliVar2.eli();
                Iterator<String> it = eli2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar3 = eli2.get(it.next());
                    if (eliVar3 != null) {
                        arrayList.addAll(eliVar3.MGA());
                    }
                }
            }
        } else if (eliVar2 == null || eliVar2.eli().size() == 0) {
            if (eli.size() != 0) {
                Iterator<String> it2 = eli.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar4 = eli.get(it2.next());
                    if (eliVar4 != null) {
                        arrayList2.addAll(eliVar4.MGA());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli3 = eliVar2.eli();
            for (String str : eli.keySet()) {
                com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar5 = eli.get(str);
                com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar6 = eli3.get(str);
                if (eliVar6 == null && eliVar5 != null) {
                    arrayList2.addAll(eliVar5.MGA());
                } else if (eliVar5 == null && eliVar6 != null) {
                    arrayList.addAll(eliVar6.MGA());
                } else if (eliVar5 != null) {
                    for (eli.C0143eli c0143eli : eliVar5.MGA()) {
                        if (c0143eli != null && !eliVar6.MGA().contains(c0143eli) && c0143eli.DbA() != null && c0143eli.eli() != null) {
                            arrayList2.add(c0143eli);
                        }
                    }
                    for (eli.C0143eli c0143eli2 : eliVar6.MGA()) {
                        if (c0143eli2 != null && !eliVar5.MGA().contains(c0143eli2)) {
                            arrayList.add(c0143eli2);
                        }
                    }
                }
            }
        }
        if (eli(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean eli(List<eli.C0143eli> list, List<eli.C0143eli> list2) {
        for (eli.C0143eli c0143eli : list) {
            String eli = c0143eli.eli();
            String eli2 = com.bytedance.sdk.component.utils.ui.eli(eli);
            File file = new File(eli(), eli2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.kb.DbA.eli MGA = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().MGA();
            MGA.DbA(eli);
            MGA.eli(eli().getAbsolutePath(), eli2);
            com.bytedance.sdk.component.kb.DbA eli3 = MGA.eli();
            list2.add(c0143eli);
            if (eli3 == null || !eli3.MGA() || eli3.ui() == null || !eli3.ui().exists()) {
                Os(list2);
                return false;
            }
        }
        return true;
    }

    public List<eli.C0143eli> DbA(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (eliVar2 == null || eliVar2.MGA().isEmpty()) {
            arrayList2.addAll(eliVar.MGA());
        } else if (eliVar.MGA().isEmpty()) {
            arrayList.addAll(eliVar2.MGA());
        } else {
            for (eli.C0143eli c0143eli : eliVar.MGA()) {
                if (!eliVar2.MGA().contains(c0143eli) && c0143eli != null && c0143eli.eli() != null && c0143eli.DbA() != null) {
                    arrayList2.add(c0143eli);
                }
            }
            for (eli.C0143eli c0143eli2 : eliVar2.MGA()) {
                if (!eliVar.MGA().contains(c0143eli2)) {
                    arrayList.add(c0143eli2);
                }
            }
        }
        if (eli(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void DbA(List<eli.C0143eli> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<eli.C0143eli> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(eli(), com.bytedance.sdk.component.utils.ui.eli(it.next().eli()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean eli(String str) {
        File file = new File(eli().getAbsoluteFile(), com.bytedance.sdk.component.utils.ui.eli(str) + ".zip");
        com.bytedance.sdk.component.kb.DbA.eli MGA = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().MGA();
        MGA.DbA(str);
        MGA.eli(file.getParent(), file.getName());
        com.bytedance.sdk.component.kb.DbA eli = MGA.eli();
        if (eli.MGA() && eli.ui() != null && eli.ui().exists()) {
            File ui = eli.ui();
            try {
                VM.eli(ui.getAbsolutePath(), file.getParent());
                if (!ui.exists()) {
                    return true;
                }
                ui.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void eli(int i) {
        if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().aGH() != null) {
            com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().aGH().eli(i);
        }
    }

    public void Os(List<eli.C0143eli> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<eli.C0143eli> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(eli(), com.bytedance.sdk.component.utils.ui.eli(it.next().eli()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void eli(File file, com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, String str) {
        FileOutputStream fileOutputStream;
        if (eliVar == null) {
            return;
        }
        String aAs = eliVar.aAs();
        if (TextUtils.isEmpty(aAs)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file3);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(aAs.getBytes(D5.N));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                fileOutputStream.close();
            } catch (Throwable unused2) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (IOException unused3) {
        }
    }

    public static boolean Os(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar2) {
        if (eliVar != null) {
            try {
                if (!TextUtils.isEmpty(eliVar.Os())) {
                    if (eliVar2 == null) {
                        return false;
                    }
                    String kb = eliVar.kb();
                    String kb2 = eliVar2.kb();
                    if ((!TextUtils.isEmpty(kb2) && !kb2.equals(kb)) || eli(eliVar.Os(), eliVar2.Os())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli = eliVar.eli();
                    Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2 = eliVar2.eli();
                    if (eli.isEmpty()) {
                        return !eli2.isEmpty();
                    }
                    if (eli2.isEmpty()) {
                        return false;
                    }
                    return eli(eli, eli2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean eli(Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> map, Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar = map.get(str);
            if (eliVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar2 = map2.get(str);
            if (eliVar2 == null) {
                return false;
            }
            if (eli(eliVar.Os(), eliVar2.Os())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean eli(String str, String str2) {
        String[] split = str2.split("\\.");
        String[] split2 = str.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            int length = split[i].length() - split2[i].length();
            if (length == 0) {
                int compareTo = split[i].compareTo(split2[i]);
                if (compareTo > 0) {
                    return true;
                }
                if (compareTo < 0) {
                    return false;
                }
                if (i == min - 1) {
                    return split.length > split2.length;
                }
                i++;
            } else if (length > 0) {
                return true;
            }
        }
    }

    public static boolean eli(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, String str) {
        if (eliVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(eliVar.Os())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return eli(eliVar.Os(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void DbA(File file, com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar, String str) {
        if (eliVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (eliVar.MGA() != null) {
            Iterator<eli.C0143eli> it = eliVar.MGA().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.ui.eli(it.next().eli())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
