package com.bytedance.adsdk.eli.DbA.ui;

import com.bytedance.adsdk.eli.DbA.DbA.eli.FC;
import com.bytedance.adsdk.eli.DbA.DbA.eli.MGA;
import com.bytedance.adsdk.eli.DbA.DbA.eli.NU;
import com.bytedance.adsdk.eli.DbA.DbA.eli.QX;
import com.bytedance.adsdk.eli.DbA.DbA.eli.dV;
import com.bytedance.adsdk.eli.DbA.DbA.eli.du;
import com.bytedance.adsdk.eli.DbA.DbA.eli.nGm;
import com.bytedance.adsdk.eli.DbA.DbA.eli.nlS;
import com.bytedance.adsdk.eli.DbA.DbA.eli.nn;
import com.bytedance.adsdk.eli.DbA.DbA.eli.ui;
import com.bytedance.adsdk.eli.DbA.DbA.eli.wC;
import com.bytedance.adsdk.eli.DbA.aGH.Os;
import com.bytedance.adsdk.eli.DbA.aGH.aGH;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA {
    public static com.bytedance.adsdk.eli.DbA.DbA.eli eli(List<com.bytedance.adsdk.eli.DbA.DbA.eli> list, String str, int i) {
        Os(list, str, i);
        Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> eli = eli(DbA(list, str, i));
        if (eli.size() != 1) {
            throw new IllegalStateException();
        }
        return eli.getFirst();
    }

    private static Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> eli(Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.eli.DbA.DbA.eli eliVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList.peekLast()).eli() == Os.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.eli.DbA.DbA.eli eliVar2 = (com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList.pollLast();
                if (((com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList.pollLast()).eli() != Os.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.eli.DbA.DbA.eli eliVar3 = (com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList.pollLast();
                QX qx = new QX();
                qx.eli(eliVar3);
                qx.DbA(eliVar2);
                qx.Os(eliVar);
                linkedList.addLast(qx);
            } else {
                linkedList.addLast(eliVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> DbA(List<com.bytedance.adsdk.eli.DbA.DbA.eli> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.eli.DbA.DbA.eli> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.eli.DbA.DbA.eli eliVar : linkedList) {
                if (!linkedList2.isEmpty() && Os.eli(((com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList2.peekLast()).eli()) && ((Os) ((com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList2.peekLast()).eli()).DbA() == i2) {
                    com.bytedance.adsdk.eli.DbA.DbA.eli eliVar2 = (com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList2.pollLast();
                    com.bytedance.adsdk.eli.DbA.DbA.eli eliVar3 = (com.bytedance.adsdk.eli.DbA.DbA.eli) linkedList2.pollLast();
                    if (!Os.eli(eliVar3.eli()) && !Os.eli(eliVar.eli())) {
                        linkedList2.addLast(eli(eliVar3, eliVar2, eliVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(eliVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void Os(List<com.bytedance.adsdk.eli.DbA.DbA.eli> list, String str, int i) {
        Iterator<com.bytedance.adsdk.eli.DbA.DbA.eli> it = list.iterator();
        while (it.hasNext()) {
            if (aGH.eli(it.next().eli())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.eli.DbA.ui.DbA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[Os.values().length];
            eli = iArr;
            try {
                iArr[Os.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[Os.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[Os.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[Os.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[Os.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[Os.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eli[Os.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                eli[Os.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                eli[Os.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                eli[Os.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                eli[Os.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                eli[Os.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                eli[Os.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.bytedance.adsdk.eli.DbA.DbA.eli eli(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar, com.bytedance.adsdk.eli.DbA.DbA.eli eliVar2, com.bytedance.adsdk.eli.DbA.DbA.eli eliVar3) {
        dV duVar;
        switch (AnonymousClass1.eli[((Os) eliVar2.eli()).ordinal()]) {
            case 1:
                duVar = new du();
                break;
            case 2:
                duVar = new nGm();
                break;
            case 3:
                duVar = new com.bytedance.adsdk.eli.DbA.DbA.eli.eli();
                break;
            case 4:
                duVar = new NU();
                break;
            case 5:
                duVar = new nlS();
                break;
            case 6:
                duVar = new com.bytedance.adsdk.eli.DbA.DbA.eli.aGH();
                break;
            case 7:
                duVar = new nn();
                break;
            case 8:
                duVar = new MGA();
                break;
            case 9:
                duVar = new FC();
                break;
            case 10:
                duVar = new ui();
                break;
            case 11:
                duVar = new wC();
                break;
            case 12:
                duVar = new com.bytedance.adsdk.eli.DbA.DbA.eli.DbA();
                break;
            case 13:
                duVar = new com.bytedance.adsdk.eli.DbA.DbA.eli.Os();
                break;
            default:
                throw new UnsupportedOperationException(eliVar2.eli().toString());
        }
        duVar.eli(eliVar);
        duVar.DbA(eliVar3);
        return duVar;
    }

    public static boolean eli(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
