import UIKit
import WebKit

class ViewController: UIViewController {

    // ── WKWebView ────────────────────────────────────────────────────────────
    private var webView: WKWebView!

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = UIColor(red: 0.05, green: 0.06, blue: 0.08, alpha: 1)
        setupWebView()
        loadSimulator()
    }

    // MARK: - Setup

    private func setupWebView() {
        // Controlador de mensajes JS → Swift
        let contentController = WKUserContentController()
        contentController.add(self, name: "saveBase64")   // recibe el PDF en base64
        contentController.add(self, name: "consoleLog")   // opcional: logs de JS

        let config = WKWebViewConfiguration()
        config.userContentController = contentController
        config.preferences.setValue(true, forKey: "allowFileAccessFromFileURLs")

        // Permitir acceso universal desde file:// (necesario para cargar el HTML local)
        if #available(iOS 15.4, *) {
            config.upgradeKnownHostsToHTTPS = false
        }

        webView = WKWebView(frame: .zero, configuration: config)
        webView.translatesAutoresizingMaskIntoConstraints = false
        webView.scrollView.contentInsetAdjustmentBehavior = .never
        webView.isOpaque = false
        webView.backgroundColor = .clear
        webView.scrollView.backgroundColor = .clear

        view.addSubview(webView)

        NSLayoutConstraint.activate([
            webView.topAnchor.constraint(equalTo: view.topAnchor),
            webView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            webView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            webView.trailingAnchor.constraint(equalTo: view.trailingAnchor)
        ])
    }

    private func loadSimulator() {
        guard let htmlPath = Bundle.main.url(forResource: "simulador", withExtension: "html") else {
            showAlert(title: "Error", message: "No se encontró simulador.html en el bundle.")
            return
        }
        // Carga el HTML local con acceso al directorio para recursos relativos
        webView.loadFileURL(htmlPath, allowingReadAccessTo: htmlPath.deletingLastPathComponent())
    }

    // MARK: - Alerts

    private func showAlert(title: String, message: String) {
        DispatchQueue.main.async {
            let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "OK", style: .default))
            self.present(alert, animated: true)
        }
    }

    // MARK: - Guardar PDF

    /// Recibe el data URI (data:application/pdf;base64,...) desde JS y lo guarda
    private func savePDF(dataURI: String) {
        // Extraer la parte base64
        guard let commaIndex = dataURI.firstIndex(of: ",") else {
            showAlert(title: "Error", message: "Formato de PDF inválido.")
            return
        }

        let base64String = String(dataURI[dataURI.index(after: commaIndex)...])

        guard let pdfData = Data(base64Encoded: base64String, options: .ignoreUnknownCharacters) else {
            showAlert(title: "Error", message: "No se pudo decodificar el PDF.")
            return
        }

        // Guardar en el directorio temporal y compartir con el selector nativo de iOS
        let tempDir = FileManager.default.temporaryDirectory
        let fileURL = tempDir.appendingPathComponent("Simulacion_Credito.pdf")

        do {
            try pdfData.write(to: fileURL, options: .atomic)
            DispatchQueue.main.async {
                self.sharePDF(url: fileURL)
            }
        } catch {
            showAlert(title: "Error", message: "No se pudo guardar el PDF: \(error.localizedDescription)")
        }
    }

    /// Muestra el selector de compartir de iOS (guardar en Archivos, AirDrop, WhatsApp, etc.)
    private func sharePDF(url: URL) {
        let activityVC = UIActivityViewController(activityItems: [url], applicationActivities: nil)

        // En iPad necesita un sourceView para el popover
        if let popover = activityVC.popoverPresentationController {
            popover.sourceView = view
            popover.sourceRect = CGRect(x: view.bounds.midX, y: view.bounds.midY, width: 0, height: 0)
            popover.permittedArrowDirections = []
        }

        present(activityVC, animated: true)
    }

    // Barra de estado en blanco para que contraste con el fondo oscuro/claro del HTML
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
}

// MARK: - WKScriptMessageHandler (recibe mensajes desde JavaScript)

extension ViewController: WKScriptMessageHandler {
    func userContentController(_ userContentController: WKUserContentController,
                               didReceive message: WKScriptMessage) {
        switch message.name {
        case "saveBase64":
            if let dataURI = message.body as? String {
                savePDF(dataURI: dataURI)
            }
        case "consoleLog":
            print("JS:", message.body)
        default:
            break
        }
    }
}
