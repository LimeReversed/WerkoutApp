package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.SetData

class Set(
    val id: Long = -1L,
    var setParts: List<SetPart> = emptyList<SetPart>(),
    var settings: SetSettings? = null,
){
    constructor(setData: SetData): this(id = setData.id, settings = SetSettings(setData.tempo, setData.rest, setData.equipment))

    fun asData(): SetData {

        if (settings == null) { return SetData(this.id, "", -1, "") }

        return SetData(
            this.id, this.settings!!.tempo, this.settings!!.rest, this.settings!!.equipment
        )
    }
}