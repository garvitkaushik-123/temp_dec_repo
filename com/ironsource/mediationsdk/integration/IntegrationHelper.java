package com.ironsource.mediationsdk.integration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C3260q4;
import com.ironsource.N6;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.p;
import com.unity3d.mediation.LevelPlay;
import com.vungle.ads.BuildConfig;
import io.bidmachine.BidMachine;

@Deprecated
/* loaded from: classes6.dex */
public class IntegrationHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3537a = "IntegrationHelper";
    private static final String b = "4.1";
    private static final String c = "4.3";

    class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3538a;

        a(Context context) {
            this.f3538a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.w(IntegrationHelper.f3537a, "--------------- Google Play Services --------------");
                if (!this.f3538a.getPackageManager().getApplicationInfo(this.f3538a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.e(IntegrationHelper.f3537a, "Google Play Services - MISSING");
                    return;
                }
                Log.i(IntegrationHelper.f3537a, "Google Play Services - VERIFIED");
                String advertiserId = p.j().getAdvertiserId(this.f3538a);
                if (TextUtils.isEmpty(advertiserId)) {
                    return;
                }
                Log.i(IntegrationHelper.f3537a, "GAID is: " + advertiserId + " (use this for test devices)");
            } catch (Exception e) {
                C3260q4.d().a(e);
                Log.e(IntegrationHelper.f3537a, "Google Play Services - MISSING");
            }
        }
    }

    private static boolean a(IntegrationData integrationData) {
        if (integrationData.version.startsWith(b) || integrationData.version.startsWith(c)) {
            Log.i(f3537a, "Adapter - VERIFIED");
            return true;
        }
        Log.e(f3537a, integrationData.name + " adapter " + integrationData.version + " is incompatible with SDK version " + LevelPlay.getSdkVersion() + ", please update your adapter to version 4.1.*");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0096 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0007, B:14:0x0046, B:15:0x006e, B:19:0x0096, B:21:0x009e, B:24:0x00a5, B:27:0x005d, B:28:0x0063, B:29:0x0069, B:30:0x0021, B:33:0x002b, B:36:0x0035), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0007, B:14:0x0046, B:15:0x006e, B:19:0x0096, B:21:0x009e, B:24:0x00a5, B:27:0x005d, B:28:0x0063, B:29:0x0069, B:30:0x0021, B:33:0x002b, B:36:0x0035), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str) {
        char c2;
        IntegrationData a2;
        try {
            String lowerCase = StringUtils.toLowerCase(str);
            int hashCode = lowerCase.hashCode();
            if (hashCode == -805296079) {
                if (lowerCase.equals("vungle")) {
                    c2 = 2;
                    if (c2 != 0) {
                    }
                    String str2 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                    a2 = a(context, str2);
                    if (a2 != null) {
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                String str22 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                a2 = a(context, str22);
                if (a2 != null) {
                }
            } else if (hashCode != 92668925) {
                if (hashCode == 497130182 && lowerCase.equals("facebook")) {
                    c2 = 0;
                    if (c2 != 0) {
                        Log.i(f3537a, "--------------- Meta --------------");
                    } else if (c2 == 1) {
                        Log.i(f3537a, "--------------- Google (AdMob and Ad Manager) --------------");
                    } else if (c2 != 2) {
                        Log.i(f3537a, "--------------- " + str + " --------------");
                    } else {
                        Log.i(f3537a, "--------------- Liftoff Monetization --------------");
                    }
                    String str222 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                    a2 = a(context, str222);
                    if (a2 != null) {
                        return false;
                    }
                    if (!str.equalsIgnoreCase("IronSource") && !a(a2)) {
                        return false;
                    }
                    a(str222);
                    return true;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                String str2222 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                a2 = a(context, str2222);
                if (a2 != null) {
                }
            } else {
                if (lowerCase.equals("admob")) {
                    c2 = 1;
                    if (c2 != 0) {
                    }
                    String str22222 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                    a2 = a(context, str22222);
                    if (a2 != null) {
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                String str222222 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
                a2 = a(context, str222222);
                if (a2 != null) {
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            Log.e(f3537a, "isAdapterValid " + str, e);
            return false;
        }
        C3260q4.d().a(e);
        Log.e(f3537a, "isAdapterValid " + str, e);
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Deprecated
    public static void validateIntegration(Context context) {
        Log.i(f3537a, "Verifying Integration:");
        b(context);
        String[] strArr = {"AppLovin", "APS", BidMachine.NAME, "Bigo", "Chartboost", "Fyber", "AdMob", "HyprMX", "InMobi", "IronSource", BuildConfig.OMSDK_PARTNER_NAME, "Maio", "Facebook", "Mintegral", "MobileFuse", "Moloco", "MyTarget", "Ogury", "Pangle", "Smaato", "SuperAwesome", N6.G1, "Verve", "Yandex"};
        for (int i = 0; i < 24; i++) {
            String str = strArr[i];
            if (b(context, str)) {
                String lowerCase = StringUtils.toLowerCase(str);
                lowerCase.hashCode();
                lowerCase.hashCode();
                switch (lowerCase.hashCode()) {
                    case -805296079:
                        if (lowerCase.equals("vungle")) {
                            break;
                        }
                        break;
                    case 92668925:
                        if (lowerCase.equals("admob")) {
                            break;
                        }
                        break;
                    case 497130182:
                        if (lowerCase.equals("facebook")) {
                            break;
                        }
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:84)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:79)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:340)
                    */
                /*
                    Method dump skipped, instructions count: 404
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.validateIntegration(android.content.Context):void");
            }

            private static IntegrationData a(Context context, String str) {
                try {
                    IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", Context.class).invoke(null, context);
                    Log.i(f3537a, "Adapter " + integrationData.version + " - VERIFIED");
                    return integrationData;
                } catch (ClassNotFoundException e) {
                    C3260q4.d().a(e);
                    Log.e(f3537a, "Adapter - MISSING");
                    return null;
                } catch (Exception e2) {
                    C3260q4.d().a(e2);
                    Log.e(f3537a, "Adapter version - NOT VERIFIED");
                    return null;
                }
            }

            private static void a(Context context) {
                new a(context).start();
            }

            private static void a(String str) {
                try {
                    Log.i(f3537a, "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", null).invoke(null, null)));
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    Log.w("validateSDKVersion", "Unable to get SDK version");
                }
            }

            private static void b(Context context) {
                Log.i(f3537a, "*** Permissions ***");
                PackageManager packageManager = context.getPackageManager();
                if (packageManager.checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
                    Log.i(f3537a, "android.permission.INTERNET - VERIFIED");
                } else {
                    Log.e(f3537a, "android.permission.INTERNET - MISSING");
                }
                if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
                    Log.i(f3537a, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
                } else {
                    Log.e(f3537a, "android.permission.ACCESS_NETWORK_STATE - MISSING");
                }
            }
        }
