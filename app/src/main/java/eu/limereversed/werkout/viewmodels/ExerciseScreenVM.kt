package eu.limereversed.werkout.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.limereversed.easy_storage_example.Graph
import eu.limereversed.werkout.classes.Description
import eu.limereversed.werkout.classes.Exercise
import eu.limereversed.werkout.classes.ExercisePack
import eu.limereversed.werkout.classes.Program
import eu.limereversed.werkout.classes.Set
import eu.limereversed.werkout.classes.SetPart
import eu.limereversed.werkout.classes.SetSettings
import eu.limereversed.werkout.repositories.DescriptionRepository
import eu.limereversed.werkout.repositories.ExercisePackRepository
import eu.limereversed.werkout.repositories.ExerciseRepository
import eu.limereversed.werkout.repositories.ProgramRepository
import eu.limereversed.werkout.repositories.SetPartRepository
import eu.limereversed.werkout.repositories.SetRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

// ViewModel is the holder of states and business logic.
class ExerciseScreenVM(
    private val programRepository: ProgramRepository = Graph.programRepository,
    private val exercisePackRepository: ExercisePackRepository = Graph.exercisePackRepository,
    private val exerciseRepository: ExerciseRepository = Graph.exerciseRepository,
    private val descriptionRepository: DescriptionRepository = Graph.descriptionRepository,
    private val setRepository: SetRepository = Graph.setRepository,
    private val setPartRepository: SetPartRepository = Graph.setPartRepository,

) : ViewModel() {

    // Have empty program here. The collect as state below and put it here.

    val setPart1: SetPart = SetPart(-1, "Part 1", "int", "1", "1", 60)
    val setPart12: SetPart = SetPart(-1, "Part 12", "int", "1", "1", 60)
    val setPart2: SetPart = SetPart(-1, "Part 2", "int", "2", "2", 60)
    val setPart22: SetPart = SetPart(-1, "Part 22", "int", "2", "2", 60)
    val setPart3: SetPart = SetPart(-1, "Part 3", "int", "3", "3", 60)

    val setSettings1: SetSettings = SetSettings("0001", 60, "Equipment 1")
    val setSettings2: SetSettings = SetSettings("0010", 60, "Equipment 2")
    val setSettings3: SetSettings = SetSettings("0011", 60, "Equipment 3")

    val set1: Set = Set(-1, listOf(setPart1, setPart12), setSettings1)
    val set2: Set = Set(-1, listOf(setPart2, setPart22), setSettings2)
    val set3: Set = Set(-1, listOf(setPart3), setSettings3)

    val exercisePack1: List<Exercise> = listOf<Exercise>(Exercise(-1, 1, "Exercise 1", "ImagePath 1", listOf(set1, set2), 0, false, description = listOf<Description>(Description(-1, "Exercise 1"))))

    // FIX - ID shouldn't be needed in constructor?
    val exercisePack2: List<Exercise> = listOf<Exercise>(Exercise(-1, 2, "Exercise 2", "ImagePath 2", listOf(set3), 0, false, description = listOf(Description(-1, "Exercise 2"))))

    val program1: Program = Program(-1, "Program 1",  null, listOf(ExercisePack(1, exercisePack1), ExercisePack(2, exercisePack2)))

    fun createProgram(program: Program){
        viewModelScope.launch(Dispatchers.IO) {
            val newProgramId: Long = programRepository.add(program.asData())
            
            for (exercisePack in program.exercisePacks) {
                val newExercisePack1Id: Long = exercisePackRepository.add()
                exercisePackRepository.assignToProgram(newExercisePack1Id, newProgramId)

                for (exercise in exercisePack.exercises) {
                    val newExerciseId = exerciseRepository.add(exercise.asData())
                    exerciseRepository.assignToExercisePack(newExerciseId, newExercisePack1Id)

                    if (exercise.defaultGoal != null) {
                        val newSetPartId: Long = setPartRepository.add(exercise.defaultGoal!!.asData())
                        setPartRepository.assignToExercise(newSetPartId, exercise.id)
                    }

                    for (description in exercise.description) {
                        val newDescriptionId = descriptionRepository.add(description.asData())
                        descriptionRepository.assignToExercise(newDescriptionId, newExerciseId)
                    }

                    for (set in exercise.sets) {
                        val newSetId: Long = setRepository.add(set.asData())
                        setRepository.assignToExercise(newSetId, newExerciseId)

                        for (setPart in set.setParts){
                            val newSetPartId: Long = setPartRepository.add(setPart.asData())
                            setPartRepository.assignToSet(newSetPartId, newSetId)
                        }
                    }
                }
            }
        }
    }

//    fun buildProgram(programId: Long) {
//        viewModelScope.launch(Dispatchers.IO) {
//
//            var program: Program = Program()
//            programRepository.getById(programId).collect {result -> program = Program(result)}
//
//            var exercisePacks: List<ExercisePack> = emptyList<ExercisePack>()
//            exercisePackRepository.getByProgramId(programId).collect { result -> result.map { item -> exercisePacks += ExercisePack(id = item.exercisePackId) } }
//
//            for (exercisePack in program.exercisePacks) {
//                exerciseRepository.getByExercisePackId(exercisePack.id).collect { result -> exercisePack.exercises = result.map {item -> Exercise(item) } }
//
//                for (exercise in exercisePack.exercises) {
//                    setRepository.getByExerciseId(exercise.id).collect { result -> exercise.sets = result.map {item -> Set(item) } }
//
//                    for (set in exercise.sets) {
//                        setPartRepository.getBySetId(set.id).collect { result -> set.setParts = result.map {item -> SetPart(item) } }
//
//
//                    }
//                }
//            }
//
//
//
//        }
//    }


}