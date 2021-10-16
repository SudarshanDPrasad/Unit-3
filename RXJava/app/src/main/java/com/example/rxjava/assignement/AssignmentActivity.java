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
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
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
//        nameDisplayonfilter();
//        CreateDisplay();


        StudentResponse studentResponse = new StudentResponse(1,getStudentslist());
        Observable<Students> observable = Observable.just(studentResponse).flatMap(new Function<StudentResponse, ObservableSource<Students>>() {
            @Override
            public ObservableSource<Students> apply(StudentResponse studentResponse) throws Throwable {

                List<Students> studentsList = studentResponse.getStudents();
                return Observable.fromIterable(studentsList).subscribeOn(Schedulers.io());
            }
        }).filter(new Predicate<Students>() {
            @Override
            public boolean test(Students students) throws Throwable {
                return students.getMarsks()>70;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<Students> observer = new Observer<Students>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Students students) {

                String data = textView.getText().toString() + students.getId();
                textView.setText(data+"\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);
    }

    private List<Students> getStudentslist(){
        List<Students> studentsList = new ArrayList<>();

        studentsList.add(new Students(12,120));
        studentsList.add(new Students(13,125));
        studentsList.add(new Students(15,60));
        studentsList.add(new Students(16,69));
        return studentsList;
    }
    private void CreateDisplay() {
        Observable<StudentModel> observable = Observable.create(new ObservableOnSubscribe<StudentModel>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<StudentModel> emitter) throws Throwable {

                StudentModel studentModel = new StudentModel(12,"sudarshan d prasad");
                if(!emitter.isDisposed()){
                    emitter.onNext(studentModel);
                }
            }
        }).map(new Function<StudentModel, StudentModel>() {
            @Override
            public StudentModel apply(StudentModel studentModel) throws Throwable {
                studentModel.setStudentage(27);
                return studentModel;
            }
        });

        Observer<StudentModel> observer = new Observer<StudentModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull StudentModel studentModel) {

                String data = textView.getText().toString() + studentModel.studentage;
                textView.setText(data);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

    private void nameDisplayonfilter() {

        StudentModel studentModel = new StudentModel(0, "sudarshan");

        Observable<StudentModel> stringObservable = Observable.fromIterable(getStudentModel())
                .filter(new Predicate<StudentModel>() {
                    @Override
                    public boolean test(StudentModel studentModel) throws Throwable {
                        SystemClock.sleep(1000);
                        return studentModel.studentname.length()>6;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()); // this is to delay items and run in the background thred

        Observer<StudentModel> stringObserver = new Observer<StudentModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull StudentModel studentModel) {

                if (studentModel.studentname.length() > 6) {
                    Log.d("Sudarshan", studentModel.studentname);
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
                Log.d("Sudarshan", integer.toString());
                String data = textView.getText().toString() + integer;
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("Sudarshan", "completed");
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
                Log.d("Sudarshan", s);
                String data = textView.getText().toString() + s;
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("Sudarshan", "completed");
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
                Log.d("Sudarshan", s);
                textView.setText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("Sudarshan", "Completed");

            }
        };
        stringObservable.subscribe(stringObserver);
    }
}