package com.mbridge.msdk.dycreator.engine;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.ironsource.D5;
import com.mbridge.msdk.MBridgeConstans;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MBLayoutInflate.java */
/* loaded from: classes6.dex */
public class a {
    private static final Class[] e = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> f = new HashMap<>();
    private static String g = "com.mbridge.msdk.dycreator.baseview.MB";
    protected final Context b;
    private long d;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4167a = true;
    private final Object[] c = new Object[2];

    public a(Context context) {
        this.b = context;
    }

    public Context a() {
        return this.b;
    }

    protected View b(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return (str.equals("MBStarLevelLayoutView") || str.equals("LuckPan")) ? a(str, "", attributeSet) : a(str, g, attributeSet);
    }

    public View a(String str, ViewGroup viewGroup) {
        return a(str, viewGroup, viewGroup != null);
    }

    public View a(String str, ViewGroup viewGroup, boolean z) {
        this.d = System.currentTimeMillis();
        System.out.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z);
    }

    private void b(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    a(xmlPullParser, view);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() != 0) {
                        a(xmlPullParser, view, attributeSet);
                    } else {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                } else if (!"merge".equals(name)) {
                    View a2 = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    b(xmlPullParser, a2, attributeSet);
                    viewGroup.addView(a2, generateLayoutParams);
                } else {
                    throw new InflateException("<merge /> must be the root element");
                }
            }
        }
    }

    public XmlPullParser a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), D5.N);
            return newPullParser;
        } catch (Exception e2) {
            e2.printStackTrace();
            return newPullParser;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View] */
    public View a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        int next;
        ViewGroup.LayoutParams layoutParams;
        synchronized (this.c) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.c[0] = this.b;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (IOException e2) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next == 2) {
                String name = xmlPullParser.getName();
                System.out.println("**************************");
                System.out.println("Creating root view: " + name);
                System.out.println("**************************");
                if (!"merge".equals(name)) {
                    View a2 = a(name, asAttributeSet);
                    if (viewGroup != 0) {
                        System.out.println("Creating params from root: " + ((Object) viewGroup));
                        layoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                        if (!z) {
                            a2.setLayoutParams(layoutParams);
                        }
                    } else {
                        layoutParams = null;
                    }
                    System.out.println("-----> start inflating children");
                    b(xmlPullParser, a2, asAttributeSet);
                    System.out.println("-----> done inflating children");
                    if (viewGroup != 0 && z) {
                        viewGroup.addView(a2, layoutParams);
                    }
                    if (viewGroup == 0 || !z) {
                        viewGroup = a2;
                    }
                } else if (viewGroup != 0 && z) {
                    b(xmlPullParser, viewGroup, asAttributeSet);
                } else {
                    throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                }
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return viewGroup;
    }

    public final View a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        HashMap<String, Constructor> hashMap = f;
        Constructor<?> constructor = hashMap.get(str);
        Class<?> cls = null;
        if (constructor == null) {
            try {
                cls = this.b.getClassLoader().loadClass(str2 != null ? str2 + str : str);
                constructor = cls.getConstructor(e);
                hashMap.put(str, constructor);
            } catch (ClassNotFoundException e2) {
                throw e2;
            } catch (NoSuchMethodException e3) {
                StringBuilder append = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                InflateException inflateException = new InflateException(append.append(str).toString());
                inflateException.initCause(e3);
                throw inflateException;
            } catch (Exception e4) {
                InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + (cls == null ? "<unknown>" : cls.getName()));
                inflateException2.initCause(e4);
                throw inflateException2;
            }
        }
        Object[] objArr = this.c;
        objArr[1] = attributeSet;
        return (View) constructor.newInstance(objArr);
    }

    View a(String str, AttributeSet attributeSet) {
        View a2;
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        System.out.println("******** Creating view: " + str);
        try {
            if (-1 == str.indexOf(46)) {
                a2 = b(str, attributeSet);
            } else {
                a2 = a(str, (String) null, attributeSet);
            }
            System.out.println("Created view is: " + a2);
            return a2;
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, View view) throws XmlPullParserException, IOException {
        int next;
        view.requestFocus();
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        } while (next != 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006e, code lost:
    
        if (r8 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
    
        b(r0, r2, r1);
        r7.addView(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        r2.setLayoutParams(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        if (r8 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        ViewGroup.LayoutParams generateLayoutParams;
        int next2;
        if (view instanceof ViewGroup) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(null, "layout", 0);
            if (attributeResourceValue == 0) {
                String attributeValue = attributeSet.getAttributeValue(null, "layout");
                if (attributeValue == null) {
                    throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
                }
                throw new InflateException("You must specifiy a valid layout reference. The layout ID " + attributeValue + " is not valid.");
            }
            XmlResourceParser layout = a().getResources().getLayout(attributeResourceValue);
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(layout);
                do {
                    next = layout.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = layout.getName();
                    if ("merge".equals(name)) {
                        b(layout, view, asAttributeSet);
                    } else {
                        View a2 = a(name, asAttributeSet);
                        ViewGroup viewGroup = (ViewGroup) view;
                        try {
                            generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                        } catch (RuntimeException unused) {
                            generateLayoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                        }
                    }
                    layout.close();
                    int depth = xmlPullParser.getDepth();
                    do {
                        next2 = xmlPullParser.next();
                        if (next2 == 3 && xmlPullParser.getDepth() <= depth) {
                            return;
                        }
                    } while (next2 != 1);
                    return;
                }
                throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
            } catch (Throwable th) {
                layout.close();
                throw th;
            }
        }
        throw new InflateException("<include /> can only be used inside of a ViewGroup");
    }
}
