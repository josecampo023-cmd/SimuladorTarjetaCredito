# Reglas de ProGuard para SimuladorApp
-keepattributes *Annotation*
-keep public class * extends android.app.Activity
-keep public class * extends android.webkit.WebViewClient
-keep public class * extends android.webkit.WebChromeClient
