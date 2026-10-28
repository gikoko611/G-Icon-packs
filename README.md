# G.I KO KO Royal Gold Icon Pack

**Style:** black enamel + extra-bright gold 3D Myanmar floral/lotus filigree frame, with app-specific gold symbols.

## Included starter icons
Phone, Messages, Camera, Settings, Facebook, YouTube, Chrome, Gallery, Calendar, Files, Play Store, Gmail, WhatsApp, Telegram, TikTok, Instagram and LINE.

## Build APK
1. Open the repository's **Actions** tab.
2. Select **Build G.I KO KO Gold Icon Pack APK**.
3. Run the workflow (or wait for the push-triggered build).
4. Download the `GI-KOKO-Gold-Icon-Pack-debug` artifact from the completed run.

The project targets Android 6.0+ (minSdk 23) and uses Java 17 / Gradle 8.7. The APK is a debug build and is not Play Store signed.

## One-click apply: important Android limitation
The dashboard includes an **ONE-CLICK APPLY** attempt for launchers that expose a compatible theme-picker intent, plus launcher-specific buttons. Android has no universal API that lets a normal app replace every app icon across the whole phone. A supported launcher must apply the icon pack; MIUI's stock launcher on some Xiaomi/Redmi builds does not support third-party icon packs. If the one-click action cannot open a theme picker, open the compatible launcher's Icon/Theme settings and select **G.I KO KO Gold Icons**.

The `appfilter.xml` maps common package/activity names to gold icon assets. Device vendors and app versions use different activity names, so some icons may need additional mappings for a particular phone. This is an initial project; verify the generated APK and device compatibility before daily use.

**Branding:** Powered By I KO KO.
