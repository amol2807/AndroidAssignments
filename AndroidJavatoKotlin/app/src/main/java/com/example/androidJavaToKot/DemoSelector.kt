package com.example.androidJavaToKot

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity.CENTER_VERTICAL
import android.view.Gravity.LEFT
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DemoSelector : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView

    private lateinit var chapterListAdapter: ChaptersListAdapter

    private val TAG = "DemoSelector"

    private class ChaptersListAdapter(val context: Context) : BaseExpandableListAdapter() {
        private val chapters: Array<String> = context.resources.getStringArray(R.array.chapters)
        private val exercises: MutableList<MutableList<String>> = mutableListOf()

        override fun getChild(groupPosition: Int, childPosition: Int): Any {
            return exercises[groupPosition][childPosition]
        }

        override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            return childPosition.toLong()
        }

        override fun getChildrenCount(groupPosition: Int): Int {
            return exercises[groupPosition].size
        }

        // Layout parameters for the ExpandableListView
        val genericView: TextView
            get() {
                // Layout parameters for the ExpandableListView
                val lp = AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
                val textView = TextView(context)
                textView.layoutParams = lp
                textView.textSize = 20f
                textView.gravity = CENTER_VERTICAL or LEFT
                textView.setPadding(60, 20, 20, 20)
                return textView
            }

        override fun getChildView(
            groupPosition: Int, childPosition: Int, isLastChild: Boolean,
            convertView: View?, parent: ViewGroup
        ): View {
            val textView = genericView
            textView.setPadding(80, 20, 20, 20)
            textView.text = getChild(groupPosition, childPosition).toString()
            return textView
        }

        override fun getGroup(groupPosition: Int): Any {
            return "Chapter " + (groupPosition + 1) + ": " + chapters[groupPosition]
        }

        override fun getGroupCount(): Int {
            return chapters.size
        }

        override fun getGroupId(groupPosition: Int): Long {
            return groupPosition.toLong()
        }

        override fun getGroupView(
            groupPosition: Int, isExpanded: Boolean, convertView: View?,
            parent: ViewGroup
        ): View {
            val textView = genericView
            textView.text = getGroup(groupPosition).toString()
            return textView
        }

        override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
            return true
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        fun getExerciseClass(
            groupPosition: Int,
            childPosition: Int,
            id: Long
        ): Class<out Activity?> {
            val exerciseId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1)
            return ExerciseActivityMapper.getExerciseClass(exerciseId)
        }

        init {
            Log.v("AdapterChapterList","chapter.size = ${chapters.size}")
            for (i in chapters.indices) {
                val resId: Int =
                    context.resources.getIdentifier("chap" + (i + 1), "array", context.packageName)
                Log.v("AdapterChapterList","resID = $resId")
                exercises.add(context.resources.getStringArray(resId).toMutableList())
                Log.v("AdapterChapterList",exercises[i].toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupChapterListView()
    }

    private fun setupChapterListView() {

        expandableListView = findViewById(R.id.chapterListView)

        chapterListAdapter = ChaptersListAdapter(this)

        expandableListView.setAdapter(chapterListAdapter)

        expandableListView.setOnChildClickListener { _, v, groupPosition, childPosition, id ->


            Log.v(TAG,"$groupPosition,$childPosition,$id")

            val exerciseTitle = chapterListAdapter.getChild(groupPosition, childPosition) as String
            val exerciseClass: Class<out Activity?> =
                chapterListAdapter.getExerciseClass(groupPosition, childPosition, id)
            Toast.makeText(this, exerciseTitle, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, exerciseClass))
            false
        }
    }
}