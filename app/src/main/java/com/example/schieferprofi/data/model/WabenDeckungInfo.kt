import kotlinx.serialization.Serializable

@Serializable
data class WabenDeckungInfo(
    val beschreibung: String = "",
    val deckunterlage: String = "",
    val befestigung: String = "",
    val decksteinmodell: String = "",
    val deckungsart: String = "",
    val einteilung: WabenEinteilung = WabenEinteilung(),
    val ortdeckung: String = "",
    val formate: List<WabenFormat> = emptyList()
)

@Serializable
data class WabenEinteilung(
    val rechtsLinksdeckung: Boolean = false,
    val waagerecht: Double = 0.0,
    val senkrecht: Double = 0.0,
    val schnuerabstandFormel: String = ""
)

@Serializable
data class WabenFormat(
    val breite: Int = 0,
    val hoehe: Int = 0,
    val ueberdeckung: Int = 0,
    val schieferbedarf: Double = 0.0,
    val gewichtPro1000Stk: Int = 0,
    val stueckProKiste: Int = 0
)