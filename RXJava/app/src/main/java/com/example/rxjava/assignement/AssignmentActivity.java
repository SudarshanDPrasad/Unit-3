package com.example.rxjava.assignement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import com.example.rxjava.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AssignmentActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        textView = findViewById(R.id.assignemnttext);

//        nameonjust();
//        nameonfromarray();
//        valuerange();

        StudentModel studentModel = new StudentModel(0, "sudarshan");

        Observable<StudentModel> stringObservable = Observable.fromIterable(getStudentModel())
                .filter(new Predicate<StudentModel>() {
                    @Override
                    public boolean test(StudentModel studentModel) throws Throwable {
                        SystemClock.sleep(1000);
                        return studentModel.iscompleted();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()); // this is to delay items and run in the background thred

        Observer<StudentModel> stringObserver = new Observer<StudentModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull StudentModel studentModel) {

                if (studentModel.studentname.length() > 6) {
                    String data = textView.getText().toString() + studentModel.studentname;
                    textView.setText(data + "\n");
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        stringObservable.subscribe(stringObserver);
    }

    private List<StudentModel> getStudentModel() {
        List<StudentModel> studentModels = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            studentModels.add(new StudentModel(i, "sudarshan"));
            studentModels.add(new StudentModel(i, "lloydDscosta"));
            studentModels.add(new StudentModel(i, "Masai"));
            studentModels.add(new StudentModel(i, "Adityacheke"));
            studentModels.add(new StudentModel(i, "skand"));
            studentModels.add(new StudentModel(i, "Name"));

        }
        return studentModels;
    }

    private void valuerange() {
        Observable<Integer> integerObservable = Observable.range(20, 21);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {

                String data = textView.getText().toString() + integer;
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        integerObservable.subscribe(integerObserver);
    }

    private void nameonfromarray() {

        String[] arr = {"lloyd", "aditya", "sudarshan", "MasaiSchool", "students"};

        Observable<String> stringobservable = Observable.fromArray(arr);


        Observer<String> stringobserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                String data = textView.getText().toString() + s;
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        stringobservable.subscribe(stringobserver);
    }

    private void nameonjust() {
        Observable<String> stringObservable = Observable.just("Sudarshan");

        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Sudarshan", "onSubscribe");

            }

            @Override
            public void onNext(@NonNull String s) {
                textView.setText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        stringObservable.subscribe(stringObserver);
    }
}