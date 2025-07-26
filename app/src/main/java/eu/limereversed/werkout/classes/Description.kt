package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.DescriptionData

class Description(
    val id: Long = 0L,
    var text : String = "",
) {
    constructor(descriptionData: DescriptionData): this(id = descriptionData.id, text = descriptionData.text)

    fun asData(): DescriptionData {
        return DescriptionData(this.id, this.text)
    }
}