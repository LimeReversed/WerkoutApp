package eu.limereversed.werkout

class Entities {

}

// String so they can name it themselves?
enum class WeightUnits2 {
    Kgs, Lbs
}


// Program
// currentExercise

class Exercise(
    val name: String?,
    val imageID: Int?,
    val sets: List<Set>,
    val defaultSetSettings: SetSettings?,
    val description: String?,
    // currentSet?
    // Put restSets inbetween the actual sets in the sets-array, or handle what's left another way.
        // Info about set done?
        // Info about whether system should go to next automatically or pause until logged.

    // Played tempo over
    // If rest then play rest

    // Nothing to play
    //

    // Varje set can ha en Play() som stannar eller fortsätter till paus. Så varje Set har två steg i sin play.
    // Fördel är att pausen blir en del av settet och inte ett separat element.
    // Blir nog inte lika ofta fel eftersom det stämmer med mer hur ui är designat. Rest tillhör settet.
    // Hur skicka det till separate rest timern.
    // Hur håller jag koll på vilket steg jag är i?
    // if isLogged then rest? Vad gör jag om jag vill göra om den?


) {}

// When new ex and when just a variation of same ex?

class Set(
    val setParts: List<SetPartAbs>,
    val overrideSettings: SetSettings?,
) {}

class SetSettings(
    val tempo: String?,
    val rest: Int?,
    val equipment: String?,
){}

abstract class SetPartAbs (
    val name: String?,
){}

open class SetPart<T>(
    name: String?,
    val value: T?,
    val goal: T?,
) : SetPartAbs(name){}

class SetPartKgs(value: Int?, goal: Int?):SetPart<Int>("Kg", value, goal){}
class SetPartReps(value: Int?, goal: Int?):SetPart<Int>("Reps", value, goal){}

