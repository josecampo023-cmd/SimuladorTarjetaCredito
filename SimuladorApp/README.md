# Simulador de Tarjeta de Crédito — App Android

## ¿Qué hay en este proyecto?
Proyecto Android listo para compilar en Android Studio.
Usa un WebView que carga el simulador localmente (sin servidor).

## Requisitos
- Android Studio Hedgehog (2023.1) o más reciente
- JDK 17 (viene con Android Studio)
- Conexión a internet la primera vez (para descargar Gradle y dependencias)

## Pasos para generar el APK

### 1. Abrir el proyecto
- Abre Android Studio
- Selecciona **File → Open** y elige la carpeta `SimuladorApp`
- Espera a que Gradle sincronice (barra de progreso abajo)

### 2. Compilar el APK de debug (más rápido, para uso personal)
- En el menú superior: **Build → Build Bundle(s) / APK(s) → Build APK(s)**
- Espera a que compile (1-3 minutos la primera vez)
- Android Studio mostrará una notificación: **"Build successful"**
- Haz clic en **"locate"** para abrir la carpeta con el APK

   Ruta del APK: `app/build/outputs/apk/debug/app-debug.apk`

### 3. Instalar en tu celular
**Opción A — Cable USB:**
- Activa "Opciones de desarrollador" en tu celular
  (Ajustes → Acerca del teléfono → toca "Número de compilación" 7 veces)
- Activa "Depuración USB"
- Conecta el cable y en Android Studio: **Run → Run 'app'**

**Opción B — Copiar el APK:**
- Copia el archivo `app-debug.apk` al celular (WhatsApp, Google Drive, cable)
- En el celular, activa "Instalar apps de fuentes desconocidas"
  (Ajustes → Seguridad → Fuentes desconocidas)
- Abre el APK desde el administrador de archivos e instala

## Notas
- El PDF requiere internet la primera vez para cargar jsPDF desde CDN
- Todos los cálculos son locales (sin servidor, sin datos enviados)
- Compatible con Android 7.0 (API 24) en adelante
