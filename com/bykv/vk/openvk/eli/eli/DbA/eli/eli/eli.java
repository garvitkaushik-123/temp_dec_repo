package com.bykv.vk.openvk.eli.eli.DbA.eli.eli;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class eli implements com.bykv.vk.openvk.eli.eli.eli.eli.DbA {
    private String eli = "video_reward_full";
    private String DbA = "video_brand";
    private String Os = "video_splash";
    private String aGH = "video_default";
    private String ui = null;
    private String MGA = null;
    private String kb = null;
    private String wC = null;
    private String FC = null;

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public void eli(String str) {
        this.ui = str;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public String Os() {
        if (this.FC == null) {
            this.FC = this.ui + File.separator + this.aGH;
            File file = new File(this.FC);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.FC;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public String eli() {
        if (this.MGA == null) {
            this.MGA = this.ui + File.separator + this.eli;
            File file = new File(this.MGA);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.MGA;
    }

    public String ui() {
        if (this.kb == null) {
            this.kb = this.ui + File.separator + this.DbA;
            File file = new File(this.kb);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.kb;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public String DbA() {
        if (this.wC == null) {
            this.wC = this.ui + File.separator + this.Os;
            File file = new File(this.wC);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.wC;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public synchronized void aGH() {
        Set<String> set = null;
        for (com.bykv.vk.openvk.eli.eli.eli.eli.eli eliVar : MGA()) {
            File[] eli = eliVar.eli();
            if (eli != null && eli.length >= eliVar.DbA()) {
                if (set == null) {
                    set = kb();
                }
                int DbA = eliVar.DbA() - 2;
                if (DbA < 0) {
                    DbA = 0;
                }
                eli(eliVar.eli(), DbA, set);
            }
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public boolean eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        if (TextUtils.isEmpty(os.ui()) || TextUtils.isEmpty(os.dV())) {
            return false;
        }
        return new File(os.ui(), os.dV()).exists();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.eli.DbA
    public long DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        if (TextUtils.isEmpty(os.ui()) || TextUtils.isEmpty(os.dV())) {
            return 0L;
        }
        return com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.eli(os.ui(), os.dV());
    }

    private static void eli(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() { // from class: com.bykv.vk.openvk.eli.eli.DbA.eli.eli.eli.1
                        @Override // java.util.Comparator
                        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long lastModified = file2.lastModified() - file.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < asList.size()) {
                        File file = (File) asList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private List<com.bykv.vk.openvk.eli.eli.eli.eli.eli> MGA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.eli.eli.eli.eli.eli(new File(eli()).listFiles(), com.bykv.vk.openvk.eli.eli.DbA.eli.Os()));
        arrayList.add(new com.bykv.vk.openvk.eli.eli.eli.eli.eli(new File(DbA()).listFiles(), com.bykv.vk.openvk.eli.eli.DbA.eli.DbA()));
        arrayList.add(new com.bykv.vk.openvk.eli.eli.eli.eli.eli(new File(ui()).listFiles(), com.bykv.vk.openvk.eli.eli.DbA.eli.aGH()));
        arrayList.add(new com.bykv.vk.openvk.eli.eli.eli.eli.eli(new File(Os()).listFiles(), com.bykv.vk.openvk.eli.eli.DbA.eli.ui()));
        return arrayList;
    }

    private Set<String> kb() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.eli.eli.DbA.eli.eli eliVar : com.bykv.vk.openvk.eli.eli.DbA.eli.eli.eli.values()) {
            if (eliVar != null && eliVar.eli() != null) {
                com.bykv.vk.openvk.eli.eli.eli.Os.Os eli = eliVar.eli();
                hashSet.add(com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.DbA(eli.ui(), eli.dV()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.Os(eli.ui(), eli.dV()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.eli.eli.DbA.eli.DbA.DbA dbA : com.bykv.vk.openvk.eli.eli.DbA.eli.DbA.Os.eli.values()) {
            if (dbA != null && dbA.eli() != null) {
                com.bykv.vk.openvk.eli.eli.eli.Os.Os eli2 = dbA.eli();
                hashSet.add(com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.DbA(eli2.ui(), eli2.dV()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.Os(eli2.ui(), eli2.dV()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
