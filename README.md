# SuperNow

`SuperNow` es una aplicación de delivery *multi-store* para Android, enfocada en el sector *retail* de consumo general, como supermercados y tiendas de conveniencia (similar a PedidosYa).

## Diseño (UI/UX)

El prototipo y diseño de la aplicación se realizó en Figma y puede ser consultado en el siguiente enlace:

* [Prototipo de Figma - SuperNow Retail Store](https://www.figma.com/design/GUrZrV2s0DfzhPVsuHTGuI/IHC---Retail-Store?node-id=52-4963&t=nphquvWeVETk2qrw-1)

## Características Principales

* Exploración de múltiples tiendas y categorías de productos.
* Búsqueda de productos dentro del catálogo.
* Gestión de carrito de compras.
* Flujo de *checkout* (proceso de pago).

## 🚀 Stack Tecnológico y Arquitectura

* **Lenguaje:** 100% [Kotlin](https://kotlinlang.org/)
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) para una UI declarativa y moderna.
* **Arquitectura:** [MVVM (Model-View-ViewModel)](https://developer.android.com/topic/architecture/recommendations#mvvm)
* **Organización del Proyecto:** Estructura modular basada en *features* (funcionalidades).
* **Inyección de Dependencias:** [Hilt](https://dagger.dev/hilt/) para la gestión de dependencias.
* **Navegación:** [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) para gestionar el flujo entre pantallas.
* **Networking:** [Ktor Client](https://ktor.io/docs/client-overview.html) para el consumo de API REST (con serialización de `kotlinx-json`).
* **Carga de Imágenes:** [Coil](https://coil-kt.github.io/coil/) para la carga asíncrona de imágenes.

## 🛠 Prerrequisitos

* Android Studio 2025.1.4 (o superior).
* JDK 17 (generalmente incluido en Android Studio).
* [Mockoon](https://mockoon.com/) (para simular el backend).

## ⚙️ Instalación y Configuración

Para compilar y ejecutar la aplicación localmente, sigue estos pasos:

1. **Simulación del Backend (Mockoon)**
    Esta aplicación requiere un backend simulado para funcionar. Utilizamos Mockoon para este propósito.

    * Instala la aplicación de escritorio de Mockoon desde [mockoon.com](https://mockoon.com/).
    * Abre Mockoon e importa el entorno de trabajo (workspace) ubicado en la carpeta `/mocks/` del proyecto:
      `./mocks/SuperNowApi.json`
    * Inicia el servidor mock en Mockoon (normalmente se ejecutará en `http://localhost:3000` o el puerto que tengas configurado).

2. **Ejecuta la aplicación**
    * Abre el proyecto en Android Studio.
    * Sincroniza los archivos Gradle.
    * Asegúrate de que el servidor de Mockoon esté corriendo.
    * Ejecuta la aplicación en un emulador o dispositivo físico.