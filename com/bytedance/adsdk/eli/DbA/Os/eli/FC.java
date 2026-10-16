package com.bytedance.adsdk.eli.DbA.Os.eli;

import java.util.Deque;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class FC extends MGA {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r0.eli() != com.bytedance.adsdk.eli.DbA.aGH.DbA.METHOD) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r0 = (com.bytedance.adsdk.eli.DbA.DbA.eli.aAs) r0;
        r1 = new java.util.LinkedList();
        r2 = new java.util.LinkedList();
        r10 = r10.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r10.hasNext() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r3 = (com.bytedance.adsdk.eli.DbA.DbA.eli) r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r3.eli() != com.bytedance.adsdk.eli.DbA.aGH.aGH.COMMA) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r2.addLast(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r1.add(com.bytedance.adsdk.eli.DbA.ui.DbA.eli(r2, r7, r8));
        r2.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r2.isEmpty() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        r1.add(com.bytedance.adsdk.eli.DbA.ui.DbA.eli(r2, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
    
        r0.eli((com.bytedance.adsdk.eli.DbA.DbA.eli[]) r1.toArray(new com.bytedance.adsdk.eli.DbA.DbA.eli[r1.size()]));
        r8 = r8 + 1;
        r9.push(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        r9.push(com.bytedance.adsdk.eli.DbA.ui.DbA.eli(r10, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        return r8 + 1;
     */
    @Override // com.bytedance.adsdk.eli.DbA.Os.eli.MGA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int eli(String str, int i, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        if (')' != eli(i, str)) {
            return eliVar.eli(str, i, deque);
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            com.bytedance.adsdk.eli.DbA.DbA.eli pollFirst = deque.pollFirst();
            if (pollFirst == null || pollFirst.eli() == com.bytedance.adsdk.eli.DbA.aGH.DbA.METHOD || pollFirst.eli() == com.bytedance.adsdk.eli.DbA.aGH.aGH.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(pollFirst);
        }
        throw new IllegalArgumentException(str.substring(0, i));
    }
}
