package eu.limereversed.werkout.classes

import eu.limereversed.werkout.SetSettings

class Set(
    val id: Long = -1L,
    var name : String = "",
    val setParts: List<SetPartAbstract> = emptyList<SetPartAbstract>(),
    var settings: SetSettings? = null,
)