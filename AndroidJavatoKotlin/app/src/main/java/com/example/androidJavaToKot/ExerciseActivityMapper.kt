package com.example.androidJavaToKot

import android.app.Activity
import java.util.*

class ExerciseActivityMapper {
    private var exerciseClassMap: HashMap<String, Class<out Activity?>>? = null
    private fun defineExerciseMappings() {
        exerciseClassMap = HashMap()
        // Chapter 1: App Fundamentals
        exerciseClassMap!!["chap1ex1"] = BasicTextViewActivity::class.java
//         Chapter 2: User Interface
        exerciseClassMap!!["chap2ex1"] = LinearLayoutDemoActivity::class.java
        // Chapter 3: View Controls
        exerciseClassMap!!["chap3ex1"] = LayoutGravityActivity::class.java
        exerciseClassMap!!["chap3ex2"] = BasicViewActivity::class.java
        exerciseClassMap!!["chap3ex3"] = ViewAttributesActivity::class.java
        exerciseClassMap!!["chap3ex4"] = SimpleListViewActivity::class.java
        // Chapter 4: User Interactions
        exerciseClassMap!!["chap4ex1"] = BasicClickHandlersActivity::class.java
        exerciseClassMap!!["chap4ex2"] = ListViewClickActivity::class.java
        // Chapter 5: User Flows
        exerciseClassMap!!["chap5ex1"] = ExplicitIntentActivity::class.java // Explicit Intents
        exerciseClassMap!!["chap5ex2"] = ImplicitIntentActivity::class.java // Implicit Intents
        exerciseClassMap!!["chap5ex3"] = IntentWithResultActivity::class.java // Intent with Results
        exerciseClassMap!!["chap5ex4"] = ActionBarMenuActivity::class.java // Action Bar
        // Chapter 6: Networking
        exerciseClassMap!!["chap6ex1"] =
            BasicImageDownloadActivity::class.java // Basic Image Download
        exerciseClassMap!!["chap6ex2"] = AsyncTaskPerformActivity::class.java // AsyncTask
//        exerciseClassMap!!["chap6ex3"] =
//            SmartImageDownloadActivity::class.java // Smart Image Download
        // Chapter 7: Advanced Views
        exerciseClassMap!!["chap7ex1"] = ToastFormInputActivity::class.java // Toast Inputs
        exerciseClassMap!!["chap7ex2"] = SpinnerToastActivity::class.java // Spinner Toast
        exerciseClassMap!!["chap7ex3"] = TimePickerActivity::class.java // TimePicker
        //	  exerciseClassMap.put("chap7ex4", ProgressBarActivity.class); // ProgressBar
        exerciseClassMap!!["chap7ex4"] = GridViewActivity::class.java // GridView
        // Chapter 8: Preferences
        exerciseClassMap!!["chap8ex1"] = PersistSettingsActivity::class.java // Persist Settings
        // Chapter 9: ContentProviders
        exerciseClassMap!!["chap9ex1"] = ContactListActivity::class.java // Contact List
        // Chapter 10: Publishing
        exerciseClassMap!!["chap10ex1"] =
            PublishingActivity::class.java // APK Generation
    }

    companion object {
        private var singleton: ExerciseActivityMapper? = null
            private get() {
                if (field == null) {
                    field = ExerciseActivityMapper()
                }
                return field
            }

        fun getExerciseClass(exerciseId: String): Class<out Activity?> {
            return singleton!!.exerciseClassMap!![exerciseId]!!
        }
    }

    init {
        defineExerciseMappings()
    }
}
