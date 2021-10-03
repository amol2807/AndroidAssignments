package com.example.mylistmaker

import android.os.Parcel
import android.os.Parcelable


/*
SharedPreferences lets you save small collections of key-value pairs that you can
retrieve later. If you need a way to save small bits of data in your app quickly,
SharedPreferences is one of the first solutions you should consider.
*/


/*
Parcelable lets you break down your object into types the Intent system is already
familiar with: strings, ints, floats, Booleans and other objects which conform to
Parcelable. You can then put all of that information into a Parcel
*/

class TaskList(val name: String, val tasks: ArrayList<String> =
    ArrayList()) : Parcelable {
    //secondary constructor
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.createStringArrayList()!!
    )
    override fun describeContents() = 0
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeStringList(tasks)
    }

    /*
    The Parcelable protocol requires you
    to create a public static Parcelable.Creator<T> CREATOR field and override some
    methods in it using Java. However, static methods don’t exist in Kotlin. Instead,
    you create a companion object meeting the same requirements and override the
    appropriate functions within that object.
     */
    companion object CREATOR: Parcelable.Creator<TaskList> {
        override fun createFromParcel(source: Parcel): TaskList =
            TaskList(source)
        override fun newArray(size: Int): Array<TaskList?> =
            arrayOfNulls(size)
    }

}
