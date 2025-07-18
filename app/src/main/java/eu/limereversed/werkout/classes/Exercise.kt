package eu.limereversed.werkout.classes

class Exercise(
    val id: Long = -1L,
    var name: String = "",
    var imagePath: String = "",
    val sets: List<Set> = emptyList<Set>(),
    var currentSet: Int = -1,
    var superSetWithNext: Boolean = false,
    var defaultSettings: SetSetting? = null,
    var defaultGoal: SetPartAbstract? = null,
    var showGoalsIndividually: Boolean = false,
    var description: List<String> = emptyList<String>()

    // FIX Do I want defaults for these?
)