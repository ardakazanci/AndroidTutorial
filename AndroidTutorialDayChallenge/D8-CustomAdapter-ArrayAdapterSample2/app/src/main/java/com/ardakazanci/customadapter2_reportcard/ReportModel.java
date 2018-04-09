package com.ardakazanci.customadapter2_reportcard;

public class ReportModel {

    private String studentLesson;
    private String studentName;
    private int studentNote;

    public ReportModel(String studentLesson, String studentName, int studentNote) {
        this.studentLesson = studentLesson;
        this.studentName = studentName;
        this.studentNote = studentNote;
    }

    public String getStudentLesson() {
        return studentLesson;
    }

    public void setStudentLesson(String studentLesson) {
        this.studentLesson = studentLesson;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentNote() {
        return studentNote;
    }

    public void setStudentNote(int studentNote) {
        this.studentNote = studentNote;
    }

    @Override
    public String toString() {
        return "Öğrenci Adı : " + this.studentName
                + " Ders Adı : " + this.studentLesson
                + " Ders Notu :  " + this.studentNote;
    }
}
