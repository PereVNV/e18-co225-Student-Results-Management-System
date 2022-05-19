package com.sharetechidea.srms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseServices {

    public static void displayCourses(CourseList courses, Courses_RecycleViewAdapter adapter, ProgressDialog progressDialog,String sem){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("departments").document("co").collection(sem)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            System.out.println("Success");


if(!task.getResult().isEmpty()){



                            for (QueryDocumentSnapshot doc : task.getResult()) {

                                if(!doc.exists()){
                                    System.out.println("error");

                                }




                                System.out.println(doc);
                                Course course = new Course();
                                course.setCourseId(doc.getId());

                                if (doc.get("name") != null) {
                                    course.setCourseName(doc.getString("name"));
                                }

                                if (doc.get("credits") != null) {
                                    course.setCourseCredits(Math.toIntExact(doc.getLong("credits")));
                                }

                                courses.courses.add(course);}
                                adapter.notifyDataSetChanged();}
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }




                            System.out.println(courses.courses);
                        } else {
                            System.out.println("error appeared");
                        }
                    }

                }
                );}



    public static void displayCourses(CourseList courses, FindGPA_RecycleViewAdapter adapter, ProgressDialog progressDialog,String sem){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("students").document("e18373").collection("marks").document(sem);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {

                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    System.out.println("beast");
                     Map<String, Object> map =  snapshot.getData();
                    System.out.println(map.values());



                    for (Map.Entry<String, Object> entry : map.entrySet()) {

                        System.out.println(entry.getValue());
//                        if(entry.getValue().equals(null)){
//
//                            courses.idgrade.put(entry.getKey(), "");
//                        }else{
//
                            courses.idgrade.put(entry.getKey(), entry.getValue().toString());
//                        }



                    }

                    System.out.println(courses.idgrade);
                    db.collection("departments").document("co").collection(sem)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                       @Override
                                                       public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                           if (task.isSuccessful()) {
                                                               System.out.println("Success");


                                                               if(!task.getResult().isEmpty()){



                                                                   for (QueryDocumentSnapshot doc : task.getResult()) {

                                                                       if(!doc.exists()){
                                                                           System.out.println("error");

                                                                       }




                                                                       System.out.println(doc);
                                                                       Course course = new Course();
                                                                       course.setCourseId(doc.getId());
                                                                       courses.grades.put(course,"");

                                                                       if (doc.get("name") != null) {
                                                                           course.setCourseName(doc.getString("name"));

                                                                       }

                                                                       if (doc.get("credits") != null) {
                                                                           course.setCourseCredits(Math.toIntExact(doc.getLong("credits")));
                                                                       }

                                                                       courses.courses.add(course);
                                                                   }
                                                                   courses.isInitial=false;

                                                                   adapter.notifyDataSetChanged();}
                                                               if (progressDialog.isShowing()) {
                                                                   progressDialog.dismiss();
                                                               }




                                                               System.out.println(courses.courses);
                                                           } else {
                                                               System.out.println("error appeared");
                                                           }
                                                       }

                                                   }
                            );



                } else {

                    db.collection("departments").document("co").collection(sem)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                       @Override
                                                       public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                           if (task.isSuccessful()) {
                                                               System.out.println("Success");


                                                               if(!task.getResult().isEmpty()){



                                                                   for (QueryDocumentSnapshot doc : task.getResult()) {

                                                                       if(!doc.exists()){
                                                                           System.out.println("error");

                                                                       }




                                                                       System.out.println(doc);
                                                                       Course course = new Course();
                                                                       course.setCourseId(doc.getId());
                                                                       courses.grades.put(course,"");

                                                                       if (doc.get("name") != null) {
                                                                           course.setCourseName(doc.getString("name"));
                                                                       }

                                                                       if (doc.get("credits") != null) {
                                                                           course.setCourseCredits(Math.toIntExact(doc.getLong("credits")));
                                                                       }

                                                                       courses.courses.add(course);}
                                                                   adapter.notifyDataSetChanged();}
                                                               if (progressDialog.isShowing()) {
                                                                   progressDialog.dismiss();
                                                               }




                                                               System.out.println(courses.courses);
                                                           } else {
                                                               System.out.println("error appeared");
                                                           }
                                                       }

                                                   }
                            );

                }
            }
        });
}
    //add course data to firebase
    public static void writeCourseDetails(Course course,String sem){

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("name", course.getCourseName());
        user.put("credits", course.getCourseCredits());

        db.collection("departments").document("co").collection(sem)
                .document(course.getCourseId()).set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("success...");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("failure...");
                    }
                });
    }


    public static void saveCourseGrades(Map<String,String> grades,String sem){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("students").document("e18373").collection("marks")
                .document(sem).set(grades)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("success...");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("failure...");
                    }
                });

    }




}




//public class FirebaseService {
//    String selectedDepartment = editName.getText().toString();
//    String selectedSemester = editName.getText().toString();
//    String selectedCourse = editName.getText().toString();
//    List<Course> courseNameList = new ArrayList<>();

    //get course data from firebase

//    public static void readCourseDetails(List<Course>courseList){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("departments").document("co").collection("sem4")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @RequiresApi(api = Build.VERSION_CODES.N)
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//
//                            for (QueryDocumentSnapshot doc : task.getResult()) {
//                                Course course = new Course();
//                                course.setcourseId(doc.getId());
//                                if (doc.get("name") != null) {
//                                    course.setcourseName(doc.getString("name"));
//                                }
//                                if (doc.get("credits") != null) {
//                                    course.setcourseCredits(Math.toIntExact(doc.getLong("credits")));
//                                }
//                                courseList.add(course);
//                            }
//                            System.out.println(courseList);
//                        } else {
//                            System.out.println("error appeared");
//                        }
//
//                    }
//                });
//    }



//    public static void setStudentDetails(){
////        String studentName = editName.getText().toString();
////        String department = editName.getText().toString();
////        String eno = editName.getText().toString();
////        String email = editName.getText().toString()+"@eng.pdn.ac.lk";
//
//        String studentName = "Vithurshini";
//        String department = "co";
//        String eno = "E18340";
//        String email = eno.toLowerCase()+"@eng.pdn.ac.lk";
//        final boolean[] isAdmin = new boolean[1];
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        db.collection("admins").document(eno.toLowerCase()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        //System.out.println("    EXIST");
//                        isAdmin[0] = true;
//
//                    } else {
//                        isAdmin[0] = false;
//                    }
//                } else {
//
//                }
//            }
//        });
//
//        Map<String, Object> user = new HashMap<>();
//        user.put("name", studentName);
//        user.put("dep_id", department);
//        user.put("email", email);
//        user.put("isAdmin",isAdmin[0]);
//
//        db.collection("students").document(eno).set(user)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        System.out.println("success...");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        System.out.println("failure...");
//                    }
//                });
//    }
//}






