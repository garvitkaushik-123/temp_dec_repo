package com.bytedance.sdk.component.MGA.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private final Os DbA;
    private final Queue<String> Os;
    private final aGH eli;

    public DbA() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.Os = concurrentLinkedQueue;
        this.eli = new MGA(concurrentLinkedQueue);
        this.DbA = new Os();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public synchronized void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        aGH agh;
        if (i != 5) {
            if (wC.kb().aqO().eli(wC.kb().MGA()) && (agh = this.eli) != null && eliVar != null) {
                agh.eli(eliVar, i);
            }
        }
        Os os = this.DbA;
        if (os != null && eliVar != null) {
            os.eli(eliVar, i);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public synchronized void eli(int i, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = list.iterator();
        while (it.hasNext()) {
            this.Os.remove(it.next().Os());
        }
        aGH agh = this.eli;
        if (agh != null) {
            agh.eli(i, list);
        }
        Os os = this.DbA;
        if (os != null) {
            os.eli(i, list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r7 == 2) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, int i2, List<String> list) {
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list2;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli = this.eli.eli(i, i2, list);
        if (eli != 0 && eli.size() != 0) {
            eli.size();
            if (i != 1) {
                list2 = eli;
            }
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA = this.DbA.DbA((com.bytedance.sdk.component.MGA.eli.aGH.eli) eli.get(0), eli.size());
            list2 = eli;
            if (DbA != null) {
                list2 = eli;
                if (DbA.size() != 0) {
                    DbA.size();
                    HashMap hashMap = new HashMap();
                    for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar : DbA) {
                        hashMap.put(eliVar.Os(), eliVar);
                    }
                    ArrayList arrayList = new ArrayList(this.Os);
                    for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar2 : DbA) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (TextUtils.equals(eliVar2.Os(), (String) it.next())) {
                                    hashMap.remove(eliVar2.Os());
                                    break;
                                }
                            }
                        }
                    }
                    for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar3 : eli) {
                        hashMap.put(eliVar3.Os(), eliVar3);
                    }
                    eli.clear();
                    Iterator it2 = hashMap.keySet().iterator();
                    while (it2.hasNext()) {
                        eli.add(hashMap.get((String) it2.next()));
                    }
                    DbA.clear();
                    list2 = eli;
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.Os);
            if (list != null && !list.isEmpty()) {
                arrayList2.addAll(list);
            }
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli2 = this.DbA.eli(i, i2, arrayList2);
            if (eli2 != 0 && eli2.size() != 0) {
                HashMap hashMap2 = new HashMap();
                for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar4 : eli2) {
                    hashMap2.put(eliVar4.Os(), eliVar4);
                }
                arrayList2.size();
                if (arrayList2.size() != 0) {
                    for (String str : arrayList2) {
                        if (hashMap2.get(str) != null) {
                            hashMap2.remove(str);
                        }
                    }
                }
                eli2.clear();
                Iterator it3 = hashMap2.keySet().iterator();
                while (it3.hasNext()) {
                    eli2.add(hashMap2.get((String) it3.next()));
                }
            }
            list2 = eli2;
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it4 = list2.iterator();
            while (it4.hasNext()) {
                this.Os.offer(it4.next().Os());
            }
            return list2;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public synchronized boolean eli(int i, boolean z) {
        if (this.eli.eli(i, z)) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.oWW(), 1);
            return true;
        }
        if ((i != 1 && i != 2) || !this.DbA.eli(i, z)) {
            return false;
        }
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.qj(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(int i, long j) {
        this.DbA.eli(i, j);
        this.eli.eli(i, j);
    }
}
