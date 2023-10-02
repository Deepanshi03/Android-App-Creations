package com.example.braniacsphere

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String ="total questions"
    const val CORRECT_ANSWERS: String ="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val ques1=Question(1,
            "Which Country does this Flag belong to?",
            R.drawable.argentina,
            "Argentina",
            "Australia",
            "Austria",
            "Armenia",
            1
        )
        questionsList.add(ques1)

        val ques2=Question(2,
            "Which Country does this Flag belong to?",
            R.drawable.niger,
            "India",
            "Niger",
            "Norway",
            "Kuwait",
            2
        )
        questionsList.add(ques2)

        val ques3=Question(3,
            "Which Country does this Flag belong to?",
            R.drawable.poland,
            "Canada",
            "Japan",
            "Poland",
            "Egypt",
            3
        )
        questionsList.add(ques3)

        val ques4=Question(4,
            "Which Country does this Flag belong to?",
            R.drawable.nigeria,
            "Ireland",
            "Nigeria",
            "Afghanistan",
            "Belgium",
            2
        )
        questionsList.add(ques4)

        val ques5=Question(5,
            "Which Country does this Flag belong to?",
            R.drawable.france,
            "France",
            "Nigeria",
            "Poland",
            "Belgium",
            1
        )
        questionsList.add(ques5)

        val ques6=Question(6,
            "Which Country does this Flag belong to?",
            R.drawable.ghana,
            "Afghanistan",
            "India",
            "Niger",
            "Ghana",
            4
        )
        questionsList.add(ques6)

        val ques7=Question(7,
            "Which Country does this Flag belong to?",
            R.drawable.ireland,
            "India",
            "Nigeria",
            "Ireland",
            "France",
            3
        )
        questionsList.add(ques7)

        val ques8=Question(8,
            "Which Country does this Flag belong to?",
            R.drawable.yemen,
            "France",
            "Yemen",
            "Thailand",
            "Belgium",
            2
        )
        questionsList.add(ques8)

        val ques9=Question(9,
            "Which Country does this Flag belong to?",
            R.drawable.turkey,
            "Pakistan",
            "Switzerland",
            "Japan",
            "Turkey",
            4
        )
        questionsList.add(ques9)

        val ques10=Question(10,
            "Which Country does this Flag belong to?",
            R.drawable.thailand,
            "Thailand",
            "Denmark",
            "France",
            "Panama",
            1
        )
        questionsList.add(ques10)

        return questionsList
    }
}