package com.intellinects.intelliquiz.ExpandedList_Demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ExpandableListView
import com.intellinects.intellinectsschool.intellitestschool.Utils.CustomAlert

import com.intellinects.intelliquiz.R
import com.intellinects.intelliquiz.model.Leaderboard_Final_curriculum
import com.intellinects.intelliquiz.other.Common_Methods
import com.intellinects.intelliquiz.other.ConstantClass
import com.intellinects.intelliquiz.other.DataCallback
import com.intellinects.intelliquiz.other.Network_calls
import com.intellinects.intelliquiz.sessionmanager.Data_Fetch_from_server
import com.intellinects.intelliquiz.sessionmanager.Pref
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class Main_ExpandList : Activity() {
    private var mExpandableList: ExpandableListView? = null
    internal var arrayParents = ArrayList<Leaderboard_Final_curriculum>()
    internal var arrayChildren = ArrayList<Leaderboard_Final_curriculum>()
    internal var leaderboard_arraylist = ArrayList<Leaderboard_Final_curriculum>()
    internal var leaderboard_arraylist_details = ArrayList<Leaderboard_Final_curriculum>()
     
    internal lateinit var pref: Pref  
    internal lateinit var data_fetch_from_server: Data_Fetch_from_server
    internal lateinit var cm: Common_Methods

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        
        pref = Pref(this@Main_ExpandList )
        cm = Common_Methods(this@Main_ExpandList )
        data_fetch_from_server = Data_Fetch_from_server(this@Main_ExpandList )

        mExpandableList = findViewById<View>(R.id.expandable_list) as ExpandableListView?


//        get_all_leaderboard_chapterwise("5","38","3","5");
//        get_all_leaderboard_details_curri("5","3","5");
        get_leaderboard_details_subject_chapters("1","3","5");


//        here we set the parents and the children
//        for (i in 0..arrayParents.size) {
//            //for each "i" create a new Parent object to set the title and the children
//            val parent = Leaderboard_Final_curriculum()
//            parent.subject_name = arrayParents.get(i).subject_name
//
//            arrayChildren = ArrayList()
//            for (j in 0..9) {
////                arrayChildren.add("Child $j")
//            }
//            parent.final_curriculumArrayList_details = arrayChildren
//
//            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
//            arrayParents.add(parent)
//        }
//
//        //sets the adapter that provides data to the list.
//        mExpandableList!!.setAdapter(MyCustomAdapter(this@Main_ExpandList, arrayParents))

    }


//
//    fun get_cust_curri( ) {
//
//
//                try {
//
//                    for (i in 0 until 5) {
//
//                        val final_curriculum1 = Leaderboard_Final_curriculum()
//                        final_curriculum1.user_id = ("userId")
//                        final_curriculum1.name = ("name")
//                        final_curriculum1.email = ("email")
//                        final_curriculum1.board_id = ("boardId")
//                        final_curriculum1.class_id = ("classId")
//                        final_curriculum1.topic_id = ("topicId")
//                        final_curriculum1.username = ("username")
//                        final_curriculum1.subject_code = ("mp_boardclasssubjectId")
//                        final_curriculum1.subject_name = ("Math")
//                        final_curriculum1.image_name = ("imageName")
//                        final_curriculum1.totalScore = ("totalScore")
//                        final_curriculum1.totalQuestions = ("totalQuestions")
//                        final_curriculum1.attemptedQuestions = ("attemptedQuestions")
//                        final_curriculum1.remark = ("remark")
//
//                        Log.e("ME","final name subject : "+final_curriculum1.subject_name  +
//                                "child subject name : "+arrayChildren.get(i).subject_name)
//
//                        if(final_curriculum1.subject_name.equals(arrayChildren.get(i).subject_name)) {
//
//                            final_curriculum1.final_curriculumArrayList_details = arrayChildren
//                        }
//                        arrayParents.add(final_curriculum1)
//
//
//                    }
//                    mExpandableList!!.setAdapter(MyCustomAdapter(this@Main_ExpandList, arrayParents))
//
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//
//
//    }
//
//    fun get_cust_chapterwise( ) {
//
//                    try {
//
//                        for (i in 0 until 10) {
//
//                            val final_curriculum = Leaderboard_Final_curriculum()
//                            final_curriculum.user_id =  ("userId")
//                            final_curriculum.name =  ("name")
//                            final_curriculum.email =  ("email")
//                            final_curriculum.board_id =  ("boardId")
//                            final_curriculum.class_id = ("classId")
//                            final_curriculum.subject_code = ("mp_boardclasssubjectId")
//                            final_curriculum.chapterTitle = ("Roman Numbers")
//                            final_curriculum.chapterId = ("chapterId")
//                            final_curriculum.subject_name = ("Math")
//                            final_curriculum.topic_id = ("topicId")
//                            final_curriculum.image_name = ("imageName")
//                            final_curriculum.username = ("username")
//                            final_curriculum.totalScore = ("totalScore")
//                            final_curriculum.totalQuestions = ("totalQuestions")
//                            final_curriculum.attemptedQuestions = ("attemptedQuestions")
//                            final_curriculum.remark = ("remark")
//
//
//                            arrayChildren.add(final_curriculum)
//
//                        }
//
//                        //   var adapter1 = MyAdapter(this@Main_ExpandList, leaderboard_arraylist)
//                        // listView.adapter = adapter1
////                        items.add(ListCell(leaderboard_arraylist ,leaderboard_arraylist_details))
//
////                        items = sortAndAddSections(items)
//
//
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//
//
//    }


    fun get_all_leaderboard_details_curri(userId:String,BoardId : String ,ClassId : String) {

        Network_calls.get_all_leadeboard_curri_details(userId,BoardId,ClassId,object : DataCallback {

            override fun onSuccess(response: String) {
                try {
                    Log.e("lead","lead data : "+response)
                    val jsonObject1 = JSONObject(response)
                    val jsonArray = jsonObject1.getJSONArray("data")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val final_curriculum1 = Leaderboard_Final_curriculum()
                        final_curriculum1.user_id = jsonObject.getString("userId")
                        final_curriculum1.name = jsonObject.getString("name")
                        final_curriculum1.email = jsonObject.getString("email")
                        final_curriculum1.board_id = jsonObject.getString("boardId")
                        final_curriculum1.class_id = jsonObject.getString("classId")
                        final_curriculum1.topic_id = jsonObject.getString("topicId")
                        final_curriculum1.username = jsonObject.getString("username")
                        final_curriculum1.subject_code = jsonObject.getString("mp_boardclasssubjectId")
                        final_curriculum1.subject_name = jsonObject.getString("subjectName")
                        final_curriculum1.image_name = jsonObject.getString("imageName")
                        final_curriculum1.totalScore = jsonObject.getString("totalScore")
                        final_curriculum1.totalQuestions = jsonObject.getString("totalQuestions")
                        final_curriculum1.attemptedQuestions = jsonObject.getString("attemptedQuestions")
                        final_curriculum1.remark = jsonObject.getString("remark")
                        Log.e("ME","final name subject : "+final_curriculum1.subject_name  +
                                "child subject name : "+arrayChildren.get(i).subject_name)
//                        leaderboard_arraylist.add(final_curriculum1)
                        if(final_curriculum1.subject_name.equals(arrayChildren.get(i).subject_name)) {
                            final_curriculum1.final_curriculumArrayList_details = arrayChildren
                        }

                        arrayParents.add(final_curriculum1)

                    }
                    mExpandableList!!.setAdapter(MyCustomAdapter(this@Main_ExpandList, arrayParents))

                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(status: String) {
                if (status.contentEquals(ConstantClass.ERRORMSG)) {
                    CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                } else {
                    CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                }
            }

        })

    }

    fun get_all_leaderboard_chapterwise(userId:String,SubjectId : String ,BoardId : String ,ClassId : String) {
        if (cm.isInternetAvailable(this@Main_ExpandList )) {
            Network_calls.get_all_leadeboard_chapterwise(userId,SubjectId,BoardId,ClassId,object : DataCallback {

                override fun onSuccess(response: String) {
                    try {
                        Log.e("lead","lead data chapters : "+response)
                        val jsonObject1 = JSONObject(response)
                        val jsonArray = jsonObject1.getJSONArray("data")
                        for (i in 0 until jsonArray.length()) {
                            val jsonObject = jsonArray.getJSONObject(i)
                            val final_curriculum = Leaderboard_Final_curriculum()
                            final_curriculum.user_id = jsonObject.getString("userId")
                            final_curriculum.name = jsonObject.getString("name")
                            final_curriculum.email = jsonObject.getString("email")
                            final_curriculum.board_id = jsonObject.getString("boardId")
                            final_curriculum.class_id = jsonObject.getString("classId")
                            final_curriculum.subject_code = jsonObject.getString("mp_boardclasssubjectId")
                            final_curriculum.chapterTitle = jsonObject.getString("ChapterTitle")
                            final_curriculum.chapterId = jsonObject.getString("chapterId")
                            final_curriculum.subject_name = jsonObject.getString("subjectName")
                            final_curriculum.topic_id = jsonObject.getString("topicId")
                            final_curriculum.image_name = jsonObject.getString("imageName")
                            final_curriculum.username = jsonObject.getString("username")
                            final_curriculum.totalScore = jsonObject.getString("totalScore")
                            final_curriculum.totalQuestions = jsonObject.getString("totalQuestions")
                            final_curriculum.attemptedQuestions = jsonObject.getString("attemptedQuestions")
                            final_curriculum.remark = jsonObject.getString("remark")
                            leaderboard_arraylist_details.add(final_curriculum)
                            arrayChildren.add(final_curriculum)
                        }
                        Log.e("lead", "leaderboard_arraylist_details : ${leaderboard_arraylist_details.size}")
                        Log.e("lead", "leaderboard_arraylist  : ${leaderboard_arraylist .size}")

                        // var adapter1 = MyAdapter(this@Main_ExpandList, leaderboard_arraylist)
                        // listView.adapter = adapter1
//                         items.add(ListCell(leaderboard_arraylist ,leaderboard_arraylist_details))

//                         items = sortAndAddSections(items)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(status: String) {
                    Log.e("errors", "statussss$status")
                    if (status.contentEquals(ConstantClass.ERRORMSG)) {
                        CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                    } else {
                        CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                    }
                }

            })
        } else {
            cm.no_interenet_connection(this@Main_ExpandList)
        }
    }


    fun get_leaderboard_details_subject_chapters(userId:String,BoardId : String ,ClassId : String) {

        Network_calls.get_leadeboard_details_subject_chapter(userId,BoardId,ClassId,object : DataCallback {

            override fun onSuccess(response: String) {
                try {
                    Log.e("lead","lead data : "+response)
                    val jsonObject1 = JSONObject(response)
                    val jsonArray = jsonObject1.getJSONArray("data")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val final_curriculum1 = Leaderboard_Final_curriculum()
//                      final_curriculum1.user_id = jsonObject.getString("userId")

                        final_curriculum1.subject_name = jsonObject.getString("subjectName")
                        final_curriculum1.subject_code = jsonObject.getString("subjectId")

                          var arrayChildren = ArrayList<Leaderboard_Final_curriculum>()
                        val jsonArray2 = jsonObject.getJSONArray("chapter_scores")
                        for (j in 0 until jsonArray2.length()) {
                            val jsonObject2 = jsonArray2.getJSONObject(j)
                            val final_curriculum2 = Leaderboard_Final_curriculum()

                            final_curriculum2.chapterTitle = jsonObject2.getString("ChapterTitle")
                            final_curriculum2.user_id = jsonObject2.getString("userId")
                            final_curriculum2.name = jsonObject2.getString("name")
                            final_curriculum2.email = jsonObject2.getString("email")
                            final_curriculum2.board_id = jsonObject2.getString("boardId")
                            final_curriculum2.class_id = jsonObject2.getString("classId")
                            final_curriculum2.mp_boardclasssubjectId = jsonObject2.getString("mp_boardclasssubjectId")
                            final_curriculum2.chapterTitle = jsonObject2.getString("ChapterTitle")
                            final_curriculum2.chapterId = jsonObject2.getString("chapterId")
                            final_curriculum2.subject_name = jsonObject2.getString("subjectName")
                            final_curriculum2.topic_id = jsonObject2.getString("topicId")
                            final_curriculum2.image_name = jsonObject2.getString("imageName")
                            final_curriculum2.username = jsonObject2.getString("username")
                            final_curriculum2.totalScore = jsonObject2.getString("totalScore")
                            final_curriculum2.totalQuestions = jsonObject2.getString("totalQuestions")
                            final_curriculum2.attemptedQuestions = jsonObject2.getString("attemptedQuestions")
                            final_curriculum2.remark = jsonObject2.getString("remark")

//                            if(jsonObject.getString("subjectName").equals(jsonObject2.getString("subjectName")))
//                            {
                                arrayChildren.add(final_curriculum2)
//                            }

                        }

                        final_curriculum1.final_curriculumArrayList_details = arrayChildren
                        arrayParents.add(final_curriculum1)

                    }
                   // Log.e("ME","final parent list : "+arrayParents.size  + "child list : "+arrayChildren.size)
                    mExpandableList!!.setAdapter(MyCustomAdapter(this@Main_ExpandList, arrayParents))

                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(status: String) {
                if (status.contentEquals(ConstantClass.ERRORMSG)) {
                    CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                } else {
                    CustomAlert.show(this@Main_ExpandList, this@Main_ExpandList.getString(R.string.failed_to_fetch))

                }
            }

        })

    }
}
