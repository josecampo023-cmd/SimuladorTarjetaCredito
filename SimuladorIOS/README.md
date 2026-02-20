# Simulador de Tarjeta de Crédito — App iOS

## Requisitos
- Mac con macOS 13 (Ventura) o superior
- Xcode 15 o superior (gratis en la App Store de Mac)
- iPhone con iOS 15 o superior
- Cable USB Lightning o USB-C

---

## Paso 1 — Instalar Xcode
Si no lo tienes, abre la App Store en tu Mac, busca **Xcode** e instálalo.
Es un archivo grande (~7 GB), ten paciencia.

---

## Paso 2 — Abrir el proyecto
1. Descomprime el ZIP `SimuladorIOS.zip`
2. Haz doble clic en **SimuladorCredito.xcodeproj**
3. Xcode abrirá el proyecto automáticamente

---

## Paso 3 — Configurar tu cuenta de Apple (para instalar en tu iPhone)

1. En Xcode: menú **Xcode → Settings → Accounts**
2. Haz clic en **+** (abajo a la izquierda) y elige **Apple ID**
3. Ingresa tu Apple ID y contraseña (la cuenta gratuita es suficiente)

Luego:
1. En el panel izquierdo, haz clic en **SimuladorCredito** (el ícono azul del proyecto)
2. Selecciona el target **SimuladorCredito** en el centro
3. Ve a la pestaña **Signing & Capabilities**
4. Marca **Automatically manage signing**
5. En **Team**, selecciona tu nombre (tu Apple ID)
6. El Bundle Identifier cambia automáticamente — no lo modifiques

---

## Paso 4 — Conectar tu iPhone
1. Conecta tu iPhone al Mac con el cable
2. En tu iPhone aparecerá el mensaje **"¿Confiar en este ordenador?"** → toca **Confiar**
3. En Xcode, en la barra superior, donde dice el nombre del simulador,
   haz clic y selecciona **tu iPhone** de la lista

---

## Paso 5 — Ejecutar la app
1. Presiona el botón ▶ (Play) en la esquina superior izquierda de Xcode
2. Xcode compilará e instalará la app en tu iPhone (~1 minuto la primera vez)
3. En tu iPhone aparecerá una alerta: **"No se puede confiar en el desarrollador"**

   Solución:
   - Ve a **Ajustes → General → VPN y gestión de dispositivos**
   - Toca tu Apple ID
   - Toca **Confiar en "tu@email.com"**
   - Vuelve a abrir la app

¡Listo! La app estará instalada y funcionando.

---

## Uso de la app

### Modo claro / oscuro
Toca el botón 🌙/☀️ en la esquina superior derecha para alternar entre modos.
Tu preferencia se guarda automáticamente.

### Simular
Rellena los campos y pulsa **⚡ Simular**.

### Descargar PDF
Después de simular, pulsa **📥 PDF**.
iOS abrirá su selector nativo donde puedes:
- Guardarlo en la app **Archivos**
- Enviarlo por **WhatsApp**, **Mail**, **AirDrop**, etc.
- Imprimirlo directamente

> ℹ️ El PDF requiere conexión a internet la primera vez para cargar
> la librería jsPDF desde CDN. Después queda en caché del WebView.

---

## Notas adicionales
- Compatible con iPhone y iPad (iOS 15+)
- Todos los cálculos son locales, sin enviar datos a ningún servidor
- La cuenta gratuita de Apple ID permite instalar en **hasta 3 dispositivos**
  durante 7 días. Pasado ese tiempo, solo vuelves a ejecutar desde Xcode para renovar.
- Si quieres instalarlo permanentemente sin Xcode, necesitas la cuenta
  de Apple Developer de pago ($99 USD/año)
