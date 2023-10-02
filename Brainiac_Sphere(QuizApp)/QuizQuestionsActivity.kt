package com.example.braniacsphere

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import java.util.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionsList: ArrayList<Question>?=null

    private var mSelectedOptionPosition:Int = 0

    private var mUserName: String? =null

    private var mCorrectAnswers: Int = 0

    private var progressbar: ProgressBar?=null
    private var tvProgress:TextView?= null
    private var tvQuestion:TextView?= null
    private var tvImage:ImageView?= null

    private var tvOption1:TextView?=null
    private var tvOption2:TextView?=null
    private var tvOption3:TextView?=null
    private var tvOption4:TextView?=null

    private var buttonSubmit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progressbar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        tvImage=findViewById(R.id.tv_image)

        tvOption1=findViewById(R.id.tv_option1)
        tvOption2=findViewById(R.id.tv_option2)
        tvOption3=findViewById(R.id.tv_option3)
        tvOption4=findViewById(R.id.tv_option4)
        buttonSubmit=findViewById(R.id.buttonSubmit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)

        mQuestionsList=Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {

        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()

        if(mCurrentPosition==mQuestionsList!!.size){
            buttonSubmit?.text="FINISH"
        }
        else{
            buttonSubmit?.text="SUBMIT"
        }

        tvImage?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressbar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4


    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                tvOption1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option2 -> {
                tvOption2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option3 -> {
                tvOption3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option4 -> {
                tvOption4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.buttonSubmit ->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,Result_Screen::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++  //for correct answers
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        buttonSubmit?.text="FINISH"
                    }
                    else{
                        buttonSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 -> {
                tvOption1?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                tvOption2?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                tvOption3?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                tvOption4?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#fb8500"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }


    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(1,it)
        }
        tvOption3?.let{
            options.add(2,it)
        }
        tvOption4?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#fefae0"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.selected_option_border_bg
            )
        }
    }

}